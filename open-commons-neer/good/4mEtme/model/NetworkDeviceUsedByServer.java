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
 * The persistent class for the groups database table.
 * 
 */
@Entity
@Table(name = "NetworkDeviceUsedByServer")
@NamedQuery(name = "NetworkDeviceUsedByServer.findAll", query = "SELECT g FROM NetworkDeviceUsedByServer g")
public class NetworkDeviceUsedByServer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int networkDeviceUsedByServerID;

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
	
	public NetworkDeviceUsedByServer() {
	}

	public int getNetworkDeviceUsedByServerID() {
		return networkDeviceUsedByServerID;
	}

	public void setNetworkDeviceUsedByServerID(int networkDeviceUsedByServerID) {
		this.networkDeviceUsedByServerID = networkDeviceUsedByServerID;
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
