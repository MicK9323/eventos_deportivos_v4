$(document).ready(function() {
  //----------------------------------------------------------
  //INICIAR VARIABLES Y ELEMENTOS
  var gcodEvento = $('#codEvento').val();
  var grolUsuario = $('#rol').val();
  var gsexoDelegado = $('#sexoDelegado').val();
  var gnomEquipo = $('#NomEquipo').val().trim().toUpperCase();
  var gcodModalidad;
  var gnomModalidad;
  var gtipoModalidad;
  var gcantIntegrantes;
  var gmaxVarones;
  var gmaxMujeres;
  var gactVarones = 0;
  var gactMujeres = 0;
  var gfecInicio;
  var gfecFin;
  var cantJugadores = 0;
  var dNow = new Date();
  var hoy = dNow.getDate()+'/'+dNow.getMonth()+'/'+dNow.getFullYear();
	var arrayJugadores = [];
  var gselecciona = false;
  $('#validador').hide();
	$('#hoy').text(hoy);
  //-----------------------------------------------------------

  //--------------BUSCADOR-----------------------------------
  (function ($) {
    $('#buscador').keyup(function () {
        var rex = new RegExp($(this).val(), 'i');
        $('.buscar .cuadro').hide();
        $('.buscar .cuadro').filter(function () {
            return rex.test($(this).text());
          }).show();
        })
  }(jQuery));
  //---------------------------------------------------------

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

  //-------------------VALIDAR NOMBRE DE EQUIPO----------------
  $('#NomEquipo').focusout(function(){
    var nombre = $(this).val().trim().toUpperCase();
    validarNombre(nombre);
  });

  function validarNombre(nombre){
    var html = "";
    if( nombre != '' ){
      console.log(nombre);
      console.log(gnomEquipo);
      if( nombre != gnomEquipo ){
          gnomEquipo = nombre;
          $.ajax({
  				type: "GET",
  				url: "validarNombre",
  				data: "equipo.nom_equipo="+gnomEquipo,
  				success:function(result){
  					var mensaje = result.mensaje;
  					if(mensaje == 'OK'){
              html += '<label class="label label-success">'+'Nombre '+gnomEquipo+' Valido'+'</label>';
              $('#alerta').children('label').replaceWith(html);
  						alertify.success('Nombre '+gnomEquipo+' Valido');
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
      alertify.warning("No ah ingresado ningun nombre de equipo");
    }
  }
  //-------------------------------------------------------------------------------------

  //-----------SELECCIONAR MODALIDAD---------------------------
  $('#btnModalidad').click(function(){
    addModalidad();
  });

  $('.mod').click(function(){
    $(this).parent().find('tr.seleccionado').children('td','a.enlace-ico','span').css({'color':'rgb(51, 51, 51)','font-weight':'normal'});
    $(this).addClass('seleccionado').children('td','a..enlace-ico','span').css({'color':'#FA830F','font-weight':'bold'});
    gcodModalidad = $(this).find('input.cod_modalidad').val();
    gtipoModalidad = $(this).find('input.tipo').val();
    gfecInicio = $(this).find('input.inicio').val();
    gfecFin = $(this).find('input.fin').val();
    gmaxVarones = $(this).find('input.varones').val();
    gmaxMujeres = $(this).find('input.mujeres').val();
    gnomModalidad = $(this).find('label.nom_modalidad').text();
    gcantIntegrantes = $(this).find('label.integrantes').text();
    gselecciona = true
    console.log('DATOS DE MODALIDAD SELECCIONADA');
    console.log($('#codEvento').val());
    console.log(gcodModalidad);
    console.log(gnomModalidad);
    console.log(gtipoModalidad);
    console.log(gcantIntegrantes);
    console.log(gmaxVarones);
    console.log(gfecInicio);
    console.log(gfecFin);
    console.log('----------------------');
  });

  $('#addModalidad').click(function(){
    if( gselecciona == false ){
      alertify.error('No ha seleccionado ninguna modalidad');
    }else{
      validarDelegado();
    }
	});
  //-----------------------------------------------------------

  //------------FUNCION MOSTRAR DATOS DE MODALIDAD-------------------
  function addModalidad(){
    if( gselecciona == true && cantJugadores > 0 ){
      alertify.confirm("Si cambia de modalidad se eliminarán los jugadores ingresados. Esta seguro de continuar?",
      function(){ // al pulsar ok
        $("#tbEquipo tr.jugador").each(function() {
          $(this).fadeOut('slow',function(){$(this).remove();});
        });
        arrayJugadores.length = 0;
        cantJugadores = 0;
        gmaxMujeres = 0;
        gmaxVarones = 0;
        gactMujeres = 0;
        gactVarones = 0;
        gselecciona = false;
        $('#modalidadModal').modal("show");
      },function(){
        //al cancelar
      });
    }else{
      $('#modalidadModal').modal("show");
    }
  }

  function validarDelegado(){
    if( grolUsuario != 3 ){
      arrayJugadores.length = 0;
      cantJugadores = 0;
      gactMujeres = 0;
      gactVarones = 0;
      var dniDelegado = $('#delegado').val();
      $.ajax({
        type: "GET",
        url: "validaJugador",
        data: "dni="+dniDelegado+"&codModalidad="+gcodModalidad+"&evento.cod_evento="+gcodEvento,
        success:function(result){
          var validacion = result.mensaje;
          if( validacion == 'ok' ){
            if( gsexoDelegado == 'FEMENINO' ){
              gactMujeres = gactMujeres + 1;
            }
            if( gsexoDelegado == 'MASCULINO' ){
              gactVarones = gactVarones + 1;
            }
            arrayJugadores.push(dniDelegado);
            cantJugadores = cantJugadores + 1;
            console.log('Cant. Integrantes: '+gcantIntegrantes);
            console.log('Jugadores: '+arrayJugadores);
            console.log('Cant. Actual: '+cantJugadores);
            console.log('Mujeres: '+gactMujeres);
            console.log('Varones: '+gactVarones);
            mostrarDatos();
          }else{
            alertify.miAlerta('¡ '+validacion+' !');
          }
        },
        error:function(result){
          alertify.miAlerta('¡ '+result.mensaje+' !');
        }
      });
    }else{
      mostrarDatos();
    }
  }

  function mostrarDatos(){
    $('#mod1').text(gnomModalidad);
	  $('#inicio').text(gfecInicio);
	  $('#fin').text(gfecFin);
	  $('#codModalidad').val(gcodModalidad);
	  $('#total').text('Integrantes: '+gcantIntegrantes);
	  $('#integrantes').text(''+cantJugadores);
	  $('#totalVarones').text('Cant. Varones: '+gmaxVarones);
    $('#totalMujeres').text('Cant. Mujeres: '+gmaxMujeres);
    $('#contvarones').text(''+gactVarones);
    $('#contmujeres').text(''+gactMujeres);
	  $('#validador').show();
  }
  function actualizarDatos(){
	  $('#integrantes').text(''+cantJugadores);
    $('#contvarones').text(''+gactVarones);
    $('#contmujeres').text(''+gactMujeres);
  }
  //-----------------------------------------------------------------

  //-----------llenar arreglo de jugadores---------------------------
  function llenarArreglo(dni, nombres, edad, sexo, sede){
    $.ajax({
      type: "POST",
      url: "detalleJugadores",
      data: {"DNI":dni,
             "nom":nombres,
             "edad":edad,
             "sexo":sexo,
             "sede":sede}
    });
  }
  //-----------------------------------------------------------------

  //---------AGREGAR JUGADOR A LA TABLA------------------------
  $('#btnValidarJugador').click(function(){
    var dniJugador = $('#dniJugador').val();
		var codModalidad = $('#codModalidad').val();
		var codEvento = $('#codEvento').val();
    // var validaJugador = ''+validarJugador(dniJugador,codModalidad,codEvento);
    $.ajax({
      type: "GET",
			url: "validaJugador",
			data: "dni="+ dniJugador+"&codModalidad="+ codModalidad+"&evento.cod_evento="+codEvento,
      success:function(result){
        var msg = result.mensaje;
				if(msg=='ok'){
					// alertify.success(msg);
				}else{
					alertify.warning(msg);
          $('#dniJugador').val("");
				}
        if(msg == 'ok'){
          if(cantJugadores < gcantIntegrantes){
            var existe = $.inArray(dniJugador,arrayJugadores);
            if(existe === -1){
              $('#ingresados').text(arrayJugadores.length+1);
              $.ajax({
                type: "GET",
								url: "datosJugador",
								data: "dni="+dniJugador,
                success:function(result){
                  if(result.jugador != null){
                    var sex = result.jugador.sexo;
                    if( (sex == 'FEMENINO' && gactMujeres < gmaxMujeres) || (sex == 'MASCULINO' && gactVarones < gmaxVarones) ){
                      if(sex == 'FEMENINO'){ gactMujeres = gactMujeres + 1 }
                      if(sex == 'MASCULINO'){ gactVarones = gactVarones +1 }
                      arrayJugadores[cantJugadores] = result.jugador.dni_jugador;
                      cantJugadores = cantJugadores + 1;
                      var tblData = "";
                      tblData +='<tr class="jugador">'
														+'<td class="col-md-2">'
															+'<input readonly="true" name="dni[]" value="'+result.jugador.dni_jugador+'" class="form-control input-sm dni" type="text">'
														+'</td>'
														+'<td class="col-md-4">'
															+'<label class="nombres">'+result.jugador.nom_jugador+'</label>'
														+'</td>'
														+'<td class="col-md-1">'
															+'<label class="edad">'+result.jugador.edad+'</label>'
														+'</td>'
														+'<td class="col-md-2">'
															+'<label class="sexo">'+result.jugador.sexo+'</label>'
														+'</td>'
														+'<td class="col-md-2">'
															+'<label class="sede">'+result.jugador.nomSede+'</label>'
														+'</td>'
														+'<td class="col-md-1 text-center">'
															+'<a class="remove" title="Eliminar"><span class="glyphicon glyphicon-remove-circle"></span></a>'
														+'</td>'
													+'</tr>';
                      $('#tbEquipo').append(tblData);
                      llenarArreglo(result.jugador.dni_jugador, result.jugador.nom_jugador, result.jugador.edad, result.jugador.sexo, result.jugador.nomSede)
      								$('#dniJugador').val("");
                      actualizarDatos();
                      alertify.success('Jugador Agregado');
                    } else{
                      alertify.warning('Cant. de Jugadores '+sex+' alcanzado');
                      $('#dniJugador').val("");
                    }
                  }else{
                    alertify.warning('Valide el dni ingresado');
                  }
                },
                error:function(result){
                  alertify.warning("Error: favor de validar antes de agregar");
                }
              });
            }else{
              alertify.warning("Ya se ingreso este jugador");
              $('#dniJugador').val("");
            }
          }else{
            alertify.warning('Maximo de jugadores alcanzado');
            $('#dniJugador').val("");
          }
        }else{
          alertify.error("Ocurrio un error");
        }
      },
      error:function(result){
        alertify.warning(result.msg);
        $('#dniJugador').val("");
      }
    });
  });
  //----------------------------------------------------------

  //----------GRABAR FICHA Y EQUIPO--------------------------
  $('#btnGrabar').click(function(){
    if($('#NomEquipo').val()!=""){
      alertify.confirm('Desea grabar los datos ingresados?',
      function(){//SI PULSA OK
        if(gcantIntegrantes == cantJugadores){
          var sex = gtipoModalidad;
          if(((sex == 'MASCULINO' && gactVarones == gmaxVarones) || (sex == 'FEMENINO' && gactMujeres == gmaxMujeres)) || (sex == 'MIXTO' && gactVarones == gmaxVarones && gactMujeres == gmaxMujeres ) ){
            var codEvento = gcodEvento;
    				var codModalidad = gcodModalidad;
    				var nomEquipo = $('input[name=NomEquipo]').val().toUpperCase();
    				// var codPago = $('#codPago').val();
    				var dniDelegado = arrayJugadores[0];
    				$.ajax({
    					type: "POST",
    					url: "inscribirEquipo",
    					data: "evento.cod_evento="+codEvento+"&codModalidad="+codModalidad+"&equipo.nom_equipo="+nomEquipo
    							+"&delegado.dni_jugador="+dniDelegado,
    					success: function(data){
    						var trama = data.mensaje;
    						var numFicha = trama.substr(0,5);
    						var codEquipo = trama.substr(5,5);
    						for (var i = 0; i < arrayJugadores.length; i++) {
    							$.ajax({
    								type: "POST",
    								url: "registrarEquipo",
    								data: "equipo.cod_equipo="+codEquipo+"&jugador.dni_jugador="+arrayJugadores[i],
    								success: function(data){
//                      var dni = arrayJugadores[i].toString();
//                      alertify.success('Jugador con DNI: '+dni+' registrado en '+nomEquipo);
    								},
    								error: function(data){
    									alertify.error('Error en el equipo');
    								}
    							})
    				     }
                alertify.confirm('Registro Exitoso. Su codigo de ficha es: '+numFicha
    														+' Su codigo de Equipo es: '+codEquipo+' Desea registrar otro equipo?',function(){
                                  location.reload();
                                },function(){
                                  $(location).attr("href","cargarEventos");
                                })
    					},
    					error: function(data){
    						alertify.error('Error en la ficha');
    					}
    				});
          }else{
              alertify.warning('Cantidad de Jugadores de sexo '+sex+' invalida');
          }
			}else{
				alertify.error('Cant. de Integrantes Invalida Por favor ingrese los '+gcantIntegrantes+' necesarios');
			}
      },function(){//SI PULSA CANCELAR
        alertify.warning('Registro de equipo cancelado!');
      });
    }else{
      alertify.error('Ingrese un nombre de equipo');
    }
  });
  //---------------------------------------------------------

  //-------------BOTON RESET---------------------------------
  $('#btnReset').click(function(){
		location.reload();
	})
  //---------------------------------------------------------

  //-------------REMOVER FILAS-------------------------------
	$('table').on('click','.remove',function(){
    var dni = $(this).parent().parent().find('input.dni').val();
    var i = arrayJugadores.indexOf(dni);
    var sexo = $(this).parent().parent().find('label.sexo').text();
    $(this).parent().parent().fadeOut('slow',function(){$(this).remove();});
		arrayJugadores.splice(i,1);
		cantJugadores = cantJugadores - 1;
    if(sexo == 'MASCULINO'){
      gactVarones = gactVarones - 1;
    }
    if(sexo == 'FEMENINO'){
      gactMujeres = gactMujeres - 1;
    }
    actualizarDatos();
		alertify.warning('Jugador con DNI: '+dni+' eliminado!');
	});
  //-----------------------------------------------------------



});
