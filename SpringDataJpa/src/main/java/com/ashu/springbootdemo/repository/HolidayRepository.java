package com.ashu.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Holiday;

@Repository
public interface HolidayRepository extends JpaRepository<Holiday, String> {
}
