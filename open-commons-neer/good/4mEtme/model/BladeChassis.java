package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the bladechassis database table.
 * 
 */
@Entity
@Table(name = "BladeChassis")
@NamedQuery(name = "BladeChassis.findAll", query = "SELECT b FROM BladeChassis b")
public class BladeChassis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bladeChassisID;

	private String bladeChassisIdentifier;

	// bi-directional many-to-one association to Rack
	@ManyToOne
	@JoinColumn(name = "RackID")
	private Rack rack;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "bladechassis1")
	private List<PhysicalServer> physicalservers1;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "bladechassis2")
	private List<PhysicalServer> physicalservers2;
	
	//bi-directional many-to-one association to BladeChassisHistory
	@OneToMany(mappedBy="bladeChassis")
	private List<BladeChassisHistory> bladeChassisHistories;

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
	
	public BladeChassis() {
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

	public int getBladeChassisID() {
		return this.bladeChassisID;
	}

	public void setBladeChassisID(int bladeChassisID) {
		this.bladeChassisID = bladeChassisID;
	}

	public String getBladeChassisIdentifier() {
		return this.bladeChassisIdentifier;
	}

	public void setBladeChassisIdentifier(String bladeChassisIdentifier) {
		this.bladeChassisIdentifier = bladeChassisIdentifier;
	}

	public Rack getRack() {
		return this.rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public List<PhysicalServer> getPhysicalservers1() {
		return this.physicalservers1;
	}

	public void setPhysicalservers1(List<PhysicalServer> physicalservers1) {
		this.physicalservers1 = physicalservers1;
	}

	public PhysicalServer addPhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().add(physicalservers1);
		physicalservers1.setBladechassis1(this);

		return physicalservers1;
	}

	public PhysicalServer removePhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().remove(physicalservers1);
		physicalservers1.setBladechassis1(null);

		return physicalservers1;
	}

	public List<PhysicalServer> getPhysicalservers2() {
		return this.physicalservers2;
	}

	public void setPhysicalservers2(List<PhysicalServer> physicalservers2) {
		this.physicalservers2 = physicalservers2;
	}

	public List<BladeChassisHistory> getBladeChassisHistories() {
		return bladeChassisHistories;
	}

	public void setBladeChassisHistories(
			List<BladeChassisHistory> bladeChassisHistories) {
		this.bladeChassisHistories = bladeChassisHistories;
	}

	public PhysicalServer addPhysicalservers2(PhysicalServer physicalservers2) {
		getPhysicalservers2().add(physicalservers2);
		physicalservers2.setBladechassis2(this);

		return physicalservers2;
	}

	public PhysicalServer removePhysicalservers2(PhysicalServer physicalservers2) {
		getPhysicalservers2().remove(physicalservers2);
		physicalservers2.setBladechassis2(null);

		return physicalservers2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bladeChassisIdentifier == null) ? 0 : bladeChassisIdentifier.hashCode());
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
		BladeChassis other = (BladeChassis) obj;
		if (bladeChassisIdentifier == null) {
			if (other.bladeChassisIdentifier != null)
				return false;
		} else if (!bladeChassisIdentifier.equals(other.bladeChassisIdentifier))
			return false;
		return true;
	}

}