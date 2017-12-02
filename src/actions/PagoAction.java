package actions;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import beans.ConstanciaDTO;
import beans.JugadorDTO;
import services.PagoService;
import utils.Correos;

@ParentPackage("pit")
public class PagoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4249178914019465831L;
	
	PagoService service = new PagoService();
	private ConstanciaDTO datos;
	private List<JugadorDTO> equipo;
	private String ficha;
	private String monto;
	private String mensaje;
	private String status;
	private String codEquipo;
	
	 @Action(value="/cargarPago",results= {
			 @Result(name="datos",type="json")
	 })
	 public String cargarPago() {
		 System.out.println(ficha);
		 monto = service.consultarPago(ficha);		 
		 System.out.println(monto);
		 Double pago = Double.parseDouble(monto);
		 if(pago > 0) {
			 datos = service.datosContancia(ficha);			 
		 }		 
		 return "datos";
	 }
	 
	 @Action(value="/registrarPago",results= {
			 @Result(name="pagado",type="json"),
			 @Result(name="error",type="json")
	 })
	 public String registrarPago() {
		 Double pago = Double.parseDouble(monto);
		 mensaje = service.registrarPago(ficha, pago);
		 datos = service.datosContancia(ficha);
		 equipo = service.detalleEquipo(codEquipo);
		 if(mensaje == "ok") {
			 for(JugadorDTO x : equipo) {
				 status = "Enviando Correos";
				 String nombre = x.getNom_jugador();
				 new Correos().enviarBoleta(x.getEmail(), datos, monto, nombre);
			 }
			 status ="Finalizado";
			 return "pagado";
		 }else {
			 return "error";
		 }
	 }
	
	public String getFicha() {
		return ficha;
	}
	public void setFicha(String ficha) {
		this.ficha = ficha;
	}
	public ConstanciaDTO getDatos() {
		return datos;
	}
	public void setDatos(ConstanciaDTO datos) {
		this.datos = datos;
	}
	public List<JugadorDTO> getEquipo() {
		return equipo;
	}
	public void setEquipo(List<JugadorDTO> equipo) {
		this.equipo = equipo;
	}

	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodEquipo() {
		return codEquipo;
	}

	public void setCodEquipo(String codEquipo) {
		this.codEquipo = codEquipo;
	}

	
	
}
