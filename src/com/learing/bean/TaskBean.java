package com.learing.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskBean {
	
	
	private String taskNmae, discriptiion,status;
	private int priority;
	private String tags;
	private Date startDate,endDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public TaskBean() {
		super();
		
	}

	public TaskBean(String taskNmae, String discriptiion, String status, int priority, String tags, Date startDate,Date endDate) {
		super();
		this.taskNmae = taskNmae;
		this.discriptiion = discriptiion;
		this.status = status;
		this.priority = priority;
		this.tags = tags;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String getTaskNmae() {
		return taskNmae;
	}

	public void setTaskNmae(String taskNmae) {
		this.taskNmae = taskNmae;
	}

	public String getDiscriptiion() {
		return discriptiion;
	}

	public void setDiscriptiion(String discriptiion) {
		this.discriptiion = discriptiion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date newDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "TaskModel [taskNmae=" + taskNmae + ", discriptiion=" + discriptiion + ", status=" + status
				+ ", priority=" + priority + ", tags=" + tags + ", newDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
	