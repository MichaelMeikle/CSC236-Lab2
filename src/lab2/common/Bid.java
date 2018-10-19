package lab2.common;

public class Bid {
	private int max;
	private int current;
	private int start;
	public Bid(int start, int max) {
		this.start = start;
		this.current = start;
		this.max = max;
	}
	public int getMax() {
		return max;
	}
	public int getCurrent() {
		return current;
	}
	public int getStart() {
		return start;
	}
	public boolean setCurrent(int current) {
		if(current <= max)
			this.current = current;
		else
			return false;
		return true;
	}
	public String toString() {
		return "\nCurrent Bid: " + current;
	}
}
