package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TaskUsers")
@NamedQuery(name="TaskUsers.findAll", query="SELECT t FROM TaskUser t")
public class TaskUser implements Serializable{

    private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskUserID;

	//bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name="TaskID")
	private Task task;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="roleID")
	private Role role;

	public int getTaskUserID() {
	    return taskUserID;
	}

	public void setTaskUserID(int taskUserID) {
	    this.taskUserID = taskUserID;
	}

	public Task getTask() {
	    return task;
	}

	public void setTask(Task task) {
	    this.task = task;
	}

	public User getUser() {
	    return user;
	}

	public void setUser(User user) {
	    this.user = user;
	}

	public Role getRole() {
	    return role;
	}

	public void setRole(Role role) {
	    this.role = role;
	}
	
	
}
