<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento Sedes</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/alertify.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/themes/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/back.css">
</head>
<body style="padding-top: 70px;">
		<%
			JugadorDTO obj = (JugadorDTO) session.getAttribute("usuario");
			if(obj == null){
				response.sendRedirect("expirado.jsp");
			}
		%>
	<jsp:include page="menuAdmin.jsp"/>


	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>DATOS DE SEDE</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" id="formSede">
							<s:set name="codSede" value="sede.codSede" />
							<s:set name="idOpcion" value="opcion" />
							<input type="hidden" id="codigo" name="sede.codSede" value=<s:property value='codSede'/>>
							<input type="hidden" id="opcion" value=<s:property value='idOpcion'/>>
							<!-- NOMBRE -->
							<div class="form-group">
								<div class="col-md-2">
									<label class="control-label">Nombre:</label>
								</div>
							  <div class="col-md-10">
							  	<s:textfield id="nombre" name="sede.nomSede" cssClass="form-control text-uppercase" placeholder="Descripción" />
							  	<div id="alerta" style="margin-top: 5px;"><label></label></div>
							  </div>
							</div>
							<!-- DIRECCION -->
							<div class="form-group">
								<div class="col-md-2">
									<label class="control-label">Dirección</label>
								</div>
							  <div class="col-md-10">
							  	<s:textfield cssClass="form-control text-uppercase" name="sede.direccion" id="dirSede" placeholder="Dirección" />
							  </div>
							</div>
							<!-- TELEFONO -->
							<div class="form-group">
								<div class="col-md-2">
									<label class="control-label">Teléfono</label>
								</div>
								  <div class="col-md-6">
								  	<s:textfield cssClass="form-control" name="sede.telf" id="telf" placeholder="Teléfono" />
								  </div>
							</div>
							<div class="col-md-12 text-center">
								<!-- <button class="btn btn-primary" type="button" id="btnNuevo">Registrar Nuevo</button> -->
								<button class="btn btn-success" type="button" id="btnGuardar"></button>
								<button class="btn btn-warning" type="button" id="btnReset">Limpiar</button>
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
								<h5><strong>SEDES DISPONIBLES</strong></h5>
							</div>
							<div class="col-md-7" align="right">
								<!-- BOTON BUSCAR -->
								<div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon">Buscar</span>
										<input type="text" id="buscador" class="form-control" placeholder="Buscar Disciplina">
									</div>
								</div>
								<!-- FIN BOTON BUSCAR -->
							</div>
						</div>
					</div>
					<div class="panel-body buscar">
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
						<s:if test="listaDisciplina.empty">
 								<div class="alert alert-danger" role="alert"> <strong>No hay disciplinas registradas!</strong></div>
						</s:if>
						<!-- BUCLE DE ITERACION -->
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<td class="text-center col-md-2"><strong>Código</strong></td>
									<td class="text-center col-md-4"><strong>Nombre</strong></td>
									<td class="text-center col-md-2"><strong>Dirección</strong></td>
									<td class="text-center col-md-2"><strong>Teléfono</strong></td>
									<td class="text-center col-md-1"><strong></strong></td>
									<td class="text-center col-md-1"><strong></strong></td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="listaSedes">
				 						 <s:url id="idBuscar" action="buscaSede">
				 							<s:param name="sede.codSede" value="codSede"/>
										 </s:url>
									<tr class="cuadro">
										<td class="codigo"><s:property value="codSede"/></td>
										<td><s:property value="nomSede"/></td>
										<td><s:property value="direccion"/></td>
										<td><s:property value="telf"/></td>
										<td><s:a href="%{idBuscar}" cssClass="editar" ><span class="glyphicon glyphicon-pencil"></span></s:a></td>
										<td><a class="remove"><span class="glyphicon glyphicon-remove"></span></a></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						<!-- BUCLE DE ITERACION -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>


	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/sedes.js"></script>
</body>
</html>
