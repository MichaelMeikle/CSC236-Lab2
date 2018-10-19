package lab2.common;

//Contains AuctionEntry Stack
//Actual manager for the auction of an item
public class ItemAuction {
	//Time Display Management for the Auction
	private int endTime;
	private String formattedEndTime;
	//Notes if auction is over
	private boolean over;
	
	//Item being auctioned
	private String item;
	//Auction entry stack
	private Stack<AuctionEntry> bidList;
	
	public ItemAuction(String item) {
		bidList = new Stack<>();
		this.item = item;
	}
	public void addEntry(String name, int startBid, int maxBid) {
		if(over) {
			System.out.println("Auction has concluded");
			return;
		}
		//Ensures the bid doesn't end up as 0 or less
		if(startBid <= 0) {
			startBid = 1;
		}
		boolean overflow = false;
		//Checks if there is any existing bids, if not just adds the new bid
		if(this.checkHighestBid() == -1) {
			bidList.push(new AuctionEntry(name, startBid, maxBid));
			return;
		}
		//Raises startbid until it is larger than the current highest bid, if the start bid is raised over the max bid over flow is triggered
		while(!(startBid > this.checkHighestBid()) || !overflow) {
			startBid++;
			if(startBid > maxBid) {
				overflow = true;
				break;
			}
		}
		//If there was no overflow above, adds new bid
		//If there was overflow, prints error
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
