package com.intuit.cg.backendtechassessment.request;

import java.util.Date;

import com.intuit.cg.backendtechassessment.exception.BadRequestException;

/**
 * JSON Representation of the add project request.
 * 
 * @author Advait Moghe
 *
 */
public class AddProjectRequest {
	private final long sellerId;
	private final String projectDescription;
	private final double maximumBudget;
	private final Date bidClosingDateTime;

	/**
	 * Constructor for the class.
	 * 
	 * @param projectDescription
	 *            the description of the project. Cannot be <code>null</code>, empty
	 *            or blank.
	 * @param maximumBudget
	 *            the maximum budget allotted for the project. Cannot be negative.
	 * @param bidClosingDateTime
	 *            the date/time at which bidding closes. Cannot be
	 *            <code>null</code>.
	 */
	public AddProjectRequest(long sellerId, String projectDescription, double maximumBudget, Date bidClosingDateTime) {
		this.sellerId = sellerId;
		this.projectDescription = projectDescription;
		this.maximumBudget = maximumBudget;
		this.bidClosingDateTime = bidClosingDateTime;
	}

	/**
	 * Returns the sellers id.
	 * 
	 * @return the sellers id. Will never be zero or negative.
	 */
	public long getSellerId() {
		return sellerId;
	}

	/**
	 * Returns the project description.
	 * 
	 * @return the project description. Will never be <code>null</code>, empty or
	 *         blank.
	 */
	public String getProjectDescription() {
		return projectDescription;
	}

	/**
	 * Returns the maximum budget.
	 * 
	 * @return the maximum budget. Will never be negative.
	 */
	public double getMaximumBudget() {
		return maximumBudget;
	}

	/**
	 * Returns the date time that bidding closes.
	 * 
	 * @return the date time that bidding closes. Will never be <code>null</code>.
	 */
	public Date getBidClosingDateTime() {
		return bidClosingDateTime;
	}

	/**
	 * Validates the request received from the user is valid. A valid request in
	 * this case means:
	 * <ul>
	 * <li>The bid closing time is provided and that it is before the current
	 * date/time.</li>
	 * <li>The project description is not <code>null</code>, empty or blank.</li>
	 * <li>The maximum budget is greater than zero.</li>
	 * </ul>
	 */
	public void validate() {
		if (bidClosingDateTime == null) {
			throw new BadRequestException("A bid closing time must be provided.");
		}

		if (bidClosingDateTime.before(new Date())) {
			throw new BadRequestException("The bid closing time must be after current date");
		}

		if (projectDescription == null || projectDescription.trim().isEmpty()) {
			throw new BadRequestException("Project description cannot be null, empty or blank");
		}

		if (maximumBudget <= 0) {
			throw new BadRequestException("The maximum budget must be greater than zero.");
		}
	}
}
