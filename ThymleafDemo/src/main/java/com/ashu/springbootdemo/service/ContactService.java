package com.ashu.springbootdemo.service;

import org.springframework.stereotype.Service;

import com.ashu.springbootdemo.model.Contact;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContactService {

	public void saveMessageDetails(Contact contact) {
		log.info("Name : " + contact.getName());
		log.info("Mobile Number : " + contact.getMobileNum());
		log.info("Email Address : " + contact.getEmail());
		log.info("Subject : " + contact.getSubject());
		log.info("Message : " + contact.getMessage());
	}
}
