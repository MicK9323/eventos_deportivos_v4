<%@ taglib uri="/struts-tags" prefix="s" %>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">EVENTOS DEPORTIVOS</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Mantenimiento <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<s:iterator value="#session.opcionesMant">
						<li class=""><a href="${pageContext.request.contextPath }/<s:property value="ruta" />"><s:property value="nomEnlace" /></a></li>
					</s:iterator>
				</ul>
			</li>
			<li class="dropdown">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown">Eventos <span class="caret"></span></a>
				<ul class="dropdown-menu">
					<s:iterator value="#session.opcionesEventos">
						<li class=""><a href="${pageContext.request.contextPath }/<s:property value="ruta" />"><s:property value="nomEnlace" /></a></li>
					</s:iterator>
				</ul>
			</li>
			<s:iterator value="#session.opcionesAdmin">
					<li class=""><a href="${pageContext.request.contextPath }/<s:property value="ruta" />"><s:property value="nomEnlace" /></a></li>
			</s:iterator>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a><span class="glyphicon glyphicon-briefcase"></span> <s:property value="#session.opcionesEventos.get(0).nomRol" /></a></li>
			<li><a><span class="glyphicon glyphicon-user"></span> <s:property value="#session.usuario.nom_jugador" /> <s:property value="#session.usuario.ape_jugador" /></a></li>
			<li><a href="organizadores.jsp"><span class="glyphicon glyphicon-lock"></span> Cambiar Contraseña</a></li>
			<li><a href="login.jsp"><span class="glyphicon glyphicon-log-out"></span> Salir</a></li>
		</ul>
	</div>
</nav>
