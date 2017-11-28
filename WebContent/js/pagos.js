$(document).ready(function() {

  var Base64={_keyStr:"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=",encode:function(e){var t="";var n,r,i,s,o,u,a;var f=0;e=Base64._utf8_encode(e);while(f<e.length){n=e.charCodeAt(f++);r=e.charCodeAt(f++);i=e.charCodeAt(f++);s=n>>2;o=(n&3)<<4|r>>4;u=(r&15)<<2|i>>6;a=i&63;if(isNaN(r)){u=a=64}else if(isNaN(i)){a=64}t=t+this._keyStr.charAt(s)+this._keyStr.charAt(o)+this._keyStr.charAt(u)+this._keyStr.charAt(a)}return t},decode:function(e){var t="";var n,r,i;var s,o,u,a;var f=0;e=e.replace(/[^A-Za-z0-9+/=]/g,"");while(f<e.length){s=this._keyStr.indexOf(e.charAt(f++));o=this._keyStr.indexOf(e.charAt(f++));u=this._keyStr.indexOf(e.charAt(f++));a=this._keyStr.indexOf(e.charAt(f++));n=s<<2|o>>4;r=(o&15)<<4|u>>2;i=(u&3)<<6|a;t=t+String.fromCharCode(n);if(u!=64){t=t+String.fromCharCode(r)}if(a!=64){t=t+String.fromCharCode(i)}}t=Base64._utf8_decode(t);return t},_utf8_encode:function(e){e=e.replace(/rn/g,"n");var t="";for(var n=0;n<e.length;n++){var r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r)}else if(r>127&&r<2048){t+=String.fromCharCode(r>>6|192);t+=String.fromCharCode(r&63|128)}else{t+=String.fromCharCode(r>>12|224);t+=String.fromCharCode(r>>6&63|128);t+=String.fromCharCode(r&63|128)}}return t},_utf8_decode:function(e){var t="";var n=0;var r=c1=c2=0;while(n<e.length){r=e.charCodeAt(n);if(r<128){t+=String.fromCharCode(r);n++}else if(r>191&&r<224){c2=e.charCodeAt(n+1);t+=String.fromCharCode((r&31)<<6|c2&63);n+=2}else{c2=e.charCodeAt(n+1);c3=e.charCodeAt(n+2);t+=String.fromCharCode((r&15)<<12|(c2&63)<<6|c3&63);n+=3}}return t}};

  var getFicha = location.search.substring(1,location.search.length);
  $('#numFicha').val(Base64.decode(getFicha));

  // ---------------------------------------------------------
  //---------------PASARELA DE PAGO---------------------------
  // Culqi.publicKey = 'pk_test_XZ8r8Be2zGAKH52R';
  // var monto = $('#monto').text();
  // var ficha;
  //
  // Culqi.settings({
  //       title: 'Eventos Deportivos',
  //       currency: 'PEN',
  //       description: 'Derecho de Inscripcion',
  //       amount: monto
  //     });
  //
  // $('#btnPagar').click(function(){
  //   Culqi.open();
  //   e.preventDefault();
  // })
  //
  // function culqi() {
  //
  //   if(Culqi.token) { // ¡Token creado exitosamente!
  //       // Get the token ID:
  //       var token = Culqi.token.id;
  //       alert('Se ha creado un token:'.token);
  //
  //   }else{ // ¡Hubo algún problema!
  //       // Mostramos JSON de objeto error en consola
  //       console.log(Culqi.error);
  //       alert(Culqi.error.mensaje);
  //   }
  // };
  //------------------------------------------------------------

  //---------CONSULTAR PAGO---------------------------------
  $('#btnconsulta').click(function(){
    var ficha = $('#numFicha').val().trim();
    $.ajax({
    	type: "POST",
        url: "cargarPago",
        data: "ficha="+ficha,
        success: function(data){
          console.log(data.monto);
          var monto = data.monto;
          $('#monto').html('S/. '+monto);
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

  //realizar pago y obtener correo
  $('.btn-pagar').click(function(){
    console.log("Captuta boton");
  })







});
