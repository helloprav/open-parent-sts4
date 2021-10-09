package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the sanluns database table.
 * 
 */
@Entity
@Table(name = "SANLUNs")
@NamedQuery(name = "Sanlun.findAll", query = "SELECT s FROM Sanlun s")
public class Sanlun implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sanlunid;

	private String sanLunName;
	
	//bi-directional many-to-one association to SanLunType
	@ManyToOne
	@JoinColumn(name="sanlunTypeID")
	private SanLunType sanLunType;

	private int sizeGB;

	// bi-directional many-to-one association to StorageService
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "StorageServiceID")
	private StorageService storageservice;

	// bi-directional many-to-one association to ServerSANConnection
	@OneToMany(mappedBy = "sanlun")
	private List<ServerSANConnection> serversanconnections;

	// bi-directional many-to-one association to ServersInServerCluster
	@OneToMany(mappedBy = "servercluster")
	private List<ServerClusterLUN> serverclusterluns;
	
	// bi-directional many-to-one association to ServerClusterLUNHistory
	@OneToMany(mappedBy = "sanlun")
	private List<ServerClusterLUNHistory> serverClusterLUNHistories;
	
	// bi-directional many-to-one association to ServerSANConnectionHistory
	@OneToMany(mappedBy = "sanlun")
	private List<ServerSANConnectionHistory> serverSANConnectionHistories;
	
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

	public Sanlun() {
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

	public int getSanlunid() {
		return this.sanlunid;
	}

	public void setSanlunid(int sanlunid) {
		this.sanlunid = sanlunid;
	}

	public String getSanLunName() {
		return sanLunName;
	}

	public void setSanLunName(String sanLunName) {
		this.sanLunName = sanLunName;
	}

	public SanLunType getSanLunType() {
		return sanLunType;
	}

	public void setSanLunType(SanLunType sanLunType) {
		this.sanLunType = sanLunType;
	}

	public int getSizeGB() {
		return this.sizeGB;
	}

	public void setSizeGB(int sizeGB) {
		this.sizeGB = sizeGB;
	}

	public StorageService getStorageservice() {
		return this.storageservice;
	}

	public void setStorageservice(StorageService storageservice) {
		this.storageservice = storageservice;
	}

	public List<ServerSANConnection> getServersanconnections() {
		return this.serversanconnections;
	}

	public void setServersanconnections(List<ServerSANConnection> serversanconnections) {
		this.serversanconnections = serversanconnections;
	}

	public ServerSANConnection addServersanconnection(ServerSANConnection serversanconnection) {
		getServersanconnections().add(serversanconnection);
		serversanconnection.setSanlun(this);

		return serversanconnection;
	}

	public ServerSANConnection removeServersanconnection(ServerSANConnection serversanconnection) {
		getServersanconnections().remove(serversanconnection);
		serversanconnection.setSanlun(null);

		return serversanconnection;
	}
	
	public List<ServerClusterLUN> getServerclusterluns() {
		return serverclusterluns;
	}

	public void setServerclusterluns(List<ServerClusterLUN> serverclusterluns) {
		this.serverclusterluns = serverclusterluns;
	}

	public List<ServerClusterLUNHistory> getServerClusterLUNHistories() {
		return serverClusterLUNHistories;
	}

	public void setServerClusterLUNHistories(
			List<ServerClusterLUNHistory> serverClusterLUNHistories) {
		this.serverClusterLUNHistories = serverClusterLUNHistories;
	}

	public List<ServerSANConnectionHistory> getServerSANConnectionHistories() {
		return serverSANConnectionHistories;
	}

	public void setServerSANConnectionHistories(
			List<ServerSANConnectionHistory> serverSANConnectionHistories) {
		this.serverSANConnectionHistories = serverSANConnectionHistories;
	}

	public ServerClusterLUN addServersinservercluster(ServerClusterLUN serverclusterluns) {
		getServerclusterluns().add(serverclusterluns);
		serverclusterluns.setSanlun(this);

		return serverclusterluns;
	}

	public ServerClusterLUN removeServersinservercluster(ServerClusterLUN serverclusterluns) {
		getServerclusterluns().remove(serverclusterluns);
		serverclusterluns.setSanlun(null);

		return serverclusterluns;
	}

}