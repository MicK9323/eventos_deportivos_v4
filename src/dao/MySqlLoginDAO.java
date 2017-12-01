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
import utils.Metodos;

public class MySqlLoginDAO implements loginDAO{
	
	Metodos met = new Metodos();

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
				obj.setClave(met.decodificarBase64(rs.getString(2)));
				System.out.println(obj.getClave());
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
				if(rs.getBlob(15)==null) {
					obj.setFotoByte(null);
				}else {
					obj.setFotoByte(rs.getBlob(15).getBytes(1, (int) rs.getBlob(15).length()));
				}				
				obj.setEstado(rs.getBoolean(18));
				obj.setNomSede(rs.getString(19));
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

	@Override
	public List<EnlaceDTO> obtenerEnlacesPagos(String dni) {
		List<EnlaceDTO> lista = new ArrayList<EnlaceDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_cargarEnlaces(?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, "PAGO");
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
	public List<EnlaceDTO> obtenerEnlacesReportes(String dni) {
		List<EnlaceDTO> lista = new ArrayList<EnlaceDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_cargarEnlaces(?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, dni);
			cstm.setString(2, "RPT");
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
	public List<EnlaceDTO> listaRoles() {
		List<EnlaceDTO> lista = new ArrayList<EnlaceDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_listarRoles()}";
			cstm = cn.prepareCall(sql);
			rs = cstm.executeQuery();
			EnlaceDTO obj = null;
			while(rs.next()){
				obj = new EnlaceDTO();
				obj.setIdRol(rs.getInt(1));
				obj.setNomRol(rs.getString(2));
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
