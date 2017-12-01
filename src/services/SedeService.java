package services;

import java.util.List;

import beans.SedeDTO;
import dao.DAOFactory;
import interfaces.SedeDAO;
import utils.Constantes;

public class SedeService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	SedeDAO dao = origen.getSedeDAO();
	
	public List<SedeDTO> listaSedes(){
		return dao.listaSedes();
	}
	public String regSede(SedeDTO x) {
		return dao.regSede(x);
	}
	public SedeDTO buscarSede(String codigo) {
		return dao.buscarSede(codigo);
	}
	public String uptSede(SedeDTO x) {
		return dao.uptSede(x);
	}
	public String delSede(String codigo) {
		return dao.delSede(codigo);
	}
	public String validarNombre(String nombre) {
		return dao.validarNombre(nombre);
	}
}
