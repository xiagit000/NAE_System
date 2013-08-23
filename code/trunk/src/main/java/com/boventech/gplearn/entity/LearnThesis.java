package com.boventech.gplearn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 研修论文 模型
 * 
 *
 */
@Entity
@Table(name="learnthesis")
public class LearnThesis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2294754679368750831L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=2000,nullable=false)
	private String title;
	
	@Column(length=5000,nullable=false)
	private String content;
	
	@ManyToOne
	@JoinColumn(name="bigsubject_id")
	private BigSubject bigSubject;
	
	private Double Score=0.0;
	
	private Date beginTime;
	
	private Date submitTime;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public BigSubject getBigSubject() {
		return bigSubject;
	}

	public void setBigSubject(BigSubject bigSubject) {
		this.bigSubject = bigSubject;
	}

	public Double getScore() {
		return Score;
	}

	public void setScore(Double score) {
		Score = score;
	}

	public Date getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}
	
	public boolean checkDatetime(){
		return this.beginTime.before(submitTime);
	}
	
}
