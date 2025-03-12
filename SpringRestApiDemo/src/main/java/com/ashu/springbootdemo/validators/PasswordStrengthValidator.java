package com.ashu.springbootdemo.validators;

import java.util.Arrays;
import java.util.List;

import com.ashu.springbootdemo.annotation.PasswordValidator;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordValidator, String> {

	List<String> weakPasswords = Arrays.asList("12345", "password", "qwerty");

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		return StringUtils.isNotBlank(password) && !weakPasswords.contains(password);
	}

}
