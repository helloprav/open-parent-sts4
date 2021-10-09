package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tasktemplatedependencies database table.
 * 
 */
@Entity
@Table(name="TaskTemplateDependencies")
@NamedQuery(name="TaskTemplateDependency.findAll", query="SELECT t FROM TaskTemplateDependency t")
public class TaskTemplateDependency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTemplateDependencyID;

	private String notes;

	//bi-directional many-to-one association to TaskTemplate
	@ManyToOne
	@JoinColumn(name="TaskTemplateID")
	private TaskTemplate tasktemplate1;

	//bi-directional many-to-one association to TaskTemplate
	@ManyToOne
	@JoinColumn(name="DependentTaskTemplateID")
	private TaskTemplate tasktemplate2;

	public TaskTemplateDependency() {
	}

	public int getTaskTemplateDependencyID() {
		return this.taskTemplateDependencyID;
	}

	public void setTaskTemplateDependencyID(int taskTemplateDependencyID) {
		this.taskTemplateDependencyID = taskTemplateDependencyID;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public TaskTemplate getTasktemplate1() {
		return this.tasktemplate1;
	}

	public void setTasktemplate1(TaskTemplate tasktemplate1) {
		this.tasktemplate1 = tasktemplate1;
	}

	public TaskTemplate getTasktemplate2() {
		return this.tasktemplate2;
	}

	public void setTasktemplate2(TaskTemplate tasktemplate2) {
		this.tasktemplate2 = tasktemplate2;
	}

}