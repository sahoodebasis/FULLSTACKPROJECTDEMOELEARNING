package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

public class CourseDetailsTest {

	CourseDetails courseDetails=new CourseDetails();
	
	@Test
	void testCourseId() {
		courseDetails.setCourseId(2);
		assertEquals(courseDetails.getCourseId(),2);
	}
	
	@Test
	void testCourseCategory() {
		courseDetails.setCourseCategory("instructor-led");
		assertEquals(courseDetails.getCourseCategory(),"instructor-led");
	}
	
	@Test
	void testName() {
		courseDetails.setName("Machine Learning");
		assertEquals(courseDetails.getName(),"Machine Learning");
	}
	
	@Test
	void testShortDescription() {
		courseDetails.setShortDescription("Welcome to the course of Machine Learning");
		assertEquals(courseDetails.getShortDescription(),"Welcome to the course of Machine Learning");
	}
	
	@Test
	void testVendorId() {
		courseDetails.setVendorId(1);
		assertEquals(courseDetails.getVendorId(),1);
	}
	
	@Test
	void testIsActive() {
		courseDetails.setActive(true);
		assertEquals(courseDetails.isActive(),true);
	}
	
	@Test
	void testPrice() {
		courseDetails.setPrice(1100);
		assertEquals(courseDetails.getPrice(),1100);
	}
	
	@Test
	void testDuration() {
		courseDetails.setDuration(4);
		assertEquals(courseDetails.getDuration(),4);
	}
	
	@Test
	void testDateOfLaunch() throws ParseException {
		courseDetails.setDateOfLaunch(new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"));
		assertEquals(courseDetails.getDateOfLaunch(),new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"));
	}
	
//	@Test
//	void testNoOfSubscription() {
//		courseDetails.setNoOfSubscription(5);
//		assertEquals(courseDetails.getNoOfSubscription(),5);
//	}
//	
	@Test
	void testPicture() {
		courseDetails.setPicture("https://uploads.toptal.io/blog/image/125320/toptal-blog-image-1517837300693-a3b0d1a0932057bbb4272c6c8feba197.png");
		assertEquals(courseDetails.getPicture(),"https://uploads.toptal.io/blog/image/125320/toptal-blog-image-1517837300693-a3b0d1a0932057bbb4272c6c8feba197.png");
	}
	
	@Test
	void testLanguages() {
		courseDetails.setLanguages("English,German");
		assertEquals(courseDetails.getLanguages(),"English,German");
	}
	
	@Test
	void testLearningGoals() {
		courseDetails.setLearningGoals("Understand the Fundamental Theories of Machine Learning");;
		assertEquals(courseDetails.getLearningGoals(),"Understand the Fundamental Theories of Machine Learning");
	}
	
	@Test
	void testRequirements() {
		courseDetails.setRequirements("Basics of statistics");
		assertEquals(courseDetails.getRequirements(),"Basics of statistics");
	}
	
	@Test
	void testDescription() {
		courseDetails.setDescription("Learn to cook Turkish traditional mezes and dishes in a very simple way,Learn to cook Turkish traditional mezes and dishes in a very simple way,Learn to cook Turkish traditional mezes and dishes in a very simple way,Learn to cook Turkish traditional mezes and dishes in a very simple way");
		assertEquals(courseDetails.getDescription(),"Learn to cook Turkish traditional mezes and dishes in a very simple way,Learn to cook Turkish traditional mezes and dishes in a very simple way,Learn to cook Turkish traditional mezes and dishes in a very simple way,Learn to cook Turkish traditional mezes and dishes in a very simple way");
	}
	
	@Test
	void testAuthor() {
		courseDetails.setAuthor("Anthony Gonsalez");
		assertEquals(courseDetails.getAuthor(),"Anthony Gonsalez");
	}
	
	//CourseDetails(int, String, String, String, int, boolean, int, int, Date, String, String, String, String, String, String,order)
	@Test
	void testToString() throws ParseException {
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1, new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		String courseDetailsToString="CourseDetails(courseId=" + courseDetails1.getCourseId() + ", courseCategory=" + courseDetails1.getCourseCategory() + ", name=" + courseDetails1.getName()
				+ ", shortDescription=" + courseDetails1.getShortDescription() + ", vendorId=" + courseDetails1.getVendorId() + ", isActive=" + courseDetails1.isActive()
				+ ", price=" + courseDetails1.getPrice() + ", duration=" + courseDetails1.getDuration() + ", dateOfLaunch=" + courseDetails1.getDateOfLaunch()
				 + ", picture=" + courseDetails1.getPicture() + ", languages=" + courseDetails1.getLanguages()
				+ ", learningGoals=" + courseDetails1.getLearningGoals() + ", requirements=" + courseDetails1.getRequirements() + ", description=" + courseDetails1.getDescription()
				+ ", author=" + courseDetails1.getAuthor() 
				+", service=" + courseDetails1.getService()+")";
		assertEquals(courseDetails1.toString(),courseDetailsToString);
	}
	
}