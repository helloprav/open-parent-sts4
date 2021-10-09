package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the applicationcomponentinstancemaintenanceoperations database table.
 * 
 */
@Entity
@Table(name="ApplicationComponentInstanceMaintenanceOperations")
@NamedQuery(name="ApplicationComponentInstanceMaintenanceOperation.findAll", query="SELECT a FROM ApplicationComponentInstanceMaintenanceOperation a")
public class ApplicationComponentInstanceMaintenanceOperation implements Serializable {

	private static final long serialVersionUID = -6993289586722811133L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationComponentInstanceMaintenanceOperationID;

	private String contactDetails;

	private String description;

	private int duration;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationComponentInstanceID")
	private ApplicationComponentInstance applicationcomponentinstance;

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

	public ApplicationComponentInstanceMaintenanceOperation() {
	}

	public int getApplicationComponentInstanceMaintenanceOperationID() {
		return this.applicationComponentInstanceMaintenanceOperationID;
	}

	public void setApplicationComponentInstanceMaintenanceOperationID(int applicationComponentInstanceMaintenanceOperationID) {
		this.applicationComponentInstanceMaintenanceOperationID = applicationComponentInstanceMaintenanceOperationID;
	}

	public String getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public ApplicationComponentInstance getApplicationcomponentinstance() {
		return this.applicationcomponentinstance;
	}

	public void setApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		this.applicationcomponentinstance = applicationcomponentinstance;
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

}