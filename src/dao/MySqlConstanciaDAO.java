package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ConstanciaDTO;
import beans.JugadorDTO;
import interfaces.constanciaDAO;
import utils.Conexion;

public class MySqlConstanciaDAO implements constanciaDAO {

	@Override
	public ConstanciaDTO datosContancia(String numFicha) {
		ConstanciaDTO datos = null;
		Connection conn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			conn = Conexion.conectar();
			String sql = "{call sp_cargarConstancia(?)}";
			cstm = conn.prepareCall(sql);
			cstm.setString(1, numFicha);
			rs = cstm.executeQuery();
			if(rs.next()) {
				datos = new ConstanciaDTO();
				datos.setCod_ficha(rs.getString(1));
				datos.setFec_inscripcion(rs.getString(2));
				datos.setDesc_evento(rs.getString(3));
				datos.setDesc_modalidad(rs.getString(4));
				datos.setFec_inicio(rs.getString(5));
				datos.setFec_fin(rs.getString(6));
				datos.setNom_equipo(rs.getString(7));
				datos.setCod_equipo(rs.getString(8));
				datos.setDelegado(rs.getString(9));
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
		return datos;
	}

	@Override
	public List<JugadorDTO> detalleEquipo(String codEquipo) {
		List<JugadorDTO> lista = new ArrayList<JugadorDTO>();
		JugadorDTO obj = null;
		Connection conn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			conn = Conexion.conectar();
			String sql = "{call sp_detEquipo(?)}";
			cstm = conn.prepareCall(sql);
			cstm.setString(1, codEquipo);
			rs = cstm.executeQuery();
			while(rs.next()) {
				obj = new JugadorDTO();
				obj.setDni_jugador(rs.getString(1));
				obj.setNom_jugador(rs.getString(2));
				obj.setEdad(rs.getInt(3));
				obj.setSexo(rs.getString(4));
				obj.setEmail(rs.getString(5));
				obj.setNomSede(rs.getString(6));
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

}
