package lab2.common;

//Contains AuctionEntry Stack
//Actual manager for the auction of an item
public class ItemAuction {
	private int endTime;
	private boolean over;
	private String formattedEndTime;
	private String item;
	private Stack<AuctionEntry> bidList;
	
	public ItemAuction(String item) {
		bidList = new Stack<>();
		this.item = item;
	}
	public void addEntry(String name, int startBid, int maxBid) {
		boolean overflow = false;
		if(this.checkHighestBid() == -1)
			bidList.push(new AuctionEntry(name, startBid, maxBid));
		while(!(startBid > this.checkHighestBid()) || !overflow) {
			startBid++;
			if(startBid > maxBid) {
				overflow = true;
				break;
			}
		}
		if(!overflow)
			bidList.push(new AuctionEntry(name, startBid, maxBid));
		else
			System.out.println("Error: Auction Entry invalid, max bid selected is less than or equal to current bid");
	}
	public String getHighestBidder() {
		return bidList.top().getName();
	}
	public String getItem() {
		return item;
	}
	public int checkHighestBid() {
		if(bidList.top() != null)
			return bidList.top().getCurrentBid();
		else
			return -1;
	}
	public String toString() {
		return "\nItem: " + item
				+ "\nHighest Bidder: " + bidList.top().getName()
				+ bidList;
	}
	
}
