package com.example.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.learning.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
	int deleteByEmail(String email);
	User findByUserIdAndRole(String role,Integer userId);
	List<User> findByHasSubscribed(Boolean hasSubscribed);
	@Query("from user where email=?1 and password=?2")
	User findByEmailAndPassword(String email, String password);
	List<User> findAllByRole(String role);
}
