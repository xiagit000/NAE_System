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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 培训子项目（培训项目与学科组合）
 */
@Entity
@Table(name = "learnsubproject")
public class LearnSubProject implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1541253371792443439L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(length=255,nullable=false)
	private String name;

	@ManyToOne
	@JoinColumn(name="learnProject_id")
	private LearnProject learnProject;
	
    //子项目简介
    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name="discipline_id")
    private Discipline discipline;
    
    @ManyToOne
    @JoinColumn(name="personIncharge_id")
    private User personInCharge;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LearnProject getLearnProject() {
		return learnProject;
	}

	public void setLearnProject(LearnProject learnProject) {
		this.learnProject = learnProject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(User personInCharge) {
		this.personInCharge = personInCharge;
	}
  
    
    

}
