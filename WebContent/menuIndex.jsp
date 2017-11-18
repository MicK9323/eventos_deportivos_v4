
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">EVENTOS DEPORTIVOS</a>
			</div>
			<ul class="nav navbar-nav">
				<li class=""><a href="index.jsp">Inicio</a></li>
				<li ><a href="cargarEventos">Eventos</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				<li><a href="loginAdmin.jsp"><span class="glyphicon glyphicon-log-in"></span> Organizadores</a></li>
			</ul>
		</div>
	</nav>

	<!-- VENTANA MODAL LOGUEARSE -->
	<!-- <div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="text-info"><strong>Login</strong><small> Por favor ingrese sus credenciales</small></h4>
				</div>
				<form class="form-horizontal" action="iniciarSesion" method="post">
					<div class="modal-body">
						<div class="form-group">
					  	<div class="col-md-2">
					  		<label class="control-label">DNI: </label>
					  	</div>
							<div class="col-md-5">
								<s:textfield id="dni" name="user.dni" cssClass="form-control text-uppercase" placeholder="DNI" />
							</div>
						</div>
						<div class="form-group">
					  	<div class="col-md-2">
					  		<label class="control-label">Password: </label>
					  	</div>
							<div class="col-md-5">
								<s:password id="password" name="user.password" cssClass="form-control text-uppercase" placeholder="Password" />								
							</div>
						</div>
					</div>
					<div class="modal-footer text-center">
						<s:set name="idMensaje" value="mensaje" />
						<s:label id="mensaje" cssClass="text-danger text-left"><s:property value='idMensaje'/></s:label>
						<input type="submit" class="btn btn-success" value="Login" data-toggle="modal" data-target="#modalLogin">
						<input type="reset" class="btn btn-warning" value="Cancelar" data-toggle="modal" data-target="#modalLogin">
					</div>
				</form>
			</div>
		</div>
	</div> -->
