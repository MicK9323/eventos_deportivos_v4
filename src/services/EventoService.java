package services;

import java.util.List;

import beans.DetEventoDTO;
import beans.EventoDTO;
import beans.ModalidadDTO;
import beans.SedeDTO;
import dao.DAOFactory;
import interfaces.EventoDAO;
import interfaces.ModalidadDAO;
import interfaces.SedeDAO;
import utils.Constantes;

public class EventoService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	SedeDAO daoSede = origen.getSedeDAO();
	ModalidadDAO daoModalidad = origen.getModalidadDAO();
	EventoDAO daoEvento = origen.getEventoDAO();
	
	public List<EventoDTO> listarEventos(){
		return daoEvento.listarEventos();
	}
	public String regEvento(EventoDTO evento) {
		return daoEvento.regEvento(evento);
	}
	public List<ModalidadDTO> listaModalidades(){
		return daoModalidad.listaModalidades();
	}
	public List<SedeDTO> listaSedes(){
		return daoSede.listaSedes();
	}
	public String regDetalleEvento(DetEventoDTO detEvento) {
		return daoEvento.regDetalleEvento(detEvento);
	}
	
	public String validarNombre(String nomEquipo) {
		return daoEvento.validarNombre(nomEquipo);
	}
	
}
