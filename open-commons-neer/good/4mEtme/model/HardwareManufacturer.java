package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the hardwaremanufacturers database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name = "HardwareManufacturers")
@NamedQuery(name = "HardwareManufacturer.findAll", query = "SELECT h FROM HardwareManufacturer h")
public class HardwareManufacturer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hardwareManufacturerID;

	private String hardwareManufacturerName;

	// bi-directional many-to-one association to AssetModel
	@OneToMany(mappedBy = "hardwaremanufacturer", cascade = { CascadeType.ALL })
	private List<AssetModel> assetmodels;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public HardwareManufacturer() {
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

	public int getHardwareManufacturerID() {
		return this.hardwareManufacturerID;
	}

	public void setHardwareManufacturerID(int hardwareManufacturerID) {
		this.hardwareManufacturerID = hardwareManufacturerID;
	}

	public String getHardwareManufacturerName() {
		return this.hardwareManufacturerName;
	}

	public void setHardwareManufacturerName(String hardwareManufacturerName) {
		this.hardwareManufacturerName = hardwareManufacturerName;
	}

	public List<AssetModel> getAssetmodels() {
		return this.assetmodels;
	}

	public void setAssetmodels(List<AssetModel> assetmodels) {
		this.assetmodels = assetmodels;
	}

	public AssetModel addAssetmodel(AssetModel assetmodel) {
		getAssetmodels().add(assetmodel);
		assetmodel.setHardwaremanufacturer(this);

		return assetmodel;
	}

	public AssetModel removeAssetmodel(AssetModel assetmodel) {
		getAssetmodels().remove(assetmodel);
		assetmodel.setHardwaremanufacturer(null);

		return assetmodel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hardwareManufacturerName == null) ? 0 : hardwareManufacturerName.hashCode());
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
		HardwareManufacturer other = (HardwareManufacturer) obj;
		if (hardwareManufacturerName == null) {
			if (other.hardwareManufacturerName != null)
				return false;
		} else if (!hardwareManufacturerName.equals(other.hardwareManufacturerName))
			return false;
		return true;
	}

}