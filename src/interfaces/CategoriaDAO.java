package interfaces;

import java.util.List;

import beans.CategoriaDTO;

public interface CategoriaDAO {
	public List<CategoriaDTO> listaCategorias();
	public String regCategoria(CategoriaDTO x);
	public CategoriaDTO buscarCategoria(String codigo);
	public String uptCategoria(CategoriaDTO x);
	public String delCategoria(String codigo);
//	public String disableCategoria(String codigo);
//	public String enableCategoria(String codigo);
	public String validarNombre(String descripcion);
}
