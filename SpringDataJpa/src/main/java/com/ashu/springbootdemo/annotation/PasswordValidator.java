package com.ashu.springbootdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ashu.springbootdemo.validators.PasswordStrengthValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordValidator {

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String message() default "Fields values don't match!";
}
