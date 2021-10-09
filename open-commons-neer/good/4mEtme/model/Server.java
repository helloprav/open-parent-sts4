package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the servers database table.
 * 
 */
@Entity
@Table(name = "Servers")
@NamedQuery(name = "Server.findAll", query = "SELECT s FROM Server s")
public class Server implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int serverID;

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
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DiscoveryStateID")
	private DiscoveryState discoverystate;

	// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

	// bi-directional many-to-one association to PhysicalServer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "PhysicalServerID")
	private PhysicalServer physicalserver1;

	// bi-directional many-to-one association to PhysicalServer
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetPhysicalServerID")
	private PhysicalServer physicalserver2;

	// bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentSLAID")
	private SLA sla1;

	// bi-directional many-to-one association to SLA
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetSLAID")
	private SLA sla2;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "SupportContactID")
	private User user;

	// bi-directional many-to-one association to VmFarm
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "VMFarmID")
	private VmFarm vmfarm1;

	// bi-directional many-to-one association to VmFarm
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetVMFarmID")
	private VmFarm vmfarm2;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "OperatingSystemVersionID")
	private OperatingSystemVersion operatingSystemVersion;
	
	// bi-directional many-to-one association to ChangeControlDecision
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ChangeControlDecisionID")
	private ChangeControlDecision changeControlDecision;

	// bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy = "server1")
	private List<ApplicationComponentInstance> applicationcomponentinstances1;

	// bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy = "server2")
	private List<ApplicationComponentInstance> applicationcomponentinstances2;

	// bi-directional many-to-one association to ServerDAS
	@OneToMany(mappedBy = "server")
	private List<ServerDAS> serverdas;

	// bi-directional many-to-one association to ServerDAS
	@OneToMany(mappedBy = "server")
	private List<ServerNIC> servernic;
	
	// bi-directional many-to-one association to ServerInstalledSoftware
	@OneToMany(mappedBy = "server")
	private List<ServerInstalledSoftware> serverinstalledsoftwares;

	// bi-directional many-to-one association to ServerMaintenanceOperation
	@OneToMany(mappedBy = "server")
	private List<ServerMaintenanceOperation> servermaintenanceoperations;

	// bi-directional many-to-one association to ServerMigrationMethod
//	@OneToMany(mappedBy = "server")
//	private List<ServerMigrationMethod> servermigrationmethods;

	// bi-directional many-to-one association to ServerRole
//	@OneToMany(mappedBy = "server")
//	private List<ServerRole> serverroles;

	// bi-directional many-to-one association to ServerSANConnection
	@OneToMany(mappedBy = "server")
	private List<ServerSANConnection> serversanconnections;

	// bi-directional many-to-one association to ServerShareMount
	@OneToMany(mappedBy = "server")
	private List<ServerShareMount> serversharemounts;

	// bi-directional many-to-one association to ServerShare
	@OneToMany(mappedBy = "server")
	private List<ServerShare> servershares;

	// bi-directional many-to-one association to ServersInServerCluster
	@OneToMany(mappedBy = "server")
	private List<ServersInServerCluster> serversinserverclusters;
	
	// bi-directional many-to-one association to ServersInServerClusterHistory
	@OneToMany(mappedBy = "server")
	private List<ServersInServerClusterHistory> serversInServerClusterHistories;
	
	// bi-directional many-to-one association to ServerNICHistory
	@OneToMany(mappedBy = "server")
	private List<ServerNICHistory> serverNICHistories;
	
	// bi-directional many-to-one association to ServerDASHistory
	@OneToMany(mappedBy = "server")
	private List<ServerDASHistory> serverDASHistories;
	
	// bi-directional many-to-one association to ServerShareHistory
	@OneToMany(mappedBy = "server")
	private List<ServerShareHistory> serverShareHistories;
	
	// bi-directional many-to-one association to ServerShareMountHistory
	@OneToMany(mappedBy = "server")
	private List<ServerShareMountHistory> serverShareMountHistories;
	
	// bi-directional many-to-one association to ServerSANConnectionHistory
	@OneToMany(mappedBy = "server")
	private List<ServerSANConnectionHistory> serverSANConnectionHistories;

	// bi-directional many-to-one association to ServerTransformationMethod
