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

package com.boventech.gplearn.dao;

import java.util.List;

import com.boventech.gplearn.entity.Announcement;
import com.boventech.gplearn.entity.User;

public interface AnnouncementDao extends BaseDao<Announcement, Long> {

	List<Announcement> listAll(User user);
	
	List<Announcement> getSystemAnnouncements();

	List<Announcement> listAllWithPagination(User user, Integer page);

	List<Announcement> listNewest();

	List<Announcement> listAllWithPagination(Integer page);
}
