<!DOCTYPE html>
<%@page import="beans.JugadorDTO"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registrar Jugador</title>
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
		<!-- <div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="col-md-4">
					<a href="listarEventos" id="btnAddEvento" class="btn btn-warning">
						<span class="glyphicon glyphicon-arrow-left"></span> <strong>Volver al listado</strong>
					</a>
				</div>
				<div class="col-md-6 titulo text-center">
					<h4><strong>REGISTRO DE JUGADORES</strong></h4>
				</div>
			</div>
		</div> -->
	</div>
	<!-- DATOS DE JUGADOR -->
	<div class="container">
		<form class="form-horizontal" id="formEvento" action="" method="post">
			<div class="row">
				<div class="col-md-12">
					<div class="panel-group" id="acordeon">
						<!-- DATOS DEL JUGADOR -->
						<div class="panel panel-primary">
							<div class="panel-heading">
								<strong>DATOS DE JUGADOR</strong>
							</div>
							<div class="panel-body">
								<form class="form-horizontal" action="" method="post">
									<div class="row">
										<div class="col-md-6">
											<!-- DNI -->
											<div class="form-group">
											  <div class="col-md-2">
											  	<label for="dni" class="control-label">DNI: </label>
											  </div>
											  <div class="col-md-4">
											  	<input type="text" name="dni" class="form-control text-uppercase" id="dni" placeholder="DNI" required>
											  </div>
											</div>
											<!-- NOMBRES -->
											<div class="form-group">
											  <div class="col-md-2">
											  	<label for="nombre" class="control-label">Nombres: </label>
											  </div>
											  <div class="col-md-9">
											  	<input type="text" name="nombre" class="form-control text-uppercase" id="nombre" placeholder="Nombres" required>
											  </div>
											</div>
											<!-- APELLIDOS -->
											<div class="form-group">
											  <div class="col-md-2">
											  	<label for="apellido" class="control-label">Apellidos: </label>
											  </div>
											  <div class="col-md-9">
											  	<input type="text" name="apellido" class="form-control text-uppercase" id="apellido" placeholder="Apeliidos" required>
											  </div>
											</div>
											<!-- FECHA DE NACIMIENTO Y EDAD -->
											<div class="row">
												<div class="col-md-6">
													<div class="col-md-10">
														<div class="form-group">
															<div class="input-group input-append date" id="datePicker" >
																<input type="text" required class="fecha form-control" name="fecNacimiento" id="fecNacimiento" placeholder="Fec. Nacimiento"/>
																<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
															</div>
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="col-md-10">
														<div class="form-group">
															<input type="text" required class="form-control" name="edad" id="edad" placeholder="Edad"/>
														</div>
													</div>
												</div>
											</div>
											<!-- <div class="form-group">
												<div class="col-md-2">
													<label for="fecNacimiento" class="control-label">Nacimiento:</label>
												</div>
												<div class="col-md-5">
													<div class="input-group input-append date" id="datePicker" >
														<input type="text" required class="fecha form-control" name="fecNacimiento" id="fecNacimiento" placeholder="Fec. Nacimiento"/>
														<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
													</div>
												</div>
											</div> -->
											<!-- EDAD -->
											<!-- <div class="form-group">
												<div class="col-md-2">
													<label for="edad" class="control-label">Edad:</label>
												</div>
												<div class="col-md-5">
													<input type="text" required class="form-control" name="edad" id="edad" placeholder="Edad"/>
												</div>
											</div> -->
											<!-- SEXO -->
											<div class="form-group">
												<div class="col-md-2">
													<label for="sexo" class="control-label">Sexo: </label>
												</div>
												<div class="col-md-5">
													<select class="form-control" name="sexo" id="sexo">
														<option value="MASCULINO">MASCULINO</option>
														<option value="FEMENINO">FEMENINO</option>
													</select>
												</div>
											</div>
											<!-- ESTADO CIVIL -->
											<div class="form-group">
												<div class="col-md-3">
													<label for="sexo" class="control-label">Est. Civil: </label>
												</div>
												<div class="col-md-4">
													<select class="form-control" name="sexo" id="sexo">
														<option value="1">SOLTERO</option>
														<option value="2">CASADO</option>
														<option value="3">VIUDO</option>
														<option value="4">DIVORCIADO</option>
													</select>
												</div>
											</div>
											<!-- TELEFONOS -->
											<div class="row">
												<div class="col-md-6">
													<div class="form-group">
														<div class="col-md-10">
															<input class="form-control" type="text" name="telfFijo" id="telfFijo" placeholder="Teléfono Fijo (Opcional)">
														</div>
													</div>
												</div>
												<div class="col-md-6">
													<div class="form-group">
														<div class="col-md-10">
															<input class="form-control" type="text" name="telfMovil" id="telfMovil" placeholder="Teléfono Celular" required>
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
													<input type="text" class="form-control text-uppercase" name="dirUsuario" id="dirUsuario" placeholder="Direccion">
												</div>
											</div>
											<!-- CORREO -->
											<div class="form-group">
												<div class="col-md-3">
													<label class="control-label" for="email">Correo:</label>
												</div>
												<div class="col-md-8">
													<input type="email" class="form-control text-lowercase" name="email" id="email" placeholder="username@example.com">
												</div>
											</div>
										</div>
										<div class="col-md-6">
											<!-- FOTO -->
											<div class="row">
												<div class="col-md-6">
													<div class="thumbnail">
														<img class="img-responsive" src="img/imgUser.png" id="imagePreview" alt="">
													</div>
												</div>
												<div class="col-md-4">
													<div class="form-group">
														<input type="file" name="subirImagen" id="subirImagen" class="hide"/>
														<label for="subirImagen" class="btn btn-default">Seleccionar Foto <span class="glyphicon glyphicon-camera"></span></label>
													</div>
													<div class="form-group">
														<div data-toggle="modal" data-target="#sedesModal" id="btnSede" class="btn btn-primary">Seleccionar Sede</div>
														<label class="control-label text-info" id="nomSedes"></label>
													</div>
												</div>
											</div>
										</div>
									</div>
								</form>
							</div>
							<div class="panel-footer">
								<div class="text-right">
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
					<div class="alert alert-danger" role="alert"> <strong>No hay sedes registradas!</strong></div>
					<table class="table table-striped table-condensed table-hover">
						<thead>
							<tr>
								<td class="text-center"><strong>Cod. Sede</strong></td>
								<td class="text-center"><strong>Sede</strong></td>
							</tr>
						</thead>
						<tbody id="tbSedes">

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
	</div>



	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>

	<script type="text/javascript" src="js/fechas.js"></script>
	<script type="text/javascript" src="js/usuarios.js"></script>
</body>
</html>
