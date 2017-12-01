<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
		<%
			JugadorDTO obj = (JugadorDTO) session.getAttribute("usuario");
		
			if(obj == null){
				response.sendRedirect("login.jsp");
			}
		%>
		<jsp:include page="valida.jsp" />
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">EVENTOS DEPORTIVOS</a>
				</div>
				<ul class="nav navbar-nav">
					<s:iterator value="#session.opcionesInscripcion">
						<li><a href="${pageContext.request.contextPath}/<s:property value="ruta"/>"><s:property value="nomEnlace"/></a></li>
					</s:iterator>
					<%-- <li class=""><a href="${pageContext.request.contextPath }/${#sesion.Permisos.get(0).ruta}">${#sesion.Permisos.get(0).nomEnlace}</a></li>
					<li ><a href="${pageContext.request.contextPath }/${#sesion.Permisos.get(1).ruta}">${#sesion.Permisos.get(0).nomEnlace}</a></li> --%>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<s:if test=" #session.opcionesInscripcion.get(0).idRol != 3 ">
						<li><a><span class="glyphicon glyphicon-map-marker"></span> <s:property value="#session.usuario.nomSede" /></a></li>
					</s:if>				
					<li><a><span class="glyphicon glyphicon-briefcase"></span> <s:property value="#session.opcionesInscripcion.get(0).nomRol" /></a></li>
					<li><s:a href="%{idBuscar}"><span class="glyphicon glyphicon-user"></span> <s:property value="#session.usuario.nom_jugador" /> <s:property value="#session.usuario.ape_jugador" /></s:a></li>
				<%-- <li><a><span class="glyphicon glyphicon-user"></span> <s:property value="#session.usuario.nom_jugador" /> <s:property value="#session.usuario.ape_jugador" /></a></li> --%>
				<%-- <li><a href="organizadores.jsp"><span class="glyphicon glyphicon-lock"></span> Cambiar Contraseña</a></li> --%>
					<li><a href="login.jsp"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
				</ul>
			</div>
		</nav>