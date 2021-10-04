package practice.privateconstructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class PrivateClass {
	private PrivateClass() {
		System.out.println("Constructor of 'PrivateClass' has been called.");
	}

	public void say() {
		System.out.println("Hello.");
	}
}

public class PrivateConstructorTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<PrivateClass> cls = PrivateClass.class;
		Constructor<PrivateClass> con = cls.getDeclaredConstructor();
		con.setAccessible(true);
		PrivateClass pc = con.newInstance();

		pc.say();
	}
}