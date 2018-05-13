package com.intuit.cg.backendtechassessment.json;

import java.util.Date;

import org.springframework.util.StringUtils;

/**
 * JSON Representation of the add project request.
 * 
 * @author Advait Moghe
 *
 */
public class AddProjectRequestJSON {
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
	public AddProjectRequestJSON(String projectDescription, double maximumBudget, Date bidClosingDateTime) {
		assert projectDescription != null : "The projectDescription cannot be null.";
		assert !projectDescription.trim().isEmpty() : "The projectDescription cannot be empty or blank.";
		assert maximumBudget > 0 : "The maximumBudget cannot be negative or zero.";
		assert bidClosingDateTime != null : "The bidClosingDateTime cannot be null.";

		this.projectDescription = projectDescription;
		this.maximumBudget = maximumBudget;
		this.bidClosingDateTime = bidClosingDateTime;
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
}
