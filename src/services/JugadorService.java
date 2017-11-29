package services;

import java.util.List;

import beans.JugadorDTO;
import dao.DAOFactory;
import interfaces.JugadorDAO;
import utils.Constantes;

public class JugadorService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	JugadorDAO dao = origen.getJugadorDAO();
	
	public List<JugadorDTO> listaJugadores(){
		return dao.listaJugadores();
	}
}
