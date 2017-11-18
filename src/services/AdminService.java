package services;

import beans.AdminDTO;
import dao.DAOFactory;
import interfaces.AdminDAO;
import utils.Constantes;

public class AdminService {
	DAOFactory origen = DAOFactory.getDAOFactory(Constantes.ORIGEN_DATOS);
	AdminDAO dao = origen.getAdminDAO();
	
	public AdminDTO iniciarSesion(AdminDTO x) {
		return dao.iniciarSesion(x);
	}
	
}
