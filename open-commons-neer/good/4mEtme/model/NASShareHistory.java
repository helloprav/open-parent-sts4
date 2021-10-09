package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;

/**
 * The persistent class for the NASShareHistory database table.
 * 
 */
@Entity
@Table(name = "NASShareHistory")
@NamedQuery(name = "NASShareHistory.findAll", query = "SELECT nh FROM NASShareHistory nh")
public class NASShareHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int NASShareHistoryID;
	private int versionNumber;
	
	private int availableGB;
	
	@ManyToOne
	@JoinColumn(name="NASShareID")
	private Nasshare nasshare;

	@Column(name="NASShareName")
	private String nASShareName;

	private int usedGB;
	
	private String targetDisposition;

	// bi-directional many-to-one association to StorageService
	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "StorageServiceID")
	private StorageService storageservice;

	//bi-directional many-to-one association to DiscoveryState
	@ManyToOne
	@JoinColumn(name="DiscoveryStateID")
	private DiscoveryState discoverystate;
	
	//bi-directional many-to-one association to MigrationScope
	@ManyToOne
	@JoinColumn(name="MigrationScopeID")
	private MigrationScope migrationscope;

	//bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name="CurrentDispositionID")
	private Disposition disposition1;

	/*//bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name="TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	private Date lastUpdatedDate;

	public int getNASShareHistoryID() {
		return NASShareHistoryID;
	}

	public void setNASShareHistoryID(int nASShareHistoryID) {
		NASShareHistoryID = nASShareHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getAvailableGB() {
		return availableGB;
	}

	public void setAvailableGB(int availableGB) {
		this.availableGB = availableGB;
	}

	public Nasshare getNasshare() {
		return nasshare;
	}

	public void setNasshare(Nasshare nasshare) {
		this.nasshare = nasshare;
	}

	public String getnASShareName() {
		return nASShareName;
	}

	public void setnASShareName(String nASShareName) {
		this.nASShareName = nASShareName;
	}

	public int getUsedGB() {
		return usedGB;
	}

	public void setUsedGB(int usedGB) {
		this.usedGB = usedGB;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public StorageService getStorageservice() {
		return storageservice;
	}

	public void setStorageservice(StorageService storageservice) {
		this.storageservice = storageservice;
	}

	public DiscoveryState getDiscoverystate() {
		return discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}

	public MigrationScope getMigrationscope() {
		return migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public Disposition getDisposition1() {
		return disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public MoveGroup getMovegroup() {
		return movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
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

	public NASShareHistory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}