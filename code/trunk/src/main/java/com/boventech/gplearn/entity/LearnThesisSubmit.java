package com.boventech.gplearn.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * 研修论文成绩记录表
 * 
 *
 */
@Entity
@Table(name="learnThesis_user")
public class LearnThesisSubmit implements Serializable{
	
	public enum LearnThesisRating{
		VERYGOOD,
		NORMAL,
		BAD
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -8618837136869345506L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="learnThesis_id")
	private LearnThesis learnThesis;
	
	@ManyToOne
	@JoinColumn(name="attachment_id")
	private Attachment attachment;
	
	private Double score=0.0;
	
	@Enumerated(EnumType.STRING)
	private LearnThesisRating learnThesisRating;
	
	@ManyToOne
	@JoinColumn(name="marking_teacher_id")
	private User teacher;
	
	private Date submitDate;
	
	private Date makingDate;
	
	private boolean newest=true;
	
	private Long learnClassId;
	
	public boolean isNewest() {
		return newest;
	}

	public void setNewest(boolean newest) {
		this.newest = newest;
	}

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

	public LearnThesis getLearnThesis() {
		return learnThesis;
	}

	public void setLearnThesis(LearnThesis learnThesis) {
		this.learnThesis = learnThesis;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public Date getMakingDate() {
		return makingDate;
	}

	public void setMakingDate(Date makingDate) {
		this.makingDate = makingDate;
	}

	public LearnThesisRating getLearnThesisRating() {
		return learnThesisRating;
	}

	public void setLearnThesisRating(LearnThesisRating learnThesisRating) {
		this.learnThesisRating = learnThesisRating;
	}

	public Long getLearnClassId() {
		return learnClassId;
	}

	public void setLearnClassId(Long learnClassId) {
		this.learnClassId = learnClassId;
	}
	
	
	
}
