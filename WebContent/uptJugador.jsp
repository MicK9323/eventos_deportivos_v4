<%@page import="beans.JugadorDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Actualizar Jugador</title>
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
				response.sendRedirect("expirado.jsp");
			}
		%>
	<s:if test="#session.usuario.idRol != 3">
		<jsp:include page="menu.jsp" />
	</s:if>
	<s:else>
		<jsp:include page="menuAdmin.jsp" />
	</s:else>

	<div class="container-fluid">
	</div>
	<!-- DATOS DE JUGADOR -->
	<div class="container">
		<form class="form-horizontal" id="formJugador" action="registraJugador" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-12">
					<div class="panel-group">
						<!-- DATOS DEL JUGADOR -->
						<div class="panel panel-primary">
							<div class="panel-heading">
								<strong>DATOS DE JUGADOR</strong>
							</div>
							<div class="panel-body">
									<div class="row">
										<div class="col-md-6">
											<!-- DNI -->
											<div class="form-group">
											  <div class="col-md-2">
											  	<label for="dni" class="control-label">DNI: </label>
											  </div>
											  <div class="col-md-4">
											  	<s:textfield name="jugador.dni_jugador" id="dni" cssClass="form-control" placeholder="DNI" readonly="true" />
											  </div>
											</div>
											<!-- PASSWORD -->
											<div class="form-group">
											  <div class="col-md-2">
											  	<label for="dni" class="control-label">PASSWORD: </label>
											  </div>
											  <div class="col-md-4">
											  	<s:password name="jugador.clave" id="clave" cssClass="form-control" required="true" />
											  </div>
											</div>
											<!-- NOMBRES -->
											<div class="form-group">
											  <div class="col-md-2">
											  	<label for="nombre" class="control-label">Nombres: </label>
											  </div>
											  <div class="col-md-9">
											  	<s:textfield name="jugador.nom_jugador" id="nombre" cssClass="form-control text-uppercase" placeholder="Nombres" readonly="true" />
											  </div>
											</div>
											<!-- APELLIDOS -->
											<div class="form-group">
											  <div class="col-md-2">
											  	<label for="apellido" class="control-label">Apellidos: </label>
											  </div>
											  <div class="col-md-9">
											  	<s:textfield name="jugador.ape_jugador" id="apellido" cssClass="form-control text-uppercase" placeholder="Apellidos" readonly="true" />
											  </div>
											</div>
											<!-- FECHA DE NACIMIENTO Y EDAD -->
											<div class="row">
												<div class="col-md-6">
													<div class="col-md-10">
														<div class="form-group">
															<div class="input-group input-append date" id="datePicker" >
																<s:textfield name="jugador.fec_nac" id="fecNac" cssClass="fecha form-control" placeholder="Fec. Nacimiento" readonly="true" />
																<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-md-10">
														<div class="form-group">
															<s:textfield name="jugador.edad" id="edad" cssClass="form-control" placeholder="Edad"  readonly="true" />
														</div>
													</div>
												</div>
											</div>
											<!-- SEXO -->
											<div class="form-group">
												<div class="col-md-2">
													<label for="sexo" class="control-label">Sexo: </label>
												</div>
												<div class="col-md-5">
													<s:select name="jugador.sexo"
														list="#{'MASCULINO':'MASCULINO','FEMENINO':'FEMENINO'}"
														headerKey="-1"
														headerValue="[Seleccione]" id="sexo" cssClass="form-control" readonly="true">
													</s:select>
												</div>
											</div>
											<!-- ESTADO CIVIL -->
											<div class="form-group">
												<div class="col-md-3">
													<label for="sexo" class="control-label">Est. Civil: </label>
												</div>
												<div class="col-md-4">
													<s:select name="jugador.estCivil"
														list="#{'SOLTERO':'SOLTERO','CASADO':'CASADO',
																'VIUDO':'VIUDO','DIVORCIADO':'DIVORCIADO'}"
														headerKey="-1"
														headerValue="[Seleccione]" id="estCivil" cssClass="form-control">
													</s:select>
												</div>
											</div>
											<!-- TELEFONOS -->
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<div class="col-md-10">
															<s:textfield name="jugador.telfDomicilio" id="telfFijo"
																cssClass="form-control" placeholder="Teléfono Fijo (Opcional)" />
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<div class="col-md-10">
															<s:textfield name="jugador.telfMovil" id="telfMovil"
																cssClass="form-control" placeholder="Teléfono Celular" required="true" />
														</div>
													</div>
												</div>
											</div>
											<!-- DIRECCION -->
											<div class="form-group">
												<div class="col-md-3">
													<label class="control-label" for="dirUsuario">Direccion</label>
												</div>
												<div class="col-md-8">
													<s:textfield name="jugador.domicilio" id="direccion"
																cssClass="form-control text-uppercase" placeholder="Direccion de domicilio" required="true" />
												</div>
											</div>
											<!-- CORREO -->
											<div class="form-group">
												<div class="col-md-3">
													<label class="control-label" for="email">Correo:</label>
												</div>
												<div class="col-md-8">
													<s:textfield type="email" name="jugador.email" id="email"
																cssClass="form-control" placeholder="username@example.com" required="true" />
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<!-- FOTO -->
											<div class="row">
												<div class="col-md-6">
													<div class="thumbnail">
														<img class="img-responsive" src=" buscarFoto?dni=<s:property value="met.codificarBase64(jugador.dni_jugador)" /> " id="imagePreview" alt="">
													</div>
												</div>
												<div class="col-md-5">
													<div class="form-group">
														<div class="hide"><s:file name="jugador.foto" id="subirImagen" accept=".jpg,.png" /></div>
														<!-- <input type="file" name="foto" id="subirImagen" class="hide"/> -->
														<label for="subirImagen" class="btn btn-default">Seleccionar Foto <span class="glyphicon glyphicon-camera"></span></label>
														<p class="help-block">Tamaño máximo = 100KB</p>
													</div>
													<!-- <div class="form-group">
														<div data-toggle="modal" data-target="#sedesModal" id="btnSede" class="btn btn-primary">Seleccionar Sede</div>
														<label class="control-label text-info" id="nomSedes"></label>
													</div> -->
													<div class="form-group">
														<label class="control-label">Sedes</label>
														<s:select list="sedes" name="jugador.codSede"
															 listKey="codSede"
															 listValue="nomSede"
															 headerKey="-1"
															 headerValue="[SELECCIONE]" cssClass="form-control text-uppercase" readonly="true"/>
													</div>
													<div class="form-group">
														<label class="control-label">Perfil</label>
														<s:select list="roles" name="jugador.idRol"
															 listKey="idRol"
															 listValue="nomRol"
															 headerKey="-1"
															 headerValue="[SELECCIONE]" cssClass="form-control text-uppercase" readonly="true"/>
													</div>
												</div>
												<div class="col-md-12">
													<s:if test="mostrar == true">
					 									<div class="alert alert-info" role="alert"> <strong> <s:label name="msg" /> </strong></div>
													</s:if>
												</div>
											</div>
										</div>
									</div>
							</div>
							<div class="panel-footer">
								<div class="text-right">
									<a href="listaJugadores" class="btn btn-primary">Volver al listado</a>
									<input type="submit" class="btn btn-success" name="guardar" id="guardar" value="Guardar">
									<input type="reset" class="btn btn-warning" name="cancelar" id="cancelar" value="Cancelar">
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
	<%-- <div class="modal fade" id="sedesModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
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
					<s:if test="sedes.isEmpty">
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
							<s:iterator>

							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<div class="col-md-8 text-left">
						<div id="addSede" class="btn btn-primary" data-toggle="modal" data-target="#sedesModal">Aceptar</div>
						<div class="btn btn-warning" id="btnLimpiarSedes">Limpiar</div>
						<div data-toggle="modal" data-target="#sedesModal" class="btn btn-default btnCancelar">Cancelar</div>
					</div>
				</div>
			</div>
		</div>
	</div> --%>



	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>

	<script type="text/javascript" src="js/fechas.js"></script>
	<script type="text/javascript" src="js/usuarios.js"></script>
</body>
</html>
