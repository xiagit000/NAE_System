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

/**
 * 结业模型
 */
@Entity
@Table(name="graduate")
public class Graduate implements Serializable{
    
    public enum GraduateStatus{
        Graduated,Special_Approval_Graduated,NoGraduate
    }

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length=100)
    private GraduateStatus graduateStatus;
    
    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="grade_id")
    private Grade grade;
    
    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="graduateStandard_id")
    private GraduateStandard graduateStandard;

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the graduateStatus
     */
    public GraduateStatus getGraduateStatus() {
        return graduateStatus;
    }

    /**
     * @param graduateStatus the graduateStatus to set
     */
    public void setGraduateStatus(GraduateStatus graduateStatus) {
        this.graduateStatus = graduateStatus;
    }

    /**
     * @return the grade
     */
    public Grade getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    /**
     * @return the graduateStandard
     */
    public GraduateStandard getGraduateStandard() {
        return graduateStandard;
    }

    /**
     * @param graduateStandard the graduateStandard to set
     */
    public void setGraduateStandard(GraduateStandard graduateStandard) {
        this.graduateStandard = graduateStandard;
    }
    
    
}
