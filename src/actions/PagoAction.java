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
//			 equipo = service.detalleEquipo(datos.getCod_equipo());
		 }		 
		 return "datos";
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


	
}
