package actions;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import beans.DetEquipoDTO;
import beans.DetEventoDTO;
import beans.EquipoDTO;
import beans.EventoDTO;
import beans.JugadorDTO;
import beans.ModalidadDTO;
import services.InscripcionService;
import utils.Correos;
import utils.Metodos;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class InscripcionAction extends ActionSupport {
	InscripcionService serv = new InscripcionService();
	private Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
	private List<EventoDTO> listaEventos;
	private List<DetEventoDTO> detalleEvento;
	private List<JugadorDTO> jugadores;
	private DetEventoDTO detEvento;
	private EquipoDTO equipo;
	private DetEquipoDTO detEquipo;
	private EventoDTO evento;
	private String mensaje;
	private String dni;
	private String codModalidad;
	private boolean mostrar = false;
	private JugadorDTO jugador, delegado;
	private ModalidadDTO modalidad;
	private String DNI,nom,edad,sexo,sede, nomModalidad, fecInicio, fecFin;

	public String getSede() {
		return sede;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}

	// Actions
	// listar eventos
	// disponibles-----------------------------------------------------------------------------
	@Action(value = "/cargarEventos", results = { @Result(name = "listarEventos", location = "/eventos.jsp") })
	public String cargarEventos() {
		listaEventos = serv.listarEventosDisponibles();
		return "listarEventos";
	}
	// -------------------------------------------------------------------------------------------------------

	// listar detalle de evento segun sede y rol de usuario
	@Action(value = "/listarDetEvento", results = { @Result(name = "detEvento", location = "/inscripcion.jsp"),
			@Result(name = "error", location = "/eventos.jsp"), })
	public String listarDetEvento() {
		delegado = (JugadorDTO) session.get("usuario");
		boolean validaSede = serv.validarSede(delegado.getDni_jugador(), evento.getCod_evento());
		if (validaSede == true) {
			detalleEvento = serv.detalleEventoxSede(evento.getCod_evento(), delegado.getCodSede(), delegado.getIdRol());
			return "detEvento";
		} else {
			listaEventos = serv.listarEventosDisponibles();
			mostrar = true;
			mensaje = "Su sede no esta habilitada para este evento";
			return "error";
		}
	}
	// ---------------------------------------------------------------------------------------------------------

	// VALIDAR
	// JUGADOR-----------------------------------------------------------------------------------------
	@Action(value = "/validaJugador", results = { @Result(name = "validar", type = "json") })
	public String validarJugador() throws SQLException {
		mensaje = "" + serv.validarJugador(dni, codModalidad, evento.getCod_evento());
		return "validar";
	}

	// RETORNAR DATOS DE
	// JUGADOR--------------------------------------------------------------------------------
	@Action(value = "/datosJugador", results = { @Result(name = "datos", type = "json") })
	public String datosJugador() throws SQLException {
		jugador = serv.datosJugador(dni);
		return "datos";
	}

	// INSCRIBIR EQUIPO
	@Action(value = "/inscribirEquipo", results = { @Result(name = "inscribeEquipo", type = "json") })
	public String inscribirEquipo() throws SQLException {
		mensaje = serv.inscribirEquipo(evento.getCod_evento(), codModalidad, equipo.getNom_equipo(),
				delegado.getDni_jugador(), null);
		if(mensaje.length()==10) {
			String ficha, equipo,nombre;
			ficha = mensaje.substring(0, 5);
			equipo = mensaje.substring(5, 5);
			JugadorDTO obj = (JugadorDTO) session.get("usuario");
			nombre = obj.getNom_jugador();
			new Correos().enviarConfirmacion("i201520478@cibertec.edu.pe", ficha, equipo, nombre);
		}
		return "inscribeEquipo";
	}

	// REGISTRAR JUGADORES DE EQUIPO
	@Action(value = "/registrarEquipo", results = { @Result(name = "registraEquipo", type = "json") })
	public String registrarEquipo() throws SQLException {
		mensaje = serv.addJugador(equipo.getCod_equipo(), jugador.getDni_jugador());
		return "registraEquipo";
	}
	
	// VALIDAR QUE NO SE DUPLIQUE NOMBRE DE EQUIPO
	@Action(value = "/validarNombre", results = { @Result(name = "validaNombre", type = "json") })
	public String validarNombre() throws SQLException {
		mensaje = serv.validarNombre(equipo.getNom_equipo());
		return "validaNombre";
	}
	

	public DetEventoDTO getDetEvento() {
		return detEvento;
	}

	public void setDetEvento(DetEventoDTO detEvento) {
		this.detEvento = detEvento;
	}

	public ModalidadDTO getModalidad() {
		return modalidad;
	}

	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}

	public String getNomModalidad() {
		return nomModalidad;
	}

	public void setNomModalidad(String nomModalidad) {
		this.nomModalidad = nomModalidad;
	}

	public String getFecInicio() {
		return fecInicio;
	}

	public void setFecInicio(String fecInicio) {
		this.fecInicio = fecInicio;
	}

	public String getFecFin() {
		return fecFin;
	}

	public void setFecFin(String fecFin) {
		this.fecFin = fecFin;
	}

	public List<JugadorDTO> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<JugadorDTO> jugadores) {
		this.jugadores = jugadores;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public DetEquipoDTO getDetEquipo() {
		return detEquipo;
	}

	public void setDetEquipo(DetEquipoDTO detEquipo) {
		this.detEquipo = detEquipo;
	}

	public EquipoDTO getEquipo() {
		return equipo;
	}

	public void setEquipo(EquipoDTO equipo) {
		this.equipo = equipo;
	}

	public String getCodModalidad() {
		return codModalidad;
	}

	public void setCodModalidad(String codModalidad) {
		this.codModalidad = codModalidad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public JugadorDTO getDelegado() {
		return delegado;
	}

	public void setDelegado(JugadorDTO delegado) {
		this.delegado = delegado;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public JugadorDTO getJugador() {
		return jugador;
	}

	public void setJugador(JugadorDTO jugador) {
		this.jugador = jugador;
	}

	public List<EventoDTO> getListaEventos() {
		return listaEventos;
	}

	public void setListaEventos(List<EventoDTO> listaEventos) {
		this.listaEventos = listaEventos;
	}

	public List<DetEventoDTO> getDetalleEvento() {
		return detalleEvento;
	}

	public void setDetalleEvento(List<DetEventoDTO> detalleEvento) {
		this.detalleEvento = detalleEvento;
	}

	public EventoDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoDTO evento) {
		this.evento = evento;
	}

}
