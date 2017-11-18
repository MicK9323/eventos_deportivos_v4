package services;

import java.util.List;

import org.apache.struts2.convention.annotation.ParentPackage;

import beans.EnlaceDTO;
import beans.JugadorDTO;
import dao.DAOFactory;
import interfaces.loginDAO;
import utils.Constantes;

@ParentPackage("pit")
public class LoginService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	loginDAO dao = origen.getLoginDAO();
	
	public JugadorDTO loginJugador(String dni, String clave) {
		return dao.loginJugador(dni, clave);
	}
	public List<EnlaceDTO> obtenerEnlacesInscripcion(String dni){
		return dao.obtenerEnlacesInscripcion(dni);
	}
	public List<EnlaceDTO> obtenerEnlacesMenuAdmin(String dni){
		return dao.obtenerEnlacesMenuAdmin(dni);
	}
	public List<EnlaceDTO> obtenerEnlacesMantenimiento(String dni){
		return dao.obtenerEnlacesMantenimiento(dni);
	}
	public List<EnlaceDTO> obtenerEnlacesEventos(String dni){
		return dao.obtenerEnlacesEventos(dni);
	}
	
}
