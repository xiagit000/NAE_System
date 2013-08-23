package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.SenderNotification;
import com.boventech.gplearn.entity.User;

public interface SenderNotificationService extends
		BaseService<SenderNotification, Long> {
	void sendNotification(SenderNotification senderNotification);
	
	List<SenderNotification> listAllNotificationByUser(User user, Integer page);

	void delete(User user);

	void deleteByRecervers(User user);
}
