<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Jugadores</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<!-- <link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css"> -->
<link rel="stylesheet" type="text/css" href="css/data-tables/dataTables.bootstrap.css">
<!-- <link rel="stylesheet" type="text/css" href="css/datepicker.min.css"> -->
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
	<jsp:include page="menuAdmin.jsp"/>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><strong>Jugadores Registrados</strong></h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-12">
								<div class="col-md-6">
									<a href="dataJugador" id="btnAddEvento" class="btn btn-success mr15">
										<span class="glyphicon glyphicon-plus-sign"></span> <strong>NUEVO</strong>
									</a>
									<div id="btnAddEvento" class="btn btn-primary" data-toggle="modal" data-target="#importar">
										<span class="glyphicon glyphicon-save"></span><strong>IMPORTAR</strong>
									</div>
								</div>								
							</div>
							<div class="col-md-12">
								<s:if test="mostrar == true">
 									<div class="alert alert-info" role="alert"> <strong> <s:label name="msg" /> </strong></div>
								</s:if>
							</div>
						</div>
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
						<s:if test="lista.empty">
							<div class="alert alert-danger" role="alert"> <strong>No hay jugadores registrados!</strong></div>
						</s:if> 						
						<!--  -->
						<table class="table table-bordered table-hover" id="tbJugadores">
							<thead>
								<tr>
									<th class="text-center col-md-1"><strong>DNI</strong></th>
									<th class="text-center col-md-2"><strong>Nombres</strong></th>
									<th class="text-center col-md-1"><strong>Edad</strong></th>
									<th class="text-center col-md-1"><strong>Sexo</strong></th>
									<th class="text-center col-md-1"><strong>Movil</strong></th>
									<th class="text-center col-md-2"><strong>Sede</strong></th>
									<th class="text-center col-md-1"><strong>Estado</strong></th>
									<th class="text-center col-md-1"></th>
									<th class="text-center col-md-1"></th>
								</tr>
							</thead>
							<tbody id="lstJugadores">
								<s:iterator value="lista">									
										<s:url id="idBuscar" action="buscaJugador">
				 							<s:param name="jugador.dni_jugador" value="dni_jugador"/>
										 </s:url>
									<s:if test="estado == true">
										<tr>
											<td class="text-center"> <s:property value="dni_jugador" /> </td>
											<td> <s:property value="nom_jugador" /> </td>
											<td class="text-center"> <s:property value="edad" /> </td>
											<td class="text-center"> <s:property value="sexo" /> </td>
											<td class="text-center"> <s:property value="telfMovil" /> </td>
											<td class="text-center"> <s:property value="nomSede" /> </td>
											<td class="text-center"> <a class="habilitado"><span class="glyphicon glyphicon-ok"></span></a> </td>
											<td><s:a href="%{idBuscar}" cssClass="editar" ><span class="glyphicon glyphicon-pencil"></span></s:a></td>
											<td class="text-center"><a class="remove"><span class="glyphicon glyphicon-remove"></span></a></td>
										</tr>
									</s:if>
									<s:if test="estado == false">
										<tr class="fondoRojo">
											<td class="text-center"> <s:property value="dni_jugador" /> </td>
											<td> <s:property value="nom_jugador" /> </td>
											<td class="text-center"> <s:property value="edad" /> </td>
											<td class="text-center"> <s:property value="sexo" /> </td>
											<td class="text-center"> <s:property value="telfMovil" /> </td>
											<td class="text-center"> <s:property value="nomSede" /> </td>
											<td class="text-center"> <a class="deshabilitado"><span class="glyphicon glyphicon-ban-circle"></span></a> </td>
											<td><s:a href="%{idBuscar}" cssClass="editar" ><span class="glyphicon glyphicon-pencil"></span></s:a></td>
											<td class="text-center"><a class="remove"><span class="glyphicon glyphicon-remove"></span></a></td>
										</tr>
									</s:if>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="importar" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span>&times;</span>
					</button>
					<h4 class="modal-title">Importar Datos</h4>
				</div>

				<div class="modal-body">
					<div class="row">
					 	<div class="col-md-12">
							<div class="col-md-12">
								<form class="" action="importarData" method="post" enctype="multipart/form-data">
									<div class="input-group image-preview">
			            	<input type="text" class="form-control image-preview-filename" disabled="disabled"> <!-- don't give a name === doesn't send on POST/GET -->
			            	<span class="input-group-btn">
			                	<!-- image-preview-clear button -->
			                	<button type="button" class="btn btn-default image-preview-clear" style="display:none;">
			                    	<span class="glyphicon glyphicon-remove"></span> Eliminar
			                	</button>
			                	<!-- image-preview-input -->
			                	<div class="btn btn-default image-preview-input">
			                    	<span class="glyphicon glyphicon-folder-open"></span>
			                    	<span class="image-preview-input-title">Buscar</span>
			                    	<!-- <input type="file" accept=".csv" name="file"/> -->
			                    	<s:file accept=".csv" name="archivo"/>
			                	</div>
			            	</span>
			            </div>
									<br>
									<s:submit value="Importar" cssClass="btn btn-primary" />
									<!-- <button type="button" class="btn btn-primary" id="btnCargar" name="button">Importar Datos</button> -->
								</form>
							</div>
					 	</div>
					</div>
				</div>

			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/data-tables/dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/cargar.js"></script>
	<script>
		$(document).ready(function() {
		  $('#tbJugadores').dataTable();
		});
	</script>
</body>
</html>
