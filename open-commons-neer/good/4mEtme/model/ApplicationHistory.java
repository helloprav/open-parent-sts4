package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the applications database table.
 * 
 */
@Entity
@Table(name = "ApplicationHistory")
@NamedQuery(name = "ApplicationHistory.findAll", query = "SELECT a FROM Application a")
public class ApplicationHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationHistoryID;

	private int versionNumber;
	private String applicationName;
	private String businessUseDescription;
	private String designDocumentationLink;
	private String notes;
	private String changeControlNumber;
	private String targetDisposition;
	private String customField1;
	private String customField2;
	private String customField3;
	

	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	// bi-directional many-to-one association to BusinessService
	@ManyToOne
	@JoinColumn(name = "BusinessServiceID")
	private BusinessService businessservice;

	// bi-directional many-to-one association to DiscoveryState
	@ManyToOne
	@JoinColumn(name = "DiscoveryStateId")
	private DiscoveryState discoverystate;

	// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MigrationComplexity
	@ManyToOne
	@JoinColumn(name = "MigrationComplexityID")
	private MigrationComplexity migrationcomplexity;

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	// bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name = "CurrentSLAID")
	private SLA sla1;

	// bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name = "TargetSLAID")
	private SLA sla2;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "BusinessOwnerID")
	private User businessOwner;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "TechnicalOwnerID")
	private User technicalOwner;

	// bi-directional many-to-one association to ChangeControlDecision
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ChangeControlDecisionID")
	private ChangeControlDecision changeControlDecision;
	
	// bi-directional many-to-one association to BusinessCriticality
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BusinessCriticalityID")
	private BusinessCriticality businessCriticality;
	
	@ManyToOne
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;

	public ChangeControlDecision getChangeControlDecision() {
		return changeControlDecision;
	}

	public void setChangeControlDecision(ChangeControlDecision changeControlDecision) {
		this.changeControlDecision = changeControlDecision;
	}

	public BusinessCriticality getBusinessCriticality() {
		return businessCriticality;
	}

	public void setBusinessCriticality(BusinessCriticality businessCriticality) {
		this.businessCriticality = businessCriticality;
	}

	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public ApplicationHistory() {
		super();
	}

	public int getApplicationHistoryID() {
		return applicationHistoryID;
	}

	public void setApplicationHistoryID(int applicationHistoryID) {
		this.applicationHistoryID = applicationHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getBusinessUseDescription() {
		return businessUseDescription;
	}

	public void setBusinessUseDescription(String businessUseDescription) {
		this.businessUseDescription = businessUseDescription;
	}

	public String getDesignDocumentationLink() {
		return designDocumentationLink;
	}

	public void setDesignDocumentationLink(String designDocumentationLink) {
		this.designDocumentationLink = designDocumentationLink;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public BusinessService getBusinessservice() {
		return businessservice;
	}

	public void setBusinessservice(BusinessService businessservice) {
		this.businessservice = businessservice;
	}

	public DiscoveryState getDiscoverystate() {
		return discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}

	public Disposition getDisposition1() {
		return disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public MigrationComplexity getMigrationcomplexity() {
		return migrationcomplexity;
	}

	public void setMigrationcomplexity(MigrationComplexity migrationcomplexity) {
		this.migrationcomplexity = migrationcomplexity;
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
	
	public String getChangeControlNumber() {
		return changeControlNumber;
	}

	public void setChangeControlNumber(String changeControlNumber) {
		this.changeControlNumber = changeControlNumber;
	}
	
}