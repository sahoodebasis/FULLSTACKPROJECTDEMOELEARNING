package com.example.learning.exception;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.learning.model.MessageResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	protected ResponseEntity<MessageResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		List<String> error = new ArrayList<String>();
		for(FieldError err: ex.getBindingResult().getFieldErrors())
		{
			error.add(err.getDefaultMessage());
		}
		MessageResponse msg = new MessageResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"Validation failed"
				,error);
		return new ResponseEntity<MessageResponse>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<MessageResponse> invalidUserExceptionHandler(UserNotFoundException exp) {
		log.error(exp.getMessage());
		MessageResponse msg1 = new MessageResponse(HttpStatus.NOT_FOUND.value(), exp.getMessage());
		return new ResponseEntity<MessageResponse>(msg1, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(UserAlreadyPresentException.class)
	public ResponseEntity<MessageResponse> invalidUserExceptionHandler(UserAlreadyPresentException exp) {
		log.error(exp.getMessage());
		MessageResponse msg1 = new MessageResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exp.getMessage());
		return new ResponseEntity<MessageResponse>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CourseDetailsNotFoundException.class) 
	public ResponseEntity<MessageResponse> CourseDetailsNotFoundExceptionHandler(CourseDetailsNotFoundException ex) {
		log.error(ex.getMessage());
		MessageResponse msg = new MessageResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return new ResponseEntity<MessageResponse>(msg, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(ListEmptyException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	//public ResponseEntity<?> handleListEmptyException(HttpServletResponse response) throws IOException {
	public ResponseEntity<?> handleListEmptyException() throws IOException {
		//response.sendError(HttpStatus.NOT_FOUND.value(), "List is Empty");
		return ResponseEntity.badRequest()
				.body(new MessageResponse(HttpStatus.BAD_REQUEST.value(), "List is Empty"));
	}
	@ExceptionHandler(ServiceAlreadyPresentException.class)
	public ResponseEntity<MessageResponse> invalidServiceExceptionHandler(ServiceAlreadyPresentException exp) {
		log.error(exp.getMessage());
		MessageResponse msg1 = new MessageResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exp.getMessage());
		return new ResponseEntity<MessageResponse>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(ServiceNotFoundException.class)
	public ResponseEntity<MessageResponse> invalidServiceExceptionHandler1(ServiceNotFoundException exp) {
		log.error(exp.getMessage());
		MessageResponse msg1 = new MessageResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exp.getMessage());
		return new ResponseEntity<MessageResponse>(msg1, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
