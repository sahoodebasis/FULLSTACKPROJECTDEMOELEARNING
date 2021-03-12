package com.example.learning.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.learning.model.CourseDetails;

@Component
public interface CourseDetailsService {
	public void addCourseDetails(CourseDetails courseDetails);
	public List<CourseDetails> getAllCourseDetailsListUser();
	public CourseDetails getCourseDetails(int courseId) ;
	public List<CourseDetails> getAllCourseDetailsListVendor(int vendorId);
	//public void removeCourseDetails(int courseId,int vendorId);
	
	public List<CourseDetails> getAllCoursesForServices(int serviceId) throws Exception;
	public CourseDetails getCourseDetailsByCourseId(int courseId);
}
