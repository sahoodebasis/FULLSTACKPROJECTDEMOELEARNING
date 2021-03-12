package com.example.learning.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.learning.model.ReviewDTO;
import com.example.learning.model.ReviewDTOinterface;
import com.example.learning.service.ReviewServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = ReviewController.class)
public class ReviewControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ReviewServiceImpl reviewService;

	@Test
	public void checkAddReview() throws Exception {
		ReviewDTO reviewDTO = new ReviewDTO(4, 4, "We can get idea in every field through this book");
		Mockito.when(reviewService.addReview(reviewDTO)).thenReturn("Added Review Successfully");

		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(reviewDTO);
		mockMvc.perform(MockMvcRequestBuilders.post("/addReview").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	
	  @Test void testgetAllReviewByCourseId() throws Exception{
	  
	  ReviewDTO reviewDTO1= null;
	  ReviewDTO reviewDTO2 = null;
	  List<ReviewDTOinterface> reviewDTO=new ArrayList<ReviewDTOinterface>();
	  reviewDTO.add((ReviewDTOinterface) reviewDTO1);
	  reviewDTO.add((ReviewDTOinterface) reviewDTO2);
	  
	  
	  when(reviewService.getAllReviewByCourseId(4)).thenReturn(reviewDTO);
	  
	  mockMvc.perform(MockMvcRequestBuilders .get("/getReviews/{courseId}", 4)
	  .contentType(MediaType.APPLICATION_JSON)) .andExpect(MockMvcResultMatchers.status().isOk()); }
	 

}
