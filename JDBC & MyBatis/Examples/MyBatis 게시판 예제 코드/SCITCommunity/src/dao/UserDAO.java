package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.User;

public class UserDAO {
	private SqlSessionFactory ftr = MybatisConfig.getSqlSessionFactory();
	
	public boolean signup(User usr) {
		int rslt = 0;
		
		SqlSession ss = null;
		try {
			ss = ftr.openSession();
			UserMapper mpr = ss.getMapper(UserMapper.class);
			rslt = mpr.signup(usr);
			ss.commit();
		} catch (Exception e) {
		} finally {
			if (ss != null) ss.close();
		}
		
		if (rslt == 1) return true;
		return false;
	}

	public String login(User usr) {
		String rslt = null;
		
		SqlSession ss = null;
		try {
			ss = ftr.openSession();
			UserMapper mpr = ss.getMapper(UserMapper.class);
			rslt = mpr.login(usr);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		
		return rslt;
	}
}