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

package com.boventech.gplearn.service;

import java.util.List;

import com.boventech.gplearn.entity.Announcement;
import com.boventech.gplearn.entity.User;

public interface AnnouncementService extends BaseService<Announcement, Long> {


	List<Announcement> listAll(User user);
	
	List<Announcement> getSystemAnnouncements();

	List<Announcement> listAllNewestFirstNine(User user);

	void saveAnnouncement(String fileName, User user, Announcement announcement);

	List<Announcement> listAllWithPagination(User user, Integer page);

	List<Announcement> listNewest();

	List<Announcement> listAllWithPagination(Integer page);
}