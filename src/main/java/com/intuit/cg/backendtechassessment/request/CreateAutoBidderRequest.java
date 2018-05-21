package com.intuit.cg.backendtechassessment.request;

import org.springframework.dao.EmptyResultDataAccessException;

import com.intuit.cg.backendtechassessment.buyer.srv.repository.BuyerJdbcRepository;
import com.intuit.cg.backendtechassessment.exception.EntityNotFoundException;

/**
 * Representation of an auto bidder.
 * 
 * @author Advait Moghe
 *
 */
public class CreateAutoBidderRequest {

	private final Long buyerId;
	private final float bidFactor;
	private final double minimumBidLimit;

	/**
	 * Constructor for the class.
	 * 
	 * @param buyerId
	 *            the id of the buyer creating the auto bidder
	 * @param bidFactor
	 *            the factor by which the new bid is to be calculated. The new bid
	 *            is calculated as <code>bidFactor*lowestBid</code>. Cannot be zero
	 *            or negative.
	 * @param minimumBidLimit
	 *            the minimum bid the auto bidder is allowed to make. If the lowest
	 *            bid is less than the minimum bid then the auto bidder will not
	 *            place a bid. Cannot be zero or negative.
	 */
	public CreateAutoBidderRequest(Long buyerId, float bidFactor, double minimumBidLimit) {
		this.buyerId = buyerId;
		this.bidFactor = bidFactor;
		this.minimumBidLimit = minimumBidLimit;
	}

	/**
	 * Returns the buyer id.
	 * 
	 * @return the buyer id
	 */
	public Long getBuyerId() {
		return buyerId;
	}

	/**
	 * Returns the bid factor.
	 * 
	 * @return the bid factor
	 */
	public float getBidFactor() {
		return bidFactor;
	}

	/**
	 * Returns the minimum bid limit.
	 * 
	 * @return the minimum bid limit
	 */
	public double getMinimumBidLimit() {
		return minimumBidLimit;
	}

	public void validate(BuyerJdbcRepository buyerRepository) {
		try {
			buyerRepository.getBuyerById(buyerId);
		} catch (EmptyResultDataAccessException exception) {
			throw new EntityNotFoundException("No buyer with buyerId id [" + buyerId + "] were found.");
		}
	}

}
