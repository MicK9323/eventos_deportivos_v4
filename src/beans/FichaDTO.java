package beans;

public class FichaDTO {
	private String codFicha;
    private String codEvento;
    private String codModalidad;
    private String codSede;
    private String fecInscripci�n;
    private String codPago;
    private int estado;
    private String nomEstado;
	public String getCodFicha() {
		return codFicha;
	}
	public void setCodFicha(String codFicha) {
		this.codFicha = codFicha;
	}
	public String getCodEvento() {
		return codEvento;
	}
	public void setCodEvento(String codEvento) {
		this.codEvento = codEvento;
	}
	public String getCodModalidad() {
		return codModalidad;
	}
	public void setCodModalidad(String codModalidad) {
		this.codModalidad = codModalidad;
	}
	public String getCodSede() {
		return codSede;
	}
	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}
	public String getFecInscripci�n() {
		return fecInscripci�n;
	}
	public void setFecInscripci�n(String fecInscripci�n) {
		this.fecInscripci�n = fecInscripci�n;
	}
	public String getCodPago() {
		return codPago;
	}
	public void setCodPago(String codPago) {
		this.codPago = codPago;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNomEstado() {
		return nomEstado;
	}
	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}
}
