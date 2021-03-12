package com.example.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.OrderRequestDTO;
import com.example.learning.model.Orders;
import com.example.learning.model.VendorCourses;
import com.example.learning.service.OrdersService;


@CrossOrigin
@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	/**
	 * Retrieves {@code courseDetails} list of all learner ordered courseDetails 
	 * @param userId Id of user
	 * @return CourseDetails List {@code List<CourseDetails>}
	 * @throws Exception Throws exception when userId is not
	 *                                    found
	 */
	@GetMapping("/orders/learner/{userId}")
	public ResponseEntity<List<CourseDetails>> getLearnerOrderedCourses( @PathVariable("userId") int userid) throws Exception {

		List<CourseDetails> cd = ordersService.getLearnerOrderedCourses(userid);
		return new ResponseEntity<List<CourseDetails>>(cd, HttpStatus.OK);

	}
	/** 
	 * Orders are added to the database
	 * @param ord details of order
	 * @return ResponseEntity
	 * @throws Exception Throws exception
	 */
	 @PostMapping("/orders/order")
	    public ResponseEntity<?> register(@RequestBody OrderRequestDTO order) throws Exception{
	        
	        return new ResponseEntity<>(ordersService.addOrder(order),HttpStatus.OK);
	    }
	 /** 
		 * Update course complete information to the database
		 * @param userid Id of user
		 * @param orderid Id of order
		 * @param iscomplete whether course is completed or not
		 * @return a ResponseEntity
		 */
	 @PatchMapping("/orders/courseStatus/{courseId}/{userId}")
	    public ResponseEntity<?> updateResource(@RequestParam("isComplete") boolean isComplete, @PathVariable("courseId") int courseid,  @PathVariable("userId") int userid){

	        return new ResponseEntity<>(ordersService.updateCourseComplete(isComplete,courseid,userid),HttpStatus.OK);
	    }
	 /**
		 * Retrieves {@code VendorCourses} list of all Vendor Courses 
		 * @param userId Id of vendor
		 * @return VendorCourses List {@code List<VendorCourses>}
		 * @throws Exception Throws exception
		 */
	 @GetMapping("/orders/vendor/{userId}")
		public ResponseEntity<List<VendorCourses>> getVendorCousesLearnerCount( @PathVariable("userId") int userid) throws Exception {

			List<VendorCourses> vc = ordersService.getVendorCousesLearnerCount(userid);
			return new ResponseEntity<List<VendorCourses>>(vc, HttpStatus.OK);

		}
	
	 @GetMapping("/orders/iscomplete/{courseId}/{userId}")
	    public ResponseEntity<Orders> isCompleteCourse(@PathVariable("courseId") int courseid,  @PathVariable("userId") int userid){

	        return new ResponseEntity<>(ordersService.isCompleteCourse(courseid,userid),HttpStatus.OK);
	    }
}
