package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the SoftwareHistory database table.
 * 
 */
@Entity
@Table(name = "SoftwareVersionHistory")
@NamedQuery(name = "SoftwareVersionHistory.findAll", query = "SELECT svh FROM SoftwareVersionHistory svh")
public class SoftwareVersionHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int softwareversionhistoryID;
	private int versionNumber;
	private String softwareVersionName;
    private int versionOrderNumber;

	
  //bi-directional many-to-one association to SoftwareVersions
  	@ManyToOne
  	@JoinColumn(name="SoftwareVersionID")
  	private SoftwareVersion softwareversion;
    
    
	//bi-directional many-to-one association to Software
	@ManyToOne
	@JoinColumn(name="SoftwareID")
	private Software software;

	public int getSoftwareversionhistoryID() {
		return softwareversionhistoryID;
	}

	public void setSoftwareversionhistoryID(int softwareversionhistoryID) {
		this.softwareversionhistoryID = softwareversionhistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getSoftwareVersionName() {
		return softwareVersionName;
	}

	public void setSoftwareVersionName(String softwareVersionName) {
		this.softwareVersionName = softwareVersionName;
	}

	public int getVersionOrderNumber() {
		return versionOrderNumber;
	}

	public void setVersionOrderNumber(int versionOrderNumber) {
		this.versionOrderNumber = versionOrderNumber;
	}

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
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

	public SoftwareVersionHistory() {
	}


   
	

}