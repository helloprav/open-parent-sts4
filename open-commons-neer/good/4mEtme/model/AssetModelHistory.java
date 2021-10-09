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
 * The persistent class for the OperatingSystemVersionHistory database table.
 * 
 */
@Entity
@Table(name = "AssetModelHistory")
@NamedQuery(name = "AssetModelHistory.findAll", query = "SELECT amh FROM AssetModelHistory amh")
public class AssetModelHistory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assetModelHistoryID;
	private int versionNumber;
	
	private String assetModelName;

	
  	@ManyToOne
  	@JoinColumn(name="AssetModelID")
  	private AssetModel assetModel;
    
    
	@ManyToOne
	@JoinColumn(name="HardwareManufacturerID")
	private HardwareManufacturer hardwareManufacturer ;
	
	
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

	public AssetModelHistory() {
	}

	public int getAssetModelHistoryID() {
		return assetModelHistoryID;
	}

	public void setAssetModelHistoryID(int assetModelHistoryID) {
		this.assetModelHistoryID = assetModelHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getAssetModelName() {
		return assetModelName;
	}

	public void setAssetModelName(String assetModelName) {
		this.assetModelName = assetModelName;
	}

	public AssetModel getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(AssetModel assetModel) {
		this.assetModel = assetModel;
	}

	public HardwareManufacturer getHardwareManufacturer() {
		return hardwareManufacturer;
	}

	public void setHardwareManufacturer(HardwareManufacturer hardwareManufacturer) {
		this.hardwareManufacturer = hardwareManufacturer;
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

}
