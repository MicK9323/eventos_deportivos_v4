package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import beans.CategoriaDTO;
import services.CategoriaService;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class CategoriaAction extends ActionSupport {
	private List<CategoriaDTO> listaCategoria;
	private CategoriaDTO categoria;
	private String opcion;
	private String mensaje;
	
	CategoriaService serv = new CategoriaService();
	
	@Action(value="/listaCategorias",results= {
			@Result(name="listado",location="/crudCategoria.jsp")
	})
	public String listaCategorias() {
		listaCategoria = serv.listaCategorias();
		opcion = "registrar";
		return "listado";
	}
	
	@Action(value="/regCategoria",results= {
			@Result(name="registra",type="json")
	})
	public String regCategoria() {
		mensaje = serv.regCategoria(categoria);
		return "registra";
	}
	
	@Action(value="/buscaCategoria",results= {
			@Result(name="busca",location="/crudCategoria.jsp")
	})
	public String buscaCategoria() {
		categoria = serv.buscarCategoria(categoria.getCodigo());
		listaCategoria = serv.listaCategorias();
		opcion = "actualizar";
		return "busca";
	}
	
	@Action(value="/uptCategoria",results= {
			@Result(name="actualiza",type="json")
	})
	public String uptCategoria() {
		mensaje = serv.uptCategoria(categoria);
		return "actualiza";
	}
	
	@Action(value="/deleteCategoria",results= {
			@Result(name="delete",type="json")
	})
	public String deleteCategoria() {
		mensaje = serv.delCategoria(categoria.getCodigo());
		return "delete";
	}
	
	@Action(value="/nombreCategoria",results= {
			@Result(name="valida",type="json")
	})
	public String nombreCategoria() {
		mensaje = serv.validarNombre(categoria.getDescripcion());
		return "valida";
	}
	
	public List<CategoriaDTO> getListaCategoria() {
		return listaCategoria;
	}
	public void setListaCategoria(List<CategoriaDTO> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}
	public CategoriaDTO getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
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
}
