package com.ashu.springbootdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashu.springbootdemo.model.Contact;
import com.ashu.springbootdemo.service.ContactService;

@Controller
public class ContactController {
	private static final Logger log = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService ContactService;

	@RequestMapping("/contact")
	public String displayContactPage() {
		return "contact.html";
	}

	@PostMapping("/saveMsg")
	public ModelAndView saveMessage(/*
									 * @RequestParam String name, @RequestParam String mobileNum,
									 * 
									 * @RequestParam String email, @RequestParam String subject, @RequestParam
									 * String message
									 */ Contact contact) {
		/*
		 * log.info("Name : " + contact.getName()); log.info("Mobile Number : " +
		 * contact.getMobileNum()); log.info("Email Address : " + contact.getEmail());
		 * log.info("Subject : " + contact.getSubject()); log.info("Message : " +
		 * contact.getMessage());
		 */
		ContactService.saveMessageDetails(contact);
		return new ModelAndView("redirect:/contact");

	}

}
