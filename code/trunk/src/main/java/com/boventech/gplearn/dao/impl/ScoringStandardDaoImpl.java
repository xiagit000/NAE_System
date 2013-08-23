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

import com.boventech.gplearn.dao.ScoringStandardDao;
import com.boventech.gplearn.entity.Batch;
import com.boventech.gplearn.entity.ScoringStandard;

@Repository
public class ScoringStandardDaoImpl extends BaseDaoImpl<ScoringStandard, Long> implements ScoringStandardDao {

    @Override
    public ScoringStandard getStandardByBatch(Batch batch) {
        List<ScoringStandard> scoringStandards = executeQueryWithoutPaging(
                "from ScoringStandard s where s.batch=?1", batch);
        return scoringStandards.size() > 0 ? scoringStandards.get(0) : null;
    }

    @Override
    public boolean checkExist() {
        return !executeQueryWithoutPaging("from ScoringStandard").isEmpty();
    }

    @Override
    public List<ScoringStandard> listAllWithoutPagnate() {
        return executeQueryWithoutPaging("from ScoringStandard");
    }

    @Override
    public boolean checkExistByBatch(Batch batch) {
        return !executeQueryWithoutPaging("from ScoringStandard s where s.batch=?1", batch).isEmpty();
    }

}
