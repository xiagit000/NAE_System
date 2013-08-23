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

import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.LearnClass;


public interface EnrollmentPlanDao extends BaseDao<EnrollmentPlan, Long>{
    
    List<EnrollmentPlan> listAll();
    
    boolean isExistByBatchAndClass(EnrollmentPlan enrollmentPlan);
    
    boolean isExistByBatchAndClassWithoutCurrent(EnrollmentPlan enrollmentPlan);

    boolean isConflictByDate(EnrollmentPlan enrollmentPlan);
    
    EnrollmentPlan findEnrollmentPlanByLearnClass(LearnClass learnClass);

	List<EnrollmentPlan> listWithPagination(Integer page);
}
