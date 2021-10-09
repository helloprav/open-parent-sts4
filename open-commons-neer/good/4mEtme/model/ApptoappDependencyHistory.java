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


/**
 * The persistent class for the ApptoAppDependencyHistory database table.
 * 
 */
@Entity
@Table(name="ApptoAppDependencyHistory")
@NamedQuery(name="ApptoappDependencyHistory.findAll", query="SELECT a FROM ApptoappDependencyHistory a")
public class ApptoappDependencyHistory implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int AppToAppDependencieHistoryID;
	
	private int versionNumber;
	private String dependencyDescription;
	
	//bi-directional many-to-one association to ApptoAppDependencies
	@ManyToOne
	@JoinColumn(name="AppToAppDependencieID")
	private ApptoappDependency appToAppDependencies;

	
	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application1;

	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="DependentApplicationID")
	private Application application2;
	
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
	

	public ApptoappDependencyHistory() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getVersionNumber() {
		return versionNumber;
	}


	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}


	public ApptoappDependency getAppToAppDependencies() {
		return appToAppDependencies;
	}

	public void setAppToAppDependencies(ApptoappDependency appToAppDependencies) {
		this.appToAppDependencies = appToAppDependencies;
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


	public int getAppToAppDependencieHistoryID() {
		return AppToAppDependencieHistoryID;
	}


	public void setAppToAppDependencieHistoryID(int appToAppDependencieHistoryID) {
		AppToAppDependencieHistoryID = appToAppDependencieHistoryID;
	}


	public String getDependencyDescription() {
		return dependencyDescription;
	}

	public void setDependencyDescription(String dependencyDescription) {
		this.dependencyDescription = dependencyDescription;
	}

	public Application getApplication1() {
		return this.application1;
	}

	public void setApplication1(Application application1) {
		this.application1 = application1;
	}

	public Application getApplication2() {
		return this.application2;
	}

	public void setApplication2(Application application2) {
		this.application2 = application2;
	}

}