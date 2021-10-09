package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the geographiclocations database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="GeographicLocations")
@NamedQuery(name="GeographicLocation.findAll", query="SELECT g FROM GeographicLocation g")
public class GeographicLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int geographicLocationID;

	private String geographicLocationName;

	//bi-directional many-to-one association to ApplicationDataRestriction
	@OneToMany(mappedBy="geographiclocation")
	private List<ApplicationDataRestriction> applicationdatarestrictions;

	//bi-directional many-to-one association to ApplicationUserLocation
	@OneToMany(mappedBy="geographiclocation")
	private List<ApplicationUserLocation> applicationuserlocations;
	
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

	public GeographicLocation() {
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

	public int getGeographicLocationID() {
		return this.geographicLocationID;
	}

	public void setGeographicLocationID(int geographicLocationID) {
		this.geographicLocationID = geographicLocationID;
	}

	public String getGeographicLocationName() {
		return this.geographicLocationName;
	}

	public void setGeographicLocationName(String geographicLocationName) {
		this.geographicLocationName = geographicLocationName;
	}

	public List<ApplicationDataRestriction> getApplicationdatarestrictions() {
		return this.applicationdatarestrictions;
	}

	public void setApplicationdatarestrictions(List<ApplicationDataRestriction> applicationdatarestrictions) {
		this.applicationdatarestrictions = applicationdatarestrictions;
	}

	public ApplicationDataRestriction addApplicationdatarestriction(ApplicationDataRestriction applicationdatarestriction) {
		getApplicationdatarestrictions().add(applicationdatarestriction);
		applicationdatarestriction.setGeographiclocation(this);

		return applicationdatarestriction;
	}

	public ApplicationDataRestriction removeApplicationdatarestriction(ApplicationDataRestriction applicationdatarestriction) {
		getApplicationdatarestrictions().remove(applicationdatarestriction);
		applicationdatarestriction.setGeographiclocation(null);

		return applicationdatarestriction;
	}

	public List<ApplicationUserLocation> getApplicationuserlocations() {
		return this.applicationuserlocations;
	}

	public void setApplicationuserlocations(List<ApplicationUserLocation> applicationuserlocations) {
		this.applicationuserlocations = applicationuserlocations;
	}

	public ApplicationUserLocation addApplicationuserlocation(ApplicationUserLocation applicationuserlocation) {
		getApplicationuserlocations().add(applicationuserlocation);
		applicationuserlocation.setGeographiclocation(this);

		return applicationuserlocation;
	}

	public ApplicationUserLocation removeApplicationuserlocation(ApplicationUserLocation applicationuserlocation) {
		getApplicationuserlocations().remove(applicationuserlocation);
		applicationuserlocation.setGeographiclocation(null);

		return applicationuserlocation;
	}

}