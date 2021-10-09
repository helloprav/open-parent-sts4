package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the ServerNICs database table. 
 */
@Entity
@Table(name="ServerNICs")
@NamedQuery(name="ServerNIC.findAll", query="SELECT s FROM ServerNIC s")
public class ServerNIC implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverNICID;
	private String ipAddress;

	//bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServerID")
	private Server server;
	
	//bi-directional many-to-one association to ServerNICHistory
	@OneToMany(mappedBy="serverNIC")
	private List<ServerNICHistory> serverNICHistories;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public ServerNIC() {
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

	public List<ServerNICHistory> getServerNICHistories() {
		return serverNICHistories;
	}

	public void setServerNICHistories(List<ServerNICHistory> serverNICHistories) {
		this.serverNICHistories = serverNICHistories;
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

	public int getServerNICID() {
		return this.serverNICID;
	}

	public void setServerNICID(int serverNICID) {
		this.serverNICID = serverNICID;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Server getServer() {
		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

}