//	@OneToMany(mappedBy = "server")
//	private List<ServerTransformationMethod> servertransformationmethods;

	// bi-directional many-to-one association to TaskTracking
	//@OneToMany(mappedBy = "server")
	//private List<TaskTracking> tasktrackings;
	
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

	public Server() {
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

	public int getServerID() {
		return this.serverID;
	}

	public void setServerID(int serverID) {
		this.serverID = serverID;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
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

	public List<ApplicationComponentInstance> getApplicationcomponentinstances1() {
		return this.applicationcomponentinstances1;
	}

	public void setApplicationcomponentinstances1(List<ApplicationComponentInstance> applicationcomponentinstances1) {
		this.applicationcomponentinstances1 = applicationcomponentinstances1;
	}

	public ApplicationComponentInstance addApplicationcomponentinstances1(
			ApplicationComponentInstance applicationcomponentinstances1) {
		getApplicationcomponentinstances1().add(applicationcomponentinstances1);
		applicationcomponentinstances1.setServer1(this);

		return applicationcomponentinstances1;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstances1(
			ApplicationComponentInstance applicationcomponentinstances1) {
		getApplicationcomponentinstances1().remove(applicationcomponentinstances1);
		applicationcomponentinstances1.setServer1(null);

		return applicationcomponentinstances1;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances2() {
		return this.applicationcomponentinstances2;
	}

	public void setApplicationcomponentinstances2(List<ApplicationComponentInstance> applicationcomponentinstances2) {
		this.applicationcomponentinstances2 = applicationcomponentinstances2;
	}

	public ApplicationComponentInstance addApplicationcomponentinstances2(
			ApplicationComponentInstance applicationcomponentinstances2) {
		getApplicationcomponentinstances2().add(applicationcomponentinstances2);
		applicationcomponentinstances2.setServer2(this);

		return applicationcomponentinstances2;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstances2(
			ApplicationComponentInstance applicationcomponentinstances2) {
		getApplicationcomponentinstances2().remove(applicationcomponentinstances2);
		applicationcomponentinstances2.setServer2(null);

		return applicationcomponentinstances2;
	}

	public List<ServerDAS> getServerdas() {
		return this.serverdas;
	}

	public void setServerdas(List<ServerDAS> serverdas) {
		this.serverdas = serverdas;
	}

	public ServerDAS addServerdas(ServerDAS serverdas) {
		getServerdas().add(serverdas);
		serverdas.setServer(this);

		return serverdas;
	}

	public ServerDAS removeServerdas(ServerDAS serverdas) {
		getServerdas().remove(serverdas);
		serverdas.setServer(null);

		return serverdas;
	}

	public List<ServerNIC> getServernic() {
		return this.servernic;
	}

	public void setServernic(List<ServerNIC> servernic) {
		this.servernic = servernic;
	}

	public ServerNIC addServernic(ServerNIC servernic) {
		getServernic().add(servernic);
		servernic.setServer(this);

		return servernic;
	}

	public ServerNIC removeServernic(ServerNIC servernic) {
		getServernic().remove(servernic);
		servernic.setServer(null);

		return servernic;
	}

	public List<ServerInstalledSoftware> getServerinstalledsoftwares() {
		return this.serverinstalledsoftwares;
	}

	public void setServerinstalledsoftwares(List<ServerInstalledSoftware> serverinstalledsoftwares) {
		this.serverinstalledsoftwares = serverinstalledsoftwares;
	}

	public ServerInstalledSoftware addServerinstalledsoftware(ServerInstalledSoftware serverinstalledsoftware) {
		getServerinstalledsoftwares().add(serverinstalledsoftware);
		serverinstalledsoftware.setServer(this);

		return serverinstalledsoftware;
	}

	public ServerInstalledSoftware removeServerinstalledsoftware(ServerInstalledSoftware serverinstalledsoftware) {
		getServerinstalledsoftwares().remove(serverinstalledsoftware);
		serverinstalledsoftware.setServer(null);

		return serverinstalledsoftware;
	}

	public List<ServerMaintenanceOperation> getServermaintenanceoperations() {
		return this.servermaintenanceoperations;
	}

	public void setServermaintenanceoperations(List<ServerMaintenanceOperation> servermaintenanceoperations) {
		this.servermaintenanceoperations = servermaintenanceoperations;
	}

	public ServerMaintenanceOperation addServermaintenanceoperation(
			ServerMaintenanceOperation servermaintenanceoperation) {
		getServermaintenanceoperations().add(servermaintenanceoperation);
		servermaintenanceoperation.setServer(this);

		return servermaintenanceoperation;
	}

	public ServerMaintenanceOperation removeServermaintenanceoperation(
			ServerMaintenanceOperation servermaintenanceoperation) {
		getServermaintenanceoperations().remove(servermaintenanceoperation);
		servermaintenanceoperation.setServer(null);

		return servermaintenanceoperation;
	}

	public DiscoveryState getDiscoverystate() {
		return this.discoverystate;
	}

	public void setDiscoverystate(DiscoveryState discoverystate) {
		this.discoverystate = discoverystate;
	}

	public Disposition getDisposition1() {
		return this.disposition1;
	}

	public void setDisposition1(Disposition disposition1) {
		this.disposition1 = disposition1;
	}

	public MigrationScope getMigrationscope() {
		return this.migrationscope;
	}

	public void setMigrationscope(MigrationScope migrationscope) {
		this.migrationscope = migrationscope;
	}

	public MoveGroup getMovegroup() {
		return this.movegroup;
	}

	public void setMovegroup(MoveGroup movegroup) {
		this.movegroup = movegroup;
	}

	public PhysicalServer getPhysicalserver1() {
		return this.physicalserver1;
	}

	public void setPhysicalserver1(PhysicalServer physicalserver1) {
		this.physicalserver1 = physicalserver1;
	}

	public PhysicalServer getPhysicalserver2() {
		return this.physicalserver2;
	}

	public void setPhysicalserver2(PhysicalServer physicalserver2) {
		this.physicalserver2 = physicalserver2;
	}

	public SLA getSla1() {
		return this.sla1;
	}

	public void setSla1(SLA sla1) {
		this.sla1 = sla1;
	}

	public SLA getSla2() {
		return this.sla2;
	}

	public void setSla2(SLA sla2) {
		this.sla2 = sla2;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public VmFarm getVmfarm1() {
		return this.vmfarm1;
	}

	public void setVmfarm1(VmFarm vmfarm1) {
		this.vmfarm1 = vmfarm1;
	}

	public VmFarm getVmfarm2() {
		return this.vmfarm2;
	}

	public void setVmfarm2(VmFarm vmfarm2) {
		this.vmfarm2 = vmfarm2;
	}

	public List<ServerSANConnection> getServersanconnections() {
		return this.serversanconnections;
	}

	public void setServersanconnections(List<ServerSANConnection> serversanconnections) {
		this.serversanconnections = serversanconnections;
	}

	public ServerSANConnection addServersanconnection(ServerSANConnection serversanconnection) {
		getServersanconnections().add(serversanconnection);
		serversanconnection.setServer(this);

		return serversanconnection;
	}

	public ServerSANConnection removeServersanconnection(ServerSANConnection serversanconnection) {
		getServersanconnections().remove(serversanconnection);
		serversanconnection.setServer(null);

		return serversanconnection;
	}

	public List<ServerShareMount> getServersharemounts() {
		return this.serversharemounts;
	}

	public void setServersharemounts(List<ServerShareMount> serversharemounts) {
		this.serversharemounts = serversharemounts;
	}

	public ServerShareMount addServersharemount(ServerShareMount serversharemount) {
		getServersharemounts().add(serversharemount);
		serversharemount.setServer(this);

		return serversharemount;
	}

	public ServerShareMount removeServersharemount(ServerShareMount serversharemount) {
		getServersharemounts().remove(serversharemount);
		serversharemount.setServer(null);

		return serversharemount;
	}

	public List<ServerShare> getServershares() {
		return this.servershares;
	}

	public void setServershares(List<ServerShare> servershares) {
		this.servershares = servershares;
	}

	public ServerShare addServershare(ServerShare servershare) {
		getServershares().add(servershare);
		servershare.setServer(this);

		return servershare;
	}

	public ServerShare removeServershare(ServerShare servershare) {
		getServershares().remove(servershare);
		servershare.setServer(null);

		return servershare;
	}

	public List<ServersInServerCluster> getServersinserverclusters() {
		return this.serversinserverclusters;
	}

	public void setServersinserverclusters(List<ServersInServerCluster> serversinserverclusters) {
		this.serversinserverclusters = serversinserverclusters;
	}

	public ServersInServerCluster addServersinservercluster(ServersInServerCluster serversinservercluster) {
		getServersinserverclusters().add(serversinservercluster);
		serversinservercluster.setServer(this);

		return serversinservercluster;
	}

	public ServersInServerCluster removeServersinservercluster(ServersInServerCluster serversinservercluster) {
		getServersinserverclusters().remove(serversinservercluster);
		serversinservercluster.setServer(null);

		return serversinservercluster;
	}

	public List<ServersInServerClusterHistory> getServersInServerClusterHistories() {
		return serversInServerClusterHistories;
	}

	public void setServersInServerClusterHistories(
			List<ServersInServerClusterHistory> serversInServerClusterHistories) {
		this.serversInServerClusterHistories = serversInServerClusterHistories;
	}

	public List<ServerNICHistory> getServerNICHistories() {
		return serverNICHistories;
	}

	public void setServerNICHistories(List<ServerNICHistory> serverNICHistories) {
		this.serverNICHistories = serverNICHistories;
	}

	public List<ServerDASHistory> getServerDASHistories() {
		return serverDASHistories;
	}

	public void setServerDASHistories(List<ServerDASHistory> serverDASHistories) {
		this.serverDASHistories = serverDASHistories;
	}

	public List<ServerShareHistory> getServerShareHistories() {
		return serverShareHistories;
	}

	public void setServerShareHistories(
			List<ServerShareHistory> serverShareHistories) {
		this.serverShareHistories = serverShareHistories;
	}

	public List<ServerShareMountHistory> getServerShareMountHistories() {
		return serverShareMountHistories;
	}

	public void setServerShareMountHistories(
			List<ServerShareMountHistory> serverShareMountHistories) {
		this.serverShareMountHistories = serverShareMountHistories;
	}

	public List<ServerSANConnectionHistory> getServerSANConnectionHistories() {
		return serverSANConnectionHistories;
	}

	public void setServerSANConnectionHistories(
			List<ServerSANConnectionHistory> serverSANConnectionHistories) {
		this.serverSANConnectionHistories = serverSANConnectionHistories;
	}

	public OperatingSystemVersion getOperatingSystemVersion() {
		return operatingSystemVersion;
	}

	public void setOperatingSystemVersion(OperatingSystemVersion operatingSystemVersion) {
		this.operatingSystemVersion = operatingSystemVersion;
	}

	public ChangeControlDecision getChangeControlDecision() {
		return changeControlDecision;
	}

	public void setChangeControlDecision(ChangeControlDecision changeControlDecision) {
		this.changeControlDecision = changeControlDecision;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serverName == null) ? 0 : serverName.hashCode());
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
		Server other = (Server) obj;
		if (serverName == null) {
			if (other.serverName != null)
				return false;
		} else if (!serverName.equals(other.serverName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Server [serverID=" + serverID + ", serverName=" + serverName + "]";
	}

}