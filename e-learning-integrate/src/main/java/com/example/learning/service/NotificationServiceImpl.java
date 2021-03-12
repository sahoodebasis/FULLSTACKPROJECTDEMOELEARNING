package com.example.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.learning.exception.ListEmptyException;
import com.example.learning.model.Notification;
import com.example.learning.model.User;
import com.example.learning.repository.NotificationRepository;
import com.example.learning.repository.UserRepository;

@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
   	NotificationRepository notificationRepository;
	
	@Autowired
   	UserRepository userRepository;

	@Override
	public List<Notification> getAllNotificationByUserId(int userId) {
		List<Notification> userNotification=notificationRepository.getNotification(userId);
		if(userNotification.isEmpty())
		{
			throw new ListEmptyException();
		}
		else {
		return userNotification;
		}
	}

	@Override
	@Transactional
	public String deleteAllNotificationByUserId(int userId) {
		notificationRepository.removeNotification(userId);
		return "Notification Cleared";
	}

	@Override
	public String addNotification(String courseName) {
		List<User> users=userRepository.findByHasSubscribed(true);
//		List<User> user=new ArrayList<User>();
//		user.add(new User());
//		userIds.add(2);
//		userIds.add(3);
		for(User user:users) {
			Notification notif=new Notification(user,courseName);
			notificationRepository.save(notif);
		}
		return "notification sent to all users";
	}
	
	
	
	
	
}
