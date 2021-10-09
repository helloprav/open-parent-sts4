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
@Table(name = "ServerDASHistory")
@NamedQuery(name = "ServerDASHistory.findAll", query = "SELECT s FROM ServerDASHistory s")
public class ServerDASHistory implements Serializable {
	
	private static final long serialVersionUID = 8716142480438128217L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverDASHistoryID;
	
	private int versionNumber;
	
	private int availableGB;

	private String dasReference;

	private int usedGB;

	//bi-directional many-to-one association to ServerDAS
	@ManyToOne
	@JoinColumn(name="ServerDASID")
	private ServerDAS serverDAS;
		
	//bi-directional many-to-one association to Server
	@ManyToOne
	@JoinColumn(name="ServerID")
	private Server server;

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
	
	public ServerDASHistory(){
		
	}

	public int getServerDASHistoryID() {
		return serverDASHistoryID;
	}

	public void setServerDASHistoryID(int serverDASHistoryID) {
		this.serverDASHistoryID = serverDASHistoryID;
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

	public String getDasReference() {
		return dasReference;
	}

	public void setDasReference(String dasReference) {
		this.dasReference = dasReference;
	}

	public int getUsedGB() {
		return usedGB;
	}

	public void setUsedGB(int usedGB) {
		this.usedGB = usedGB;
	}

	public ServerDAS getServerDAS() {
		return serverDAS;
	}

	public void setServerDAS(ServerDAS serverDAS) {
		this.serverDAS = serverDAS;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
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
