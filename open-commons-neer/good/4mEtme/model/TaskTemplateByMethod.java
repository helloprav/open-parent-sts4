package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the tasktemplatebymethods database table.
 * 
 */
@Entity
@Table(name="TaskTemplateByMethods")
@NamedQuery(name="TaskTemplateByMethod.findAll", query="SELECT t FROM TaskTemplateByMethod t")
public class TaskTemplateByMethod implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTemplateByMethodsID;

	private int methodId;

	private String methodName;

	private String methodType;

	private String notes;

	private Timestamp timestamp;

	//bi-directional many-to-one association to Tasktemplate
	@ManyToOne/*(cascade = { CascadeType.ALL })*/
	@JoinColumn(name="TaskTemplateId")
	private TaskTemplate tasktemplate;

	//bi-directional many-to-one association to User
	@ManyToOne/*(cascade = { CascadeType.ALL })*/
	@JoinColumn(name="UserId")
	private User user;

	public TaskTemplateByMethod() {
	}

	public int getTaskTemplateByMethodsID() {
		return this.taskTemplateByMethodsID;
	}

	public void setTaskTemplateByMethodsID(int taskTemplateByMethodsID) {
		this.taskTemplateByMethodsID = taskTemplateByMethodsID;
	}

	public int getMethodId() {
		return this.methodId;
	}

	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public String getMethodType() {
		return this.methodType;
	}

	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Timestamp getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public TaskTemplate getTasktemplate() {
		return this.tasktemplate;
	}

	public void setTasktemplate(TaskTemplate tasktemplate) {
		this.tasktemplate = tasktemplate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}