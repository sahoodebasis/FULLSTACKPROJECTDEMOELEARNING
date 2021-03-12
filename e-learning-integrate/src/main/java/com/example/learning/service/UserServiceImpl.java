package com.example.learning.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.exception.UserAlreadyPresentException;
import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.EmailAndPasswordDto;
import com.example.learning.model.User;
import com.example.learning.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepo;
	
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		users = userRepo.findAll();
		return users;
	}

	@Override
	public String addUser(User user) {
		User user1 = userRepo.findByEmail(user.getEmail());
		if(user1 == null)
		{
			//System.out.println(userRepo.findByEmail(user.getEmail()));
			userRepo.save(user);
			return "User successfully added";
		}
		else
			throw new UserAlreadyPresentException("User Already exists");
	}

	@Override
	@Transactional
	public String deleteUser(String email) {
		User user1 = userRepo.findByEmail(email);
		if(user1 == null)
		{
			throw new UserNotFoundException("User not found");
		}
		else
			userRepo.deleteByEmail(email);
		return "User deleted successfully";
	}

	@Override
	public User getUserByEmail(String email) {
		User user1 = userRepo.findByEmail(email);
		if(user1 == null)
		{
			throw new UserNotFoundException("User not found");
		}
		else
			return user1;
	}

	@Override
	public String updateUser(User user) {
		User user1 = userRepo.findByEmail(user.getEmail());
		if(user1 == null)
		{
			throw new UserNotFoundException("User not found");
		}
		else
		{
			userRepo.save(user);
			return "User updated successfully";
		}
			
	}

	@Override
	public String changeActiveStatus(String email) {
		User user1 = userRepo.findByEmail(email);
		if(user1 == null)
		{
			throw new UserNotFoundException("User not found");
		}
		else
		{
			Boolean status = !user1.getIsActive();
			user1.setIsActive(status);
			userRepo.save(user1);
			return "User updated successfully";
		}
	}

	@Override
	public User getUserByEmailIdAndPassword(EmailAndPasswordDto loginuser) {
		// TODO Auto-generated method stub
		System.out.println(loginuser.toString() + loginuser.getEmail() + loginuser.getPassword());
		User user = userRepo.findByEmailAndPassword(loginuser.getEmail(),loginuser.getPassword());
		if(user == null)
		{
			throw new UserNotFoundException("User not found");
		}
		return user;
	}
	
	@Override
	public List<User> getUsersByRole(String role) {
		return userRepo.findAllByRole(role);
	}
}
