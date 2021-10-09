package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tasktracking database table.
 * 
 */
@Entity
@NamedQuery(name="TaskTracking.findAll", query="SELECT t FROM TaskTracking t")
public class TaskTracking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTrackingID;

	@Temporal(TemporalType.DATE)
	private Date dueDate;

	private String notes;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@ManyToOne
	@JoinColumn(name="ApplicationComponentInstanceID")
	private ApplicationComponentInstance applicationcomponentinstance;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne
	@JoinColumn(name="ApplicationComponentID")
	private ApplicationComponent applicationcomponent;

	//bi-directional many-to-one association to ApplicationInstance
	@ManyToOne
	@JoinColumn(name="ApplicationInstanceID")
	private ApplicationInstance applicationinstance;

	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to BusinessService
	@ManyToOne
	@JoinColumn(name="BusinessServiceID")
	private BusinessService businessservice;

	//bi-directional many-to-one association to OperationalService
	@ManyToOne
	@JoinColumn(name="OperationalServiceID")
	private OperationalService operationalservice;

	//bi-directional many-to-one association to Server
	@ManyToOne
	@JoinColumn(name="ServerID")
	private Server server;

	//bi-directional many-to-one association to TaskTemplate
	@ManyToOne
	@JoinColumn(name="TemplateTaskID")
	private TaskTemplate tasktemplate;

	//bi-directional many-to-one association to TaskTrackingStatusUser
	@OneToMany(mappedBy="tasktracking")
	private List<TaskTrackingStatusUser> tasktrackingstatususers;

	public TaskTracking() {
	}

	public int getTaskTrackingID() {
		return this.taskTrackingID;
	}

	public void setTaskTrackingID(int taskTrackingID) {
		this.taskTrackingID = taskTrackingID;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public ApplicationComponentInstance getApplicationcomponentinstance() {
		return this.applicationcomponentinstance;
	}

	public void setApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		this.applicationcomponentinstance = applicationcomponentinstance;
	}

	public ApplicationComponent getApplicationcomponent() {
		return this.applicationcomponent;
	}

	public void setApplicationcomponent(ApplicationComponent applicationcomponent) {
		this.applicationcomponent = applicationcomponent;
	}

	public ApplicationInstance getApplicationinstance() {
		return this.applicationinstance;
	}

	public void setApplicationinstance(ApplicationInstance applicationinstance) {
		this.applicationinstance = applicationinstance;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public BusinessService getBusinessservice() {
		return this.businessservice;
	}

	public void setBusinessservice(BusinessService businessservice) {
		this.businessservice = businessservice;
	}

	public OperationalService getOperationalservice() {
		return this.operationalservice;
	}

	public void setOperationalservice(OperationalService operationalservice) {
		this.operationalservice = operationalservice;
	}

	public Server getServer() {
		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public TaskTemplate getTasktemplate() {
		return this.tasktemplate;
	}

	public void setTasktemplate(TaskTemplate tasktemplate) {
		this.tasktemplate = tasktemplate;
	}

	public List<TaskTrackingStatusUser> getTasktrackingstatususers() {
		return this.tasktrackingstatususers;
	}

	public void setTasktrackingstatususers(List<TaskTrackingStatusUser> tasktrackingstatususers) {
		this.tasktrackingstatususers = tasktrackingstatususers;
	}

	public TaskTrackingStatusUser addTasktrackingstatususer(TaskTrackingStatusUser tasktrackingstatususer) {
		getTasktrackingstatususers().add(tasktrackingstatususer);
		tasktrackingstatususer.setTasktracking(this);

		return tasktrackingstatususer;
	}

	public TaskTrackingStatusUser removeTasktrackingstatususer(TaskTrackingStatusUser tasktrackingstatususer) {
		getTasktrackingstatususers().remove(tasktrackingstatususer);
		tasktrackingstatususer.setTasktracking(null);

		return tasktrackingstatususer;
	}

}