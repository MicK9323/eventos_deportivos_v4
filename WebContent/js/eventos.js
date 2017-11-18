$(document).ready(function() {
	//-------FUNCION BUSCADOR DE ELEMENTOS-----------------
  (function ($) {//CATEGORIAS
      $('#buscaSedes').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.sedes .sede').hide();
        $('.sedes .sede').filter(function () {
            return rex.test($(this).text());
        }).show();
      })
  }(jQuery));

  (function ($) {//MODALIDADES
      $('#buscaModalidades').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.modalidades .modalidad').hide();
        $('.modalidades .modalidad').filter(function () {
            return rex.test($(this).text());
        }).show();
      })
  }(jQuery));
  //---------------------------------------------------------

  //---------------VALIDATORS--------------------------------
  var cantIntegrantes;
  $('#formEvento').bootstrapValidator({
    feedbackIcons: {
              valid: 'glyphicon glyphicon-ok',
              invalid: 'glyphicon glyphicon-remove',
              validating: 'glyphicon glyphicon-refresh'
    },
    submitButtons:'#btnGrabar',
    fields:{
      nomEvento:{
        selector:'#nomEvento',
        validators:{
          notEmpty:{
            message:'Campo Requerido*'
          },
          stringLength:{
            min: 8,
            max: 50,
            message: 'El nombre debe contener más de 8 y menos de 30 caracteres*'
          },
          regexp:{
            regexp: /^[a-zA-ZñÑÁÉÍÓÚ0-9\s]+$/,
            message: 'Ingrese solo números y letras*'
          }
        }
      },
      inicioInscripcion:{
        selector:'#inicioInscripcion',
        validators:{
          notEmpty:{
            message:'Campo Requerido*'
          }
        }
      },
      finInscripcion:{
        selector:'#finInscripcion',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          }
        }
      },
      inicioEvento:{
        selector:'#inicioEvento',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          }
        }
      },
      finEvento:{
        selector:'#finEvento',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          }
        }
      },
      inicioModalidad:{
        selector:'#inicioModalidad',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          }
        }
      },
      finModalidad:{
        selector:'#finModalidad',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          }
        }
      },
      integrantes:{
        selector:'#integrantes',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      },
      cantMujeres:{
        selector:'#cantMujeres',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      },
      cantVarones:{
        selector:'#cantVarones',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos'
          }
        }
      },
      nroEquipos:{
        selector:'#nroEquipos',
        validators:{
          notEmpty:{
            message: 'Campo Requerido*'
          },
          regexp: {
            regexp: /^[0-9]{1,2}$/,
            message: 'Ingrese solo valores númericos de hasta 2 cifras'
          }
        }
      }
    }
  });
  $('#inicioInscripcion').change(function(){//---DETECTAR CAMBIO DE VALOR
    $('#formEvento').bootstrapValidator('revalidateField','inicioInscripcion');
  })
  $('#finInscripcion').change(function(){//---DETECTAR CAMBIO DE VALOR
    $('#formEvento').bootstrapValidator('revalidateField','finInscripcion');
  })
  $('#inicioEvento').change(function(){//---DETECTAR CAMBIO DE VALOR
    $('#formEvento').bootstrapValidator('revalidateField','inicioEvento');
  })
  $('#finEvento').change(function(){//---DETECTAR CAMBIO DE VALOR
    $('#formEvento').bootstrapValidator('revalidateField','finEvento');
  })
  $('#inicioModalidad').change(function(){//---DETECTAR CAMBIO DE VALOR
    $('#formEvento').bootstrapValidator('revalidateField','inicioModalidad');
  })
  $('#finModalidad').change(function(){//---DETECTAR CAMBIO DE VALOR
    $('#formEvento').bootstrapValidator('revalidateField','finModalidad');
  })
  $('#integrantes').change(function(){//---DETECTAR CAMBIO DE VALOR
    cantIntegrantes = $(this).val();
  })
  $('#cantMujeres').change(function(){//---DETECTAR CAMBIO DE VALOR
    // mujeres = $(this).val();
    $('#formEvento').bootstrapValidator('revalidateField','cantMujeres');
  })
  $('#cantVarones').change(function(){//---DETECTAR CAMBIO DE VALOR
    // mujeres = $(this).val();
    $('#formEvento').bootstrapValidator('revalidateField','cantVarones');
  })
  //---------------------------------------------------------

  //-------------------VALIDAR NOMBRE DE EVENTO----------------
  var gnomEvento = $('#nomEvento').val().trim().toUpperCase();
  $('#nomEvento').focusout(function(){
    var nombre = $(this).val().trim().toUpperCase();
    validarNombre(nombre);    
  });

  function validarNombre(nombre){
    var html = "";
    if( nombre != '' ){
      if( nombre != gnomEvento ){
          gnomEvento = nombre;
          $.ajax({
  				type: "GET",
  				url: "validaNombre",
  				data: "evento.desc_evento="+gnomEvento,
  				success:function(result){
  					var mensaje = result.mensaje;
  					if(mensaje == 'OK'){
              html += '<label class="label label-success">'+'Nombre '+gnomEvento+' Valido'+'</label>';
              $('#alerta').children('label').replaceWith(html);
  						alertify.success('Nombre '+gnomEvento+' Valido');
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
      alertify.warning("No ah ingresado ningun nombre de evento");
    }
  }
  //-----------------------------------------------------------

  //--------------CREACION DE ALERTA PERSONAL-----------------
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
  //--------------------------------------------------------------

	//-------------------------SELECCIONAR SEDE----------------------------------------
	// var codSede;
	// var nomSede;
  var arrayCodSede = [];
  var arrayNomSede = [];
	$('.sede').click(function(){
		// $(this).parent().find('.seleccionado').children('td').css({'color':'rgb(51, 51, 51)','font-weight':'normal'});
    $(this).addClass('seleccionado').children('td').css({'color':'#10ad3c','font-weight':'bold'});
		var codSede = $(this).find('.codSede').text();
		var nomSede = $(this).find('.nomSede').text();
    arrayCodSede.push(codSede);
    arrayNomSede.push(nomSede);
    console.log('----SEDE---');
    console.log(arrayCodSede);
    console.log(arrayNomSede);
	});
	$('#addSede').click(function(){
		for(var i = 0; i<arrayNomSede.length;i++){
      $('#nomSedes').append('<span class="label label-primary">'+arrayNomSede[i]+'</span> ');
    }
	});
  $('#btnLimpiarSedes').click(function(){
    limpiarSedes();
  });
  $('#btnTodo').click(function(){
    seleccionarTodo();
    console.log(arrayCodSede);
    console.log(arrayNomSede);
  });
	//---------------------------------------------------------------------------------

	//-------------------------SELECCIONAR MODALIDAD-----------------------------------
	var codModalidad;
	var nomModalidad;
	$('.modalidad').click(function(){
    $(this).parent().find('tr.seleccionado').removeClass('seleccionado');
		$(this).parent().find('tr').children('td').css({'color':'rgb(51, 51, 51)','font-weight':'normal'});
    $(this).addClass('seleccionado').children('td').css({'color':'#10ad3c','font-weight':'bold'});
		codModalidad = $(this).find('.codModalidad').val();
    nomModalidad = $(this).find('.descripcion').text();
    console.log('----MODALIDAD---');
    console.log(codModalidad);
    console.log(nomModalidad);
	});
	$('#addModalidad').click(function(){
		$('#codModalidad').val(codModalidad);
		$('#nomModalidad').text(nomModalidad);
	})
	//---------------------------------------------------------------------------------

  //-----------------FUNCION PARA VALIDAR CAMPOS VACIOS------------------------------
  function validarCamposEvento(nombre,inscripcionInicio,inscripcionFin,eventoInicio,eventoFin){
    var msg = "";
    if(arrayDetalle.length == 0){
      msg = "No ah ingresado datos";
    }else if(nombre == ""){
      msg = "Ingrese un nombre de evento!";
    }else if(inscripcionInicio == ""){
      msg = "Ingrese Inicio Inscripcion";
    }else if(inscripcionFin == ""){
      msg = "Ingrese Cierre de Inscripcion";
    }else if(eventoInicio == ""){
      msg = "Ingrese Inicio del Evento!";
    }else if(eventoFin == ""){
      msg = "Ingrese Fin del Evento";
    }else if(nombre == "" && inscripcionInicio == "" && inscripcionFin == "" && eventoInicio == "" && eventoFin == ""){
      msg = "Porfavor llene los campos";
    }else{
      msg = "ok";
    }
    return msg;
  }

  function validarCamposDetalle(sede,modalidad,inicio,fin,integrantes,mujeres,varones,equipos){
    var msg = "";
    if(sede.length < 0 && modalidad == "" && inicio == "" && fin == "" && minimo == "" && maximo == "" && mujeres == "" && varones == "" && equipos == ""){
      msg = "No ah ingresado datos";
    }else if(sede.length < 0){
      msg = "Seleccione al menos una sede";
    }else if(modalidad == ""){
      msg = "No ah seleccionado una modalidad";
    }else if(inicio == ""){
      msg = "Ingrese la fecha de apertura para esta modalidad";
    }else if(fin == ""){
      msg = "Ingrese la fecha de clausura para esta modalidad";
    }else if(integrantes == ""){
      msg = "Ingrese la cantidad minima de participantes";
    }else if(mujeres == ""){
      msg = "Ingrese la cantidad permitida de mujeres";
    }else if(varones == ""){
      msg = "Ingrese la cantidad permitida de varones";
    }else if(equipos == ""){
      msg = "Ingrese la cantidad de equipos que participaran";
    }else if((parseInt(varones) + parseInt(mujeres)) != parseInt(integrantes)){
      msg = "Cantidad de integrantes por sexo fuera de rango";
    }else{
      msg = "ok";
    }
    return msg;
  }
  //---------------------------------------------------------------------------------

	//----------FUNCION CONSTRUCTORA DE OBJETO DETALLE--------------------------------
	function Detalle(sede,modalidad,inicio,fin,integrantes,mujeres,varones,equipos){
		this.sede = sede;
		this.modalidad = modalidad;
		this.inicio = inicio;
		this.fin = fin;
		this.integrantes = integrantes;
		this.mujeres = mujeres;
		this.varones = varones;
		this.equipos = equipos;
	}
	//---------------------------------------------------------------------------------

	//-----------------------FUNCION QUE AGREGARA DETALLE A LA TABLA-------------------
	var arrayDetalle = new Array();
	function agregarDetalle(Detalle){
		var msg = "";
    if(arrayDetalle.length == 0){
      msg = "ok";
    }else{
      for(var i = 0; i < arrayDetalle.length; i++){
  			if(arrayDetalle[i].sede === Detalle.sede && arrayDetalle[i].modalidad === Detalle.modalidad){
  				msg = "Sede "+Detalle.sede+" ya esta registrada en la modalidad "+nomModalidad;
          break;
  			}else{
  				msg = "ok";
  			}
  		}
    }
		return msg;
	}
	//---------------------------------------------------------------------------------

  //----------------------LIMPIAR SEDES SELECCIONADAS-------------------------------
  function limpiarSedes(){
    $('#tbSedes').children('tr.sede').removeClass('seleccionado');
    $('#tbSedes').children('tr').children('td').css({'color':'rgb(51, 51, 51)','font-weight':'normal'});
    $('#nomSedes').html('<strong>Participan: </strong>');
    arrayCodSede.length = 0;
    arrayNomSede.length = 0;
  }
  //--------------------------------------------------------------------------------

  //----------------------SELECCIONAR_TODO------------------------------------------
  function seleccionarTodo(){
    $('#tbSedes tr').each(function() {
      $(this).addClass('seleccionado');
      $(this).children('td').css({'color':'#10ad3c','font-weight':'bold'});
      var cod = $(this).find('td.codSede').text();
      var nom = $(this).find('td.nomSede').text();
      arrayCodSede.push(cod);
      arrayNomSede.push(nom);
    });
  }
  //--------------------------------------------------------------------------------

  //----------------------LIMPIAR CAMPOS DE DETALLE----------------------------------
  function limpiarCampos(){
    limpiarSedes();
    $('#codModalidad').val("");
    $('#nomModalidad').text("Seleccione una modalidad!");
    $('#inicioModalidad').val("");
    $('#finModalidad').val("");
    $('#integrantes').val("");
    $('#cantMujeres').val("");
    $('#cantVarones').val("");
    $('#nroEquipos').val("");
  }
  //---------------------------------------------------------------------------------

	//--------------------------AGREGAR DETALLE----------------------------------------
	$('#btnAgregar').click(function(){
    // var codSede = $('#codSede').val().trim();
    var codModalidad = $('#codModalidad').val().trim();
    var iniModalidad = $('#inicioModalidad').val().trim();
    var finModalidad = $('#finModalidad').val().trim();
    var integrantes = $('#integrantes').val().trim();
    var cantMujeres = $('#cantMujeres').val().trim();
    var cantVarones = $('#cantVarones').val().trim();
    var nroEquipos = $('#nroEquipos').val().trim();
    var mensaje = validarCamposDetalle(arrayCodSede,codModalidad,iniModalidad,finModalidad,integrantes,cantMujeres
                                        ,cantVarones,nroEquipos);
    if(mensaje == "ok"){
      alertify.confirm('Desea agregar este detalle?',
  		function(){
        for( var i = 0; i < arrayCodSede.length;i++){
          var obj = new Detalle(arrayCodSede[i],codModalidad,iniModalidad,finModalidad,integrantes,cantMujeres,
    															cantVarones,nroEquipos);
          var mensaje = agregarDetalle(obj);
          if( mensaje == "ok" ){
            arrayDetalle.push(obj);
            var tblData = "";
            tblData += '<tr class="detalles">'+
  											 '<td class="col-md-2">'+arrayNomSede[i]+'</td>'+
                         '<input type="hidden" class="sedeCodigo" value="'+obj.sede+'">'+
  											 '<td class="col-md-2">'+nomModalidad+'</td>'+
                         '<input type="hidden" class="modCodigo" value="'+obj.modalidad+'">'+
  											 '<td class="col-md-1 text-center">'+obj.inicio+'</td>'+
  											 '<td class="col-md-1 text-center">'+obj.fin+'</td>'+
  											 '<td class="col-md-1 text-center">'+obj.integrantes+'</td>'+
  											 '<td class="col-md-1 text-center">'+obj.mujeres+'</td>'+
  											 '<td class="col-md-1 text-center">'+obj.varones+'</td>'+
  											 '<td class="col-md-1 text-center">'+obj.equipos+'</td>'+
  											 '<td class="col-md-1 text-center"><a class="remove"><span class="glyphicon glyphicon-remove-circle"></span></a></td>'+
  									    '</tr>';
            $('#tdDetEvento').append(tblData);
            alertify.success('Sede '+arrayNomSede[i]+' y Modalidad '+nomModalidad+' agregada!');
          }else{
            alertify.error(mensaje);
          }
        }
        limpiarCampos();
  		},function(){
  			alertify.warning('Cancelado!');
  		});
    }else{
      alertify.warning(mensaje);
    }
	});
	//---------------------------------------------------------------------------------

  //--------------------BOTON DESCARTAR DETALLE-------------------------------------
  $('#btnDescartar').click(function(){
    limpiarCampos();
  });
  //--------------------------------------------------------------------------------

  //-----------------GRABAR EVENTO-------------------------------------------------
	$('#btnGrabar').click(function(){
    if(arrayDetalle.length == 0){
      $('#formEvento').data('bootstrapValidator').validate();
    }else{
      var nomEvento = $('#nomEvento').val().trim().toUpperCase();
      var iniInscripcion = $('#inicioInscripcion').val().trim();
      var finInscripcion = $('#finInscripcion').val().trim();
      var iniEvento = $('#inicioEvento').val().trim();
      var finEvento = $('#finEvento').val().trim();
      var mensaje = validarCamposEvento(nomEvento,iniInscripcion,finInscripcion,iniEvento,finEvento);
      if(mensaje == "ok"){
        alertify.confirm('Desea grabar este evento?',
    		function(){//SI PULSA OK
    			$.ajax({
    				type: "POST",
    				url: "regEvento",
    				data: "evento.desc_evento="+nomEvento+"&evento.inicio_inscripcion="+iniInscripcion+"&evento.fin_inscripcion="+finInscripcion
    							+"&evento.inicio_evento="+iniEvento+"&evento.fin_evento="+finEvento,
    				success: function(data){
    					var codEvento = data.mensaje;
              for(var i=0; i<arrayDetalle.length; i++){
                var obj = arrayDetalle[i];
                $.ajax({
                  type: "POST",
                  url: "regDetEvento",
                  data: "detalle.cod_evento="+codEvento+"&detalle.cod_modalidad="+obj.modalidad+"&detalle.cod_sede="+obj.sede+
                        "&detalle.fec_inicio="+obj.inicio+"&detalle.fec_fin="+obj.fin+"&detalle.cantIntegrantes="+obj.integrantes+
                        "&detalle.cantMujeres="+obj.mujeres+"&detalle.cantVarones="+obj.varones+"&detalle.maxEquipos="+obj.equipos,
                  success: function(data){
                    var resp = data.mensaje;
                    if(resp == "ok"){
                      alertify.success('Se agrego la modalidad: '+obj.modalidad+' al evento '+codEvento);
                    }else{
                      alertify.error(resp);
                    }
                  },
                  error: function(data){
                    alertify.error(data.mensaje);
                  }
                });
              }
              //------------------------
              alertify.confirm('Evento grabado correctamente desea crear un nuevo evento?',
              function(){
                $(location).attr("href","cargarDatos");
              },function(){
                $(location).attr("href","listarEventos");
              });
              //------------------------
    				},
    				error: function(data){
    					alertify.error(data.mensaje);
    				}
    			});
    		},function(){//SI PULSA CANCEL
    				alertify.warning('Registro de evento cancelado!');
    		});
      }else{
        alertify.warning(mensaje);
      }
    }
	});

  //---------------------------------ELIMINAR FILA------------------------------------------
  $('#tdDetEvento').on('click','.remove',function(){
    var sede;
    var modalidad;
    var indice;
    sede = $(this).parent().parent().find('.sedeCodigo').val();
    modalidad = $(this).parent().parent().find('.modCodigo').val();
    for(var i=0;i <arrayDetalle.length;i++){
      if(arrayDetalle[i].sede == sede && arrayDetalle[i].modalidad == modalidad){
        indice  = i;
        break;
      }
    }
    $(this).parent().parent().fadeOut('slow',function(){$(this).remove();});
    arrayDetalle.splice(indice,1);
    alertify.warning('Detalle eliminado');
  });
  //----------------------------------------------------------------------------------------

});
