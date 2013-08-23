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

import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.GraduateStandard;


public interface GraduateStandardService extends BaseService<GraduateStandard, Long>{
    boolean checkeExist();
    
    boolean checkeExistByBatch(Batch batch);
    
    List<GraduateStandard> listAll();

	GraduateStandard getCurrentBatchGraduateStandard(Batch currentBatch);
	
	GraduateStandard getStandardByBatch(Batch batch);
}
