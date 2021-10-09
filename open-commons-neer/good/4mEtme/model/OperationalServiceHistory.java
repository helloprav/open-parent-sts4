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
@Table(name = "OperationalServiceHistory")
@NamedQuery(name = "OperationalServiceHistory.findAll", query = "SELECT osh FROM OperationalServiceHistory osh")
public class OperationalServiceHistory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int operationalServiceHistoryID;
	private int versionNumber;
	

	private String operationalServiceName;
	private String description;
	private String isMigrating;

	// bi-directional many-to-one association to OperatingSystem
	@ManyToOne
	@JoinColumn(name = "operationalServiceID")
    private OperationalService operationalService;

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
	
	public OperationalServiceHistory() {
	}

	public int getOperationalServiceHistoryID() {
		return operationalServiceHistoryID;
	}

	public void setOperationalServiceHistoryID(int operationalServiceHistoryID) {
		this.operationalServiceHistoryID = operationalServiceHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getOperationalServiceName() {
		return operationalServiceName;
	}

	public void setOperationalServiceName(String operationalServiceName) {
		this.operationalServiceName = operationalServiceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsMigrating() {
		return isMigrating;
	}

	public void setIsMigrating(String isMigrating) {
		this.isMigrating = isMigrating;
	}

	public OperationalService getOperationalService() {
		return operationalService;
	}

	public void setOperationalService(OperationalService operationalService) {
		this.operationalService = operationalService;
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
