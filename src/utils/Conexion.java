package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
	
	public static Connection conectar(){
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/bd_eventos_deportivos_v7","root","mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
	
}
