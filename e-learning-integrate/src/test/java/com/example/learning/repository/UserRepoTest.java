package com.example.learning.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.learning.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class UserRepoTest {

	@Autowired
	UserRepository userRepo;
	
	@Test
	@Order(1)
	void testCreateUser() throws ParseException {
		Date d1 = new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998");
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,d1);
		User savedUser = userRepo.save(user1);
		assertNotNull(savedUser);
		
	}
	@Test
	void testGetByEmail() throws ParseException {
		Date d1 = new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998");
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,d1);
		userRepo.save(user1);
		User user = userRepo.findByEmail("testing@tester.com");
		assertThat(user.getContactNo()).isEqualTo("9425302456");
	}
	@Test
	@Order(2)
	void testUpdateUser() throws ParseException {
		Date d1 = new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998");
		User user2 = new User("testing1@tester.com","Tester","9425302456","testing","user",true,d1);
		User oldUser = userRepo.save(user2);
		System.out.println(user2.getName());
		User user3 = new User(oldUser.getUserId(), "testing1@tester.com","Testers","9425302456","testing","user",true,d1,false);
		userRepo.save(user3);
		System.out.println(user2.getName());
		User updatedUser = userRepo.findByEmail("testing1@tester.com");
		assertThat(user2.getName()).isEqualTo(updatedUser.getName());
	}
	@Test
	void testGetAllUsers() {
		List<User> users = userRepo.findAll();
		assertThat(users).size().isGreaterThan(0);
	}
	@Test
	void testDeleteUser() throws ParseException {
		Date d1 = new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998");
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,d1);
		userRepo.save(user1);
		User user2 = userRepo.findByEmail("testing@tester.com");
		userRepo.deleteByEmail(user1.getEmail());
		User user3 = userRepo.findByEmail("testing@tester.com");
		assertNotNull(user2);
		assertNull(user3);
		
	}
	
}
