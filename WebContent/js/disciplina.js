$(document).ready(function(){

var opcion = $('#opcion').val();
var validacion;

if(opcion == "registrar"){
//  $('#btnNuevo').hide();
  $('#btnGuardar').text('Guardar');
  $('#btnReset').text('Limpiar');
}else{
//  $('#btnNuevo').show();
  $('#btnGuardar').text('Actualizar');
  $('#btnReset').text('Cancelar');
}
//----------------------------------------------------
//VALIDACIONES DE CAJAS DE TEXTO
$('#formDisciplina').bootstrapValidator({
  feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
  },
  fields:{
    descripcion:{
    	selector:'#descripcion',
      validators:{
        regexp: {
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
    }
  }
});

//-------------------VALIDAR NOMBRE DE DISCIPLINA----------------
var gnomDisciplina = $('#descripcion').val().trim().toUpperCase();
$('#descripcion').focusout(function(){
  var nombre = $(this).val().trim().toUpperCase();
  validarNombre(nombre);
});

function validarNombre(nombre){
  var html = "";
  if( nombre != '' ){
    if( nombre != gnomDisciplina ){
        gnomDisciplina = nombre;
        $.ajax({
        type: "GET",
        url: "nombreDisciplina",
        data: "disciplina.descripcion="+gnomDisciplina,
        success:function(result){
          var mensaje = result.mensaje;
          if(mensaje == 'OK'){
            html += '<label class="label label-success">'+'Nombre '+gnomDisciplina+' Valido'+'</label>';
            $('#alerta').children('label').replaceWith(html);
            alertify.success('Nombre '+gnomDisciplina+' Valido');
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
    alertify.warning("No ha ingresado ningun nombre de disciplina");
  }
}

//-----------------------------------------------------------

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
  //--------------------------------------------------
  //FUNCION PARA BUSCAR COINCIDENCIAS DENTRO DE LA TABLA
  (function ($) {
      $('#buscador').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.buscar .cuadro').hide();
        $('.buscar .cuadro').filter(function () {
            return rex.test($(this).text());
        }).show();
      })
  }(jQuery));
  //-----------------------------------------------------
  //FUNCION PARA VALIDAR CAMPOS
  function validarCampos(a){
    var msg = "ok";
    if(a == ""){
      msg = "Ingrese Descripcion";
    }
    return msg;
  }
  //------------------------------------------------------
  //METODOS QUE RIGEN EL REGISTRO Y ACTUALIZACION DE CATEGORIAS
  $('#btnGuardar').click(function(){
    var codigo = $('#codigo').val();
  	var descripcion = $('#descripcion').val().toUpperCase();
    validacion = validarCampos(descripcion);
    if(opcion == "registrar"){//MODO DE INSERTAR
      if(validacion == 'ok'){
        alertify.confirm('Desea grabar esta disciplina?',
        function(){//SI PULSA OK
          $.ajax({
            type: "POST",
            url: "regDisciplina",
            data: "disciplina.descripcion="+descripcion,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Disciplina '+descripcion+' Registrada!');
                setTimeout(function(){
                  $(location).attr("href","listadoDisciplina");
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
        alertify.confirm('Desea actualizar esta categoria?',
        function(){//SI PULSA OK
          $.ajax({
            type: "POST",
            url: "uptDisciplina",
            data: "disciplina.descripcion="+descripcion+
                  "&disciplina.codigo="+codigo,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Disciplina '+codigo+' Actualizada!');
                setTimeout(function(){
                  $(location).attr("href","listadoDisciplina");
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
          alertify.error('Actualizacion Cancelada!');
        });
      }else{
        alertify.error(validacion);
      }
    }
  });
  //---------------------------------------------------------
  //BOTON RESET
  $('#btnReset').click(function(){
	  $(location).attr("href","listadoDisciplina");
  });
  //--------------------------------------------------------
  //ELIMINAR CATEGORIAS
  $('.remove').click(function(){
    var codigo = $(this).parent().parent().find('.codigo').text();
    alertify.confirm('Desea eliminar esta disciplina?',
    function(){
      $.ajax({
        type:"POST",
        url:'delDisciplina',
        data:"disciplina.codigo="+codigo,
        success:function(data){
          var msg = data.mensaje;
          if(msg == 'ok'){
            alertify.success('Disciplina '+codigo+' eliminada');
            setTimeout(function(){
              $(location).attr("href","listadoDisciplina");
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
    },function(){
      alertify.error('Eliminación Cancelada!');
    })
  });

});
