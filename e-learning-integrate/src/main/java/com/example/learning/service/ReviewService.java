package com.example.learning.service;

import java.util.List;

import com.example.learning.model.ReviewDTO;
import com.example.learning.model.ReviewDTOinterface;

public interface ReviewService {

	public String addReview(ReviewDTO review);
	public List<ReviewDTOinterface> getAllReviewByCourseId(Integer courseId);  
	
}
