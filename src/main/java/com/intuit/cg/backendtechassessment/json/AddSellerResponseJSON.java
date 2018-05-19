package com.intuit.cg.backendtechassessment.json;

public class AddSellerResponseJSON {
	private final Long sellerId;

	public AddSellerResponseJSON(Long sellerId) {
		this.sellerId = sellerId;
	}

	public long getSellerId() {
		return sellerId;
	}
}
