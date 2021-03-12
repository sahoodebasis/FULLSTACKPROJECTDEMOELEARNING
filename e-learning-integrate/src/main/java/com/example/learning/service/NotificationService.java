package com.example.learning.service;

import java.util.List;

import com.example.learning.model.Notification;

public interface NotificationService {

	List<Notification> getAllNotificationByUserId(int userId);
	String deleteAllNotificationByUserId(int userId);
	String addNotification(String courseName);
	
}
