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

package com.boventech.gplearn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 招生计划
 */
@Entity
@Table(name = "enrollmentplan")
public class EnrollmentPlan implements Serializable {

    private static final long serialVersionUID = -7355800901874325770L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // 教学模式（学分制，学年制）
    public enum LearnModel {
        Scholastic_Year_System, Credit_System
    }

    @Enumerated(EnumType.STRING)
    private LearnModel learnModel;

    // 是否收费
    private boolean isPay;

    // 收费金额
    private double expense;

    // 招生人数
    private int EnrollmentNumber;

    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date beginTime;

    @Temporal(TemporalType.DATE)
    @Column(nullable=false)
    private Date endTime;

    @Column(length = 2000)
    private String description;
    
    //已经招收的学生人数
    private Integer existedUserNumber=0;

    // 培训批次
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "batch_id")
    private Batch batch;

    // 班级
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "learnClass_id")
    private LearnClass learnClass;
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the learnModel
     */
    public LearnModel getLearnModel() {
        return learnModel;
    }

    /**
     * @param learnModel
     *            the learnModel to set
     */
    public void setLearnModel(LearnModel learnModel) {
        this.learnModel = learnModel;
    }

    /**
     * @return the isPay
     */
    public boolean isPay() {
        return isPay;
    }

    /**
     * @param isPay
     *            the isPay to set
     */
    public void setPay(boolean isPay) {
        this.isPay = isPay;
    }

    /**
     * @return the expense
     */
    public double getExpense() {
        return expense;
    }

    /**
     * @param expense
     *            the expense to set
     */
    public void setExpense(double expense) {
        this.expense = expense;
    }

    /**
     * @return the beginTime
     */
    public Date getBeginTime() {
        return beginTime;
    }

    /**
     * @param beginTime
     *            the beginTime to set
     */
    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            the endTime to set
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * @param batch
     *            the batch to set
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    /**
     * @return the learnClass
     */
    public LearnClass getLearnClass() {
        return learnClass;
    }

    /**
     * @param learnClass
     *            the learnClass to set
     */
    public void setLearnClass(LearnClass learnClass) {
        this.learnClass = learnClass;
    }

    /**
     * @return the enrollmentNumber
     */
    public int getEnrollmentNumber() {
        return EnrollmentNumber;
    }

    /**
     * @param enrollmentNumber the enrollmentNumber to set
     */
    public void setEnrollmentNumber(int enrollmentNumber) {
        EnrollmentNumber = enrollmentNumber;
    }

    /**
     * @return the existedUserNumber
     */
    public Integer getExistedUserNumber() {
        return existedUserNumber;
    }

    /**
     * @param existedUserNumber the existedUserNumber to set
     */
    public void setExistedUserNumber(Integer existedUserNumber) {
        this.existedUserNumber = existedUserNumber;
    }
}
