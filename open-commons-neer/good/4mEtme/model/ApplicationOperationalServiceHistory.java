package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ApplicationOperationalServiceHistory database table.
 * 
 */
@Entity
@Table(name="ApplicationOperationalServiceHistory")
@NamedQuery(name="ApplicationOperationalServiceHistory.findAll", query="SELECT aosh FROM ApplicationOperationalServiceHistory aosh")
public class ApplicationOperationalServiceHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationOperationalServiceHistoryID;
	private int versionNumber;
	
    public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	//bi-directional many-to-one association to ApplicationOperationalServices
	@ManyToOne
	@JoinColumn(name="ApplicationOperationalServiceID")
	private ApplicationOperationalService applicationOperationalService;
	
	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to OperationalService
	@ManyToOne
	@JoinColumn(name="OperationalServiceID")
	private OperationalService operationalservice;

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

	public ApplicationOperationalServiceHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getApplicationOperationalServiceHistoryID() {
		return applicationOperationalServiceHistoryID;
	}

	public void setApplicationOperationalServiceHistoryID(
			int applicationOperationalServiceHistoryID) {
		this.applicationOperationalServiceHistoryID = applicationOperationalServiceHistoryID;
	}

	public ApplicationOperationalService getApplicationOperationalService() {
		return applicationOperationalService;
	}

	public void setApplicationOperationalService(
			ApplicationOperationalService applicationOperationalService) {
		this.applicationOperationalService = applicationOperationalService;
	}

	public Application getApplication() {
		return application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public OperationalService getOperationalservice() {
		return operationalservice;
	}

	public void setOperationalservice(OperationalService operationalservice) {
		this.operationalservice = operationalservice;
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