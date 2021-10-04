package thread;

public class Producer implements Runnable {
	private Cake cake;
	
	public Producer(Cake cake) {
		this.cake = cake;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i ++) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			cake.produce(i);
			System.out.println("생산: " + i + "번 케이크");
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
