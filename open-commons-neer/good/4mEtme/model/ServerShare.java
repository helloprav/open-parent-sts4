package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the servershares database table.
 * 
 */
@Entity
@Table(name = "ServerShares")
@NamedQuery(name = "ServerShare.findAll", query = "SELECT s FROM ServerShare s")
public class ServerShare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serverShareID;

	private int availableGB;
	private String shareName;
	private String localPath;
	private int usedGB;

	// bi-directional many-to-one association to ServerShareMount
	@OneToMany(mappedBy = "servershare")
	private List<ServerShareMount> serversharemounts;
	
	// bi-directional many-to-one association to ServerShareHistory
	@OneToMany(mappedBy = "serverShare")
	private List<ServerShareHistory> serverShareHistories;
	
	// bi-directional many-to-one association to ServerShareMountHistory
	@OneToMany(mappedBy = "servershare")
	private List<ServerShareMountHistory> serverShareMountHistories;

	// bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ServerID")
	private Server server;

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
	
	public ServerShare() {
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

	public int getServerShareID() {
		return this.serverShareID;
	}

	public void setServerShareID(int serverShareID) {
		this.serverShareID = serverShareID;
	}

	public int getAvailableGB() {
		return this.availableGB;
	}

	public void setAvailableGB(int availableGB) {
		this.availableGB = availableGB;
	}

	public String getShareName() {
		return this.shareName;
	}

	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public String getLocalPath() {
		return localPath;
	}

	public void setLocalPath(String localPath) {
		this.localPath = localPath;
	}

	public int getUsedGB() {
		return this.usedGB;
	}

	public void setUsedGB(int usedGB) {
		this.usedGB = usedGB;
	}

	public List<ServerShareMount> getServersharemounts() {
		return this.serversharemounts;
	}

	public void setServersharemounts(List<ServerShareMount> serversharemounts) {
		this.serversharemounts = serversharemounts;
	}

	public List<ServerShareHistory> getServerShareHistories() {
		return serverShareHistories;
	}

	public void setServerShareHistories(
			List<ServerShareHistory> serverShareHistories) {
		this.serverShareHistories = serverShareHistories;
	}

	public List<ServerShareMountHistory> getServerShareMountHistories() {
		return serverShareMountHistories;
	}

	public void setServerShareMountHistories(
			List<ServerShareMountHistory> serverShareMountHistories) {
		this.serverShareMountHistories = serverShareMountHistories;
	}

	public ServerShareMount addServersharemount(ServerShareMount serversharemount) {
		getServersharemounts().add(serversharemount);
		serversharemount.setServershare(this);

		return serversharemount;
	}

	public ServerShareMount removeServersharemount(ServerShareMount serversharemount) {
		getServersharemounts().remove(serversharemount);
		serversharemount.setServershare(null);

		return serversharemount;
	}

	public Server getServer() {
		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((server == null) ? 0 : server.hashCode());
		result = prime * result + ((shareName == null) ? 0 : shareName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerShare other = (ServerShare) obj;
		if (server == null) {
			if (other.server != null)
				return false;
		} else if (!server.equals(other.server))
			return false;
		if (shareName == null) {
			if (other.shareName != null)
				return false;
		} else if (!shareName.equals(other.shareName))
			return false;
		return true;
	}

}