package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the NetworkDeviceHistory database table.
 * 
 */
@Entity
@Table(name="NetworkDeviceHistory")
@NamedQuery(name="NetworkDeviceHistory.findAll", query="SELECT nh FROM NetworkDeviceHistory nh")
public class NetworkDeviceHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int networkDeviceHistoryID;
	private int versionNumber;

	private String networkDeviceName;
	private String targetDisposition;
	private String ipAddress;

	//bi-directional many-to-one association to DiscoveryState
	@ManyToOne
	@JoinColumn(name="NetworkDeviceID")
	private NetworkDevice networkDevice;
	
	//bi-directional many-to-one association to DiscoveryState
	@ManyToOne
	@JoinColumn(name="DiscoveryStateID")
	private DiscoveryState discoverystate;
	
	//bi-directional many-to-one association to MigrationScope
	@ManyToOne
	@JoinColumn(name="MigrationScopeID")
	private MigrationScope migrationscope;

	//bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name="CurrentDispositionID")
	private Disposition disposition1;

	/*//bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name="TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	//bi-directional many-to-one association to NetworkDeviceType
	@ManyToOne
	@JoinColumn(name="NetworkDeviceTypeID")
	private NetworkDeviceType networkdevicetype;
	
	// bi-directional many-to-one association to FloorLocation
	@ManyToOne
	@JoinColumn(name = "FloorLocationID")
	private FloorLocation floorlocation1;

	// bi-directional many-to-one association to FloorLocation
	@ManyToOne
	@JoinColumn(name = "TargetFloorLocationID")
	private FloorLocation floorlocation2;

	// bi-directional many-to-one association to Rack
	@ManyToOne
	@JoinColumn(name = "RackID")
	private Rack rack1;

	// bi-directional many-to-one association to Rack
	@ManyToOne
	@JoinColumn(name = "TargetRackID")
	private Rack rack2;

	// bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name = "CurrentSLAID")
	private SLA sla1;

	// bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name = "TargetSLAID")
	private SLA sla2;
	
	@ManyToOne
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public NetworkDeviceHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNetworkDeviceHistoryID() {
		return networkDeviceHistoryID;
	}

	public void setNetworkDeviceHistoryID(int networkDeviceHistoryID) {
		this.networkDeviceHistoryID = networkDeviceHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getNetworkDeviceName() {
		return networkDeviceName;
	}

	public void setNetworkDeviceName(String networkDeviceName) {
		this.networkDeviceName = networkDeviceName;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public NetworkDevice getNetworkDevice() {
		return networkDevice;
	}

	public void setNetworkDevice(NetworkDevice networkDevice) {
		this.networkDevice = networkDevice;
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

	public NetworkDeviceType getNetworkdevicetype() {
		return networkdevicetype;
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