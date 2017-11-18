package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import beans.CategoriaDTO;
import beans.DisciplinaDTO;
import beans.ModalidadDTO;
import services.ModalidadService;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class ModalidadAction extends ActionSupport {
	ModalidadService dao = new ModalidadService();
	private ModalidadDTO modalidad;
	private List<ModalidadDTO> listaModalidades;
	private List<DisciplinaDTO> listaDisciplinas;
	private List<CategoriaDTO> listaCategorias;
	private String opcion;
	private String mensaje;
	
	@Action(value="/listaModalidad",results= {
			@Result(name="listado",location="/crudModalidad.jsp")
	})
	public String listaModalidades() {
		listaModalidades = dao.listaModalidades();
		listaDisciplinas = dao.listaDisciplinas();
		listaCategorias = dao.listaCategorias();
		opcion = "registrar";
		return "listado";
	}
	
	@Action(value="/regModalidad",results= {
			@Result(name="registra",type="json")
	})
	public String regModalidad() {
		mensaje = dao.regModalidad(modalidad);
		return "registra";
	}
	
	@Action(value="/uptModalidad",results= {
			@Result(name="actualiza",type="json")
	})
	public String uptModalidad() {
		mensaje = dao.uptModalidad(modalidad);
		return "actualiza";
	}
	
	@Action(value="/buscaModalidad",results= {
			@Result(name="busca",location="/crudModalidad.jsp")
	})
	public String buscaModalidad() {
		modalidad = dao.buscaModalidad(modalidad.getCodigo());
		listaModalidades = dao.listaModalidades();
		listaDisciplinas = dao.listaDisciplinas();
		listaCategorias = dao.listaCategorias();
		opcion = "actualizar";
		return "busca";
	}
	
	@Action(value="/deleteModalidad",results= {
			@Result(name="elimina",type="json")
	})
	public String deleteModalidad() {
		mensaje = dao.deleteModalidad(modalidad.getCodigo());
		return "elimina";
	}
	
	@Action(value="/nombreModalidad",results= {
			@Result(name="valida",type="json")
	})
	public String nombreModalidad() {
		mensaje = dao.validarNombre(modalidad.getDescripcion());
		return "valida";
	}
	
	public ModalidadDTO getModalidad() {
		return modalidad;
	}
	public void setModalidad(ModalidadDTO modalidad) {
		this.modalidad = modalidad;
	}
	public List<ModalidadDTO> getListaModalidades() {
		return listaModalidades;
	}
	public void setListaModalidades(List<ModalidadDTO> listaModalidades) {
		this.listaModalidades = listaModalidades;
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

	public List<DisciplinaDTO> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void setListaDisciplinas(List<DisciplinaDTO> listaDisciplinas) {
		this.listaDisciplinas = listaDisciplinas;
	}

	public List<CategoriaDTO> getListaCategorias() {
		return listaCategorias;
	}

	public void setListaCategorias(List<CategoriaDTO> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}
	
}
