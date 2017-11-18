package services;

import java.sql.SQLException;
import java.util.List;

import beans.DetEventoDTO;
import beans.EventoDTO;
import beans.JugadorDTO;
import dao.DAOFactory;
import interfaces.EquipoDAO;
import interfaces.EventoDAO;
import interfaces.FichaDAO;
import interfaces.JugadorDAO;
import utils.Constantes;

public class InscripcionService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	EventoDAO daoEvento = origen.getEventoDAO();
	FichaDAO daoFicha = origen.getFichaDAO();
	EquipoDAO daoEquipo = origen.getEquipoDAO();
	JugadorDAO daoJugador = origen.getJugadorDAO();

	public List<EventoDTO> listarEventosDisponibles() {
		return daoEvento.listarEventosDisponibles();
	}

	public List<DetEventoDTO> detalleEventoxSede(String codEvento, String codSede, int rol) {
		return daoEvento.detalleEventoxSede(codEvento, codSede, rol);
	}

	public boolean validarSede(String dni, String codEvento) {
		return daoFicha.validarSede(dni, codEvento);
	}

	public String validarJugador(String dni, String codModalidad, String codEvento) throws SQLException {
		return daoJugador.validarJugador(dni, codModalidad, codEvento);
	}

	public JugadorDTO datosJugador(String dni) throws SQLException {
		return daoJugador.datosJugador(dni);
	}

	public String inscribirEquipo(String vCodEvento, String vCodModalidad, String vNomEquipo, String vDni,
			String vCodPago) throws SQLException {
		return daoFicha.inscribirEquipo(vCodEvento, vCodModalidad, vNomEquipo, vDni, vCodPago);
	}

	public String addJugador(String vCodEquipo, String vDniJugador) throws SQLException {
		return daoEquipo.addJugador(vCodEquipo, vDniJugador);
	}

	public String validarNombre(String nomEquipo) throws SQLException {
		return daoEquipo.validarNombre(nomEquipo);
	}

}
