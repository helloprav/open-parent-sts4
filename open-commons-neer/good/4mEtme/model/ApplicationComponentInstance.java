package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the applicationcomponentinstances database table.
 * 
 */
@Entity
@Table(name="ApplicationComponentInstances")
@NamedQuery(name="ApplicationComponentInstance.findAll", query="SELECT a FROM ApplicationComponentInstance a")
public class ApplicationComponentInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationComponentInstanceID;

	private String applicationComponentInstanceName;
	
	private String changeControlNumber;
	
	private String targetDisposition;
	
	//bi-directional many-to-one association to ApplicationComponentInstanceMaintenanceOperation
	@OneToMany(mappedBy="applicationcomponentinstance")
	private List<ApplicationComponentInstanceMaintenanceOperation> applicationcomponentinstancemaintenanceoperations;

	//bi-directional many-to-one association to ApplicationComponentInstanceMigrationMethod
//	@OneToMany(mappedBy="applicationcomponentinstance")
//	private List<ApplicationComponentInstanceMigrationMethod> applicationcomponentinstancemigrationmethods;

	//bi-directional many-to-one association to ApplicationComponentInstanceRole
//	@OneToMany(mappedBy="applicationcomponentinstance")
//	private List<ApplicationComponentInstanceRole> applicationcomponentinstanceroles;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationComponentID")
	private ApplicationComponent applicationcomponent;

	//bi-directional many-to-one association to ApplicationInstance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationInstanceID")
	private ApplicationInstance applicationinstance;

	//bi-directional many-to-one association to Environment
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="EnvironmentID")
	private Environment environment;

	//bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MigrationScopeID")
	private MigrationScope migrationscope;

	//bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MoveGroupID")
	private MoveGroup movegroup;

	//bi-directional many-to-one association to PaaS
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PaaSID")
	private PaaS paas1;

	//bi-directional many-to-one association to PaaS
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TargetPaaSID")
	private PaaS paas2;

	//bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CurrentSLAID")
	private SLA sla1;

	//bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TargetSLAID")
	private SLA sla2;

	//bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServerID")
	private Server server1;

	//bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TargetServerID")
	private Server server2;

	// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to
//	@OneToMany(mappedBy = "applicationcomponentinstance")
//	private List<ApplicationComponentInstanceTransformationMethod> applicationcomponentinstancetransformationmethods;

	//bi-directional many-to-one association to TaskTracking
	//@OneToMany(mappedBy="applicationcomponentinstance")
	//private List<TaskTracking> tasktrackings;
	
	// bi-directional many-to-one association to ChangeControlDecision
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ChangeControlDecisionID")
	private ChangeControlDecision changeControlDecision;
	
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

	public ApplicationComponentInstance() {
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

	public int getApplicationComponentInstanceID() {
		return this.applicationComponentInstanceID;
	}

	public void setApplicationComponentInstanceID(int applicationComponentInstanceID) {
		this.applicationComponentInstanceID = applicationComponentInstanceID;
	}

	public List<ApplicationComponentInstanceMaintenanceOperation> getApplicationcomponentinstancemaintenanceoperations() {
		return this.applicationcomponentinstancemaintenanceoperations;
	}

	public void setApplicationcomponentinstancemaintenanceoperations(List<ApplicationComponentInstanceMaintenanceOperation> applicationcomponentinstancemaintenanceoperations) {
		this.applicationcomponentinstancemaintenanceoperations = applicationcomponentinstancemaintenanceoperations;
	}

	public ApplicationComponentInstanceMaintenanceOperation addApplicationcomponentinstancemaintenanceoperation(ApplicationComponentInstanceMaintenanceOperation applicationcomponentinstancemaintenanceoperation) {
		getApplicationcomponentinstancemaintenanceoperations().add(applicationcomponentinstancemaintenanceoperation);
		applicationcomponentinstancemaintenanceoperation.setApplicationcomponentinstance(this);

		return applicationcomponentinstancemaintenanceoperation;
	}

	public ApplicationComponentInstanceMaintenanceOperation removeApplicationcomponentinstancemaintenanceoperation(ApplicationComponentInstanceMaintenanceOperation applicationcomponentinstancemaintenanceoperation) {
		getApplicationcomponentinstancemaintenanceoperations().remove(applicationcomponentinstancemaintenanceoperation);
		applicationcomponentinstancemaintenanceoperation.setApplicationcomponentinstance(null);

		return applicationcomponentinstancemaintenanceoperation;
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

	public Environment getEnvironment() {
		return this.environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
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

	public PaaS getPaas1() {
		return this.paas1;
	}

	public void setPaas1(PaaS paas1) {
		this.paas1 = paas1;
	}

	public PaaS getPaas2() {
		return this.paas2;
	}

	public void setPaas2(PaaS paas2) {
		this.paas2 = paas2;
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

	public Server getServer1() {
		return this.server1;
	}

	public void setServer1(Server server1) {
		this.server1 = server1;
	}

	public Server getServer2() {
		return this.server2;
	}

	public void setServer2(Server server2) {
		this.server2 = server2;
	}

	public Disposition getDisposition1() {
		return disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public String getApplicationComponentInstanceName() {
		return applicationComponentInstanceName;
	}

	public void setApplicationComponentInstanceName(String applicationComponentInstanceName) {
		this.applicationComponentInstanceName = applicationComponentInstanceName;
	}

	public String getChangeControlNumber() {
		return changeControlNumber;
	}

	public void setChangeControlNumber(String changeControlNumber) {
		this.changeControlNumber = changeControlNumber;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public ChangeControlDecision getChangeControlDecision() {
		return changeControlDecision;
	}

	public void setChangeControlDecision(ChangeControlDecision changeControlDecision) {
		this.changeControlDecision = changeControlDecision;
	}

}