package dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import beans.SedeDTO;
import interfaces.SedeDAO;
import utils.Conexion;

public class MySqlSedeDAO implements SedeDAO {
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SedeDTO> listaSedes() {
		List<SedeDTO> lista = new ArrayList<SedeDTO>();
		SqlSession sesion = null;
		try {
			sesion = origen.openSession();
			lista = sesion.selectList("listaSedes");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public String regSede(SedeDTO x) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.insert("regSede",x);
			if(estado != -1)
				msg = "ok";
		} catch (Exception e) {
			msg = e.getMessage();
		}finally {
			sesion.close();
		}
		return msg;
	}

	@Override
	public SedeDTO buscarSede(String codigo) {
		SedeDTO sede = null;
		SqlSession sesion = origen.openSession();
		try {
			sede = (SedeDTO) sesion.selectOne("buscaSedes",codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return sede;
	}

	@Override
	public String uptSede(SedeDTO x) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("uptSede",x);
			if(estado != -1)
				msg = "ok";
		} catch (Exception e) {
			msg = e.getMessage();
		}finally {
			sesion.close();
		}
		return msg;
	}

	@Override
	public String delSede(String codigo) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.delete("deleteSede",codigo);
			if(estado != -1)
				msg = "ok";
		} catch (Exception e) {
			msg = e.getMessage();
		}finally {
			sesion.close();
		}
		return msg;
	}

	@Override
	public String validarNombre(String nombre) {
		String msg = "";
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select func_validar_nombres(?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, nombre);
			pstm.setString(2, "tb_sede");
			rs = pstm.executeQuery();
			if(rs.next()) {
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
