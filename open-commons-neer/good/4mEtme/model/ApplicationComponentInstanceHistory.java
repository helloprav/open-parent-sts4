package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the ApplicationComponentInstanceHistory database
 * table.
 * 
 */
@Entity
@Table(name = "ApplicationComponentInstanceHistory")
@NamedQuery(name = "ApplicationComponentInstanceHistory.findAll", query = "SELECT acih FROM ApplicationComponentInstanceHistory acih")
public class ApplicationComponentInstanceHistory implements Serializable {

	public ApplicationComponentInstanceHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationComponentInstanceHistoryID;
	private int versionNumber;
	private String applicationComponentInstanceName;
	
	private String targetDisposition;
	private Date creationDate;
	private Date lastUpdatedDate;
	private String changeControlNumber;

	
	// bi-directional many-to-one association to ApplicationComponentInstance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ApplicationComponentInstanceID")
	private ApplicationComponentInstance applicationComponentInstance;

	// bi-directional many-to-one association to ApplicationComponent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ApplicationComponentID")
	private ApplicationComponent applicationcomponent;

	// bi-directional many-to-one association to ApplicationInstance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ApplicationInstanceID")
	private ApplicationInstance applicationinstance;

	// bi-directional many-to-one association to Environment
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "EnvironmentID")
	private Environment environment;

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;

	//bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	// bi-directional many-to-one association to PaaS
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PaaSID")
	private PaaS paas1;

	// bi-directional many-to-one association to PaaS
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetPaaSID")
	private PaaS paas2;

	// bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentSLAID")
	private SLA sla1;

	// bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetSLAID")
	private SLA sla2;

	// bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ServerID")
	private Server server1;

	// bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetServerID")
	private Server server2;

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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	// bi-directional many-to-one association to ChangeControlDecision
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ChangeControlDecisionID")
	private ChangeControlDecision changeControlDecision;
	
	
	public int getApplicationComponentInstanceHistoryID() {
		return applicationComponentInstanceHistoryID;
	}

	public void setApplicationComponentInstanceHistoryID(
			int applicationComponentInstanceHistoryID) {
		this.applicationComponentInstanceHistoryID = applicationComponentInstanceHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getApplicationComponentInstanceName() {
		return applicationComponentInstanceName;
	}

	public void setApplicationComponentInstanceName(
			String applicationComponentInstanceName) {
		this.applicationComponentInstanceName = applicationComponentInstanceName;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public ApplicationComponentInstance getApplicationcomponentinstance() {
		return applicationComponentInstance;
	}

	public void setApplicationcomponentinstance(
			ApplicationComponentInstance applicationcomponentinstance) {
		this.applicationComponentInstance = applicationcomponentinstance;
	}

	public ApplicationComponent getApplicationcomponent() {
		return applicationcomponent;
	}

	public void setApplicationcomponent(ApplicationComponent applicationcomponent) {
		this.applicationcomponent = applicationcomponent;
	}

	public ApplicationInstance getApplicationinstance() {
		return applicationinstance;
	}

	public void setApplicationinstance(ApplicationInstance applicationinstance) {
		this.applicationinstance = applicationinstance;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public MigrationScope getMigrationscope() {
		return migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public MoveGroup getMovegroup() {
		return movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public PaaS getPaas1() {
		return paas1;
	}

	public void setPaas1(PaaS paas1) {
		this.paas1 = paas1;
	}

	public PaaS getPaas2() {
		return paas2;
	}

	public void setPaas2(PaaS paas2) {
		this.paas2 = paas2;
	}

	public SLA getSla1() {
		return sla1;
	}

	public void setSla1(SLA sla1) {
		this.sla1 = sla1;
	}

	public SLA getSla2() {
		return sla2;
	}

	public void setSla2(SLA sla2) {
		this.sla2 = sla2;
	}

	public Server getServer1() {
		return server1;
	}

	public void setServer1(Server server1) {
		this.server1 = server1;
	}

	public Server getServer2() {
		return server2;
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

	public TemplateUpload getTemplateUpload() {
		return templateUpload;
	}

	public void setTemplateUpload(TemplateUpload templateUpload) {
		this.templateUpload = templateUpload;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public User getLastUpdatedByUser() {
		return lastUpdatedByUser;
	}

	public void setLastUpdatedByUser(User lastUpdatedByUser) {
		this.lastUpdatedByUser = lastUpdatedByUser;
	}

	public String getChangeControlNumber() {
		return changeControlNumber;
	}

	public void setChangeControlNumber(String changeControlNumber) {
		this.changeControlNumber = changeControlNumber;
	}

	public ChangeControlDecision getChangeControlDecision() {
		return changeControlDecision;
	}

	public void setChangeControlDecision(ChangeControlDecision changeControlDecision) {
		this.changeControlDecision = changeControlDecision;
	}


}