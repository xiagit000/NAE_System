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
@Table(name="question")
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 89231765086069878L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="asker_id")
	private User asker;
	
	@ManyToOne
	@JoinColumn(name="resolver_id")
	private User resolver;
	
	private boolean resolved=false;
	
	@Column(length=2000,nullable=false)
	private String askTitle;
	
	@Column(length=5000)
	private String answerContent;
	
	@ManyToOne
	@JoinColumn(name="learnClass_id")
	private LearnClass learnClass;

	@ManyToOne
	@JoinColumn(name="discipline_id")
	private Discipline discipline;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getAsker() {
		return asker;
	}

	public void setAsker(User asker) {
		this.asker = asker;
	}

	public User getResolver() {
		return resolver;
	}

	public void setResolver(User resolver) {
		this.resolver = resolver;
	}

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved(boolean resolved) {
		this.resolved = resolved;
	}

	public String getAskTitle() {
		return askTitle;
	}

	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public LearnClass getLearnClass() {
		return learnClass;
	}

	public void setLearnClass(LearnClass learnClass) {
		this.learnClass = learnClass;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}
	
	
}
