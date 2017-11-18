package services;

import java.util.List;

import beans.CategoriaDTO;
import dao.DAOFactory;
import interfaces.CategoriaDAO;
import utils.Constantes;

public class CategoriaService {

	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	CategoriaDAO dao = origen.getCategoriaDAO();

	public List<CategoriaDTO> listaCategorias() {
		return dao.listaCategorias();
	}

	public String regCategoria(CategoriaDTO x) {
		return dao.regCategoria(x);
	}

	public CategoriaDTO buscarCategoria(String codigo) {
		return dao.buscarCategoria(codigo);
	}

	public String uptCategoria(CategoriaDTO x) {
		return dao.uptCategoria(x);
	}

	public String delCategoria(String codigo) {
		return dao.delCategoria(codigo);
	}

	public String disableCategoria(String codigo) {
		return dao.disableCategoria(codigo);
	}

	public String enableCategoria(String codigo) {
		return dao.enableCategoria(codigo);
	}
	public String validarNombre(String descripcion) {
		return dao.validarNombre(descripcion);
	}
}
