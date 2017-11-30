<%@page import="beans.JugadorDTO"%>
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
	
	<%
		JugadorDTO obj = (JugadorDTO) session.getAttribute("usuario");
	
		if(obj == null){
			response.sendRedirect("expirado.jsp");
		}
	%>
	
	<jsp:include page="menu.jsp"/>

	

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
