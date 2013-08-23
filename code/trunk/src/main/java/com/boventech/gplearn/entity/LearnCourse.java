package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.boventech.gplearn.entity.Discipline.LearnRange;

@Entity
@Table(name="learncourse")
public class LearnCourse implements Serializable {

	/**
	 * 课程
	 */
	private static final long serialVersionUID = -3697922867216292003L;

	/**
	 * OBLIGATORY 必修
	 * ELECTIVE   选修
	 */
	public enum LearnShape{
		OBLIGATORY,ELECTIVE
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=255,nullable=false)
	private String name;
	
	@Column(length=255,nullable=false)
	private String code;
	
	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private LearnShape learnShape;
	
	@Column(length=2000)
	private String description;

	@Enumerated(EnumType.STRING)
	private LearnRange learnRange;
	
	@Column(nullable=false)
	private Double studyTimeCount=0.0;

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

	public LearnShape getLearnShape() {
		return learnShape;
	}

	public void setLearnShape(LearnShape learnShape) {
		this.learnShape = learnShape;
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

	public Double getStudyTimeCount() {
		return studyTimeCount;
	}

	public void setStudyTimeCount(Double studyTimeCount) {
		this.studyTimeCount = studyTimeCount;
	}

	
	
	
}
