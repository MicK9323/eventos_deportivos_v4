$(document).ready(function(){
	//$('#tbIntegrantes').hide();

	var cont = 0;
	var gcodigoEvento;
	var gcodigoModalidad;
	var gnomModalidad;
	var gintegrantes;
	var gmaximo;
	var gvarones;
	var ginicio;
	var gfin;
	var cantJugadores = 0;
	var dNow = new Date();
	var hoy = dNow.getDate()+'/'+dNow.getMonth()+'/'+dNow.getFullYear();
	var jugadores = [];

	$('#validador').hide();

	$('#hoy').text(hoy);

	//Cambiar de color a fila seleccionada
	$('.mod').click(function(){

		if(cont<1){
			$(this).css('color', '#FA830F');
			$(this).parent().parent().css('color', '#FA830F');
			cont = cont + 1;
			gcodigoEvento = $(this).parent().parent().find('label.cod_evento').text();
			gcodigoModalidad = $(this).parent().parent().find('input.cod_modalidad').val();
			gnomModalidad = $(this).parent().parent().find('label.nom_modalidad').text();;
			gintegrantes = $(this).parent().parent().find('label.minimo').text();
			gmaximo = $(this).parent().parent().find('label.maximo').text();
			gvarones = $(this).parent().parent().find('input.varones').val();
			ginicio = $(this).parent().parent().find('input.inicio').val();
			gfin = $(this).parent().parent().find('input.fin').val();
		}else{
			alert('Seleccione solo 1 evento');
		}
	});

	//Cerrar Ventana Modal
	$('#addModalidad').click(function(){
		if(cont=1){
			$('#mod1').text(gnomModalidad);
			$('#inicio').text(ginicio);
			$('#fin').text(gfin);
			$('#codModalidad').val(gcodigoModalidad);
			$('#max').text(gmaximo);
			$('#min').text(gintegrantes);
			$('#validador').show();
			if(gvarones > 0){
				$('#maxvarones').text(gvarones);
			}else{
				$('#varones').hide();
			}

			console.log('Cod. Modalidad '+ $('#codModalidad').val());
		}
		else{
			alert('No ah seleccionado ningun evento');
		}
	});

	//Deseleccionar Modalidad
	$('#btnLimpiar').click(function(){
		$('tr').css('color', '#343333');
		$('.mod').css('color', '#343333');
		cont = 0;
		gcodigoEvento = "";
		gcodigoModalidad = "";
		gnomModalidad = "";
		gintegrantes = "";
		gmaximo = "";
		ginicio = "";
		gfin = "";
	});

	$('#btnReset').click(function(){
		location.reload();
	})

	//Validar Nombre de Equipo
	$('#btnValidarNombre').click(function(){
		var nombreEquipo = $('#NomEquipo').val();
		if(nombreEquipo != ""){
			$.ajax({
				type: "GET",
				url: "validarNombre",
				data: "nombreEquipo="+nombreEquipo,
				success:function(result){
					var mensaje = result.msg;
					if(mensaje == 'OK')
						alertify.success('Nombre Valido');
					else
						alertify.error(mensaje);
				},
				error: function(result){
					var mensaje = result.msg;
					alertify.error(mensaje);
				}
			});
		}else{
			alertify.error('No ah ingresado un nombre de equipo');
		}
	});

	//Validar Jugador
	$('#btnValidarJugador').click(function(){
		var dniJugador = $('#dniJugador').val();
		var codModalidad = $('#codModalidad').val();
		var codEvento = $('#codEvento').val();
		$.ajax({
			type: "POST",
			url: "validaJugador",
			data: "dniJugador="+ dniJugador+"&codModalidad="+ codModalidad+"&codEvento="+codEvento,
			success: function(data){
				var msg = data.msg;
				if(msg=='ok'){
					alertify.success(msg);
				}else{
					alertify.error(msg)
				}
				if(msg=='ok'){
					if(cantJugadores < gmaximo ){
						var dniJugador = $('#dniJugador').val();
						var existe = $.inArray(dniJugador,jugadores);
						if(existe === -1){
							$('#ingresados').text(jugadores.length+1);
							$.ajax({
								type: "GET",
								url: "datosJugador",
								data: "dniJugador="+dniJugador,
								success:function(result){
									if(result.jugador != null){
										jugadores[cantJugadores] = result.jugador.dni_jugador;
										cantJugadores = cantJugadores + 1;
										// if(gvarones>0 and result.jugador.sexo = 'MASCULINO'){
										// 	gvarones = gvarones - 1;
										// }
										var tblData = "";

											tblData +='<tr>'
														+'<td class="col-md-2">'
															+'<input readonly="true" name="dni[]" value="'+result.jugador.dni_jugador+'" class="form-control input-sm dni" type="text">'
														+'</td>'
														+'<td class="col-md-4">'
															+'<label class="nombres">'+result.jugador.nom_jugador+'</label>'
														+'</td>'
														+'<td class="col-md-1">'
															+'<label class="nombres">'+result.jugador.edad+'</label>'
														+'</td>'
														+'<td class="col-md-2">'
															+'<label class="nombres">'+result.jugador.sexo+'</label>'
														+'</td>'
														+'<td class="col-md-2">'
															+'<label class="nombres">'+result.jugador.nomSede+'</label>'
														+'</td>'
														+'<td class="col-md-1 text-center">'
															+'<a class="remove"><span class="glyphicon glyphicon-remove-circle"></span></a>'
														+'</td>'
													+'</tr>';

										$('#tbEquipo').append(tblData);
										$('#dniJugador').val("");
									}
									else{
										alertify.error('Valide el dni ingresado');
									}
								},
								error: function(data){
									alertify.error("Error: favor de validar antes de agregar");
								}
							});
						}
						else{
							alertify.error("Ya se ingreso este jugador");
						}
					}
					else{
						alertify.alert("Maximo de jugadores alcanzado");//, function(){alertify.message('OK');});
					}
				}
			},
			error: function(data){
				alertify.alert("Ocurrio un error");
			}
		});
	})

	//GRABAR FICHA Y EQUIPO
	$('#btnGrabar').click(function(){
		if($('#NomEquipo').val()!=""){
			if(gintegrantes <= cantJugadores && cantJugadores <= gmaximo){
				var codEvento = $('#codEvento').val();
				var codModalidad = $('#codModalidad').val();
				var nomEquipo = $('input[name=NomEquipo]').val();
				var codPago = $('#codPago').val();
				var dniDelegado = jugadores[0];
				$.ajax({
					type: "POST",
					url: "inscribirEquipo",
					data: "codEvento="+codEvento+"&codModalidad="+codModalidad+"&nombreEquipo="+nomEquipo
							+"&dniJugador="+dniDelegado+"&vCodPago="+codPago,
					success: function(data){
						var trama = data.msg;
						var numFicha = trama.substr(0,5);
						var codEquipo = trama.substr(5,5);
						for (var i = 0; i < jugadores.length; i++) {
							$.ajax({
								type: "POST",
								url: "registrarEquipo",
								data: "codEquipo="+codEquipo+"&dniJugador="+jugadores[i],
								success: function(data){

								},
								error: function(data){
									alertify.alert('Error en el equipo');
								}
							})
				        }
						alertify.alert('Registro Exitoso. Su codigo de ficha es: '+numFicha
														+' Su codigo de Equipo es: '+codEquipo);
						//var url = "index.jsp";
						//$(location).attr('href',url);
					},
					error: function(data){
						alertify.alert('Error en la ficha');
					}
				});
			}else{
				alertify.alert('Cant. de Integrantes Invalida Min: '+gintegrantes+' Max: '+gmaximo);
			}
		}else{
			alertify.alert('Ingrese un nombre de equipo');
		}


	});

	//Remover filas
	$('table').on('click','.remove',function(){
		var dni = $(this).parent().parent().find('input.dni').val();
		var i = jugadores.indexOf(dni);
		$(this).parent().parent().fadeOut('slow',function(){$(this).remove();});
		jugadores.splice(i,1);
		cantJugadores = cantJugadores - 1;
		console.log(cantJugadores);
		console.log(jugadores);
	});

})
