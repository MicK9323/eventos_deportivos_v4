package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.reciboDAO;
import utils.Conexion;

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
		ResultSet rs = null;
		try {
			conn = Conexion.conectar();
			String sql = "func_CalcularPago(?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, numFicha);
			rs = pstm.executeQuery();
			if(rs.next()) {
				monto = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
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
