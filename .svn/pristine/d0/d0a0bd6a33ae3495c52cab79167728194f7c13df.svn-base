package com.boventech.gplearn.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.gplearn.dao.ReceiverNotificationDao;
import com.boventech.gplearn.entity.ReceiverNotification;
import com.boventech.gplearn.entity.User;

@Repository
public class ReceiverNotificationDaoImpl extends BaseDaoImpl<ReceiverNotification, Long> implements ReceiverNotificationDao{

	@Override
	public Integer countNoConsultNotificationByUser(User user) {
		String queryString="from ReceiverNotification r where r.consult=0 and r.receiver=?1";
		return executeQueryWithoutPaging(queryString, user).size();
	}

	@Override
	public List<ReceiverNotification> listAllNotificationByUser(User user,Integer page) {
		String queryString="from ReceiverNotification r where r.receiver=?1";
		return executeQueryWithPagination(queryString, null, page, user);
	}

	@Override
	public void delete(User user) {
		String queryString = "DELETE FROM ReceiverNotification r WHERE r.receiver=?1";
		executeUpdateOrDelete(queryString, user);
	}
}
