package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
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
@Cacheable(true)
@Table(name="SLAHistory")
@NamedQuery(name="SLAHistory.findAll", query="SELECT s FROM SLAHistory s")
public class SLAHistory implements Serializable {

	private static final long serialVersionUID = 6356330454967868361L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slaHistoryID;
	
	private int versionNumber;

	private float availabilityPercent;
	
	private int RPOMinutes;

	private int RTOMinutes;

	private String sLAName;
	
	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	//bi-directional many-to-one association to AssetCustomField
	@ManyToOne
	@JoinColumn(name="SLAID")
	private SLA sla;
	
	public SLAHistory(){
		
	}
	
	public int getSlaHistoryID() {
		return slaHistoryID;
	}

	public void setSlaHistoryID(int slaHistoryID) {
		this.slaHistoryID = slaHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public float getAvailabilityPercent() {
		return availabilityPercent;
	}

	public void setAvailabilityPercent(float availabilityPercent) {
		this.availabilityPercent = availabilityPercent;
	}

	public int getRPOMinutes() {
		return RPOMinutes;
	}

	public void setRPOMinutes(int rPOMinutes) {
		RPOMinutes = rPOMinutes;
	}

	public int getRTOMinutes() {
		return RTOMinutes;
	}

	public void setRTOMinutes(int rTOMinutes) {
		RTOMinutes = rTOMinutes;
	}

	public String getsLAName() {
		return sLAName;
	}

	public void setsLAName(String sLAName) {
		this.sLAName = sLAName;
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

	public SLA getSla() {
		return sla;
	}

	public void setSla(SLA sla) {
		this.sla = sla;
	}

}
