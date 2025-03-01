package com.ashu.springbootdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashu.springbootdemo.model.Contact;
import com.ashu.springbootdemo.service.ContactService;

import jakarta.validation.Valid;

@Controller
public class ContactController {
	private static final Logger log = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService ContactService;

	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact", new Contact());
		return "contact.html";
	}

	@PostMapping("/saveMsg")
	public String saveMessage(@RequestParam String name, @RequestParam String mobileNum, @RequestParam String email,
			@RequestParam String subject, @RequestParam String message,
			@Valid @ModelAttribute("contact") Contact contact, Errors errors) {
		log.info("Name : " + contact.getName());
		log.info("Mobile Number : " + contact.getMobileNum());
		log.info("Email Address : " + contact.getEmail());
		log.info("Subject : " + contact.getSubject());
		log.info("Message : " + contact.getMessage());

		if (errors.hasErrors()) {
			log.error("Conctact form validation vfailed udue to : " + errors.toString());
			return "contact.html";
		}
		ContactService.saveMessageDetails(contact);
		return "redirect:/contact";
	}

	@GetMapping("/displayMessages")
	public ModelAndView displayMessages(Model model) {
		List<Contact> contactMsgs = ContactService.findMsgsWithOpenStatus();
		ModelAndView modelAndView = new ModelAndView("messages.html");
		modelAndView.addObject("contactMsgs", contactMsgs);
		return modelAndView;
	}

	@GetMapping("/closeMessage")
	public String closeMessage(@RequestParam Integer id, Authentication authentication) {
		boolean isUpdate = ContactService.updateMessageStatus(id, authentication.getName());
		log.info("is message status updated : " + isUpdate);
		return "redirect:/displayMessages";
	}
}
