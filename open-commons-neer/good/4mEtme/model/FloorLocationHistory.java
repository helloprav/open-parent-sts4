package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "FloorLocationHistory")
@NamedQuery(name = "FloorLocationHistory.findAll", query = "SELECT f FROM FloorLocationHistory f")
public class FloorLocationHistory implements Serializable {

	private static final long serialVersionUID = 5946525820686554751L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int floorLocationHistoryID;
	
	private int versionNumber;
	
	private String floorLocationName;

	// bi-directional many-to-one association to Room
	@ManyToOne
	@JoinColumn(name = "RoomID")
	private Room room;
	
	// bi-directional many-to-one association to FloorLocation
	@ManyToOne
	@JoinColumn(name = "FloorLocationID")
	private FloorLocation floorLocation;
	
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
	
	public FloorLocationHistory(){
		
	}

	public int getFloorLocationHistoryID() {
		return floorLocationHistoryID;
	}

	public void setFloorLocationHistoryID(int floorLocationHistoryID) {
		this.floorLocationHistoryID = floorLocationHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getFloorLocationName() {
		return floorLocationName;
	}

	public void setFloorLocationName(String floorLocationName) {
		this.floorLocationName = floorLocationName;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public FloorLocation getFloorLocation() {
		return floorLocation;
	}

	public void setFloorLocation(FloorLocation floorLocation) {
		this.floorLocation = floorLocation;
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
