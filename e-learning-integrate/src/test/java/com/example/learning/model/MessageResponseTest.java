package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class MessageResponseTest {

	MessageResponse messageResponse = new MessageResponse();

	MessageResponse message1 = new MessageResponse(101, "response");
	MessageResponse message2 = new MessageResponse(404, "response");

	@Test
	public void testMessage() {
		messageResponse.setMessage("message");
		messageResponse.setStatusCode(101);
		messageResponse.setTimestamp(LocalDateTime.now());
		messageResponse.getTimestamp();
		assertEquals(messageResponse.getMessage(), "message");
		assertEquals(messageResponse.getStatusCode(), 101);
	}

	@Test
	public void testCons() {
		assertEquals(message1.getMessage(), "response");
		List<String> details = new ArrayList<String>();
		details.add("detail1");
		MessageResponse message3 = new MessageResponse(500,"response",details);
		details.add("detail2");
		message3.setDetails(details);
		assertEquals(message3.getDetails(), details);
	}
}



