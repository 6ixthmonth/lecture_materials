package member.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybatis-config.xml 설정 파일을 불러오고 DB 연결 작업에 필요한 객체를 생성하는 클래스.
 */
public class MybatisConfig {

	private static SqlSessionFactory sqlSessionFactory;

	static {
		String resource = "mybatis-config.xml"; // Mybatis 설정 정보를 담은 파일

		try {
			Reader reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
