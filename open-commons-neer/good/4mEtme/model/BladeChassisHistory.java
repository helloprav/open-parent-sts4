package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "BladeChassisHistory")
@NamedQuery(name = "BladeChassisHistory.findAll", query = "SELECT b FROM BladeChassisHistory b")
public class BladeChassisHistory implements Serializable {

	private static final long serialVersionUID = 276902577646815755L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bladeChassisHistoryID;
	
	private int versionNumber;
	
	private String bladeChassisIdentifier;

	// bi-directional many-to-one association to Rack
	@ManyToOne
	@JoinColumn(name = "RackID")
	private Rack rack;
	
	// bi-directional many-to-one association to BladeChassis
	@ManyToOne
	@JoinColumn(name = "BladeChassisID")
	private BladeChassis bladeChassis;
	
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
	
	public BladeChassisHistory(){
		
	}

	public int getBladeChassisHistoryID() {
		return bladeChassisHistoryID;
	}

	public void setBladeChassisHistoryID(int bladeChassisHistoryID) {
		this.bladeChassisHistoryID = bladeChassisHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getBladeChassisIdentifier() {
		return bladeChassisIdentifier;
	}

	public void setBladeChassisIdentifier(String bladeChassisIdentifier) {
		this.bladeChassisIdentifier = bladeChassisIdentifier;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public BladeChassis getBladeChassis() {
		return bladeChassis;
	}

	public void setBladeChassis(BladeChassis bladeChassis) {
		this.bladeChassis = bladeChassis;
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
