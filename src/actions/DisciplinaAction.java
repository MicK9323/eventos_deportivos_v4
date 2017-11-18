package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import beans.DisciplinaDTO;
import services.DisciplinaService;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class DisciplinaAction extends ActionSupport {
	private DisciplinaDTO disciplina;
	private List<DisciplinaDTO> listaDisciplina;
	private String mensaje;
	private String opcion="";
	
	@Action(value="/listadoDisciplina",results= {
			@Result(name="listado",location="/crudDisciplina.jsp")
	})
	public String listadoDisciplina() {
		listaDisciplina = new DisciplinaService().listaDisciplinas();
		opcion = "registrar";
		return "listado";
	}
	
	@Action(value="/regDisciplina",results= {
			@Result(name="registra",type="json")
	})
	public String regDisciplina() {
		mensaje = new DisciplinaService().regDisciplina(disciplina);
		return "registra";
	}
	
	@Action(value="/findDisciplina",results= {
			@Result(name="busca",location="/crudDisciplina.jsp")
	})
	public String findDisciplina() {
		disciplina = new DisciplinaService().buscarDisciplina(disciplina.getCodigo());
		listaDisciplina = new DisciplinaService().listaDisciplinas();
		opcion = "actualizar";
		return "busca";
	}
	
	@Action(value="/uptDisciplina",results= {
			@Result(name="actualiza",type="json")
	})
	public String uptDisciplina() {
		mensaje = new DisciplinaService().uptDisciplina(disciplina);
		return "actualiza";
	}
	
	@Action(value="/delDisciplina",results= {
			@Result(name="elimina",type="json")
	})
	public String delDisciplina() {
		mensaje = new DisciplinaService().delDisciplina(disciplina.getCodigo());
		return "elimina";
	}
	
	@Action(value="/nombreDisciplina",results= {
			@Result(name="valida",type="json")
	})
	public String nombreDisciplina() {
		mensaje = new DisciplinaService().validarNombre(disciplina.getDescripcion());
		return "valida";
	}
	
	public DisciplinaDTO getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(DisciplinaDTO disciplina) {
		this.disciplina = disciplina;
	}
	public List<DisciplinaDTO> getListaDisciplina() {
		return listaDisciplina;
	}
	public void setListaDisciplina(List<DisciplinaDTO> listaDisciplina) {
		this.listaDisciplina = listaDisciplina;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}
	
}
