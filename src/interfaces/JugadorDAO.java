package interfaces;

import java.sql.SQLException;
import java.util.List;

import beans.JugadorDTO;

public interface JugadorDAO {
	public String validarJugador(String dni, String codModalidad, String codEvento) throws SQLException;
	public JugadorDTO datosJugador(String dni) throws SQLException;
	public List<JugadorDTO> listaJugadores();
}
