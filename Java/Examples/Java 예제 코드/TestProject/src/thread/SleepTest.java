package thread;

public class SleepTest {
	public static void main(String[] args) {
		Thread t1 = new Thread(new SleepThread(5));
		Thread t2 = new Thread(new SleepThread(5));
		t1.start();
		t2.start();
		System.out.println("t1 Interrupt? " + t1.isInterrupted());
		System.out.println("t2 Interrupt? " + t2.isInterrupted());
		
		t1.interrupt();
		System.out.println("t1 Interrupt? " + t1.isInterrupted());
		System.out.println("t2 Interrupt? " + t2.isInterrupted());
	}
}