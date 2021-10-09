package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the DiscoveryStateHistory database table.
 */
@Entity
@Cacheable(true)
@Table(name="DiscoveryStateHistory")
@NamedQuery(name="DiscoveryStateHistory.findAll", query="SELECT dh FROM DiscoveryStateHistory dh")
public class DiscoveryStateHistory implements Serializable{
	
	private static final long serialVersionUID = 1L;

		
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int discoveryStateHistoryID;
	

	private int versionNumber;
	
	@ManyToOne
	@JoinColumn(name="discoveryStateID")
	private DiscoveryState discoveryState ;

	private String discoveryStateName;
	private String freezeItem;
	private int orderNum;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="discoverystate")
	private List<Application> applications;

	//bi-directional many-to-one association to ApplicationInstance
	@OneToMany(mappedBy="discoverystate")
	private List<ApplicationInstance> applicationinstances;

	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="discoverystate")
	private List<Server> servers;

	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="discoverystate")
	private List<PhysicalServer> physicalservers;
	
	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="discoverystate")
	private List<NetworkDevice> networkdevices;
	
	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="discoverystate")
	private List<StorageService> storageservices;

	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="discoverystate")
	private List<Nasshare> nasshares;

	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="discoverystate")
	private List<OtherHardware> otherhardwares;
	
	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public DiscoveryStateHistory() {
		super();
	}
	
	public int getDiscoveryStateHistoryID() {
		return discoveryStateHistoryID;
	}

	public void setDiscoveryStateHistoryID(int discoveryStateHistoryID) {
		this.discoveryStateHistoryID = discoveryStateHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public DiscoveryState getDiscoveryState() {
		return discoveryState;
	}

	public void setDiscoveryState(DiscoveryState discoveryState) {
		this.discoveryState = discoveryState;
	}

	public String getDiscoveryStateName() {
		return discoveryStateName;
	}

	public void setDiscoveryStateName(String discoveryStateName) {
		this.discoveryStateName = discoveryStateName;
	}

	public String getFreezeItem() {
		return freezeItem;
	}

	public void setFreezeItem(String freezeItem) {
		this.freezeItem = freezeItem;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public List<ApplicationInstance> getApplicationinstances() {
		return applicationinstances;
	}

	public void setApplicationinstances(
			List<ApplicationInstance> applicationinstances) {
		this.applicationinstances = applicationinstances;
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	public List<PhysicalServer> getPhysicalservers() {
		return physicalservers;
	}

	public void setPhysicalservers(List<PhysicalServer> physicalservers) {
		this.physicalservers = physicalservers;
	}

	public List<NetworkDevice> getNetworkdevices() {
		return networkdevices;
	}

	public void setNetworkdevices(List<NetworkDevice> networkdevices) {
		this.networkdevices = networkdevices;
	}

	public List<StorageService> getStorageservices() {
		return storageservices;
	}

	public void setStorageservices(List<StorageService> storageservices) {
		this.storageservices = storageservices;
	}

	public List<Nasshare> getNasshares() {
		return nasshares;
	}

	public void setNasshares(List<Nasshare> nasshares) {
		this.nasshares = nasshares;
	}

	public List<OtherHardware> getOtherhardwares() {
		return otherhardwares;
	}

	public void setOtherhardwares(List<OtherHardware> otherhardwares) {
		this.otherhardwares = otherhardwares;
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
