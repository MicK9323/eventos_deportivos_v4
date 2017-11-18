package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import interfaces.FichaDAO;
import utils.Conexion;

public class MySqlFichaDAO implements FichaDAO {

	@Override
	public String getCorrelativoFicha() throws SQLException {
		String correlativo = "";
		Connection cn = null;
		PreparedStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select getCorrelativo(?)";
			cstm = cn.prepareStatement(sql);
			cstm.setString(1, "F");
			rs = cstm.executeQuery();
			if(rs.next()) {
				correlativo = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return correlativo;
	}

	@Override
	public String getCorrelativoEquipo() throws SQLException {
		String correlativo = "";
		Connection cn = null;
		PreparedStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select getCorrelativo(?)";
			cstm = cn.prepareStatement(sql);
			cstm.setString(1, "E");
			rs = cstm.executeQuery();
			if(rs.next()) {
				correlativo = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return correlativo;
	}

	@Override
	public String inscribirEquipo(String vCodEvento, String vCodModalidad, String vNomEquipo, String vDni,
			String vCodPago) throws SQLException {
		String msg = "";
		Connection cn = null;
		CallableStatement cstm = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_registraFicha(?,?,?,?,?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, vCodEvento);
			cstm.setString(2, vCodModalidad);
			cstm.setString(3, vNomEquipo);
			cstm.setString(4, vDni);
			cstm.setString(5, vCodPago);
			cstm.registerOutParameter(6, Types.VARCHAR);
			int estado = cstm.executeUpdate();
			if(estado != -1)
				msg=cstm.getString(6);
		} catch (SQLException e) {
			msg = e.getMessage();
		}finally {
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
	public boolean validarSede(String dni, String codEvento) {
		Boolean validacion = false;
		Connection cn = null;
		PreparedStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select func_validar_sede(?,?)";
			cstm = cn.prepareStatement(sql);
			cstm.setString(1, dni);
			cstm.setString(2, codEvento);
			rs = cstm.executeQuery();
			if(rs.next()) {
				validacion = rs.getBoolean(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return validacion;
	}

}
