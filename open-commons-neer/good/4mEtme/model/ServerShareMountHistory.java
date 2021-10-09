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
@Table(name="ServerShareMountHistory")
@NamedQuery(name="ServerShareMountHistory.findAll", query="SELECT s FROM ServerShareMountHistory s")
public class ServerShareMountHistory implements Serializable {

	private static final long serialVersionUID = -153800651471057800L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverShareMountHistoryID;
    
	private int versionNumber;
	
	private String localMount;

	//bi-directional many-to-one association to ServerShareMount
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ServerShareMountID")
	private ServerShareMount serverShareMount;
	
	//bi-directional many-to-one association to Nasshare
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="NASShareID")
	private Nasshare nasshare;

	//bi-directional many-to-one association to ServerShare
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="ServerShareID")
	private ServerShare servershare;

	//bi-directional many-to-one association to Server
	@ManyToOne(cascade={CascadeType.ALL})
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
	
	public ServerShareMountHistory(){
		
	}

	public int getServerShareMountHistoryID() {
		return serverShareMountHistoryID;
	}

	public void setServerShareMountHistoryID(int serverShareMountHistoryID) {
		this.serverShareMountHistoryID = serverShareMountHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getLocalMount() {
		return localMount;
	}

	public void setLocalMount(String localMount) {
		this.localMount = localMount;
	}

	public ServerShareMount getServerShareMount() {
		return serverShareMount;
	}

	public void setServerShareMount(ServerShareMount serverShareMount) {
		this.serverShareMount = serverShareMount;
	}

	public Nasshare getNasshare() {
		return nasshare;
	}

	public void setNasshare(Nasshare nasshare) {
		this.nasshare = nasshare;
	}

	public ServerShare getServershare() {
		return servershare;
	}

	public void setServershare(ServerShare servershare) {
		this.servershare = servershare;
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
