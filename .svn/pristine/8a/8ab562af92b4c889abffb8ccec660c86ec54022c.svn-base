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

import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.Graduate;

public interface GraduateDao extends BaseDao<Graduate, Long> {
    List<Graduate> listAllWithPagenate(Integer page);
    
    List<Graduate> listAllWithoutPagenate();
    
    Graduate findByGrade(Grade grade);
    
    List<Graduate> search(Integer page,Long batchId, Long learnClassId);

    List<Graduate> search(Long batchId, Long learnClassId);
}
