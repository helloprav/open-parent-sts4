package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the ApplicationComponentSoftwareRequirements database table.
 * 
 */
@Entity
@Table(name="ApplicationComponentSoftwareRequirements")
@NamedQuery(name="ApplicationComponentSoftwareRequirement.findAll", query="SELECT a FROM ApplicationComponentSoftwareRequirement a")
public class ApplicationComponentSoftwareRequirement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationComponentSoftwareRequirementID;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationComnponentID")
	private ApplicationComponent applicationcomponent;

	//bi-directional many-to-one association to SoftwareVersion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SoftwareVersionID")
	private SoftwareVersion softwareversion;
	
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
	
	public ApplicationComponentSoftwareRequirement() {
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

	public int getApplicationComponentSoftwareRequirementID() {
		return this.applicationComponentSoftwareRequirementID;
	}

	public void setApplicationComponentSoftwareRequirementID(int applicationComponentSoftwareRequirementID) {
		this.applicationComponentSoftwareRequirementID = applicationComponentSoftwareRequirementID;
	}

	public ApplicationComponent getApplicationcomponent() {
		return this.applicationcomponent;
	}

	public void setApplicationcomponent(ApplicationComponent applicationcomponent) {
		this.applicationcomponent = applicationcomponent;
	}

	public SoftwareVersion getSoftwareversion() {
		return this.softwareversion;
	}

	public void setSoftwareversion(SoftwareVersion softwareversion) {
		this.softwareversion = softwareversion;
	}

}