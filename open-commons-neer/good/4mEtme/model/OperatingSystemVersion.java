package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the DiscoveryState database table.
 * 
 */
@Entity
@Table(name="OperatingSystemVersions")
@NamedQuery(name="OperatingSystemVersion.findAll", query="SELECT o FROM OperatingSystemVersion o")
public class OperatingSystemVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int operatingSystemVersionID;
	private String operatingSystemVersion;
	
	//bi-directional many-to-one association to SupportStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OperatingSystemID")
	private OperatingSystem operatingSystem;
	
	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="operatingSystemVersion")
	private List<Server> servers;

	//bi-directional many-to-one association to SupportStatus
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SupportStatusID")
	private SupportStatus supportstatus;
	
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
	
	public OperatingSystemVersion() {
	}

	public int getOperatingSystemVersionID() {
		return operatingSystemVersionID;
	}

	public void setOperatingSystemVersionID(int operatingSystemVersionID) {
		this.operatingSystemVersionID = operatingSystemVersionID;
	}

	public String getOperatingSystemVersion() {
		return operatingSystemVersion;
	}

	public void setOperatingSystemVersion(String operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(OperatingSystem operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	public SupportStatus getSupportstatus() {
		return supportstatus;
	}

	public void setSupportstatus(SupportStatus supportstatus) {
		this.supportstatus = supportstatus;
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

	public Server addServer(Server server) {
		getServers().add(server);
		server.setOperatingSystemVersion(this);

		return server;
	}

	public Server removeServer(Server server) {
		getServers().remove(server);
		server.setOperatingSystemVersion(null);

		return server;
	}
}