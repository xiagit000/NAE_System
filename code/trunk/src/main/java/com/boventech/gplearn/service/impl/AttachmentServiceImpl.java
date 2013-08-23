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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.AttachmentDao;
import com.boventech.gplearn.entity.Attachment;
import com.boventech.gplearn.service.AttachmentService;

@Service
@Transactional
public class AttachmentServiceImpl implements AttachmentService{

    @Autowired
    private AttachmentDao attachmentDao;
    
    @Override
    public void save(Attachment t) {
        attachmentDao.save(t);
        
    }

    @Override
    public void delete(Attachment t) {
        attachmentDao.delete(t);
        
    }

    @Override
    public void delete(Long id) {
        attachmentDao.deleteById(id);
        
    }

    @Override
    public void update(Attachment t) {
        attachmentDao.update(t);
        
    }

    @Override
    public Attachment findById(Long id) {
        return attachmentDao.findByID(id);
    }

	@Override
	public Attachment findByfileName(String fileName) {
		return attachmentDao.findByfileName(fileName);
	}

}
