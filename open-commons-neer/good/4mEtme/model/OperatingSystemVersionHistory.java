package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the OperatingSystemVersionHistory database table.
 * 
 */
@Entity
@Table(name = "OperatingSystemVersionHistory")
@NamedQuery(name = "OperatingSystemVersionHistory.findAll", query = "SELECT osvh FROM SoftwareVersionHistory osvh")
public class OperatingSystemVersionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int operatingSystemVersionHistoryID;
	private int versionNumber;
	
	@Column(name="OperatingSystemVersion")
	private String osVersion;

	
  //bi-directional many-to-one association to SoftwareVersions
  	@ManyToOne
  	@JoinColumn(name="OperatingSystemVersionID")
  	private OperatingSystemVersion operatingSystemVersion;
    
    
	//bi-directional many-to-one association to Software
	@ManyToOne
	@JoinColumn(name="OperatingSystemID")
	private OperatingSystem operatingSystem;
	
	
	//bi-directional many-to-one association to SupportStatus
	@ManyToOne
	@JoinColumn(name="SupportStatusID")
	private SupportStatus supportstatus;
	
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

	public OperatingSystemVersionHistory() {
	}

	public int getOperatingSystemVersionHistoryID() {
		return operatingSystemVersionHistoryID;
	}

	public void setOperatingSystemVersionHistoryID(
			int operatingSystemVersionHistoryID) {
		this.operatingSystemVersionHistoryID = operatingSystemVersionHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getOperatingSystemVersion() {
		return osVersion;
	}

	public void setOperatingSystemVersion(String operatingSystemVersion) {
		this.osVersion = operatingSystemVersion;
	}

	public OperatingSystemVersion getOsv() {
		return operatingSystemVersion;
	}

	public void setOsv(OperatingSystemVersion operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public SupportStatus getSupportstatus() {
		return supportstatus;
	}

	public void setSupportstatus(SupportStatus supportstatus) {
		this.supportstatus = supportstatus;
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