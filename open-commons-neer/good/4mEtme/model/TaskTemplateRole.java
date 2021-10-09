package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tasktemplateroles database table.
 * 
 */
@Entity
@Table(name="TaskTemplateRoles")
@NamedQuery(name="TaskTemplateRole.findAll", query="SELECT t FROM TaskTemplateRole t")
public class TaskTemplateRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTemplateRoleID;

	private byte isInformed;

	private byte isResponsible;

	private String notes;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RoleID")
	private Role role;

	//bi-directional many-to-one association to TaskTemplate
	@ManyToOne
	@JoinColumn(name="TaskTemplateID")
	private TaskTemplate tasktemplate;

	public TaskTemplateRole() {
	}

	public int getTaskTemplateRoleID() {
		return this.taskTemplateRoleID;
	}

	public void setTaskTemplateRoleID(int taskTemplateRoleID) {
		this.taskTemplateRoleID = taskTemplateRoleID;
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

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public TaskTemplate getTasktemplate() {
		return this.tasktemplate;
	}

	public void setTasktemplate(TaskTemplate tasktemplate) {
		this.tasktemplate = tasktemplate;
	}

}