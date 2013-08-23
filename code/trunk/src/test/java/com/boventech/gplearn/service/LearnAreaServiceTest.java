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

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.boventech.gplearn.entity.LearnArea;

public class LearnAreaServiceTest extends JunitServiceBase{
    
    @Autowired
    private LearnAreaService learnAreaService;

    @Test
    public void savaLearnArea() {
        LearnArea learnArea = new LearnArea();
        learnArea.setCode("12312313");
        learnArea.setAddress("123123");
        learnArea.setEmail("123123");
        learnArea.setElCode("123213");
        learnArea.setName("123");
        learnArea.setPersonIncharge("123123");
        learnArea.setStatus(true);
        learnArea.setTel("123213");
        learnArea.setZipCode("234234");
        this.learnAreaService.save(learnArea);
    }

    @Test
    public void updateLearnArea() {
        LearnArea learnArea = this.learnAreaService.findById((long)1);
        learnArea.setCode("1111");
        this.learnAreaService.update(learnArea);
    }

    @Test
    public void deleteLearnArea() {
        LearnArea learnArea = this.learnAreaService.findById((long)1);
        this.learnAreaService.delete(learnArea);
        this.learnAreaService.delete(learnArea.getId());
    }
}
