package dao;

import java.io.Reader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import beans.DetEventoDTO;
import beans.EventoDTO;
import interfaces.EventoDAO;
import utils.Conexion;
import utils.Metodos;

public class MySqlEventoDAO implements EventoDAO {
	Metodos met = new Metodos();
	SqlSessionFactory origen = null;

	{
		try {
			String archivo = "ConfiguracionIbatis.xml";
			Reader reader = Resources.getResourceAsReader(archivo);
			origen = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<EventoDTO> listarEventosDisponibles() {
		List<EventoDTO> eventos = new ArrayList<EventoDTO>();
		EventoDTO obj = null;
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_EventosDisponibles()}";
			cstm = cn.prepareCall(sql);
			rs = cstm.executeQuery();
			while (rs.next()) {
				obj = new EventoDTO();
				obj.setCod_evento(rs.getString(1));
				obj.setDesc_evento(rs.getString(2));
				obj.setInicio_inscripcion(met.fechaNormal(rs.getString(3)));
				obj.setFin_inscripcion(met.fechaNormal(rs.getString(4)));
				obj.setInicio_evento(met.fechaNormal(rs.getString(5)));
				obj.setFin_evento(met.fechaNormal(rs.getString(6)));
				obj.setParticipantes(rs.getString(7));
				obj.setNom_estado(rs.getString(8));
				eventos.add(obj);
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
		return eventos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EventoDTO> listarEventos() {
		List<EventoDTO> lista = new ArrayList<EventoDTO>();
		SqlSession sesion = null;
		try {
			sesion = origen.openSession();
			lista = sesion.selectList("listaEventos");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sesion.close();
		}
		return lista;
	}

//	@Override
//	public EventoDTO buscarEvento(String codEvento) {
//		EventoDTO evento = null;
//		SqlSession sesion = null;
//		try {
//			sesion = origen.openSession();
//			evento = (EventoDTO) sesion.selectOne("buscarEvento", codEvento);
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sesion.close();
//		}
//		return evento;
//	}

//	@Override
//	public String uptEvento(EventoDTO evento) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String deleteEvento(String codEvento) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	// DETALLE DE EVENTO

	@Override
	public List<DetEventoDTO> detalleEventoxSede(String codEvento, String codSede, int rol) {
		List<DetEventoDTO> detalle = new ArrayList<DetEventoDTO>();
		Connection cn = null;
		CallableStatement cstm = null;
		ResultSet rs = null;
		DetEventoDTO obj = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_detalleEventoxSede(?,?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, codEvento);
			cstm.setString(2, codSede);
			cstm.setInt(3, rol);
			rs = cstm.executeQuery();
			while (rs.next()) {
				obj = new DetEventoDTO();
				obj.setCod_evento(rs.getString(1));
				obj.setNomEvento(rs.getString(2));
				obj.setCod_modalidad(rs.getString(3));
				obj.setNomModalidad(rs.getString(4));
				obj.setTipoModalidad(rs.getString(5));
				obj.setFec_inicio(rs.getString(6));
				obj.setFec_fin(rs.getString(7));
				obj.setCantIntegrantes(rs.getInt(8));
				obj.setCantMujeres(rs.getInt(9));
				obj.setCantVarones(rs.getInt(10));
				obj.setMaxEquipos(rs.getInt(11));
				obj.setDisponibles(rs.getInt(12));
				obj.setEstado(rs.getInt(13));
				obj.setNomEstado(rs.getString(14));
				detalle.add(obj);
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
		return detalle;
	}

//	@Override
//	public List<DetEventoDTO> buscarDetalleEvento(String codEvento) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String regDetalleEvento(DetEventoDTO detEvento) {
		String msg = "";
		int estado = -1;
		SqlSession sesion = null;
		try {
			sesion = origen.openSession();
			estado = sesion.insert("regDetalleEvento", detEvento);
			if (estado != -1) {
				msg = "ok";
			}
		} catch (Exception e) {
			msg = e.getMessage();
		} finally {
			sesion.close();
		}
		return msg;
	}

//	@Override
//	public String deleteDetEvento(String codEvento, String codModalidad, String codSede) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public String regEvento(EventoDTO evento) {
		String msg = "";
		Connection cn = null;
		CallableStatement cstm = null;
		try {
			cn = Conexion.conectar();
			String sql = "{call sp_regEvento(?,?,?,?,?,?)}";
			cstm = cn.prepareCall(sql);
			cstm.setString(1, evento.getDesc_evento());
			cstm.setString(2, met.fechaMysql(evento.getInicio_inscripcion()));
			cstm.setString(3, met.fechaMysql(evento.getFin_inscripcion()));
			cstm.setString(4, met.fechaMysql(evento.getInicio_evento()));
			cstm.setString(5, met.fechaMysql(evento.getFin_evento()));
			cstm.registerOutParameter(6, Types.CHAR);
			int estado = cstm.executeUpdate();
			if (estado != -1)
				msg = cstm.getString(6);
		} catch (Exception e) {
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
	public String validarNombre(String nomEquipo) {
		String msg = "";
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select func_validar_nombres(?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nomEquipo);
			pstm.setString(2, "tb_evento");
			rs = pstm.executeQuery();
			if (rs.next()) {
				msg = rs.getString(1);
			}
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
