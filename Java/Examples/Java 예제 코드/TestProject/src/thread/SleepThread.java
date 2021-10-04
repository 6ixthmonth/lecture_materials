package thread;

public class SleepThread implements Runnable {
	private int count;
	
	public SleepThread(int time) {
		count = time;
	}
	
	@Override
	public void run() {
		System.out.println("Countdown Start!");
		while (count > 0) {
			System.out.println(count--);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				break;
			}
		}
		System.out.println("The end!");
	}
}