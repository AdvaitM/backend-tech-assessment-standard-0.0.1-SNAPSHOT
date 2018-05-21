package com.intuit.cg.backendtechassessment.buyer.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.buyer.srv.entity.Buyer;

/**
 * The repository used for accessing buyer data.
 * 
 * @author Advait Moghe
 *
 */
@Repository
public class BuyerJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * A <code>RowMapper</code> to map the attributes on the buyer table to the
	 * {@link Buyer} object.
	 * 
	 * @author Advait Moghe
	 *
	 */
	class BuyerRowMapper implements RowMapper<Buyer> {

		@Override
		public Buyer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Buyer buyer = new Buyer(resultSet.getLong("id"), resultSet.getString("description"),
					resultSet.getString("email_id"));
			return buyer;
		}
	}

	/**
	 * Inserts the given {@link Buyer} into the buyer table.
	 * 
	 * @param buyer
	 *            the {@link Buyer} to insert. Cannot be <code>null</code>.
	 * @return the number of rows affected
	 */
	public int insertBuyer(Buyer buyer) {
		return jdbcTemplate.update("insert into buyer (description, email_id) " + "values(?, ?)",
				new Object[] { buyer.getDescription(), buyer.getEmail() });
	}

	/**
	 * Retrieves the id of last inserted buyer in the table.
	 * 
	 * @return the id of the most recently inserted buyer.
	 */
	public Long getLastInsertedBuyerId() {
		// This is done so that the newest added buyer id can be returned to the user
		// placing the buyer for their reference
		List<Buyer> sellers = jdbcTemplate.query("select * from buyer", new BuyerRowMapper());
		return sellers.get(sellers.size() - 1).getId();
	}

	public Buyer getBuyerById(Long buyerId) {
		return jdbcTemplate.queryForObject("select * from buyer where id=?", new Object[] { buyerId },
				new BuyerRowMapper());
	}

}
