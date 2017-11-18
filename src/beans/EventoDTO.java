package beans;

public class EventoDTO {
	private String cod_evento;
	private String desc_evento;
	private String participantes;
	private int estado;
	private String nom_estado;
	private String inicio_inscripcion;
	private String fin_inscripcion;
	private String inicio_evento;
	private String fin_evento;
	
	public String getCod_evento() {
		return cod_evento;
	}
	public void setCod_evento(String cod_evento) {
		this.cod_evento = cod_evento;
	}
	public String getDesc_evento() {
		return desc_evento;
	}
	public void setDesc_evento(String desc_evento) {
		this.desc_evento = desc_evento;
	}
	public String getParticipantes() {
		return participantes;
	}
	public void setParticipantes(String participantes) {
		this.participantes = participantes;
	}
	public String getNom_estado() {
		return nom_estado;
	}
	public void setNom_estado(String nom_estado) {
		this.nom_estado = nom_estado;
	}
	public String getInicio_inscripcion() {
		return inicio_inscripcion;
	}
	public void setInicio_inscripcion(String inicio_inscripcion) {
		this.inicio_inscripcion = inicio_inscripcion;
	}
	public String getFin_inscripcion() {
		return fin_inscripcion;
	}
	public void setFin_inscripcion(String fin_inscripcion) {
		this.fin_inscripcion = fin_inscripcion;
	}
	public String getInicio_evento() {
		return inicio_evento;
	}
	public void setInicio_evento(String inicio_evento) {
		this.inicio_evento = inicio_evento;
	}
	public String getFin_evento() {
		return fin_evento;
	}
	public void setFin_evento(String fin_evento) {
		this.fin_evento = fin_evento;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
		
	
	
}
