package com.example.learning.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.model.Notification;
import com.example.learning.service.NotificationService;

@RestController
@CrossOrigin
@Validated
public class NotificationController {

	@Autowired
	NotificationService notificationService;

	//Dummy for course controller. Comment this mapping later on
//	@GetMapping("/addCourses")
//	public ResponseEntity<String> addCourses(){
//		notificationService.addNotification("Artificial Intelligence");
//		return ResponseEntity.ok("Course Added");
//	}
	/**
	 * Deletes notification for particular user
	 * @param userId is Id of user
	 * @valid validates the field userId
	 * @Positive indicates that field should be positive
	 * @returns a ResponseEntity<?>
	*/	
	@DeleteMapping("/deletenot/{id}")
	public ResponseEntity<String> deleteNotification(@Valid @Positive @PathVariable("id") int userId){
		notificationService.deleteAllNotificationByUserId(userId);
		return ResponseEntity.ok("notification Cleared for the User");
	}
	
	/**
	 * Retrieves ResponseEntitylist of notification for particular user
	 * @param userId is Id of user
	 * @valid validates the field userId
	 * @Positive indicates that field should be positive
	 * @returns courseDetails for particular vendorId
	*/	
	@GetMapping("/getnot/{id}")
	public ResponseEntity<List<Notification>> getNotification(@Valid @Positive @PathVariable("id") int userId){
		//List<Notification> allnotification=notificationService.getAllNotificationByUserId(userId);
		return ResponseEntity.ok(notificationService.getAllNotificationByUserId(userId));
	}
	
}
