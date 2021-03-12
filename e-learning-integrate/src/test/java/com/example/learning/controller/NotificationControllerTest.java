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

import com.example.learning.model.Notification;
import com.example.learning.model.User;
import com.example.learning.service.NotificationService;

@WebMvcTest(controllers = NotificationController.class)
public class NotificationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	NotificationService notificationService;
	
	@Test
    void testGetAllNotificationByUserId() throws Exception{
		//User(Integer, String, String, String, String, String, Boolean, Date, Boolean)
		User user1=new User(1,"abc@gmail.com","Sandeep","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true);
		User user2=new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true);
		Notification notification1=new Notification(user1,"ABC1");
		Notification notification2=new Notification(user2,"ABC2");
		
		List<Notification> notifications=new ArrayList<Notification>();
		notifications.add(notification1);
		notifications.add(notification2);
		
        when(notificationService.getAllNotificationByUserId(2)).thenReturn(notifications);
 
        mockMvc.perform(MockMvcRequestBuilders
                .get("/getnot/{id}", 2)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].user.userId", is(1)))
                .andExpect(jsonPath("$[0].description", is("ABC1")))
                .andExpect(jsonPath("$[1].user.userId", is(2)))
                .andExpect(jsonPath("$[1].description", is("ABC2")))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(status().isOk());
    }
	
	@Test
    void testDeleteNotification() throws Exception{
 
        when(notificationService.deleteAllNotificationByUserId(1)).thenReturn("Notification Cleared");
 
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/deletenot/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
	
}
