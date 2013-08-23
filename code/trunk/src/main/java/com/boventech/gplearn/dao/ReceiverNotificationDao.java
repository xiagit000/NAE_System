package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.ReceiverNotification;
import com.boventech.gplearn.entity.User;

public interface ReceiverNotificationDao extends BaseDao<ReceiverNotification, Long>{
	Integer countNoConsultNotificationByUser(User user);
    
    List<ReceiverNotification> listAllNotificationByUser(User user,Integer page);

	void delete(User user);
}
