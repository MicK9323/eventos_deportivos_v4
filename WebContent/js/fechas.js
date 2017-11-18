$(document).ready(function(){
  //------------DECLARACION DE VARIABLES--------------
  var dNow = new Date();
  var hoy = dNow.getFullYear()+'-'+(dNow.getMonth()+1)+'-'+dNow.getDate();
  var iniInscripcion;
  var finInscripcion;
  var inicioEvento;
  var finEvento;
  var inicioModalidad;
  var finModalidad;
  //--------------------------------------------------

  //------------DATEPICKERS-------------
  $.fn.datepicker.defaults.format = "yyyy-mm-dd";
  $.fn.datepicker.noConflict;
  $('#inicioInscripcion').datepicker({//Iniciar datepicker con fecha del dia actual
   autoclose: true,
   startDate: hoy
  });
  $('#finInscripcion').datepicker({//Iniciar datepicker
   autoclose: true
  });
  $('#inicioEvento').datepicker({//Iniciar datepicker
   autoclose: true
  });
  $('#finEvento').datepicker({//Iniciar datepicker
   autoclose: true
  });
  $('#inicioModalidad').datepicker({
    autoclose: true
  });
  $('#finModalidad').datepicker({
    autoclose: true
  });

  $('#inicioInscripcion').change(function(e){//cambia la fecha de inicio para seleccionar el cierre de inscripcion
    iniInscripcion = $(this).val();
    $('#finInscripcion').datepicker('setStartDate',iniInscripcion);
  });
  $('#finInscripcion').change(function(e){//Inicia las opciones de fecha inicial y fecha maxima de inicio de evento y fecha maxima de fin de evento
    finInscripcion = $(this).val();
    $('#inicioEvento').datepicker('setStartDate',finInscripcion);
  });
  $('#inicioEvento').change(function(e){//Inicia las opciones de fecha inicial y fecha maxima de inicio de evento y fecha maxima de fin de evento
    inicioEvento = $(this).val();
    $('#finEvento').datepicker('setStartDate',inicioEvento);
    $('#inicioModalidad').datepicker('setStartDate',inicioEvento);
  });
  $('#finEvento').change(function(e){//Inicia las opciones de fecha inicial y fecha maxima de inicio de evento y fecha maxima de fin de evento
    finEvento = $(this).val();
    $('#inicioModalidad').datepicker('setEndDate',finEvento);
    $('#finModalidad').datepicker('setEndDate',finEvento);
  });
  $('#inicioModalidad').change(function(e){
    inicioModalidad = $(this).val();
    $('#finModalidad').datepicker('setStartDate',inicioModalidad);
  });
  $('#finModalidad').change(function(e){
    finModalidad = $(this).val();
  });
  //-----------------------------------------------
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
  //---------------------------------------------------------
  //----------MENSAJES PARA EVITAR CAMPOS VACIOS-------------
  $('#finInscripcion').click(function(e){
    if(iniInscripcion == null){
      alertify.miAlerta('Seleccione la fecha de inicio de inscripcion!');
    }
  });
  $('#inicioEvento').click(function(e){
    if(iniInscripcion == null || finInscripcion == null){
      alertify.miAlerta('Seleccione el rango para inscripcion!');
    }
  });
  $('#finEvento').click(function(e){
    if(iniInscripcion == null || finInscripcion == null){
      alertify.miAlerta('Seleccione el rango para inscripcion!');
    }
    if(inicioEvento == null){
      alertify.miAlerta('Seleccione el inicio del evento!');
    }
  });
//  $('#btnDetalle').click(function(e){
//    if(iniInscripcion == null || finInscripcion == null || inicioEvento == null || finEvento == null){
//      alertify.miAlerta('Ingrese las fechas clave del evento antes de pasar al detalle!');
//    }
//  });
  //---------------------------------------------------------


});
