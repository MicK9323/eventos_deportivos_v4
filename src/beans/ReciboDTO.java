package beans;

public class ReciboDTO {
	private String numFicha;
	private String numPago;
	private Double monto;
	private String fecPago;
	private int estado;
	private String descEstado;
	
	
	public String getNumFicha() {
		return numFicha;
	}
	public void setNumFicha(String numFicha) {
		this.numFicha = numFicha;
	}
	public String getNumPago() {
		return numPago;
	}
	public void setNumPago(String numPago) {
		this.numPago = numPago;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	public String getFecPago() {
		return fecPago;
	}
	public void setFecPago(String fecPago) {
		this.fecPago = fecPago;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getDescEstado() {
		return descEstado;
	}
	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}
	
}
