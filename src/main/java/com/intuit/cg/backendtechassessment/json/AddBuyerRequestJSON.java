package com.intuit.cg.backendtechassessment.json;

public class AddBuyerRequestJSON {
	private final String description;
	private final String emailId;

	public AddBuyerRequestJSON(String description, String emailId) {
		this.description = description;
		this.emailId = emailId;
	}

	public String getDescription() {
		return description;
	}

	public String getEmailId() {
		return emailId;
	}
}
