package com.example.learning.exception;

public class CourseDetailsNotFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public CourseDetailsNotFoundException(String message) 
	{
		super(message);
	}
	

}
