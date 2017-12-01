package actions;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;
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
	private InputStream foto;
	private Map<String, Object> session	= ActionContext.getContext().getSession();
	
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
			@Result(name = "muestra", location = "/encuentraJugador.jsp"),
			@Result(name = "nomuestra", location = "/index.jsp") 
			})
	public String mostrarJugador() {
		jugador = (JugadorDTO) session.get("usuario");
		if (jugador != null) {
			listarDatos();
			return "muestra";
		} else {
			mostrar = true;
			msg = "Jugador no encontrado";
			listado();
			return "nomuestra";
		}
	}
	
	@Action(value = "mostrarFoto",results={@Result(
			params={"inputName","foto"}, 
			name = "muestraFoto", type="stream")})
	public String verFoto() throws Exception {
		try {
			JugadorDTO obj =  (JugadorDTO) session.get("usuario");
			byte[] array = obj.getFotoByte();
			foto= new ByteArrayInputStream(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "muestraFoto";
	}
	
	@Action(value = "/buscaJugador", results = { 
			@Result(name = "encuentra", location = "/uptJugador.jsp"),
			@Result(name = "noencuentra", location = "/listaJugadores.jsp") 
			})
	public String buscaJugador() {
		jugador = service.buscarJugador(met.decodificarBase64(dni));
		if (jugador != null) {
			listarDatos();
			return "encuentra";
		} else {
			mostrar = true;
			msg = "Jugador no encontrado";
			listado();
			return "noencuentra";
		}
	}
	
	@Action(value = "buscarFoto",results={@Result(
			params={"inputName","foto"}, 
			name = "getFoto", type="stream")})
	public String buscarFoto() throws Exception {
		try {
			JugadorDTO obj =  service.buscarFoto(met.decodificarBase64(dni));
			foto= new ByteArrayInputStream(obj.getFotoByte());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "getFoto";
	}
	
	
	@Action(value = "/actualizaDatos", results = { 
			@Result(name = "actualiza", location = "/encuentraJugador.jsp"),
			@Result(name = "uptError", location = "/encuentraJugador.jsp")
	})
	public String actualizaDatos() throws IOException {
		JugadorDTO obj = jugador;
		InputStream img = foto;
		File file = obj.getFoto();
		int kb = met.getLongfile(file);
		if (kb <= 100) {
			byte[] array = met.getBytesFromFile(file);
			obj.setFotoByte(array);
			obj.setFotoFileName(obj.getDni_jugador());
			msg = service.uptJugador(obj);
			if (msg == "ok") {
				mostrar = true;
				msg = "Actualizacion Existosa";
				listarDatos();
				return "actualiza";
			} else {
				foto = img;
				jugador = obj;
				listarDatos();
				mostrar = true;
				return "uptError";
			}
		} else {
			foto = img;
			jugador = obj;
			listarDatos();
			mostrar = true;
			msg = "Tamaño de la foto excede los 100KB";
			return "uptError";
		}
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

	public InputStream getFoto() {
		return foto;
	}

	public void setFoto(InputStream foto) {
		this.foto = foto;
	}

	public Metodos getMet() {
		return met;
	}

	public void setMet(Metodos met) {
		this.met = met;
	}

}
