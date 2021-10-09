package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the vmhypervisortypes database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name = "VMHypervisorTypes")
@NamedQuery(name = "VmHypervisorType.findAll", query = "SELECT v FROM VmHypervisorType v")
public class VmHypervisorType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int VMHypervisorTypeID;

	private String vMHypervisorTypeName;

	// bi-directional many-to-one association to VmFarm
	@OneToMany(mappedBy = "vmhypervisortype", cascade = { CascadeType.ALL })
	private List<VmFarm> vmfarms;

	public VmHypervisorType() {
	}

	public int getVMHypervisorTypeID() {
		return this.VMHypervisorTypeID;
	}

	public void setVMHypervisorTypeID(int VMHypervisorTypeID) {
		this.VMHypervisorTypeID = VMHypervisorTypeID;
	}

	public String getVMHypervisorTypeName() {
		return this.vMHypervisorTypeName;
	}

	public void setVMHypervisorTypeName(String vMHypervisorTypeName) {
		this.vMHypervisorTypeName = vMHypervisorTypeName;
	}

	public List<VmFarm> getVmfarms() {
		return this.vmfarms;
	}

	public void setVmfarms(List<VmFarm> vmfarms) {
		this.vmfarms = vmfarms;
	}

	public VmFarm addVmfarm(VmFarm vmfarm) {
		getVmfarms().add(vmfarm);
		vmfarm.setVmhypervisortype(this);

		return vmfarm;
	}

	public VmFarm removeVmfarm(VmFarm vmfarm) {
		getVmfarms().remove(vmfarm);
		vmfarm.setVmhypervisortype(null);

		return vmfarm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vMHypervisorTypeName == null) ? 0 : vMHypervisorTypeName.hashCode());
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
		VmHypervisorType other = (VmHypervisorType) obj;
		if (vMHypervisorTypeName == null) {
			if (other.vMHypervisorTypeName != null)
				return false;
		} else if (!vMHypervisorTypeName.equals(other.vMHypervisorTypeName))
			return false;
		return true;
	}

}