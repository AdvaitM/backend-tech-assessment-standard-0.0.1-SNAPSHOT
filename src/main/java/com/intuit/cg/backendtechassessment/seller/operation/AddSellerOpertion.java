package com.intuit.cg.backendtechassessment.seller.operation;

import com.intuit.cg.backendtechassessment.request.AddActorRequest;
import com.intuit.cg.backendtechassessment.response.AddActorResponse;
import com.intuit.cg.backendtechassessment.seller.srv.entity.Seller;
import com.intuit.cg.backendtechassessment.seller.srv.repository.SellerJdbcRepository;

/**
 * The operation for adding a seller.
 * 
 * @author Advait Moghe
 *
 */
public class AddSellerOpertion {

	private final SellerJdbcRepository sellerRepository;

	/**
	 * Constructor for the class
	 * 
	 * @param sellerRepository
	 *            the {@link SellerJdbcRepository}. Cannot be <code>null</code>.
	 */
	public AddSellerOpertion(SellerJdbcRepository sellerRepository) {
		this.sellerRepository = sellerRepository;
	}

	/**
	 * Adds the seller to the database.
	 * 
	 * @param addSellerRequest
	 *            the add {@link AddActorRequest seller} request. Cannot be
	 *            <code>null</code>.
	 * @return the success response
	 */
	public AddActorResponse addSeller(AddActorRequest addSellerRequest) {
		Seller seller = new Seller(addSellerRequest.getDescription(), addSellerRequest.getEmailId());
		sellerRepository.insert(seller);
		return new AddActorResponse(sellerRepository.getLastInsertedSellerId());
	}
}
