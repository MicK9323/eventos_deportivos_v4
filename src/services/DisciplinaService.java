package services;

import java.util.List;

import beans.DisciplinaDTO;
import dao.DAOFactory;
import interfaces.DisciplinaDAO;
import utils.Constantes;

public class DisciplinaService {
	DAOFactory fabrica=DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	DisciplinaDAO objDisciplina = fabrica.getDisciplinaDAO();
	
	public List<DisciplinaDTO> listaDisciplinas(){
		return objDisciplina.listaDisciplinas();
	}
	public String regDisciplina(DisciplinaDTO x) {
		return objDisciplina.regDisciplina(x);
	}
	public DisciplinaDTO buscarDisciplina(String codigo) {
		return objDisciplina.buscarDisciplina(codigo);
	}
	public String uptDisciplina(DisciplinaDTO x) {
		return objDisciplina.uptDisciplina(x);
	}
	public String delDisciplina(String codigo) {
		return objDisciplina.delDisciplina(codigo);
	}
	public String disableDisciplina(String codigo) {
		return objDisciplina.disableDisciplina(codigo);
	}
	public String enableDisciplina(String codigo) {
		return objDisciplina.enableDisciplina(codigo);
	}
	public String validarNombre(String descripcion) {
		return objDisciplina.validarNombre(descripcion);
	}
	
}
