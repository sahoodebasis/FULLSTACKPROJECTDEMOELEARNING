package com.example.learning.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.learning.model.Review;
import com.example.learning.model.ReviewDTOinterface;

public interface ReviewRepository extends JpaRepository<Review, Integer>  
{

	@Query(value="select * from review where courseId=?1",nativeQuery=true)
	List<ReviewDTOinterface> getAllReviewByCourseId(@Param("courseId") Integer courseId);
		
	
}  
