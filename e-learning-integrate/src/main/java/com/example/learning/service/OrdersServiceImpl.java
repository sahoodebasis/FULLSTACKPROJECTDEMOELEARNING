package com.example.learning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.exception.ListEmptyException;
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


@Service
public class OrdersServiceImpl implements OrdersService {
	

	@Autowired
	OrdersRepository ordersRepo;
	
	@Autowired 
	UserRepository user;
	
	@Autowired
	CourseDetailsRepository cd;
	
	@Autowired
	ServicesRepository ser;

	@Override
	public List<CourseDetails> getLearnerOrderedCourses(int userid){
		
		List<Orders> order;
		order = ordersRepo.findByUserId(userid);
		if(order.isEmpty()) {
			throw new ListEmptyException();
		}
		//List<Orders> ord = order.stream().collect(Collectors.toList());
		List<CourseDetails> lcd = new ArrayList<CourseDetails>();
		CourseDetails coursedetails;
		for(Orders o : order) {
			 coursedetails = o.getCourse();
			 lcd.add(coursedetails);
		}
		
		return lcd;
	}

	@Override
	public String addOrder(OrderRequestDTO ord)  {
		if(ord==null) {
			throw new ListEmptyException();
		}
		Orders o = new Orders();
		int userid = ord.getUserid();
		int courseid = ord.getCourseid();
		int serviceid=ord.getServiceid();
		User u = user.findById(userid).get();
		CourseDetails coursedetails = cd.findById(courseid).get();
		Services service=ser.findById(serviceid).get();
		Random r = new Random();
		int paymentid=r.nextInt(99999999);
		o.setCourse(coursedetails);
		o.setUser(u);
		o.setService(service);
		o.setPaymentNo(paymentid);
		o.setComplete(false);
		ordersRepo.save(o);
		return "Successfully added to orders with payment number "+paymentid;
		
	}

	@Override
	public List<VendorCourses> getVendorCousesLearnerCount(int userid) {
		
		List<Integer> coursesId = cd.findByVendorId(userid);
		//List<Integer> ord = coursesId.stream().collect(Collectors.toList());
//		List<Orders> allorders=new ArrayList<Orders>();
//		for(Integer i : coursesId) {
//			List<Orders> order=ordersRepo.findByCoursesId(i);
//			for(Orders o : order) {
//				allorders.add(o);
//			}
//		}
		List<VendorCourses> vcfull=new ArrayList<VendorCourses>();
		for(Integer i : coursesId) {
		 vcfull.addAll(ordersRepo.findByVendorCoursesId(i, i));
		}
		return vcfull;
	}

	
	@Override
	public String updateCourseComplete(boolean iscomplete, int courseid, int userid) {
		
		Orders o = ordersRepo.findByCoursesIdandUserId(courseid,userid);
		o.setComplete(iscomplete);
		ordersRepo.save(o);
		return "course progress is updated";
	}
	@Override
	public Orders isCompleteCourse(int courseid, int userid) {
		Orders o = ordersRepo.findByCoursesIdandUserId(courseid,userid);
		return o;
	}

	
	
}






