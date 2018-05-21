package com.intuit.cg.backendtechassessment.buyer.operation;

import com.intuit.cg.backendtechassessment.buyer.srv.entity.Buyer;
import com.intuit.cg.backendtechassessment.buyer.srv.repository.BuyerJdbcRepository;
import com.intuit.cg.backendtechassessment.request.AddActorRequest;
import com.intuit.cg.backendtechassessment.response.AddActorResponse;

public class AddBuyerOperation {

	private final BuyerJdbcRepository buyerRepository;

	public AddBuyerOperation(BuyerJdbcRepository buyerRepository) {
		this.buyerRepository = buyerRepository;
	}

	public AddActorResponse addBuyer(AddActorRequest addBuyerRequest) {
		Buyer buyer = new Buyer(addBuyerRequest.getDescription(), addBuyerRequest.getEmailId());
		buyerRepository.insertBuyer(buyer);
		return new AddActorResponse(buyerRepository.getLastInsertedBuyerId());
	}
}
