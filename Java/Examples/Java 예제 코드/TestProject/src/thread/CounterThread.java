package thread;

public class CounterThread extends Thread {
	private Counter counter;
	private int tryCounter;
	
	public CounterThread(Counter counter, int tryCounter) {
		this.counter = counter;
		this.tryCounter = tryCounter;
	}
	
	@Override
	public void run() {
		while (tryCounter-- > 0) {
			synchronized (counter) {
				counter.increment();
				counter.decrement();
			}
			
			if (tryCounter % 100 == 0)
				System.out.println(counter.getValue());
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
} 