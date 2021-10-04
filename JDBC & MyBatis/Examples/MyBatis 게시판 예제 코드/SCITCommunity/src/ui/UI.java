package ui;

import java.util.ArrayList;
import java.util.Scanner;

import dao.BoardDAO;
import dao.UserDAO;
import vo.Board;
import vo.User;

public class UI {
	private Scanner sc; 
	private UserDAO usrDAO;
	private BoardDAO brdDAO;
	private boolean login;
	
	{
		sc = new Scanner(System.in);
		usrDAO = new UserDAO();
		brdDAO = new BoardDAO();
		login = false;
	}
	
	public UI() {
		while (true) {
			if (login) printMenuInLogin(); // 로그인 중일 때 메뉴 출력
			else printMenuInLogout(); // 로그인하지 않을 때 메뉴 출력
			
			int sel = 0;
			try {sel = sc.nextInt();}
			catch (Exception e) {
				System.out.println("다시 입력해주세요.");
				sc.nextLine();
				continue;
			}
			System.out.println();
			if (login) {
				switch (sel) {
				case 1: // 공지사항
					toNoticeBoard();
					break;
				case 2: // 자유게시판
					toFreeBoard();
					break;
				case 0: // 로그아웃
					System.out.println("로그아웃합니다.");
					login = false;
					break;
				default:
					System.out.println("다시 입력해주세요.");
				}
			} else {
				switch (sel) {
				case 1: // 회원가입
					signup();
					break;
				case 2: // 로그인
					login();
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					sc.close();
					System.exit(0);
					break;
				default:
					System.out.println("다시 입력해주세요.");
				}
			}
		}
	}
	
	private void printMenuInLogin() {
		System.out.println();
		System.out.println("┌─SCIT 커뮤니티─┐");
		System.out.println("│　1. 공지사항    │");
		System.out.println("│　2. 자유게시판 │");
		System.out.println("│　0. 로그아웃    │");
		System.out.println("└─────────────┘");
		System.out.print("메뉴를 선택하세요:");
	}
	
	private void printMenuInLogout() {
		System.out.println();
		System.out.println("┌─SCIT 커뮤니티─┐");
		System.out.println("│　1. 회원가입    │");
		System.out.println("│　2. 로그인　　│");
		System.out.println("│　0. 종료　　   │");
		System.out.println("└─────────────┘");
		System.out.print("메뉴를 선택하세요:");
	}
	
	private void signup() {
		System.out.println("===회원가입===");
		sc.nextLine();
		System.out.print("이름을 입력하세요(30 byte 이내):");
		String name = sc.nextLine();
		System.out.print("ID를 입력하세요(20 byte 이내, 중복 불가):");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요(30 byte 이내):");
		String pw = sc.nextLine();
		boolean rslt = usrDAO.signup(new User(name, id, pw));
		if (rslt) System.out.println("가입에 성공했습니다. 로그인해주세요.");
		else System.out.println("가입에 실패했습니다. 입력하신 정보를 확인해주세요.");
	}
	
	private void login() {
		System.out.println("===로그인===");
		sc.nextLine();
		System.out.print("ID를 입력하세요:");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요:");
		String pw = sc.nextLine();
		String name = usrDAO.login(new User(id, pw));
		if (name == null) {System.out.println("로그인에 실패했습니다. 입력하신 정보를 확인해주세요.");}
		else {System.out.println(String.format("%s님, 환영합니다.", name)); login = true;}
	}
	
	private void toNoticeBoard() {
		ArrayList<Board> list = brdDAO.noticeList();
		System.out.println("===공지사항===");
		sc.nextLine();
		System.out.println("글 번호\t제목\t작성자\t작성일\t조회수");
		for (Board b : list) {
			System.out.println(b.getNum() + "\t"
								+ b.getTitle() + "\t"
								+ b.getId() + "\t"
								+ b.getWritten_date() + "\t"
								+ b.getHits() + "\t");
		}
		
		System.out.print("열람하실 글 번호를 입력하세요(0 입력 시 이전 메뉴로 이동).:");
		int sel = 0;
		try {sel = sc.nextInt(); sc.nextLine();}
		catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			sc.nextLine();
			return;
		}
		if (sel == 0 || sel > list.size()) return;
		else readNotice(sel);
	}
	
	private void readNotice(int sel) {
		Board b = brdDAO.readNotice(sel);
		System.out.println();
		System.out.print("제목: ");
		System.out.println(b.getTitle());
		System.out.print("작성자: ");
		System.out.println(b.getId());
		System.out.print("작성일: ");
		System.out.println(b.getWritten_date());
		System.out.println(b.getContent());
		
		System.out.println();
		System.out.println("┌──────────────┐");
		System.out.println("│　1. 이전 메뉴로   │");
		System.out.println("│　0. 메인 메뉴로   │");
		System.out.println("└──────────────┘");
		try {sel = sc.nextInt();}
		catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			sc.nextLine();
			return;
		}
		if (sel == 1) toNoticeBoard();
		else return;
	}

	private void toFreeBoard() {
		ArrayList<Board> list = brdDAO.freeList();
		System.out.println("===자유게시판===");
		sc.nextLine();
		System.out.println("글 번호\t제목\t작성자\t작성일\t조회수");
		for (Board b : list) {
			System.out.println(b.getNum() + "\t"
								+ b.getTitle() + "\t"
								+ b.getId() + "\t"
								+ b.getWritten_date() + "\t"
								+ b.getHits() + "\t");
		}
		
		System.out.print("열람하실 글 번호를 입력하세요(0 입력 시 이전 메뉴로 이동).:");
		int sel = 0;
		try {sel = sc.nextInt(); sc.nextLine();}
		catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			sc.nextLine();
			return;
		}
		if (sel == 0 || sel > list.size()) return;
		else readFree(sel);
	}

	private void readFree(int sel) {
		Board b = brdDAO.readFree(sel);
		System.out.println();
		System.out.print("제목: ");
		System.out.println(b.getTitle());
		System.out.print("작성자: ");
		System.out.println(b.getId());
		System.out.print("작성일: ");
		System.out.println(b.getWritten_date());
		System.out.println(b.getContent());
		
		System.out.println();
		System.out.println("┌──────────────┐");
		System.out.println("│　1. 이전 메뉴로   │");
		System.out.println("│　0. 메인 메뉴로   │");
		System.out.println("└──────────────┘");
		try {sel = sc.nextInt();}
		catch (Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			sc.nextLine();
			return;
		}
		if (sel == 1) toFreeBoard();
		else return;
	}
}