package actions;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import beans.DetEventoDTO;
import beans.EventoDTO;
import beans.ModalidadDTO;
import beans.SedeDTO;
import services.EventoService;

@SuppressWarnings("serial")
@ParentPackage("pit")
public class EventoAction extends ActionSupport {
	EventoService dao = new EventoService();
	private EventoDTO evento;
	private List<EventoDTO> listadoEventos;
	private List<SedeDTO> listaSedes;
	private List<ModalidadDTO> listaModalidades;
	private DetEventoDTO detalle;
	private ArrayList<DetEventoDTO> arrayDetalle;
	private String mensaje;

	@Action(value = "/listarEventos", results = { @Result(name = "listaEventos", location = "/listaEventos.jsp") })
	public String listarEventos() {
		listadoEventos = dao.listarEventos();
		return "listaEventos";
	}
	
	@Action(value="/cargarDatos",results= {
			@Result(name="datos",location="/nuevoEvento.jsp")
	})
	public String cargarDatos() {
		listaSedes = dao.listaSedes();
		listaModalidades = dao.listaModalidades();
		return "datos";
	}
	
	@Action(value="/regEvento",results={
			@Result(name="registra",type="json")
	})
	public String regEvento() {
		mensaje = dao.regEvento(evento);
		return "registra";
	}
	
	@Action(value="/regDetEvento",results= {
			@Result(name="registraDetalle",type="json")
	})
	public String regDetEvento() {
		mensaje = dao.regDetalleEvento(detalle);
		return "registraDetalle";
	}
	
	@Action(value="/validaNombre",results= {
			@Result(name="valida",type="json")
	})
	public String validaNombre() {
		mensaje = dao.validarNombre(evento.getDesc_evento());
		return "valida";
	}
	
	public List<SedeDTO> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(List<SedeDTO> listaSedes) {
		this.listaSedes = listaSedes;
	}

	public List<ModalidadDTO> getListaModalidades() {
		return listaModalidades;
	}

	public void setListaModalidades(List<ModalidadDTO> listaModalidades) {
		this.listaModalidades = listaModalidades;
	}

	public EventoDTO getEvento() {
		return evento;
	}

	public void setEvento(EventoDTO evento) {
		this.evento = evento;
	}

	public List<EventoDTO> getListadoEventos() {
		return listadoEventos;
	}

	public void setListadoEventos(List<EventoDTO> listadoEventos) {
		this.listadoEventos = listadoEventos;
	}

	public DetEventoDTO getDetalle() {
		return detalle;
	}

	public void setDetalle(DetEventoDTO detalle) {
		this.detalle = detalle;
	}

	public ArrayList<DetEventoDTO> getArreyDetalle() {
		return arrayDetalle;
	}

	public void setArreyDetalle(ArrayList<DetEventoDTO> arreyDetalle) {
		this.arrayDetalle = arreyDetalle;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
