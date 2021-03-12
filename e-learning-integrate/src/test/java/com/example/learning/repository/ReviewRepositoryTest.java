package com.example.learning.repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.Review;
import com.example.learning.model.ReviewDTOinterface;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class ReviewRepositoryTest
{
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Test
	public void testCreateReview() {
		Review review=new Review(2,null,null,"It was nice");
		Review savedReview=reviewRepo.save(review);
		assertNotNull(savedReview);
		
	}
	
	@Test
	void testgetAllReviewByCourseIdExist() throws ParseException {
		CourseDetails courseDetails=new CourseDetails(1,"abc1", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		Review review=new Review(2,courseDetails,null,"It was nice");
		reviewRepo.save(review);
		List<ReviewDTOinterface> list = reviewRepo.getAllReviewByCourseId(courseDetails.getCourseId());
		assertThat(list).size().isGreaterThan(0);
	}

	/*
	 * @Test void testgetAllReviewByCourseIdNotExist() { List<ReviewDTOinterface>
	 * list = reviewRepo.getAllReviewByCourseId(500); assertThat(list).isEmpty(); }
	 */
	@Test
	void testgetAllReviewByCourseIdandDelete() throws ParseException {
		CourseDetails courseDetails=new CourseDetails(1,"abc1", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		
		Review review1=new Review(2,courseDetails,null,"It was nice");
		log.info("hello  {}",courseDetails);
		Review rev = reviewRepo.save(review1);
		boolean a= reviewRepo.getAllReviewByCourseId(courseDetails.getCourseId()).isEmpty();
		log.info("before {}",reviewRepo.getAllReviewByCourseId(1).size());
		reviewRepo.delete(rev);
		log.info("after{}",reviewRepo.getAllReviewByCourseId(1).size());
		boolean b=reviewRepo.getAllReviewByCourseId(courseDetails.getCourseId()).isEmpty();
		assertFalse(a);
		
	}
	
	/*@Test
	public void testListReviews() {
		List<Review> review=(List<Review>) reviewRepo.findAll();
		
		for(Review r:review) {
			System.out.println(r);
		}
		assertThat(review).size().isGreaterThan(0);
	}*/
	
	
	
	
	
}