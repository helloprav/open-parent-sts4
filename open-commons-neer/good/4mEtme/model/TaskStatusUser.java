package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the taskstatususers database table.
 * 
 */
@Entity
@Table(name="TaskStatusUsers")
@NamedQuery(name="TaskStatusUser.findAll", query="SELECT t FROM TaskStatusUser t")
public class TaskStatusUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskStatusUserID;

	private String notes;
	private Date creationDate;
	
	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="TaskID")
	private Task task;

	//bi-directional many-to-one association to TaskStatus
	@ManyToOne
	@JoinColumn(name="TaskStatusID")
	private TaskStatus taskstatus;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	public TaskStatusUser() {
	}

	public int getTaskStatusUserID() {
		return this.taskStatusUserID;
	}

	public void setTaskStatusUserID(int taskStatusUserID) {
		this.taskStatusUserID = taskStatusUserID;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public TaskStatus getTaskstatus() {
		return this.taskstatus;
	}

	public void setTaskstatus(TaskStatus taskstatus) {
		this.taskstatus = taskstatus;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	
	

}