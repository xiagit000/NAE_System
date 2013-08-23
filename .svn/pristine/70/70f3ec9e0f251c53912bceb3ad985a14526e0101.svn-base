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

public interface BatchService extends BaseService<Batch, Long> {
    List<Batch> listAll();

    boolean isExistByCode(String code);

    boolean isExistByCodeWithoutCurrent(Batch batch);

    Batch getCurrentBatch();
    
    Batch getNowBatch();

    boolean isDateConflict(Batch batch);
    
    boolean isDateConflictWithoutCurrent(Batch batch);
    
    boolean checkExist();
}
