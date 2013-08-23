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

import java.util.List;

import org.springframework.stereotype.Repository;

import com.boventech.gplearn.dao.GradeDao;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.User;

@Repository
public class GradeDaoImpl extends BaseDaoImpl<Grade, Long> implements GradeDao{

    @Override
    public List<Grade> listAllWithPagnate(Integer page) {
        return executeQueryWithPagination("from Grade", null, page);
    }

    @Override
    public Grade findByUser(User user) {
        String queryString="from Grade g where g.user=?1";
        List<Grade> list= executeQueryWithoutPaging(queryString, user);
        return list.isEmpty()?null:list.get(0);
    }

	@Override
	public List<Grade> listWithPaginationByLearnClassId(Long id, Integer page) {
		String queryString = "FROM Grade g where g.learnClassId=?1";
		return executeQueryWithPagination(queryString, " ORDER BY g.id ASC", page, id);
	}

    @Override
    public List<Grade> search(Integer page,Long batchId, Long learnClassId) {
        StringBuilder builder=new StringBuilder("from Grade g where 1=1");
        if(batchId!=0){
            builder.append(" and g.user.batch.id="+batchId);
        }
        if(learnClassId!=0){
            builder.append(" and g.learnClassId="+learnClassId);
        }
        String queryString=builder.toString();
        return executeQueryWithPagination(queryString, null, page);
    }

    @Override
    public List<Grade> search(Long batchId, Long learnClassId) {
        StringBuilder builder=new StringBuilder("from Grade g where 1=1");
        if(batchId!=0){
            builder.append(" and g.user.batch.id="+batchId);
        }
        if(learnClassId!=0){
            builder.append(" and g.learnClassId="+learnClassId);
        }
        String queryString=builder.toString();
        return executeQueryWithoutPaging(queryString);
    }

}
