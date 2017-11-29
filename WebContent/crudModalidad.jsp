<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento Modalidades</title>
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
				response.sendRedirect("login.jsp");
			}
		%>
	<jsp:include page="menuAdmin.jsp"/>

	<!-- MODAL DISCIPLINA -->
	<div class="modal fade" id="disciplinaModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="col-md-4">
						<h4><strong>DISCIPLINAS</strong></h4>
					</div>
					<div class="col-md-8" align="right">
						<!-- BOTON BUSCAR -->
						<div class="col-md-12">
							<div class="input-group">
								<span class="input-group-addon">Buscar</span>
								<input type="text" id="buscaDisciplinas" class="form-control text-uppercase" placeholder="Buscar Disciplina">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body disciplinas">
					<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
					<s:if test="listaDisciplinas.empty">
						<div class="alert alert-danger" role="alert"> <strong>No hay disciplinas registradas!</strong></div>
					</s:if>
					<table class="table table-striped table-condensed table-hover">
						<thead>
							<tr>
								<td class="text-center"><strong>Código</strong></td>
								<td class="text-center"><strong>Descripción</strong></td>
							</tr>
						</thead>
						<tbody id="tbDisciplina">
							<!-- INSERTAR ITERATOR -->
							<s:iterator value="listaDisciplinas">
								<tr class="disciplina">
									<input type="hidden" class="codDisciplina" value=<s:property value='codigo'/>>
									<td class="text-center"><s:property value="codigo"/></td>
									<td class="text-center descripcion"><s:property value="descripcion"/></td>
								</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="modal-footer text-center">
					<div id="addDisciplina" class="btn btn-primary" data-toggle="modal" data-target="#disciplinaModal">Seleccionar</div>
					<div data-toggle="modal" data-target="#disciplinaModal" class="btn btn-warning btnCancelar">Cancelar</div>
				</div>
			</div>
		</div>
	</div>

	<!-- MODAL CATEGORIA -->
	<div class="modal fade" id="categoriaModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="col-md-4">
						<h4><strong>CATEGORIAS</strong></h4>
					</div>
					<div class="col-md-8" align="right">
						<!-- BOTON BUSCAR -->
						<div class="col-md-12">
							<div class="input-group">
								<span class="input-group-addon">Buscar</span>
								<input type="text" id="buscaCategorias" class="form-control text-uppercase" placeholder="Buscar Categoria">
							</div>
						</div>
					</div>
				</div>
				<div class="modal-body categorias">
					<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
					<s:if test="listaCategorias.empty">
						<div class="alert alert-danger" role="alert"> <strong>No hay categorias registradas!</strong></div>
					</s:if>
					<table class="table table-striped table-condensed table-hover">
						<thead>
							<tr>
								<td class="text-center"><strong>Descripción</strong></td>
								<td class="text-center"><strong>Edad(Min)</strong></td>
								<td class="text-center"><strong>Edad(Max)</strong></td>
							</tr>
						</thead>
						<tbody id="tbCategoria">
							<!-- INSERTAR ITERATOR -->
							<s:iterator value="listaCategorias">
								<tr class="categoria">
								<input type="hidden" class="codCategoria" value=<s:property value='codigo'/>>
								<td class="descripcion"><s:property value="descripcion"/></td>
								<td class="text-center"><s:property value="edadMin"/></td>
								<td class="text-center"><s:property value="edadMax"/></td>
							</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>
				<div class="modal-footer text-center">
					<div id="addCategoria" class="btn btn-primary" data-toggle="modal" data-target="#categoriaModal">Seleccionar</div>
					<div data-toggle="modal" data-target="#categoriaModal" class="btn btn-warning btnCancelar">Cancelar</div>
				</div>
			</div>
		</div>
	</div>


	<div class="container-fluid">
		<div class="row">
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>DATOS DE MODALIDAD</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" id="formModalidad">
							<s:set name="codModalidad" value="modalidad.codigo" />
							<s:set name="idOpcion" value="opcion" />
							<input type="hidden" id="codigo" name="modalidad.codigo" value=<s:property value='codModalidad'/>>
							<input type="hidden" id="opcion" value=<s:property value='idOpcion'/>>
							<!-- DESCRIPCION -->
							<div class="form-group">
								<div class="col-md-4">
									<label class="control-label">Descripción</label>
								</div>
							  <div class="col-md-8">
							  	<s:textfield id="descripcion" name="modalidad.descripcion" cssClass="form-control text-uppercase" placeholder="Descripción" />
							  	<div id="alerta" style="margin-top: 5px;"><label></label></div>
							  </div>
							</div>
							<!--ABRIR MODAL DISCIPLINA -->
							<div class="form-group">
								<div class="col-md-5">
									<div id="btnDisciplina" class="form-control btn btn-primary"
										data-toggle="modal" data-target="#disciplinaModal">Seleccionar Disciplina</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<s:hidden name="modalidad.codDisciplina" id="codDisciplina" />
								  <label class="control-label">Disciplina: </label>
								  <s:label name="modalidad.nomDisciplina" id="nomDisciplina" />
								</div>
							</div>
							<!--ABRIR MODAL CATEGORIA -->
							<div class="form-group">
								<div class="col-md-5">
									<div id="btnCategoria" class="form-control btn btn-primary"
										data-toggle="modal" data-target="#categoriaModal">Seleccionar Categoria</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<s:hidden name="modalidad.codCategoria" id="codCategoria" />
									<label class="control-label">Categoria: </label>
									<s:label name="modalidad.nomCategoria" id="nomCategoria" />
								</div>
							</div>
							<!-- TIPO -->
							<div class="form-group">
								<div class="col-md-4">
									<label class="control-label">Tipo</label>
								</div>
								<div class="col-md-6">
									<s:select name="modalidad.tipo" id="tipo"
									list="#{'MASCULINO':'MASCULINO',
											'FEMENINO':'FEMENINO',
											'MIXTO':'MIXTO'}"
									headerKey=""
									headerValue="[SELECCIONE]"
									cssClass="form-control"/>
								</div>
							</div>
							<div class="col-md-12 text-center">
								<!-- <button class="btn btn-primary" type="button" id="btnNuevo">Registrar Nuevo</button> -->
								<button class="btn btn-success" type="button" id="btnGuardar"></button>
								<button class="btn btn-warning" type="button" id="btnReset"></button>
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
								<h5><strong>LISTA DE MODALIDADES</strong></h5>
							</div>
							<div class="col-md-7" align="right">
								<!-- BOTON BUSCAR -->
								<div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon">Buscar</span>
										<input type="text" id="buscaModalidad" class="form-control text-uppercase" placeholder="Buscar Modalidad">
									</div>
								</div>
								<!-- BOTON BUSCAR -->
							</div>
						</div>
					</div>
					<div class="panel-body modalidades">
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
						<s:if test="listaModalidades.empty">
 								<div class="alert alert-danger" role="alert"> <strong>No hay modalidades registradas!</strong></div>
						</s:if>
						<!-- BUCLE DE ITERACION -->
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<td class="text-center col-md-2"><strong>Código</strong></td>
									<td class="text-center col-md-4"><strong>Descripción</strong></td>
									<%-- <td class="text-center col-md-1"><strong>Disciplina</strong></td>
									<td class="text-center col-md-1"><strong>Categoria</strong></td> --%>
									<td class="text-center col-md-2"><strong>Tipo</strong></td>
									<%-- <td class="text-center col-md-2"><strong>Varones(Max)</strong></td> --%>
									<td class="text-center col-md-1"><strong></strong></td>
									<td class="text-center col-md-1"><strong></strong></td>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="listaModalidades">
				 					<s:url id="idBuscar" action="buscaModalidad">
				 						<s:param name="modalidad.codigo" value="codigo"/>
									</s:url>
									<tr class="modalidad">
										<td class="codigo col-md-1 text-center"><s:property value="codigo"/></td>
										<td class="text-left col-md-8"><s:property value="descripcion"/></td>
										<%-- <td><s:property value="nomDisciplina"/></td>
										<td><s:property value="nomCategoria"/></td> --%>
										<td><s:property value="tipo"/></td>
										<%-- <td class="text-center"><s:property value="varones(maxVarones)"/></td> --%>
										<td class="col-md-1 text-center"><s:a href="%{idBuscar}" cssClass="editar" ><span class="glyphicon glyphicon-pencil"></span></s:a></td>
										<td class="col-md-1 text-center"><a class="remove"><span class="glyphicon glyphicon-remove"></span></a></td>
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
	<script type="text/javascript" src="js/modalidad.js"></script>
</body>
</html>
