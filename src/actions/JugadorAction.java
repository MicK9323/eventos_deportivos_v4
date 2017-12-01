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

	@Action(value = "/importarData", results = { @Result(name = "importado", location = "/listaJugadores.jsp") })
	public String importarData() {
		ArrayList<JugadorDTO> data = met.dataCSV(archivo);
		if (data != null) {
			String confirm = service.importarJugadores(data);
			if (confirm == "ok") {
				lista = service.listaJugadores();
				mostrar = true;
				msg = "Importacion Correcta";
			} else {
				lista = service.listaJugadores();
				mostrar = true;
				msg = "Error en la importacion";
			}
		} else {
			lista = service.listaJugadores();
			mostrar = true;
			msg = "No hay data que importar";
		}
		return "importado";
	}

	@Action(value = "/dataJugador", results = { @Result(name = "datos", location = "/nuevoJugador.jsp") })
	public String dataJugador() {
		sedes = service.listaSedes();
		roles = service.listaRoles();
		return "datos";
	}

	@Action(value = "/registraJugador", results = { @Result(name = "registra", location = "/listaJugadores.jsp"),
			@Result(name = "regError", location = "/nuevoJugador.jsp") })
	public String registraJugador() throws IOException {
		JugadorDTO obj = jugador;
		File file = obj.getFoto();
		int kb = met.getLongfile(file);
		if (kb <= 100) {
			byte[] array = met.getBytesFromFile(file);
			obj.setFotoByte(array);
			obj.setFotoFileName(obj.getDni_jugador());
			msg = service.regJugador(obj);
			if (msg == "ok") {
				mostrar = true;
				msg = "Registro Existoso";
				lista = service.listaJugadores();
				return "registra";
			} else {
				jugador = obj;
				listarDatos();
				mostrar = true;
				return "regError";
			}
		} else {
			jugador = obj;
			listarDatos();
			mostrar = true;
			msg = "Tamaño de la foto excede los 100KB";
			return "regError";
		}
	}

	@Action(value = "/mostrarJugador", results = { 
			@Result(name = "encuentra", location = "/encuentraJugador.jsp"),
			@Result(name = "noencuentra", location = "/listaJugadores.jsp") 
			})
	public String buscarJugador() {
		JugadorDTO obj = service.buscarJugador(jugador.getDni_jugador());
		if (obj != null) {
			listarDatos();
			return "encuentra";
		} else {
			mostrar = true;
			msg = "Jugador no encontrado";
			listado();
			return "noencuentra";
		}
	}

	@Action(value = "verFoto", results = {
			@Result(params = { "inputName", "foto" }, name = "success", type = "stream") 
			})
	public String verFoto() throws Exception {
		try {
			//EmpleadoDTO bean = new EmpleadoService().buscarFotoEmpleado(idCodigo);
			//foto = new ByteArrayInputStream(bean.getFotoByte());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	void listarDatos() {
		sedes = service.listaSedes();
		roles = service.listaRoles();
	}

	void listado() {
		lista = service.listaJugadores();
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
