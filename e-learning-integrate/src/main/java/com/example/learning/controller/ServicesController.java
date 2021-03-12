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
import com.example.learning.model.Orders;
import com.example.learning.model.OrdersDTO;
import com.example.learning.model.Services;
import com.example.learning.model.ServicesDTO;
import com.example.learning.service.ServicesServiceImpl;


@CrossOrigin
@RestController
public class ServicesController {


	@Autowired
	private ServicesServiceImpl servicesService;
	/**
	 * Retrieves a list of services
	 * @returns a list of services
	 * @throws Exception Throws exception
	*/	
	@GetMapping("/services")
	public ResponseEntity<List<Services>> getAllServices() throws Exception {

		List<Services> cd = servicesService.getAllServices();
		return new ResponseEntity<List<Services>>(cd, HttpStatus.OK);

	}
	/**
	 * Service is added to the database
	 * @RequestBody service structure is added
	 * @returns a ResponseEntity<?>
	 * @throws Exception Throws exception
	*/	
	 @PostMapping("/services/service")
	    public ResponseEntity<?> register(@RequestBody Services service) throws Exception{

	        return new ResponseEntity<>(servicesService.addService(service),HttpStatus.OK);
	    }
	 /**
		 * Updates the resource information
		 * @param isActive active status of service
		 * @param serviceId:Id of service
		 * @throws Exception Throws exception
		 * @returns a ResponseEntity<?>
		*/	
	 @PatchMapping("/services/Active/{serviceId}")
	    public ResponseEntity<?> updateResource(@RequestParam("isActive") boolean isActive, @PathVariable("serviceId") int serviceId) throws Exception{

	        return new ResponseEntity<>(servicesService.updateActiveStatus(isActive,serviceId),HttpStatus.OK);
	    }

	 //service list of vendor
	 /**
		 * Retrieves list of services for given vendor
		 * @param vendorId is Id of vendor
		 * @returns list of services
		 * @throws Exception Throws exception
		*/	
	 @GetMapping("/services/vendor/{vendorId}")
		public ResponseEntity<List<ServicesDTO>> getAllServicesForVendor(@PathVariable("vendorId") int vendorId) throws Exception {

			List<ServicesDTO> serviceList = servicesService.getAllServicesForVendor(vendorId);
			return new ResponseEntity<List<ServicesDTO>>(serviceList, HttpStatus.OK);

		}

	 // courses for vendors by service
	 /**
		 * Retrieves {@code courseDetails} list of all courseDetails for particular vendor based on service
		 * @param vendorId  Id of vendor
		 * @param serviceId:Id of service
		 * @return CourseDetails List {@code List<CourseDetails>}
		 * @throws Exception Throws exception 
		 */
		@GetMapping("/services/vendor/courses/{vendorId}/{serviceId}")
		public ResponseEntity<List<CourseDetails>> getAllCoursesForVendorByService(@PathVariable("vendorId") int vendorId, @PathVariable("serviceId") int serviceId) throws Exception {

			List<CourseDetails> courseList = servicesService.getAllCoursesForVendorByService(vendorId,serviceId);
			return new ResponseEntity<List<CourseDetails>>(courseList, HttpStatus.OK);

		}
		
		/**
		 * Retrieves {@code VendorCourses} list of all course orders for particular vendor based on service
		 * @param vendorId  Id of Vendor
		 * @param serviceId:Id of service
		 * @return VednorCourses List {@code List<VendorCourses>}
		 * @throws Exception Throws exception
		 */
		@GetMapping("/services/orders/{serviceId}/{vendorId}")
		public ResponseEntity<List<OrdersDTO>> getAllOrdersForVendorByServiceId(@PathVariable("serviceId") int serviceId, @PathVariable("vendorId") int vendorId) throws Exception {

			List<OrdersDTO> orders = servicesService.getAllOrdersForVendorByServiceId(serviceId,vendorId);
			return new ResponseEntity<List<OrdersDTO>>(orders, HttpStatus.OK);

		}
		//user
		/**
		 * Retrieves {@code courseDetails} list of all courseDetails purchased by learner
		 * @param userId  Id of user
		 * @return services List {@code List<ServiesDTO>}
		 * @throws Exception Throws exception
		 */
		@GetMapping("/services/learner/{userId}")
		public ResponseEntity<List<ServicesDTO>> getAllServicesPurchasedByUser(@PathVariable("userId") int userId) throws Exception {

			List<ServicesDTO> serviceList = servicesService.getAllServicesPurchasedByLearner(userId);
			return new ResponseEntity<List<ServicesDTO>>(serviceList, HttpStatus.OK);

		}

		/**
		 * Retrieves {@code Orders} list of all orders for particular user based on service
		 * @param userId  Id of user
		 * @param serviceId:Id of service
		 * @return Orders List {@code List<Orders>}
		 * @throws Exception Throws exception
		 */

		@GetMapping("/services/learner/courses/{userId}/{serviceId}")
		public ResponseEntity<List<Orders>> getAllCoursesForLearnerByService(@PathVariable("userId") int userId, @PathVariable("serviceId") int serviceId) throws Exception {

			List<Orders> courseList = servicesService.getAllCoursesForLearnerByService(userId,serviceId);
			return new ResponseEntity<List<Orders>>(courseList, HttpStatus.OK);

		}






}