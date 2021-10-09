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

/**
 * The persistent class for the taskattachments database table.
 * 
 */
@Entity
@Table(name = "TaskAttachments")
@NamedQuery(name = "TaskAttachment.findAll", query = "SELECT t FROM TaskAttachment t")
public class TaskAttachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskAttachmentId;

	private String identity;

	private String attachmentName;

	// bi-directional many-to-one association to Task
	@ManyToOne
	@JoinColumn(name = "TaskId")
	private Task task;

	public TaskAttachment() {
	}

	public int getTaskAttachmentId() {
		return this.taskAttachmentId;
	}

	public void setTaskAttachmentId(int taskAttachmentId) {
		this.taskAttachmentId = taskAttachmentId;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public Task getTask() {
		return this.task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}