package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the ServerClusterLUNs database table.
 * 
 */
@Entity
@Table(name="ServerClusterLUNs")
@NamedQuery(name="ServerClusterLUN.findAll", query="SELECT s FROM ServerClusterLUN s")
public class ServerClusterLUN implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverClusterLUNID;

	private String localName;
	private int availableGB;
	private int usedGB;

	//bi-directional many-to-one association to Sanlun
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="SANLUNID")
	private Sanlun sanlun; 

	//bi-directional many-to-one association to ServerCluster
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="serverClusterID")
	private ServerCluster servercluster;

	// bi-directional many-to-one association to StorageService
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "StorageServiceID")
	private StorageService storageservice;
	
	// bi-directional many-to-one association to ServerClusterLUNHistory
	@OneToMany(mappedBy = "serverClusterLUN")
	private List<ServerClusterLUNHistory> serverClusterLUNHistories;
	
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

	public ServerClusterLUN() {
	}

	public int getServerClusterLUNID() {
		return serverClusterLUNID;
	}

	public void setServerClusterLUNID(int serverClusterLUNID) {
		this.serverClusterLUNID = serverClusterLUNID;
	}

	public int getAvailableGB() {
		return availableGB;
	}

	public void setAvailableGB(int availableGB) {
		this.availableGB = availableGB;
	}

	public String getLocalName() {
		return localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
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

	public List<ServerClusterLUNHistory> getServerClusterLUNHistories() {
		return serverClusterLUNHistories;
	}

	public void setServerClusterLUNHistories(
			List<ServerClusterLUNHistory> serverClusterLUNHistories) {
		this.serverClusterLUNHistories = serverClusterLUNHistories;
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