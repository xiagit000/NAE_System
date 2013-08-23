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

import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.Graduate;

public interface GraduateService extends BaseService<Graduate, Long> {

    List<Graduate> listAllWithPagenate(Integer page);
    
    Graduate findByGrade(Grade grade);
    
    List<Graduate> generateGraduates(List<Grade> grades);
    
    void save(List<Graduate> graduates);

    void updateAllStatus();
    
    List<Graduate> search(Integer page,Long batchId, Long learnClassId);

    List<Graduate> search(Long batchId, Long learnClassId);

}
