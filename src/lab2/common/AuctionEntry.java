package lab2.common;

public class AuctionEntry implements Comparable{
	private String timeStamp;
	private Bid bid;
	private Person person;
	//Date variable
	public AuctionEntry(String name, int startBid, int maxBid) {
		bid = new Bid(startBid, maxBid);
		person = new Person(name);
	}
	public void increaseBid(int raise) {
		//New timestamp
		bid.setCurrent(raise);
	}
	public int getCurrentBid() {
		return bid.getCurrent();
	}
	public int getMaxBid() {
		return bid.getMax();
	}
	public String getName() {
		return person.getName();
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	//Return 1 if bigger (this)
	//Return 0 if same
	//Return -1 if smaller
	public int compareTo(Object arg0) {
		return 0;
	}
	public String toString() {
		return "\nTime Stamp of Current Bid: " + timeStamp
				+ person
				+ bid;
	}
	
}
