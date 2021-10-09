package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tasktemplateusers database table.
 * 
 */
@Entity
@Table(name="TaskTemplateUsers")
@NamedQuery(name="TaskTemplateUser.findAll", query="SELECT t FROM TaskTemplateUser t")
public class TaskTemplateUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTemplateUserID;

	private byte isInformed;

	private byte isResponsible;

	private String notes;

	//bi-directional many-to-one association to TaskTemplate
	@ManyToOne
	@JoinColumn(name="TaskTemplateID")
	private TaskTemplate tasktemplate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public TaskTemplateUser() {
	}

	public int getTaskTemplateUserID() {
		return this.taskTemplateUserID;
	}

	public void setTaskTemplateUserID(int taskTemplateUserID) {
		this.taskTemplateUserID = taskTemplateUserID;
	}

	public byte getIsInformed() {
		return this.isInformed;
	}

	public void setIsInformed(byte isInformed) {
		this.isInformed = isInformed;
	}

	public byte getIsResponsible() {
		return this.isResponsible;
	}

	public void setIsResponsible(byte isResponsible) {
		this.isResponsible = isResponsible;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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