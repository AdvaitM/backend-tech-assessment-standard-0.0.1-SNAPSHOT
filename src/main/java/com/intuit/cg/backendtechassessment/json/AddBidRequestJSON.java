package com.intuit.cg.backendtechassessment.json;

import java.util.Date;

/**
 * JSON representation of the bids sent by buyers.
 * 
 * @author Advait Moghe
 *
 */
public class AddBidRequestJSON {
	private final double bidAmount;
	private final Long buyerId;

	public AddBidRequestJSON(double bidAmount, long buyerId) {
		this.bidAmount = bidAmount;
		this.buyerId = buyerId;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public Long getBuyerId() {
		return buyerId;
	}

}
