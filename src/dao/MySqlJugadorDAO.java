package dao;

import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import beans.JugadorDTO;
import interfaces.JugadorDAO;
import utils.Conexion;
import utils.Metodos;

public class MySqlJugadorDAO implements JugadorDAO {
	Metodos met = new Metodos();
	
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
				obj.setEstado(rs.getInt(7));
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

	@Override
	public String regJugador(JugadorDTO obj) {
		String msg = "";
		Connection conn = null;
		CallableStatement cstm = null;
		int estado = -1;
		try {
			conn = Conexion.conectar();
			String sql = "{ call sp_regJugador(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			cstm = conn.prepareCall(sql);
			Blob blob = null;
			String filename= null;
			cstm.setString(1, obj.getDni_jugador());
			cstm.setString(2, met.codificarBase64(obj.getDni_jugador()));
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
			if(obj.getFotoByte() != null) {
				blob = new SerialBlob(obj.getFotoByte());
				filename = obj.getFotoFileName();
				cstm.setBlob(15, blob);
				cstm.setString(16, filename);
			}else {
				cstm.setNull(15, Types.BLOB);
				cstm.setNull(16, Types.VARCHAR);
			}						
			estado = cstm.executeUpdate();
			if(estado != -1) {
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

	@Override
	public String uptJugador(JugadorDTO obj) {
		String msg = "";
		Connection conn = null;
		CallableStatement cstm = null;
		int estado = -1;
		try {
			conn = Conexion.conectar();
			String sql = "{ call sp_uptJugador(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";			
			cstm = conn.prepareCall(sql);
			Blob blob = null;
			String filename= null;			
			cstm.setString(1, obj.getDni_jugador());
			cstm.setString(2, met.codificarBase64(obj.getClave()));
			cstm.setString(3, obj.getNom_jugador());
			cstm.setString(4, obj.getApe_jugador());
			cstm.setString(5, obj.getFec_nac());
			cstm.setInt(6, obj.getEdad());
			cstm.setString(7, obj.getSexo());
			cstm.setString(8, obj.getEstCivil());
			cstm.setString(9, obj.getTelfDomicilio());
			cstm.setString(10, obj.getTelfMovil());
			cstm.setString(11, obj.getDomicilio());
			cstm.setString(12, obj.getEmail());
			cstm.setString(13, obj.getCodSede());
			if(obj.getFotoByte() != null) {
				blob = new SerialBlob(obj.getFotoByte());
				filename = obj.getFotoFileName();
				cstm.setBlob(14, blob);
				cstm.setString(15, filename);
			}else {
				cstm.setNull(14, Types.BLOB);
				cstm.setNull(15, Types.VARCHAR);
			}
			System.out.println(obj.getEstado());
			cstm.setInt(16, obj.getEstado());
			estado = cstm.executeUpdate();
			if(estado != -1) {
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

	@Override
	public String delJugador(String dni) {
		String msg = "";
		Connection conn = null;
		CallableStatement cstm = null;
		int estado = -1;
		try {
			conn = Conexion.conectar();
			String sql = "{ call sp_delJugador(?) }";
			cstm = conn.prepareCall(sql);
			cstm.setString(1, dni);
			estado = cstm.executeUpdate();
			if(estado != -1) {
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

	@Override
	public JugadorDTO buscarJugador(String dni) {
		JugadorDTO obj = null;
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_buscarJugador(?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			rs = cstm.executeQuery();
			if(rs.next()) {
				obj = new JugadorDTO();
				obj.setDni_jugador(rs.getString(1));
				obj.setClave(met.decodificarBase64(rs.getString(2)));
				obj.setIdRol(rs.getInt(3));
				obj.setNom_jugador(rs.getString(4));
				obj.setApe_jugador(rs.getString(5));
				obj.setFec_nac(rs.getString(6));
				obj.setEdad(rs.getInt(7));
				obj.setSexo(rs.getString(8));
				obj.setEstCivil(rs.getString(9));
				obj.setTelfDomicilio(rs.getString(10));
				obj.setTelfMovil(rs.getString(11));
				obj.setDomicilio(rs.getString(12));
				obj.setEmail(rs.getString(13));
				obj.setCodSede(rs.getString(14));						
				obj.setEstado(rs.getInt(15));
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
		return obj;
	}

	@Override
	public JugadorDTO buscarFoto(String dni) {
		JugadorDTO obj = null;
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_buscarFoto(?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			rs = cstm.executeQuery();
			if(rs.next()) {
				obj = new JugadorDTO();
				if(rs.getBlob(1)==null) {
					obj.setFotoByte(null);
				}else {
					obj.setFotoByte(rs.getBlob(1).getBytes(1, (int) rs.getBlob(1).length()));
				}	
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
		return obj;			
	}

}
