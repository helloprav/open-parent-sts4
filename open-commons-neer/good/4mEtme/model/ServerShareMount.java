package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the serversharemounts database table.
 * 
 */
@Entity
@Table(name="ServerShareMounts")
@NamedQuery(name="ServerShareMount.findAll", query="SELECT s FROM ServerShareMount s")
public class ServerShareMount implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverShareMountID;

	private String localMount;

	//bi-directional many-to-one association to Nasshare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="NASShareID")
	private Nasshare nasshare;

	//bi-directional many-to-one association to ServerShare
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServerShareID")
	private ServerShare servershare;

	//bi-directional many-to-one association to Server
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ServerID")
	private Server server;

	// bi-directional many-to-one association to ServerShareMountHistory
	@OneToMany(mappedBy = "serverShareMount")
	private List<ServerShareMountHistory> serverShareMountHistories;
		
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

	public ServerShareMount() {
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

	public int getServerShareMountID() {
		return this.serverShareMountID;
	}

	public void setServerShareMountID(int serverShareMountID) {
		this.serverShareMountID = serverShareMountID;
	}

	public String getLocalMount() {
		return this.localMount;
	}

	public void setLocalMount(String localMount) {
		this.localMount = localMount;
	}

	public Nasshare getNasshare() {
		return this.nasshare;
	}

	public void setNasshare(Nasshare nasshare) {
		this.nasshare = nasshare;
	}

	public ServerShare getServershare() {
		return this.servershare;
	}

	public void setServershare(ServerShare servershare) {
		this.servershare = servershare;
	}

	public Server getServer() {
		return this.server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public List<ServerShareMountHistory> getServerShareMountHistories() {
		return serverShareMountHistories;
	}

	public void setServerShareMountHistories(
			List<ServerShareMountHistory> serverShareMountHistories) {
		this.serverShareMountHistories = serverShareMountHistories;
	}

}