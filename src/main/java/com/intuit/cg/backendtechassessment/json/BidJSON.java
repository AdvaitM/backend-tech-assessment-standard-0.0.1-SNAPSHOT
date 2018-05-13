package com.intuit.cg.backendtechassessment.json;

/**
 * JSON representation of the bids sent by buyers.
 * 
 * @author Advait Moghe
 *
 */
public class BidJSON {

	private final double bidAmount;

	public BidJSON(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public double getBidAmount() {
		return bidAmount;
	}

}
