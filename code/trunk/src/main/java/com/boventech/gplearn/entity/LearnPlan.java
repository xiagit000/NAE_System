package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.boventech.gplearn.entity.Discipline.LearnRange;

/**
 * 教学计划 模型
 * 
 *
 */
@Entity
@Table(name="learnplan")
public class LearnPlan implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2534275103351125024L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=255,nullable=false)
	private String name;
	
	@Column(length=255,nullable=false)
	private String code;
	
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	@ManyToOne
	@JoinColumn(name="learnSubProject_id")
	private LearnSubProject learnSubProject;
	
	@ManyToOne
	@JoinColumn(name="learnCourse_id")
	private LearnCourse learnCourse;
	
	@Enumerated(EnumType.STRING)
	private LearnRange learnRange;

	@Column(length=2000)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public LearnSubProject getLearnSubProject() {
		return learnSubProject;
	}

	public void setLearnSubProject(LearnSubProject learnSubProject) {
		this.learnSubProject = learnSubProject;
	}

	public LearnCourse getLearnCourse() {
		return learnCourse;
	}

	public void setLearnCourse(LearnCourse learnCourse) {
		this.learnCourse = learnCourse;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LearnRange getLearnRange() {
		return learnRange;
	}

	public void setLearnRange(LearnRange learnRange) {
		this.learnRange = learnRange;
	}
	
	
}
