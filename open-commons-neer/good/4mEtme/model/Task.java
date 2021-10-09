package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the task database table.
 * 
 */
@Entity
@NamedQuery(name = "Task.findAll", query = "SELECT t FROM Task t")
public class Task implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskID;

	private int assetID;

	private String assetType;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	private String executionLevel;

	private int executionLevelID;

	private String notes;

	// bi-directional many-to-one association to Taskattachment
	@OneToMany(mappedBy = "task")
	private List<TaskAttachment> taskattachments;

	@OneToMany(mappedBy = "task")
	private List<TaskStatusUser> taskstatususers;

	//bi-directional many-to-one association to Taskuser
	@OneToMany(mappedBy="task", cascade = { CascadeType.PERSIST})
	private List<TaskUser> taskUsers;
	
	// bi-directional many-to-one association to TaskTemplate
	@ManyToOne
	@JoinColumn(name = "TemplateTaskID")
	private TaskTemplate tasktemplate;

	@ManyToOne
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	public Task() {
	}

	public int getTaskID() {
		return this.taskID;
	}

	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	public int getAssetID() {
		return this.assetID;
	}

	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}

	public String getAssetType() {
		return this.assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getExecutionLevel() {
		return this.executionLevel;
	}

	public void setExecutionLevel(String executionLevel) {
		this.executionLevel = executionLevel;
	}

	public int getExecutionLevelID() {
		return this.executionLevelID;
	}

	public void setExecutionLevelID(int executionLevelID) {
		this.executionLevelID = executionLevelID;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<TaskAttachment> getTaskattachments() {
		return this.taskattachments;
	}

	public void setTaskattachments(List<TaskAttachment> taskattachments) {
		this.taskattachments = taskattachments;
	}

	public TaskAttachment addTaskattachment(TaskAttachment taskattachment) {
		getTaskattachments().add(taskattachment);
		taskattachment.setTask(this);

		return taskattachment;
	}

	public TaskAttachment removeTaskattachment(TaskAttachment taskattachment) {
		getTaskattachments().remove(taskattachment);
		taskattachment.setTask(null);

		return taskattachment;
	}

	public TaskTemplate getTasktemplate() {
		return this.tasktemplate;
	}

	public void setTasktemplate(TaskTemplate tasktemplate) {
		this.tasktemplate = tasktemplate;
	}

	public MoveGroup getMovegroup() {
		return movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public List<TaskStatusUser> getTaskstatususers() {
		return this.taskstatususers;
	}

	public void setTaskstatususers(List<TaskStatusUser> taskstatususers) {
		this.taskstatususers = taskstatususers;
	}
	public TaskStatusUser addTaskstatususer(TaskStatusUser taskstatususer) {
		getTaskstatususers().add(taskstatususer);
		taskstatususer.setTask(this);
		return taskstatususer;
	}
		 
	public TaskStatusUser removeTaskstatususer(TaskStatusUser taskstatususer) {
		getTaskstatususers().remove(taskstatususer);
		taskstatususer.setTask(null);
		return taskstatususer;
	}
	public List<TaskUser> getTaskUsers() {
		return this.taskUsers;
	}

	public void setTaskUsers(List<TaskUser> taskUsers) {
		this.taskUsers = taskUsers;
	}

	public TaskUser addTaskUser(TaskUser taskUser) {
		getTaskUsers().add(taskUser);
		taskUser.setTask(this);

		return taskUser;
	}

	public TaskUser removeTaskUser(TaskUser taskUser) {
		getTaskUsers().remove(taskUser);
		taskUser.setTask(null);

		return taskUser;
	}
}