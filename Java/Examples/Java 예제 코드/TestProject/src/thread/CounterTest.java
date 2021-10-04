package thread;

public class CounterTest {
	public static void main(String[] args) {
		Counter counter = new Counter();
		
		new CounterThread(counter, 10000).start();
		new CounterThread(counter, 10000).start();
		new CounterThread(counter, 10000).start();
		new CounterThread(counter, 10000).start();
	}
}