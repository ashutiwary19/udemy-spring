package com.ashu.springbootdemo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
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
	private PasswordEncoder passwordEncoder;

	public Boolean createNewPerson(Person person) {
		Roles role = rolesRepository.getByRoleName(STUDENT_ROLE);
		person.setRole(role);
		person.setPwd(passwordEncoder.encode(person.getPwd()));
		person.setConfirmPwd(person.getPwd());
		return personRepository.save(person).getPersonId() > 0;
	}
}
