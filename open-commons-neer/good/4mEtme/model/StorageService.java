package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the storageservices database table.
 * 
 */
@Entity
@Table(name = "StorageServices")
@NamedQuery(name = "StorageService.findAll", query = "SELECT s FROM StorageService s")
public class StorageService implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storageServiceID;
    
	private int availableGB;
    
	private String storageServiceName;
	
	//bi-directional many-to-one association to StorageType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="storageTypeID")
	private StorageType storageType;
	
	private int usedGB;
	
	private String targetDisposition;

	//bi-directional many-to-one association to DiscoveryState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="DiscoveryStateID")
	private DiscoveryState discoverystate;
	
	//bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MigrationScopeID")
	private MigrationScope migrationscope;

	//bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CurrentDispositionID")
	private Disposition disposition1;

	/*//bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;
	
	// bi-directional many-to-one association to Nasshare
	@OneToMany(mappedBy = "storageservice")
	private List<Nasshare> nasshares;

	// bi-directional many-to-one association to Sanlun
	@OneToMany(mappedBy = "storageservice")
	private List<Sanlun> sanluns;

	// bi-directional many-to-one association to Sanlun
	@OneToMany(mappedBy = "storageservice")
	private List<ServerSANConnection> serversanconnections;
	
	// bi-directional many-to-one association to ServerClusterLUNHistory
	@OneToMany(mappedBy = "storageservice")
	private List<ServerClusterLUNHistory> serverClusterLUNHistories;
	
	// bi-directional many-to-one association to ServerSANConnectionHistory
	@OneToMany(mappedBy = "storageservice")
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

	public StorageService() {
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

	public int getStorageServiceID() {
		return this.storageServiceID;
	}

	public void setStorageServiceID(int storageServiceID) {
		this.storageServiceID = storageServiceID;
	}

	public int getAvailableGB() {
		return this.availableGB;
	}

	public void setAvailableGB(int availableGB) {
		this.availableGB = availableGB;
	}

	public String getStorageServiceName() {
		return this.storageServiceName;
	}

	public void setStorageServiceName(String storageServiceName) {
		this.storageServiceName = storageServiceName;
	}

	public int getUsedGB() {
		return this.usedGB;
	}

	public void setUsedGB(int usedGB) {
		this.usedGB = usedGB;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public StorageType getStorageType() {
		return storageType;
	}

	public void setStorageType(StorageType storageType) {
		this.storageType = storageType;
	}

	public DiscoveryState getDiscoverystate() {
		return discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}

	public MigrationScope getMigrationscope() {
		return migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public Disposition getDisposition1() {
		return disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public MoveGroup getMovegroup() {
		return movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public List<Nasshare> getNasshares() {
		return this.nasshares;
	}

	public void setNasshares(List<Nasshare> nasshares) {
		this.nasshares = nasshares;
	}

	public Nasshare addNasshare(Nasshare nasshare) {
		getNasshares().add(nasshare);
		nasshare.setStorageservice(this);

		return nasshare;
	}

	public Nasshare removeNasshare(Nasshare nasshare) {
		getNasshares().remove(nasshare);
		nasshare.setStorageservice(null);

		return nasshare;
	}

	public List<Sanlun> getSanluns() {
		return this.sanluns;
	}

	public void setSanluns(List<Sanlun> sanluns) {
		this.sanluns = sanluns;
	}

	public Sanlun addSanlun(Sanlun sanlun) {
		getSanluns().add(sanlun);
		sanlun.setStorageservice(this);

		return sanlun;
	}

	public Sanlun removeSanlun(Sanlun sanlun) {
		getSanluns().remove(sanlun);
		sanlun.setStorageservice(null);

		return sanlun;
	}

	public List<ServerSANConnection> getServersanconnections() {
		return this.serversanconnections;
	}

	public void setServersanconnections(List<ServerSANConnection> serversanconnections) {
		this.serversanconnections = serversanconnections;
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

	public ServerSANConnection addServersanconnection(ServerSANConnection serversanconnection) {
		getServersanconnections().add(serversanconnection);
		serversanconnection.setStorageservice(this);

		return serversanconnection;
	}

	public ServerSANConnection removeServersanconnection(ServerSANConnection serversanconnection) {
		getServersanconnections().remove(serversanconnection);
		serversanconnection.setStorageservice(null);

		return serversanconnection;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((storageServiceName == null) ? 0 : storageServiceName.hashCode());
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
		StorageService other = (StorageService) obj;
		if (storageServiceName == null) {
			if (other.storageServiceName != null)
				return false;
		} else if (!storageServiceName.equals(other.storageServiceName))
			return false;
		return true;
	}

}