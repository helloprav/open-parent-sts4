package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the applicationinstances database table.
 * 
 */
@Entity
@Table(name="ApplicationInstances")
@NamedQuery(name="ApplicationInstance.findAll", query="SELECT a FROM ApplicationInstance a")
public class ApplicationInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationInstanceID;

	private String applicationInstanceName;
	
	private String targetDisposition;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy="applicationinstance")
	private List<ApplicationComponentInstance> applicationcomponentinstances;

	//bi-directional many-to-one association to ApplicationInstanceRole
//	@OneToMany(mappedBy="applicationinstance")
//	private List<ApplicationInstanceRole> applicationinstanceroles;

	//bi-directional many-to-one association to Application
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to DiscoveryState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DiscoveryStateId")
	private DiscoveryState discoverystate;

	//bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CurrentDispositionID")
	private Disposition disposition1;

	/*//bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TargetDispositionID")
	private Disposition disposition2;*/

	//bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MigrationScopeID")
	private MigrationScope migrationscope;

	//bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MoveGroupID")
	private MoveGroup movegroup;

	//bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CurrentSLAID")
	private SLA sla1;

	//bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TargetSLAID")
	private SLA sla2;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BusinessOwnerID")
	private User businessOwner;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TechnicalOwnerID")
	private User technicalOwner;
	
	//bi-directional many-to-one association to TaskTracking
	//@OneToMany(mappedBy="applicationinstance")
	//private List<TaskTracking> tasktrackings;
	
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

	public ApplicationInstance() {
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

	public int getApplicationInstanceID() {
		return this.applicationInstanceID;
	}

	public void setApplicationInstanceID(int applicationInstanceID) {
		this.applicationInstanceID = applicationInstanceID;
	}

	public String getApplicationInstanceName() {
		return this.applicationInstanceName;
	}

	public void setApplicationInstanceName(String applicationInstanceName) {
		this.applicationInstanceName = applicationInstanceName;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances() {
		return this.applicationcomponentinstances;
	}

	public void setApplicationcomponentinstances(List<ApplicationComponentInstance> applicationcomponentinstances) {
		this.applicationcomponentinstances = applicationcomponentinstances;
	}

	public ApplicationComponentInstance addApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().add(applicationcomponentinstance);
		applicationcomponentinstance.setApplicationinstance(this);

		return applicationcomponentinstance;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().remove(applicationcomponentinstance);
		applicationcomponentinstance.setApplicationinstance(null);

		return applicationcomponentinstance;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public DiscoveryState getDiscoverystate() {
		return this.discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}

	public Disposition getDisposition1() {
		return this.disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public MigrationScope getMigrationscope() {
		return this.migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public MoveGroup getMovegroup() {
		return this.movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public SLA getSla1() {
		return this.sla1;
	}

	public void setSla1(SLA sla1) {
		this.sla1 = sla1;
	}

	public SLA getSla2() {
		return this.sla2;
	}

	public void setSla2(SLA sla2) {
		this.sla2 = sla2;
	}
	
	public User getBusinessOwner() {
		return businessOwner;
	}

	public void setBusinessOwner(User businessOwner) {
		this.businessOwner = businessOwner;
	}

	public User getTechnicalOwner() {
		return technicalOwner;
	}

	public void setTechnicalOwner(User technicalOwner) {
		this.technicalOwner = technicalOwner;
	}

	/*public List<TaskTracking> getTasktrackings() {
		return this.tasktrackings;
	}

	public void setTasktrackings(List<TaskTracking> tasktrackings) {
		this.tasktrackings = tasktrackings;
	}

	public TaskTracking addTasktracking(TaskTracking tasktracking) {
		getTasktrackings().add(tasktracking);
		tasktracking.setApplicationinstance(this);

		return tasktracking;
	}

	public TaskTracking removeTasktracking(TaskTracking tasktracking) {
		getTasktrackings().remove(tasktracking);
		tasktracking.setApplicationinstance(null);

		return tasktracking;
	}*/

}