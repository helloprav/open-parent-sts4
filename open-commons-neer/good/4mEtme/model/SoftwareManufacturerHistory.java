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
@Table(name = "SoftwareManufacturerHistory")
@NamedQuery(name = "SoftwareManufacturerHistory.findAll", query = "SELECT s FROM SoftwareManufacturerHistory s")
public class SoftwareManufacturerHistory implements Serializable {
	
	private static final long serialVersionUID = 6825166804638960757L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int softwareManufacturerHistoryID;
	
	private int versionNumber;
	
	private String contactDetails;

	private String preferredSupplier;

	private String softwareManufacturerName;
	
	@ManyToOne
	@JoinColumn(name = "SoftwareManufacturerID")
	private SoftwareManufacturer softwareManufacturer;
	
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
	
	public SoftwareManufacturerHistory(){
		
	}

	public int getSoftwareManufacturerHistoryID() {
		return softwareManufacturerHistoryID;
	}

	public void setSoftwareManufacturerHistoryID(int softwareManufacturerHistoryID) {
		this.softwareManufacturerHistoryID = softwareManufacturerHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public SoftwareManufacturer getSoftwareManufacturer() {
		return softwareManufacturer;
	}

	public void setSoftwareManufacturer(SoftwareManufacturer softwareManufacturer) {
		this.softwareManufacturer = softwareManufacturer;
	}

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getPreferredSupplier() {
		return preferredSupplier;
	}

	public void setPreferredSupplier(String preferredSupplier) {
		this.preferredSupplier = preferredSupplier;
	}

	public String getSoftwareManufacturerName() {
		return softwareManufacturerName;
	}

	public void setSoftwareManufacturerName(String softwareManufacturerName) {
		this.softwareManufacturerName = softwareManufacturerName;
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
