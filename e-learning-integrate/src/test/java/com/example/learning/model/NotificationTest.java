package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

public class NotificationTest {

	Notification notification=new Notification();
	
	@Test
	void testNotificationId() {
		notification.setNotificationId(2);
		assertEquals(notification.getNotificationId(),2);
	}
	
	@Test
	void testUser() throws ParseException {
		notification.setUser(new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true));
		assertEquals(notification.getUser().getUserId(),2);
	}
	
	@Test
	void testDescription() {
		notification.setDescription("HI");
		assertEquals(notification.getDescription(),"HI");
	}
	
	@Test
	void testToString() throws ParseException {
		notification.setDescription("HI");
		assertEquals(notification.getDescription(),"HI");
		Notification notification=new Notification(1,new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true),"Machine Learning");
		String notToString=notification.toString();
		assertEquals(notification.toString(),notToString);
	}
	
}
