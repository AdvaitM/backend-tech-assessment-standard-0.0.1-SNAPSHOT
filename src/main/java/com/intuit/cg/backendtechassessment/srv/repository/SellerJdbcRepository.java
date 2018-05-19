package com.intuit.cg.backendtechassessment.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.srv.entity.Seller;

@Repository
public class SellerJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	class SellerRowMapper implements RowMapper<Seller> {

		@Override
		public Seller mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Seller seller = new Seller(resultSet.getLong("id"), resultSet.getString("description"),
					resultSet.getString("email_id"));
			return seller;
		}
	}

	public int insert(Seller seller) {
		return jdbcTemplate.update("insert into seller (description, email_id) " + "values(?, ?)",
				new Object[] { seller.getDescription(), seller.getEmail() });
	}

	public Long getLastInsertedRow() {
		List<Seller> sellers = jdbcTemplate.query("select * from seller", new SellerRowMapper());
		return sellers.get(sellers.size() - 1).getId();
	}

}
