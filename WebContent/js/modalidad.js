$(document).ready(function() {
  var opcion = $('#opcion').val();
  var validacion;

  //-----------------------------------------------

  //INICIAR BOTONES
  if(opcion == "registrar"){
//    $('#btnNuevo').hide();
    $('#btnGuardar').text('Guardar');
    $('#btnReset').text('Limpiar');
  }else{
//    $('#btnNuevo').show();
    $('#btnGuardar').text('Actualizar');
    $('#btnReset').text('Cancelar');
  }

  
//Maximo valor del input
  $("#descripcion").attr("maxlength", 30);

  //--------BOOTSTRAP VALIDATOR--------------
  $('#formModalidad').bootstrapValidator({
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
//         regexp: {
//           regexp: /^[a-zA-ZñÑÁÉÍÓÚ\s][1-9]+$/i,
//           message: 'Caracter Inválido'
//         },
         stringLength:{
         	min: 5,
         	message: 'Ingrese mínimo 5 carácteres'
         },
          notEmpty:{
            message: 'Requerido'
          }
        }
      },
      codDisciplina:{
        selector: '#codDisciplina',
        validators:{
          notEmpty:{
            message: 'Requerido'
          }
        }
      },
      codCategoria:{
        selector: '#codCategoria',
        validators:{
          notEmpty:{
            message: 'Requerido'
          }
        }
      },
      tipo:{
        selector: '#tipo',
        validators:{
          notEmpty:{
            message: 'Requerido'
          }
        }
      }
    }
  });
  //-----------------------------------------

  //-------------------VALIDAR NOMBRE DE MODALIDAD----------------
  var gnomModalidad = $('#descripcion').val().trim().toUpperCase();
  $('#descripcion').focusout(function(){
    var nombre = $(this).val().trim().toUpperCase();
    validarNombre(nombre);
  });

  function validarNombre(nombre){
    var html = "";
    if( nombre != '' ){
      if( nombre != gnomModalidad ){
          gnomModalidad = nombre;
          $.ajax({
          type: "GET",
          url: "nombreModalidad",
          data: "modalidad.descripcion="+gnomModalidad,
          success:function(result){
            var mensaje = result.mensaje;
            if(mensaje == 'OK'){
              html += '<label class="label label-success">'+'Nombre '+gnomModalidad+' Valido'+'</label>';
              $('#alerta').children('label').replaceWith(html);
              alertify.success('Nombre '+gnomModalidad+' Valido');
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
      alertify.warning("No ha ingresado ningun nombre de modalidad");
    }
  }

  //-----------------------------------------------------------

  //-------PLUGIN ALERTIFY------------------
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
  //----------------------------------------

  //-------FUNCION BUSCADOR DE ELEMENTOS-----------------
  (function ($) {//DISCIPLINAS
      $('#buscaDisciplinas').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.disciplinas .disciplina').hide();
        $('.disciplinas .disciplina').filter(function () {
            return rex.test($(this).text());
        }).show();
      })
  }(jQuery));

  (function ($) {//CATEGORIAS
      $('#buscaCategorias').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.categorias .categoria').hide();
        $('.categorias .categoria').filter(function () {
            return rex.test($(this).text());
        }).show();
      })
  }(jQuery));

  (function ($) {//MODALIDADES
      $('#buscaModalidad').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.modalidades .modalidad').hide();
        $('.modalidades .modalidad').filter(function () {
            return rex.test($(this).text());
        }).show();
      })
  }(jQuery));
  //-----------------------------------------------------

  //---------SELECCIONAR DISCIPLINA----------------------
  let codDisciplina;
  let nomDisciplina;
  $('.disciplina').click(function(){
    $(this).parent().find('.seleccionado').children('td').css({'color':'rgb(51, 51, 51)','font-weight':'normal'});
    $(this).addClass('seleccionado').children('td').css({'color':'#10ad3c','font-weight':'bold'});
    codDisciplina = $(this).find('.codDisciplina').val();
    nomDisciplina = $(this).find('.descripcion').text();
    console.error(codDisciplina);
  });

  $('#addDisciplina').click(function(){
    $('#codDisciplina').val(codDisciplina);
    $('#nomDisciplina').text(nomDisciplina);
  });
  //-----------------------------------------------------

  //---------SELECCIONAR CATEGORIA----------------------
  let codCategoria;
  let nomCategoria;
  $('.categoria').click(function(){
    $(this).parent().find('.seleccionado').children('td').css({'color':'rgb(51, 51, 51)','font-weight':'normal'});
    $(this).addClass('seleccionado').children('td').css({'color':'#10ad3c','font-weight':'bold'});
    codCategoria = $(this).find('.codCategoria').val();
    nomCategoria = $(this).find('.descripcion').text();
  });

  $('#addCategoria').click(function(){
    $('#codCategoria').val(codCategoria);
    $('#nomCategoria').text(nomCategoria);
  });
  //-----------------------------------------------------

  //-----------BOTON CANCELAR------------------------------
  $('.btnCancelar').click(function(){
    $('tbody').children('td').css({'color':'rgb(51, 51, 51)','font-weight':'normal'});
  });
  //------------------------------------------------------

  //---------VALIDAR CAMPOS VACIOS-----------------------
  function validarCampos(descripcion,disciplina,categoria,sexo){
    var msg = "ok";
    if(descripcion == ""){
      msg = "Ingrese Descripcion";
      return msg;
    }
    if(disciplina == ""){
      msg = "Seleccione una Disciplina";
      return msg;
    }
    if(categoria == ""){
      msg = "Seleccione una Categoria";
      return msg;
    }
    if(sexo == "" || sexo == null){
      msg = "Seleccione el Tipo de Modalidad";
      return msg;
    }
    if(descripcion == "" && disciplina == ""  && categoria == "" && sexo == ""){
      msg = "Debe llenar los campos";
      return msg;
    }
    return msg;
  }
  //-----------------------------------------------------

  //------------GUARDAR O ACTUALIZAR----------------------
  $('#btnGuardar').click(function(){
    var codigo = $('#codigo').val();
  	var descripcion = $('#descripcion').val().toUpperCase();
  	var disciplina = $('#codDisciplina').val();
    var categoria = $('#codCategoria').val();
    var sexo = $('#tipo').val();
    validacion = validarCampos(descripcion,disciplina,categoria,sexo);
    if(opcion == "registrar"){//MODO DE INSERTAR
      if(validacion == 'ok'){
        alertify.confirm('Desea grabar esta modalidad?',
        function(){//SI PULSA OK
          $.ajax({
            type: "POST",
            url:"regModalidad",
            data:"modalidad.descripcion="+descripcion+
                  "&modalidad.codDisciplina="+disciplina+
                  "&modalidad.codCategoria="+categoria+
                  "&modalidad.tipo="+sexo,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Modalidad '+descripcion+' Registrada!');
                setTimeout(function(){
                  $(location).attr("href","listaModalidad");
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
        alertify.confirm('Desea actualizar esta modalidad?',
        function(){//SI PULSA OK
          $.ajax({
            type: "POST",
            url:"uptModalidad",
            data:"modalidad.descripcion="+descripcion+
                  "&modalidad.codDisciplina="+disciplina+
                  "&modalidad.codCategoria="+categoria+
                  "&modalidad.tipo="+sexo+
                  "&modalidad.codigo="+codigo,
            success:function(data){
              var msg = data.mensaje;
              if(msg == 'ok'){
                alertify.success('Modalidad '+codigo+' Actualizada!');
                setTimeout(function(){
                  $(location).attr("href","listaModalidad");
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
  //------------------------------------------------------

  //----------------BOTON CANCELAR------------------------
  $('#btnReset').click(function(){
	  $(location).attr("href","listaModalidad");
  });
  //------------------------------------------------------

  //------------ELIMINAR MODALIDAD------------------------
  $('.remove').click(function(){
    var codigo = $(this).parent().parent().find('.codigo').text();
    alertify.confirm('Desea eliminar esta modalidad?',
    function(){//SI PULSA OK
      $.ajax({
        type:"POST",
        url:'deleteModalidad',
        data:"modalidad.codigo="+codigo,
        success:function(data){
          var msg = data.mensaje;
          if(msg == 'ok'){
            alertify.success('Modalidad '+codigo+' eliminada!');
            setTimeout(function(){
              $(location).attr("href","listaModalidad");
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
  //-------------------------------------------------------

});
