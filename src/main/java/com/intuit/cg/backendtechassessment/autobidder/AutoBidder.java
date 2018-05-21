package com.intuit.cg.backendtechassessment.autobidder;

import com.intuit.cg.backendtechassessment.bid.srv.repository.BidJdbcRepository;
import com.intuit.cg.backendtechassessment.project.srv.entity.Project;

/**
 * Interface representing an auto bidder.
 * 
 * @author Advait Moghe
 *
 */
public interface AutoBidder {

	/**
	 * Adds a new bid for the given {@link Project}. The bid is only added if the
	 * following conditions are met:
	 * <ul>
	 * <li>The lowest bid must be greater than the minimum bid limit.</li>
	 * <li>The new bid to be added by the auto bidder must be greater than the
	 * minimum bid limit.</li>
	 * </ul>
	 * 
	 * @param bidRepository
	 * @param project
	 */
	public void addNewBid(BidJdbcRepository bidRepository, Project project);

}
