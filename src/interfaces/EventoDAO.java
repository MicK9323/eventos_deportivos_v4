package interfaces;

import java.util.List;

import beans.DetEventoDTO;
import beans.EventoDTO;

public interface EventoDAO {
	public List<EventoDTO> listarEventosDisponibles();
	public List<EventoDTO> listarEventos();
//	public EventoDTO buscarEvento(String codEvento);
	public String regEvento(EventoDTO evento);
//	public String uptEvento(EventoDTO evento);
//	public String deleteEvento(String codEvento);
	public String validarNombre(String nomEquipo);
	
	public List<DetEventoDTO> detalleEventoxSede(String codEvento, String codSede, int rol);
//	public List<DetEventoDTO> buscarDetalleEvento(String codEvento);
	public String regDetalleEvento(DetEventoDTO detEvento);
//	public String deleteDetEvento(String codEvento, String codModalidad, String codSede);
}
