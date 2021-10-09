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
@Table(name = "RackHistory")
@NamedQuery(name = "RackHistory.findAll", query = "SELECT r FROM RackHistory r")
public class RackHistory implements Serializable {

	private static final long serialVersionUID = -5987516329205958231L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rackHistoryID;
	
	private int versionNumber;
	
	private String rackIdentifier;
	
	// bi-directional many-to-one association to FloorLocation
	@ManyToOne
	@JoinColumn(name = "FloorLocationID")
	private FloorLocation floorlocation;
	
	// bi-directional many-to-one association to Rack
	@ManyToOne
	@JoinColumn(name = "RackID")
	private Rack rack;

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

	public int getRackHistoryID() {
		return rackHistoryID;
	}

	public void setRackHistoryID(int rackHistoryID) {
		this.rackHistoryID = rackHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getRackIdentifier() {
		return rackIdentifier;
	}

	public void setRackIdentifier(String rackIdentifier) {
		this.rackIdentifier = rackIdentifier;
	}

	public FloorLocation getFloorlocation() {
		return floorlocation;
	}

	public void setFloorlocation(FloorLocation floorlocation) {
		this.floorlocation = floorlocation;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
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
