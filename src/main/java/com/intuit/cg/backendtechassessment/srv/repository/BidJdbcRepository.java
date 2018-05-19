package com.intuit.cg.backendtechassessment.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.srv.entity.Bid;
import com.intuit.cg.backendtechassessment.srv.repository.BidJdbcRepository.BidRowMapper;

@Repository
public class BidJdbcRepository {
	@Autowired
	JdbcTemplate jdbcTemplate;

	class BidRowMapper implements RowMapper<Bid> {

		@Override
		public Bid mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Bid bid = new Bid(resultSet.getLong("id"), resultSet.getLong("buyer_id"), resultSet.getLong("project_id"),
					resultSet.getDouble("bid_amount"), resultSet.getDate("bid_placed_date_time"));
			return bid;
		}
	}

	public int insertBid(Bid bid) {
		return jdbcTemplate.update(
				"insert into bid (bid_amount, bid_placed_date_time, buyer_id, project_id) " + "values(?, ?, ?, ?)",
				new Object[] { bid.getBidAmount(), bid.getBidPlacedDateTime(), bid.getBuyerId(), bid.getProjectId() });
	}

	public Long getLastInsertedRow() {
		List<Bid> bid = jdbcTemplate.query("select * from bid", new BidRowMapper());
		return bid.get(bid.size() - 1).getId();
	}

}
