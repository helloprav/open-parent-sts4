package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the operationalservices database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="OperationalServices")
@NamedQuery(name="OperationalService.findAll", query="SELECT o FROM OperationalService o")
public class OperationalService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int operationalServiceID;

	private String description;

	private String isMigrating;

	private String operationalServiceName;

	//bi-directional many-to-one association to ApplicationOperationalService
	@OneToMany(mappedBy="operationalservice")
	private List<ApplicationOperationalService> applicationoperationalservices;

	//bi-directional many-to-one association to TaskTracking
	//@OneToMany(mappedBy="operationalservice")
	//private List<TaskTracking> tasktrackings;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public OperationalService() {
	}

	public TemplateUpload getTemplateUpload() {
		return templateUpload;
	}

	public void setTemplateUpload(TemplateUpload templateUpload) {
		this.templateUpload = templateUpload;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public User getLastUpdatedByUser() {
		return lastUpdatedByUser;
	}

	public void setLastUpdatedByUser(User lastUpdatedByUser) {
		this.lastUpdatedByUser = lastUpdatedByUser;
	}

	public int getOperationalServiceID() {
		return this.operationalServiceID;
	}

	public void setOperationalServiceID(int operationalServiceID) {
		this.operationalServiceID = operationalServiceID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsMigrating() {
		return this.isMigrating;
	}

	public void setIsMigrating(String isMigrating) {
		this.isMigrating = isMigrating;
	}

	public String getOperationalServiceName() {
		return this.operationalServiceName;
	}

	public void setOperationalServiceName(String operationalServiceName) {
		this.operationalServiceName = operationalServiceName;
	}

	public List<ApplicationOperationalService> getApplicationoperationalservices() {
		return this.applicationoperationalservices;
	}

	public void setApplicationoperationalservices(List<ApplicationOperationalService> applicationoperationalservices) {
		this.applicationoperationalservices = applicationoperationalservices;
	}

	public ApplicationOperationalService addApplicationoperationalservice(ApplicationOperationalService applicationoperationalservice) {
		getApplicationoperationalservices().add(applicationoperationalservice);
		applicationoperationalservice.setOperationalservice(this);

		return applicationoperationalservice;
	}

	public ApplicationOperationalService removeApplicationoperationalservice(ApplicationOperationalService applicationoperationalservice) {
		getApplicationoperationalservices().remove(applicationoperationalservice);
		applicationoperationalservice.setOperationalservice(null);

		return applicationoperationalservice;
	}

	/*public List<TaskTracking> getTasktrackings() {
		return this.tasktrackings;
	}

	public void setTasktrackings(List<TaskTracking> tasktrackings) {
		this.tasktrackings = tasktrackings;
	}

	public TaskTracking addTasktracking(TaskTracking tasktracking) {
		getTasktrackings().add(tasktracking);
		tasktracking.setOperationalservice(this);

		return tasktracking;
	}

	public TaskTracking removeTasktracking(TaskTracking tasktracking) {
		getTasktrackings().remove(tasktracking);
		tasktracking.setOperationalservice(null);

		return tasktracking;
	}*/

}