package com.example.learning.model;


import java.time.LocalDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageResponse {

	private LocalDateTime timestamp;
	private String message;
	private int statusCode;
	private List<String> details;
	
	public MessageResponse(int statusCode,String message) {
		super();
		this.message = message;
		this.timestamp= LocalDateTime.now();
		this.statusCode = statusCode;
	}
	public MessageResponse(int statusCode,String message,List<String> details) {
		super();
		this.message = message;
		this.timestamp= LocalDateTime.now();
		this.statusCode = statusCode;
		this.details = details;
	}
	}


