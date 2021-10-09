package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="ServerClusterLunsHistory")
@NamedQuery(name="ServerClusterLUNHistory.findAll", query="SELECT s FROM ServerClusterLUNHistory s")
public class ServerClusterLUNHistory implements Serializable {

	private static final long serialVersionUID = 4876470412537202681L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverClusterLUNHistoryID;

	private int versionNumber;
	
	private String localName;
	private int availableGB;
	private int usedGB;

	//bi-directional many-to-one association to Sanlun
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="SANLUNID")
	private Sanlun sanlun;
	
	//bi-directional many-to-one association to ServerClusterLUN
	@ManyToOne
	@JoinColumn(name="ServerClusterLUNID")
	private ServerClusterLUN serverClusterLUN;

	//bi-directional many-to-one association to ServerCluster
	@ManyToOne
	@JoinColumn(name="serverClusterID")
	private ServerCluster servercluster;

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
	
	public ServerClusterLUNHistory(){
		
	}

	public int getServerClusterLUNHistoryID() {
		return serverClusterLUNHistoryID;
	}

	public void setServerClusterLUNHistoryID(int serverClusterLUNHistoryID) {
		this.serverClusterLUNHistoryID = serverClusterLUNHistoryID;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public int getAvailableGB() {
		return availableGB;
	}

	public void setAvailableGB(int availableGB) {
		this.availableGB = availableGB;
	}

	public int getUsedGB() {
		return usedGB;
	}

	public void setUsedGB(int usedGB) {
		this.usedGB = usedGB;
	}

	public Sanlun getSanlun() {
		return sanlun;
	}

	public void setSanlun(Sanlun sanlun) {
		this.sanlun = sanlun;
	}

	public ServerClusterLUN getServerClusterLUN() {
		return serverClusterLUN;
	}

	public void setServerClusterLUN(ServerClusterLUN serverClusterLUN) {
		this.serverClusterLUN = serverClusterLUN;
	}

	public ServerCluster getServercluster() {
		return servercluster;
	}

	public void setServercluster(ServerCluster servercluster) {
		this.servercluster = servercluster;
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

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}
	
}
