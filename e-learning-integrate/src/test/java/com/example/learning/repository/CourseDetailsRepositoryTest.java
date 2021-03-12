package com.example.learning.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.learning.model.CourseDetails;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
public class CourseDetailsRepositoryTest {
	@Autowired
	CourseDetailsRepository courseRepo;
	
	@Test
	@Rollback(false)
	@Order(1)
	void testCreateCourse() throws ParseException {
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		CourseDetails course1 = courseRepo.save(courseDetails1);
		assertEquals(courseDetails1.getDateOfLaunch(), course1.getDateOfLaunch());
	}
	
	@Test
	@Order(2)
	void testUpdateCourse() throws ParseException {
		CourseDetails courseDetails1=new CourseDetails(1,"abcd123", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		CourseDetails course1 = courseRepo.save(courseDetails1);
		CourseDetails c1 = courseRepo.getCourseDetails(1);
		assertThat(course1.getCourseCategory()).isEqualTo(c1.getCourseCategory());
	}
	@Test
	@Order(3)
	void testGetAllCourseDetailsListUser() {
		List<CourseDetails> list = courseRepo.getAllCourseDetailsListUser();
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(4)
	void testGetCourseDetails() throws ParseException {
		CourseDetails c1 = courseRepo.getCourseDetails(1);
		assertThat(c1).isNotNull();
			
	}
	@Test
	@Order(5)
	void testGetAllCourseDetailsVendorExist() {
		List<CourseDetails> list = courseRepo.getAllCourseDetailsListVendor(1);
		assertThat(list).size().isGreaterThan(0);
	}
	@Test
	@Order(6)
	void testGetAllCourseDetailsVendorNotExist() {
		List<CourseDetails> list = courseRepo.getAllCourseDetailsListVendor(900);
		assertThat(list).isEmpty();
	}
	/*
	 * @Test
	 * 
	 * @Order(7) void testRemoveCourseDetails() throws ParseException {
	 * CourseDetails BeforeDeletionCourse = courseRepo.getCourseDetails(1);
	 * courseRepo.removeCourseDetails(1); CourseDetails AfterDeletionCourse =
	 * courseRepo.getCourseDetails(1); assertNotNull(BeforeDeletionCourse);
	 * assertNull(AfterDeletionCourse); }
	 */
	
}