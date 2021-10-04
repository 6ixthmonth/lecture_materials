package dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.Board;

public class BoardDAO {
	SqlSessionFactory ftr = MybatisConfig.getSqlSessionFactory();

	public ArrayList<Board> noticeList() {
		ArrayList<Board> rslt = null;
		
		SqlSession ss = null;
		try {
			ss = ftr.openSession();
			BoardMapper mpr = ss.getMapper(BoardMapper.class);
			rslt = mpr.noticeList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		
		return rslt;
	}

	public Board readNotice(int num) {
		Board rslt = null;
		
		SqlSession ss = null;
		try {
			ss = ftr.openSession();
			BoardMapper mpr = ss.getMapper(BoardMapper.class);
			rslt = mpr.readNotice(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		return rslt;
	}

	public ArrayList<Board> freeList() {
		ArrayList<Board> rslt = null;
		
		SqlSession ss = null;
		try {
			ss = ftr.openSession();
			BoardMapper mpr = ss.getMapper(BoardMapper.class);
			rslt = mpr.freeList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		
		return rslt;
	}

	public Board readFree(int num) {
		Board rslt = null;
		
		SqlSession ss = null;
		try {
			ss = ftr.openSession();
			BoardMapper mpr = ss.getMapper(BoardMapper.class);
			rslt = mpr.readFree(num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ss != null) ss.close();
		}
		return rslt;
	}
}