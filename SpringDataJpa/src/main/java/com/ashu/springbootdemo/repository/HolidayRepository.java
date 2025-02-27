package com.ashu.springbootdemo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Holiday;
import com.ashu.springbootdemo.util.HolidayRowMapper;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, String> {
}
