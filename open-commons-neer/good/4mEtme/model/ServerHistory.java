package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the servers database table.
 * 
 */
@Entity
@Table(name = "ServerHistory")
@NamedQuery(name = "ServerHistory.findAll", query = "SELECT sh FROM ServerHistory sh")
public class ServerHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serverhistoryID;
	private int versionNumber;
	
	private String serverName;
	private String serialNumber; 
	private String cpuType; 
	private int cpuCount; 
	private String cpuSpeed; 
	private int memoryGB; 
	private String FQDN; 
	private String modelDescription;
	private String notes;
	private String changeControlNumber;
	private String targetDisposition;
	private String customField1;
	private String customField2;
	private String customField3;
	
	// bi-directional many-to-one association to DiscoveryState
	@ManyToOne
	@JoinColumn(name = "ServerID")
	private Server server;

	// bi-directional many-to-one association to DiscoveryState
	@ManyToOne
	@JoinColumn(name = "DiscoveryStateID")
	private DiscoveryState discoverystate;

	// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	// bi-directional many-to-one association to PhysicalServer
	@ManyToOne
	@JoinColumn(name = "PhysicalServerID")
	private PhysicalServer physicalserver1;

	// bi-directional many-to-one association to PhysicalServer
	@ManyToOne
	@JoinColumn(name = "TargetPhysicalServerID")
	private PhysicalServer physicalserver2;

	// bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name = "CurrentSLAID")
	private SLA sla1;

	// bi-directional many-to-one association to SLA
	@ManyToOne
	@JoinColumn(name = "TargetSLAID")
	private SLA sla2;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "SupportContactID")
	private User user;

	// bi-directional many-to-one association to VmFarm
	@ManyToOne
	@JoinColumn(name = "VMFarmID")
	private VmFarm vmfarm1;

	// bi-directional many-to-one association to VmFarm
	@ManyToOne
	@JoinColumn(name = "TargetVMFarmID")
	private VmFarm vmfarm2;
	
	@ManyToOne
	@JoinColumn(name = "OperatingSystemVersionID")
	private OperatingSystemVersion operatingSystemVersion;
	
	// bi-directional many-to-one association to ChangeControlDecision
	@ManyToOne
	@JoinColumn(name = "ChangeControlDecisionID")
	private ChangeControlDecision changeControlDecision;
	
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

	public ServerHistory() {
	}

	public int getServerhistoryID() {
		return serverhistoryID;
	}

	public void setServerhistoryID(int serverhistoryID) {
		this.serverhistoryID = serverhistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCpuType() {
		return cpuType;
	}

	public void setCpuType(String cpuType) {
		this.cpuType = cpuType;
	}

	public int getCpuCount() {
		return cpuCount;
	}

	public void setCpuCount(int cpuCount) {
		this.cpuCount = cpuCount;
	}

	public String getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(String cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public int getMemoryGB() {
		return memoryGB;
	}

	public void setMemoryGB(int memoryGB) {
		this.memoryGB = memoryGB;
	}

	public String getFQDN() {
		return FQDN;
	}

	public void setFQDN(String fQDN) {
		FQDN = fQDN;
	}

	public String getModelDescription() {
		return modelDescription;
	}

	public void setModelDescription(String modelDescription) {
		this.modelDescription = modelDescription;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getChangeControlNumber() {
		return changeControlNumber;
	}

	public void setChangeControlNumber(String changeControlNumber) {
		this.changeControlNumber = changeControlNumber;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public String getCustomField1() {
		return customField1;
	}

	public void setCustomField1(String customField1) {
		this.customField1 = customField1;
	}

	public String getCustomField2() {
		return customField2;
	}

	public void setCustomField2(String customField2) {
		this.customField2 = customField2;
	}

	public String getCustomField3() {
		return customField3;
	}

	public void setCustomField3(String customField3) {
		this.customField3 = customField3;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public DiscoveryState getDiscoverystate() {
		return discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}

	public Disposition getDisposition1() {
		return disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public MigrationScope getMigrationscope() {
		return migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public MoveGroup getMovegroup() {
		return movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public PhysicalServer getPhysicalserver1() {
		return physicalserver1;
	}

	public void setPhysicalserver1(PhysicalServer physicalserver1) {
		this.physicalserver1 = physicalserver1;
	}

	public PhysicalServer getPhysicalserver2() {
		return physicalserver2;
	}

	public void setPhysicalserver2(PhysicalServer physicalserver2) {
		this.physicalserver2 = physicalserver2;
	}

	public SLA getSla1() {
		return sla1;
	}

	public void setSla1(SLA sla1) {
		this.sla1 = sla1;
	}

	public SLA getSla2() {
		return sla2;
	}

	public void setSla2(SLA sla2) {
		this.sla2 = sla2;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VmFarm getVmfarm1() {
		return vmfarm1;
	}

	public void setVmfarm1(VmFarm vmfarm1) {
		this.vmfarm1 = vmfarm1;
	}

	public VmFarm getVmfarm2() {
		return vmfarm2;
	}

	public void setVmfarm2(VmFarm vmfarm2) {
		this.vmfarm2 = vmfarm2;
	}

	public OperatingSystemVersion getOperatingSystemVersion() {
		return operatingSystemVersion;
	}

	public void setOperatingSystemVersion(
			OperatingSystemVersion operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public ChangeControlDecision getChangeControlDecision() {
		return changeControlDecision;
	}

	public void setChangeControlDecision(ChangeControlDecision changeControlDecision) {
		this.changeControlDecision = changeControlDecision;
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