package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Cacheable(true)
@Table(name="ServerInstalledSoftwareHistory")
@NamedQuery(name="ServerInstalledSoftwareHistory.findAll", query="SELECT ssh FROM ServerInstalledSoftwareHistory ssh")
public class ServerInstalledSoftwareHistory implements Serializable {

	private static final long serialVersionUID = 6356330454967868361L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int serverInstalledSoftwareHistoryID;
	
	private int versionNumber;
	
	@ManyToOne
	@JoinColumn(name="serverInstalledSoftwareID")
	private ServerInstalledSoftware serverInstalledSoftware;
	
	private String notes;

	//bi-directional many-to-one association to Server
	@ManyToOne
	@JoinColumn(name="ServerID")
	private Server server;

	//bi-directional many-to-one association to SoftwareVersion
	@ManyToOne
	@JoinColumn(name="SoftwareVersionID")
	private SoftwareVersion softwareversion;
	
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
	
	public ServerInstalledSoftwareHistory() {
	}

	public int getServerInstalledSoftwareHistoryID() {
		return serverInstalledSoftwareHistoryID;
	}

	public void setServerInstalledSoftwareHistoryID(
			int serverInstalledSoftwareHistoryID) {
		this.serverInstalledSoftwareHistoryID = serverInstalledSoftwareHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public ServerInstalledSoftware getServerInstalledSoftware() {
		return serverInstalledSoftware;
	}

	public void setServerInstalledSoftware(
			ServerInstalledSoftware serverInstalledSoftware) {
		this.serverInstalledSoftware = serverInstalledSoftware;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public SoftwareVersion getSoftwareversion() {
		return softwareversion;
	}

	public void setSoftwareversion(SoftwareVersion softwareversion) {
		this.softwareversion = softwareversion;
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
