<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro de Pagos</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/alertify.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/themes/bootstrap.min.css">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/back.css">
<link rel="stylesheet" type="text/css" href="css/pagos.css">
</head>
<body style="padding-top: 70px;">


	<s:if test="#session.usuario.idRol != 3">
		<jsp:include page="menu.jsp" />
	</s:if>
	<s:else>
		<jsp:include page="menuAdmin.jsp" />
	</s:else>


	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>DATOS DE PAGO</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" id="formCategoria">
							<!-- DESCRIPCION -->
							<div class="form-group">
								<div class="col-md-6">
									<s:textfield name="ficha" id="numFicha"
										placeholder="Num. Ficha" cssClass="form-control" value="" required="true"/>
								</div>
								<div class="col-md-3">
									<div id="btnconsulta" class="btn btn-primary">
										Buscar <span class="glyphicon glyphicon-search"></span>
									</div>
								</div>
							</div>
							<hr>
							<!-- MONTO A PAGAR -->
							<div class="form-group">
								<div class="col-md-7">
									<label class="control-label">Monto a Pagar: </label>
								</div>
								<div class="col-md-5">
									<s:label cssClass="control-label" name="monto" id="monto" />
								</div>
							</div>
							<div class="col-md-12 text-center">
								<button class="btn btn-success" type="button" id="btnPagar">Pagar</button>
									<!-- data-toggle="modal" data-target="#pago">Pagar</button> -->
								<button class="btn btn-warning" type="button" id="btnCancelar">Cancelar</button>
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
								<h5>
									<strong>INFORMACION DE FICHA</strong>
								</h5>
							</div>
						</div>
					</div>
					<div class="panel-body buscar">
						<s:if test="datos.empty">
							<div class="alert alert-danger" role="alert">
								<strong>No existe la ficha ingresada!</strong>
							</div>
						</s:if>
						<form class="form-horizontal">
							<!-- Cod. Ficha y Fec. Inscripcion -->
							<div class="col-md-12 pdl0 pdr0">
								<div class="col-md-6">
									<div class="form-group">
										<div class="col-md-5 pdl0">
											<label class="control-label">Ficha N°:</label>
										</div>
										<div class="col-md-7 pdl30">
											<s:textfield name="datos.cod_ficha" id="codFicha"
												cssClass="form-control" readonly="true" />
										</div>
									</div>
								</div>
								<div class="col-md-6 pdr0">
									<div class="form-group">
										<div class="col-md-5">
											<label class="control-label">Inscripción:</label>
										</div>
										<div class="col-md-7 pdl30">
											<s:textfield name="datos.fec_inscripcion" id="fecInscripcion"
												cssClass="form-control" readonly="true" />
										</div>
									</div>
								</div>
							</div>
							<!-- nombre evento -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Evento:</label>
								</div>
								<div class="col-md-9">
									<s:textfield name="datos.desc_evento" id="nomEvento"
										cssClass="form-control" readonly="true" />
								</div>
							</div>
							<!-- nombre modalidad -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Modalidad:</label>
								</div>
								<div class="col-md-9">
									<s:textfield name="datos.desc_modalidad" id="nomModalidad"
										cssClass="form-control" readonly="true" />
								</div>
							</div>
							<!-- fec inicio y fec cierre -->
							<div class="col-md-12 pdl0 pdr0">
								<div class="col-md-6">
									<div class="form-group">
										<div class="col-md-5 pdl0">
											<label class="control-label">Fec. Inicio:</label>
										</div>
										<div class="col-md-7 pdl30">
											<s:textfield name="datos.fec_inicio" id="fecInicio"
												cssClass="form-control" readonly="true" />
										</div>
									</div>
								</div>
								<div class="col-md-6 pdr0">
									<div class="form-group">
										<div class="col-md-5">
											<label class="control-label">Fec. Cierre:</label>
										</div>
										<div class="col-md-7 pdl30">
											<s:textfield name="datos.fec_fin" id="fecCierre"
												cssClass="form-control" readonly="true" />
										</div>
									</div>
								</div>
							</div>
							<!-- Nombre de equipo -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Equipo:</label>
								</div>
								<div class="col-md-9">
									<s:textfield name="datos.nom_equipo" id="nomEquipo"
										cssClass="form-control" readonly="true" />
								</div>
							</div>
							<!-- Nombre de equipo -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Cod. Equipo:</label>
								</div>
								<div class="col-md-3">
									<s:textfield name="datos.cod_equipo" id="codEquipo"
										cssClass="form-control" readonly="true" />
								</div>
							</div>
							<!-- Nombre de delegado -->
							<div class="form-group">
								<div class="col-md-3">
									<label class="control-label">Delegado:</label>
								</div>
								<div class="col-md-9">
									<s:textfield name="datos.delegado" id="nomDelegado"
										cssClass="form-control" readonly="true" />
								</div>
							</div>
							<div class="clearfix"></div>
							<hr>
							<%-- <div class="text-center">
								<table class="table table-hover table-condensed table-bordered">
									<thead>
										<tr>
											<td class="text-center"><strong>DNI</strong></td>
											<td class="text-center"><strong>Nombres</strong></td>
											<td class="text-center"><strong>Edad</strong></td>
											<td class="text-center"><strong>Sexo</strong></td>
											<td class="text-center"><strong>Sede</strong></td>
										</tr>
									</thead>
									<tbody>
										<s:iterator value="equipo">
											<tr>
												<td><s:property value="dni_jugador" /></td>
												<td><s:property value="nom_jugador" /></td>
												<td><s:property value="edad" /></td>
												<td><s:property value="sexo" /></td>
												<td><s:property value="nomSede" /></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div> --%>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>

	<!-- modal de pasarela de pago -->
	<div class="modal fade" id="pago" tabindex="-1">
		<div class="modal-pago">
			<!-- CREDIT CARD FORM STARTS HERE -->
			<div class="panel panel-default credit-card-box">
				<div class="panel-heading display-table">
					<div class="row display-tr">
						<h3 class="panel-title display-td">Detalle de Pago</h3>
						<div class="display-td">
							<img class="img-responsive pull-right"
								src="http://i76.imgup.net/accepted_c22e0.png">
						</div>
					</div>
				</div>
				<div class="panel-body">
					<form role="form" id="payment-form" method="POST"
						action="javascript:void(0);">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<label for="cardNumber">N° de Tarjeta</label>
									<div class="input-group">
										<input type="tel" class="form-control" name="cardNumber"
											placeholder="N° Tarjeta" autocomplete="cc-number"
											required autofocus /> <span
											class="input-group-addon"><i class="fa fa-credit-card"></i></span>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-7 col-md-7">
								<div class="form-group">
									<label for="cardExpiry"><span class="hidden-xs">Fec. Expiración</span></label>
									<input type="tel" class="form-control" name="cardExpiry" placeholder="MM / YY"
									autocomplete="cc-exp" required />
								</div>
							</div>
							<div class="col-xs-5 col-md-5 pull-right">
								<div class="form-group">
									<label for="cardCVC">CVV</label> <input type="tel"
										class="form-control" name="cardCVC" placeholder="CVV"
										autocomplete="cc-csc" required />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<button id="btnProcesar" class="subscribe btn btn-success btn-lg btn-block"
									type="button">Procesar Pago</button>
							</div>
						</div>
						<div class="row" style="display: none;">
							<div class="col-xs-12">
								<p class="payment-errors"></p>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- CREDIT CARD FORM ENDS HERE -->
		</div>
	</div>


	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/pagos.js"></script>
	<!-- Vendor libraries -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>
	<!-- If you're using Stripe for payments -->
	<script type="text/javascript" src="https://js.stripe.com/v2/"></script>	
</body>
</html>
