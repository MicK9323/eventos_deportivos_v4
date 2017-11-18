<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ficha de Inscripcion</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/alertify.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/themes/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

	<jsp:include page="menu.jsp"></jsp:include>


				<!-- VENTANA MODAL -->
				<div class="modal fade" id="modalidadModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Modalidades Disponibles</h4>
							</div>
							<div class="modal-body">
								<table class="table table-striped table-condensed">
									<thead>
										<tr>
											<th class="col-md-1"></th>
											<th class="col-md-3">Descripcion</th>
											<th class="col-md-2">Cant. Jugadores</th>
											<th class="col-md-1">Disponibles</th>
											<th class="col-md-2">Estado</th>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="detalleEvento">
											<tr class="mod">
												<input type="hidden" class="cod_modalidad" value='<s:property value="cod_modalidad"/>'>
												<input type="hidden" class="tipo" value='<s:property value="tipoModalidad"/>'>
												<input type="hidden" class="inicio" value='<s:property value="fec_inicio" />'>
												<input type="hidden" class="fin" value='<s:property value="fec_fin" />'>
												<input type="hidden" class="varones" value='<s:property value="cantVarones"/>'>
												<input type="hidden" class="mujeres" value='<s:property value="cantMujeres"/>'>
												<td><a class="f20 enlace-ico"><span class="glyphicon glyphicon-ok"></span></a></td>
												<td><label class="control-label nom_modalidad"><s:property value="nomModalidad" /></label></td>
												<td><label class="control-label integrantes"><s:property value="cantIntegrantes" /></label></td>
												<td><label class="control-label disponibles"><s:property value="disponibles" /></label></td>
												<td><label class="control-label estado"><s:property value="nomEstado" /></label></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
							<div class="modal-footer">
								<div class="col-md-3">
									<div id="addModalidad" class="form-control btn btn-success"
										data-toggle="modal" data-target="#modalidadModal">Aceptar</div>
								</div>
								<!-- <div class="col-md-3">
									<div id="btnLimpiar" class="form-control btn btn-warning">Deshacer</div>
								</div> -->
							</div>
						</div>
					</div>
				</div>
				<!-- VENTANA MODAL FIN -->
	<!-- SET -->
	<%-- <s:set name="descEvento" value="nomEvento" />
	<s:set name="codEvento" value="codEvento" /> --%>
	<s:set name="alerta" value="mensaje" />
	<s:hidden name="delegado.idRol" id="rol"/>
	<s:hidden name="delegado.sexo" id="sexoDelegado"/>
	<!-- FICHA DE INSCRIPCION -->
	<div class="container">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-4" align="left">
								<h4>Ficha de Inscripción</h4>
							</div>
						</div>
					</div>
					<div class="panel-body">
						<form id="formFicha" class="form-horizontal">
							<!-- DESCRIPCION DE EVENTo -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Evento:</label>
								</div>
								<div class="col-md-4">
									<s:label name="evento.desc_evento" cssClass="control-label" id="" />
									<s:hidden id="codEvento" name="evento.cod_evento" />
									<%-- <label id="nom_evento" class="control-label"><s:property value="#descEvento" /></label> --%>
									<!-- <input type="hidden" id="codEvento" name="codEvento" value=<s:property value='#codEvento'/>> -->
								</div>
							</div>
							<!-- Nombre de Equipo -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label" for="equipo">Nombre de Equipo:</label>
								</div>
								<div class="col-md-5">
									<input class="form-control text-uppercase" type="text" id="NomEquipo" name="NomEquipo" placeholder="Ingrese un nombre para su equipo" required="true">
									<div id="alerta" style="margin-top: 5px;"><label></label></div>
								</div>
								<!-- <div class="col-md-1">
									<div id="btnValidarNombre" class="btn btn-success">Validar</div>
								</div> -->
							</div>
							<!--  DNI DELEGADO -->
							<s:if test="#session.usuario.idRol == 3">
								<div class="alert alert-info" role="alert">El primer jugador ingresado cumplira el rol de delegado</div>
							</s:if>
							<s:else>
								<div class="form-group">
									<div class="col-md-3">
										<label class="control-label" for="equipo">Dni Delegado:</label>
									</div>
									<div class="col-md-4">
										<s:textfield readonly="true" cssClass="form-control text-uppercase"  name="delegado.dni_jugador" id="delegado" placeholder="DNI DELEGADO" />
									</div>
								</div>
							</s:else>
							<!-- SELECCIONAR MODALIDAD -->
							<div class="form-group">
								<div class="col-md-3">
									<div id="btnModalidad" class="form-control btn btn-warning">Seleccionar Modalidad</div>
								</div>
							</div>
							<!-- DESCRIPCION DE MODALIDAD -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Modalidad:</label>
								</div>
								<div class="col-md-6">
									<label id="mod1" class="control-label"></label>
									<input type="hidden" name="codModalidad" id="codModalidad">
								</div>
							</div>
							<!-- FECHA DE INICIO -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Fec. Inicio:</label>
								</div>
								<div class="col-md-4">
									<label id="inicio" class="control-label"></label>
								</div>
							</div>
							<!-- FECHA DE FIN -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Fec. Fin:</label>
								</div>
								<div class="col-md-4">
									<label id="fin" class="control-label"></label>
								</div>
							</div>
							<!-- DELEGADO -->
							<!-- <div class="form-group">
								<div class="col-md-3">
									<label class="control-label" for="equipo">Delegado</label>
								</div>
								<div class="col-md-4">
									<input class="form-control" type="text" name="dni"
										placeholder="DNI" required="true">
								</div>
								<div class="col-md-2">
									<button id="btnValidarDelegado" class="btn btn-success">Validar</span></button>
								</div>
							</div> -->

							<!-- INTEGRANTES -->
							<legend>Integrantes</legend>
							<div class="form-group" id="validador">
								<div class="col-md-12" style="margin-bottom: 10px;">
									<div class="col-md-3">
										<label class="control-label" for="equipo">Buscar</label>
									</div>
									<div class="col-md-4">
										<input class="form-control" type="text" id="dniJugador" name="dniJugador"
											placeholder="DNI">
									</div>
									<div class="col-md-1">
										<div id="btnValidarJugador" class="btn btn-success">Validar</div>
									</div>
								</div>
								<div class="col-md-12 text-center">
									<div class="col-md-4">
										<div class="col-md-12"><label id="total" class="text-primary"><strong>Integrantes: </strong></label></div>
										<div class="col-md-12"><h5 id="integrantes" class="text-danger"></h5></div>
									</div>
									<%-- <div class="col-md-3">
										<label class="text-primary"><strong>Ingresados: </strong></label>
										<h5 id="ingresados" class="text-primary"></h5>
									</div> --%>
									<div class="col-md-4">
										<div class="col-md-12"><label id="totalVarones" class="text-primary"><strong>Cant. Varones: </strong></label></div>
										<div class="col-md-12"><h5 id="contvarones" class="text-danger"></h5></div>
									</div>
									<div class="col-md-4">
										<div class="col-md-12"><label id="totalMujeres" class="text-primary"><strong>Cant. Mujeres: </strong></label></div>
										<div class="col-md-12"><h5 id="contmujeres" class="text-danger"></h5></div>
									</div>
								</div>
								<%-- <div id="varones" class="col-md-12">
									<div class="col-md-4">
										<label class="text-danger"><strong>Cant. Varones: </strong></label>
										<h5 id="maxvarones" class="text-danger"></h5>
									</div>
								</div> --%>
							</div>
							<div class="col-md-6 col-md-offset-3">
								<label class="text-warning" id="msg1"></label>
							</div>
							<hr>
							<table class="table table-bordered table-condensed table-hover">
								<thead>
									<tr>
										<th class="col-md-2 text-center">DNI</th>
										<th class="col-md-5 text-center">Nombres y Apellidos</th>
										<th class="col-md-1 text-center">Edad</th>
										<th class="col-md-2 text-center">Sexo</th>
										<th class="col-md-1 text-center">Sede</th>
										<th class="col-md-1 text-center"></th>
									</tr>
								</thead>
								<tbody id="tbEquipo">
									<s:if test="#session.usuario.idRol != 3">
										<tr class="bg-success delegado">
											<td class="col-md-2"> <s:label name="delegado.dni_jugador" /> </td>
											<td class="col-md-4"><s:label name="delegado.nom_jugador" /></td>
											<td class="col-md-1"><s:label name="delegado.edad" /></td>
											<td class="col-md-2"><s:label name="delegado.sexo" /></td>
											<td class="col-md-2"><s:label name="delegado.nomSede" /></td>
											<td class="col-md-1 text-center"><span class="glyphicon glyphicon-ban-circle bloqueado" title="Opción Bloqueada"></span></td>
										</tr>
									</s:if>									
								</tbody>
							</table>

							<!-- COD PAGO -->
							 <!-- <div class="form-group">
								<div class="col-md-3">
									<label class="control-label" for="equipo">Cod. Pago</label>
								</div>
								<div class="col-md-5">
									<input class="form-control" id="codPago" type="text" name="codPago">
								</div>
								<div class="col-md-1">
									<div id="btnValidarJugador" class="btn btn-success">Validar</div>
								</div>
							</div> -->
							<!-- BOTONES -->
							<div class="col-md-6 col-md-offset-3 text-center panel-footer">
								<id id="btnGrabar" class="circular btn btn-success">
									Grabar</id>
								<div id="btnReset" class="circular btn btn-danger">
									Descartar</div>
								<!-- <button class="circular btn btn-primary" type="">
									Salir</button> -->
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/validator.js"></script>
	<script type="text/javascript" src="js/inscripcionV2.js"></script>
</body>
</html>
