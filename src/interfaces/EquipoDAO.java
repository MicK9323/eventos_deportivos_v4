package interfaces;

import java.sql.SQLException;

public interface EquipoDAO {
	public String addJugador(String vCodEquipo,String vDniJugador) throws SQLException;
	public String validarNombre(String nomEquipo) throws SQLException;
}

