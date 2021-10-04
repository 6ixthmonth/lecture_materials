package member.ui;

import java.util.ArrayList;

import member.dao.MemberDAO;
import member.vo.Member;

public class MemberMain {

	public static void main(String[] args) {

		MemberDAO dao = new MemberDAO();

		/**
		 * 신규 회원 등록 코드.
		 */
//		Member newMember = new Member();
//		newMember.setMember_name("김철수");
//		newMember.setMember_age(30);
//		newMember.setMember_phone("010-9876-5432");
//		newMember.setMember_address("코엑스 4층 ICT 교육센터");
//
//		dao.insertMember(newMember);

		/**
		 * MemberDAO를 통해 DB에서 회원 목록을 가져오고 출력하는 코드.
		 */
		ArrayList<Member> memberList = dao.selectMember();

		System.out.println("===== [회원 목록] =====");
		for (Member m : memberList) {
			System.out.println(m);
		}

	}

}
