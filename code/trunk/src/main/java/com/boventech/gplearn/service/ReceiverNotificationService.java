package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.ReceiverNotification;
import com.boventech.gplearn.entity.User;

public interface ReceiverNotificationService extends
		BaseService<ReceiverNotification, Long> {
	Integer countNoConsultNotificationByUser(User user);

	List<ReceiverNotification> listAllNotificationByUser(User user, Integer page);
	
	void save(List<ReceiverNotification> receiverNotifications);

	void delete(User user);
}
