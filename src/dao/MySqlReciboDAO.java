package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.reciboDAO;
import utils.Conexion;

public class MySqlReciboDAO implements reciboDAO {

	@Override
	public String registrarPago(String numFicha, Double monto) {
		String msg = "";
		int estado = -1;
		Connection conn = null;
		CallableStatement cstm = null;
		try {
			conn = Conexion.conectar();
			String sql = "{ call sp_registrarPago(?,?) }";
			cstm = conn.prepareCall(sql);
			cstm.setString(1, numFicha);
			cstm.setDouble(2, monto);
			estado = cstm.executeUpdate();
			if(estado > -1)
				msg = "ok";
		} catch (Exception e) {
			msg = e.getMessage();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				msg = e2.getMessage();
			}
		}
		return msg;
	}

	@Override
	public String consultarPago(String numFicha) {
		String monto = "";
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			conn = Conexion.conectar();
			String sql = "select func_CalcularPago(?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, numFicha);
			rs = pstm.executeQuery();
			if (rs.next()) {
				monto = "" + rs.getDouble(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return monto;
	}

}
