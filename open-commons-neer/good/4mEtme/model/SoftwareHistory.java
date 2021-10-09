package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the SoftwareHistory database table.
 * 
 */
@Entity
@Table(name = "SoftwareHistory")
@NamedQuery(name = "SoftwareHistory.findAll", query = "SELECT sh FROM SoftwareHistory sh")
public class SoftwareHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int softwarehistoryID;
	private int versionNumber;
	
    private String SMEDetails;

	private String softwareName;

	// bi-directional many-to-one association to SoftwareManufacturer
	@ManyToOne
	@JoinColumn(name = "SoftwareID")
    private Software software;

	
	// bi-directional many-to-one association to SoftwareManufacturer
	@ManyToOne
	@JoinColumn(name = "SoftwareManufacturerID")
	private SoftwareManufacturer softwaremanufacturer;

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
	
	public SoftwareHistory() {
	}

	public int getSoftwarehistoryID() {
		return softwarehistoryID;
	}

	public void setSoftwarehistoryID(int softwarehistoryID) {
		this.softwarehistoryID = softwarehistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getSMEDetails() {
		return SMEDetails;
	}

	public void setSMEDetails(String sMEDetails) {
		SMEDetails = sMEDetails;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public SoftwareManufacturer getSoftwaremanufacturer() {
		return softwaremanufacturer;
	}

	public void setSoftwaremanufacturer(SoftwareManufacturer softwaremanufacturer) {
		this.softwaremanufacturer = softwaremanufacturer;
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