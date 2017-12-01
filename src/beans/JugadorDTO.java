package beans;

import java.io.File;

public class JugadorDTO {

	private String dni_jugador;
	private String clave;
	private int idRol;
    private String nom_jugador;
    private String ape_jugador;
    private String fec_nac;
    private int edad;
    private String sexo;
    private String estCivil;
    private String telfDomicilio;
    private String telfMovil;
    private String domicilio;
    private String email;
    private String codSede;
    private String nomSede;
    private File foto;
    private byte[] FotoByte;
    private String FotoContentType;
    private String FotoFileName;    
    private int estado;
    
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
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public File getFoto() {
		return foto;
	}
	public void setFoto(File foto) {
		this.foto = foto;
	}
	public byte[] getFotoByte() {
		return FotoByte;
	}
	public void setFotoByte(byte[] fotoByte) {
		FotoByte = fotoByte;
	}
	public String getFotoContentType() {
		return FotoContentType;
	}
	public void setFotoContentType(String fotoContentType) {
		FotoContentType = fotoContentType;
	}
	public String getFotoFileName() {
		return FotoFileName;
	}
	public void setFotoFileName(String fotoFileName) {
		FotoFileName = fotoFileName;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
