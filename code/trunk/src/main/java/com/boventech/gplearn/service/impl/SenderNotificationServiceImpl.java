package com.boventech.gplearn.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.ReceiverNotificationDao;
import com.boventech.gplearn.dao.SenderNotificationDao;
import com.boventech.gplearn.entity.ReceiverNotification;
import com.boventech.gplearn.entity.SenderNotification;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.SenderNotificationService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class SenderNotificationServiceImpl implements SenderNotificationService {

	@Autowired
	private SenderNotificationDao senderNotificationDao;
	
	
	@Autowired
	private ReceiverNotificationDao receiverNotificationDao;

	@Override
	public void save(SenderNotification t) {
		this.senderNotificationDao.save(t);
	}

	@Override
	public void delete(SenderNotification t) {
		this.senderNotificationDao.delete(t);
	}

	@Override
	public void delete(Long id) {
		this.senderNotificationDao.deleteById(id);
	}

	@Override
	public void update(SenderNotification t) {
		this.senderNotificationDao.update(t);
	}

	@Override
	public SenderNotification findById(Long id) {
		return this.senderNotificationDao.findByID(id);
	}

	@Override
	public void sendNotification(SenderNotification senderNotification) {
		List<ReceiverNotification> receiverNotifications = getReceiverNotifications(senderNotification);
		try {
            this.senderNotificationDao.save(senderNotification);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		this.receiverNotificationDao.save(receiverNotifications);

	}
	
	private List<ReceiverNotification> getReceiverNotifications(SenderNotification senderNotification) {
		List<ReceiverNotification> receiverNotifications=Lists.newArrayList();
		for (User receiver : senderNotification.getReceivers()) {
			ReceiverNotification receiverNotification = new ReceiverNotification();
			receiverNotification.setConsult(false);
			receiverNotification.setDetails(senderNotification.getDetails());
			receiverNotification.setMessage(senderNotification.getMessage());
			receiverNotification.setSender(senderNotification.getSender());
			receiverNotification.setReceiver(receiver);
			receiverNotification.setTime(new Date());
			receiverNotifications.add(receiverNotification);
		}
		return receiverNotifications;
	}

	@Override
	public List<SenderNotification> listAllNotificationByUser(User user,
			Integer page) {
		return this.senderNotificationDao.listAllNotificationByUser(user, page);
	}

	@Override
	public void delete(User user) {
		this.senderNotificationDao.delete(user);
	}

	@Override
	public void deleteByRecervers(User user) {
		List<SenderNotification> list=this.senderNotificationDao.listAll();
		Iterator<SenderNotification> iterater=list.iterator();
		while(iterater.hasNext()){
			SenderNotification sn = iterater.next();
			Set<User> receivers= sn.getReceivers();
			Iterator<User> users=receivers.iterator();
			while(users.hasNext()){
				User u = users.next();
				if(u.getId()==user.getId()){
					receivers.remove(u);
					sn.setReceivers(receivers);
					senderNotificationDao.update(sn);
				}
			}
			
		}
	}

}
