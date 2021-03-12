package com.example.learning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.learning.exception.UserAlreadyPresentException;
import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.User;
import com.example.learning.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userService;
	@Mock
	UserRepository userRepo;
	@Test
	void contentLoad() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		assertNotNull(user1);
	}
	@Test
	void testGetUsers() {
		List<User> users = new ArrayList<User>();
		when(userRepo.findAll()).thenReturn(users);
		assertEquals(userService.getUsers(), users);
		
	}
	@Test
	void testAddUser() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		User user2 = new User();
		when(userRepo.findByEmail(user1.getEmail())).thenReturn(user1);
		assertEquals(userService.addUser(user2), "User successfully added");
	}
	@Test
	void testAddUserException() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		when(userRepo.findByEmail(user1.getEmail())).thenReturn(user1);
		assertThrows(UserAlreadyPresentException.class,() -> userService.addUser(user1));
	}
	@Test
	void testDeleteUserException() {
		assertThrows(UserNotFoundException.class, ()-> userService.deleteUser("test@test.com"));
	}
	@Test
	void testDeleteUser() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		when(userRepo.findByEmail(user1.getEmail())).thenReturn(user1);
		assertEquals(userService.deleteUser(user1.getEmail()), "User deleted successfully");
	}
	
	@Test
	void testGetUserByEmailException() {
		assertThrows(UserNotFoundException.class,()->userService.getUserByEmail("test@test.com"));
	}
	@Test
	void testGetUserByEmail() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		when(userRepo.findByEmail(user1.getEmail())).thenReturn(user1);
		assertEquals(userService.getUserByEmail(user1.getEmail()), user1);
	}
	@Test
	void testUpdateUserException() {
		User user2 = new User();
		assertThrows(UserNotFoundException.class,()->userService.updateUser(user2));
	}
	@Test
	void testUpdateUser() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		when(userRepo.findByEmail(user1.getEmail())).thenReturn(user1);
		assertEquals(userService.updateUser(user1), "User updated successfully");
	}
	@Test
	void testChangeActiveStatusException() {
		assertThrows(UserNotFoundException.class,()->userService.changeActiveStatus("test@test.com"));
	}
	@Test
	void testChangeActiveStatus() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		when(userRepo.findByEmail(user1.getEmail())).thenReturn(user1);
		assertEquals(userService.changeActiveStatus(user1.getEmail()), "User updated successfully");
	}
	
}
