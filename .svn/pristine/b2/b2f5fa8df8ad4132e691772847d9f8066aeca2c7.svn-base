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
@Table(name="bigsubject")
public class BigSubject implements Serializable {

	/**
	 * 大主题
	 */
	private static final long serialVersionUID = -906043200013479430L;

	//编号
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//大主题发布的学科专家或者管理员
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	//大主题所属学科
	@ManyToOne
	@JoinColumn(name="discipline_id")
	private Discipline discipline;
	
	//大主题标题
	@Column(length=1000,nullable=false)
	private String title;
	
	//大主题描述
	@Column(length=5000,nullable=false)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
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

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
	
}
