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
import beans.ModalidadDTO;
import interfaces.ModalidadDAO;
import utils.Conexion;

public class MySqlModalidadDAO implements ModalidadDAO {
	
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
	public List<ModalidadDTO> listaModalidades() {
		List<ModalidadDTO> lista = new ArrayList<ModalidadDTO>();
		SqlSession sesion = origen.openSession();
		try {
			lista = sesion.selectList("listaModalidades");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return lista;
	}

	@Override
	public String regModalidad(ModalidadDTO x) {
		int estado = -1;
		String msg = "";
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.insert("regModalidad",x);
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
	public ModalidadDTO buscaModalidad(String codigo) {
		ModalidadDTO obj = null;
		SqlSession sesion = origen.openSession();
		try {
			obj = (ModalidadDTO) sesion.selectOne("buscaModalidad", codigo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return obj;
	}

	@Override
	public String uptModalidad(ModalidadDTO x) {
		String msg = "";
		int estado = -1;
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("uptModalidad", x);
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
	public String deleteModalidad(String codigo) {
		String msg = "";
		int estado = -1;
		SqlSession sesion = origen.openSession();
		try {
			estado = sesion.update("deleteModalidad", codigo);
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
	public String disableModalidad(String codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String enableModalidad(String codigo) {
		// TODO Auto-generated method stub
		return null;
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
			pstm.setString(2, "tb_modalidad");
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
