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
@Table(name="ServersInServerClusterHistory")
@NamedQuery(name="ServersInServerClusterHistory.findAll", query="SELECT s FROM ServersInServerClusterHistory s")
public class ServersInServerClusterHistory implements Serializable {

	private static final long serialVersionUID = -2353156340892583627L;

	private int versionNumber;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serversInServerClusterHistoryID;
	
	//bi-directional many-to-one association to ServersInServerCluster
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ServersInServerClusterID")
	private ServersInServerCluster serversInServerCluster;

	//bi-directional many-to-one association to ServerCluster
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ServerClusterID")
	private ServerCluster servercluster;

	//bi-directional many-to-one association to Server
	@ManyToOne(cascade={CascadeType.ALL})
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
	
	public ServersInServerClusterHistory(){
		
	}

	public int getServersInServerClusterHistoryID() {
		return serversInServerClusterHistoryID;
	}

	public void setServersInServerClusterHistoryID(
			int serversInServerClusterHistoryID) {
		this.serversInServerClusterHistoryID = serversInServerClusterHistoryID;
	}

	public ServersInServerCluster getServersInServerCluster() {
		return serversInServerCluster;
	}

	public void setServersInServerCluster(
			ServersInServerCluster serversInServerCluster) {
		this.serversInServerCluster = serversInServerCluster;
	}

	public ServerCluster getServercluster() {
		return servercluster;
	}

	public void setServercluster(ServerCluster servercluster) {
		this.servercluster = servercluster;
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

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}
	
}
