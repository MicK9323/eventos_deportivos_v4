$(document).ready(function() {

  var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9+/=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/rn/g,"n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}};

  var getFicha = location.search.substring(1,location.search.length);
  $('#numFicha').val(Base64.decode(getFicha));
  var gficha;
  var gmonto;
  //---------CONSULTAR PAGO---------------------------------
  $('#btnconsulta').click(function(){
    var ficha = $('#numFicha').val().trim();
    gficha = ficha;
    $.ajax({
    	type: "POST",
        url: "cargarPago",
        data: "ficha="+ficha,
        success: function(data){
          console.log(data.monto);
          gmonto = data.monto;
          $('#monto').html('S/. '+gmonto);
          //datos de la ficha
          var numFicha = data.datos.cod_ficha;
          var fecInscripcion = data.datos.fec_inscripcion;
          var evento = data.datos.desc_evento;
          var modalidad = data.datos.desc_modalidad;
          var inicio = data.datos.fec_inicio;
          var cierre = data.datos.fec_fin;
          var equipo = data.datos.nom_equipo;
          var codEquipo = data.datos.cod_equipo;
          var delegado = data.datos.delegado;
          $('#codFicha').val(numFicha);
          $('#fecInscripcion').val(fecInscripcion);
          $('#nomEvento').val(evento);
          $('#nomModalidad').val(modalidad);
          $('#fecInicio').val(inicio);
          $('#fecCierre').val(cierre);
          $('#nomEquipo').val(equipo);
          $('#codEquipo').val(codEquipo);
          $('#nomDelegado').val(delegado);
        },
        error: function(data){
          alertify.error(data);
        }
      })
  });

  $('#btnPagar').click(function(){
	  var num = $('#numFicha');
	  var monto = $('#monto').text();
    if( num == "" || monto == "" ){
      alertify.warning("Ingrese los datos de ficha y monto para continuar");
    }else{
      $('#pago').modal("show");
    }
  })


  //ventana de pago
  var $form = $('#payment-form');
//  $form.find('.subscribe').on('click', payWithStripe);

  $('#btnProcesar').click(function(){
    if( gficha == "" || gmonto == "" ){
      alertify.warning("Ingrese los datos de ficha y monto para continuar");
    }else{
      var equipo = $('#codEquipo').val().trim();
      $form.find('.subscribe').html('Validando <i class="fa fa-spinner fa-pulse"></i>').prop('disabled', true);
      $.ajax({
        type: "POST",
        url: "registrarPago",
        data: "ficha="+gficha+"&monto="+gmonto+"&codEquipo="+equipo,
        success: function(data){
          if(data.mensaje == "ok"){
            $form.find('.subscribe').html('Pago exitoso! <i class="fa fa-check"></i>');
            if(data.status == "finalizado"){
              $form.find('.subscribe').html('Proceso terminado <i class="fa fa-check"></i>');
            }
          }else{
            alertify.error(data.mensaje);
          }
        },
        error: function(data){

        }
      });
    }
  })

  /* Fancy restrictive input formatting via jQuery.payment library*/
  $('input[name=cardNumber]').payment('formatCardNumber');
  $('input[name=cardCVC]').payment('formatCardCVC');
  $('input[name=cardExpiry').payment('formatCardExpiry');

  /* Form validation using Stripe client-side validation helpers */
  jQuery.validator.addMethod("cardNumber", function(value, element) {
      return this.optional(element) || Stripe.card.validateCardNumber(value);
  }, "Número de tarjeta inválido");

  jQuery.validator.addMethod("cardExpiry", function(value, element) {
      /* Parsing month/year uses jQuery.payment library */
      value = $.payment.cardExpiryVal(value);
      return this.optional(element) || Stripe.card.validateExpiry(value.month, value.year);
  }, "Fecha incorrecta");

  jQuery.validator.addMethod("cardCVC", function(value, element) {
      return this.optional(element) || Stripe.card.validateCVC(value);
  }, "CVV Inválido");

  validator = $form.validate({
      rules: {
          cardNumber: {
              required: true,
              cardNumber: true
          },
          cardExpiry: {
              required: true,
              cardExpiry: true
          },
          cardCVC: {
              required: true,
              cardCVC: true
          }
      },
      highlight: function(element) {
          $(element).closest('.form-control').removeClass('success').addClass('error');
      },
      unhighlight: function(element) {
          $(element).closest('.form-control').removeClass('error').addClass('success');
      },
      errorPlacement: function(error, element) {
          $(element).closest('.form-group').append(error);
      }
  });

  paymentFormReady = function() {
      if ($form.find('[name=cardNumber]').hasClass("success") &&
          $form.find('[name=cardExpiry]').hasClass("success") &&
          $form.find('[name=cardCVC]').val().length > 1) {
          return true;
      } else {
          return false;
      }
  }

  $form.find('.subscribe').prop('disabled', true);
  var readyInterval = setInterval(function() {
      if (paymentFormReady()) {
          $form.find('.subscribe').prop('disabled', false);
          clearInterval(readyInterval);
      }
  }, 250);




});
