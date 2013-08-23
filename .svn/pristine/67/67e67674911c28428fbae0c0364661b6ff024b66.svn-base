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

import com.boventech.gplearn.entity.LearnClass;


public class LearnClassServiceTest extends JunitServiceBase{

    @Autowired
    private LearnClassService learnClassService;
    
    @Test
    public void savaBatch() {
        LearnClass learnClass = new LearnClass();
        learnClass.setAllName("234");
        learnClass.setAreaCode("234");
        learnClass.setCode("123");
        learnClass.setCreateTime(new Date());
        learnClass.setName("123");
        learnClass.setTel("123");
        learnClass.setZipCode("123");
        this.learnClassService.save(learnClass);
    }

    @Test
    public void updateBatch() {
        LearnClass learnClass = this.learnClassService.findById((long) 1);
        this.learnClassService.update(learnClass);
    }

    @Test
    public void deleteBatch() {
        LearnClass learnClass = this.learnClassService.findById((long) 1);
        this.learnClassService.delete(learnClass);
        this.learnClassService.delete(learnClass.getId());
    }
    
    @Test
    public void listAll(){
        this.learnClassService.listAll();
    }
}
