package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the serverclusters database table.
 * 
 */
@Entity
@Table(name = "ServerClusters")
@NamedQuery(name = "ServerCluster.findAll", query = "SELECT s FROM ServerCluster s")
public class ServerCluster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serverClusterID;

	private String serverClusterIdentifier;

	// bi-directional many-to-one association to ServerClusterType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ServerClusterTypeID")
	private ServerClusterType serverclustertype;

	// bi-directional many-to-one association to ServersInServerCluster
	@OneToMany(mappedBy = "servercluster")
	private List<ServersInServerCluster> serversinserverclusters;

	// bi-directional many-to-one association to ServersInServerCluster
	@OneToMany(mappedBy = "servercluster")
	private List<ServerClusterLUN> serverclusterluns;
	
	// bi-directional many-to-one association to ServerClusterHistory
	@OneToMany(mappedBy = "servercluster")
	private List<ServerClusterHistory> serverClusterHistories;
	
	// bi-directional many-to-one association to ServersInServerClusterHistory
	@OneToMany(mappedBy = "servercluster")
	private List<ServersInServerClusterHistory> serversInServerClusterHistories;
	
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
	
	public ServerCluster() {
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

	public int getServerClusterID() {
		return this.serverClusterID;
	}

	public void setServerClusterID(int serverClusterID) {
		this.serverClusterID = serverClusterID;
	}

	public String getServerClusterIdentifier() {
		return this.serverClusterIdentifier;
	}

	public void setServerClusterIdentifier(String serverClusterIdentifier) {
		this.serverClusterIdentifier = serverClusterIdentifier;
	}

	public List<ServerClusterHistory> getServerClusterHistories() {
		return serverClusterHistories;
	}

	public void setServerClusterHistories(
			List<ServerClusterHistory> serverClusterHistories) {
		this.serverClusterHistories = serverClusterHistories;
	}

	public List<ServersInServerClusterHistory> getServersInServerClusterHistories() {
		return serversInServerClusterHistories;
	}

	public void setServersInServerClusterHistories(
			List<ServersInServerClusterHistory> serversInServerClusterHistories) {
		this.serversInServerClusterHistories = serversInServerClusterHistories;
	}

	public ServerClusterType getServerclustertype() {
		return this.serverclustertype;
	}

	public void setServerclustertype(ServerClusterType serverclustertype) {
		this.serverclustertype = serverclustertype;
	}

	public List<ServersInServerCluster> getServersinserverclusters() {
		return this.serversinserverclusters;
	}

	public void setServersinserverclusters(List<ServersInServerCluster> serversinserverclusters) {
		this.serversinserverclusters = serversinserverclusters;
	}

	public ServersInServerCluster addServersinservercluster(ServersInServerCluster serversinservercluster) {
		getServersinserverclusters().add(serversinservercluster);
		serversinservercluster.setServercluster(this);

		return serversinservercluster;
	}

	public ServersInServerCluster removeServersinservercluster(ServersInServerCluster serversinservercluster) {
		getServersinserverclusters().remove(serversinservercluster);
		serversinservercluster.setServercluster(null);

		return serversinservercluster;
	}

	public List<ServerClusterLUN> getServerclusterluns() {
		return serverclusterluns;
	}

	public void setServerclusterluns(List<ServerClusterLUN> serverclusterluns) {
		this.serverclusterluns = serverclusterluns;
	}

	public ServerClusterLUN addServersinservercluster(ServerClusterLUN serverclusterluns) {
		getServerclusterluns().add(serverclusterluns);
		serverclusterluns.setServercluster(this);

		return serverclusterluns;
	}

	public ServerClusterLUN removeServersinservercluster(ServerClusterLUN serverclusterluns) {
		getServerclusterluns().remove(serverclusterluns);
		serverclusterluns.setServercluster(null);

		return serverclusterluns;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serverClusterIdentifier == null) ? 0 : serverClusterIdentifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerCluster other = (ServerCluster) obj;
		if (serverClusterIdentifier == null) {
			if (other.serverClusterIdentifier != null)
				return false;
		} else if (!serverClusterIdentifier.equals(other.serverClusterIdentifier))
			return false;
		return true;
	}

}