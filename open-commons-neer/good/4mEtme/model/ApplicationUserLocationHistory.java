package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ApplicationUserLocations database table.
 * 
 */
@Entity
@Table(name="ApplicationUserLocationHistory")
@NamedQuery(name="ApplicationUserLocationHistory.findAll", query="SELECT a FROM ApplicationUserLocationHistory a")
public class ApplicationUserLocationHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int applicationUserLocationHistoryID;
	private int versionNumber;
    public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	private String notes;
    private int userCount;

	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationUserLocationID")
	private ApplicationUserLocation applicationUserLocation;
	
	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to GeographicLocation
	@ManyToOne
	@JoinColumn(name="GeographicLocationID")
	private GeographicLocation geographiclocation;
	
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public ApplicationUserLocationHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getApplicationUserLocationHistoryID() {
		return applicationUserLocationHistoryID;
	}

	public void setApplicationUserLocationHistoryID(
			int applicationUserLocationHistoryID) {
		this.applicationUserLocationHistoryID = applicationUserLocationHistoryID;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public ApplicationUserLocation getApplicationUserLocation() {
		return applicationUserLocation;
	}

	public void setApplicationUserLocation(
			ApplicationUserLocation applicationUserLocation) {
		this.applicationUserLocation = applicationUserLocation;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public GeographicLocation getGeographiclocation() {
		return geographiclocation;
	}

	public void setGeographiclocation(GeographicLocation geographiclocation) {
		this.geographiclocation = geographiclocation;
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