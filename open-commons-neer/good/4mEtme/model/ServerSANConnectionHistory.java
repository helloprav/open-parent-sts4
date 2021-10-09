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
@Table(name="ServerSANConnectionsHistory")
@NamedQuery(name="ServerSANConnectionHistory.findAll", query="SELECT s FROM ServerSANConnectionHistory s")
public class ServerSANConnectionHistory implements Serializable {

	private static final long serialVersionUID = -3311354441155454528L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverSANConnectionHistoryID;

	private int versionNumber;
	
	private int availableGB;

	private String localName;

	private int usedGB;

	//bi-directional many-to-one association to Sanlun
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ServerSANConnectionID")
	private ServerSANConnection serverSANConnection;
	
	//bi-directional many-to-one association to Sanlun
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="SANLUNID")
	private Sanlun sanlun;

	//bi-directional many-to-one association to Server
	@ManyToOne
	@JoinColumn(name="ServerID")
	private Server server;

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
	
	public ServerSANConnectionHistory(){
		
	}

	public int getServerSANConnectionHistoryID() {
		return serverSANConnectionHistoryID;
	}

	public void setServerSANConnectionHistoryID(int serverSANConnectionHistoryID) {
		this.serverSANConnectionHistoryID = serverSANConnectionHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
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

	public ServerSANConnection getServerSANConnection() {
		return serverSANConnection;
	}

	public void setServerSANConnection(ServerSANConnection serverSANConnection) {
		this.serverSANConnection = serverSANConnection;
	}

	public Sanlun getSanlun() {
		return sanlun;
	}

	public void setSanlun(Sanlun sanlun) {
		this.sanlun = sanlun;
	}

	public Server getServer() {
		return server;
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
