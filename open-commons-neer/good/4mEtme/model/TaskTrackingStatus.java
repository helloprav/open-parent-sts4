package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tasktrackingstatus database table.
 * 
 */
@Entity
@NamedQuery(name="TaskTrackingStatus.findAll", query="SELECT t FROM TaskTrackingStatus t")
public class TaskTrackingStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTrackingStatusID;

	private String taskTrackingStatusName;

	//bi-directional many-to-one association to TaskTrackingStatusUser
	@OneToMany(mappedBy="tasktrackingstatus")
	private List<TaskTrackingStatusUser> tasktrackingstatususers;

	public TaskTrackingStatus() {
	}

	public int getTaskTrackingStatusID() {
		return this.taskTrackingStatusID;
	}

	public void setTaskTrackingStatusID(int taskTrackingStatusID) {
		this.taskTrackingStatusID = taskTrackingStatusID;
	}

	public String getTaskTrackingStatusName() {
		return this.taskTrackingStatusName;
	}

	public void setTaskTrackingStatusName(String taskTrackingStatusName) {
		this.taskTrackingStatusName = taskTrackingStatusName;
	}

	public List<TaskTrackingStatusUser> getTasktrackingstatususers() {
		return this.tasktrackingstatususers;
	}

	public void setTasktrackingstatususers(List<TaskTrackingStatusUser> tasktrackingstatususers) {
		this.tasktrackingstatususers = tasktrackingstatususers;
	}

	public TaskTrackingStatusUser addTasktrackingstatususer(TaskTrackingStatusUser tasktrackingstatususer) {
		getTasktrackingstatususers().add(tasktrackingstatususer);
		tasktrackingstatususer.setTasktrackingstatus(this);

		return tasktrackingstatususer;
	}

	public TaskTrackingStatusUser removeTasktrackingstatususer(TaskTrackingStatusUser tasktrackingstatususer) {
		getTasktrackingstatususers().remove(tasktrackingstatususer);
		tasktrackingstatususer.setTasktrackingstatus(null);

		return tasktrackingstatususer;
	}

}