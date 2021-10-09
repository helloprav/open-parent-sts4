package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the serverdas database table.
 * 
 */
@Entity
@Table(name="ServerDAS")
@NamedQuery(name="ServerDAS.findAll", query="SELECT s FROM ServerDAS s")
public class ServerDAS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverDASID;

	private int availableGB;

	private String dasReference;

	private int usedGB;

	//bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServerID")
	private Server server;
	
	// bi-directional many-to-one association to ServerDASHistory
	@OneToMany(mappedBy = "serverDAS")
	private List<ServerDASHistory> serverDASHistories;

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
	
	public ServerDAS() {
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

	public int getServerDASID() {
		return this.serverDASID;
	}

	public void setServerDASID(int serverDASID) {
		this.serverDASID = serverDASID;
	}

	public int getAvailableGB() {
		return this.availableGB;
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
		return this.usedGB;
	}

	public void setUsedGB(int usedGB) {
		this.usedGB = usedGB;
	}

	public Server getServer() {
		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public List<ServerDASHistory> getServerDASHistories() {
		return serverDASHistories;
	}

	public void setServerDASHistories(List<ServerDASHistory> serverDASHistories) {
		this.serverDASHistories = serverDASHistories;
	}

}