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

import com.boventech.gplearn.dao.GraduateDao;
import com.boventech.gplearn.dao.GraduateStandardDao;
import com.boventech.gplearn.entity.Grade;
import com.boventech.gplearn.entity.Graduate;
import com.boventech.gplearn.entity.Graduate.GraduateStatus;
import com.boventech.gplearn.entity.GraduateStandard;
import com.boventech.gplearn.service.GraduateService;

@Service
@Transactional
public class GraduateServiceImpl implements GraduateService {

    @Autowired
    private GraduateDao graduateDao;

    @Autowired
    private GraduateStandardDao graduateStandardDao;

    @Override
    public void save(Graduate t) {
        this.graduateDao.save(t);
    }

    @Override
    public void delete(Graduate t) {
        this.graduateDao.delete(t);
    }

    @Override
    public void delete(Long id) {
        this.graduateDao.deleteById(id);
    }

    @Override
    public void update(Graduate t) {
        this.graduateDao.update(t);
    }

    @Override
    public Graduate findById(Long id) {
        return this.graduateDao.findByID(id);
    }

    @Override
    public List<Graduate> listAllWithPagenate(Integer page) {
        return this.graduateDao.listAllWithPagenate(page);
    }

    @Override
    public Graduate findByGrade(Grade grade) {
        return this.graduateDao.findByGrade(grade);
    }

    @Override
    public List<Graduate> generateGraduates(List<Grade> grades) {
        List<Graduate> graduates = new ArrayList<Graduate>();
        for (Grade grade : grades) {
            GraduateStandard graduateStandard = this.graduateStandardDao.getStandardByBatch(grade.getUser()
                    .getBatch());
            Graduate graduate = new Graduate();
            graduate.setGrade(grade);
            graduate.setGraduateStandard(graduateStandard);
            graduate.setGraduateStatus(GraduateStatus.NoGraduate);
            graduates.add(graduate);
        }
        return graduates;
    }

    @Override
    public void save(List<Graduate> graduates) {
        this.graduateDao.save(graduates);
    }

    @Override
    public void updateAllStatus() {
        List<Graduate> graduates = this.graduateDao.listAllWithoutPagenate();
        for (Graduate graduate : graduates) {
            if (graduate.getGrade().getTotalScore() >= graduate.getGraduateStandard().getPassScore()) {
                graduate.setGraduateStatus(GraduateStatus.Graduated);
                this.graduateDao.update(graduate);
            }
        }
    }

    @Override
    public List<Graduate> search(Integer page, Long batchId, Long learnClassId) {
        return graduateDao.search(page, batchId, learnClassId);
    }

    @Override
    public List<Graduate> search(Long batchId, Long learnClassId) {
        return graduateDao.search(batchId, learnClassId);
    }

}
