package interfaces;

import java.util.List;
import beans.SedeDTO;

public interface SedeDAO {
	public List<SedeDTO> listaSedes();
	public String regSede(SedeDTO x);
	public SedeDTO buscarSede(String codigo);
	public String uptSede(SedeDTO x);
	public String delSede(String codigo);
	public String validarNombre(String nombre);
}
