package com.example.learning.service;

import java.util.List;

import com.example.learning.model.EmailAndPasswordDto;
import com.example.learning.model.User;

public interface UserService {
	public List<User> getUsers();
	public User getUserByEmail(String email);
	public String addUser(User user);
	public String updateUser(User user);
	public String deleteUser(String email);
	public String changeActiveStatus(String email);
	public User getUserByEmailIdAndPassword(EmailAndPasswordDto loginuser);
	public List<User> getUsersByRole(String role);
}
