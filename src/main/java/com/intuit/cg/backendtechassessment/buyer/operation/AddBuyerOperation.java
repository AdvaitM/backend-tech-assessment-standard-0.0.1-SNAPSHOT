package com.intuit.cg.backendtechassessment.buyer.operation;

import com.intuit.cg.backendtechassessment.buyer.srv.entity.Buyer;
import com.intuit.cg.backendtechassessment.buyer.srv.repository.BuyerJdbcRepository;
import com.intuit.cg.backendtechassessment.request.AddActorRequest;
import com.intuit.cg.backendtechassessment.response.AddActorResponse;

/**
 * The operation responsible for adding a buyer.
 * 
 * @author Advait Moghe
 *
 */
public class AddBuyerOperation {

	private final BuyerJdbcRepository buyerRepository;

	/**
	 * Constructor.
	 * 
	 * @param buyerRepository
	 *            the {@link BuyerJdbcRepository}. Cannot be <code>null</code>.
	 */
	public AddBuyerOperation(BuyerJdbcRepository buyerRepository) {
		this.buyerRepository = buyerRepository;
	}

	/**
	 * Performs the add buyer operation. This operation calls insert method in the
	 * ({@link BuyerJdbcRepository}.
	 * 
	 * @param addBuyerRequest
	 *            the {@link AddActorRequest buyer} request. Cannot be
	 *            <code>null</code>.
	 * @return the success response
	 */
	public AddActorResponse addBuyer(AddActorRequest addBuyerRequest) {
		Buyer buyer = new Buyer(addBuyerRequest.getDescription(), addBuyerRequest.getEmailId());
		buyerRepository.insertBuyer(buyer);
		return new AddActorResponse(buyerRepository.getLastInsertedBuyerId());
	}
}
