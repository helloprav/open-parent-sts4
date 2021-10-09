package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the apptoappdependencies database table.
 * 
 */
@Entity
@Table(name="ApptoAppDependencies")
@NamedQuery(name="ApptoappDependency.findAll", query="SELECT a FROM ApptoappDependency a")
public class ApptoappDependency implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int appToAppDependencieID;
	private String dependencyDescription;
	
	//bi-directional many-to-one association to Application
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationID")
	private Application application1;

	//bi-directional many-to-one association to Application
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DependentApplicationID")
	private Application application2;
	
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
	
	public ApptoappDependency() {
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

	public int getAppToAppDependencieID() {
		return this.appToAppDependencieID;
	}

	public void setAppToAppDependencieID(int appToAppDependencieID) {
		this.appToAppDependencieID = appToAppDependencieID;
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