package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the rooms database table.
 * 
 */
@Entity
@Table(name = "Rooms")
@NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
public class Room implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roomID;

	private String roomName;

	// bi-directional many-to-one association to FloorLocation
	@OneToMany(mappedBy = "room")
	private List<FloorLocation> floorlocations;
	
	//bi-directional many-to-one association to RoomHistory
	@OneToMany(mappedBy="room")
	private List<RoomHistory> roomHistories;
	
	//bi-directional many-to-one association to FloorLocationHistory
	@OneToMany(mappedBy="room")
	private List<FloorLocationHistory> floorLocationHistories;

	// bi-directional many-to-one association to Floor
	@ManyToOne
	@JoinColumn(name = "FloorID")
	private Floor floor;

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

	public Room() {
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

	public int getRoomID() {
		return this.roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return this.roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public List<FloorLocation> getFloorlocations() {
		return this.floorlocations;
	}

	public void setFloorlocations(List<FloorLocation> floorlocations) {
		this.floorlocations = floorlocations;
	}

	public List<RoomHistory> getRoomHistories() {
		return roomHistories;
	}

	public void setRoomHistories(List<RoomHistory> roomHistories) {
		this.roomHistories = roomHistories;
	}

	public List<FloorLocationHistory> getFloorLocationHistories() {
		return floorLocationHistories;
	}

	public void setFloorLocationHistories(
			List<FloorLocationHistory> floorLocationHistories) {
		this.floorLocationHistories = floorLocationHistories;
	}

	public FloorLocation addFloorlocation(FloorLocation floorlocation) {
		getFloorlocations().add(floorlocation);
		floorlocation.setRoom(this);

		return floorlocation;
	}

	public FloorLocation removeFloorlocation(FloorLocation floorlocation) {
		getFloorlocations().remove(floorlocation);
		floorlocation.setRoom(null);

		return floorlocation;
	}

	public Floor getFloor() {
		return this.floor;
	}

	public void setFloor(Floor floor) {
		this.floor = floor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
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
		Room other = (Room) obj;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		return true;
	}

}