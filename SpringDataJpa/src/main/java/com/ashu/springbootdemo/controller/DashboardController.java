package com.ashu.springbootdemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {

	@RequestMapping("/dashboard")
	public String displayDashboard(Model model, Authentication authentication) {
		model.addAttribute("username", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities().toString());
		return "dashboard.html";
	}

}
