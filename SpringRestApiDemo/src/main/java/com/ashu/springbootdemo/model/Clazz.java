package com.ashu.springbootdemo.model;

import java.util.List;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "class")
public class Clazz extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer classId;

	@NotBlank(message = "Class name cannot be blank!")
	@Size(min = 3, message = "Class name must be min 3 characters")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "clazz", cascade = CascadeType.PERSIST, targetEntity = Person.class)
	private List<Person> students;

}
