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


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3">
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
							  <div class="col-md-6">
								<input type="text" class="form-control" placeholder="Num. Ficha">
							  </div>
								<div class="col-md-3">
									<div class="btn btn-primary">Buscar <span class="glyphicon glyphicon-search"></span></div>
								</div>
							</div>
							<hr>
							<!-- MONTO A PAGAR -->
							<div class="form-group">
								<div class="col-md-7">
									<label class="control-label">Monto a Pagar: </label>
								</div>
							  <div class="col-md-5">
							  	<s:textfield readonly="true" cssClass="form-control" name="monto" id="monto" />
							  </div>
							</div>
							<!-- MONTO PAGADO -->
							<div class="form-group">
								<div class="col-md-7">
									<label class="control-label">Pagado: </label>
								</div>
							  <div class="col-md-5">
							  	<s:textfield  name="pagado" cssClass="form-control" placeholder="Pagado" />
							  </div>
							</div>
							<div class="col-md-12 text-center">
								<!-- <button class="btn btn-primary" type="button" id="btnNuevo">Registrar Nuevo</button> -->
								<button class="btn btn-success" type="button" id="btnPagar">Pagar</button>
								<button class="btn btn-warning" type="button" id="btnCancelar">Cancelar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-5" align="left">
								<h5><strong>INFORMACION DE FICHA</strong></h5>
							</div>
						</div>
					</div>
					<div class="panel-body buscar">
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
						<s:if test="listaCategoria.empty">
 							<div class="alert alert-danger" role="alert"> <strong>No existe la ficha ingresada!</strong></div>
						</s:if>
						
						</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>

	<%@ include file="footer.jsp" %>
	<script src="https://checkout.culqi.com/v2"></script>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/pagos.js"></script>
</body>
</html>
