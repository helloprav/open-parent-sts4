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
@Table(name = "ServerNICHistory")
@NamedQuery(name = "ServerNICHistory.findAll", query = "SELECT s FROM ServerNICHistory s")
public class ServerNICHistory implements Serializable {

	private static final long serialVersionUID = -8592203757945536297L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverNICHistoryID;

	private int versionNumber;
	private String ipAddress;

	//bi-directional many-to-one association to ServerNIC
	@ManyToOne
	@JoinColumn(name="ServerNICID")
	private ServerNIC serverNIC;
		
	//bi-directional many-to-one association to Server
	@ManyToOne
	@JoinColumn(name="ServerID")
	private Server server;

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
	
	public ServerNICHistory(){
		
	}

	public int getServerNICHistoryID() {
		return serverNICHistoryID;
	}

	public void setServerNICHistoryID(int serverNICHistoryID) {
		this.serverNICHistoryID = serverNICHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public ServerNIC getServerNIC() {
		return serverNIC;
	}

	public void setServerNIC(ServerNIC serverNIC) {
		this.serverNIC = serverNIC;
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
