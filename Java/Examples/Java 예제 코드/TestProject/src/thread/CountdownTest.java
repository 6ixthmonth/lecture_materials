package thread;

public class CountdownTest {
	public static void main(String[] args) {
//		Thread t1 = new CountdownThread(10000);
		Thread t1 = new Thread(new CountdownThread("T1", 5000));
		Thread t2 = new Thread(new CountdownThread("\tT2", 5000));
		
//		t1.setPriority(1);
//		t2.setPriority(10);
		
		t1.start();
		t2.start();
	}
}