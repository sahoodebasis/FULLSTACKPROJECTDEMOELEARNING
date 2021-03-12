package com.example.learning.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.learning.exception.ListEmptyException;
import com.example.learning.model.Notification;
import com.example.learning.model.User;
import com.example.learning.repository.NotificationRepository;
import com.example.learning.repository.UserRepository;

//@RunWith(MockitoJUnitRunner.class)

@SpringBootTest
public class NotificationServiceImplTest {

	@InjectMocks
	NotificationServiceImpl notificationService;
	
	
	@Mock
    NotificationRepository notificationRepository;
	
	@Mock
	UserRepository userRepo;
	
	@Test
    public void testgetAllNotificationByUserId() throws ParseException
    {
		Notification notification1=new Notification(new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true),"ABC1");
		Notification notification2=new Notification(new User(1,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true),"ABC1");
		Notification notification3=new Notification(new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true),"ABC2");
		
		List<Notification> notifications=new ArrayList<Notification>();
		notifications.add(notification1);
		notifications.add(notification2);
		notifications.add(notification3);
		
        when(notificationRepository.getNotification(2)).thenReturn(notifications);
      
        List<Notification> userNotification=notificationService.getAllNotificationByUserId(notification1.getUser().getUserId());         
        assertEquals(3,userNotification.size());  
    }
	
	@Test
	public void testgetAllNotificationByUserIdException() {
		assertThrows(ListEmptyException.class,()->notificationService.getAllNotificationByUserId(2));
	}
	
	@Test
    public void deleteAllNotificationByUserId() throws ParseException
    {
		Notification notification1=new Notification(new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true),"ABC1");
		Notification notification2=new Notification(new User(1,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true),"ABC1");
		Notification notification3=new Notification(new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true),"ABC2");
		
		List<Notification> notifications=new ArrayList<Notification>();
		notifications.add(notification1);
		notifications.add(notification2);
		notifications.add(notification3);
		
       // when(notificationRepository.removeNotification(2)).thenReturn("Successfully Removed");
      
        String notificationDeleted=notificationService.deleteAllNotificationByUserId(2);         
        assertEquals(notificationDeleted,"Notification Cleared");  
    }
	
	@Test
    public void addNotification() throws ParseException
    {
       // when(notificationRepository.removeNotification(2)).thenReturn("Successfully Removed");
		List<User> users = new ArrayList<User>();
		User user = new User(2,"abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"),true);
		users.add(user);
		when(userRepo.findByHasSubscribed(true)).thenReturn(users);
        String notificationAdded=notificationService.addNotification("MachineLearning-Dummy");         
        assertEquals(notificationAdded,"notification sent to all users");  
    }
	
}
