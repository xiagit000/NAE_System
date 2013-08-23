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

package com.boventech.gplearn.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.gplearn.dao.LearnClassDao;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.LearnArea;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.entity.LearnSubProject;
import com.boventech.gplearn.entity.User;

@Repository
public class LearnClassDaoImpl extends BaseDaoImpl<LearnClass, Long> implements LearnClassDao {

    @Override
    public List<LearnClass> listAll() {
        return executeQueryWithoutPaging("FROM LearnClass");
    }

    @Override
    public boolean isExistByCode(String code) {
        String queryString="from LearnClass where code=?1";
        return !executeQueryWithoutPaging(queryString, code).isEmpty();
    }

    @Override
    public boolean isExistByCodeWhitoutCurrent(LearnClass learnClass) {
        String queryString="from LearnClass where code=?1 and id<>?2";
        return !executeQueryWithoutPaging(queryString, learnClass.getCode(),learnClass.getId()).isEmpty();
    }

    @Override
    public List<LearnClass> listEnable() {
        List<LearnClass> learnClasses=new ArrayList<LearnClass>();
        List<LearnClass> classes=executeQueryWithoutPaging("From LearnClass where status=1");
        for (LearnClass learnClass : classes) {
            if(null==learnClass.getEnrollmentPlan()){
                learnClasses.add(learnClass);
            }
        }
        return learnClasses;
    }

	@Override
	public LearnClass findByCode(String code) {
		String queryString = "FROM LearnClass lc WHERE lc.code = ?1";
		List<LearnClass> list = executeQueryWithoutPaging(queryString, code);
		return list.isEmpty()?null:list.get(0);
	}

	@Override
	public LearnClass findByTeacher(User user) {
			String queryString="from LearnClass l where l.teacher=?1";
			List<LearnClass> list = executeQueryWithoutPaging(queryString, user);
			return list.isEmpty()?null:list.get(0);
		}

	@Override
	public List<LearnClass> listByLearnSubProjectInCurrentBatch(
			LearnSubProject learnSubProject,Batch currentBatach) {
		String queryString = "FROM LearnClass l WHERE l.learnProject=?1 AND l.batch=?2";
		return executeQueryWithoutPaging(queryString, learnSubProject,currentBatach);
	}

	@Override
	public List<LearnClass> listByLearnAreaInCurrentBatch(LearnArea learnArea,
			Batch currentBatch) {
		String queryString  ="FROM LearnClass l WHERE l.batch=?1 AND learnArea=?2";
		return executeQueryWithoutPaging(queryString, currentBatch,learnArea);
	}

	@Override
	public List<LearnClass> listWithPagination(Integer page) {
		String queryString = "FROM LearnClass lc";
		return executeQueryWithPagination(queryString, " ORDER BY lc.id DESC", page);
	}

	@Override
	public Integer getClassCount() {
		String queryString = "select Count(*) FROM LearnClass lc";
		return executeCountQuery(queryString);
	}


	

}
