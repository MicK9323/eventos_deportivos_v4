<%@page import="beans.JugadorDTO"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mantenimiento Sedes</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrapValidator.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/alertify.min.css">
<link rel="stylesheet" type="text/css" href="css/alertify/themes/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/back.css">
</head>
<body style="padding-top: 70px;">
	<%
			JugadorDTO obj = (JugadorDTO) session.getAttribute("usuario");		
			if(obj == null){
				response.sendRedirect("login.jsp");
			}
		%>
	<jsp:include page="menuAdmin.jsp"/>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-5">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>DATOS DE SEDE</h4>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" id="formCategoria">
							<input type="hidden" id="codigo" name="codigo" value=""/>
							<input type="hidden" id="opcion" name="opcion" value=""/>
							<!-- DESCRIPCION -->
							<div class="form-group">
								<div class="col-md-2">
									<label class="control-label">Nombre</label>
								</div>
							  <div class="col-md-8">
									<input type="text" id="nomSede" class="form-control text-uppercase" name="nomSede" value="" placeholder="Nombre de Sede">
							  	<div id="alerta" style="margin-top: 5px;"><label></label></div>
							  </div>
							</div>
							<!-- MIN JUGADORES -->
							<div class="form-group">
								<div class="col-md-2">
									<label class="control-label">DirecciÃ³n</label>
								</div>
							  <div class="col-md-8">
									<input type="text" id="dirSede" name="dirSede" class="form-control" placeholder="DirecciÃ³n" value="">
							  </div>
							</div>
							<!-- MAX JUGADORES -->
							<div class="form-group">
								<div class="col-md-2">
									<label class="control-label">TelÃ©fono</label>
								</div>
							  <div class="col-md-4">
									<input type="text" id="telfSede" name="telfSede" class="form-control" placeholder="TelÃ©fono" value="">
							  </div>
							</div>
							<div class="col-md-12 text-center">
								<!-- EL btnGuardar muestra el nombre segun la opcion que envie el action "Guardar o Actualizar" (lo dejare como guardar) -->
								<button class="btn btn-success" type="button" id="btnGuardar">Guardar</button>
								<button class="btn btn-warning" type="button" id="btnReset">Cancelar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-7">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-5" align="left">
								<h5><strong>SEDES REGISTRADAS</strong></h5>
							</div>
							<div class="col-md-7" align="right">
								<!-- BOTON BUSCAR -->
								<div class="col-md-12">
									<div class="input-group">
										<span class="input-group-addon">Buscar</span>
										<input type="text" id="buscador" class="form-control" placeholder="Buscar Categoria">
									</div>
								</div>
								<!-- BOTON BUSCAR -->
							</div>
						</div>
					</div>
					<div class="panel-body buscar">
						<!-- SE MOSTRABA SI EL ARREGLO QUE ENVIABA EL ACTION ESTABA VACIO -->
 						<div class="alert alert-danger" role="alert"> <strong>No hay sedes registradas!</strong></div>
						<!-- ITERACION DE LOS DATOS DEL ARREGLO -->
						<table class="table table-bordered table-hover">
							<thead>
								<tr>
									<td class="text-center col-md-1"><strong>CÃ³digo</strong></td>
									<td class="text-center col-md-4"><strong>Nombre</strong></td>
									<td class="text-center col-md-3"><strong>DirecciÃ³n</strong></td>
									<td class="text-center col-md-1"><strong>TelÃ©fono</strong></td>
									<td class="text-center col-md-1"><strong>Estado</strong></td>
									<td class="text-center col-md-1"><strong></strong></td>
									<td class="text-center col-md-1"><strong></strong></td>
								</tr>
							</thead>
							<tbody>
								<tr class="cuadro">
									<td class="codigo">C0001</td>
									<td>SEDE INDEPENDENCIA</td>
									<td>Av. Carlos Izaguirre Independencia - Lima Norte</td>
									<td>12345678</td>
									<td>ACTIVO</td>
									<td><a class="editar"><span class="glyphicon glyphicon-pencil"></span></a></td>
									<td><a class="remove"><span class="glyphicon glyphicon-remove"></span></a></td>
								</tr>
							</tbody>
						</table>
						<!-- BUCLE DE ITERACION -->
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="clearfix"></div>

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
	<script type="text/javascript" src="js/bootstrapValidator.min.js"></script>
	<script type="text/javascript" src="js/alertify/alertify.min.js"></script>
	<script type="text/javascript" src="js/categoria.js"></script>
</body>
</html>
