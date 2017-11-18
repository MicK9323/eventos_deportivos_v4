package beans;

import java.io.Serializable;

public class JugadorDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6930712121076987493L;
	private String dni_jugador;
	private String clave;
	private int idRol;
    private String nom_jugador;
    private String ape_jugador;
    private String fec_nac;
    private int edad;
    private String sexo;
    private int codEstCivil;
    private String estCivil;
    private String telfDomicilio;
    private String telfMovil;
    private String idUbigueo;
    private String nomUbigueo;
    private String profesion;
    private String domicilio;
    private String dirTrabajo;
    private String email;
    private String codSede;
    private String nomSede;
    private String foto;
    private boolean estado;
    
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	public String getNomSede() {
		return nomSede;
	}
	public void setNomSede(String nomSede) {
		this.nomSede = nomSede;
	}
	public String getCodSede() {
		return codSede;
	}
	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}
	public String getDni_jugador() {
		return dni_jugador;
	}
	public void setDni_jugador(String dni_jugador) {
		this.dni_jugador = dni_jugador;
	}
	public String getNom_jugador() {
		return nom_jugador;
	}
	public void setNom_jugador(String nom_jugador) {
		this.nom_jugador = nom_jugador;
	}
	public String getApe_jugador() {
		return ape_jugador;
	}
	public void setApe_jugador(String ape_jugador) {
		this.ape_jugador = ape_jugador;
	}
	public String getFec_nac() {
		return fec_nac;
	}
	public void setFec_nac(String fec_nac) {
		this.fec_nac = fec_nac;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getCodEstCivil() {
		return codEstCivil;
	}
	public void setCodEstCivil(int codEstCivil) {
		this.codEstCivil = codEstCivil;
	}
	public String getEstCivil() {
		return estCivil;
	}
	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}
	public String getTelfDomicilio() {
		return telfDomicilio;
	}
	public void setTelfDomicilio(String telfDomicilio) {
		this.telfDomicilio = telfDomicilio;
	}
	public String getTelfMovil() {
		return telfMovil;
	}
	public void setTelfMovil(String telfMovil) {
		this.telfMovil = telfMovil;
	}
	public String getIdUbigueo() {
		return idUbigueo;
	}
	public void setIdUbigueo(String idUbigueo) {
		this.idUbigueo = idUbigueo;
	}
	public String getNomUbigueo() {
		return nomUbigueo;
	}
	public void setNomUbigueo(String nomUbigueo) {
		this.nomUbigueo = nomUbigueo;
	}
	public String getProfesion() {
		return profesion;
	}
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getDirTrabajo() {
		return dirTrabajo;
	}
	public void setDirTrabajo(String dirTrabajo) {
		this.dirTrabajo = dirTrabajo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
       
	
    
    
    
}
