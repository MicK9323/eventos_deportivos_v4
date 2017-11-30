$(document).ready(function(){

var opcion = $('#opcion').val();
var validacion;
$("#minimo").attr("maxlength", 2);
$("#maximo").attr("maxlength", 2);
if(opcion == "registrar"){
  $('#btnNuevo').hide();
  $('#btnGuardar').text('Guardar');
}else{
  $('#btnNuevo').show();
  $('#btnGuardar').text('Actualizar');
}

//-------------------VALIDAR NOMBRE DE CATEGORIA----------------
var gnomCategoria = $('#descripcion').val().trim().toUpperCase();
$('#descripcion').focusout(function(){
  var nombre = $(this).val().trim().toUpperCase();
  validarNombre(nombre);
});

function validarNombre(nombre){
  var html = "";
  if( nombre != '' ){
    if( nombre != gnomCategoria ){
        gnomCategoria = nombre;
        $.ajax({
        type: "GET",
        url: "nombreCategoria",
        data: "categoria.descripcion="+gnomCategoria,
        success:function(result){
          var mensaje = result.mensaje;
          if(mensaje == 'OK'){
            html += '<label class="label label-success">'+'Nombre '+gnomCategoria+' Valido'+'</label>';
            $('#alerta').children('label').replaceWith(html);
            alertify.success('Nombre '+gnomCategoria+' es Valido');
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
    alertify.warning("No ha ingresado ningún nombre de categoría");
  }
}
//-----------------------------------------------------------

//-------------------------------------------------
//VALIDADORES DE CAJAS DE TEXTO
$('#formCategoria').bootstrapValidator({
  feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
  },
  submitButtons:'#btnGuardar',
  fields:{
    descripcion:{
    	selector:'#descripcion',
      validators:{
//        regexp: {
//        	regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s][1-9\\-\\]+$/i,
//            message: 'Ingrese solo letras'
//        },
        stringLength:{
        	min: 5,
        	message: 'Ingrese mínimo 5 carácteres'
        },
        notEmpty:{
          message: 'Requerido'
        }
      }
    },
    minimo:{
      selector: '#minimo',
      validators:{
        integer:{
          message: 'Este campo debe contener un valor numérico'
        },
        between:{
        	min: 5,
        	max: 50,
        	message: 'Edad debe estar entre 5 y 50 años'
        },
        notEmpty:{
          message: 'Requerido'
        }
      }
    },
    maximo:{
      selector: '#maximo',
      validators:{
        integer:{
          message: 'Este campo debe contener un valor numérico'
        },
        between:{
        	min: 5,
        	max: 50,
        	message: 'Edad debe estar entre 5 y 50 años'
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
  //FUNCION PARA BUSCAR CATEGORIAS DE LA TABLA
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
  function validarCampos(a,b,c){
	    var msg = 'ok';
	    var min = parseInt(b);
	    var max = parseInt(c);
	    if(a == ""){
	      msg = "Ingrese Descripcion";
	    }
	    if(b == ""){
	      msg = "Ingrese mínimo de jugadores";
	    }
	    if(c == ""){
	      msg = "Ingrese maximo de jugadores";
	    }
	    if(a == "" && b == ""  && c == ""){
	      msg = "Debe llenar los campos";
	    }
	    if(min < 5 || max < 5 || min > 50 || max > 50){
	    	msg = "Las edades permitidas deben ser mayores a 5 y menores a 50";
	    }
	    if(min > max){
	    	msg = "Parámetros de edad incorrecto";
	    }
	    return msg;
  }
  //-------------------------------------------------------
  //METODOS QUE SE RIGEN PARA GRABAR O ACTUALIZAR UNA CATEGORIA
  $('#btnGuardar').click(function(){
    var codigo = $('#codigo').val();
  	var descripcion = $('#descripcion').val().toUpperCase();
  	var minimo = $('#minimo').val();
  	var maximo = $('#maximo').val();
    validacion = validarCampos(descripcion,minimo,maximo);
    if(opcion == "registrar"){//MODO DE INSERTAR
      if(validacion == 'ok'){
        alertify.confirm('Desea grabar esta categoria?',
        function(){//SI PULSA OK
          $.ajax({
            type: "POST",
            url:"regCategoria",
            data:"categoria.descripcion="+descripcion+
                  "&categoria.edadMin="+minimo+
                  "&categoria.edadMax="+maximo,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Categoria '+descripcion+' Registrada!');
                setTimeout(function(){
                  $(location).attr("href","listaCategorias");
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
            url:"uptCategoria",
            data:"categoria.descripcion="+descripcion+
                  "&categoria.edadMin="+minimo+
                  "&categoria.edadMax="+maximo+
                  "&categoria.codigo="+codigo,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Categoria '+codigo+' Actualizada!');
                setTimeout(function(){
                  $(location).attr("href","listaCategorias");
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
	  $(location).attr("href","listaCategorias");
  });

  //----------------------------------------------------------
  //ELIMINAR CATEGORIAS
  $('.remove').click(function(){
    var codigo = $(this).parent().parent().find('.codigo').text();
    alertify.confirm('Desea eliminar esta categoria?',
    function(){//SI PULSA OK
      $.ajax({
        type:"POST",
        url:'deleteCategoria',
        data:"categoria.codigo="+codigo,
        success:function(data){
          var msg = data.mensaje;
          if(msg == 'ok'){
            alertify.success('Categoria '+codigo+' eliminada!');
            setTimeout(function(){
              $(location).attr("href","listaCategorias");
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
      alertify.error('Eliminacion Cancelada!');
    })
  });

});
