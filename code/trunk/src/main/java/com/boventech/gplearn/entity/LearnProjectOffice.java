package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="learnprojectoffice")
public class LearnProjectOffice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6037919421872577520L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private User user;
	
	private LearnProject learnProject;
	
	private boolean active;

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

	public LearnProject getLearnProject() {
		return learnProject;
	}

	public void setLearnProject(LearnProject learnProject) {
		this.learnProject = learnProject;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
}
