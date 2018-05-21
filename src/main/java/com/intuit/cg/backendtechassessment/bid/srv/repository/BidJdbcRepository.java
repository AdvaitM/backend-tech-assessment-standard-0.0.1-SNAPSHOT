package com.intuit.cg.backendtechassessment.bid.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.bid.srv.entity.Bid;

/**
 * The repository used for accessing bidding data.
 * 
 * @author Advait Moghe
 *
 */
@Repository
public class BidJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * A <code>RowMapper</code> to map the attributes on the bid table to the
	 * {@link Bid} object.
	 * 
	 * @author Advait Moghe
	 *
	 */
	class BidRowMapper implements RowMapper<Bid> {

		@Override
		public Bid mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Bid bid = new Bid(resultSet.getLong("id"), resultSet.getLong("buyer_id"), resultSet.getLong("project_id"),
					resultSet.getDouble("bid_amount"), resultSet.getDate("bid_placed_date_time"));
			return bid;
		}
	}

	/**
	 * Inserts the given {@link Bid} into the bid table.
	 * 
	 * @param bid
	 *            the {@link Bid} to insert. Cannot be <code>null</code>.
	 * @return the number of rows affected
	 */
	public int insertBid(Bid bid) {
		return jdbcTemplate.update(
				"insert into bid (bid_amount, bid_placed_date_time, buyer_id, project_id) " + "values(?, ?, ?, ?)",
				new Object[] { bid.getBidAmount(), bid.getBidPlacedDateTime(), bid.getBuyerId(), bid.getProjectId() });
	}

	/**
	 * Retrieves the list of lowest bids by for a project ordered by the date/time
	 * the bids we placed as long as the bids were placed before the bid closing
	 * time.
	 * 
	 * @param projectId
	 *            the id of the project whose bids are to be retrieved. Cannot be
	 *            zero or negative.
	 * @param bidClosingDateTime
	 *            the bid closing {@link Date}. Cannot be <code>null</code>.
	 * @return the list of lowest bids ordered in ascending order by the time the
	 *         bids were placed.
	 */
	public List<Bid> getLowestBidsByProjectId(Long projectId, Date bidClosingDateTime) {
		// Retrieves the minimum bids based on the projectId and bid closing time
		// If one or more buyers have the same lowest bid then the bids are ordered by
		// the time the buyer placed the bids so that the buyer that placed the bid
		// first
		// is given preference. Any bids placed after the bid closing time will not be
		// returned and thus the buyer with the lowest bid placed before bid
		// closing wins.

		return jdbcTemplate.query(
				"select * from bid where bid_amount = (select MIN(bid_amount) from bid where project_id = ? and bid_placed_date_time < ?) order by bid_placed_date_time;",
				new Object[] { projectId, bidClosingDateTime }, new BidRowMapper());
	}

}
