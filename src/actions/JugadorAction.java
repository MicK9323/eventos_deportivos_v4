package actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import beans.EnlaceDTO;
import beans.JugadorDTO;
import beans.SedeDTO;
import services.JugadorService;
import utils.Constantes;
import utils.Metodos;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class JugadorAction extends ActionSupport {
	JugadorService service = new JugadorService();
	Metodos met = new Metodos();
	private File archivo;
	private List<JugadorDTO> lista;
	private List<SedeDTO> sedes;
	private List<EnlaceDTO> roles;
	private String dni;
	private JugadorDTO jugador;
	private String msg;
	private boolean mostrar = false;

	@Action(value = "/listaJugadores", results = { @Result(name = "lista", location = "/listaJugadores.jsp") })
	public String listaJugadores() {
		lista = service.listaJugadores();
		return "lista";
	}
	
	@Action(value="/importarData",results= {
			@Result(name="importado",location = "/listaJugadores.jsp")
	})
	public String importarData() {
		ArrayList<JugadorDTO> data = met.dataCSV(archivo);
		if(data != null) {
			String confirm = service.importarJugadores(data);
			if(confirm == "ok") {
				lista = service.listaJugadores();
				mostrar = true;
				msg = "Importacion Correcta";
			}else {
				lista = service.listaJugadores();
				mostrar = true;
				msg = "Error en la importacion";
			}
		}else {
			lista = service.listaJugadores();
			mostrar = true;
			msg = "No hay data que importar";
		}
		return "importado";
	}
	
	@Action(value="/dataJugador",results= {
			@Result(name="datos",location="/nuevoJugador.jsp")
	})
	public String dataJugador() {
		sedes = service.listaSedes();
		roles = service.listaRoles();
		return "datos";
	}
	
	@Action(value="/registraJugador",results= {
			@Result(name="registra",location="/listaJugadores.jsp"),
			@Result(name="regError",type="redirectAction",params= {"actionName","/dataJugador"})
	})	
	public String registraJugador() throws IOException {
		byte[] array = met.getBytesFromFile(jugador.getFoto());
		return null;
		
	}
	
	
	public List<JugadorDTO> getLista() {
		return lista;
	}

	public void setLista(List<JugadorDTO> lista) {
		this.lista = lista;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public JugadorDTO getJugador() {
		return jugador;
	}

	public void setJugador(JugadorDTO jugador) {
		this.jugador = jugador;
	}

	public File getArchivo() {
		return archivo;
	}

	public void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isMostrar() {
		return mostrar;
	}

	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}

	public List<SedeDTO> getSedes() {
		return sedes;
	}

	public void setSedes(List<SedeDTO> sedes) {
		this.sedes = sedes;
	}

	public List<EnlaceDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<EnlaceDTO> roles) {
		this.roles = roles;
	}
	
}
