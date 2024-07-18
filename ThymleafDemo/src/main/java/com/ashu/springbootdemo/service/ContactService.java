package com.ashu.springbootdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ashu.springbootdemo.model.Contact;

@Service
public class ContactService {

	private static final Logger log = LoggerFactory.getLogger(ContactService.class);

	public void saveMessageDetails(Contact contact) {
		log.info("Name : " + contact.getName());
		log.info("Mobile Number : " + contact.getMobileNum());
		log.info("Email Address : " + contact.getEmail());
		log.info("Subject : " + contact.getSubject());
		log.info("Message : " + contact.getMessage());
	}
}
