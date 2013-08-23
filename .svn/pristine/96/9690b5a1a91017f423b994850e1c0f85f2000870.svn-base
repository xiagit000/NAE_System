/*
 * Copyright 2010. 
 * 
 * This document may not be reproduced, distributed or used 
 * in any manner whatsoever without the expressed written 
 * permission of Boventech Corp. 
 * 
 * $Rev: Rev $
 * $Author: Author $
 * $LastChangedDate: LastChangedDate $
 *
 */

package com.boventech.gplearn.service.impl;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.AnnouncementDao;
import com.boventech.gplearn.entity.Announcement;
import com.boventech.gplearn.entity.Attachment;
import com.boventech.gplearn.entity.Constants;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.service.AnnouncementService;
import com.boventech.gplearn.service.AttachmentService;
import com.google.common.collect.Lists;

@Service
@Transactional
public class AnnouncementServiceImpl implements AnnouncementService {

    @Autowired
    private AnnouncementDao announcementDao;
    
    @Autowired
    private AttachmentService attachmentService;

    @Override
    public void save(Announcement t) {
        announcementDao.save(t);
    }

    @Override
    public void delete(Announcement t) {
        announcementDao.delete(t);

    }

    @Override
    public void delete(Long id) {
        announcementDao.deleteById(id);

    }

    @Override
    public void update(Announcement t) {
        announcementDao.update(t);

    }

    @Override
    public Announcement findById(Long id) {
        return announcementDao.findByID(id);
    }


    @Override
    public List<Announcement> listAll(User user) {
        List<Announcement> list = announcementDao.listAll(user);
        return list;
    }


	@Override
	public List<Announcement> getSystemAnnouncements() {
		return this.announcementDao.getSystemAnnouncements();
	}

	@Override
	public List<Announcement> listAllNewestFirstNine(User user) {
		List<Announcement> list = listAll(user);
		List<Announcement> newEstFirstFive=Lists.newArrayList();
		if(list.size()>=9){
			for(int i=0;i<9;i++){
				newEstFirstFive.add(list.get(i));
			}
		}
		else{
			newEstFirstFive=list;
		}
		return newEstFirstFive;
	}

	@Override
	public void saveAnnouncement(String fileName, User user, Announcement announcement) {
		if(fileName!=null){
			Attachment attachment = new Attachment();
			attachment.setFileName(fileName);
			attachment.setFilePath(File.separator+Constants.DEFAULT_UPLOAD_PATH+File.separator+fileName);
			attachmentService.update(attachment);
			Attachment savedAttachment = attachmentService.findByfileName(fileName);
			announcement.setAttachment(savedAttachment);
		}
		announcement.setTime(new Date());
		announcement.setUser(user);
		save(announcement);
	}

	@Override
	public List<Announcement> listAllWithPagination(User user, Integer page) {
		return announcementDao.listAllWithPagination(user, page);
	}

	@Override
	public List<Announcement> listNewest() {
		return announcementDao.listNewest();
	}

	@Override
	public List<Announcement> listAllWithPagination(Integer page) {
		return announcementDao.listAllWithPagination(page);
	}

}
