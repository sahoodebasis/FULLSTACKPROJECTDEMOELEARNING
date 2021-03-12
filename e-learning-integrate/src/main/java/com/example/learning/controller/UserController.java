package com.example.learning.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.EmailAndPasswordDto;
import com.example.learning.model.MessageResponse;
import com.example.learning.model.User;
import com.example.learning.service.UserServiceImpl;

@CrossOrigin
@RestController
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	/**
	 * Retrieves a list of users
	 * @returns a list of users
	*/	
	@GetMapping( "/users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	/**
	 * Retrieves a single user
	 * @param email user_email
	 * @returns a user according to the email
	*/	
	@GetMapping("/users/{email}")
	public User getUserByEmail(@PathVariable("email") String email) {
		return userService.getUserByEmail(email);
	}
	
	/**
	 * User is added to the database
	 * @returns a ResponseEntity<?>
	*/	
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@Valid @RequestBody User user)
	{
		return new ResponseEntity<>(new MessageResponse(HttpStatus.ACCEPTED.value()
				, userService.addUser(user)),HttpStatus.ACCEPTED);
	}
	/**
	 * Updates the information of user
	 * @RequestBody sends the information structure of user
	 * @returns a ResponseEntity<?>
	*/	
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user)
	{
		return new ResponseEntity<>(new MessageResponse(HttpStatus.ACCEPTED.value()
				, userService.updateUser(user)),HttpStatus.ACCEPTED);
	}
	/**
	 * Deletes a user 
	 * @param email user_email
	 * @returns a ResponseEntity<?>
	*/	
	@DeleteMapping("/del/{email}")
	public ResponseEntity<MessageResponse> deleteUser(@PathVariable("email") String email)
	{
		return new ResponseEntity<MessageResponse>(new MessageResponse(HttpStatus.ACCEPTED.value()
				, userService.deleteUser(email)),HttpStatus.ACCEPTED);
	}
	/**
	 * Deactivates the active state of user for given email
	 * @param email user_email
	 * @returns a ResponseEntity<?>
	*/	
	@PatchMapping("/deactivate/{email}")
	public ResponseEntity<?> deactivateUser(@PathVariable("email") String email)
	{
		return new  ResponseEntity<MessageResponse>(new MessageResponse(HttpStatus.ACCEPTED.value()
				, userService.changeActiveStatus(email)),HttpStatus.ACCEPTED);
	}
	/**
	 * User is validated with the credentials stored in the database
	 * @RequestBody gives the email and password credentials
	 * @returns a User
	*/
	@PostMapping("/validate/users")
	public User getUser(@RequestBody EmailAndPasswordDto loginuser) {
		User user= userService.getUserByEmailIdAndPassword(loginuser);
		if(user==null) {
			throw new UserNotFoundException("Invalid Credentials");
		}
		return user;
	}
	@GetMapping( "/usersbyrole/{role}")
	public List<User> getUsersByRole(@PathVariable("role") String role){
		return userService.getUsersByRole(role);
	}
}
