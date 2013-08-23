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
import com.boventech.gplearn.entity.ScoringStandard;

public interface ScoringStandardService extends BaseService<ScoringStandard, Long>{
    boolean checkExist();
    
    List<ScoringStandard> listAll();
    
    boolean checkExistByBatch(Batch batch);
}
