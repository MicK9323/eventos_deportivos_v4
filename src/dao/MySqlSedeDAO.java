package dao;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import beans.SedeDTO;
import interfaces.SedeDAO;

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

}
