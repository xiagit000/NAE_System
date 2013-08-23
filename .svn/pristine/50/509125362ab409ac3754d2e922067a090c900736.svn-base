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

import com.boventech.gplearn.dao.AttachmentDao;
import com.boventech.gplearn.entity.Attachment;

@Repository
public class AttachmentDaoImpl extends BaseDaoImpl<Attachment, Long> implements AttachmentDao{

	@Override
	public Attachment findByfileName(String fileName) {
		String queryString  ="FROM Attachment a WHERE a.fileName=?1";
		List<Attachment> list =executeQueryWithoutPaging(queryString, fileName); 
		return list.isEmpty()?null:list.get(0);
	}

}
