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


/**
 * The persistent class for the ApplicationComponentHistory database table.
 * 
 */
@Entity
@Table(name="ApplicationComponentHistory")
@NamedQuery(name="ApplicationComponentHistory.findAll", query="SELECT ach FROM ApplicationComponentHistory ach")
public class ApplicationComponentHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationComponentHistoryID;

	private int versionNumber;
	private String applicationComponentName;
	private String description;
	private String targetDisposition;
	private String customField1;
	private String customField2;
	private String customField3;
	
	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne
	@JoinColumn(name="ApplicationComponentID")
	private ApplicationComponent applicationComponent;
	
	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;
	
	//bi-directional many-to-one association to MoveGroup
	@ManyToOne
	@JoinColumn(name="MoveGroupID")
	private MoveGroup movegroup;

	// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/
	
	@ManyToOne
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public ApplicationComponentHistory() {
		super();
	}

	public int getApplicationComponentHistoryID() {
		return applicationComponentHistoryID;
	}

	public void setApplicationComponentHistoryID(int applicationComponentHistoryID) {
		this.applicationComponentHistoryID = applicationComponentHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getApplicationComponentName() {
		return applicationComponentName;
	}

	public void setApplicationComponentName(String applicationComponentName) {
		this.applicationComponentName = applicationComponentName;
	}

	public String getDescription() {
		return description;
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

	public ApplicationComponent getApplicationComponent() {
		return applicationComponent;
	}

	public void setApplicationComponent(ApplicationComponent applicationComponent) {
		this.applicationComponent = applicationComponent;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
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
	
}
