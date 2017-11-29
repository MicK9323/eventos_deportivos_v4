<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Evento</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-datepicker.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/alertify.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/themes/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/back.css">
</head>
<body>
	<%
			JugadorDTO obj = (JugadorDTO) session.getAttribute("usuario");		
			if(obj == null){
				response.sendRedirect("login.jsp");
			}
		%>
	<jsp:include page="menuAdmin.jsp"/>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="col-md-4">
					<a href="listarEventos" id="btnAddEvento" class="btn btn-warning">
						<span class="glyphicon glyphicon-arrow-left"></span> <strong>Volver al listado</strong>
					</a>
				</div>
				<div class="col-md-6 titulo text-center">
					<h4><strong>REGISTRO DE EVENTOS</strong></h4>
				</div>
			</div>
		</div>
	</div>
	<!-- DATOS DE EVENTO -->
	<div class="container">
		<form class="form-horizontal" id="formEvento" action="" method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="panel-group" id="acordeon">
						<!-- DATOS DEL EVENTO -->
						<div class="panel panel-primary">
							<div class="panel-heading" id="heading1">
								<h4 class="panel-title">
									<a href="#colapsable1" data-toggle="collapse" data-parent="#acordeon">
										<strong>Datos de Evento</strong>
									</a>
								</h4>
							</div>
							<div id="colapsable1" class="panel-collapse collapse in" arial-labelledby="heading1">
								<div class="panel-body">
									<!-- NOMBRE DE EVENTO -->
									<div class="form-group">
										<div class="col-md-2">
											<label class="control-label">Nombre de Evento:</label>
										</div>
									  <div class="col-md-4">
									  	<input type="text" class="form-control text-uppercase" name="" id="nomEvento" placeholder="Nombre de Evento">
											<div id="alerta" style="margin-top: 5px;"><label></label></div>
									  </div>
									</div>
									<!-- FECHAS DE INSCRIPCION -->
									<div class="form-group">
										<div class="col-md-2">
											<label class="control-label">Inicio de Inscripción</label>
										</div>
										<div class="col-md-3">
											<div class="input-group input-append date" id="datePicker" style="left:5px">
												<input type="text" class="form-control" name="" id="inicioInscripcion"/>
												<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
											</div>
										</div>
										<div class="col-md-2">
											<label class="control-label">Fin de Inscripción</label>
										</div>
										<div class="col-md-3">
											<div class="input-group input-append date" id="datePicker" style="left:5px">
												<input type="text" class="form-control" name="" id="finInscripcion"/>
												<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
											</div>
										</div>
									</div>
									<hr>
									<!-- FECHAS DE EVENTO -->
									<div class="form-group">
										<div class="col-md-2">
											<label class="control-label">Inicio de Evento</label>
										</div>
										<div class="col-md-3">
											<div class="input-group input-append date" id="datePicker" style="left:5px">
												<input type="text" class="fecha form-control" name="" id="inicioEvento"/>
												<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
											</div>
										</div>
										<div class="col-md-2">
											<label class="control-label">Fin de Evento</label>
										</div>
										<div class="col-md-3">
											<div class="input-group input-append date" id="datePicker" style="left:5px">
												<input type="text" class="fecha form-control" name="" id="finEvento"/>
												<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- DETALLE DE EVENTO -->
						<div class="panel panel-primary">
							<div class="panel-heading" id="heading2">
								<h4 class="panel-title" id="btnDetalle">
									<a href="#colapsable2" data-toggle="collapse" data-parent="#acordeon">
										<strong>Detalle de Evento</strong>
									</a>
								</h4>
							</div>
							<div id="colapsable2" class="panel-collapse collapse" arial-labelledby="heading2">
								<div class="panel-body">
									<!-- SELECCIONAR SEDE -->
									<div class="form-group">
										<div class="col-md-1">
											<label class="control-label">Sedes:</label>
										</div>
										<div class="col-md-3">
											<div data-toggle="modal" data-target="#sedesModal" id="btnSede" class="btn btn-default">Seleccionar Sedes</div>
										</div>
										<div class="col-md-8">
											<!-- <input type="hidden" id="codSede" value=""> -->
											<label class="control-label text-info" id="nomSedes"><strong>Participan: </strong></label>
										</div>

									</div>
									<!-- SELECCIONAR MODALIDAD -->
									<div class="form-group">
										<div class="col-md-1">
											<label class="control-label">Modalidad:</label>
										</div>
										<div class="col-md-3">
											<input type="hidden" id="codModalidad" value="">
											<label class="control-label text-danger" id="nomModalidad">Seleccione una Modalidad!</label>
										</div>
										<div class="col-md-3">
											<div data-toggle="modal" data-target="#modalModalidades" id="btnModalidad" class="btn btn-default">Seleccionar Modalidad</div>
										</div>
									</div>
									<hr>
									<!-- INGRESO DE DATOS DE MODALIDAD -->
									<!--DURACION DE MODALIDAD-->
									<div class="col-md-3 caja">
										<div class="form-group">
										  <label control-label>Duracion:</label>
											<!-- INICIO -->
											<div class="col-md-12">
												<div class="col-md-2">
													<label class="control-label">Inicio</label>
												</div>
												<div class="col-md-10">
													<div class="input-group input-append date mb5" id="datePicker" style="left:5px">
														<input type="text" class="fecha form-control" name="" id="inicioModalidad"/>
														<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
													</div>
												</div>
											</div>
											<div class="clearfix"></div>
											<!-- FIN -->
											<div class="col-md-12">
												<div class="col-md-2">
													<label class="control-label">Fin</label>
												</div>
												<div class="col-md-10">
													<div class="input-group input-append date mb5" id="datePicker" style="left:5px">
														<input type="text" class="fecha form-control" name="" id="finModalidad"/>
														<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
													</div>
												</div>
											</div>
										</div>
									</div>
									<!--CANTIDAD DE INTEGRANTES POR EQUIPO-->
									<div class="col-md-2 caja">
										<div class="form-group">
										  <label control-label>Integrantes:</label>
											<!-- MINIMO -->
											<div class="col-md-12 mb5">
												<!-- <div class="col-md-4">
													<label class="control-label">Min.</label>
												</div> -->
												<div class="col-md-12">
													<input type="text" class="form-control" name="" id="integrantes" placeholder="Cant. Integrantes">
												</div>
											</div>
											<div class="clearfix"></div>
											<!-- MAXIMO -->
											<!-- <div class="col-md-12 mb5">
												<div class="col-md-4">
													<label class="control-label">Max.</label>
												</div>
												<div class="col-md-8">
													<input type="text" class="form-control" name="" id="maxIntegrantes">
												</div>
											</div> -->
										</div>
									</div>
									<!--SEXO DE INTEGRANTES POR EQUIPO-->
									<div class="col-md-3 caja">
										<div class="form-group">
										  <label control-label>Sexo:</label>
											<!-- MUJERES -->
											<div class="col-md-12 mb5">
												<div class="col-md-7">
													<label class="control-label">Cant. Mujeres</label>
												</div>
												<div class="col-md-5">
													<input type="text" class="form-control" name="" id="cantMujeres">
												</div>
											</div>
											<div class="clearfix"></div>
											<!-- VARONES -->
											<div class="col-md-12 mb5">
												<div class="col-md-7">
													<label class="control-label">Cant. Varones</label>
												</div>
												<div class="col-md-5">
													<input type="text" class="form-control" name="" id="cantVarones">
												</div>
											</div>
										</div>
									</div>
									<!--CANT DE EQUIPOS PARTICIPANTES-->
									<div class="col-md-3">
										<div class="form-group">
											<div class="col-md-12 mb5">
												<div class="col-md-7">
													<label class="control-label">Nro. Equipos</label>
												</div>
												<div class="col-md-5">
													<input type="text" class="form-control" name="" id="nroEquipos">
												</div>
											</div>
											<div class="col-md-12 mb5">
												<div id="btnAgregar" class="btn btn-success btn-outline btn-block">Agregar</div>
											</div>
											<div class="col-md-12 mb5">
												<div class="btn btn-warning btn-outline btn-block">Descartar</div>
											</div>
										</div>
									</div>
									<div class="clearfix"></div>
									<hr>
									<div class="col-md-12">
										<table class="table table-bordered table-hover">
											<thead>
												<tr>
													<td class="text-center"><strong>Sede</strong></td>
													<td class="text-center"><strong>Modalidad</strong></td>
													<td class="text-center"><strong>Inicio</strong></td>
													<td class="text-center"><strong>Cierre</strong></td>
													<td class="text-center"><strong>Integrantes</strong></td>
													<td class="text-center"><strong>Mujeres</strong></td>
													<td class="text-center"><strong>Varones</strong></td>
													<td class="text-center"><strong>Nro. Equipos</strong></td>
													<td></td>
												</tr>
											</thead>
											<tbody id="tdDetEvento">

											</tbody>
										</table>
									</div>
								</div>
								<div class="panel-footer">
									<div class="btn btn-success" id="btnGrabar">Registrar Evento</div>
									<div class="btn btn-danger" id="btnDescartar">Descartar Evento</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- VENTANAS MODALES -->
	<!-- SEDES -->
	<div class="modal fade" id="sedesModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="col-md-4">
						<h4><strong>SEDES</strong></h4>
					</div>
					<div class="col-md-8" align="right">
						<!-- BOTON BUSCAR -->
						<div class="col-md-12">
							<div class="input-group">
								<span class="input-group-addon">Buscar</span>
								<input type="text" id="buscaSedes" class="form-control text-uppercase" placeholder="Buscar Sede">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body sedes">
					<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
					<s:if test="listaSedes.empty">
						<div class="alert alert-danger" role="alert"> <strong>No hay sedes registradas!</strong></div>
					</s:if>
					<table class="table table-striped table-condensed table-hover">
						<thead>
							<tr>
								<td class="text-center"><strong>Cod. Sede</strong></td>
								<td class="text-center"><strong>Sede</strong></td>
							</tr>
						</thead>
						<tbody id="tbSedes">
							<!-- INSERTAR ITERATOR -->
							<s:iterator value="listaSedes">
								<tr class="sede">
									<td class="text-center codSede"><s:property value="codSede"/></td>
									<td class="text-center nomSede"><s:property value="nomSede"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<div class="col-md-4 text-left">
						<div class="btn btn-success" id="btnTodo">Seleccionar Todo</div>
					</div>
					<div class="col-md-8 text-right">
						<div id="addSede" class="btn btn-primary" data-toggle="modal" data-target="#sedesModal">Aceptar</div>
						<div class="btn btn-warning" id="btnLimpiarSedes">Limpiar</div>
						<div data-toggle="modal" data-target="#sedesModal" class="btn btn-default btnCancelar">Cancelar</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- MODALIDADES -->
	<div class="modal fade" id="modalModalidades" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="col-md-4">
						<h4><strong>MODALIDADES</strong></h4>
					</div>
					<div class="col-md-8" align="right">
						<!-- BOTON BUSCAR -->
						<div class="col-md-12">
							<div class="input-group">
								<span class="input-group-addon">Buscar</span>
								<input type="text" id="buscaModalidades" class="form-control text-uppercase" placeholder="Buscar Modalidad">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body modalidades">
					<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
					<s:if test="listaModalidades.empty">
						<div class="alert alert-danger" role="alert"> <strong>No hay modalidades registradas!</strong></div>
					</s:if>
					<table class="table table-striped table-condensed table-hover">
						<thead>
							<tr>
								<td class="text-center"><strong>Modalidad</strong></td>
								<td class="text-center"><strong>Tipo</strong></td>
							</tr>
						</thead>
						<tbody id="tbModalidad">
							<!-- INSERTAR ITERATOR -->
							<s:iterator value="listaModalidades">
								<tr class="modalidad">
									<input type="hidden" class="codModalidad" value=<s:property value='codigo'/>>
									<td class="text-center descripcion"><s:property value="descripcion"/></td>
									<td class="text-center tipo"><s:property value="tipo"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<div id="addModalidad" class="btn btn-primary" data-toggle="modal" data-target="#modalModalidades">Seleccionar</div>
					<div data-toggle="modal" data-target="#modalModalidades" class="btn btn-default btnCancelar">Cancelar</div>
				</div>
			</div>
		</div>
	</div>

	<!-- <jsp:include page="footer.jsp"/> -->
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<%-- <script type="text/javascript" src="js/validatorEventos.js"></script> --%>
	<script type="text/javascript" src="js/fechas.js"></script>
	<script type="text/javascript" src="js/eventos.js"></script>
</body>
</html>
