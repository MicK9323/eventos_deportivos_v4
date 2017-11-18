package interfaces;

import java.util.List;

import beans.DisciplinaDTO;

public interface DisciplinaDAO {
	public List<DisciplinaDTO> listaDisciplinas();
	public String regDisciplina(DisciplinaDTO x);
	public DisciplinaDTO buscarDisciplina(String codigo);
	public String uptDisciplina(DisciplinaDTO x);
	public String delDisciplina(String codigo);
	public String disableDisciplina(String codigo);
	public String enableDisciplina(String codigo);
	public String validarNombre(String descripcion);
}
