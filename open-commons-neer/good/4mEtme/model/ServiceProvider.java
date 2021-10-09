package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the serviceproviders database table.
 */
@Entity
@Cacheable(true)
@Table(name="ServiceProviders")
@NamedQuery(name="ServiceProvider.findAll", query="SELECT s FROM ServiceProvider s")
public class ServiceProvider implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ServiceProviderID")
	private int serviceProviderID;

	private String serviceProviderName;

	//bi-directional many-to-one association to PaaS
	@OneToMany(mappedBy="serviceprovider")
	private List<PaaS> paas;

	//bi-directional many-to-one association to SaaSApplication
	@OneToMany(mappedBy="serviceprovider")
	private List<SaaSApplication> saasapplications;

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

	public ServiceProvider() {
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

	public int getServiceProviderID() {
		return this.serviceProviderID;
	}

	public void setServiceProviderID(int serviceProviderID) {
		this.serviceProviderID = serviceProviderID;
	}

	public String getServiceProviderName() {
		return this.serviceProviderName;
	}

	public void setServiceProviderName(String serviceProviderName) {
		this.serviceProviderName = serviceProviderName;
	}

	public List<PaaS> getPaas() {
		return this.paas;
	}

	public void setPaas(List<PaaS> paas) {
		this.paas = paas;
	}

	public PaaS addPaa(PaaS paa) {
		getPaas().add(paa);
		paa.setServiceprovider(this);

		return paa;
	}

	public PaaS removePaa(PaaS paa) {
		getPaas().remove(paa);
		paa.setServiceprovider(null);

		return paa;
	}

	public List<SaaSApplication> getSaasapplications() {
		return this.saasapplications;
	}

	public void setSaasapplications(List<SaaSApplication> saasapplications) {
		this.saasapplications = saasapplications;
	}

	public SaaSApplication addSaasapplication(SaaSApplication saasapplication) {
		getSaasapplications().add(saasapplication);
		saasapplication.setServiceprovider(this);

		return saasapplication;
	}

	public SaaSApplication removeSaasapplication(SaaSApplication saasapplication) {
		getSaasapplications().remove(saasapplication);
		saasapplication.setServiceprovider(null);

		return saasapplication;
	}

}