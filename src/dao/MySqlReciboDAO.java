package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import interfaces.reciboDAO;

public class MySqlReciboDAO implements reciboDAO {

	@Override
	public String registrarPago(String numFicha, Double monto) {
		String cadena = "";
		return cadena;
	}

	@Override
	public String consultarPago(String numFicha) {
		String monto = "";
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null)
					pstm.close();
				if(conn!=null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return monto;
	}

}
