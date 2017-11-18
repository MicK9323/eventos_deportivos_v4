package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import interfaces.EquipoDAO;
import utils.Conexion;

public class MySqlEquipoDAO implements EquipoDAO {

	@Override
	public String addJugador(String vCodEquipo, String vDniJugador) throws SQLException {
		String msg = "";
		Connection cn = null;
		CallableStatement cstm = null;
		try {
			cn = Conexion.conectar();
			cn.setAutoCommit(false);
			String sql = "call sp_regDet_Equipo(?,?)";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, vCodEquipo);
			cstm.setString(2, vDniJugador);
			int estado = cstm.executeUpdate();
			if (estado != -1) {
				msg = "Correcto";
			}
		} catch (SQLException e) {
			cn.rollback();
			msg = e.getMessage();
		} finally {
			try {
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				msg = e2.getMessage();
			}
		}
		return msg;
	}

	@Override
	public String validarNombre(String nomEquipo) throws SQLException {
		String msg = "";
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select func_validar_nombres(?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nomEquipo);
			pstm.setString(2, "tb_equipo");
			rs = pstm.executeQuery();
			if(rs.next())
				msg = rs.getString(1);
		} catch (Exception e) {
			msg = e.getMessage();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				msg = e2.getMessage();
			}
		}
		return msg;
	}

}
