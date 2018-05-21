package com.intuit.cg.backendtechassessment.autobidder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.intuit.cg.backendtechassessment.bid.srv.repository.BidJdbcRepository;
import com.intuit.cg.backendtechassessment.project.srv.entity.Project;

/**
 * A listener for the auto bidding functionality. This is a singleton as one
 * instance should be shared across all classes using the listener so the map
 * containing the auto bidders is the same across all classes and no one is
 * allowed to create a new instance.
 * 
 * @author Advait Moghe
 *
 */
public class AutoBidderListener {

	private Map<Long, List<AutoBidder>> autoBidders = new HashMap<>();
	private static final AutoBidderListener INSTANCE = new AutoBidderListener();

	/**
	 * Private constructor to avoid unwanted instantiation.
	 */
	private AutoBidderListener() {

	}

	/**
	 * Returns the singleton instance of the {@link AutoBidderListener}.
	 * 
	 * @return the instance of the listener. Will never be <code>null</code>.
	 */
	public static AutoBidderListener getInstance() {
		return INSTANCE;
	}

	/**
	 * Notifies the auto bidders for each project.
	 * 
	 * @param bidJdbcRepository
	 *            the {@link BidJdbcRepository} for accessing the bids. Cannot be
	 *            <code>null</code>.
	 * @param project
	 *            the {@link Project} whose auto bidders need to be notified. Cannot
	 *            be <code>null</code>.
	 */
	public void notifyAutoBidders(BidJdbcRepository bidJdbcRepository, Project project) {
		if (!autoBidders.containsKey(project.getId())) {
			return;
		}
		for (AutoBidder bidder : autoBidders.get(project.getId())) {
			bidder.addNewBid(bidJdbcRepository, project);
		}
	}

	/**
	 * Adds a new {@link AutoBidder} to the map.
	 * 
	 * @param autoBidder
	 *            the auto bidder to add. Cannot be <code>null</code>.
	 * @param projectId
	 *            the id of the project for which auto bidder needs to be added.
	 *            Cannot be zero or negative.
	 */
	public void addAutoBidder(AutoBidder autoBidder, Long projectId) {
		if (!autoBidders.containsKey(projectId)) {
			autoBidders.put(projectId, new ArrayList<>());
		}
		autoBidders.get(projectId).add(autoBidder);
	}
}
