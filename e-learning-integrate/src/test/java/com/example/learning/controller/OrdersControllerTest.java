package com.example.learning.controller;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.OrderRequestDTO;
import com.example.learning.model.VendorCourses;
import com.example.learning.service.OrdersService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = OrdersController.class)
public class OrdersControllerTest {

	@Autowired
	MockMvc mockMvc;
	@MockBean
	OrdersService ordersService;
	@Autowired
	ObjectMapper objectMapper;
	@Test
	void testGetLearnerOrderedCourses() throws Exception {
		List<CourseDetails> courses = new ArrayList<CourseDetails>();
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		CourseDetails courseDetails2=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		courses.addAll(Arrays.asList(courseDetails1,courseDetails2));
		Mockito.when(ordersService.getLearnerOrderedCourses(1)).
		thenReturn(courses);
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/learner/{userId}",1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)));
	}
	@Test
	void testRegister() throws JsonProcessingException, Exception {
		OrderRequestDTO order = new OrderRequestDTO();
		Mockito.when(ordersService.addOrder(order)).thenReturn("Good");
		mockMvc.perform(MockMvcRequestBuilders.post("/orders/order")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(order)))
				.andExpect(MockMvcResultMatchers.status().isOk());
				//.andExpect(MockMvcResultMatchers.jsonPath("$",Matchers.is("Good")));
	}
	@Test
	void testUpdateResource() throws Exception {
		Mockito.when(ordersService.updateCourseComplete(true,1,1)).thenReturn("good");
		mockMvc.perform(MockMvcRequestBuilders.patch("/orders/courseStatus/{courseId}/{userId}",1,1)
				.param("isComplete", "true")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testGetVendorCoursesLearnerCount() throws Exception {
		List<VendorCourses> vc = new ArrayList<VendorCourses>();
		Mockito.when(ordersService.getVendorCousesLearnerCount(1)).thenReturn(vc);
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/vendor/{userId}",1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
