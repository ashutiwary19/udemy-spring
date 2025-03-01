package com.ashu.springbootdemo.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashu.springbootdemo.model.Holiday;
import com.ashu.springbootdemo.service.HolidayService;

@Controller
public class HolidaysController {

	private final HolidayService holidayService;

	public HolidaysController(HolidayService holidayService) {
		super();
		this.holidayService = holidayService;
	}

	@GetMapping("/holidays/{display}")
	public String displayHolidays(
			/* @RequestParam Boolean festival, @RequestParam Boolean federal */ @PathVariable String display,
			Model model) {
		model.addAttribute("festival",
				Holiday.Type.FESTIVAL.toString().equalsIgnoreCase(display) || display.equalsIgnoreCase("ALL"));
		model.addAttribute("federal",
				Holiday.Type.FEDERAL.toString().equalsIgnoreCase(display) || display.equalsIgnoreCase("ALL"));

		List<Holiday> holidays = holidayService.getAllHolidays();

		/*
		 * Arrays.asList(new Holiday(" Jan 1 ", "New Year's Day",
		 * Holiday.Type.FESTIVAL), new Holiday(" Oct 31 ", "Halloween",
		 * Holiday.Type.FESTIVAL), new Holiday(" Nov 24 ", "Thanksgiving Day",
		 * Holiday.Type.FESTIVAL), new Holiday(" Dec 25 ", "Christmas",
		 * Holiday.Type.FESTIVAL), new Holiday(" Jan 17 ", "Martin Luther King Jr. Day",
		 * Holiday.Type.FEDERAL), new Holiday(" July 4 ", "Independence Day",
		 * Holiday.Type.FEDERAL), new Holiday(" Sep 5 ", "Labor Day",
		 * Holiday.Type.FEDERAL), new Holiday(" Nov 11 ", "Veterans Day",
		 * Holiday.Type.FEDERAL));
		 */

		Holiday.Type[] types = Holiday.Type.values();
		for (Holiday.Type type : types) {
			model.addAttribute(type.toString(),
					holidays.stream().filter(holiday -> type.equals(holiday.getType())).collect(Collectors.toList()));
		}

		return "holiday.html";

	}
}
