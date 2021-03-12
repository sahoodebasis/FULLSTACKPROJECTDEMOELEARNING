package com.example.learning.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class GlobalExceptionHandlerTest {
	
	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;

	@Test
	public void testHandleInvalidUserException1Handler() {
		assertEquals(globalExceptionHandler.invalidUserExceptionHandler(new UserNotFoundException(null))
				.getStatusCodeValue(), 404);
	}
	@Test
	public void testHandleInvalidUserException2Handler() {
		assertEquals(globalExceptionHandler.invalidUserExceptionHandler(new UserAlreadyPresentException(null))
				.getStatusCodeValue(), HttpStatus.INTERNAL_SERVER_ERROR.value());
	}

	@Test
	public void testCourseDetailsNotFoundExceptionHandler(){
		assertEquals(globalExceptionHandler.CourseDetailsNotFoundExceptionHandler(new CourseDetailsNotFoundException(null))
				.getStatusCodeValue(), HttpStatus.NOT_FOUND.value());
	}
	@Test
	public void handleListEmptyException() throws IOException{
		assertEquals(globalExceptionHandler.handleListEmptyException()
				.getStatusCodeValue(), HttpStatus.BAD_REQUEST.value());
	}
//	@Test
//	public void handleConnectionExceptionHandler() {
//		assertEquals(globalExceptionHandler.connectionExceptionHandler(new ConnectException(null)).getStatusCodeValue(),
//				400);
//	}

}