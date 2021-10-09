package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the DiscoveryState database table.
 */
@Entity
@Cacheable(true)
@Table(name="DiscoveryState")
@NamedQuery(name="DiscoveryState.findAll", query="SELECT d FROM DiscoveryState d")
public class DiscoveryState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int discoveryStateID;

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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public DiscoveryState() {
		super();
	}

	public int getDiscoveryStateID() {
		return this.discoveryStateID;
	}

	public void setDiscoveryStateID(int discoveryStateID) {
		this.discoveryStateID = discoveryStateID;
	}

	public String getDiscoveryStateName() {
		return this.discoveryStateName;
	}

	public void setDiscoveryStateName(String discoveryStateName) {
		this.discoveryStateName = discoveryStateName;
	}

	public String getFreezeItem() {
		return this.freezeItem;
	}

	public void setFreezeItem(String freezeItem) {
		this.freezeItem = freezeItem;
	}

	public int getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public List<ApplicationInstance> getApplicationinstances() {
		return this.applicationinstances;
	}

	public void setApplicationinstances(List<ApplicationInstance> applicationinstances) {
		this.applicationinstances = applicationinstances;
	}

	public ApplicationInstance addApplicationinstance(ApplicationInstance applicationinstance) {
		getApplicationinstances().add(applicationinstance);
		applicationinstance.setDiscoverystate(this);

		return applicationinstance;
	}

	public ApplicationInstance removeApplicationinstance(ApplicationInstance applicationinstance) {
		getApplicationinstances().remove(applicationinstance);
		applicationinstance.setDiscoverystate(null);

		return applicationinstance;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setDiscoverystate(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setDiscoverystate(null);

		return application;
	}

	public List<Server> getServers() {
		return this.servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	public Server addServer(Server server) {
		getServers().add(server);
		server.setDiscoverystate(this);

		return server;
	}

	public Server removeServer(Server server) {
		getServers().remove(server);
		server.setDiscoverystate(null);

		return server;
	}

	public List<NetworkDevice> getNetworkDevices() {
		return this.networkdevices;
	}

	public void setNetworkDevices(List<NetworkDevice> networkdevices) {
		this.networkdevices = networkdevices;
	}

	public NetworkDevice addNetworkDevice(NetworkDevice networkdevice) {
		getNetworkDevices().add(networkdevice);
		networkdevice.setDiscoverystate(this);

		return networkdevice;
	}

	public NetworkDevice removeNetworkDevice(NetworkDevice networkdevice) {
		getNetworkDevices().remove(networkdevice);
		networkdevice.setDiscoverystate(null);

		return networkdevice;
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