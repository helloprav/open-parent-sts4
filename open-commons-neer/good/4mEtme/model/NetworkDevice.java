package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the networkdevices database table.
 * 
 */
@Entity
@Table(name="NetworkDevices")
@NamedQuery(name="NetworkDevice.findAll", query="SELECT n FROM NetworkDevice n")
public class NetworkDevice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int networkDeviceID;

	private String networkDeviceName;
	private String ipAddress;
	
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

	//bi-directional many-to-one association to NetworkDeviceType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NetworkDeviceTypeID")
	private NetworkDeviceType networkdevicetype;
	
	// bi-directional many-to-one association to FloorLocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "FloorLocationID")
	private FloorLocation floorlocation1;

	// bi-directional many-to-one association to FloorLocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetFloorLocationID")
	private FloorLocation floorlocation2;

	// bi-directional many-to-one association to Rack
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "RackID")
	private Rack rack1;

	// bi-directional many-to-one association to Rack
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetRackID")
	private Rack rack2;

	// bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentSLAID")
	private SLA sla1;

	// bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetSLAID")
	private SLA sla2;
	
	@OneToMany(mappedBy = "networkDevice")
	private List<NetworkDeviceUsedByServer> networkDeviceUsedByServers;
	
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

	public NetworkDevice() {
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

	public int getNetworkDeviceID() {
		return this.networkDeviceID;
	}

	public void setNetworkDeviceID(int networkDeviceID) {
		this.networkDeviceID = networkDeviceID;
	}

	public String getNetworkDeviceName() {
		return this.networkDeviceName;
	}

	public void setNetworkDeviceName(String networkDeviceName) {
		this.networkDeviceName = networkDeviceName;
	}

	public DiscoveryState getDiscoverystate() {
		return this.discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}
	
	public MigrationScope getMigrationscope() {
		return this.migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}
	
	public Disposition getDisposition1() {
		return this.disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public NetworkDeviceType getNetworkdevicetype() {
		return this.networkdevicetype;
	}

	public void setNetworkdevicetype(NetworkDeviceType networkdevicetype) {
		this.networkdevicetype = networkdevicetype;
	}

	public FloorLocation getFloorlocation1() {
		return floorlocation1;
	}

	public void setFloorlocation1(FloorLocation floorlocation1) {
		this.floorlocation1 = floorlocation1;
	}

	public FloorLocation getFloorlocation2() {
		return floorlocation2;
	}

	public void setFloorlocation2(FloorLocation floorlocation2) {
		this.floorlocation2 = floorlocation2;
	}

	public Rack getRack1() {
		return rack1;
	}

	public void setRack1(Rack rack1) {
		this.rack1 = rack1;
	}

	public Rack getRack2() {
		return rack2;
	}

	public void setRack2(Rack rack2) {
		this.rack2 = rack2;
	}

	public SLA getSla1() {
		return sla1;
	}

	public void setSla1(SLA sla1) {
		this.sla1 = sla1;
	}

	public SLA getSla2() {
		return sla2;
	}

	public void setSla2(SLA sla2) {
		this.sla2 = sla2;
	}

	public MoveGroup getMovegroup() {
		return movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public List<NetworkDeviceUsedByServer> getNetworkDeviceUsedByServers() {
		return networkDeviceUsedByServers;
	}

	public void setNetworkDeviceUsedByServers(
			List<NetworkDeviceUsedByServer> networkDeviceUsedByServers) {
		this.networkDeviceUsedByServers = networkDeviceUsedByServers;
	}
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

}