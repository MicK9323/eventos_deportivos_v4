package interfaces;

import java.sql.SQLException;

public interface FichaDAO {
	public String getCorrelativoFicha() throws SQLException;

	public String getCorrelativoEquipo() throws SQLException;
	
	public boolean validarSede(String dni, String codEvento);

	public String inscribirEquipo(String vCodEvento, String vCodModalidad, String vNomEquipo, String vDni,
			String vCodPago) throws SQLException;
}