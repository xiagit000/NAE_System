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
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.User;
import com.boventech.gplearn.exception.StudySpaceClassRoomCreateFaildException;
import com.boventech.gplearn.exception.StudySpaceClassRoomDestroyFaildException;

public interface LearnClassService extends BaseService<LearnClass, Long> {
    List<LearnClass> listAll();
    
    List<LearnClass> listEnable();
    
    boolean checkExist();

    boolean isExistByCode(String code);

    boolean isExistByCodeWhitoutCurrent(LearnClass learnClass);

	LearnClass findByCode(String code);

	void saveLearnClass(LearnClass learnClass) throws StudySpaceClassRoomCreateFaildException;

	void deleteLearnClass(Long id) throws StudySpaceClassRoomDestroyFaildException ;
	
	LearnClass findByTeacher(User user);

	List<LearnClass> listByLearnSubProjectInCurrentBatch(
			LearnSubProject learnSubProject, Batch currentBatch);

	List<LearnClass> listByLearnAreasInCurrentBatch(List<LearnArea> learnAreas,
			Batch currentBatch);

	List<LearnClass> listByLearnAreaInCurrentBatch(LearnArea temp,
			Batch currentBatch);

	List<LearnClass> listWithPagination(Integer page);

	Integer getClassCount();

}
