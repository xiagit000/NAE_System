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

import com.boventech.gplearn.dao.GraduateDao;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.Graduate;

@Repository
public class GraduateDaoImpl extends BaseDaoImpl<Graduate, Long> implements GraduateDao{

    @Override
    public List<Graduate> listAllWithPagenate(Integer page) {
        return executeQueryWithPagination("from Graduate", null, page);
    }

    @Override
    public Graduate findByGrade(Grade grade) {
        String queryString="from Graduate g where g.grade=?1";
        return executeQueryWithoutPaging(queryString, grade).get(0);
    }

    @Override
    public List<Graduate> listAllWithoutPagenate() {
        return executeQueryWithoutPaging("from Graduate");
    }

    @Override
    public List<Graduate> search(Integer page, Long batchId, Long learnClassId) {
        StringBuilder builder=new StringBuilder("from Graduate g where 1=1");
        if(batchId!=0){
            builder.append(" and g.grade.user.batch.id="+batchId);
        }
        if(learnClassId!=0){
            builder.append(" and g.grade.learnClassId="+learnClassId);
        }
        String queryString=builder.toString();
        return executeQueryWithPagination(queryString, null, page);
    }

    @Override
    public List<Graduate> search(Long batchId, Long learnClassId) {
        StringBuilder builder=new StringBuilder("from Graduate g where 1=1");
        if(batchId!=0){
            builder.append(" and g.grade.user.batch.id="+batchId);
        }
        if(learnClassId!=0){
            builder.append(" and g.grade.learnClassId="+learnClassId);
        }
        String queryString=builder.toString();
        return executeQueryWithoutPaging(queryString);
    }

}
