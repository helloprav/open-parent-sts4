package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the serversanconnections database table.
 * 
 */
@Entity
@Table(name="ServerSANConnections")
@NamedQuery(name="ServerSANConnection.findAll", query="SELECT s FROM ServerSANConnection s")
public class ServerSANConnection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverSANConnectionID;

	private int availableGB;

	private String localName;

	private int usedGB;

	//bi-directional many-to-one association to Sanlun
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SANLUNID")
	private Sanlun sanlun;

	//bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServerID")
	private Server server;

	// bi-directional many-to-one association to StorageService
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "StorageServiceID")
	private StorageService storageservice;
	
	// bi-directional many-to-one association to ServerSANConnectionHistory
	@OneToMany(mappedBy = "serverSANConnection")
	private List<ServerSANConnectionHistory> serverSANConnectionHistories;
	
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

	public ServerSANConnection() {
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

	public int getServerSANConnectionID() {
		return this.serverSANConnectionID;
	}

	public void setServerSANConnectionID(int serverSANConnectionID) {
		this.serverSANConnectionID = serverSANConnectionID;
	}

	public int getAvailableGB() {
		return this.availableGB;
	}

	public void setAvailableGB(int availableGB) {
		this.availableGB = availableGB;
	}

	public String getLocalName() {
		return this.localName;
	}

	public void setLocalName(String localName) {
		this.localName = localName;
	}

	public int getUsedGB() {
		return this.usedGB;
	}

	public void setUsedGB(int usedGB) {
		this.usedGB = usedGB;
	}

	public Sanlun getSanlun() {
		return this.sanlun;
	}

	public void setSanlun(Sanlun sanlun) {
		this.sanlun = sanlun;
	}

	public Server getServer() {
		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public StorageService getStorageservice() {
		return storageservice;
	}

	public void setStorageservice(StorageService storageservice) {
		this.storageservice = storageservice;
	}

	public List<ServerSANConnectionHistory> getServerSANConnectionHistories() {
		return serverSANConnectionHistories;
	}

	public void setServerSANConnectionHistories(
			List<ServerSANConnectionHistory> serverSANConnectionHistories) {
		this.serverSANConnectionHistories = serverSANConnectionHistories;
	}

}