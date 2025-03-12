package com.ashu.springbootdemo.error;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ashu.springbootdemo.dto.Response;

@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class GlobalExeptionRestHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		Response response = new Response(status.toString(), ex.getBindingResult().toString());
		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Response> exceptionHandler(Exception ex) {
		Response response = new Response("500", ex.getMessage());
		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
