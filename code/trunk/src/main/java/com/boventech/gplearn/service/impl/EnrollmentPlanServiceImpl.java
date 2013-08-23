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

package com.boventech.gplearn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boventech.gplearn.dao.EnrollmentPlanDao;
import com.boventech.gplearn.dao.SchoolRollDao;
import com.boventech.gplearn.entity.EnrollmentPlan;
import com.boventech.gplearn.entity.LearnClass;
import com.boventech.gplearn.service.EnrollmentPlanService;

@Service
@Transactional
public class EnrollmentPlanServiceImpl implements EnrollmentPlanService {

    @Autowired
    private EnrollmentPlanDao enrollmentPlanDao;

    @Autowired
    private SchoolRollDao schoolRollDao;

    @Override
    public void save(EnrollmentPlan t) {
        this.enrollmentPlanDao.save(t);
    }

    @Override
    public void delete(EnrollmentPlan t) {
        this.enrollmentPlanDao.delete(t);
    }

    @Override
    public void delete(Long id) {
        this.enrollmentPlanDao.deleteById(id);
    }

    @Override
    public void update(EnrollmentPlan t) {
        this.enrollmentPlanDao.update(t);
    }

    @Override
    public EnrollmentPlan findById(Long id) {
        return this.enrollmentPlanDao.findByID(id);
    }

    @Override
    public List<EnrollmentPlan> listAll() {
        return this.enrollmentPlanDao.listAll();
    }

    @Override
    public boolean isExistByBatchAndClass(EnrollmentPlan enrollmentPlan) {
        return this.enrollmentPlanDao.isExistByBatchAndClass(enrollmentPlan);
    }

    @Override
    public boolean isExistByBatchAndClassWithoutCurrent(EnrollmentPlan enrollmentPlan) {
        return this.enrollmentPlanDao.isExistByBatchAndClassWithoutCurrent(enrollmentPlan);
    }

    @Override
    public boolean isConflictByDate(EnrollmentPlan enrollmentPlan) {
        return this.enrollmentPlanDao.isConflictByDate(enrollmentPlan);
    }

    /**
     * 已满员的班级不再招生，在导入学生选择招生计划时过滤掉
     */
    @Override
    public List<EnrollmentPlan> listEnableImport() {
        List<EnrollmentPlan> enrollmentPlans = new ArrayList<EnrollmentPlan>();
        for (EnrollmentPlan enrollmentPlan : this.enrollmentPlanDao.listAll()) {
            if (enrollmentPlan.getExistedUserNumber() < enrollmentPlan.getEnrollmentNumber()) {
                enrollmentPlans.add(enrollmentPlan);
            }
        }
        return enrollmentPlans;
    }
    
    @Override
    public boolean checkExist() {
        return !this.listEnableImport().isEmpty();
    }

    @Override
    public void updateExistedUserNumber(EnrollmentPlan enrollmentPlan) {
        enrollmentPlan.setExistedUserNumber(this.schoolRollDao.getUserNumberByLearnClass(enrollmentPlan
                .getLearnClass()));
        this.enrollmentPlanDao.update(enrollmentPlan);
    }

    @Override
    public EnrollmentPlan findEnrollmentPlanByLearnClass(LearnClass learnClass) {
        return this.enrollmentPlanDao.findEnrollmentPlanByLearnClass(learnClass);
    }

	@Override
	public List<EnrollmentPlan> listWithPagination(Integer page) {
		return this.enrollmentPlanDao.listWithPagination(page);
	}

}
