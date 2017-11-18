package beans;

public class DetEquipoDTO {
	private String cod_equipo;
    private String dni_jugador;
    private String fec_registro;
    private boolean estado;
	public String getCod_equipo() {
		return cod_equipo;
	}
	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}
	public String getDni_jugador() {
		return dni_jugador;
	}
	public void setDni_jugador(String dni_jugador) {
		this.dni_jugador = dni_jugador;
	}
	public String getFec_registro() {
		return fec_registro;
	}
	public void setFec_registro(String fec_registro) {
		this.fec_registro = fec_registro;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
    
}
