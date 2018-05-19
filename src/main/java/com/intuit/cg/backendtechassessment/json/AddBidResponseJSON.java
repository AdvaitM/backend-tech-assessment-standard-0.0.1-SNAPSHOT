package com.intuit.cg.backendtechassessment.json;

public class AddBidResponseJSON {
	private final long bidId;

	public AddBidResponseJSON(long bidId) {
		this.bidId = bidId;
	}

	public long getbidId() {
		return bidId;
	}

}
