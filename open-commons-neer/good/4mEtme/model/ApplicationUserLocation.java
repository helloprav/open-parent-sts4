package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ApplicationUserLocations database table.
 * 
 */
@Entity
@Table(name="ApplicationUserLocations")
@NamedQuery(name="ApplicationUserLocation.findAll", query="SELECT a FROM ApplicationUserLocation a")
public class ApplicationUserLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationUserLocationID;

	private String notes;

	private int userCount;

	//bi-directional many-to-one association to Application
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to GeographicLocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="GeographicLocationID")
	private GeographicLocation geographiclocation;
	
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

	public ApplicationUserLocation() {
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

	public int getApplicationUserLocationID() {
		return this.applicationUserLocationID;
	}

	public void setApplicationUserLocationID(int applicationUserLocationID) {
		this.applicationUserLocationID = applicationUserLocationID;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getUserCount() {
		return this.userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
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