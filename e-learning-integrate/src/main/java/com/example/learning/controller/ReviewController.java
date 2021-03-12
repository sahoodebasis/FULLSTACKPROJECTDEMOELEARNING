package com.example.learning.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.model.ReviewDTO;
import com.example.learning.model.ReviewDTOinterface;
import com.example.learning.service.ReviewServiceImpl;
import com.example.learning.model.MessageResponse;

@CrossOrigin
@RestController
public class ReviewController {
	
	@Autowired
	private ReviewServiceImpl reviewService;
	


	/*
	 * Retrieves ResponseEntity
	 * Add review structure within @RequestBody 
	 * @returns the status,time,message
	 * */
	
	@PostMapping(value="/addReview")
	public ResponseEntity<MessageResponse> addCourseDetails(@RequestBody ReviewDTO review)  {
		reviewService.addReview(review);
		return ResponseEntity.ok().body(new MessageResponse(HttpStatus.OK.value(),"Review Added Successfully" ));
	}
	
	
	/*
	 * Retrieves list of reviews for a particular course id
	 * @PathVariable courseId
	 * @returns reviews */
	

	@GetMapping("/getReviews/{courseId}")  
	public ResponseEntity<List<ReviewDTOinterface>> getAllReviewByCourseId(@PathVariable("courseId") Integer courseId)   
	{  
		return new ResponseEntity<>(reviewService.getAllReviewByCourseId(courseId),HttpStatus.OK);  
	}
	
	
	
}
