package com.boventech.gplearn.entity;

public class WorkStatistics {

	public enum WorkType{
		LearnThesis,
		Question
	}
	
	private WorkType workType;
	
	private Integer waitResolveCount=0;
	
	private Integer resolveCount=0;
	
	private Integer total=0;

	public Integer getResolveCount() {
		return resolveCount;
	}

	public void setResolveCount(Integer resolveCount) {
		this.resolveCount = resolveCount;
	}

	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public Integer getWaitResolveCount() {
		return waitResolveCount;
	}

	public void setWaitResolveCount(Integer waitResolveCount) {
		this.waitResolveCount = waitResolveCount;
	}

	public Integer getTotal() {
		this.total=this.waitResolveCount+this.resolveCount;
		return this.total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	
	
	
	 
}
