package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the racks database table.
 * 
 */
@Entity
@Table(name = "Racks")
@NamedQuery(name = "Rack.findAll", query = "SELECT r FROM Rack r")
public class Rack implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rackID;

	private String rackIdentifier;

	// bi-directional many-to-one association to BladeChassi
	@OneToMany(mappedBy = "rack")
	private List<BladeChassis> bladechassis;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "rack1")
	private List<PhysicalServer> physicalservers1;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "rack2")
	private List<PhysicalServer> physicalservers2;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "rack1")
	private List<NetworkDevice> networkdevices1;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "rack2")
	private List<NetworkDevice> networkdevices2;
	
	//bi-directional many-to-one association to RackHistory
	@OneToMany(mappedBy="rack")
	private List<RackHistory>  rackHistories;
	
	//bi-directional many-to-one association to BladeChassisHistory
	@OneToMany(mappedBy="rack")
	private List<BladeChassisHistory>  bladeChassisHistories;

	// bi-directional many-to-one association to FloorLocation
	@ManyToOne
	@JoinColumn(name = "FloorLocationID")
	private FloorLocation floorlocation;

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

	public Rack() {
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

	public int getRackID() {
		return this.rackID;
	}

	public void setRackID(int rackID) {
		this.rackID = rackID;
	}

	public String getRackIdentifier() {
		return this.rackIdentifier;
	}

	public void setRackIdentifier(String rackIdentifier) {
		this.rackIdentifier = rackIdentifier;
	}

	public List<BladeChassis> getBladechassis() {
		return this.bladechassis;
	}

	public void setBladechassis(List<BladeChassis> bladechassis) {
		this.bladechassis = bladechassis;
	}

	public List<RackHistory> getRackHistories() {
		return rackHistories;
	}

	public void setRackHistories(List<RackHistory> rackHistories) {
		this.rackHistories = rackHistories;
	}

	public List<BladeChassisHistory> getBladeChassisHistories() {
		return bladeChassisHistories;
	}

	public void setBladeChassisHistories(
			List<BladeChassisHistory> bladeChassisHistories) {
		this.bladeChassisHistories = bladeChassisHistories;
	}

	public BladeChassis addBladechassi(BladeChassis bladechassi) {
		getBladechassis().add(bladechassi);
		bladechassi.setRack(this);

		return bladechassi;
	}

	public BladeChassis removeBladechassi(BladeChassis bladechassi) {
		getBladechassis().remove(bladechassi);
		bladechassi.setRack(null);

		return bladechassi;
	}

	public List<PhysicalServer> getPhysicalservers1() {
		return this.physicalservers1;
	}

	public void setPhysicalservers1(List<PhysicalServer> physicalservers1) {
		this.physicalservers1 = physicalservers1;
	}

	public PhysicalServer addPhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().add(physicalservers1);
		physicalservers1.setRack1(this);

		return physicalservers1;
	}

	public PhysicalServer removePhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().remove(physicalservers1);
		physicalservers1.setRack1(null);

		return physicalservers1;
	}

	public List<PhysicalServer> getPhysicalservers2() {
		return this.physicalservers2;
	}

	public void setPhysicalservers2(List<PhysicalServer> physicalservers2) {
		this.physicalservers2 = physicalservers2;
	}

	public PhysicalServer addPhysicalservers2(PhysicalServer physicalservers2) {
		getPhysicalservers2().add(physicalservers2);
		physicalservers2.setRack2(this);

		return physicalservers2;
	}

	public PhysicalServer removePhysicalservers2(PhysicalServer physicalservers2) {
		getPhysicalservers2().remove(physicalservers2);
		physicalservers2.setRack2(null);

		return physicalservers2;
	}

	public List<NetworkDevice> getNetworkdevices1() {
		return networkdevices1;
	}

	public void setNetworkdevices1(List<NetworkDevice> networkdevices1) {
		this.networkdevices1 = networkdevices1;
	}

	public NetworkDevice addNetworkdevices1(NetworkDevice networkdevices1) {
		getNetworkdevices1().add(networkdevices1);
		networkdevices1.setRack1(this);

		return networkdevices1;
	}

	public NetworkDevice removeNetworkdevices1(NetworkDevice networkdevices1) {
		getNetworkdevices1().remove(networkdevices1);
		networkdevices1.setRack1(null);

		return networkdevices1;
	}

	public List<NetworkDevice> getNetworkdevices2() {
		return networkdevices2;
	}

	public void setNetworkdevices2(List<NetworkDevice> networkdevices2) {
		this.networkdevices2 = networkdevices2;
	}

	public NetworkDevice addNetworkdevices2(NetworkDevice networkdevices2) {
		getNetworkdevices2().add(networkdevices2);
		networkdevices2.setRack2(this);

		return networkdevices2;
	}

	public NetworkDevice removeNetworkdevices2(NetworkDevice networkdevices2) {
		getNetworkdevices2().remove(networkdevices2);
		networkdevices2.setRack2(null);

		return networkdevices2;
	}
	
	public FloorLocation getFloorlocation() {
		return this.floorlocation;
	}

	public void setFloorlocation(FloorLocation floorlocation) {
		this.floorlocation = floorlocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rackIdentifier == null) ? 0 : rackIdentifier.hashCode());
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
		Rack other = (Rack) obj;
		if (rackIdentifier == null) {
			if (other.rackIdentifier != null)
				return false;
		} else if (!rackIdentifier.equals(other.rackIdentifier))
			return false;
		return true;
	}

}