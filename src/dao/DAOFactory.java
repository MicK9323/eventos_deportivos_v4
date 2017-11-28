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
import interfaces.constanciaDAO;
import interfaces.loginDAO;
import interfaces.reciboDAO;

public abstract class DAOFactory {
	// los posibles orígenes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    // Existirá un método get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    // registramos nuestros daos
    public abstract FichaDAO getFichaDAO();
    public abstract JugadorDAO getJugadorDAO();
    public abstract EventoDAO getEventoDAO();
    public abstract EquipoDAO getEquipoDAO();
    public abstract DisciplinaDAO getDisciplinaDAO();
    public abstract CategoriaDAO getCategoriaDAO();
    public abstract ModalidadDAO getModalidadDAO();
    public abstract SedeDAO getSedeDAO();
    public abstract AdminDAO getAdminDAO();
    public abstract loginDAO getLoginDAO();
    public abstract reciboDAO getReciboDAO();
    public abstract constanciaDAO getConstanciaDAO();
    
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case XML:
        	    //return new XmlDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();
        	case SQLSERVER:
        	    return new SqlServerDAOFactory();
        	case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
