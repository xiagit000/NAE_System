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
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.User;

public interface LearnClassDao extends BaseDao<LearnClass, Long> {
    List<LearnClass> listAll();
    
    List<LearnClass> listEnable();
    
    boolean isExistByCode(String code);
    
    boolean isExistByCodeWhitoutCurrent(LearnClass learnClass);

	LearnClass findByCode(String code);
	
	LearnClass findByTeacher(User user);

	List<LearnClass> listByLearnSubProjectInCurrentBatch(
			LearnSubProject learnSubProject,Batch currentBatach);

	List<LearnClass> listByLearnAreaInCurrentBatch(LearnArea learnArea,
			Batch currentBatch);

	List<LearnClass> listWithPagination(Integer page);

	Integer getClassCount();
}
