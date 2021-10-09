package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the businessservices database table.
 */
@Entity
@Cacheable(true)
@Table(name="BusinessServices")
@NamedQuery(name="BusinessService.findAll", query="SELECT b FROM BusinessService b")
public class BusinessService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int businessServiceID;

	private String businessServiceName;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="businessservice")
	private List<Application> applications;

	//bi-directional many-to-one association to BusinessServiceRole
//	@OneToMany(mappedBy="businessservice")
//	private List<BusinessServiceRole> businessserviceroles;

	//bi-directional many-to-one association to TaskTracking
	//@OneToMany(mappedBy="businessservice")
	//private List<TaskTracking> tasktrackings;

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
	
	public BusinessService() {
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

	public int getBusinessServiceID() {
		return this.businessServiceID;
	}

	public void setBusinessServiceID(int businessServiceID) {
		this.businessServiceID = businessServiceID;
	}

	public String getBusinessServiceName() {
		return this.businessServiceName;
	}

	public void setBusinessServiceName(String businessServiceName) {
		this.businessServiceName = businessServiceName;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setBusinessservice(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setBusinessservice(null);

		return application;
	}

}