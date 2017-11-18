package beans;

public class SedeDTO {
	private String codSede;
	private String nomSede;
	private String direccion;
	private String telf;
	private String fecRegistro;
	private boolean estado;
	
	public String leerEstado(boolean estado) {
		String x = "";
		if(estado == true)
			x = "Activo";
		if(estado == false)
			x = "Inactivo";
		return x;
	}
	
	public String getCodSede() {
		return codSede;
	}
	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}
	public String getNomSede() {
		return nomSede;
	}
	public void setNomSede(String nomSede) {
		this.nomSede = nomSede;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelf() {
		return telf;
	}
	public void setTelf(String telf) {
		this.telf = telf;
	}
	public String getFecRegistro() {
		return fecRegistro;
	}
	public void setFecRegistro(String fecRegistro) {
		this.fecRegistro = fecRegistro;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
	
}
