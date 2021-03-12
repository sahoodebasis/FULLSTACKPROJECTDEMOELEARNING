package com.example.learning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.learning.model.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>{

	@Query(value="select * from notification_table where user_id=?1",nativeQuery = true)
	List<Notification> getNotification(int userId);
	
	@Modifying
	@Query(value="delete from notification_table where user_id=?1",nativeQuery = true)
	void removeNotification(int userId);
	
}
