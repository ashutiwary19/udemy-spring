package com.ashu.springbootdemo.service;

import org.springframework.stereotype.Service;

import com.ashu.springbootdemo.model.Person;
import com.ashu.springbootdemo.model.Roles;
import com.ashu.springbootdemo.repository.PersonRepository;
import com.ashu.springbootdemo.repository.RolesRepository;
import lombok.AllArgsConstructor;
import static com.ashu.springbootdemo.util.Constants.STUDENT_ROLE;

@AllArgsConstructor
@Service
public class PersonService {

	private PersonRepository personRepository;
	private RolesRepository rolesRepository;

	public Boolean createNewPerson(Person person) {

		Roles role = rolesRepository.getByRoleName(STUDENT_ROLE);
		person.setRole(role);
		return personRepository.save(person).getPersonId() > 0;
	}
}
