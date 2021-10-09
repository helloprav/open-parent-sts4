package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the floors database table.
 * 
 */
@Entity
@Table(name = "Floors")
@NamedQuery(name = "Floor.findAll", query = "SELECT f FROM Floor f")
public class Floor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int floorID;

	private String floorName;

	// bi-directional many-to-one association to Building
	@ManyToOne
	@JoinColumn(name = "BuildingID")
	private Building building;

	// bi-directional many-to-one association to Room
	@OneToMany(mappedBy = "floor")
	private List<Room> rooms;
	
	//bi-directional many-to-one association to FloorHistory
	@OneToMany(mappedBy="floor")
	private List<FloorHistory> floorHistories;
	
	//bi-directional many-to-one association to RoomHistory
	@OneToMany(mappedBy="floor")
	private List<RoomHistory> roomHistories;

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
	
	public Floor() {
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

	public int getFloorID() {
		return this.floorID;
	}

	public void setFloorID(int floorID) {
		this.floorID = floorID;
	}

	public String getFloorName() {
		return this.floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public Building getBuilding() {
		return this.building;
	}

	public void setBuilding(Building building) {
		this.building = building;
	}

	public List<FloorHistory> getFloorHistories() {
		return floorHistories;
	}

	public void setFloorHistories(List<FloorHistory> floorHistories) {
		this.floorHistories = floorHistories;
	}

	public List<RoomHistory> getRoomHistories() {
		return roomHistories;
	}

	public void setRoomHistories(List<RoomHistory> roomHistories) {
		this.roomHistories = roomHistories;
	}

	public List<Room> getRooms() {
		return this.rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setFloor(this);

		return room;
	}

	public Room removeRoom(Room room) {
		getRooms().remove(room);
		room.setFloor(null);

		return room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((floorName == null) ? 0 : floorName.hashCode());
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
		Floor other = (Floor) obj;
		if (floorName == null) {
			if (other.floorName != null)
				return false;
		} else if (!floorName.equals(other.floorName))
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return "Floor [floorName=" + floorName + ", building=" + building + "]";
	}
	

}