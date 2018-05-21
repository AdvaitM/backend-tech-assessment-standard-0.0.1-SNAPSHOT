package com.intuit.cg.backendtechassessment.seller.operation;

import org.springframework.beans.factory.annotation.Autowired;

import com.intuit.cg.backendtechassessment.request.AddActorRequest;
import com.intuit.cg.backendtechassessment.response.AddActorResponse;
import com.intuit.cg.backendtechassessment.seller.srv.entity.Seller;
import com.intuit.cg.backendtechassessment.seller.srv.repository.SellerJdbcRepository;

public class AddSellerOpertion {

	private final SellerJdbcRepository sellerRepository;

	public AddSellerOpertion(SellerJdbcRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

	public AddActorResponse addSeller(AddActorRequest addSellerRequest) {
		Seller seller = new Seller(addSellerRequest.getDescription(), addSellerRequest.getEmailId());
		sellerRepository.insert(seller);
		return new AddActorResponse(sellerRepository.getLastInsertedSellerId());
	}
}
