package com.example.learning.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.learning.model.CourseDetails;
import com.example.learning.service.CourseDetailsServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(controllers = CourseDetailsController.class)
public class CourseServiceControllerTest {
	
	@MockBean
	CourseDetailsServiceImpl courseServiceService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	
	@Test
	public void getAllCourseDetailsListUserTest() throws Exception {
		
		List<CourseDetails> CourseDetailsList = new ArrayList<>();
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		CourseDetails courseDetails2=new CourseDetails(2,"abcd", "abcd", "abcd", 2, true, 2, 2,
				new SimpleDateFormat("dd/mm/yyyy").parse("29/01/1998"), "abcd", "abcd", "abcd", "abcd", "abcd", "abcd", null);
		CourseDetailsList.add(courseDetails1);
		CourseDetailsList.add(courseDetails2);
		when(courseServiceService.getAllCourseDetailsListUser()).thenReturn(CourseDetailsList);
		mockMvc.perform(MockMvcRequestBuilders
                .get("/getallcoursedetailstouser")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].courseId", is(1)))
                .andExpect(jsonPath("$[0].name", is("abc")))
                .andExpect(jsonPath("$[1].courseId", is(2)))
                .andExpect(jsonPath("$[1].name", is("abcd")))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
		//ResponseEntity<List<CourseDetails>> response = new ResponseEntity<List<CourseDetails>>(CourseDetailsList, HttpStatus.OK);
		//assertEquals(courseServiceController.getAllCourseDetailsListUser(), response);
	}

	
	@Test
	public void getCourseDetailsTest() throws Exception {
		
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		when(courseServiceService.getCourseDetails(1)).thenReturn(courseDetails1);
		mockMvc.perform(MockMvcRequestBuilders
                .get("/getcoursedetailstouser/{courseid}",1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.courseId", is(1)))
                .andExpect(jsonPath("$.name", is("abc")))
                .andExpect(status().isOk());
		//ResponseEntity<CourseDetails> response = new ResponseEntity<CourseDetails>(courseDetails1, HttpStatus.OK);
		//assertEquals(courseServiceController.getCourseDetails(1), response);
	}
	
	@Test
	public void getAllCourseDetailsListVendorTest() throws Exception {
		
		List<CourseDetails> CourseDetailsList = new ArrayList<>();
		CourseDetails courseDetails1=new CourseDetails(1,"abc", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		CourseDetails courseDetails2=new CourseDetails(2,"abcd", "abcd", "abcd", 2, true, 1, 2,
				new SimpleDateFormat("dd/mm/yyyy").parse("29/01/1998"), "abcd", "abcd", "abcd", "abcd", "abcd", "abcd", null);
		CourseDetailsList.add(courseDetails1);
		CourseDetailsList.add(courseDetails2);
		when(courseServiceService.getAllCourseDetailsListVendor(1)).thenReturn(CourseDetailsList);
		mockMvc.perform(MockMvcRequestBuilders
                .get("/getallcoursedetailstovendor/{vendorid}",1)
                .contentType(MediaType.APPLICATION_JSON))
		 		.andExpect(jsonPath("$[0].courseId", is(1)))
		 		.andExpect(jsonPath("$[0].name", is("abc")))
		 		.andExpect(jsonPath("$[1].courseId", is(2)))
		 		.andExpect(jsonPath("$[1].name", is("abcd")))
		 		.andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
		//ResponseEntity<List<CourseDetails>> response = new ResponseEntity<List<CourseDetails>>(CourseDetailsList, HttpStatus.OK);
		//assertEquals(courseServiceController.getAllCourseDetailsListVendor(1), response);
	}

	
	@Test
	public void addCourseDetailsTest() throws JsonProcessingException, Exception {
		CourseDetails courseDetails1=new CourseDetails();
		mockMvc.perform(MockMvcRequestBuilders
				.post("/addcourses")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(courseDetails1)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.message", is("Added Successfully and notification sent")));
//		ResponseEntity<Msg> response = new ResponseEntity<Msg>(HttpStatus.OK);
//		assertEquals(courseServiceController.addCourseDetails(courseDetails1).getStatusCodeValue(),
//				response.getStatusCodeValue());
		
	}


	
//	@Test
//	public void removeCourseDetailsTest() throws Exception {
//		
//		mockMvc.perform(MockMvcRequestBuilders
//				.delete("/deletecoursedetails/{courseid}/{vendorid}", 1,1)
//				.contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$.message", is("Deleted Successfully")));
//		ResponseEntity<Msg> response = new ResponseEntity<Msg>(HttpStatus.OK);
//		assertEquals(courseServiceController.removeCourseDetails(1,1).getStatusCodeValue(),
//				response.getStatusCodeValue());
		
//}
	

}

