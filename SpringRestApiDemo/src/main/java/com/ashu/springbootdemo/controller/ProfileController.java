package com.ashu.springbootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.servlet.ModelAndView;

import com.ashu.springbootdemo.model.Address;
import com.ashu.springbootdemo.model.Person;
import com.ashu.springbootdemo.model.Profile;
import com.ashu.springbootdemo.repository.PersonRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Controller
public class ProfileController {

	private PersonRepository personRepository;

	@GetMapping("displayProfile")
	public ModelAndView displayProfile(Model model, HttpSession session) {
		Person person = (Person) session.getAttribute("loggedInPerson");
		Profile profile = new Profile();
		if (person != null) {
			profile.setName(person.getName());
			profile.setMobileNumber(person.getMobileNumber());
			profile.setEmail(person.getEmail());
			if (person.getAddress() != null) {
				profile.setAddress1(person.getAddress().getAddress1());
				profile.setAddress2(person.getAddress().getAddress2());
				profile.setCity(person.getAddress().getCity());
				profile.setState(person.getAddress().getState());
				profile.setZipCode(person.getAddress().getZipCode().toString());
			}
		}
		ModelAndView modelAndView = new ModelAndView("profile.html");
		modelAndView.addObject("profile", profile);
		return modelAndView;
	}

	@PostMapping("updateProfile")
	public String updateProfile(@Valid @ModelAttribute("profile") Profile profile, Errors errors, HttpSession session) {
		if (errors.hasErrors()) {
			return "profile.html";
		}
		Person person = (Person) session.getAttribute("loggedInPerson");
		person.setName(profile.getName());
		person.setEmail(profile.getEmail());
		person.setMobileNumber(profile.getMobileNumber());
		if (person.getAddress() == null || person.getAddress().getAddressId() == 0) {
			person.setAddress(new Address());
		}
		person.getAddress().setAddress1(profile.getAddress1());
		person.getAddress().setAddress2(profile.getAddress2());
		person.getAddress().setCity(profile.getCity());
		person.getAddress().setState(profile.getCity());
		person.getAddress().setZipCode(Integer.parseInt(profile.getZipCode()));
		personRepository.save(person);
		session.setAttribute("loggedInPerson", person);
		if (person.getPersonId() != 0) {
			return "redirect:/displayProfile";
		} else {
			return "profile.html";
		}
	}

}
