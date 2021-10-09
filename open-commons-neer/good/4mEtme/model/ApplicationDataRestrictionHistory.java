package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ApplicationDataRestrictionHistory database table.
 * 
 */
@Entity
@Table(name="ApplicationDataRestrictionHistory")
@NamedQuery(name="ApplicationDataRestrictionHistory.findAll", query="SELECT a FROM ApplicationDataRestrictionHistory a")
public class ApplicationDataRestrictionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int versionNumber;
	private int applicationRestrictionHistoryID;
    private String locationForbidden;
    private String locationMandatory;
    private String locationOptional;

  //bi-directional many-to-one association to Application
  	@ManyToOne
  	@JoinColumn(name="applicationRestrictionID")
  	private ApplicationDataRestriction applicationDataRestriction;
    
    //bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to GeographicLocation
	@ManyToOne
	@JoinColumn(name="GeographicLocationID")
	private GeographicLocation geographiclocation;
	
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

	public ApplicationDataRestrictionHistory() {
	}

	public ApplicationDataRestriction getApplicationDataRestrictionID() {
		return applicationDataRestriction;
	}

	public void setApplicationDataRestrictionID(
			ApplicationDataRestriction applicationDataRestriction) {
		this.applicationDataRestriction = applicationDataRestriction;
	}
	
	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getApplicationRestrictionHistoryID() {
		return applicationRestrictionHistoryID;
	}

	public void setApplicationRestrictionHistoryID(
			int applicationRestrictionHistoryID) {
		this.applicationRestrictionHistoryID = applicationRestrictionHistoryID;
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

	public String getLocationForbidden() {
		return this.locationForbidden;
	}

	public void setLocationForbidden(String locationForbidden) {
		this.locationForbidden = locationForbidden;
	}

	public String getLocationMandatory() {
		return this.locationMandatory;
	}

	public void setLocationMandatory(String locationMandatory) {
		this.locationMandatory = locationMandatory;
	}

	public String getLocationOptional() {
		return this.locationOptional;
	}

	public void setLocationOptional(String locationOptional) {
		this.locationOptional = locationOptional;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public GeographicLocation getGeographiclocation() {
		return this.geographiclocation;
	}

	public void setGeographiclocation(GeographicLocation geographiclocation) {
		this.geographiclocation = geographiclocation;
	}

}