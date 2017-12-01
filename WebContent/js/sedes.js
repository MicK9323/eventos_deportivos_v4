$(document).ready(function(){

var opcion = $('#opcion').val();
var validacion;

if(opcion == "registrar"){
  $('#btnNuevo').hide();
  $('#btnGuardar').text('Guardar');
}else{
  $('#btnNuevo').show();
  $('#btnGuardar').text('Actualizar');
}

//-------------------VALIDAR NOMBRE DE SEDE----------------
var gnomSede = $('#nombre').val().trim().toUpperCase();
$('#nombre').focusout(function(){
  var nombre = $(this).val().trim().toUpperCase();
  validarNombre(nombre);
});


//Maximo valor del input
$("#nombre").attr("maxlength", 30);
$("#dirSede").attr("maxlength", 35);
$("#telf").attr("maxlength", 10);

//Solo Números
$('#telf').on('input', function () { 
	    this.value = this.value.replace(/[^0-9]/g,'');
	});

//
function validarNombre(nombre){
  var html = "";
  if( nombre != '' ){
    if( nombre != gnomSede ){
        gnomSede = nombre;
        $.ajax({
        type: "GET",
        url: "nombreSede",
        data: "sede.nomSede="+gnomSede,
        success:function(result){
          var mensaje = result.mensaje;
          if(mensaje == 'OK'){
            html += '<label class="label label-success">'+'Nombre '+gnomSede+' Valido'+'</label>';
            $('#alerta').children('label').replaceWith(html);
            alertify.success('Nombre '+gnomSede+' es Valido');
          }
          else{
            html += '<label class="label label-danger">'+mensaje+'</label>';
            $('#alerta').children('label').replaceWith(html);
            alertify.error(mensaje);
          }
        },
        error: function(result){
          var mensaje = result.msg;
          alertify.error(mensaje);
        }
      });
    }
  }else{
    html += '<label class="label label-warning">Campo Requerido</label>';
    $('#alerta').children('label').replaceWith(html);
    alertify.warning("No ha ingresado ningún nombre de sede");
  }
}
//-----------------------------------------------------------

//-------------------------------------------------
//VALIDADORES DE CAJAS DE TEXTO
$('#formSede').bootstrapValidator({
  feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
  },
  submitButtons:'#btnGuardar',
  fields:{
    nombre:{
    	selector:'#nombre',
      validators:{
       regexp: {
           // regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s][1-9\\-\\]+$/i,
           regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s]+$/i,
           message: 'Ingrese solo letras'
       },
        stringLength:{
        	min: 5,
        	message: 'Ingrese mínimo 5 carácteres'
        },
        notEmpty:{
          message: 'Requerido'
        }
      }
    },
    direccion:{
      selector: '#dirSede',
      validators:{
        // regexp: {
        //     regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s][1-9\\-\\]+$/i,
        //     regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s]+$/i,
        //     message: 'Ingrese solo letras'
        // },
         stringLength:{
         	min: 10,
         	message: 'Ingrese mínimo 5 carácteres'
         },
         notEmpty:{
           message: 'Requerido'
         }
      }
    },
    telefono:{
      selector: '#telf',
      validators:{
        regexp: {
            // regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s][1-9\\-\\]+$/i,
            regexp: /^[0-9\s]+$/i,
            message: 'Ingrese solo numeros'
        },
         stringLength:{
         	min: 7,
          max: 10,
         	message: '7 Caracteres mínimo y 10 máximo'
         },
         notEmpty:{
           message: 'Requerido'
         }
      }
    }
  }
});

  //CREACION DE LA ALERTA
  if(!alertify.miAlerta){
    //define a new dialog
    alertify.dialog('miAlerta',function(){
      return{
        main:function(message){
          this.message = message;
        },
        setup:function(){
            return {
              buttons:[{text: "OK", key:27/*Esc*/}],
              focus: { element:0 }
            };
        },
        prepare:function(){
          this.setContent(this.message);
        }
    }});
  }
  //---------------------------------------------
  //FUNCION PARA BUSCAR Sedes DE LA TABLA
  (function ($) {
      $('#buscador').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.buscar .cuadro').hide();
        $('.buscar .cuadro').filter(function () {
            return rex.test($(this).text());
        }).show();
      })
  }(jQuery));

  //--------------------------------------------
  //FUNCION PARA VALIDAR CAMPOS
  function validarCampos(nom,dir,telf){
	    var msg = 'ok';
	    if(nom == ""){
	      msg = "Ingrese Nombre de Sede";
	    }
	    if(dir == ""){
	      msg = "Ingrese una dirección para la sede";
	    }
	    if(telf == ""){
	      msg = "Ingrese un teléfono para la sede";
	    }
	    return msg;
  }
  //-------------------------------------------------------
  //METODOS QUE SE RIGEN PARA GRABAR O ACTUALIZAR UNA SEDE
  $('#btnGuardar').click(function(){
    var codigo = $('#codigo').val();
  	var nombre = $('#nombre').val().trim().toUpperCase();
  	var direccion = $('#dirSede').val().trim().toUpperCase();
  	var telf = $('#telf').val().trim();
    validacion = validarCampos(nombre,direccion,telf);
    if(opcion == "registrar"){//MODO DE INSERTAR
      if(validacion == 'ok'){
        alertify.confirm('Desea grabar esta sede?',
        function(){//SI PULSA OK
          $.ajax({
            type: "POST",
            url:"regSede",
            data:"sede.nomSede="+nombre+
                  "&sede.direccion="+direccion+
                  "&sede.telf="+telf,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Sede '+nombre+' Registrada!');
                setTimeout(function(){
                  $(location).attr("href","listaSedes");
                },1000);
              }else{
                alertify.error(msg);
              }
            },
            error:function(data){
              var msg = data.mensaje;
              alertify.error(msg);
            }
          });
        },function(){//SI PULSA CANCELAR
          alertify.error('Registro Cancelado!');
        });
      }else{
        alertify.error(validacion);
      }
    }else{//MODO DE ACTUALIZACION
      if(validacion == 'ok'){
        alertify.confirm('Desea actualizar esta sede?',
        function(){//SI PULSA OK
          $.ajax({
            type: "POST",
            url:"uptSede",
            data:"sede.nomSede="+nombre+
                  "&sede.direccion="+direccion+
                  "&sede.telf="+telf+
                  "&sede.codSede="+codigo,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Sede '+codigo+' Actualizada!');
                setTimeout(function(){
                  $(location).attr("href","listaSedes");
                },1000);
              }else{
                alertify.error(msg);
              }
            },
            error:function(data){
              var msg = data.mensaje;
              alertify.error(msg);
            }
          });
        },function(){//SI PULSA CANCELAR
          alertify.error('Actualización Cancelada');
        });
      }else{
        alertify.error(validacion);
      }
    }
  });

  //----------------------------------------------
  //BOTON CANCELAR
  $('#btnReset').click(function(){
	  $(location).attr("href","listaSedes");
  });

  //----------------------------------------------------------
  //ELIMINAR SEDE
  $('.remove').click(function(){
    var codigo = $(this).parent().parent().find('.codigo').text();
    alertify.confirm('Desea eliminar esta sede?',
    function(){//SI PULSA OK
      $.ajax({
        type:"POST",
        url:'deleteSede',
        data:"sede.codSede="+codigo,
        success:function(data){
          var msg = data.mensaje;
          if(msg == 'ok'){
            alertify.success('Sede '+codigo+' eliminada!');
            setTimeout(function(){
              $(location).attr("href","listaSedes");
            },1000);
          }else{
        	 alertify.error("Sede no puede ser Eliminada,    Se encuentra en uso");
          }
        },
        error:function(data){
          var msg = data.mensaje;
          alertify.error("Error al Eliminar Sede");
        }
      });
    },function(){//SI PULSA CANCELAR
      alertify.error('Eliminacion Cancelada!');
    })
  });

});
