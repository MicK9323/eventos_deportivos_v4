package beans;

public class DetEventoDTO {
	private String cod_evento;
	private String nomEvento;
	private String cod_modalidad;
	private String tipoModalidad;
	private String nomModalidad;
	private String cod_sede;
	private String nomSede;
	private String fec_inicio;
	private String fec_fin;
	private int cantIntegrantes;
	private int cantMujeres;
	private int cantVarones;
	private int maxEquipos;
	private int disponibles;
	private int estado;
	private String nomEstado;
	
	public String varones(int cantVarones) {
		String cant = "";
		if(cantVarones > 0) {
			cant = ""+cantVarones;
		}else {
			cant = "No Aplica";
		}
		return cant;
	}
	
	public String mujeres(int cantMujeres) {
		String cant = "";
		if(cantMujeres > 0) {
			cant = ""+cantMujeres;
		}else {
			cant = "No Aplica";
		}
		return cant;
	}

	public String getCod_evento() {
		return cod_evento;
	}

	public void setCod_evento(String cod_evento) {
		this.cod_evento = cod_evento;
	}

	public String getNomEvento() {
		return nomEvento;
	}

	public void setNomEvento(String nomEvento) {
		this.nomEvento = nomEvento;
	}

	public String getCod_modalidad() {
		return cod_modalidad;
	}

	public void setCod_modalidad(String cod_modalidad) {
		this.cod_modalidad = cod_modalidad;
	}

	public String getTipoModalidad() {
		return tipoModalidad;
	}

	public void setTipoModalidad(String tipoModalidad) {
		this.tipoModalidad = tipoModalidad;
	}

	public String getNomModalidad() {
		return nomModalidad;
	}

	public void setNomModalidad(String nomModalidad) {
		this.nomModalidad = nomModalidad;
	}

	public String getCod_sede() {
		return cod_sede;
	}

	public void setCod_sede(String cod_sede) {
		this.cod_sede = cod_sede;
	}

	public String getNomSede() {
		return nomSede;
	}

	public void setNomSede(String nomSede) {
		this.nomSede = nomSede;
	}

	public String getFec_inicio() {
		return fec_inicio;
	}

	public void setFec_inicio(String fec_inicio) {
		this.fec_inicio = fec_inicio;
	}

	public String getFec_fin() {
		return fec_fin;
	}

	public void setFec_fin(String fec_fin) {
		this.fec_fin = fec_fin;
	}

	public int getCantIntegrantes() {
		return cantIntegrantes;
	}

	public void setCantIntegrantes(int cantIntegrantes) {
		this.cantIntegrantes = cantIntegrantes;
	}

	public int getCantMujeres() {
		return cantMujeres;
	}

	public void setCantMujeres(int cantMujeres) {
		this.cantMujeres = cantMujeres;
	}

	public int getCantVarones() {
		return cantVarones;
	}

	public void setCantVarones(int cantVarones) {
		this.cantVarones = cantVarones;
	}

	public int getMaxEquipos() {
		return maxEquipos;
	}

	public void setMaxEquipos(int maxEquipos) {
		this.maxEquipos = maxEquipos;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
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
