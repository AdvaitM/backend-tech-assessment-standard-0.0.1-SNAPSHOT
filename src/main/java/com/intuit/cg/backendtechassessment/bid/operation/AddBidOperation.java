package com.intuit.cg.backendtechassessment.bid.operation;

import java.util.Date;

import com.intuit.cg.backendtechassessment.bid.srv.entity.Bid;
import com.intuit.cg.backendtechassessment.bid.srv.repository.BidJdbcRepository;
import com.intuit.cg.backendtechassessment.exception.BadRequestException;
import com.intuit.cg.backendtechassessment.project.srv.entity.Project;
import com.intuit.cg.backendtechassessment.request.AddBidRequest;

/**
 * The operation responsible for adding a bid.
 * 
 * @author Advait Moghe
 *
 */
public class AddBidOperation {

	private final BidJdbcRepository bidRepository;

	/**
	 * Constructor.
	 * 
	 * @param bidRepository
	 *            the {@link BidJdbcRepository}. Cannot be <code>null</code>.
	 */
	public AddBidOperation(BidJdbcRepository bidRepository) {
		this.bidRepository = bidRepository;
	}

	/**
	 * Performs the add bid operation.
	 * 
	 * @param addBidRequest
	 *            the bid request. Cannot be <code>null</code>.
	 * @param project
	 *            the project to add bid to. Cannot be <code>null</code>.
	 */
	public void addBid(AddBidRequest addBidRequest, Project project) {
		if (addBidRequest.getBidAmount() > project.getMaximumBudget()) {
			throw new BadRequestException("The bid amount exceedes the maximum budget");
		}
		Bid bid = new Bid(addBidRequest.getBuyerId(), project.getId(), addBidRequest.getBidAmount(), new Date());
		bidRepository.insertBid(bid);
	}
}
