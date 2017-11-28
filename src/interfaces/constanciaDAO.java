package interfaces;

import java.util.List;

import beans.ConstanciaDTO;
import beans.JugadorDTO;

public interface constanciaDAO {
	
	public ConstanciaDTO datosContancia(String numFicha);
	public List<JugadorDTO> detalleEquipo(String codEquipo);
	
}
