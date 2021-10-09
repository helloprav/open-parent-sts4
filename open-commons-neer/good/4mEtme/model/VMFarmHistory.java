package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Cacheable(true)
@Table(name="VMFarmHistory")
@NamedQuery(name="VMFarmHistory.findAll", query="SELECT vfh FROM VMFarmHistory vfh")
public class VMFarmHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vMFarmHistoryID;
	
	private int versionNumber;
	
	@ManyToOne
	@JoinColumn(name="VMFarmID")
	private VmFarm vmFarm;

	private String vMFarmName;

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "vmfarm1")
	private List<Server> servers1;

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "vmfarm2")
	private List<Server> servers2;

	// bi-directional many-to-one association to PhysicalServer
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PhysicalServerID")
	private PhysicalServer physicalserver;

	// bi-directional many-to-one association to VmHypervisorType
	@ManyToOne(cascade = { CascadeType.MERGE })
	@JoinColumn(name = "VMHypervisorTypeID")
	private VmHypervisorType vmhypervisortype;

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
	
	public void VmFarmHistory() {
	}

	public int getvMFarmHistoryID() {
		return vMFarmHistoryID;
	}

	public void setvMFarmHistoryID(int vMFarmHistoryID) {
		this.vMFarmHistoryID = vMFarmHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public VmFarm getVmFarm() {
		return vmFarm;
	}

	public void setVmFarm(VmFarm vmFarm) {
		this.vmFarm = vmFarm;
	}

	public String getvMFarmName() {
		return vMFarmName;
	}

	public void setvMFarmName(String vMFarmName) {
		this.vMFarmName = vMFarmName;
	}

	public List<Server> getServers1() {
		return servers1;
	}

	public void setServers1(List<Server> servers1) {
		this.servers1 = servers1;
	}

	public List<Server> getServers2() {
		return servers2;
	}

	public void setServers2(List<Server> servers2) {
		this.servers2 = servers2;
	}

	public PhysicalServer getPhysicalserver() {
		return physicalserver;
	}

	public void setPhysicalserver(PhysicalServer physicalserver) {
		this.physicalserver = physicalserver;
	}

	public VmHypervisorType getVmhypervisortype() {
		return vmhypervisortype;
	}

	public void setVmhypervisortype(VmHypervisorType vmhypervisortype) {
		this.vmhypervisortype = vmhypervisortype;
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
