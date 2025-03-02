package com.ashu.springbootdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ashu.springbootdemo.model.Holiday;
import com.ashu.springbootdemo.repository.HolidayRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HolidayService {
	private final HolidayRepository holidayRepository;

	public List<Holiday> getAllHolidays() {
		return holidayRepository.findAll();
	}

}
