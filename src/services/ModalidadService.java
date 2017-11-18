package services;

import java.util.List;

import beans.CategoriaDTO;
import beans.DisciplinaDTO;
import beans.ModalidadDTO;
import dao.DAOFactory;
import interfaces.CategoriaDAO;
import interfaces.DisciplinaDAO;
import interfaces.ModalidadDAO;
import utils.Constantes;

public class ModalidadService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	ModalidadDAO dao = origen.getModalidadDAO();
	DisciplinaDAO daoDisciplina = origen.getDisciplinaDAO();
	CategoriaDAO daoCategoria = origen.getCategoriaDAO();

	public List<DisciplinaDTO> listaDisciplinas() {
		return daoDisciplina.listaDisciplinas();
	}

	public List<CategoriaDTO> listaCategorias() {
		return daoCategoria.listaCategorias();
	}

	public List<ModalidadDTO> listaModalidades() {
		return dao.listaModalidades();
	}

	public String regModalidad(ModalidadDTO x) {
		return dao.regModalidad(x);
	}

	public ModalidadDTO buscaModalidad(String codigo) {
		return dao.buscaModalidad(codigo);
	}

	public String uptModalidad(ModalidadDTO x) {
		return dao.uptModalidad(x);
	}

	public String deleteModalidad(String codigo) {
		return dao.deleteModalidad(codigo);
	}
	public String validarNombre(String descripcion) {
		return dao.validarNombre(descripcion);
	}
}
