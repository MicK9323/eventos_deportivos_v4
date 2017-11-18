package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection conectar(){
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://69.167.175.221/mcaproye_pit_2017?noAccessToProcedureBodies=true","mcaproye_root","(pit)!2017");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
}
