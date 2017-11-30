<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento Disciplina</title>
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
						<h4>DATOS DE DISCIPLINA</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" id="formDisciplina">
							<s:set name="codDisciplina" value="disciplina.codigo" />
							<s:set name="idOpcion" value="opcion" />
							<input type="hidden" id="codigo" name="disciplina.codigo" value=<s:property value='codDisciplina'/>>
							<input type="hidden" id="opcion" value=<s:property value='idOpcion'/>>
							<!-- DESCRIPCION -->
							<div class="form-group">
								<div class="col-md-4">
									<label class="control-label">Descripción</label>
								</div>
							  <div class="col-md-8">
							  	<s:textfield id="descripcion" name="disciplina.descripcion" cssClass="form-control text-uppercase" placeholder="Descripción" />
							  	<div id="alerta" style="margin-top: 5px;"><label></label></div>
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
								<h5><strong>DISCIPLINAS DISPONIBLES</strong></h5>
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
									<td class="text-center col-md-4"><strong>Descripción</strong></td>
									<%-- <td class="text-center col-md-2"><strong>Estado</strong></td> --%>
									<td class="text-center col-md-1"><strong></strong></td>
									<td class="text-center col-md-1"><strong></strong></td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="listaDisciplina">
				 						 <s:url id="idBuscar" action="findDisciplina">
				 							<s:param name="disciplina.codigo" value="codigo"/>
										 </s:url>
									<tr class="cuadro">
										<td class="codigo"><s:property value="codigo"/></td>
										<td><s:property value="descripcion"/></td>
										<%-- <td><s:property value="leerEstado(estado)"/></td> --%>
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

	<%@ include file="footer.jsp" %>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/disciplina.js"></script>
</body>
</html>
