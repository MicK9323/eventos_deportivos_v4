package dao;

import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import beans.CategoriaDTO;
import interfaces.CategoriaDAO;
import utils.Conexion;

public class MySqlCategoriaDAO implements CategoriaDAO {

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
	public List<CategoriaDTO> listaCategorias() {
		List<CategoriaDTO> lista = null;
		SqlSession sesion = origen.openSession();
		try {
			lista = sesion.selectList("listaCategorias");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public String regCategoria(CategoriaDTO x) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.insert("regCategoria",x);
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
	public CategoriaDTO buscarCategoria(String codigo) {
		CategoriaDTO categoria = null;
		SqlSession sesion = origen.openSession();
		try {
			categoria = (CategoriaDTO) sesion.selectOne("buscaCategoria", codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return categoria;
	}

	@Override
	public String uptCategoria(CategoriaDTO x) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("uptCategoria",x);
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
	public String delCategoria(String codigo) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.delete("deleteCategoria",codigo);
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
	public String disableCategoria(String codigo) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("disableCategoria",codigo);
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
	public String enableCategoria(String codigo) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("enableCategoria",codigo);
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
			pstm.setString(2, "tb_categoria");
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
