package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the floorlocations database table.
 * 
 */
@Entity
@Table(name = "FloorLocations")
@NamedQuery(name = "FloorLocation.findAll", query = "SELECT f FROM FloorLocation f")
public class FloorLocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int floorLocationID;

	private String floorLocationName;

	// bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name = "RoomID")
	private Room room;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "floorlocation1")
	private List<PhysicalServer> physicalservers1;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "floorlocation2")
	private List<PhysicalServer> physicalservers2;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "floorlocation1")
	private List<NetworkDevice> networkdevices1;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "floorlocation2")
	private List<NetworkDevice> networkdevices2;
		
	// bi-directional many-to-one association to Rack
	@OneToMany(mappedBy = "floorlocation")
	private List<Rack> racks;
	
	//bi-directional many-to-one association to FloorLocationHistory
	@OneToMany(mappedBy="floorLocation")
	private List<FloorLocationHistory> floorLocationHistories;
	
	//bi-directional many-to-one association to RackHistory
	@OneToMany(mappedBy="floorlocation")
	private List<RackHistory> rackHistories;

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

	public FloorLocation() {
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

	public int getFloorLocationID() {
		return this.floorLocationID;
	}

	public void setFloorLocationID(int floorLocationID) {
		this.floorLocationID = floorLocationID;
	}

	public List<FloorLocationHistory> getFloorLocationHistories() {
		return floorLocationHistories;
	}

	public void setFloorLocationHistories(
			List<FloorLocationHistory> floorLocationHistories) {
		this.floorLocationHistories = floorLocationHistories;
	}

	public String getFloorLocationName() {
		return this.floorLocationName;
	}

	public void setFloorLocationName(String floorLocationName) {
		this.floorLocationName = floorLocationName;
	}

	public Room getRoom() {
		return this.room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public List<PhysicalServer> getPhysicalservers1() {
		return this.physicalservers1;
	}

	public void setPhysicalservers1(List<PhysicalServer> physicalservers1) {
		this.physicalservers1 = physicalservers1;
	}

	public List<RackHistory> getRackHistories() {
		return rackHistories;
	}

	public void setRackHistories(List<RackHistory> rackHistories) {
		this.rackHistories = rackHistories;
	}

	public PhysicalServer addPhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().add(physicalservers1);
		physicalservers1.setFloorlocation1(this);

		return physicalservers1;
	}

	public PhysicalServer removePhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().remove(physicalservers1);
		physicalservers1.setFloorlocation1(null);

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
		physicalservers2.setFloorlocation2(this);

		return physicalservers2;
	}

	public PhysicalServer removePhysicalservers2(PhysicalServer physicalservers2) {
		getPhysicalservers2().remove(physicalservers2);
		physicalservers2.setFloorlocation2(null);

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
		networkdevices1.setFloorlocation1(this);

		return networkdevices1;
	}

	public NetworkDevice removeNetworkdevices1(NetworkDevice networkdevices1) {
		getNetworkdevices1().remove(networkdevices1);
		networkdevices1.setFloorlocation1(null);

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
		networkdevices2.setFloorlocation2(this);

		return networkdevices2;
	}

	public NetworkDevice removePhysicalservers2(NetworkDevice networkdevices2) {
		getPhysicalservers2().remove(networkdevices2);
		networkdevices2.setFloorlocation2(null);

		return networkdevices2;
	}

	public List<Rack> getRacks() {
		return this.racks;
	}

	public void setRacks(List<Rack> racks) {
		this.racks = racks;
	}

	public Rack addRack(Rack rack) {
		getRacks().add(rack);
		rack.setFloorlocation(this);

		return rack;
	}

	public Rack removeRack(Rack rack) {
		getRacks().remove(rack);
		rack.setFloorlocation(null);

		return rack;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((floorLocationName == null) ? 0 : floorLocationName.hashCode());
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
		FloorLocation other = (FloorLocation) obj;
		if (floorLocationName == null) {
			if (other.floorLocationName != null)
				return false;
		} else if (!floorLocationName.equals(other.floorLocationName))
			return false;
		return true;
	}

}