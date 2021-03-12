package com.example.learning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.learning.exception.CourseDetailsNotFoundException;
import com.example.learning.exception.UserNotFoundException;
import com.example.learning.model.CourseDetails;
import com.example.learning.model.User;
import com.example.learning.repository.CourseDetailsRepository;
import com.example.learning.repository.UserRepository;

@SpringBootTest
public class CourseDetailsServiceImplTest {
	@InjectMocks
	CourseDetailsServiceImpl courseServiceService;
	
	@Mock
	CourseDetailsRepository courseServiceRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	NotificationServiceImpl notificationService;
	
	
	@Test
	void getAllCourseDetailsListUserTest() throws ParseException {
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		CourseDetails courseDetails2=new CourseDetails(2,"abcd", "abcd", "abcd", 2, true, 2, 2,
				new SimpleDateFormat("dd/mm/yyyy").parse("29/01/1998"), "abcd", "abcd", "abcd", "abcd", "abcd", "abcd", null);
		List<CourseDetails> givenList = new ArrayList<CourseDetails>();
		givenList.add(courseDetails1);
		givenList.add(courseDetails2);
		when(courseServiceRepository.getAllCourseDetailsListUser()).thenReturn(givenList);
		List<CourseDetails> courseDetailsList=courseServiceService.getAllCourseDetailsListUser();
		assertEquals(2,courseDetailsList.size());
	}
	
	
	@Test
	void getCourseDetailsTest() throws ParseException {
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		when(courseServiceRepository.getCourseDetails(1)).thenReturn(courseDetails1);
		CourseDetails courseDetailsList=courseServiceService.getCourseDetails(1);

		assertEquals("abc",courseDetailsList.getName());
	}
	
	@Test
	void getAllCourseDetailsListVendorTest() throws ParseException {
		Optional<User> userOptional = Optional.of(new User(1,"abc@gmail.com","Sandeep","9998821312","abcde123","vendor",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),true));
		when(userRepository.findById(1)).thenReturn(userOptional);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		CourseDetails courseDetails2=new CourseDetails(2,"abcd", "abcd", "abcd", 1, true, 2, 2,
				new SimpleDateFormat("dd/mm/yyyy").parse("29/01/1998"), "abcd", "abcd", "abcd", "abcd", "abcd", "abcd", null);
		List<CourseDetails> givenList = new ArrayList<CourseDetails>();
		givenList.add(courseDetails1);
		givenList.add(courseDetails2);
		when(courseServiceRepository.getAllCourseDetailsListVendor(1)).thenReturn(givenList);
		List<CourseDetails> courseDetailsList=courseServiceService.getAllCourseDetailsListVendor(1);
		assertEquals(2,courseDetailsList.size());
	}
	
	@Test
	void addCourseDetailsTest() throws ParseException {
		Optional<User> userOptional = Optional.of(new User(1,"abc@gmail.com","Sandeep","9998821312","abcde123","vendor",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),true));
		when(userRepository.findById(1)).thenReturn(userOptional);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		when(courseServiceRepository.save(courseDetails1)).thenReturn(null);
		courseServiceService.addCourseDetails(courseDetails1);
	}
	
//	@Test
//	void removeCourseDetailsTest() throws ParseException {
//		Optional<User> userOptional = Optional.of(new User(1,"abc@gmail.com","Sandeep","9998821312","abcde123","vendor",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),true));
//		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
//				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
//		Optional<CourseDetails> courseOptional = Optional.of(courseDetails1);
//		when(userRepository.findById(1)).thenReturn(userOptional);
//		
//		when(courseServiceRepository.findById(1)).thenReturn(courseOptional);
//		courseServiceService.removeCourseDetails(1,1);
//	}

	@Test
	void getAllCourseDetailsListUserFailureTest() {	
		List<CourseDetails> givenList = new ArrayList<CourseDetails>();
		when(courseServiceRepository.getAllCourseDetailsListUser()).thenReturn(givenList);	
		assertThrows(CourseDetailsNotFoundException.class, ()->courseServiceService.getAllCourseDetailsListUser());
	}
	
	@Test
	void getCourseDetailsFailureTest() {	
		CourseDetails courseDetails = null;
		when(courseServiceRepository.getCourseDetails(1)).thenReturn(courseDetails);	
		assertThrows(CourseDetailsNotFoundException.class, ()->courseServiceService.getCourseDetails(1));
	}
	@Test
	void getAllCourseDetailsListVendorFailureTest1() throws ParseException {	
		CourseDetails courseDetails = null;
		Optional<User> userOptional = Optional.of(new User(1,"abc@gmail.com","Sandeep","9998821312","abcde123","vendor",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),true));
		when(userRepository.findById(1)).thenReturn(userOptional);
		List<CourseDetails> givenList = new ArrayList<CourseDetails>();
		when(courseServiceRepository.getAllCourseDetailsListVendor(1)).thenReturn(givenList);
		when(courseServiceRepository.getCourseDetails(1)).thenReturn(courseDetails);	
		assertThrows(CourseDetailsNotFoundException.class, ()->courseServiceService.getAllCourseDetailsListVendor(1));
	}

	
	@Test
	void getAllCourseDetailsListVendorFailureTest2() {	
		assertThrows(UserNotFoundException.class, ()->courseServiceService.getAllCourseDetailsListVendor(2));
	}
	
	
	@Test
	void addCourseDetailsFailureTest() {	
		CourseDetails courseDetails1=new CourseDetails();
		assertThrows(UserNotFoundException.class, ()->courseServiceService.addCourseDetails(courseDetails1));
	}
	
	/*
	 * @Test void removeCourseDetailsFailureTest1() throws ParseException {
	 * Optional<CourseDetails> courseDetails = Optional.of(new CourseDetails());
	 * Optional<User> userOptional = Optional.of(new
	 * User(1,"abc@gmail.com","Sandeep","9998821312","abcde123","vendor",true,new
	 * SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),true));
	 * when(userRepository.findById(1)).thenReturn(userOptional);
	 * when(courseServiceRepository.findById(1)).thenReturn(courseDetails);
	 * assertThrows(CourseDetailsNotFoundException.class,
	 * ()->courseServiceService.removeCourseDetails(2,1)); }
	 * 
	 * @Test void removeCourseDetailsFailureTest2() {
	 * assertThrows(UserNotFoundException.class,
	 * ()->courseServiceService.removeCourseDetails(1,2)); }
	 */
	
}
