package com.ashu.springbootdemo.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Address extends BaseEntity {

	@Id
	@GeneratedValue(generator = "native", strategy = GenerationType.AUTO)
	@GenericGenerator(name = "native", strategy = "native")
	private Integer addressId;

	@NotNull(message = "Address cannot be null")
	@Size(min = 5, message = "Address cannot be less than 5 characters")
	private String address1;
	private String address2;

	@NotNull(message = "City cannot be null")
	@Size(min = 5, message = "City cannot be less than 5 characters")
	private String city;

	@NotNull(message = "State cannot be null")
	@Size(min = 5, message = "state cannot be less than 5 characters")
	private String state;

	@NotNull(message = "ZipCode cannot be null")
	@Size(min = 5, message = "ZipCode cannot be less than 5 characters")
	private Integer zipCode;
}
