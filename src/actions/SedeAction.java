package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import beans.SedeDTO;
import services.SedeService;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class SedeAction extends ActionSupport {
	private List<SedeDTO> listaSedes;
	private SedeDTO sede;
	private String opcion;
	private String mensaje;	
	SedeService service = new SedeService();
	
	@Action(value="/listaSedes",results= {
			@Result(name="listado",location="/crudSede.jsp")
	})
	public String listaSedes() {
		listaSedes = service.listaSedes();
		opcion = "registrar";
		return "listado";
	}
	
	@Action(value="/regSede",results= {
			@Result(name="registra",type="json")
	})
	public String regSede() {
		mensaje = service.regSede(sede);
		return "registra";
	}
	
	@Action(value="/buscaSede",results= {
			@Result(name="busca",location="/crudSede.jsp")
	})
	public String buscaSede() {
		sede = service.buscarSede(sede.getCodSede());
		listaSedes = service.listaSedes();
		opcion = "actualizar";
		return "busca";
	}
	
	@Action(value="/uptSede",results= {
			@Result(name="actualiza",type="json")
	})
	public String uptSede() {
		mensaje = service.uptSede(sede);
		return "actualiza";
	}
	
	@Action(value="/deleteSede",results= {
			@Result(name="delete",type="json")
	})
	public String deleteSede() {
		mensaje = service.delSede(sede.getCodSede());
		return "delete";
	}
	
	@Action(value="/nombreSede",results= {
			@Result(name="valida",type="json")
	})
	public String nombreSede() {
		mensaje = service.validarNombre(sede.getNomSede());
		return "valida";
	}

	public SedeDTO getSede() {
		return sede;
	}

	public void setSede(SedeDTO sede) {
		this.sede = sede;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public List<SedeDTO> getListaSedes() {
		return listaSedes;
	}

	public void setListaSedes(List<SedeDTO> listaSedes) {
		this.listaSedes = listaSedes;
	}
	
	
}
