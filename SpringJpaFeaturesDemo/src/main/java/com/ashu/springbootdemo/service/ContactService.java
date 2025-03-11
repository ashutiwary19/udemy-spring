package com.ashu.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
		Contact contactSaved = contactRepository.save(contact);
		log.info("Rows inserted : " + contactSaved.getContactId());
		return contactSaved.getContactId() > 0;
	}

	public Page<Contact> findMsgsWithOpenStatus(Integer pageNum, String sortField, String sortDir) {
		int pageSize = 5;
		Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
				equals("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending());
		return contactRepository.findByStatus(MESSAGE_STATUS_OPEN, pageable);
	}

	public boolean updateMessageStatus(Integer id, String updateUser) {
		Optional<Contact> contactOp = contactRepository.findById(id);
		contactOp.ifPresent(contact -> {
			contact.setStatus(MESSAGE_STATUS_CLOSE);
		});

		Contact contact = contactRepository.save(contactOp.get());
		return contact != null;
	}
}
