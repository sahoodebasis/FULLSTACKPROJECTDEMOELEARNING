package com.example.learning.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.learning.model.Services;
import com.example.learning.service.ServicesServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = ServicesController.class)
public class ServicesControllerTest {
	@InjectMocks
	ServicesController servicesController;
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	ObjectMapper objectMapper;
	@MockBean
	ServicesServiceImpl servicesService;
	
	@Test
	void testGetAllServices() throws Exception {
		List<Services> cd = new ArrayList<Services>();
		when(servicesService.getAllServices()).thenReturn(cd);
		mockMvc.perform(MockMvcRequestBuilders.get("/services")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testRegister() throws JsonProcessingException, Exception {
		Services service = new Services(1,"Online Training",true);
		mockMvc.perform(MockMvcRequestBuilders.post("/services/service")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(service)))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testUpdateResource() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.patch("/services/Active/{serviceId}",1)
				.contentType(MediaType.APPLICATION_JSON)
				.param("isActive", "true"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testGetAllServicesForVendor() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/services/vendor/{vendorId}",1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testGetAllCoursesForVendorByService() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/services/vendor/courses/{vendorId}/{serviceId}",1,1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testGetAllOrdersForVendorByServiceId() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/services/orders/{serviceId}/{vendorId}",1,1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testGetAllServicesPurchasedByUser() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/services/learner/{userId}",1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	@Test
	void testGetAllCoursesForLearnerByService() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/services/learner/courses/{userId}/{serviceId}",1,1)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
