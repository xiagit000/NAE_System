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

import java.util.Date;
import java.util.List;

import com.boventech.gplearn.entity.Batch;

public interface BatchDao extends BaseDao<Batch, Long> {
    List<Batch> listAll();

    boolean isExistByCode(String code);

    boolean isExistByCodeWithoutCurrent(Batch batch);
    
    Batch getCurrentBatch(Date date);
    
    Batch getNowBatch();
    
    boolean isDateConflict(Batch batch);
    
    boolean isDateConflictWithoutCurrent(Batch batch);
}
