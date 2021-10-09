package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the taskstatus database table.
 * 
 */
@Entity
@Table(name="TaskStatus")
@NamedQuery(name="TaskStatus.findAll", query="SELECT t FROM TaskStatus t")
public class TaskStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskStatusID;

	private String taskStatusName;

	//bi-directional many-to-one association to TaskStatusUser
	@OneToMany(mappedBy="taskstatus")
	private List<TaskStatusUser> taskstatususers;

	public TaskStatus() {
	}

	public int getTaskStatusID() {
		return this.taskStatusID;
	}

	public void setTaskStatusID(int taskStatusID) {
		this.taskStatusID = taskStatusID;
	}

	public String getTaskStatusName() {
		return this.taskStatusName;
	}

	public void setTaskStatusName(String taskStatusName) {
		this.taskStatusName = taskStatusName;
	}

	public List<TaskStatusUser> getTaskstatususers() {
		return this.taskstatususers;
	}

	public void setTaskstatususers(List<TaskStatusUser> taskstatususers) {
		this.taskstatususers = taskstatususers;
	}

	public TaskStatusUser addTaskstatususer(TaskStatusUser taskstatususer) {
		getTaskstatususers().add(taskstatususer);
		taskstatususer.setTaskstatus(this);

		return taskstatususer;
	}

	public TaskStatusUser removeTaskstatususer(TaskStatusUser taskstatususer) {
		getTaskstatususers().remove(taskstatususer);
		taskstatususer.setTaskstatus(null);

		return taskstatususer;
	}

}