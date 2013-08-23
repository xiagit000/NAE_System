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

@Entity
@Table(name="smalltopic")
public class SmallTopic implements Serializable {

	/**
	 * 小话题
	 */
	private static final long serialVersionUID = -5609146587561681690L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="belongbigsubject_id")
	private BigSubject belongBigSubject;
	
	@Column(length=2000,nullable=false)
	private String title;
	
	@Column(length=5000,nullable=false)
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public BigSubject getBelongBigSubject() {
		return belongBigSubject;
	}

	public void setBelongBigSubject(BigSubject belongBigSubject) {
		this.belongBigSubject = belongBigSubject;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
