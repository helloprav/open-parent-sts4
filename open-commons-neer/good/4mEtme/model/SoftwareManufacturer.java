package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the softwaremanufacturers database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name = "SoftwareManufacturers")
@NamedQuery(name = "SoftwareManufacturer.findAll", query = "SELECT s FROM SoftwareManufacturer s")
public class SoftwareManufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int softwareManufacturerID;

	private String contactDetails;

	private String preferredSupplier;

	private String softwareManufacturerName;

	// bi-directional many-to-one association to Software
	@OneToMany(mappedBy = "softwaremanufacturer")
	private List<Software> softwares;
	
	// bi-directional many-to-one association to SoftwareManufacturerHistory
	@OneToMany(mappedBy = "softwareManufacturer")
	private List<SoftwareManufacturerHistory> softwareManufacturerHistories;
	
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

	public SoftwareManufacturer() {
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


	public int getSoftwareManufacturerID() {
		return this.softwareManufacturerID;
	}

	public void setSoftwareManufacturerID(int softwareManufacturerID) {
		this.softwareManufacturerID = softwareManufacturerID;
	}

	public String getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getPreferredSupplier() {
		return this.preferredSupplier;
	}

	public void setPreferredSupplier(String preferredSupplier) {
		this.preferredSupplier = preferredSupplier;
	}

	public String getSoftwareManufacturerName() {
		return this.softwareManufacturerName;
	}

	public void setSoftwareManufacturerName(String softwareManufacturerName) {
		this.softwareManufacturerName = softwareManufacturerName;
	}

	public List<Software> getSoftwares() {
		return this.softwares;
	}

	public void setSoftwares(List<Software> softwares) {
		this.softwares = softwares;
	}

	public Software addSoftware(Software software) {
		getSoftwares().add(software);
		software.setSoftwaremanufacturer(this);

		return software;
	}

	public Software removeSoftware(Software software) {
		getSoftwares().remove(software);
		software.setSoftwaremanufacturer(null);

		return software;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((softwareManufacturerName == null) ? 0 : softwareManufacturerName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SoftwareManufacturer other = (SoftwareManufacturer) obj;
		if (softwareManufacturerName == null) {
			if (other.softwareManufacturerName != null)
				return false;
		} else if (!softwareManufacturerName.equals(other.softwareManufacturerName))
			return false;
		return true;
	}

}