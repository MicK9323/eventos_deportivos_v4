<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Eventos</title>
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
	<jsp:include page="menuAdmin.jsp"/>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="col-md-4">
					<a href="cargarDatos" id="btnAddEvento" class="btn btn-success">
						<span class="glyphicon glyphicon-plus-sign"></span> <strong>NUEVO EVENTO</strong>
					</a>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><strong>Listado de Eventos</strong></h4>
					</div>
					<div class="panel-body">
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
						<s:if test="listadoEventos.empty">
 								<div class="alert alert-danger" role="alert"> <strong>No hay eventos registrados!</strong></div>
						</s:if>
						<table class="table table-bordered table-hover" id="tbEventos">
							<thead>
								<tr>
									<th class="text-center col-md-1"><strong>Codigo</strong></th>
									<th class="text-center col-md-3"><strong>Descripción</strong></th>
									<th class="text-center"><strong>Inscripción(Inicio)</strong></th>
									<th class="text-center"><strong>Inscripción(Fin)</strong></th>
									<th class="text-center"><strong>Inicio de Evento</strong></th>
									<th class="text-center"><strong>Fin de Evento</strong></th>
									<th class="text-center col-md-1"><strong>Estado</strong></th>
									<th class="text-center col-md-1"></th>
								</tr>
							</thead>
							<tbody id="lstEventos">
								<s:iterator value="listadoEventos">
									<s:url id="idBuscar" action="">
				 						<s:param name="" value="cod_evento"/>
									</s:url>
									<tr>
										<td><s:property value="cod_evento"/></td>
										<td><s:property value="desc_evento"/></td>
										<td><s:property value="inicio_inscripcion"/></td>
										<td><s:property value="fin_inscripcion"/></td>
										<td><s:property value="inicio_evento"/></td>
										<td><s:property value="fin_evento"/></td>
										<td><s:property value="nom_estado"/></td>
										<td><s:a>Ver Detalle</s:a></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


	<jsp:include page="footer.jsp"/>
	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/data-tables/jquery.dataTables.js"></script>
	<script type="text/javascript" src="js/data-tables/dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/eventos.js"></script>
	<script>
		$(document).ready(function() {
		  $('#tbEventos').dataTable();
		});
	</script>
</body>
</html>
