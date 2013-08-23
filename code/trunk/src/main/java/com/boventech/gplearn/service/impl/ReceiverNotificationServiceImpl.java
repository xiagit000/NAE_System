package com.boventech.gplearn.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.ReceiverNotificationDao;
import com.boventech.gplearn.entity.ReceiverNotification;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.ReceiverNotificationService;

@Service
@Transactional
public class ReceiverNotificationServiceImpl implements
		ReceiverNotificationService {

	@Autowired
	private ReceiverNotificationDao receiverNotificationDao;

	@Override
	public void save(ReceiverNotification t) {
		this.receiverNotificationDao.save(t);
	}

	@Override
	public void delete(ReceiverNotification t) {
		this.receiverNotificationDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		this.receiverNotificationDao.deleteById(id);
	}

	@Override
	public void update(ReceiverNotification t) {
		this.receiverNotificationDao.update(t);
	}

	@Override
	public ReceiverNotification findById(Long id) {
		return this.receiverNotificationDao.findByID(id);
	}

	@Override
	public Integer countNoConsultNotificationByUser(User user) {
		return this.receiverNotificationDao
				.countNoConsultNotificationByUser(user);
	}

	@Override
	public List<ReceiverNotification> listAllNotificationByUser(User user,
			Integer page) {
		return this.receiverNotificationDao.listAllNotificationByUser(user,
				page);
	}

	@Override
	public void save(List<ReceiverNotification> receiverNotifications) {
		this.receiverNotificationDao.save(receiverNotifications);
	}

	@Override
	public void delete(User user) {
		this.receiverNotificationDao.delete(user);
	}

}
