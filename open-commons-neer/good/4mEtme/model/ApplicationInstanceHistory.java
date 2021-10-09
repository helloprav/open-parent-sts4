package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "ApplicationInstanceHistory")
@NamedQuery(name = "ApplicationInstanceHistory.findAll", query = "SELECT aih FROM ApplicationInstanceHistory aih")
public class ApplicationInstanceHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationInstanceHistoryID;

	private int versionNumber;
	private String applicationInstanceName;
	private String targetDisposition;
	private Date lastUpdatedDate;
	private Date creationDate;

	// bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name = "ApplicationInstanceID")
	private ApplicationInstance applicationInstance;

	// bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name = "ApplicationID")
	private Application application;

	@ManyToOne
	@JoinColumn(name = "DiscoveryStateID")
	private DiscoveryState discoverystate;

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;

	// bi-directional many-to-one association to BusinessOwner
	@ManyToOne
	@JoinColumn(name = "BusinessOwnerID")
	private User businessOwner;

	// bi-directional many-to-one association to TechnicalOwner
	@ManyToOne
	@JoinColumn(name = "TechnicalOwnerID")
	private User TechnicalOwner;

	// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	//bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name="CurrentSLAID")
	private SLA sla1;

	//bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name="TargetSLAID")
	private SLA sla2;

	@ManyToOne
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;

	@ManyToOne
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	@ManyToOne
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public ApplicationInstanceHistory() {
		super();
	}

	public int getApplicationInstanceHistoryID() {
		return applicationInstanceHistoryID;
	}

	public void setApplicationInstanceHistoryID(int applicationInstanceHistoryID) {
		this.applicationInstanceHistoryID = applicationInstanceHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getApplicationInstanceName() {
		return applicationInstanceName;
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

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public ApplicationInstance getApplicationInstance() {
		return applicationInstance;
	}

	public void setApplicationInstance(ApplicationInstance applicationInstance) {
		this.applicationInstance = applicationInstance;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public DiscoveryState getDiscoverystate() {
		return discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}

	public MigrationScope getMigrationscope() {
		return migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public User getBusinessOwner() {
		return businessOwner;
	}

	public void setBusinessOwner(User businessOwner) {
		this.businessOwner = businessOwner;
	}

	public User getTechnicalOwner() {
		return TechnicalOwner;
	}

	public void setTechnicalOwner(User technicalOwner) {
		TechnicalOwner = technicalOwner;
	}

	public Disposition getDisposition1() {
		return disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public MoveGroup getMovegroup() {
		return movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
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

}
