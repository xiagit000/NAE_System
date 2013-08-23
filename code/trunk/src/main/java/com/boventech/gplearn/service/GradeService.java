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

import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.User;


public interface GradeService extends BaseService<Grade, Long>{
    List<Grade> listAllWithPagnate(Integer page); 
    
    Grade findByUser(User user);
    
    List<Grade> generateGrades(List<User> users, EnrollmentPlan enrollmentPlan);
    
    void save(List<Grade> grades);

	List<Grade> listWithPaginationByLearnClassId(Long id, Integer page);

    List<Grade> search(Integer page,Long batchId, Long learnClassId);

    List<Grade> search(Long batchId, Long learnClassId);
    
    List<Grade> findByUsers(List<User> users);
}
