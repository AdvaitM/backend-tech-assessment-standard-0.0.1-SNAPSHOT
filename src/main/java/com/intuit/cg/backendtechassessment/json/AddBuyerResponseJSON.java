package com.intuit.cg.backendtechassessment.json;

public class AddBuyerResponseJSON {
	private final Long buyerId;

	public AddBuyerResponseJSON(Long buyerId) {
		this.buyerId = buyerId;
	}

	public long getBuyerId() {
		return buyerId;
	}
}
