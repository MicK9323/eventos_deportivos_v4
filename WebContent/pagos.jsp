<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Pagos</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/alertify.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/themes/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/back.css">
</head>
<body style="padding-top: 70px;">

	<jsp:include page="menuAdmin.jsp"/>


	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>DATOS DE PAGO</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" id="formCategoria">
							<s:set name="codCategoria" value="categoria.codigo" />
							<s:set name="idOpcion" value="opcion" />
							<input type="hidden" id="codigo" name="categoria.codigo" value=<s:property value='codCategoria'/>>
							<input type="hidden" id="opcion" value=<s:property value='idOpcion'/>>
							<!-- DESCRIPCION -->
							<div class="form-group">
							  <div class="col-md-4">
								<input type="text" class="form-control" placeholder="Num. Ficha">
							  </div>
								<div class="col-md-2">
									<div class="btn btn-primary">Buscar <span class="glyphicon glyphicon-search"></span></div>
								</div>
							</div>
							<hr>
							<!-- MONTO A PAGAR -->
							<div class="form-group">
								<div class="col-md-4">
									<label class="control-label">Monto a Pagar: </label>
								</div>
							  <div class="col-md-4">
							  	<s:textfield readonly="true" cssClass="form-control" name="monto" />
							  </div>
							</div>
							<!-- MONTO PAGADO -->
							<div class="form-group">
								<div class="col-md-4">
									<label class="control-label">Pagado: </label>
								</div>
							  <div class="col-md-4">
							  	<s:textfield  name="categoria.edadMax" cssClass="form-control" placeholder="Pagado" />
							  </div>
							</div>
							<div class="col-md-12 text-center">
								<!-- <button class="btn btn-primary" type="button" id="btnNuevo">Registrar Nuevo</button> -->
								<button class="btn btn-success" type="button" id="btnGuardar"></button>
								<button class="btn btn-warning" type="button" id="btnReset">Cancelar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-7">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-5" align="left">
								<h5><strong>INFORMACION DE FICHA</strong></h5>
							</div>
							<div class="col-md-7" align="right">
								<!-- BOTON BUSCAR -->
								<%-- <div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon">Buscar</span>
										<input type="text" id="buscador" class="form-control" placeholder="Buscar Categoria">
									</div>
								</div> --%>
								<!-- BOTON BUSCAR -->
							</div>
						</div>
					</div>
					<div class="panel-body buscar">
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
						<s:if test="listaCategoria.empty">
 							<div class="alert alert-danger" role="alert"> <strong>No existe la ficha ingresada!</strong></div>
						</s:if>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Ficha N°: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="numFicha" id="numFicha" value="XXXXX" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Fec. Registro: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="fecRegistro" id="fecRegistro" value="xx/xx/xxxx" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Evento: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="nomEvento" id="nomEvento" value="Evento Consultado" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Modalidad: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="nomModalidad" id="nomModalidad" value="Modalidad" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Inicio: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="fecInicio" id="fecInicio" value="xx/xx/xxxx" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Cierre: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="fecFin" id="fecFin" value="xx/xx/xxxx" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Equipo: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="nomEquipo" id="nomEquipo" value="LOS NYUPI" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-2">
									<label class="control-label">Código: </label>
								</div>
								<div class="col-md-4">
									<s:label cssClass="control-label" name="codEquipo" id="codEquipo" value="E0012" />
								</div>
							</div>
						</div>	
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>

	<%@ include file="footer.jsp" %>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/categoria.js"></script>
</body>
</html>
