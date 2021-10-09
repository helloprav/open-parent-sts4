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
 * The persistent class for the tasktrackingstatususers database table.
 * 
 */
@Entity
@Table(name="TaskTrackingStatusUsers")
@NamedQuery(name="TaskTrackingStatusUser.findAll", query="SELECT t FROM TaskTrackingStatusUser t")
public class TaskTrackingStatusUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTrackingStatusUserID;

	private String notes;
	private Date creationDate;
	
	//bi-directional many-to-one association to TaskTracking
	@ManyToOne
	@JoinColumn(name="TaskTrackingID")
	private TaskTracking tasktracking;

	//bi-directional many-to-one association to TaskTrackingStatus
	@ManyToOne
	@JoinColumn(name="TaskTrackingStatusID")
	private TaskTrackingStatus tasktrackingstatus;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	public TaskTrackingStatusUser() {
	}

	public int getTaskTrackingStatusUserID() {
		return this.taskTrackingStatusUserID;
	}

	public void setTaskTrackingStatusUserID(int taskTrackingStatusUserID) {
		this.taskTrackingStatusUserID = taskTrackingStatusUserID;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public TaskTracking getTasktracking() {
		return this.tasktracking;
	}

	public void setTasktracking(TaskTracking tasktracking) {
		this.tasktracking = tasktracking;
	}

	public TaskTrackingStatus getTasktrackingstatus() {
		return this.tasktrackingstatus;
	}

	public void setTasktrackingstatus(TaskTrackingStatus tasktrackingstatus) {
		this.tasktrackingstatus = tasktrackingstatus;
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