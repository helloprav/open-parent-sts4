package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the serverclustertypes database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="ServerClusterTypes")
@NamedQuery(name="ServerClusterType.findAll", query="SELECT s FROM ServerClusterType s")
public class ServerClusterType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverClusterTypeID;

	private String serverClusterTypeName;

	//bi-directional many-to-one association to ServerCluster
	@OneToMany(mappedBy="serverclustertype")
	private List<ServerCluster> serverclusters;
	
	//bi-directional many-to-one association to ServerClusterHistory
	@OneToMany(mappedBy="serverclustertype")
	private List<ServerClusterHistory> serverClusterHistories;

	public ServerClusterType() {
	}

	public int getServerClusterTypeID() {
		return this.serverClusterTypeID;
	}

	public void setServerClusterTypeID(int serverClusterTypeID) {
		this.serverClusterTypeID = serverClusterTypeID;
	}

	public String getServerClusterTypeName() {
		return this.serverClusterTypeName;
	}

	public void setServerClusterTypeName(String serverClusterTypeName) {
		this.serverClusterTypeName = serverClusterTypeName;
	}

	public List<ServerCluster> getServerclusters() {
		return this.serverclusters;
	}

	public void setServerclusters(List<ServerCluster> serverclusters) {
		this.serverclusters = serverclusters;
	}

	public List<ServerClusterHistory> getServerClusterHistories() {
		return serverClusterHistories;
	}

	public void setServerClusterHistories(
			List<ServerClusterHistory> serverClusterHistories) {
		this.serverClusterHistories = serverClusterHistories;
	}

	public ServerCluster addServercluster(ServerCluster servercluster) {
		getServerclusters().add(servercluster);
		servercluster.setServerclustertype(this);

		return servercluster;
	}

	public ServerCluster removeServercluster(ServerCluster servercluster) {
		getServerclusters().remove(servercluster);
		servercluster.setServerclustertype(null);

		return servercluster;
	}

}