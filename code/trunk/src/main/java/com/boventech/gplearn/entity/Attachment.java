package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="attachment")
public class Attachment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4481958502538831290L;

	//编号
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//附件名
	@Column(length=100,nullable=false)
	private String fileName;
	
	//附件路径
	@Column(length=2000,nullable=false)
	private String filePath;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

}
