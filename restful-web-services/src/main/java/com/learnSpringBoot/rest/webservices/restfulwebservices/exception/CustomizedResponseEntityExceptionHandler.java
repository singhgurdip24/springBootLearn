package com.learnSpringBoot.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learnSpringBoot.rest.webservices.restfulwebservices.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

		@ExceptionHandler(Exception.class)
		public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req){
			ExceptionResponse exres=new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
			return new ResponseEntity(exres,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		@ExceptionHandler(UserNotFoundException.class)
		public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex, WebRequest req){
			ExceptionResponse exres=new ExceptionResponse(new Date(), ex.getMessage(), req.getDescription(false));
			return new ResponseEntity(exres,HttpStatus.NOT_FOUND);
		}
		
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(
				MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest req) {
			ExceptionResponse exres=new ExceptionResponse(new Date(), "Not Valid", ex.getBindingResult().toString());
			return new ResponseEntity(exres,HttpStatus.BAD_REQUEST);
		}
}
