package thread;

public class CakeTest {
	public static void main(String[] args) {
		Cake cake = new Cake();
		new Thread(new Producer(cake)).start();
		new Thread(new Consumer(cake)).start();
	}
}
