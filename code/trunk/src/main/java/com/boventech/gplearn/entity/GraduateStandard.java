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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 结业标准
 */
@Entity
@Table(name="graduatestandard")
public class GraduateStandard implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private double passScore;
    
    @Temporal(TemporalType.DATE)
    private Date graduateTime;
    
    @OneToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="batch_id")
    private Batch batch;
    
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
     * @return the passScore
     */
    public double getPassScore() {
        return passScore;
    }

    /**
     * @param passScore the passScore to set
     */
    public void setPassScore(double passScore) {
        this.passScore = passScore;
    }

    /**
     * @return the graduateTime
     */
    public Date getGraduateTime() {
        return graduateTime;
    }

    /**
     * @param graduateTime the graduateTime to set
     */
    public void setGraduateTime(Date graduateTime) {
        this.graduateTime = graduateTime;
    }

    /**
     * @return the batch
     */
    public Batch getBatch() {
        return batch;
    }

    /**
     * @param batch the batch to set
     */
    public void setBatch(Batch batch) {
        this.batch = batch;
    }
    
    

}
