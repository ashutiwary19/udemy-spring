package com.ashu.springbootdemo.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandler(Exception exception) {
		ModelAndView errorPage = new ModelAndView();
		log.error("Exception occured : ", exception);
		errorPage.setViewName("error");
		errorPage.addObject("errorMsg", exception.getMessage());
		return errorPage;
	}

}
