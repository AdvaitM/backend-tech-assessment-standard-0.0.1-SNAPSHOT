package com.intuit.cg.backendtechassessment.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.srv.entity.Buyer;

@Repository
public class BuyerJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class BuyerRowMapper implements RowMapper<Buyer> {

		@Override
		public Buyer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Buyer buyer = new Buyer(resultSet.getLong("id"), resultSet.getString("description"),
					resultSet.getString("email_id"));
			return buyer;
		}
	}

	public int insertBuyer(Buyer buyer) {
		return jdbcTemplate.update("insert into buyer (description, email_id) " + "values(?, ?)",
				new Object[] { buyer.getDescription(), buyer.getEmail() });
	}

	public Long getLastInsertedRow() {
		List<Buyer> sellers = jdbcTemplate.query("select * from buyer", new BuyerRowMapper());
		return sellers.get(sellers.size() - 1).getId();
	}

}
