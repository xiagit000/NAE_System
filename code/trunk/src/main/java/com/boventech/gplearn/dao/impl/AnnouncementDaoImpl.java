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

package com.boventech.gplearn.dao.impl;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.boventech.gplearn.dao.AnnouncementDao;
import com.boventech.gplearn.entity.Announcement;
import com.boventech.gplearn.entity.User;

@Repository
public class AnnouncementDaoImpl extends BaseDaoImpl<Announcement, Long> implements AnnouncementDao {


    @Override
    public List<Announcement> listAll(User user) {
        String queryString = "FROM Announcement an WHERE an.user=? ORDER BY an.id DESC";
        return executeQueryWithoutPaging(queryString, user);
    }


	@Override
	public List<Announcement> getSystemAnnouncements() {
		String queryString = "FROM Announcement a WHERE a.user.userType = 'System_Administrator'";
		return executeQueryWithoutPaging(queryString);
	}


	@Override
	public List<Announcement> listAllWithPagination(User user, Integer page) {
		String queryString = "FROM Announcement a WHERE a.user=?1";
		return executeQueryWithPagination(queryString, " ORDER BY a.id DESC", page,user);
	}


	@Override
	public List<Announcement> listNewest() {
		String queryString = "FROM Announcement a";
		return executeQueryWithPagination(queryString, " ORDER BY a.time DESC", null);
	}


	@Override
	public List<Announcement> listAllWithPagination(Integer page) {
		String queryString = "FROM Announcement a";
		return executeQueryWithPagination(queryString, " ORDER BY a.time DESC", page);
	}

}