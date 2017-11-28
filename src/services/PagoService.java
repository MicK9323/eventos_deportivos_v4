package services;

import java.util.List;

import beans.ConstanciaDTO;
import beans.JugadorDTO;
import dao.DAOFactory;
import interfaces.constanciaDAO;
import interfaces.reciboDAO;
import utils.Constantes;

public class PagoService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	reciboDAO daoRecibo = origen.getReciboDAO();
	constanciaDAO daoConstancia = origen.getConstanciaDAO();
	
	public String registrarPago( String numFicha, Double monto ) {
		return daoRecibo.registrarPago(numFicha, monto);
	}
	public String consultarPago( String numFicha ) {
		return daoRecibo.consultarPago(numFicha);
	}
	public ConstanciaDTO datosContancia(String numFicha) {
		return daoConstancia.datosContancia(numFicha);
	}
	public List<JugadorDTO> detalleEquipo(String codEquipo){
		return daoConstancia.detalleEquipo(codEquipo);
	}
	
}
