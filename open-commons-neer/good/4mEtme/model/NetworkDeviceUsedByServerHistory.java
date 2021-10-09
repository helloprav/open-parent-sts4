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

/**
 * The persistent class for the NetworkDeviceUsedByServerHistory database table.
 * 
 */
@Entity
@Table(name = "NetworkDeviceUsedByServerHistory")
@NamedQuery(name = "NetworkDeviceUsedByServerHistory.findAll", query = "SELECT gh FROM NetworkDeviceUsedByServerHistory gh")
public class NetworkDeviceUsedByServerHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int networkDeviceUsedByServerHistoryID;
	private int versionNumber;
	
	private int networkDeviceUsedByServerID;

	@ManyToOne
	@JoinColumn(name="NetworkDeviceUsedByServerID")
	private NetworkDeviceUsedByServer networkDeviceUsedByServer;
	
	@ManyToOne
	@JoinColumn(name="NetworkDeviceID")
	private NetworkDevice networkDevice;

	@ManyToOne
	@JoinColumn(name="ServerID")
	private Server server;

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
	
	public NetworkDeviceUsedByServerHistory() {
	}

	public int getNetworkDeviceUsedByServerHistoryID() {
		return networkDeviceUsedByServerHistoryID;
	}

	public void setNetworkDeviceUsedByServerHistoryID(
			int networkDeviceUsedByServerHistoryID) {
		this.networkDeviceUsedByServerHistoryID = networkDeviceUsedByServerHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getNetworkDeviceUsedByServerID() {
		return networkDeviceUsedByServerID;
	}

	public void setNetworkDeviceUsedByServerID(int networkDeviceUsedByServerID) {
		this.networkDeviceUsedByServerID = networkDeviceUsedByServerID;
	}

	public NetworkDeviceUsedByServer getNetworkDeviceUsedByServer() {
		return networkDeviceUsedByServer;
	}

	public void setNetworkDeviceUsedByServer(
			NetworkDeviceUsedByServer networkDeviceUsedByServer) {
		this.networkDeviceUsedByServer = networkDeviceUsedByServer;
	}

	public NetworkDevice getNetworkDevice() {
		return networkDevice;
	}

	public void setNetworkDevice(NetworkDevice networkDevice) {
		this.networkDevice = networkDevice;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
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
