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
import com.boventech.gplearn.entity.SchoolSpace;
import com.boventech.gplearn.entity.User;

public interface SchoolSpaceDao extends BaseDao<SchoolSpace, Long> {


	List<SchoolSpace> listByUncreate();

	List<SchoolSpace> listWithPaginationOfCurrentBatch(Integer page, Batch batch);

	List<SchoolSpace> listWithPagination(Integer page);

	boolean checkExistBySchoolNameAndBatch(String school, Batch batch);
	
	SchoolSpace findBySchoolNameAndBatch(String schoolName,Batch batch);

	SchoolSpace findByPersonIncharge(User currentUser);

	List<SchoolSpace> listWithCurrentBatch(Batch currentBatch);

	List<SchoolSpace> listAll();
}


