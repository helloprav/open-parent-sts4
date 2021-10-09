package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the SANLUNHistory database table.
 * 
 */
@Entity
@Table(name = "SANLUNHistory")
@NamedQuery(name = "SanlunHistory.findAll", query = "SELECT sh FROM SanlunHistory sh")
public class SanlunHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sanlunhistoryid;
	private int versionNumber;
	
	private String sanLunName;
	
	//bi-directional many-to-one association to SanLunType
	@ManyToOne
	@JoinColumn(name="sanlunID")
	private Sanlun sanlun;
	
	//bi-directional many-to-one association to SanLunType
	@ManyToOne
	@JoinColumn(name="sanlunTypeID")
	private SanLunType sanLunType;

	private int sizeGB;

	// bi-directional many-to-one association to StorageService
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "StorageServiceID")
	private StorageService storageservice;
	
	
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

	public SanlunHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSanlunhistoryid() {
		return sanlunhistoryid;
	}

	public void setSanlunhistoryid(int sanlunhistoryid) {
		this.sanlunhistoryid = sanlunhistoryid;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getSanLunName() {
		return sanLunName;
	}

	public void setSanLunName(String sanLunName) {
		this.sanLunName = sanLunName;
	}

	public Sanlun getSanlun() {
		return sanlun;
	}

	public void setSanlun(Sanlun sanlun) {
		this.sanlun = sanlun;
	}

	public SanLunType getSanLunType() {
		return sanLunType;
	}

	public void setSanLunType(SanLunType sanLunType) {
		this.sanLunType = sanLunType;
	}

	public int getSizeGB() {
		return sizeGB;
	}

	public void setSizeGB(int sizeGB) {
		this.sizeGB = sizeGB;
	}

	public StorageService getStorageservice() {
		return storageservice;
	}

	public void setStorageservice(StorageService storageservice) {
		this.storageservice = storageservice;
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