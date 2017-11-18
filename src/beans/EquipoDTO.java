package beans;

public class EquipoDTO {
	private String cod_equipo;
	private String nom_equipo;
	private String dni_delegado;
	private String cod_ficha;
	private String fec_registro;
	private boolean estado;

	public String getCod_equipo() {
		return cod_equipo;
	}

	public void setCod_equipo(String cod_equipo) {
		this.cod_equipo = cod_equipo;
	}

	public String getNom_equipo() {
		return nom_equipo;
	}

	public void setNom_equipo(String nom_equipo) {
		this.nom_equipo = nom_equipo;
	}

	public String getDni_delegado() {
		return dni_delegado;
	}

	public void setDni_delegado(String dni_delegado) {
		this.dni_delegado = dni_delegado;
	}

	public String getCod_ficha() {
		return cod_ficha;
	}

	public void setCod_ficha(String cod_ficha) {
		this.cod_ficha = cod_ficha;
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
