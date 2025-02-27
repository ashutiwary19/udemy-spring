package com.ashu.springbootdemo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.ashu.springbootdemo.model.Contact;
import com.ashu.springbootdemo.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;
import static com.ashu.springbootdemo.util.Constants.MESSAGE_STATUS_OPEN;
import static com.ashu.springbootdemo.util.Constants.MESSAGE_STATUS_CLOSE;

@Slf4j
@Service
@SessionScope
public class ContactService {
	private final ContactRepository contactRepository;

	public ContactService(ContactRepository contactRepository) {
		log.info("Counter is being initialised...");
		this.contactRepository = contactRepository;
	}

	public boolean saveMessageDetails(Contact contact) {
		log.info("Name : " + contact.getName());
		log.info("Mobile Number : " + contact.getMobileNum());
		log.info("Email Address : " + contact.getEmail());
		log.info("Subject : " + contact.getSubject());
		log.info("Message : " + contact.getMessage());
		contact.setStatus(MESSAGE_STATUS_OPEN);
		contact.setCreatedAt(LocalDateTime.now());
		contact.setCreatedBy("Ashu Tiwary");
		int rowsInserted = contactRepository.saveContactMsg(contact);
		log.info("Rows inserted : " + rowsInserted);
		return rowsInserted > 0;
	}

	public List<Contact> findMsgsWithOpenStatus() {
		return contactRepository.findMsgsByStatus(MESSAGE_STATUS_OPEN);
	}

	public boolean updateMessageStatus(Integer id, String updateUser) {
		int update = contactRepository.updateMessageStatus(id, updateUser, MESSAGE_STATUS_CLOSE);
		return update > 0;
	}
}
