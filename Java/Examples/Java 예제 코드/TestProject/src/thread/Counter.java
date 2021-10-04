package thread;

public class Counter {
	private int value;
	
	public Counter() {value = 0;}

	public /* synchronized */ void increment() {value++;}
	public /* synchronized */ void decrement() {value--;}

	public int getValue() {return value;}
}