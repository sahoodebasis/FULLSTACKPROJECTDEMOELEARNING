package com.example.learning.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.learning.model.CourseDetails;
import com.example.learning.model.ReviewDTO;
import com.example.learning.model.ReviewDTOinterface;
import com.example.learning.model.User;
import com.example.learning.repository.CourseDetailsRepository;
import com.example.learning.repository.ReviewRepository;
import com.example.learning.repository.UserRepository;


@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepo;

    @InjectMocks
    private ReviewServiceImpl reviewService;


	@Mock
	UserRepository userRepo;
	
	@Mock
	CourseDetailsRepository courseRepo;
	
    
    @Test
	void testgetAllReviewByCourseIdExist() {
		List<ReviewDTOinterface> list = new ArrayList<ReviewDTOinterface>();
		when(reviewRepo.getAllReviewByCourseId(1)).thenReturn(list);
		assertEquals(reviewService.getAllReviewByCourseId(1),list);
	}
    
    @Test
    public void testaddReview() throws ParseException {
    	
		
    	ReviewDTO reviewDTO=new ReviewDTO(1,1,"It was nice");
    	
    	CourseDetails courseDetails=new CourseDetails(1,"abc1", "abc", "abc", 1, true, 1, 1,
				new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), "abc", "abc", "abc", "abc", "abc", "abc", null);
		Optional<CourseDetails> datacourse = Optional.of(courseDetails);
		when(courseRepo.findById(1)).thenReturn(datacourse);
		
		User user1 = new User(1,"testing@tester.com","Test","9425302456","testing","admin",true,new SimpleDateFormat("dd/mm/yyyy").parse("28/01/1998"), null);
    	Optional<User> datauser = Optional.of(user1);
    	when(userRepo.findById(1)).thenReturn(datauser);	
    	
		assertEquals(reviewService.addReview(reviewDTO),"Added Review Successfully");

        
    }
      
}