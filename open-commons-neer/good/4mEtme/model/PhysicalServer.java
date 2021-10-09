package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the physicalservers database table.
 * 
 */
@Entity
@Table(name = "PhysicalServers")
@NamedQuery(name = "PhysicalServer.findAll", query = "SELECT p FROM PhysicalServer p")
public class PhysicalServer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int physicalServerID;

	private String physicalServerIdentifier;
	private String targetDisposition;
	private String customField1;
	private String customField2;
	private String customField3;
	
	// bi-directional many-to-one association to AssetModel
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "AssetModelID")
	private AssetModel assetmodel;

	// bi-directional many-to-one association to BladeChassi
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BladeChassisID")
	private BladeChassis bladechassis1;

	// bi-directional many-to-one association to BladeChassi
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetBladeChassisID")
	private BladeChassis bladechassis2;

	// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to FloorLocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "FloorLocationID")
	private FloorLocation floorlocation1;

	// bi-directional many-to-one association to FloorLocation
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetFloorLocationID")
	private FloorLocation floorlocation2;

	// bi-directional many-to-one association to DiscoveryState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DiscoveryStateID")
	private DiscoveryState discoverystate;

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	// bi-directional many-to-one association to Rack
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "RackID")
	private Rack rack1;

	// bi-directional many-to-one association to Rack
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetRackID")
	private Rack rack2;

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "physicalserver1")
	private List<Server> servers1;

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "physicalserver2")
	private List<Server> servers2;

	// bi-directional many-to-one association to VmFarm
	@OneToMany(mappedBy = "physicalserver")
	private List<VmFarm> vmfarms;

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

	public PhysicalServer() {
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

	public int getPhysicalServerID() {
		return this.physicalServerID;
	}

	public void setPhysicalServerID(int physicalServerID) {
		this.physicalServerID = physicalServerID;
	}

	public String getPhysicalServerIdentifier() {
		return physicalServerIdentifier;
	}

	public void setPhysicalServerIdentifier(String physicalServerIdentifier) {
		this.physicalServerIdentifier = physicalServerIdentifier;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public String getCustomField1() {
		return customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getCustomField2() {
		return customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

	public String getCustomField3() {
		return customField3;
	}

	public void setCustomField3(String customField3) {
		this.customField3 = customField3;
	}

	public AssetModel getAssetmodel() {
		return this.assetmodel;
	}

	public void setAssetmodel(AssetModel assetmodel) {
		this.assetmodel = assetmodel;
	}

	public BladeChassis getBladechassis1() {
		return this.bladechassis1;
	}

	public void setBladechassis1(BladeChassis bladechassis1) {
		this.bladechassis1 = bladechassis1;
	}

	public BladeChassis getBladechassis2() {
		return this.bladechassis2;
	}

	public void setBladechassis2(BladeChassis bladechassis2) {
		this.bladechassis2 = bladechassis2;
	}

	public Disposition getDisposition1() {
		return this.disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public FloorLocation getFloorlocation1() {
		return this.floorlocation1;
	}

	public void setFloorlocation1(FloorLocation floorlocation1) {
		this.floorlocation1 = floorlocation1;
	}

	public FloorLocation getFloorlocation2() {
		return this.floorlocation2;
	}

	public void setFloorlocation2(FloorLocation floorlocation2) {
		this.floorlocation2 = floorlocation2;
	}

	public MoveGroup getMovegroup() {
		return this.movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
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

	public Rack getRack1() {
		return this.rack1;
	}

	public void setRack1(Rack rack1) {
		this.rack1 = rack1;
	}

	public Rack getRack2() {
		return this.rack2;
	}

	public void setRack2(Rack rack2) {
		this.rack2 = rack2;
	}

	public List<Server> getServers1() {
		return this.servers1;
	}

	public void setServers1(List<Server> servers1) {
		this.servers1 = servers1;
	}

	public Server addServers1(Server servers1) {
		getServers1().add(servers1);
		servers1.setPhysicalserver1(this);

		return servers1;
	}

	public Server removeServers1(Server servers1) {
		getServers1().remove(servers1);
		servers1.setPhysicalserver1(null);

		return servers1;
	}

	public List<Server> getServers2() {
		return this.servers2;
	}

	public void setServers2(List<Server> servers2) {
		this.servers2 = servers2;
	}

	public Server addServers2(Server servers2) {
		getServers2().add(servers2);
		servers2.setPhysicalserver2(this);

		return servers2;
	}

	public Server removeServers2(Server servers2) {
		getServers2().remove(servers2);
		servers2.setPhysicalserver2(null);

		return servers2;
	}

	public List<VmFarm> getVmfarms() {
		return this.vmfarms;
	}

	public void setVmfarms(List<VmFarm> vmfarms) {
		this.vmfarms = vmfarms;
	}

	public VmFarm addVmfarm(VmFarm vmfarm) {
		getVmfarms().add(vmfarm);
		vmfarm.setPhysicalserver(this);

		return vmfarm;
	}

	public VmFarm removeVmfarm(VmFarm vmfarm) {
		getVmfarms().remove(vmfarm);
		vmfarm.setPhysicalserver(null);

		return vmfarm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((physicalServerIdentifier == null) ? 0 : physicalServerIdentifier.hashCode());
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
		PhysicalServer other = (PhysicalServer) obj;
		if (physicalServerIdentifier == null) {
			if (other.physicalServerIdentifier != null)
				return false;
		} else if (!physicalServerIdentifier.equals(other.physicalServerIdentifier))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PhysicalServer [physicalServerID=" + physicalServerID + ", physicalServerIdentifier=" + physicalServerIdentifier + "]";
	}

}