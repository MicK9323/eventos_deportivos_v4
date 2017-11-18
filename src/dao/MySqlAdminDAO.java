package dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import beans.AdminDTO;
import interfaces.AdminDAO;

public class MySqlAdminDAO implements AdminDAO {
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
	public AdminDTO iniciarSesion(AdminDTO x) {
		AdminDTO user = null;
		SqlSession sesion = origen.openSession();
		try {
			user = (AdminDTO) sesion.selectOne("iniciarSesion", x);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sesion.close();
		}
		return user;
	}

}
