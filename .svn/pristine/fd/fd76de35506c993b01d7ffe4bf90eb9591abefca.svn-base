package com.boventech.gplearn.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videoStatistics")
public class VideoStatistics implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2812178216539436306L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String userLoginName;
	
	private Long disciplineId;
	
	private Long schoolSpaceId;
	
	@Column(nullable=false)
	private Long timeCount=0L;
	
	@Column(nullable=false)
	private String videoPath;
	
	@Column(nullable=false)
	private String videoId;

	
	private boolean online=false;
	
	

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserLoginName() {
		return userLoginName;
	}

	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}

	public Long getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(Long disciplineId) {
		this.disciplineId = disciplineId;
	}

	

	public Long getSchoolSpaceId() {
		return schoolSpaceId;
	}

	public void setSchoolSpaceId(Long schoolSpaceId) {
		this.schoolSpaceId = schoolSpaceId;
	}

	public Long getTimeCount() {
		return timeCount;
	}

	public void setTimeCount(Long timeCount) {
		this.timeCount = timeCount;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	
	
	
}
