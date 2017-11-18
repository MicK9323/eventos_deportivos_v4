package interfaces;

import java.util.List;

import beans.EnlaceDTO;
import beans.JugadorDTO;

public interface loginDAO {
	public JugadorDTO loginJugador(String dni, String clave);
	public List<EnlaceDTO> obtenerEnlacesInscripcion(String dni);
	public List<EnlaceDTO> obtenerEnlacesMenuAdmin(String dni);
	public List<EnlaceDTO> obtenerEnlacesMantenimiento(String dni);
	public List<EnlaceDTO> obtenerEnlacesEventos(String dni);
}
