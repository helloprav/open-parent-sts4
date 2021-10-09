package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the logicaldatalinkmaintenancewindows database table.
 * 
 */
@Entity
@Table(name="LogicalDataLinkMaintenanceWindows")
@NamedQuery(name="LogicalDataLinkMaintenanceWindow.findAll", query="SELECT l FROM LogicalDataLinkMaintenanceWindow l")
public class LogicalDataLinkMaintenanceWindow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int logicalDataLinkMaintenaceWindowID;

	private int duration;

	private String contactDetails;

	private String description;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	//bi-directional many-to-one association to LogicalDataLink
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LogicalDataLinkID")
	private LogicalDataLink logicaldatalink;

	//bi-directional many-to-one association to Recurrance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RecurranceID")
	private Recurrance recurrance;
	
	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public LogicalDataLinkMaintenanceWindow() {
	}

	public int getLogicalDataLinkMaintenaceWindowID() {
		return this.logicalDataLinkMaintenaceWindowID;
	}

	public void setLogicalDataLinkMaintenaceWindowID(int logicalDataLinkMaintenaceWindowID) {
		this.logicalDataLinkMaintenaceWindowID = logicalDataLinkMaintenaceWindowID;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public LogicalDataLink getLogicaldatalink() {
		return this.logicaldatalink;
	}

	public void setLogicaldatalink(LogicalDataLink logicaldatalink) {
		this.logicaldatalink = logicaldatalink;
	}

	public Recurrance getRecurrance() {
		return this.recurrance;
	}

	public void setRecurrance(Recurrance recurrance) {
		this.recurrance = recurrance;
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

	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}