package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the vmfarms database table.
 * 
 */
@Entity
@Table(name = "VMFarms")
@NamedQuery(name = "VmFarm.findAll", query = "SELECT v FROM VmFarm v")
public class VmFarm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int VMFarmID;

	private String vMFarmName;

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "vmfarm1")
	private List<Server> servers1;

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "vmfarm2")
	private List<Server> servers2;

	// bi-directional many-to-one association to PhysicalServer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PhysicalServerID")
	private PhysicalServer physicalserver;

	// bi-directional many-to-one association to VmHypervisorType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "VMHypervisorTypeID")
	private VmHypervisorType vmhypervisortype;

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
	
	public VmFarm() {
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

	public int getVMFarmID() {
		return this.VMFarmID;
	}

	public void setVMFarmID(int VMFarmID) {
		this.VMFarmID = VMFarmID;
	}

	public String getVMFarmName() {
		return this.vMFarmName;
	}

	public void setVMFarmName(String VMFarmName) {
		this.vMFarmName = VMFarmName;
	}

	public List<Server> getServers1() {
		return this.servers1;
	}

	public void setServers1(List<Server> servers1) {
		this.servers1 = servers1;
	}

	public Server addServers1(Server servers1) {
		getServers1().add(servers1);
		servers1.setVmfarm1(this);

		return servers1;
	}

	public Server removeServers1(Server servers1) {
		getServers1().remove(servers1);
		servers1.setVmfarm1(null);

		return servers1;
	}

	public List<Server> getServers2() {
		return this.servers2;
	}

	public void setServers2(List<Server> servers2) {
		this.servers2 = servers2;
	}

	public Server addServers2(Server servers2) {
		getServers2().add(servers2);
		servers2.setVmfarm2(this);

		return servers2;
	}

	public Server removeServers2(Server servers2) {
		getServers2().remove(servers2);
		servers2.setVmfarm2(null);

		return servers2;
	}

	public PhysicalServer getPhysicalserver() {
		return this.physicalserver;
	}

	public void setPhysicalserver(PhysicalServer physicalserver) {
		this.physicalserver = physicalserver;
	}

	public VmHypervisorType getVmhypervisortype() {
		return this.vmhypervisortype;
	}

	public void setVmhypervisortype(VmHypervisorType vmhypervisortype) {
		this.vmhypervisortype = vmhypervisortype;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vMFarmName == null) ? 0 : vMFarmName.hashCode());
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
		VmFarm other = (VmFarm) obj;
		if (vMFarmName == null) {
			if (other.vMFarmName != null)
				return false;
		} else if (!vMFarmName.equals(other.vMFarmName))
			return false;
		return true;
	}

}