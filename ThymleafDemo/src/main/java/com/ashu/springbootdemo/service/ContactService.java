package com.ashu.springbootdemo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.ashu.springbootdemo.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@SessionScope
public class ContactService {
	private int counter = 0;

	public ContactService() {
		log.info("Counter is being initialised...");
	}

	public void saveMessageDetails(Contact contact) {
		log.info("Name : " + contact.getName());
		log.info("Mobile Number : " + contact.getMobileNum());
		log.info("Email Address : " + contact.getEmail());
		log.info("Subject : " + contact.getSubject());
		log.info("Message : " + contact.getMessage());
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
