package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the servermaintenanceoperations database table.
 */
@Entity
@Table(name="ServerMaintenanceOperations")
@NamedQuery(name="ServerMaintenanceOperation.findAll", query="SELECT s FROM ServerMaintenanceOperation s")
public class ServerMaintenanceOperation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverMaintenanceOperationID;

	private String contactDetails;

	private String description;

	private int duration;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startTime;

	//bi-directional many-to-one association to Recurrance
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="RecurranceID")
	private Recurrance recurrance;

	//bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServerID")
	private Server server;

	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public User getLastUpdatedByUser() {
		return lastUpdatedByUser;
	}

	public void setLastUpdatedByUser(User lastUpdatedByUser) {
		this.lastUpdatedByUser = lastUpdatedByUser;
	}

	public ServerMaintenanceOperation() {
	}

	public int getServerMaintenanceOperationID() {
		return this.serverMaintenanceOperationID;
	}

	public void setServerMaintenanceOperationID(int serverMaintenanceOperationID) {
		this.serverMaintenanceOperationID = serverMaintenanceOperationID;
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

	public Recurrance getRecurrance() {
		return this.recurrance;
	}

	public void setRecurrance(Recurrance recurrance) {
		this.recurrance = recurrance;
	}

	public Server getServer() {
		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

}