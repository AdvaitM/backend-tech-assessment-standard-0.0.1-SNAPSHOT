package com.intuit.cg.backendtechassessment.autobidder;

import java.util.Date;
import java.util.List;

import com.intuit.cg.backendtechassessment.bid.srv.entity.Bid;
import com.intuit.cg.backendtechassessment.bid.srv.repository.BidJdbcRepository;
import com.intuit.cg.backendtechassessment.project.srv.entity.Project;

/**
 * Implementation of the {@link AutoBidder}.
 * 
 * @author Advait Moghe
 *
 */
public class AutoBidderImpl implements AutoBidder {

	private final Long buyerId;
	private final float bidFactor;
	private final double minimumBidLimit;

	/**
	 * Constructor for the class
	 * 
	 * @param buyerId
	 *            the buyer id. Cannot be zero or negative.
	 * @param bidFactor
	 *            the factor by which to calculate the new bid. Cannot be zero or
	 *            negative.
	 * @param minimumBidLimit
	 */
	public AutoBidderImpl(Long buyerId, float bidFactor, double minimumBidLimit) {
		this.buyerId = buyerId;
		this.bidFactor = bidFactor;
		this.minimumBidLimit = minimumBidLimit;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addNewBid(BidJdbcRepository bidRepository, Project project) {
		List<Bid> bids = bidRepository.getLowestBidsByProjectId(project.getId(), project.getBidClosingDateTime());
		if (bids.isEmpty()) {
			return;
		}

		Bid lowestBid = bids.get(0);

		double lowestBidAmount = lowestBid.getBidAmount();

		if (lowestBidAmount < minimumBidLimit) {
			return;
		}

		double newBid = lowestBidAmount * bidFactor;
		Bid bid = new Bid(buyerId, project.getId(), newBid < minimumBidLimit ? minimumBidLimit : newBid, new Date());
		bidRepository.insertBid(bid);
	}

}
