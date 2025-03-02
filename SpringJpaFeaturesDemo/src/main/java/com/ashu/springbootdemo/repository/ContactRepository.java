package com.ashu.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
	public List<Contact> findByStatus(String status);
}
