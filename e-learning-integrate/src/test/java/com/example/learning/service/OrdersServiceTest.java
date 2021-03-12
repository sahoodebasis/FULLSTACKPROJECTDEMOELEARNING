package com.example.learning.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.OrderRequestDTO;
import com.example.learning.model.Orders;
import com.example.learning.model.Services;
import com.example.learning.model.User;
import com.example.learning.model.VendorCourses;
import com.example.learning.repository.CourseDetailsRepository;
import com.example.learning.repository.OrdersRepository;
import com.example.learning.repository.ServicesRepository;
import com.example.learning.repository.UserRepository;

@SpringBootTest
public class OrdersServiceTest {

	@InjectMocks
	OrdersServiceImpl orderService;
	
	@Mock
	OrdersRepository orderRepo;
	
	@Mock
	UserRepository userRepo;
	
	@Mock
	CourseDetailsRepository courseRepo;
	
	@Mock
	ServicesRepository serviceRepo;
	
	@Test
	public void getLearnerOrderedCoursesTest() throws Exception{
		User user2 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),false);
		CourseDetails courseDetails=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		List<Orders> o=new ArrayList<Orders>();;
		Orders order = new Orders(101,user2,courseDetails,10101,false, null);
		o.add(order);
		when(orderRepo.findByUserId(1)).thenReturn(o);
		List<CourseDetails> lcd = new ArrayList<CourseDetails>();
		CourseDetails course=order.getCourse();
			 lcd.add(course);
		
		Optional<Orders> data = Optional.of(order);
		when(orderRepo.findById(101)).thenReturn(data);
		
		assertEquals(orderService.getLearnerOrderedCourses(1),lcd);
	}
	
	@Test
	public void getLearnerOrderedCoursesTestException() throws Exception{
		User user2 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),false);
		CourseDetails courseDetails=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		List<Orders> o=new ArrayList<Orders>();;
		Orders order = new Orders(101,user2,courseDetails,10101,false, null);
		o.add(order);
		when(orderRepo.findByUserId(3)).thenReturn(o);
		List<CourseDetails> lcd = new ArrayList<CourseDetails>();
		CourseDetails course=order.getCourse();
			 lcd.add(course);
		
		Optional<Orders> data = Optional.of(order);
		when(orderRepo.findById(101)).thenReturn(data);
		
		assertThrows(Exception.class,()->orderService.getLearnerOrderedCourses(1));
		
	}
	
	@Test
	public void addOrderTest() throws Exception {
	
		User user2 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),false);
		Services service = new Services(1,"abc",true);
		CourseDetails courseDetails=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
//		Orders order = new Orders(101,user2,courseDetails,10101,false);
		
		OrderRequestDTO orderDTO = new OrderRequestDTO(1,1, 1);
		
		Optional<User> datauser = Optional.of(user2);
		Optional<CourseDetails> datacourse = Optional.of(courseDetails);
		Optional<Services> ser = Optional.of(service);
//		int cid=orderDTO.getCourseid();
//		int uid=orderDTO.getUserid();	
		when(userRepo.findById(1)).thenReturn(datauser);	
		when(courseRepo.findById(1)).thenReturn(datacourse);
		when(serviceRepo.findById(1)).thenReturn(ser);
//		Optional<Orders> data = Optional.of(order);
//		when(orderRepo.findById(101)).thenReturn(data);
		
		assertThat(orderService.addOrder(orderDTO)).contains("Successfully added to orders with payment number");
		
		
		
	}
//	
	@Test
	public void addOrderTestException() throws Exception {
	
		User user2 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),false);
		CourseDetails courseDetails=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		//Orders order = new Orders(101,user2,courseDetails,10101,false);
		
		Optional<User> datauser = Optional.of(user2);
		Optional<CourseDetails> datacourse = Optional.of(courseDetails);
		
		when(userRepo.findById(1)).thenReturn(datauser);	
		when(courseRepo.findById(1)).thenReturn(datacourse);
//		Optional<Orders> data = Optional.of(order);
//		when(orderRepo.findById(101)).thenReturn(data);
		
		assertThrows(Exception.class,()->orderService.addOrder(null));
		
	}
	
	@Test
	public void getAllVendorCoursesbyCourseIdTest() throws Exception {
		
		//User user2 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"));
		//CourseDetails courseDetails=new CourseDetails(1,"abc1", "abc", "abc", 1, true, 1, 1,
		//		new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), 1, "abc", "abc", "abc", "abc", "abc", "abc");
//		Orders order = new Orders(101,user2,courseDetails,10101,false);
		VendorCourses vc1 =null;
		List<Integer> courseid = new ArrayList<Integer>();
		courseid.add(1);
		when(courseRepo.findByVendorId(1)).thenReturn(courseid);
		List<VendorCourses> vc=new ArrayList<VendorCourses>();
		vc.add(vc1);
		when(orderRepo.findByVendorCoursesId(1, 1)).thenReturn(vc);
		
		assertEquals(orderService.getVendorCousesLearnerCount(1),vc);
	}
	
	@Test
	public void updateCourseCompleteTest() throws Exception {
		
		User user2 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"),false);
		CourseDetails courseDetails=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		Orders order = new Orders(1,user2,courseDetails,10101,false, null);

		when(orderRepo.findByCoursesIdandUserId(1,1)).thenReturn(order);
		
		assertEquals(orderService.updateCourseComplete(true, 1,1),"course progress is updated");
	}
	
}
