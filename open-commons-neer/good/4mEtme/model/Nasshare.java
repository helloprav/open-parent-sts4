package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the nasshares database table.
 * 
 */
@Entity
@Table(name = "NASShares")
@NamedQuery(name = "Nasshare.findAll", query = "SELECT n FROM Nasshare n")
public class Nasshare implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int NASShareID;

	private int availableGB;

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

	// bi-directional many-to-one association to ServerShareMount
	@OneToMany(mappedBy = "nasshare")
	private List<ServerShareMount> serversharemounts;
	
	// bi-directional many-to-one association to ServerShareMountHistory
	@OneToMany(mappedBy = "nasshare")
	private List<ServerShareMountHistory> serverShareMountHistories;

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
	
	public Nasshare() {
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

	public int getNASShareID() {
		return this.NASShareID;
	}

	public void setNASShareID(int NASShareID) {
		this.NASShareID = NASShareID;
	}

	public int getAvailableGB() {
		return this.availableGB;
	}

	public void setAvailableGB(int availableGB) {
		this.availableGB = availableGB;
	}

	public String getNASShareName() {
		return this.nASShareName;
	}

	public void setNASShareName(String NASShareName) {
		this.nASShareName = NASShareName;
	}

	public int getUsedGB() {
		return this.usedGB;
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
		return this.storageservice;
	}

	public void setStorageservice(StorageService storageservice) {
		this.storageservice = storageservice;
	}

	public String getnASShareName() {
		return nASShareName;
	}

	public void setnASShareName(String nASShareName) {
		this.nASShareName = nASShareName;
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

	public List<ServerShareMount> getServersharemounts() {
		return this.serversharemounts;
	}

	public void setServersharemounts(List<ServerShareMount> serversharemounts) {
		this.serversharemounts = serversharemounts;
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
		serversharemount.setNasshare(this);

		return serversharemount;
	}

	public ServerShareMount removeServersharemount(ServerShareMount serversharemount) {
		getServersharemounts().remove(serversharemount);
		serversharemount.setNasshare(null);

		return serversharemount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nASShareName == null) ? 0 : nASShareName.hashCode());
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
		Nasshare other = (Nasshare) obj;
		if (nASShareName == null) {
			if (other.nASShareName != null)
				return false;
		} else if (!nASShareName.equals(other.nASShareName))
			return false;
		return true;
	}

}