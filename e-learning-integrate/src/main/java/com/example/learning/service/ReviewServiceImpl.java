package com.example.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.learning.exception.ReviewNotFoundException;
import com.example.learning.model.CourseDetails;
import com.example.learning.model.Review;
import com.example.learning.model.ReviewDTO;
import com.example.learning.model.ReviewDTOinterface;
import com.example.learning.model.User;
import com.example.learning.repository.CourseDetailsRepository;
import com.example.learning.repository.ReviewRepository;
import com.example.learning.repository.UserRepository;


@Service
public class ReviewServiceImpl implements ReviewService {
	

	@Autowired
	ReviewRepository reviewRepo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	CourseDetailsRepository courseDetailsRepo;
	
	@Transactional
	public  String addReview(ReviewDTO review)   
	{  
			CourseDetails courseDetails=courseDetailsRepo.findById(review.getCourseId()).get();
			User user=userRepo.findById(review.getUserId()).get();
			Review review1=new Review();
			review1.setCourseDetails(courseDetails);
			review1.setUser(user);
			review1.setDescription(review.getDescription());
			reviewRepo.save(review1);  
			return "Added Review Successfully";
	}  
	
	
	
	@Transactional
	public List<ReviewDTOinterface> getAllReviewByCourseId(Integer courseId)
	{
		List<ReviewDTOinterface> review=reviewRepo.getAllReviewByCourseId(courseId);
		
		if(review==null)
		{
			throw new ReviewNotFoundException("Reviews Not Found");	
		}
		else
		return review;
	}  	
	
	
	

}