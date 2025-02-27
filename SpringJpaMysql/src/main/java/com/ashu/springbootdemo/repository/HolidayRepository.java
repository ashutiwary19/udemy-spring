package com.ashu.springbootdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Holiday;
import com.ashu.springbootdemo.util.HolidayRowMapper;

@Repository
public class HolidayRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Holiday> getHolidays() {
		return jdbcTemplate.query("SELECT * FROM holidays", BeanPropertyRowMapper.newInstance(Holiday.class));
	}
}
