package services;

import java.util.ArrayList;
import java.util.List;

import beans.EnlaceDTO;
import beans.JugadorDTO;
import beans.SedeDTO;
import dao.DAOFactory;
import interfaces.JugadorDAO;
import interfaces.SedeDAO;
import interfaces.loginDAO;
import utils.Constantes;

public class JugadorService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	JugadorDAO daoJugador = origen.getJugadorDAO();
	SedeDAO daoSede = origen.getSedeDAO();
	loginDAO daoEnlace = origen.getLoginDAO();
	
	public List<JugadorDTO> listaJugadores(){
		return daoJugador.listaJugadores();
	}
	public String importarJugadores(ArrayList<JugadorDTO> data) {
		return daoJugador.importarJugadores(data);
	}
	public List<SedeDTO> listaSedes(){
		return daoSede.listaSedes();
	}
	public List<EnlaceDTO> listaRoles(){
		return daoEnlace.listaRoles();
	}
	
	//CRUD
	public String regJugador(JugadorDTO x) {
		return daoJugador.regJugador(x);
	}
	public String uptJugador(JugadorDTO x) {
		return daoJugador.uptJugador(x);
	}
	public String delJugador(JugadorDTO x) {
		return daoJugador.delJugador(x);
	}
	public JugadorDTO buscarJugador(String dni) {
		return daoJugador.buscarJugador(dni);
	}
	public JugadorDTO buscarFoto(String dni) {
		return daoJugador.buscarFoto(dni);
	}
	
}
