package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ReviewTest {

	Review review=new Review();
	
	
	@Test
	void testReviewId(){
		review.setReviewId(101);
		assertEquals(review.getReviewId(),101);
	}
	@Test
	void testCourseId(){
		review.setCourseDetails(null);
		assertEquals(review.getCourseDetails(),null);
	}
	@Test
	void testUserId(){
		review.setUser(null);
		assertEquals(review.getUser(),null);
	}
	@Test
	void testDescription(){
		review.setDescription("It was nice");
		assertEquals(review.getDescription(),"It was nice");
	}
	
	@Test
	void testAllArgsConstructor(){
		Review review1=new Review(101,null,null,"It was nice");
		assertEquals(review1.getReviewId(),101);
		assertEquals(review1.getCourseDetails(),null);
		assertEquals(review1.getUser(),null);
		assertEquals(review1.getDescription(),"It was nice");
	}
	
	@Test
	void testThreeArgsConstructor(){
		Review review1=new Review(101,null,null);
		assertEquals(review1.getReviewId(),101);
		assertEquals(review1.getCourseDetails(),null);
		assertEquals(review1.getUser(),null);
		
	}
	
	
	
	@Test
	void testTwoArgsConstructor(){
		Review review1=new Review(101,null);
		assertEquals(review1.getReviewId(),101);
		assertEquals(review1.getCourseDetails(),null);
	
		
	}
	
}