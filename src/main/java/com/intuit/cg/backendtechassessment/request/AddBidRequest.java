package com.intuit.cg.backendtechassessment.request;

/**
 * Representation of the bids sent by buyers.
 * 
 * @author Advait Moghe
 *
 */
public class AddBidRequest {
	private final double bidAmount;
	private final Long buyerId;

	/**
	 * Constructor for the class.
	 * 
	 * @param bidAmount
	 *            the amount to bid. Cannot be zero or negative.
	 * @param buyerId
	 *            the id of the buyer placing the bid. Cannot be zero or negative.
	 */
	public AddBidRequest(double bidAmount, long buyerId) {
		this.bidAmount = bidAmount;
		this.buyerId = buyerId;
	}

	/**
	 * Returns the bid amount.
	 * 
	 * @return the bid amount
	 */
	public double getBidAmount() {
		return bidAmount;
	}

	/**
	 * Returns the buyer id.
	 * 
	 * @return the buyer id
	 */
	public Long getBuyerId() {
		return buyerId;
	}

}
