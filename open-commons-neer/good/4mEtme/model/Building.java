package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the buildings database table.
 */
@Entity
@Table(name="Buildings")
@NamedQuery(name="Building.findAll", query="SELECT b FROM Building b")
public class Building implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int buildingID;

	private String buildingName;

	//bi-directional many-to-one association to Floor
	@OneToMany(mappedBy="building")
	private List<Floor> floors;
	
	//bi-directional many-to-one association to BuildingHistory
	@OneToMany(mappedBy="building")
	private List<BuildingHistory> buildingHistories;
	
	//bi-directional many-to-one association to FloorHistory
	@OneToMany(mappedBy="building")
	private List<FloorHistory> floorHistories;
	
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

	public Building() {
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
	
	public int getBuildingID() {
		return this.buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public String getBuildingName() {
		return this.buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public List<Floor> getFloors() {
		return this.floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public List<BuildingHistory> getBuildingHistories() {
		return buildingHistories;
	}

	public void setBuildingHistories(List<BuildingHistory> buildingHistories) {
		this.buildingHistories = buildingHistories;
	}

	public List<FloorHistory> getFloorHistories() {
		return floorHistories;
	}

	public void setFloorHistories(List<FloorHistory> floorHistories) {
		this.floorHistories = floorHistories;
	}

	public Floor addFloor(Floor floor) {
		getFloors().add(floor);
		floor.setBuilding(this);

		return floor;
	}

	public Floor removeFloor(Floor floor) {
		getFloors().remove(floor);
		floor.setBuilding(null);

		return floor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((buildingName == null) ? 0 : buildingName.hashCode());
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
		Building other = (Building) obj;
		if (buildingName == null) {
			if (other.buildingName != null)
				return false;
		} else if (!buildingName.equals(other.buildingName))
			return false;
		return true;
	}

	@Override
	public String toString() {
	    return "Building [buildingName=" + buildingName + "]";
	}
	
	

}