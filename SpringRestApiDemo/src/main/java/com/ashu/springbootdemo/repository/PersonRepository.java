package com.ashu.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashu.springbootdemo.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
	public Person getByEmail(String email);
}
