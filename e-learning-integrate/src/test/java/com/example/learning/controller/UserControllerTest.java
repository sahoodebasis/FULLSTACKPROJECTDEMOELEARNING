package com.example.learning.controller;

import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.learning.model.EmailAndPasswordDto;
import com.example.learning.model.User;
import com.example.learning.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	UserServiceImpl userService;

	@Test
	void testGetUserByEmail() throws Exception {
		User user1 = new User(100,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd-mm-yyyy").parse("22-10-1998"),false);
		Mockito.when(userService.getUserByEmail("testing@tester.com")).thenReturn(user1);
		mockMvc.perform(MockMvcRequestBuilders.get("/users/{email}","testing@tester.com")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.userId", Matchers.is(100)));
	}
	@Test
	void testGetUsers() throws Exception {
		User user1 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd-mm-yyyy").parse("22-10-1998"),false);
		User user2 = new User(2,"testing@testers.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd-mm-yyyy").parse("22-10-1998"),false);

		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		when(userService.getUsers()).thenReturn(users);
		mockMvc.perform(MockMvcRequestBuilders.get("/users")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2) ))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].email", Matchers.is("testing@testers.com")));
	}
	@Test
	void testAddUser() throws Exception {
		User user1 = new User(100,"testing@tester111.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd-mm-yyyy").parse("22-10-1998"),false);
		Mockito.when(userService.addUser(user1)).thenReturn("testing");
		mockMvc.perform(MockMvcRequestBuilders.post("/add")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user1)))
				.andExpect(MockMvcResultMatchers.status().isAccepted());
	}
	@Test
	void testUpdateUser() throws Exception {
		User user1 = new User(100,"testing@tester111.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd-mm-yyyy").parse("22-10-1998"),false);
		Mockito.when(userService.updateUser(user1)).thenReturn("testing");
		mockMvc.perform(MockMvcRequestBuilders.put("/update")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(user1)))
				.andExpect(MockMvcResultMatchers.status().isAccepted());
	}
	@Test
	void testDeactivateUser() throws Exception {
		Mockito.when(userService.changeActiveStatus("testing@tester111.com")).thenReturn("testing");
		mockMvc.perform(MockMvcRequestBuilders.patch("/deactivate/{email}","testing@tester111.com")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isAccepted());
	}
	@Test
	void testDeleteUser() throws Exception {
		User user1 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new Date(22-10-1998),false);
		Mockito.when(userService.deleteUser(user1.getEmail())).thenReturn("testing");
		mockMvc.perform(MockMvcRequestBuilders.delete("/del/{email}","testing@tester111.com")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isAccepted());
	}
//	@Test
//	void testGetUser() throws JsonProcessingException, Exception {
//		User user1 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new Date(22-10-1998),false);
//		EmailAndPasswordDto dto = null ;
//		Mockito.when(userService.getUserByEmailIdAndPassword(dto)).thenReturn(user1);
//		mockMvc.perform(MockMvcRequestBuilders.post("/validate/users")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(objectMapper.writeValueAsString(dto)))
//				.andExpect(MockMvcResultMatchers.status().isOk());
//	}
	@Test
	void testGetUsersByRole() throws Exception {
		List<User> users = new ArrayList<User>();
		User user1 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new Date(22-10-1998),false);
		users.add(user1);
		when(userService.getUsersByRole("user")).thenReturn(users);
		mockMvc.perform(MockMvcRequestBuilders.get("/usersbyrole/{role}","user")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(1)));
	}

}
