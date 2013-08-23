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

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.boventech.gplearn.entity.Batch;

/**
 * @author peng.xia
 *
 */
public class BatchServiceTest extends JunitServiceBase{
    
    @Autowired
    private BatchService batchService;
    
    @Test
    public void savaBatch(){
        Batch batch=new Batch();
        batch.setCode("12312313");
        batch.setName("123");
        batch.setBeginTime(new Date());
        batch.setEndTime(new Date());
        this.batchService.save(batch);
    }
    
    @Test
    public void updateBatch(){
        Batch batch=this.batchService.findById((long)20);
        batch.setCode("1111");
        this.batchService.update(batch);
    }
    
    @Test
    public void deleteBatch(){
        Batch batch=this.batchService.findById((long)20);
        this.batchService.delete(batch);
        this.batchService.delete(batch.getId());
    }
    
}
