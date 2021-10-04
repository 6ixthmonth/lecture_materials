package practice.inheritance;

class Parent2 {
	int parentMoney = 10000;
	String familyName = "김";
	
	/* super 키워드 예제 */
//	public Parent2(String name) {
//		System.out.println("부모 클래스의 생성자2가 호출되었음.");
//		this.familyName = name;
//	}
	
	public Parent2() {
		System.out.println("부모 클래스의 생성자 호출.");
	}
	
	public String getFamilyName() {
		return familyName;
	}
}

class Child2 extends Parent2 {
	int childMoney = 20000;
	String familyName = "김";

	/* super 키워드 예제 */
//	public Child2(String name) {
//		super(name);
//		
//		System.out.println("자식 클래스의 생성자2가 호출되었음.\n");
//		this.familyName = name;
//	}
	
	public Child2() {
		System.out.println("자식 클래스의 생성자1 호출.\n");
	}
	
	public Child2(String name) {
		System.out.println("자식 클래스의 생성자2 호출.\n");
		this.familyName = name;
		
	}
	
	/* override 예제 */
	@Override
	public String getFamilyName() {
		return familyName;
	}
}

public class InheritanceTest2 {
	public static void main(String[] args) {
		Child2 son = new Child2("이");
		
		System.out.println("부모가 물려준 돈: " + son.parentMoney);
		System.out.println("아들이 직접 번 돈: " + son.childMoney + "\n");
		
		System.out.println("변수로 확인한 아들의 성씨: " + son.familyName + "씨");
		System.out.println("메서드로 확인한 아들의 성씨: " + son.getFamilyName() + "씨\n");
		
		Child2 daughter = new Child2();
		System.out.println("변수로 확인한 딸의 성씨: " + daughter.familyName + "씨");
		System.out.println("메서드로 확인한 딸의 성씨: " + daughter.getFamilyName() + "씨");
	}
}