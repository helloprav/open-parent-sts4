package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the assetmodels database table.
 * 
 */
@Entity
@Table(name = "AssetModels")
@NamedQuery(name = "AssetModel.findAll", query = "SELECT a FROM AssetModel a")
public class AssetModel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assetModelID;

	private String assetModelName;

	// bi-directional many-to-one association to HardwareManufacturer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "HardwareManufacturerID")
	private HardwareManufacturer hardwaremanufacturer;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "assetmodel")
	private List<PhysicalServer> physicalservers;

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
	
	public AssetModel() {
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

	public int getAssetModelID() {
		return this.assetModelID;
	}

	public void setAssetModelID(int assetModelID) {
		this.assetModelID = assetModelID;
	}

	public String getAssetModelName() {
		return this.assetModelName;
	}

	public void setAssetModelName(String assetModelName) {
		this.assetModelName = assetModelName;
	}

	public HardwareManufacturer getHardwaremanufacturer() {
		return this.hardwaremanufacturer;
	}

	public void setHardwaremanufacturer(HardwareManufacturer hardwaremanufacturer) {
		this.hardwaremanufacturer = hardwaremanufacturer;
	}

	public List<PhysicalServer> getPhysicalservers() {
		return this.physicalservers;
	}

	public void setPhysicalservers(List<PhysicalServer> physicalservers) {
		this.physicalservers = physicalservers;
	}

	public PhysicalServer addPhysicalserver(PhysicalServer physicalserver) {
		getPhysicalservers().add(physicalserver);
		physicalserver.setAssetmodel(this);

		return physicalserver;
	}

	public PhysicalServer removePhysicalserver(PhysicalServer physicalserver) {
		getPhysicalservers().remove(physicalserver);
		physicalserver.setAssetmodel(null);

		return physicalserver;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetModelName == null) ? 0 : assetModelName.hashCode());
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
		AssetModel other = (AssetModel) obj;
		if (assetModelName == null) {
			if (other.assetModelName != null)
				return false;
		} else if (!assetModelName.equals(other.assetModelName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AssetModel [assetModelID=" + assetModelID + ", assetModelName=" + assetModelName + "]";
	}
	
	

}