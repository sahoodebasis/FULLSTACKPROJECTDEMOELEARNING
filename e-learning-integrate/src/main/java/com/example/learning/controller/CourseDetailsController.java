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

import com.example.learning.model.CourseDetails;
import com.example.learning.model.MessageResponse;
import com.example.learning.service.CourseDetailsService;

@RestController
@CrossOrigin
//@RequestMapping("/courses")
public class CourseDetailsController {
	
	@Autowired
	CourseDetailsService courseDetailsService;
//	@Autowired
//	NotificationService notificationService;
	
	/**
	 * Retrieves ResponseEntity
	 * Add courseDetails structure within @RequestBody 
	 * @returns the status,time,message
	 * */
	@PostMapping(value="/addcourses")
	public ResponseEntity<MessageResponse> addCourseDetails(@RequestBody CourseDetails courseDetails)  {
		courseDetailsService.addCourseDetails(courseDetails);
		return ResponseEntity.ok().body(new MessageResponse( HttpStatus.OK.value(),"Added Successfully and notification sent"));
	}
	
	/**
	 * Retrieves list of courseDetails for user
	 * @returns list of courseDetails */
	@GetMapping("/getallcoursedetailstouser")
	public ResponseEntity<List<CourseDetails>> getAllCourseDetailsListUser() {
		return new ResponseEntity<>(courseDetailsService.getAllCourseDetailsListUser(), HttpStatus.OK);
	}
	
	/**
	 * Retrieves courseDetails of given course Id
	 * @param courseId is Id of course
	 * @returns courseDetails for particular courseId
	*/	
	@GetMapping("/getcoursedetailstouser/{courseid}")
	public ResponseEntity<CourseDetails> getCourseDetails(@PathVariable("courseid") int courseid) {
		return new ResponseEntity<>(courseDetailsService.getCourseDetails(courseid), HttpStatus.OK);
	}
	
	/**
	 * Retrieves list of courseDetails for vendor
	 * @param vendorId is Id of vendor
	 * @returns courseDetails for particular vendorId
	*/	
	@GetMapping("/getallcoursedetailstovendor/{vendorid}")
	public ResponseEntity<List<CourseDetails>> getAllCourseDetailsListVendor(@PathVariable("vendorid") int vendorid) {
		return new ResponseEntity<>(courseDetailsService.getAllCourseDetailsListVendor(vendorid), HttpStatus.OK);
	}
	
	/**
	 * Retrieves list of courseDetails for given service
	 * @param serviceId is Id of service
	 * @return List of courseDetails
	 * @throws throws exception if anything is invalid
	 */
	/*
	 * @DeleteMapping(value="/deletecoursedetails/{courseid}/{vendorid}") public
	 * ResponseEntity<MessageResponse> removeCourseDetails(@PathVariable("courseid")
	 * int courseid,@PathVariable("vendorid") int vendorid) {
	 * courseDetailsService.removeCourseDetails(courseid, vendorid); return
	 * ResponseEntity.ok().body(new
	 * MessageResponse(HttpStatus.OK.value(),"Deleted Successfully")); }
	 */

	@GetMapping("/courses/{serviceId}")
	public ResponseEntity<List<CourseDetails>> getAllCoursesForServices(@PathVariable("serviceId") int serviceId) throws Exception {

		List<CourseDetails> cd = courseDetailsService.getAllCoursesForServices(serviceId);
		return new ResponseEntity<List<CourseDetails>>(cd, HttpStatus.OK);

	}
	@GetMapping("/getcoursedetails/{courseid}")
	public ResponseEntity<CourseDetails> getCourseDetailsByCourseId(@PathVariable("courseid") int courseid) {
		return new ResponseEntity<>(courseDetailsService.getCourseDetailsByCourseId(courseid), HttpStatus.OK);
	}
}
