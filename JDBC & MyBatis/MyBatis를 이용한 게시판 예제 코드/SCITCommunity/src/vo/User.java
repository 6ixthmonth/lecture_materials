package vo;

public class User {
	private int num;
	private String name;
	private String id;
	private String pw;
	
	public User() {}
	
	public User(String id, String pw) { // 로그인에 사용하는 생성자
		super();
		this.id = id;
		this.pw = pw;
	}

	public User(String name, String id, String pw) { // 회원 가입에 사용하는 생성자
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [num=" + num + ", name=" + name + ", id=" + id + ", pw=" + pw + "]";
	}
}