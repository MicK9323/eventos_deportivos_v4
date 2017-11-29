package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;

import beans.JugadorDTO;
import services.JugadorService;

@ParentPackage("pit")
@SuppressWarnings("serial")
public class JugadorAction extends ActionSupport {
	JugadorService service = new JugadorService();
	
	private List<JugadorDTO> lista;
	private String dni;
	private JugadorDTO jugador;
	
	@Action(value="/listaJugadores",results= {
			@Result(name="lista",location="/listaJugadores.jsp")
	})
	public String listaJugadores() {
		lista = service.listaJugadores();
		return "lista";
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
	
}
