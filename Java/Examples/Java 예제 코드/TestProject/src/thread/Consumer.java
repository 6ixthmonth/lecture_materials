package thread;

public class Consumer implements Runnable {
	private Cake cake;
	
	public Consumer(Cake cake) {
		this.cake = cake;
	}
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int j = cake.consume();
			System.out.println("\t소비: " + j + "번 케이크");
			try {
				Thread.sleep((long) (Math.random() * 1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
