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
 * The persistent class for the HardwareManufacturerHistory database table.
 * 
 */
@Entity
@Table(name = "HardwareManufacturerHistory")
@NamedQuery(name = "HardwareManufacturerHistory.findAll", query = "SELECT hmh FROM HardwareManufacturerHistory hmh")
public class HardwareManufacturerHistory implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hardwareManufacturerHistoryID;
	private int versionNumber;
	

	private String hardwareManufacturerName;

	// bi-directional many-to-one association to OperatingSystem
	@ManyToOne
	@JoinColumn(name = "hardwareManufacturerID")
    private HardwareManufacturer hardwareManufacturer;

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
	
	public HardwareManufacturerHistory() {
	}

	public int getHardwareManufacturerHistoryID() {
		return hardwareManufacturerHistoryID;
	}

	public void setHardwareManufacturerHistoryID(int hardwareManufacturerHistoryID) {
		this.hardwareManufacturerHistoryID = hardwareManufacturerHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getHardwareManufacturerName() {
		return hardwareManufacturerName;
	}

	public void setHardwareManufacturerName(String hardwareManufacturerName) {
		this.hardwareManufacturerName = hardwareManufacturerName;
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
