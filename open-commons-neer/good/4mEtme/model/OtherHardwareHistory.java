package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the OtherHardwareHistory database table.
 * 
 */
@Entity
@Table(name="OtherHardwareHistory")
@NamedQuery(name="OtherHardwareHistory.findAll", query="SELECT ohh FROM OtherHardwareHistory ohh")
public class OtherHardwareHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int otherHardwareHistoryID;
	private int versionNumber;
	
	@ManyToOne
	@JoinColumn(name="otherHardwareID")
	private OtherHardware otherHardware;

	private String otherHardwareName;
	
	private String targetDisposition;
	
	//bi-directional many-to-one association to OtherHardwareType
	@ManyToOne
	@JoinColumn(name="otherHardwareTypeID")
	private OtherHardwareType otherHardwareType;

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

	// bi-directional many-to-one association to FloorLocation
	@ManyToOne
	@JoinColumn(name = "FloorLocationID")
	private FloorLocation floorlocation1;

	// bi-directional many-to-one association to FloorLocation
	@ManyToOne
	@JoinColumn(name = "TargetFloorLocationID")
	private FloorLocation floorlocation2;

	// bi-directional many-to-one association to Rack
	@ManyToOne
	@JoinColumn(name = "RackID")
	private Rack rack1;

	// bi-directional many-to-one association to Rack
	@ManyToOne
	@JoinColumn(name = "TargetRackID")
	private Rack rack2;
		
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

	public OtherHardwareHistory() {
	}

	public int getOtherHardwareHistoryID() {
		return otherHardwareHistoryID;
	}

	public void setOtherHardwareHistoryID(int otherHardwareHistoryID) {
		this.otherHardwareHistoryID = otherHardwareHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public OtherHardware getOtherHardware() {
		return otherHardware;
	}

	public void setOtherHardware(OtherHardware otherHardware) {
		this.otherHardware = otherHardware;
	}

	public String getOtherHardwareName() {
		return otherHardwareName;
	}

	public void setOtherHardwareName(String otherHardwareName) {
		this.otherHardwareName = otherHardwareName;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public OtherHardwareType getOtherHardwareType() {
		return otherHardwareType;
	}

	public void setOtherHardwareType(OtherHardwareType otherHardwareType) {
		this.otherHardwareType = otherHardwareType;
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

	public FloorLocation getFloorlocation1() {
		return floorlocation1;
	}

	public void setFloorlocation1(FloorLocation floorlocation1) {
		this.floorlocation1 = floorlocation1;
	}

	public FloorLocation getFloorlocation2() {
		return floorlocation2;
	}

	public void setFloorlocation2(FloorLocation floorlocation2) {
		this.floorlocation2 = floorlocation2;
	}

	public Rack getRack1() {
		return rack1;
	}

	public void setRack1(Rack rack1) {
		this.rack1 = rack1;
	}

	public Rack getRack2() {
		return rack2;
	}

	public void setRack2(Rack rack2) {
		this.rack2 = rack2;
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
