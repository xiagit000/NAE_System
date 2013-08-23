package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="navigation")
public class Navigation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1652505041557143135L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(length=255,nullable=false)
	private String name;
	
	@Column(length=255)
	private String elCode;
	
	private Integer childCount=0;

	
	
	
	public Integer getChildCount() {
		return childCount;
	}

	public void setChildCount(Integer childCount) {
		this.childCount = childCount;
	}

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

	public String getElCode() {
		return elCode;
	}

	public void setElCode(String elCode) {
		this.elCode = elCode;
	}


	
	
}
