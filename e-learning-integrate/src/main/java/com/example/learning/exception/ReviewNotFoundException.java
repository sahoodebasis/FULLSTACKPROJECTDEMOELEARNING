package com.example.learning.exception;

public class ReviewNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		public ReviewNotFoundException(String message) 
		{
			super(message);
		}

	}


