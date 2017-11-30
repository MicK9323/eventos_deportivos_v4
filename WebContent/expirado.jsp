<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

	<%-- <jsp:include page="menuIndex.jsp"/> --%>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">EVENTOS DEPORTIVOS</a>
			</div>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="" data-toggle="modal" data-target="#modalLogin"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
			</ul>
		</div>
	</nav>

	<!-- VENTANA MODAL LOGUEARSE -->
	<div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="text-danger text-uppercase"><strong>Sesión expirada</strong></h4>
				</div>
				<form class="form-horizontal" method="post" action="login">
					<div class="modal-body">
						<div class="alert alert-danger" role="alert"> Ha expirado su tiempo de conexión con el sistema, por favor vuelva a ingresar</div>
					</div>
					<div class="modal-footer text-center">						
						<a href="login.jsp" class="btn btn-default" >Aceptar</a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#modalLogin').modal("show");
		});

	</script>
</body>
</html>
