package com.boventech.gplearn.entity;

import java.io.Serializable;

public class LearnStatistics implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8577959822358476972L;

	private User teacher;
	
	private String classMateInfo;
	
	private String onlineTimeCount;
	
	private String enableTimeCount;
	
	private String learnThesisInfo;
	
	private String forumTopicInfo;
	
	private String questionInfo;
	
	private LearnClass learnClass;
	
	private LearnArea learnArea;
	
	private City province;
	
	private Integer provinceCount;
	
	private Integer citiesCount;
	
	private Integer learnClassCount;
	
	private LearnSubProject learnSubProject;
	
	private Integer schoolCount;
	
	private SchoolSpace school;
	
	private Integer learnSubjectCount;
	
	private Discipline discipline;
	
	private Integer teacherCount=0;
	
	
	
	
	public Integer getTeacherCount() {
		return teacherCount;
	}

	public void setTeacherCount(Integer teacherCount) {
		this.teacherCount = teacherCount;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	
	public String getClassMateInfo() {
		return classMateInfo;
	}

	public void setClassMateInfo(String classMateInfo) {
		this.classMateInfo = classMateInfo;
	}

	

	public String getLearnThesisInfo() {
		return learnThesisInfo;
	}

	public void setLearnThesisInfo(String learnThesisInfo) {
		this.learnThesisInfo = learnThesisInfo;
	}

	public String getForumTopicInfo() {
		return forumTopicInfo;
	}

	public void setForumTopicInfo(String forumTopicInfo) {
		this.forumTopicInfo = forumTopicInfo;
	}

	public String getQuestionInfo() {
		return questionInfo;
	}

	public void setQuestionInfo(String questionInfo) {
		this.questionInfo = questionInfo;
	}

	public LearnClass getLearnClass() {
		return learnClass;
	}

	public void setLearnClass(LearnClass learnClass) {
		this.learnClass = learnClass;
	}

	public LearnArea getLearnArea() {
		return learnArea;
	}

	public void setLearnArea(LearnArea learnArea) {
		this.learnArea = learnArea;
	}

	public Integer getProvinceCount() {
		return provinceCount;
	}

	public void setProvinceCount(Integer provinceCount) {
		this.provinceCount = provinceCount;
	}

	public Integer getCitiesCount() {
		return citiesCount;
	}

	public void setCitiesCount(Integer citiesCount) {
		this.citiesCount = citiesCount;
	}

	public Integer getLearnClassCount() {
		return learnClassCount;
	}

	public void setLearnClassCount(Integer learnClassCount) {
		this.learnClassCount = learnClassCount;
	}

	public LearnSubProject getLearnSubProject() {
		return learnSubProject;
	}

	public void setLearnSubProject(LearnSubProject learnSubProject) {
		this.learnSubProject = learnSubProject;
	}

	public Integer getSchoolCount() {
		return schoolCount;
	}

	public void setSchoolCount(Integer schoolCount) {
		this.schoolCount = schoolCount;
	}

	public City getProvince() {
		return province;
	}

	public void setProvince(City province) {
		this.province = province;
	}

	public SchoolSpace getSchool() {
		return school;
	}

	public void setSchool(SchoolSpace school) {
		this.school = school;
	}

	public Integer getLearnSubjectCount() {
		return learnSubjectCount;
	}

	public void setLearnSubjectCount(Integer learnSubjectCount) {
		this.learnSubjectCount = learnSubjectCount;
	}

	public String getOnlineTimeCount() {
		return onlineTimeCount;
	}

	public void setOnlineTimeCount(String onlineTimeCount) {
		this.onlineTimeCount = onlineTimeCount;
	}

	public String getEnableTimeCount() {
		return enableTimeCount;
	}

	public void setEnableTimeCount(String enableTimeCount) {
		this.enableTimeCount = enableTimeCount;
	}

	
	
	
	
}
