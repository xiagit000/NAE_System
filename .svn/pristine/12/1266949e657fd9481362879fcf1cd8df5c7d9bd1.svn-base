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

import com.boventech.gplearn.entity.EnrollmentPlan;

public class EnrollmentPlanServiceTest extends JunitServiceBase {

    @Autowired
    private EnrollmentPlanService enrollmentPlanService;

    @Test
    public void sava() {
        EnrollmentPlan enrollmentPlan = new EnrollmentPlan();
        enrollmentPlan.setDescription("123");
        enrollmentPlan.setExpense(12);
        this.enrollmentPlanService.save(enrollmentPlan);
    }

    @Test
    public void update() {
        EnrollmentPlan enrollmentPlan = this.enrollmentPlanService.findById((long) 2);
        enrollmentPlan.setDescription("123");
        this.enrollmentPlanService.update(enrollmentPlan);
    }

    @Test
    public void delete() {
        EnrollmentPlan enrollmentPlan = this.enrollmentPlanService.findById((long) 2);
        this.enrollmentPlanService.delete(enrollmentPlan);
        this.enrollmentPlanService.delete(enrollmentPlan.getId());
    }
}
