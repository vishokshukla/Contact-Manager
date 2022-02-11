package com.contact.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.contact.model.Contact;

public class ContactDAOImpl implements ContactDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ContactDAOImpl(DataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Integer save(Contact contact) {
		// TODO Auto-generated method stub
		String sql = "insert into contact (name, email, address, phone) values (?,?,?,?)";
		return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());
	}

	@Override
	public Integer update(Contact contact) {
		// TODO Auto-generated method stub
		String sql = "update contact set name=?, email=?, address=?, phone=? where contact_id=?";
		return jdbcTemplate.update(sql,contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(), contact.getId());
	}

	@Override
	public Contact getContact(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from contact where contact_id="+id;
		
		ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>() {

			@Override
			public Contact extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String name = rs.getString("name");
					String email = rs.getString("email");
					String address = rs.getString("address");
					String phone = rs.getString("phone");
					
					return new Contact(id,name, email, address, phone);
				}
				return null;
			}
		};
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public Integer delete(Integer id) {
		String sql = "delete from contact where contact_id="+id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> listContact() {
		String sql = "select * from contact";
		RowMapper<Contact> rowMapper = new RowMapper<Contact>() {

			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("contact_id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				
				return new Contact(id, name, email, address, phone);
			}
		};	
		return jdbcTemplate.query(sql, rowMapper);
	}

}
