package com.ashu.springbootdemo.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Contact;
import com.ashu.springbootdemo.util.ContactRowMapper;

@Repository
public class ContactRepository {

	private final JdbcTemplate jdbcTemplate;

	public ContactRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveContactMsg(Contact contact) {
		String sql = "insert into contact_msg (name,mobile_num,email,subject,message,status,"
				+ "created_at,created_by) values (?,?,?,?,?,?,?,?)";
		return jdbcTemplate.update(sql, contact.getName(), contact.getMobileNum(), contact.getEmail(),
				contact.getSubject(), contact.getMessage(), contact.getStatus(), contact.getCreatedAt(),
				contact.getCreatedBy());
	}

	public List<Contact> findMsgsByStatus(String status) {
		String sql = "select * from contact_msg where status=?";
		/*
		 * return jdbcTemplate.query(sql, new PreparedStatementSetter() { public void
		 * setValues(@NonNull PreparedStatement preparedStatement) throws SQLException {
		 * preparedStatement.setString(1, status); } }, new ContactRowMapper());
		 */

		return jdbcTemplate.query(sql, new ContactRowMapper(), status);
	}

	public int updateMessageStatus(Integer id, String updateUser, String status) {
		return jdbcTemplate.update("update contact_msg set status=?, updated_by=?, updated_at=? where contact_id=?",
				status, updateUser, LocalDateTime.now(), id);
	}

}
