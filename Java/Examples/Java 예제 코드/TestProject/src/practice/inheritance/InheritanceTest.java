package practice.inheritance;

class Parent {
	int parentMoney = 10000;
	String familyName = "김";

	Parent() {
		System.out.println("Parent 생성자 호출되었음.");
	}

	String getFamilyName() {
		return familyName;
	}
}

class Child extends Parent {
	int childMoney = 20000;
	String familyName = "이";

	Child() {
		System.out.println("Child 생성자 호출되었음.");
	}

	@Override
	String getFamilyName() {
		// return familyName;
		// return super.familyName;
		return super.getFamilyName();
	}
}

public class InheritanceTest {
	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		System.out.println();

		System.out.println("부모가 소유한 재산: " + p.parentMoney);
		System.out.println("자식이 물려받은 재산: " + c.parentMoney);
		System.out.println("자식이 소유한 재산: " + c.childMoney);
		System.out.println();

		System.out.println("직접 호출한 부모의 성씨: " + p.familyName);
		System.out.println("직접 호출한 자식의 성씨: " + c.familyName);
		System.out.println("메소드로 호출한 부모의 성씨: " + p.getFamilyName());
		System.out.println("메소드로 호출한 자식의 성씨: " + c.getFamilyName());
		System.out.println();

		Parent a = new Child();
		System.out.println(a.getClass());
	}
}