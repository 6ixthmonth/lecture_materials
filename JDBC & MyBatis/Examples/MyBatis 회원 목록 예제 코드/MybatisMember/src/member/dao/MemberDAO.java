package member.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.vo.Member;

/**
 * Database에 접근하여 작업을 시도하는 클래스.
 */
public class MemberDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();

	/**
	 * 회원 조회
	 */
	public ArrayList<Member> selectMember() {
		SqlSession session = null;
		ArrayList<Member> memberList = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			memberList = mapper.selectMember();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return memberList;
	}

	/**
	 * 회원 등록
	 */
	public void insertMember(Member newMember) {
		SqlSession session = null;

		try {
			session = factory.openSession();
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			mapper.insertMember(newMember);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
