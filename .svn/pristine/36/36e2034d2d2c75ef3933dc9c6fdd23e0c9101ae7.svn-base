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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="scoringStandard")
public class ScoringStandard implements Serializable{
   
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Double learnVideoProportion=0.4;
    
    private Double learnThesisProportion=0.4;
    
    private Double learnDiscussProportion=0.15;
    
    private Double usuallyProportion=0.05;
    
    
    
    
    public Double getLearnVideoProportion() {
		return learnVideoProportion;
	}

	public void setLearnVideoProportion(Double learnVideoProportion) {
		this.learnVideoProportion = learnVideoProportion;
	}

	public Double getLearnThesisProportion() {
		return learnThesisProportion;
	}

	public void setLearnThesisProportion(Double learnThesisProportion) {
		this.learnThesisProportion = learnThesisProportion;
	}

	public Double getLearnDiscussProportion() {
		return learnDiscussProportion;
	}

	public void setLearnDiscussProportion(Double learnDiscussProportion) {
		this.learnDiscussProportion = learnDiscussProportion;
	}

	public Double getUsuallyProportion() {
		return usuallyProportion;
	}

	public void setUsuallyProportion(Double usuallyProportion) {
		this.usuallyProportion = usuallyProportion;
	}

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
