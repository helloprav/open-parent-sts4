package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the migrationslots database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="MigrationSlots")
@NamedQuery(name="MigrationSlot.findAll", query="SELECT m FROM MigrationSlot m")
public class MigrationSlot implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int migrationSlotID;

	@Temporal(TemporalType.DATE)
	private Date migrationSlotExecutionDate;

	private String migrationSlotName;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="MigrationSlotOwnerID")
	private User user;
	
	//bi-directional many-to-one association to MoveGroup
	@OneToMany(mappedBy="migrationslot")
	private List<MoveGroup> movegroups;
	
	public MigrationSlot() {
	}

	public int getMigrationSlotID() {
		return this.migrationSlotID;
	}

	public void setMigrationSlotID(int migrationSlotID) {
		this.migrationSlotID = migrationSlotID;
	}

	public Date getMigrationSlotExecutionDate() {
		return this.migrationSlotExecutionDate;
	}

	public void setMigrationSlotExecutionDate(Date migrationSlotExecutionDate) {
		this.migrationSlotExecutionDate = migrationSlotExecutionDate;
	}

	public String getMigrationSlotName() {
		return this.migrationSlotName;
	}

	public void setMigrationSlotName(String migrationSlotName) {
		this.migrationSlotName = migrationSlotName;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<MoveGroup> getMovegroups() {
		return this.movegroups;
	}

	public void setMovegroups(List<MoveGroup> movegroups) {
		this.movegroups = movegroups;
	}

	public MoveGroup addMovegroup(MoveGroup movegroup) {
		getMovegroups().add(movegroup);
		movegroup.setMigrationslot(this);

		return movegroup;
	}

	public MoveGroup removeMovegroup(MoveGroup movegroup) {
		getMovegroups().remove(movegroup);
		movegroup.setMigrationslot(null);

		return movegroup;
	}
	
}