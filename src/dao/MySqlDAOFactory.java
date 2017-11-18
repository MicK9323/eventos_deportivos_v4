package dao;

import interfaces.AdminDAO;
import interfaces.CategoriaDAO;
import interfaces.DisciplinaDAO;
import interfaces.EquipoDAO;
import interfaces.EventoDAO;
import interfaces.FichaDAO;
import interfaces.JugadorDAO;
import interfaces.ModalidadDAO;
import interfaces.SedeDAO;
import interfaces.loginDAO;
import interfaces.reciboDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public FichaDAO getFichaDAO() {
		// TODO Auto-generated method stub
		return new MySqlFichaDAO();
	}

	@Override
	public JugadorDAO getJugadorDAO() {
		// TODO Auto-generated method stub
		return new MySqlJugadorDAO();
	}

	@Override
	public EventoDAO getEventoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEventoDAO();
	}

	@Override
	public EquipoDAO getEquipoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEquipoDAO();
	}

	@Override
	public DisciplinaDAO getDisciplinaDAO() {
		// TODO Auto-generated method stub
		return new MySqlDisciplinaDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new MySqlCategoriaDAO();
	}

	@Override
	public ModalidadDAO getModalidadDAO() {
		// TODO Auto-generated method stub
		return new MySqlModalidadDAO();
	}

	@Override
	public AdminDAO getAdminDAO() {
		// TODO Auto-generated method stub
		return new MySqlAdminDAO();
	}

	@Override
	public SedeDAO getSedeDAO() {
		// TODO Auto-generated method stub
		return new MySqlSedeDAO();
	}

	@Override
	public loginDAO getLoginDAO() {
		// TODO Auto-generated method stub
		return new MySqlLoginDAO();
	}

	@Override
	public reciboDAO getReciboDAO() {
		// TODO Auto-generated method stub
		return new MySqlReciboDAO();
	}

}
