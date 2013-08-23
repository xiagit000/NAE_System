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
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 学生成绩
 */
@Entity
@Table(name="grade")
public class Grade implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Double learnVideoScore=0.0;
    
    private Double learnThesisScore=0.0;
    
    private Double learnDiscussScore=0.0;
    
    private Double usuallyScore=0.0;
    
    private String onlineTimeCount="";
    
    private String effectiveTimeCount="";
    
    

    public String getOnlineTimeCount() {
		return onlineTimeCount;
	}

	public void setOnlineTimeCount(String onlineTimeCount) {
		this.onlineTimeCount = onlineTimeCount;
	}

	public String getEffectiveTimeCount() {
		return effectiveTimeCount;
	}

	public void setEffectiveTimeCount(String effectiveTimeCount) {
		this.effectiveTimeCount = effectiveTimeCount;
	}

	@Transient
    private Double totalScore=0.0;
    
    @ManyToOne(cascade=CascadeType.REFRESH)
    @JoinColumn(name="scoringStandard_id")
    private ScoringStandard scoringStandard;
    
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
    
    private Long learnClassId;
    

    public Long getLearnClassId() {
		return learnClassId;
	}

	public void setLearnClassId(Long learnClassId) {
		this.learnClassId = learnClassId;
	}

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

    
   
	public Double getLearnVideoScore() {
		return learnVideoScore;
	}

	public void setLearnVideoScore(Double learnVideoScore) {
		this.learnVideoScore = learnVideoScore;
	}

	public Double getLearnThesisScore() {
		return learnThesisScore;
	}

	public void setLearnThesisScore(Double learnThesisScore) {
		this.learnThesisScore = learnThesisScore;
	}

	public Double getLearnDiscussScore() {
		return learnDiscussScore;
	}

	public void setLearnDiscussScore(Double learnDiscussScore) {
		this.learnDiscussScore = learnDiscussScore;
	}

	public Double getUsuallyScore() {
		return usuallyScore;
	}

	public void setUsuallyScore(Double usuallyScore) {
		this.usuallyScore = usuallyScore;
	}

	public void setTotalScore(Double totalScore) {
		this.totalScore = totalScore;
	}
	

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ScoringStandard getScoringStandard() {
        return scoringStandard;
    }

    public void setScoringStandard(ScoringStandard scoringStandard) {
        this.scoringStandard = scoringStandard;
    }

    public Double getTotalScore() {
        BigDecimal lds=new BigDecimal(learnDiscussScore);
        BigDecimal lts=new BigDecimal(learnThesisScore);
        BigDecimal lvs=new BigDecimal(learnVideoScore);
        BigDecimal us=new BigDecimal(usuallyScore);
        this.totalScore = lds.add(us).add(lvs).add(lts).doubleValue();
        return this.totalScore;
    }

    
}
