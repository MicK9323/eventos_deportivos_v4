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

	<jsp:include page="menu.jsp"/>

	<%-- <nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">EVENTOS DEPORTIVOS</a>
			</div>
			<ul class="nav navbar-nav">
				<s:iterator value="#session.opcionesInscripcion">
					<li><a href="${pageContext.request.contextPath}/<s:property value="ruta"/>"><s:property value="nomEnlace"/></a></li>
				</s:iterator>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li> </li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Cambiar Contraseña</a></li>
				<li><a href="login.jsp"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
			</ul>
		</div>
	</nav> --%>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
