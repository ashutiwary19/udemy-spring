package com.ashu.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ashu.springbootdemo.model.Person;
import com.ashu.springbootdemo.service.PersonService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
@RequestMapping("public")
public class PublicController {

	private PersonService personService;

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String displayRegisterPage(Model model) {
		model.addAttribute("person", new Person());
		return "register.html";
	}

	@RequestMapping(value = "/createUser", method = { RequestMethod.POST })
	public String createUser(@Valid @ModelAttribute("person") Person person, Errors errors) {

		if (errors.hasErrors()) {
			return "register.html";
		}

		boolean isSaved = personService.createNewPerson(person);
		if (isSaved) {
			return "redirect:/login?register=true";
		} else {
			return "register.html";
		}

	}

}
