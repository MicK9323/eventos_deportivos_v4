package dao;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.EnlaceDTO;
import beans.JugadorDTO;
import interfaces.loginDAO;
import utils.Conexion;

public class MySqlLoginDAO implements loginDAO, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2866767539575427907L;

	public JugadorDTO loginJugador(String dni, String clave) {
		JugadorDTO obj = null;
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_login(?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, clave);
			rs = cstm.executeQuery();
			if(rs.next()) {
				obj = new JugadorDTO();
				obj.setDni_jugador(rs.getString(1));
				obj.setClave(rs.getString(2));
				obj.setIdRol(rs.getInt(3));
				obj.setNom_jugador(rs.getString(4));
				obj.setApe_jugador(rs.getString(5));
				obj.setFec_nac(rs.getString(6));
				obj.setEdad(rs.getInt(7));
				obj.setSexo(rs.getString(8));
				obj.setCodEstCivil(rs.getInt(9));
				obj.setTelfDomicilio(rs.getString(10));
				obj.setTelfMovil(rs.getString(11));
				obj.setProfesion(rs.getString(12));
				obj.setDomicilio(rs.getString(13));
				obj.setDirTrabajo(rs.getString(14));
				obj.setEmail(rs.getString(15));
				obj.setCodSede(rs.getString(16));
				obj.setFoto(rs.getString(17));
				obj.setEstado(rs.getBoolean(19));
				obj.setNomSede(rs.getString(20));
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
	public List<EnlaceDTO> obtenerEnlacesInscripcion(String dni) {
		List<EnlaceDTO> lista = new ArrayList<EnlaceDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_cargarEnlaces(?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, "HOME");
			rs = cstm.executeQuery();
			EnlaceDTO obj = null;
			while(rs.next()){
				obj = new EnlaceDTO();
				obj.setIdRol(rs.getInt(1));
				obj.setNomRol(rs.getString(2));
				obj.setIdEnlace(rs.getInt(3));
				obj.setNomEnlace(rs.getString(4));
				obj.setRuta(rs.getString(5));
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
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<EnlaceDTO> obtenerEnlacesMenuAdmin(String dni) {
		List<EnlaceDTO> lista = new ArrayList<EnlaceDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_cargarEnlaces(?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, "ADM");
			rs = cstm.executeQuery();
			EnlaceDTO obj = null;
			while(rs.next()){
				obj = new EnlaceDTO();
				obj.setIdRol(rs.getInt(1));
				obj.setNomRol(rs.getString(2));
				obj.setIdEnlace(rs.getInt(3));
				obj.setNomEnlace(rs.getString(4));
				obj.setRuta(rs.getString(5));
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
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<EnlaceDTO> obtenerEnlacesMantenimiento(String dni) {
		List<EnlaceDTO> lista = new ArrayList<EnlaceDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_cargarEnlaces(?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, "MANT");
			rs = cstm.executeQuery();
			EnlaceDTO obj = null;
			while(rs.next()){
				obj = new EnlaceDTO();
				obj.setIdRol(rs.getInt(1));
				obj.setNomRol(rs.getString(2));
				obj.setIdEnlace(rs.getInt(3));
				obj.setNomEnlace(rs.getString(4));
				obj.setRuta(rs.getString(5));
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
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

	@Override
	public List<EnlaceDTO> obtenerEnlacesEventos(String dni) {
		List<EnlaceDTO> lista = new ArrayList<EnlaceDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_cargarEnlaces(?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, "EVENT");
			rs = cstm.executeQuery();
			EnlaceDTO obj = null;
			while(rs.next()){
				obj = new EnlaceDTO();
				obj.setIdRol(rs.getInt(1));
				obj.setNomRol(rs.getString(2));
				obj.setIdEnlace(rs.getInt(3));
				obj.setNomEnlace(rs.getString(4));
				obj.setRuta(rs.getString(5));
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
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}
}