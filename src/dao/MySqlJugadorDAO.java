package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			while (rs.next()) {
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

	@Override
	public List<JugadorDTO> listaJugadores() {
		List<JugadorDTO> lista = new ArrayList<JugadorDTO>();
		Connection conn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			conn = Conexion.conectar();
			String sql = "{ call sp_listaJugadores() }";
			cstm = conn.prepareCall(sql);
			rs = cstm.executeQuery();
			JugadorDTO obj = null;
			while (rs.next()) {
				obj = new JugadorDTO();
				obj.setDni_jugador(rs.getString(1));
				obj.setNom_jugador(rs.getString(2));
				obj.setEdad(rs.getInt(3));
				obj.setSexo(rs.getString(4));
				obj.setTelfMovil(rs.getString(5));
				obj.setNomSede(rs.getString(6));
				obj.setEstado(rs.getBoolean(7));
				lista.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (cstm != null)
					cstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

//	@Override
//	public String registrarJugador(JugadorDTO obj) {
//		String msg = "";
//		Connection conn = null;
//		CallableStatement cstm = null;
//		int estado = -1;
//		try {
//			conn = Conexion.conectar();
//			String sql = "{ call sp_importarJugador(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
//			cstm = conn.prepareCall(sql);
//			cstm.setString(1, obj.getDni_jugador());
//			cstm.setString(2, obj.getClave());
//			cstm.setInt(3, obj.getIdRol());
//			cstm.setString(4, obj.getNom_jugador());
//			cstm.setString(5, obj.getApe_jugador());
//			cstm.setString(6, obj.getFec_nac());
//			cstm.setInt(7, obj.getEdad());
//			cstm.setString(8, obj.getSexo());
//			cstm.setInt(9, obj.getCodEstCivil());
//			cstm.setString(10, obj.getTelfDomicilio());
//			cstm.setString(11, obj.getTelfMovil());
//			cstm.setString(12, obj.getDomicilio());
//			cstm.setString(13, obj.getEmail());
//			cstm.setString(14, obj.getCodSede());
//			estado = cstm.executeUpdate();
//			if(estado != -1) {
//				msg = "ok";
//			}
//		} catch (Exception e) {
//			msg = e.getMessage();
//		} finally {
//			try {
//				if (cstm != null)
//					cstm.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e2) {
//				msg = e2.getMessage();
//			}
//		}
//		return msg;
//	}

	@Override
	public String importarJugadores(ArrayList<JugadorDTO> data) {
		String msg = "";
		Connection conn = null;
		CallableStatement cstm = null;
		int estado = 0;
		try {
			conn = Conexion.conectar();
			String sql = "{ call sp_importarJugador(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			for(JugadorDTO obj : data) {
				cstm = conn.prepareCall(sql);
				cstm.setString(1, obj.getDni_jugador());
				cstm.setString(2, obj.getClave());
				cstm.setInt(3, obj.getIdRol());
				cstm.setString(4, obj.getNom_jugador());
				cstm.setString(5, obj.getApe_jugador());
				cstm.setString(6, obj.getFec_nac());
				cstm.setInt(7, obj.getEdad());
				cstm.setString(8, obj.getSexo());
				cstm.setString(9, obj.getEstCivil());
				cstm.setString(10, obj.getTelfDomicilio());
				cstm.setString(11, obj.getTelfMovil());
				cstm.setString(12, obj.getDomicilio());
				cstm.setString(13, obj.getEmail());
				cstm.setString(14, obj.getCodSede());
				estado += cstm.executeUpdate();
			}
			if(estado > 0) {
				msg = "ok";
			}
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

}
