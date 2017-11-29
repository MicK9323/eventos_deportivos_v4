<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inicio</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/alertify.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/themes/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body style="padding-top: 70px;">
		<%
			JugadorDTO obj = (JugadorDTO) session.getAttribute("usuario");		
			if(obj == null){
				response.sendRedirect("login.jsp");
			}
		%>
	<jsp:include page="menu.jsp"/>


	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>INFORMACION</h4>
					</div>
					<div class="panel-body">
						<p><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sit nam ad repellat laborum officia distinctio repudiandae ullam amet accusantium nisi, quaerat voluptas hic similique numquam quidem dolorem corporis iusto unde.</span>
						<span>Quod praesentium temporibus at accusamus rerum illum sint in, ratione illo magni! Ex minus architecto esse reprehenderit distinctio tenetur vel odio aliquam animi voluptatibus, dolores molestiae rerum quae et ea?</span>
						<span>Praesentium fuga nesciunt, velit odit itaque quaerat expedita, laborum. Atque, a doloremque! Maxime sit quod blanditiis, earum assumenda reprehenderit odit necessitatibus dolor a. Deleniti rem, explicabo tempora placeat laboriosam neque!</span>
						<span>Aspernatur facere minima veniam omnis ex eum similique temporibus beatae cum quibusdam? Dolorem non incidunt, minus laudantium, perferendis officiis itaque esse eius quibusdam culpa soluta dolor architecto laboriosam. Odit, corrupti!</span></p>
					</div>
				</div>
			</div>
			<div class="col-md-7">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-5" align="left">
								<h4>EVENTOS DISPONIBLES</h4>
							</div>
							<div class="col-md-7" align="right">
								<!-- BOTON BUSCAR -->
								<div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon">Buscar</span>
										<input type="text" id="buscador" class="form-control" placeholder="Buscar Evento">
									</div>
								</div>
								<!-- BOTON BUSCAR -->
							</div>
						</div>
					</div>
					<div class="panel-body buscar">
						<!-- VERIFICA SI EL ARREGLO NO ESTA VACIO -->
						<s:if test="listaEventos.empty">
 								<div class="alert alert-danger" role="alert"> <strong>Lo sentimos!</strong>, no hay eventos disponibles por el momento</div>
						</s:if>
						<s:if test="mostrar == true">
 								<div class="alert alert-danger" role="alert"> <strong> <s:label name="mensaje" /> </strong></div>
						</s:if>
						<!-- BUCLE DE ITERACION -->
						<s:iterator value="listaEventos" >
						<!-- URL'S -->
							<s:url id="idDetEvento" action="listarDetEvento">
								<s:param name="evento.cod_evento" value="cod_evento"/>
								<s:param name="evento.desc_evento" value="desc_evento"/>
							</s:url>
							<!-- URL'S -->
							<div class="panel panel-success cuadro">
								<div class="panel-heading"><strong><s:property value="desc_evento"/></strong></div>
								<div class="panel-body">
									<input type="hidden" name="evento.cod_evento" value="<s:property value="cod_evento"/>">
									<!-- <h3><s:property value="nom_estado"/></h3> -->
									<h5 class="text-danger"><strong>Inscripción desde: <s:property value="inicio_inscripcion"/> hasta:
											<s:property value="fin_inscripcion"/></strong></h5>
									<h5 class="text-primary"><strong>Participan: <s:property value="participantes"/></strong></h5>
									<h5 class="text-success"><strong>Inicio de Evento: <s:property value="inicio_evento"/></strong></h5>
									<div class="text-right">
										<s:a href="%{idDetEvento}">
											<button class="btn btn-success">Inscribete</button>
										</s:a>
									</div>
								</div>
				 			</div>
						</s:iterator>
						<!-- BUCLE DE ITERACION -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer>

	</footer>

	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/inscripcionV2.js"></script>
</body>
</html>
