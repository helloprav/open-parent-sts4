package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ApplicationComponents database table.
 * 
 */
@Entity
@Table(name="ApplicationComponents")
@NamedQuery(name="ApplicationComponent.findAll", query="SELECT a FROM ApplicationComponent a")
public class ApplicationComponent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationComponentID;

	private String applicationComponentName;
	private String description;
	private String targetDisposition;
	private String customField1;
	private String customField2;
	private String customField3;
	
	//bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy="applicationcomponent")
	private List<ApplicationComponentInstance> applicationcomponentinstances;

	//bi-directional many-to-one association to ApplicationComponentRole
//	@OneToMany(mappedBy="applicationcomponent")
//	private List<ApplicationComponentRole> applicationcomponentroles;

	//bi-directional many-to-one association to Application
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationID")
	private Application application;

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;
	
	//bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MoveGroupID")
	private MoveGroup movegroup;

	//bi-directional many-to-one association to ApplicationComponentSoftwareRequirement
	@OneToMany(mappedBy="applicationcomponent")
	private List<ApplicationComponentSoftwareRequirement> applicationcomponentsoftwarerequirements;

	//bi-directional many-to-one association to LogicalDataLink
	@OneToMany(mappedBy="applicationcomponent1")
	private List<LogicalDataLink> logicaldatalinks1;

	//bi-directional many-to-one association to LogicalDataLink
	@OneToMany(mappedBy="applicationcomponent2")
	private List<LogicalDataLink> logicaldatalinks2;

	//bi-directional many-to-one association to TaskTracking
	//@OneToMany(mappedBy="applicationcomponent")
	//private List<TaskTracking> tasktrackings;

	// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public ApplicationComponent() {
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

	public int getApplicationComponentID() {
		return this.applicationComponentID;
	}

	public void setApplicationComponentID(int applicationComponentID) {
		this.applicationComponentID = applicationComponentID;
	}

	public String getApplicationComponentName() {
		return this.applicationComponentName;
	}

	public void setApplicationComponentName(String applicationComponentName) {
		this.applicationComponentName = applicationComponentName;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public String getCustomField1() {
		return customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getCustomField2() {
		return customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

	public String getCustomField3() {
		return customField3;
	}

	public void setCustomField3(String customField3) {
		this.customField3 = customField3;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances() {
		return this.applicationcomponentinstances;
	}

	public void setApplicationcomponentinstances(List<ApplicationComponentInstance> applicationcomponentinstances) {
		this.applicationcomponentinstances = applicationcomponentinstances;
	}

	public ApplicationComponentInstance addApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().add(applicationcomponentinstance);
		applicationcomponentinstance.setApplicationcomponent(this);

		return applicationcomponentinstance;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().remove(applicationcomponentinstance);
		applicationcomponentinstance.setApplicationcomponent(null);

		return applicationcomponentinstance;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public MoveGroup getMovegroup() {
		return this.movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public MigrationScope getMigrationscope() {
		return migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public Disposition getDisposition1() {
		return this.disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}
	
	public List<ApplicationComponentSoftwareRequirement> getApplicationcomponentsoftwarerequirements() {
		return this.applicationcomponentsoftwarerequirements;
	}

	public void setApplicationcomponentsoftwarerequirements(List<ApplicationComponentSoftwareRequirement> applicationcomponentsoftwarerequirements) {
		this.applicationcomponentsoftwarerequirements = applicationcomponentsoftwarerequirements;
	}

	public ApplicationComponentSoftwareRequirement addApplicationcomponentsoftwarerequirement(ApplicationComponentSoftwareRequirement applicationcomponentsoftwarerequirement) {
		getApplicationcomponentsoftwarerequirements().add(applicationcomponentsoftwarerequirement);
		applicationcomponentsoftwarerequirement.setApplicationcomponent(this);

		return applicationcomponentsoftwarerequirement;
	}

	public ApplicationComponentSoftwareRequirement removeApplicationcomponentsoftwarerequirement(ApplicationComponentSoftwareRequirement applicationcomponentsoftwarerequirement) {
		getApplicationcomponentsoftwarerequirements().remove(applicationcomponentsoftwarerequirement);
		applicationcomponentsoftwarerequirement.setApplicationcomponent(null);

		return applicationcomponentsoftwarerequirement;
	}

	public List<LogicalDataLink> getLogicaldatalinks1() {
		return this.logicaldatalinks1;
	}

	public void setLogicaldatalinks1(List<LogicalDataLink> logicaldatalinks1) {
		this.logicaldatalinks1 = logicaldatalinks1;
	}

	public LogicalDataLink addLogicaldatalinks1(LogicalDataLink logicaldatalinks1) {
		getLogicaldatalinks1().add(logicaldatalinks1);
		logicaldatalinks1.setApplicationcomponent1(this);

		return logicaldatalinks1;
	}

	public LogicalDataLink removeLogicaldatalinks1(LogicalDataLink logicaldatalinks1) {
		getLogicaldatalinks1().remove(logicaldatalinks1);
		logicaldatalinks1.setApplicationcomponent1(null);

		return logicaldatalinks1;
	}

	public List<LogicalDataLink> getLogicaldatalinks2() {
		return this.logicaldatalinks2;
	}

	public void setLogicaldatalinks2(List<LogicalDataLink> logicaldatalinks2) {
		this.logicaldatalinks2 = logicaldatalinks2;
	}

	public LogicalDataLink addLogicaldatalinks2(LogicalDataLink logicaldatalinks2) {
		getLogicaldatalinks2().add(logicaldatalinks2);
		logicaldatalinks2.setApplicationcomponent2(this);

		return logicaldatalinks2;
	}

	public LogicalDataLink removeLogicaldatalinks2(LogicalDataLink logicaldatalinks2) {
		getLogicaldatalinks2().remove(logicaldatalinks2);
		logicaldatalinks2.setApplicationcomponent2(null);

		return logicaldatalinks2;
	}

	/*public List<TaskTracking> getTasktrackings() {
		return this.tasktrackings;
	}

	public void setTasktrackings(List<TaskTracking> tasktrackings) {
		this.tasktrackings = tasktrackings;
	}

	public TaskTracking addTasktracking(TaskTracking tasktracking) {
		getTasktrackings().add(tasktracking);
		tasktracking.setApplicationcomponent(this);

		return tasktracking;
	}

	public TaskTracking removeTasktracking(TaskTracking tasktracking) {
		getTasktrackings().remove(tasktracking);
		tasktracking.setApplicationcomponent(null);

		return tasktracking;
	}*/

}