<%@page import="beans.JugadorDTO"%>
<%
	JugadorDTO obj = (JugadorDTO) session.getAttribute("usuario");

	if (obj == null) {
		response.sendRedirect("login.jsp");
	}
%>