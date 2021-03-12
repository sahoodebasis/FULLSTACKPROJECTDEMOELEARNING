package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserTest {

	User user1 = new User();
	@Order(1)
	@Test
	void contentLoad() throws ParseException {
		User user2 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		assertNotNull(user2);
	}
	
	@Test
	void testUserId() {
		
		user1.setUserId(1);
		assertEquals(user1.getUserId(), 1);
	}
	@Test
	void testEmail() {
		
		user1.setEmail("testing@tester.com");
		assertEquals(user1.getEmail(), "testing@tester.com");
	}
	@Test
	void testUserName() {
		
		user1.setName("Test");
		assertEquals(user1.getName(), "Test");
	}
	@Test
	void testUserContactNo() {
		
		user1.setContactNo("9425302456");
		assertEquals(user1.getContactNo(), "9425302456");
	}
	@Test
	void testUserIsActive() {
		
		user1.setIsActive(true);
		assertEquals(user1.getIsActive(), true);
	}
	@Test
	void testUserDateOfBirth() throws ParseException {
		Date d1 = new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998");
		user1.setDateOfBirth(d1);
		assertEquals(user1.getDateOfBirth(), d1);
	}
	@Test
	void testUserPassword() {
		
		user1.setPassword("testing");
		assertEquals(user1.getPassword(), "testing");
	}
	@Test
	void testUserRole() {
		
		user1.setRole("admin");
		assertEquals(user1.getRole(), "admin");
	}
	@Test
	void testUserHasSubscribed() {
		
		user1.setHasSubscribed(true);
		assertEquals(user1.getHasSubscribed(), true);
	}
	@Test
	void testToString() {
		String message = user1.toString();
		assertEquals(user1.toString(), message);
	}
}
