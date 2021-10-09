package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the software database table.
 * 
 */
@Entity
@Table(name = "Software")
@NamedQuery(name = "Software.findAll", query = "SELECT s FROM Software s")
public class Software implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int softwareID;

	private String SMEDetails;

	private String softwareName;

	// bi-directional many-to-one association to SoftwareManufacturer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SoftwareManufacturerID")
	private SoftwareManufacturer softwaremanufacturer;

	// bi-directional many-to-one association to SoftwareVersion
	@OneToMany(mappedBy = "software")
	private List<SoftwareVersion> softwareversions;

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
	
	public Software() {
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


	public int getSoftwareID() {
		return this.softwareID;
	}

	public void setSoftwareID(int softwareID) {
		this.softwareID = softwareID;
	}

	public String getSMEDetails() {
		return this.SMEDetails;
	}

	public void setSMEDetails(String SMEDetails) {
		this.SMEDetails = SMEDetails;
	}

	public String getSoftwareName() {
		return this.softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public SoftwareManufacturer getSoftwaremanufacturer() {
		return this.softwaremanufacturer;
	}

	public void setSoftwaremanufacturer(SoftwareManufacturer softwaremanufacturer) {
		this.softwaremanufacturer = softwaremanufacturer;
	}

	public List<SoftwareVersion> getSoftwareversions() {
		return this.softwareversions;
	}

	public void setSoftwareversions(List<SoftwareVersion> softwareversions) {
		this.softwareversions = softwareversions;
	}

	public SoftwareVersion addSoftwareversion(SoftwareVersion softwareversion) {
		getSoftwareversions().add(softwareversion);
		softwareversion.setSoftware(this);

		return softwareversion;
	}

	public SoftwareVersion removeSoftwareversion(SoftwareVersion softwareversion) {
		getSoftwareversions().remove(softwareversion);
		softwareversion.setSoftware(null);

		return softwareversion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((softwareName == null) ? 0 : softwareName.hashCode());
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
		Software other = (Software) obj;
		if (softwareName == null) {
			if (other.softwareName != null)
				return false;
		} else if (!softwareName.equals(other.softwareName))
			return false;
		return true;
	}

}