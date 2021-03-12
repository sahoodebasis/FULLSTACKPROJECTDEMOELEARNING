package com.example.learning.repository;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.Orders;
import com.example.learning.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class OrdersRepositoryTest {

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	CourseDetailsRepository cdRepo;
	
	@Autowired
	OrdersRepository orderRepo;
	
	@Autowired
	ServicesRepository serviceRepo;
	
	@Test
	void testAddOrders() throws Exception {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		userRepo.save(user1);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		cdRepo.save(courseDetails1);
		User u = userRepo.findById(user1.getUserId()).get();
		CourseDetails courseDetails2 = cdRepo.findById(courseDetails1.getCourseId()).get();
		Orders order = new Orders(110,u,courseDetails2,10101,false, null);
		Orders ordersave = orderRepo.save(order);
		assertNotNull(ordersave);
	}
	
	@Test
	void testGetOrders() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		userRepo.save(user1);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		cdRepo.save(courseDetails1);
		User u = userRepo.findById(user1.getUserId()).get();
		CourseDetails courseDetails2 = cdRepo.findById(courseDetails1.getCourseId()).get();
		Orders order = new Orders(110,u,courseDetails2,10101,false, null);
		Orders orderSave = orderRepo.save(order);
		Orders orderget = orderRepo.findById(orderSave.getOrderId()).get();
		assertThat(orderget).isNotNull();
	}
	
	@Test
	void NottestGetOrders() {
		Orders orderget = orderRepo.findById(50).orElse(null);
		assertNull(orderget);
	}
	
	
	@Test
	void testGetAllOrders() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		userRepo.save(user1);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		cdRepo.save(courseDetails1);
		User u = userRepo.findById(user1.getUserId()).get();
		CourseDetails courseDetails2 = cdRepo.findById(courseDetails1.getCourseId()).get();
		Orders order = new Orders(110,u,courseDetails2,10101,false, null);
		orderRepo.save(order);
		Iterable<Orders> ordergetAll = orderRepo.findAll();
		assertThat(ordergetAll).size().isGreaterThan(0);
	}
	
	@Test
	void testGetCourseByUserId() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		userRepo.save(user1);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		cdRepo.save(courseDetails1);
		Orders order = new Orders(110,user1,courseDetails1,10101,false, null);
		orderRepo.save(order);
		List<Orders> orderget = orderRepo.findByUserId(user1.getUserId());
		assertThat(orderget).isNotNull();
	}
	
	@Test
	void NottestGetCourseByUserId() {
		List<Orders> orderget = orderRepo.findByUserId(200);
		assertEquals(orderget.isEmpty(),true);
	}
	
	@Test
	void testGetOrderByCourseId() throws ParseException {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		userRepo.save(user1);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		cdRepo.save(courseDetails1);
		Orders order = new Orders(110,user1,courseDetails1,10101,false, null);
		orderRepo.save(order);
		List<Orders> orderget = orderRepo.findByCoursesId(courseDetails1.getCourseId());
		assertThat(orderget).isNotNull();
	}
	
	@Test
	void NottestGetOrderByCourseId() {
		List<Orders> orderget = orderRepo.findByCoursesId(100);
		assertEquals(orderget.isEmpty(),true);
	}
	
	@Test
	void updateOrders() throws Exception {
		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		userRepo.save(user1);
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		cdRepo.save(courseDetails1);
		Orders order = new Orders(110,user1,courseDetails1,10101,false, null);
		Orders savedOrder = orderRepo.save(order);
		Orders orderget = orderRepo.findById(savedOrder.getOrderId()).get();
		orderget.setComplete(true);
		orderRepo.save(orderget);
		assertThat(orderget).isNotNull();
		
	}
	
//	@Test
//	void findByVendorCoursesId() throws ParseException {
//		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
//				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc",null);
//		cdRepo.save(courseDetails1);
//		User user1 = new User("testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
//		userRepo.save(user1);
//		Orders order = new Orders(110,user1,courseDetails1,10101,false);
//		orderRepo.save(order);
//		List<VendorCourses> vc = orderRepo.findByVendorCoursesId(courseDetails1.getCourseId(), courseDetails1.getCourseId());
//		assertThat(vc).isNotNull();
//	}
//	
//	@Test
//	void NotfindByVendorCoursesId() {
//		List<VendorCourses> vc = orderRepo.findByVendorCoursesId(700, 700);
//		assertEquals(vc.isEmpty(),true);
//	}
	
	
}
