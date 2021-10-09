package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the softwareversions database table.
 * 
 */
@Entity
@Table(name="SoftwareVersions")
@NamedQuery(name="SoftwareVersion.findAll", query="SELECT s FROM SoftwareVersion s")
public class SoftwareVersion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int softwareVersionID;

	private String softwareVersionName;

	private int versionOrderNumber;

	//bi-directional many-to-one association to ApplicationComponentSoftwareRequirement
	@OneToMany(mappedBy="softwareversion")
	private List<ApplicationComponentSoftwareRequirement> applicationcomponentsoftwarerequirements;

	//bi-directional many-to-one association to ServerInstalledSoftware
	@OneToMany(mappedBy="softwareversion")
	private List<ServerInstalledSoftware> serverinstalledsoftwares;

	//bi-directional many-to-one association to Software
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SoftwareID")
	private Software software;

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

	public SoftwareVersion() {
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

	public int getSoftwareVersionID() {
		return this.softwareVersionID;
	}

	public void setSoftwareVersionID(int softwareVersionID) {
		this.softwareVersionID = softwareVersionID;
	}

	public String getSoftwareVersionName() {
		return this.softwareVersionName;
	}

	public void setSoftwareVersionName(String softwareVersionName) {
		this.softwareVersionName = softwareVersionName;
	}

	public int getVersionOrderNumber() {
		return this.versionOrderNumber;
	}

	public void setVersionOrderNumber(int versionOrderNumber) {
		this.versionOrderNumber = versionOrderNumber;
	}

	public List<ApplicationComponentSoftwareRequirement> getApplicationcomponentsoftwarerequirements() {
		return this.applicationcomponentsoftwarerequirements;
	}

	public void setApplicationcomponentsoftwarerequirements(List<ApplicationComponentSoftwareRequirement> applicationcomponentsoftwarerequirements) {
		this.applicationcomponentsoftwarerequirements = applicationcomponentsoftwarerequirements;
	}

	public ApplicationComponentSoftwareRequirement addApplicationcomponentsoftwarerequirement(ApplicationComponentSoftwareRequirement applicationcomponentsoftwarerequirement) {
		getApplicationcomponentsoftwarerequirements().add(applicationcomponentsoftwarerequirement);
		applicationcomponentsoftwarerequirement.setSoftwareversion(this);

		return applicationcomponentsoftwarerequirement;
	}

	public ApplicationComponentSoftwareRequirement removeApplicationcomponentsoftwarerequirement(ApplicationComponentSoftwareRequirement applicationcomponentsoftwarerequirement) {
		getApplicationcomponentsoftwarerequirements().remove(applicationcomponentsoftwarerequirement);
		applicationcomponentsoftwarerequirement.setSoftwareversion(null);

		return applicationcomponentsoftwarerequirement;
	}

	public List<ServerInstalledSoftware> getServerinstalledsoftwares() {
		return this.serverinstalledsoftwares;
	}

	public void setServerinstalledsoftwares(List<ServerInstalledSoftware> serverinstalledsoftwares) {
		this.serverinstalledsoftwares = serverinstalledsoftwares;
	}

	public ServerInstalledSoftware addServerinstalledsoftware(ServerInstalledSoftware serverinstalledsoftware) {
		getServerinstalledsoftwares().add(serverinstalledsoftware);
		serverinstalledsoftware.setSoftwareversion(this);

		return serverinstalledsoftware;
	}

	public ServerInstalledSoftware removeServerinstalledsoftware(ServerInstalledSoftware serverinstalledsoftware) {
		getServerinstalledsoftwares().remove(serverinstalledsoftware);
		serverinstalledsoftware.setSoftwareversion(null);

		return serverinstalledsoftware;
	}

	public Software getSoftware() {
		return this.software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public SupportStatus getSupportstatus() {
		return this.supportstatus;
	}

	public void setSupportstatus(SupportStatus supportstatus) {
		this.supportstatus = supportstatus;
	}

}