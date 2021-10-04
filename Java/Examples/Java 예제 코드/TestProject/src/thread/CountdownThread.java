package thread;

public class CountdownThread /* extends Thread */implements Runnable {
	private String name;
	private int count;
	
	public CountdownThread(String name, int count) {
		this.name = name;
		this.count = count;
	}
	
	@Override
	public void run() {
		while (count > 0) {
			System.out.println(name + ": " + count--);
		}
		System.out.println(name + " Finished!");
	}
}