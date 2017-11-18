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

import beans.DisciplinaDTO;
import interfaces.DisciplinaDAO;
import utils.Conexion;

public class MySqlDisciplinaDAO implements DisciplinaDAO {
	
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
	public List<DisciplinaDTO> listaDisciplinas() {
		List<DisciplinaDTO> lista = new ArrayList<DisciplinaDTO>();
		SqlSession sesion = origen.openSession();
		try {
			lista = sesion.selectList("listaDisciplinas");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public String regDisciplina(DisciplinaDTO x) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.insert("regDisciplina",x);
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
	public DisciplinaDTO buscarDisciplina(String codigo) {
		DisciplinaDTO obj = null;
		SqlSession sesion = origen.openSession();
		try {
			obj = (DisciplinaDTO) sesion.selectOne("buscaDisciplina", codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return obj;
	}

	@Override
	public String uptDisciplina(DisciplinaDTO x) {
		String msg = "";
		int estado = -1;
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("uptDisciplina", x);
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
	public String delDisciplina(String codigo) {
		String msg = "";
		int estado = -1;
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("deleteDisciplina", codigo);
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
	public String disableDisciplina(String codigo) {
		String msg = "";
		int estado = -1;
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("disableDisciplina", codigo);
			if(estado != -1)
				msg = "Disciplina "+codigo+ " inhabilitada";
		} catch (Exception e) {
			msg = e.getMessage();
		}finally {
			sesion.close();
		}
		return msg;
	}

	@Override
	public String enableDisciplina(String codigo) {
		String msg = "";
		int estado = -1;
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("enableDisciplina", codigo);
			if(estado != -1)
				msg = "Disciplina "+codigo+ " habilitada";
		} catch (Exception e) {
			msg = e.getMessage();
		}finally {
			sesion.close();
		}
		return msg;
	}

	@Override
	public String validarNombre(String descripcion) {
		String msg = "";
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = Conexion.conectar();
			String sql = "Select func_validar_nombres(?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, descripcion);
			pstm.setString(2, "tb_disciplina");
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
