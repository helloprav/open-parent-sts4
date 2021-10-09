package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
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
@Cacheable(true)
@Table(name="ServerClusterHistory")
@NamedQuery(name="ServerClusterHistory.findAll", query="SELECT s FROM ServerClusterHistory s")
public class ServerClusterHistory implements Serializable {

	private static final long serialVersionUID = 6056747386279813053L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverClusterHistoryID;
	
	private int versionNumber;
	
	private String serverClusterIdentifier;
	
	// bi-directional many-to-one association to ServerCluster
	@ManyToOne
	@JoinColumn(name = "ServerClusterID")
	private ServerCluster servercluster;
	
	// bi-directional many-to-one association to ServerClusterType
	@ManyToOne
	@JoinColumn(name = "ServerClusterTypeID")
	private ServerClusterType serverclustertype;
	
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
	
	public ServerClusterHistory(){
		
	}

	public int getServerClusterHistoryID() {
		return serverClusterHistoryID;
	}

	public void setServerClusterHistoryID(int serverClusterHistoryID) {
		this.serverClusterHistoryID = serverClusterHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getServerClusterIdentifier() {
		return serverClusterIdentifier;
	}

	public void setServerClusterIdentifier(String serverClusterIdentifier) {
		this.serverClusterIdentifier = serverClusterIdentifier;
	}

	public ServerCluster getServercluster() {
		return servercluster;
	}

	public void setServercluster(ServerCluster servercluster) {
		this.servercluster = servercluster;
	}

	public ServerClusterType getServerclustertype() {
		return serverclustertype;
	}

	public void setServerclustertype(ServerClusterType serverclustertype) {
		this.serverclustertype = serverclustertype;
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
