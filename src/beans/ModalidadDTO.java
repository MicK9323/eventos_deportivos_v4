package beans;

public class ModalidadDTO {
	private String codigo;
	private String descripcion;
	private String codDisciplina;
	private String nomDisciplina;
	private String codCategoria;
	private String nomCategoria;
	private String tipo;
	private String fecRegistro;
	private boolean estado;

	public String leerEstado(boolean estado) {
		String x = "";
		if (estado == true)
			x = "Activo";
		if (estado == false)
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

	public String getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(String codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public String getNomDisciplina() {
		return nomDisciplina;
	}

	public void setNomDisciplina(String nomDisciplina) {
		this.nomDisciplina = nomDisciplina;
	}

	public String getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getNomCategoria() {
		return nomCategoria;
	}

	public void setNomCategoria(String nomCategoria) {
		this.nomCategoria = nomCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
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
