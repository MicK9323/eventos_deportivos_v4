package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.JugadorDTO;
import interfaces.JugadorDAO;
import utils.Conexion;

public class MySqlJugadorDAO implements JugadorDAO {

	@Override
	public String validarJugador(String dni, String codModalidad, String codEvento) throws SQLException {
		String alerta = "";
		Connection cn = null;
		PreparedStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select validar(?,?,?)";
			cstm = cn.prepareStatement(sql);
			cstm.setString(1, dni);
			cstm.setString(2, codModalidad);
			cstm.setString(3, codEvento);
			rs = cstm.executeQuery();
			if (rs.next()) {
				alerta = rs.getString(1);
			}
		} catch (SQLException e) {
			alerta = e.getMessage();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				alerta = e2.getMessage();
			}
		}
		return alerta;
	}

	@Override
	public JugadorDTO datosJugador(String dni) throws SQLException {
		JugadorDTO obj = null;
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_datosJugador(?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			rs = cstm.executeQuery();
			obj = new JugadorDTO();
			while(rs.next()) {
				obj.setDni_jugador(rs.getString(1));
				obj.setNom_jugador(rs.getString(2));
				obj.setEdad(rs.getInt(3));
				obj.setSexo(rs.getString(4));
				obj.setNomSede(rs.getString(5));
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
		return obj;
	}

}
