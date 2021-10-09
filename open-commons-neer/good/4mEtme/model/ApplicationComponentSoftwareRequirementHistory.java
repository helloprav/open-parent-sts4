package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the AppComponentSoftwareRequirementHistory database table.
 * 
 */
@Entity
@Table(name="AppComponentSoftwareRequirementHistory")
@NamedQuery(name="ApplicationComponentSoftwareRequirementHistory.findAll", query="SELECT acsrh FROM ApplicationComponentSoftwareRequirementHistory acsrh")
public class ApplicationComponentSoftwareRequirementHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appComponentSoftwareRequirementhistoryID;
	private int versionNumber;
	private int applicationComponentSoftwareRequirementID;
	

	//bi-directional many-to-one association to ApplicationComponentSoftwareRequirement
	@ManyToOne
	@JoinColumn(name="ApplicationComponentSoftwareRequirementID")
	private ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement;
	
	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne
	@JoinColumn(name="ApplicationComnponentID")
	private ApplicationComponent applicationcomponent;

	//bi-directional many-to-one association to SoftwareVersion
	@ManyToOne
	@JoinColumn(name="SoftwareVersionID")
	private SoftwareVersion softwareversion;
	
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
	
	public ApplicationComponentSoftwareRequirementHistory() {
	}

	public int getAppComponentSoftwareRequirementhistoryID() {
		return appComponentSoftwareRequirementhistoryID;
	}

	public void setAppComponentSoftwareRequirementhistoryID(
			int appComponentSoftwareRequirementhistoryID) {
		this.appComponentSoftwareRequirementhistoryID = appComponentSoftwareRequirementhistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getApplicationComponentSoftwareRequirementID() {
		return applicationComponentSoftwareRequirementID;
	}

	public void setApplicationComponentSoftwareRequirementID(
			int applicationComponentSoftwareRequirementID) {
		this.applicationComponentSoftwareRequirementID = applicationComponentSoftwareRequirementID;
	}

	public ApplicationComponentSoftwareRequirement getApplicationComponentSoftwareRequirement() {
		return applicationComponentSoftwareRequirement;
	}

	public void setApplicationComponentSoftwareRequirement(
			ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement) {
		this.applicationComponentSoftwareRequirement = applicationComponentSoftwareRequirement;
	}

	public ApplicationComponent getApplicationcomponent() {
		return applicationcomponent;
	}

	public void setApplicationcomponent(ApplicationComponent applicationcomponent) {
		this.applicationcomponent = applicationcomponent;
	}

	public SoftwareVersion getSoftwareversion() {
		return softwareversion;
	}

	public void setSoftwareversion(SoftwareVersion softwareversion) {
		this.softwareversion = softwareversion;
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