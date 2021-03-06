package actions;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import beans.EnlaceDTO;
import beans.JugadorDTO;
import services.LoginService;
import utils.Metodos;

@SuppressWarnings("serial")
@ParentPackage("pit")
public class LoginAction extends ActionSupport implements SessionAware{
	LoginService dao = new LoginService();
	Metodos met = new Metodos();
	private String dni,clave;
	private boolean mostrar = false;
	private String mensaje;
	private Map<String, Object> session = (Map<String, Object>)ActionContext.getContext().getSession();
	
	@Action(value="/login",results= {
			@Result(name="usuario",location="/index.jsp"),
			@Result(name="admin",location="/organizadores.jsp"),
			@Result(name="error",location="/login.jsp")
	})
	public String login() {
		JugadorDTO jugador = dao.loginJugador(dni, met.codificarBase64(clave));
		if(jugador == null) {
			mostrar = true;
			mensaje = "Credenciales Incorrectas";
			return "error";
		}
		else if(jugador != null && jugador.getEstado() == 0) {
			mostrar = true;
			mensaje = "Jugador Deshabilitado";
			return "error";
		}else {
			String dni = jugador.getDni_jugador();
			List<EnlaceDTO> menuInscripcion = dao.obtenerEnlacesInscripcion(dni);
			List<EnlaceDTO> menuMantenimiento = dao.obtenerEnlacesMantenimiento(dni);
			List<EnlaceDTO> menuEventos = dao.obtenerEnlacesEventos(dni);
			List<EnlaceDTO> menuPagos = dao.obtenerEnlacesPagos(dni);
			List<EnlaceDTO> menuReportes = dao.obtenerEnlacesReportes(dni);
			session.put("usuario", jugador);
			session.put("opcionesInscripcion", menuInscripcion);			
			session.put("opcionesMant", menuMantenimiento);
			session.put("opcionesEventos", menuEventos);
			session.put("opcionesPagos", menuPagos);
			session.put("opcionesReportes", menuReportes);
			if(jugador.getIdRol() == 3) {
				return "admin";
			}else {
				return "usuario";
			}
		}		
	}
	
	public Metodos getMet() {
		return met;
	}

	public void setMet(Metodos met) {
		this.met = met;
	}

	@Action(value="/cerrar",results={
			@Result(name="logout",location="/login.jsp")
	})
	public String cerrar(){
		//Recuperar la sesion atual
		SessionMap sesionActual = (SessionMap) ActionContext.getContext().getSession();
		sesionActual.invalidate();
		return "logout";
	}
	

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}	

}
