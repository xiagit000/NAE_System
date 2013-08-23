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

import com.boventech.gplearn.dao.GraduateStandardDao;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.GraduateStandard;

@Repository
public class GraduateStandardDaoImpl extends BaseDaoImpl<GraduateStandard, Long> implements
        GraduateStandardDao {

    @Override
    public boolean checkeExist() {
        return !executeQueryWithoutPaging("from GraduateStandard").isEmpty();
    }

    @Override
    public GraduateStandard getStandardByBatch(Batch batch) {
        List<GraduateStandard> graduateStandards = executeQueryWithoutPaging(
                "from GraduateStandard g where g.batch=?1", batch);
        return graduateStandards.size() > 0 ? graduateStandards.get(0) : null;
    }

    @Override
    public List<GraduateStandard> listAllWithoutPagnate() {
        return executeQueryWithoutPaging("from GraduateStandard");
    }

    @Override
    public boolean checkeExistByBatch(Batch batch) {
        return !executeQueryWithoutPaging("from GraduateStandard g where g.batch=?1", batch).isEmpty();
    }

	@Override
	public GraduateStandard getCurrentBatchGraduateStandard(Batch currentBatch) {
		String queryString = "FROM GraduateStandard g WHERE g.batch=?1";
		List<GraduateStandard> list=executeQueryWithoutPaging(queryString, currentBatch);
		return list.isEmpty()?null:list.get(0);
	}

}
