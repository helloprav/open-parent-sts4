package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paas database table.
 * 
 */
@Entity
@NamedQuery(name="PaaS.findAll", query="SELECT p FROM PaaS p")
public class PaaS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paaSID;

	private String paaSName;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy="paas1")
	private List<ApplicationComponentInstance> applicationcomponentinstances1;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy="paas2")
	private List<ApplicationComponentInstance> applicationcomponentinstances2;

	//bi-directional many-to-one association to ServiceProvider
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServiceProviderID")
	private ServiceProvider serviceprovider;
	
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

	public PaaS() {
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

	public int getPaaSID() {
		return this.paaSID;
	}

	public void setPaaSID(int paaSID) {
		this.paaSID = paaSID;
	}

	public String getPaaSName() {
		return this.paaSName;
	}

	public void setPaaSName(String paaSName) {
		this.paaSName = paaSName;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances1() {
		return this.applicationcomponentinstances1;
	}

	public void setApplicationcomponentinstances1(List<ApplicationComponentInstance> applicationcomponentinstances1) {
		this.applicationcomponentinstances1 = applicationcomponentinstances1;
	}

	public ApplicationComponentInstance addApplicationcomponentinstances1(ApplicationComponentInstance applicationcomponentinstances1) {
		getApplicationcomponentinstances1().add(applicationcomponentinstances1);
		applicationcomponentinstances1.setPaas1(this);

		return applicationcomponentinstances1;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstances1(ApplicationComponentInstance applicationcomponentinstances1) {
		getApplicationcomponentinstances1().remove(applicationcomponentinstances1);
		applicationcomponentinstances1.setPaas1(null);

		return applicationcomponentinstances1;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances2() {
		return this.applicationcomponentinstances2;
	}

	public void setApplicationcomponentinstances2(List<ApplicationComponentInstance> applicationcomponentinstances2) {
		this.applicationcomponentinstances2 = applicationcomponentinstances2;
	}

	public ApplicationComponentInstance addApplicationcomponentinstances2(ApplicationComponentInstance applicationcomponentinstances2) {
		getApplicationcomponentinstances2().add(applicationcomponentinstances2);
		applicationcomponentinstances2.setPaas2(this);

		return applicationcomponentinstances2;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstances2(ApplicationComponentInstance applicationcomponentinstances2) {
		getApplicationcomponentinstances2().remove(applicationcomponentinstances2);
		applicationcomponentinstances2.setPaas2(null);

		return applicationcomponentinstances2;
	}

	public ServiceProvider getServiceprovider() {
		return this.serviceprovider;
	}

	public void setServiceprovider(ServiceProvider serviceprovider) {
		this.serviceprovider = serviceprovider;
	}

}