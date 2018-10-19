package lab2.common;

public class Main {
	public static void main(String[] args) {
		AuctionEntry testEntry = new AuctionEntry("TestName", 1, 5);
		System.out.println(testEntry);
	}
}
/*
 * Item Auction runs an auction for a particular item and contains a list of AuctionEntrys
 * AuctionEntry has a person and a bid object
 * The bidList is a list of auctionEntries
 */
