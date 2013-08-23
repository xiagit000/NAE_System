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

import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.GraduateStandard;

public interface GraduateStandardDao extends BaseDao<GraduateStandard, Long> {
    boolean checkeExist();
    
    boolean checkeExistByBatch(Batch batch);
    
    GraduateStandard getStandardByBatch(Batch batch);
    
    List<GraduateStandard> listAllWithoutPagnate();

	GraduateStandard getCurrentBatchGraduateStandard(Batch currentBatch);
}
