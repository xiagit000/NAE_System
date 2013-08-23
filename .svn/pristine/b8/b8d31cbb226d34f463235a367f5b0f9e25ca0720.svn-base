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
@Table(name="videoInfo")
public class VideoInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1441505019080913971L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="discipline_Id")
	private Discipline discipline;
	
	@ManyToOne
	@JoinColumn(name="school_Id")
	private SchoolSpace schoolSpace;
	
	@Column(nullable=false)
	private String videoId;
	
	@ManyToOne
	@JoinColumn(name="batch_id")
	private Batch batch;
	
	private Long videoLength=0L;
	
	

	public Long getVideoLength() {
		return videoLength;
	}

	public void setVideoLength(Long videoLength) {
		this.videoLength = videoLength;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public SchoolSpace getSchoolSpace() {
		return schoolSpace;
	}

	public void setSchoolSpace(SchoolSpace schoolSpace) {
		this.schoolSpace = schoolSpace;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	
	
}
