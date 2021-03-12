package com.example.learning.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;

public class OrdersTest {

	Orders o = new Orders();
	CourseDetails cd = new CourseDetails();
	User u = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new Date(22-10-1998), false);
	Services service = new Services(1,"abc",true);
	Orders o1 = new Orders(1,u,cd,123,false,service);
	@Test
	public void testOrders() {
		o.setOrderId(1);
		o.setPaymentNo(123);
		o.setUser(u);
		o.setCourse(cd);
		o.setComplete(false);
		o.setService(service);
		assertEquals(o.getOrderId(),1);
		assertEquals(o.getPaymentNo(), 123);
		assertEquals(o.getUser(), u);
		assertEquals(o.getCourse(),cd);
		assertEquals(o.isComplete(), false);
		assertEquals(o.getService(),service);
	}
}
