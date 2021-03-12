package com.example.learning.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.learning.model.Notification;
import com.example.learning.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class NotificationRepositoryTest {

	@Autowired
	NotificationRepository notificationRepository;
	@Autowired
	UserRepository userRepo;
	
	@Test
	@Rollback(true)
    public void testNotificationRepositorySave() throws ParseException 
    {
        Notification notification=new Notification(new User("abc1@gmail.com","Debasis","9998821312","abcde123","vendor",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017")),"HI");
        notificationRepository.save(notification);
        assertNotNull(notification.getNotificationId());
        System.out.println(notification.getNotificationId());
    }
	
	@Test
    public void testNotificationRepositoryGetAndDelete() throws ParseException 
    {	
		User user = new User("abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"));
		userRepo.save(user);
		Notification notification1=new Notification(user,"YO");
	    notificationRepository.save(notification1);
    	boolean a=notificationRepository.getNotification(user.getUserId()).isEmpty();
    	notificationRepository.removeNotification(user.getUserId());
        boolean b=notificationRepository.getNotification(user.getUserId()).isEmpty();
        assertFalse(a);
        assertTrue(b);
    }
	
	@Test
    public void testNotificationRepositoryUpdate() throws ParseException 
    {	User user = new User("abc1@gmail.com","Debasis","9998821312","vendor","abcde123",true,new SimpleDateFormat("dd/MM/yyyy").parse("28/01/2017"));
		userRepo.save(user);
		Notification notification1=new Notification(user,"YO");
	    notificationRepository.save(notification1);
	    int i=notification1.getNotificationId();
	    notificationRepository.save(new Notification(i,user,"Hi"));
	   assertEquals(notificationRepository.findById(i).get().getDescription(), "Hi");
    }
	
}
