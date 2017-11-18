package beans;

public class CategoriaDTO {
	private String codigo;
	private String descripcion;
	private int edadMin;
	private int edadMax;
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
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEdadMin() {
		return edadMin;
	}
	public void setEdadMin(int edadMin) {
		this.edadMin = edadMin;
	}
	public int getEdadMax() {
		return edadMax;
	}
	public void setEdadMax(int edadMax) {
		this.edadMax = edadMax;
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
