package interfaces;

import java.util.List;

import beans.ModalidadDTO;


public interface ModalidadDAO {
	public List<ModalidadDTO> listaModalidades();
	public String regModalidad(ModalidadDTO x);
	public ModalidadDTO buscaModalidad(String codigo);
	public String uptModalidad(ModalidadDTO x);
	public String deleteModalidad(String codigo);
	public String disableModalidad(String codigo);
	public String enableModalidad(String codigo);
	public String validarNombre(String descripcion);
}
