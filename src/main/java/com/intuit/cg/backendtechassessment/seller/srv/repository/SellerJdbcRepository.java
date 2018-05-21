package com.intuit.cg.backendtechassessment.seller.srv.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.intuit.cg.backendtechassessment.seller.srv.entity.Seller;

/**
 * The repository used for accessing seller data.
 * 
 * @author Advait Moghe
 *
 */
@Repository
public class SellerJdbcRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * A <code>RowMapper</code> to map the attributes on the seller table to the
	 * {@link Seller} object.
	 * 
	 * @author Advait Moghe
	 *
	 */
	class SellerRowMapper implements RowMapper<Seller> {

		@Override
		public Seller mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Seller seller = new Seller(resultSet.getLong("id"), resultSet.getString("description"),
					resultSet.getString("email_id"));
			return seller;
		}
	}

	/**
	 * Inserts the given {@link Seller} into the seller table.
	 * 
	 * @param seller
	 *            the {@link Seller} to insert. Cannot be <code>null</code>.
	 * @return the number of rows affected
	 */
	public int insert(Seller seller) {
		return jdbcTemplate.update("insert into seller (description, email_id) " + "values(?, ?)",
				new Object[] { seller.getDescription(), seller.getEmail() });
	}

	/**
	 * Retrieves the id of last inserted seller in the table.
	 * 
	 * @return the id of the most recently inserted seller.
	 */
	public Long getLastInsertedSellerId() {
		List<Seller> sellers = jdbcTemplate.query("select * from seller", new SellerRowMapper());
		return sellers.get(sellers.size() - 1).getId();
	}

}
