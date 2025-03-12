package com.ashu.springbootdemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ashu.springbootdemo.model.Person;
import com.ashu.springbootdemo.repository.PersonRepository;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
public class DashboardController {

	private PersonRepository personRepository;

	@RequestMapping("/dashboard")
	public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
		Person person = personRepository.getByEmail(authentication.getName());
		session.setAttribute("loggedInPerson", person);
		model.addAttribute("username", person.getName());
		model.addAttribute("roles", authentication.getAuthorities().toString());
		return "dashboard.html";
	}

}
