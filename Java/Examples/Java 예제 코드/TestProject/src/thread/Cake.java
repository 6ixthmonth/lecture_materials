package thread;

public class Cake {
	private int cakeNum;
	private boolean empty;
	
	public Cake() {
		cakeNum = 0;
		empty = true;
	}
	
	public synchronized void produce(int cakeNum) {
		while (!empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = false;
		this.cakeNum = cakeNum;
		notifyAll();
	}
	
	public synchronized int consume() {
		while (empty) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		empty = true;
		notifyAll();
		return cakeNum;
	}

	public boolean isEmpty() {
		return empty;
	}

	public void setEmpty(boolean empty) {
		this.empty = empty;
	}
}
