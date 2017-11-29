<!DOCTYPE html>
<%@page import="beans.JugadorDTO"%>
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
				response.sendRedirect("login.jsp");
			}
		%>
	<jsp:include page="menuAdmin.jsp"/>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="col-md-4">
					<a href="cargarDatos" id="btnAddEvento" class="btn btn-success">
						<span class="glyphicon glyphicon-plus-sign"></span> <strong>NUEVO JUGADOR</strong>
					</a>
				</div>
			</div>
		</div>
	</div>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h4><strong>Jugadores Registrados</strong></h4>
					</div>
					<div class="panel-body">
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
 						<div class="alert alert-danger" role="alert"> <strong>No hay jugadores registrados!</strong></div>
						<!--  -->
						<table class="table table-bordered table-hover" id="tbEventos">
							<thead>
								<tr>
									<th class="text-center col-md-1"><strong>DNI</strong></th>
									<th class="text-center col-md-3"><strong>Nombres</strong></th>
									<th class="text-center col-md-1"><strong>Edad</strong></th>
									<th class="text-center col-md-1"><strong>Sexo</strong></th>
									<th class="text-center col-md-1"><strong>Movil</strong></th>
									<th class="text-center col-md-2"><strong>Sede</strong></th>
									<th class="text-center col-md-1"><strong>Estado</strong></th>
									<th class="text-center col-md-1"></th>
								</tr>
							</thead>
							<tbody id="lstEventos">

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>


	<footer>
		<div class="mencion">
			<a
				style="background-color: black; color: white; text-decoration: none; padding: 4px 6px; font-family: -apple-system, BlinkMacSystemFont,&amp; quot; San Francisco&amp;quot; , &amp; quot; Helvetica Neue&amp;quot; , Helvetica , Ubuntu, Roboto, Noto, &amp;quot; Segoe UI&amp;quot; , Arial , sans-serif; font-size: 12px; font-weight: bold; line-height: 1.2; display: inline-block; border-radius: 3px;"
				href="https://unsplash.com/@austinban?utm_medium=referral&amp;utm_campaign=photographer-credit&amp;utm_content=creditBadge"
				target="_blank" rel="noopener noreferrer"
				title="Download free do whatever you want high-resolution photos from Austin Ban"><span
				style="display: inline-block; padding: 2px 3px;"><svg
						xmlns="http://www.w3.org/2000/svg"
						style="height: 12px; width: auto; position: relative; vertical-align: middle; top: -1px; fill: white;"
						viewBox="0 0 32 32">
						<title></title><path
							d="M20.8 18.1c0 2.7-2.2 4.8-4.8 4.8s-4.8-2.1-4.8-4.8c0-2.7 2.2-4.8 4.8-4.8 2.7.1 4.8 2.2 4.8 4.8zm11.2-7.4v14.9c0 2.3-1.9 4.3-4.3 4.3h-23.4c-2.4 0-4.3-1.9-4.3-4.3v-15c0-2.3 1.9-4.3 4.3-4.3h3.7l.8-2.3c.4-1.1 1.7-2 2.9-2h8.6c1.2 0 2.5.9 2.9 2l.8 2.4h3.7c2.4 0 4.3 1.9 4.3 4.3zm-8.6 7.5c0-4.1-3.3-7.5-7.5-7.5-4.1 0-7.5 3.4-7.5 7.5s3.3 7.5 7.5 7.5c4.2-.1 7.5-3.4 7.5-7.5z"></path></svg></span><span
				style="display: inline-block; padding: 2px 3px;">Austin Ban</span></a>
		</div>
	</footer>


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
