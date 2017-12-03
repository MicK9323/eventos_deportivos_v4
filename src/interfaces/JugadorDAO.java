package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.JugadorDTO;

public interface JugadorDAO {
	public String validarJugador(String dni, String codModalidad, String codEvento) throws SQLException;
	public JugadorDTO datosJugador(String dni) throws SQLException;
	public List<JugadorDTO> listaJugadores();
	public String importarJugadores(ArrayList<JugadorDTO> data);
	
	//CRUD
	public String regJugador(JugadorDTO x);
	public String uptJugador(JugadorDTO x);
	public String delJugador(String dni);
	public JugadorDTO buscarJugador(String dni);
	public JugadorDTO buscarFoto(String dni);
}
