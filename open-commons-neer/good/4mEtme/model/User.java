package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="Users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userID;

	private String eMail;

	private Boolean globalAdmin;

	private String password;

	private String userName;
	
	private String firstName;
	private String lastName;
	private String phone;
	private String status;
	private Boolean isCustomer;

	//bi-directional many-to-one association to TaskTemplateByMethod
	@OneToMany(mappedBy="user")
	private List<TaskTemplateByMethod> tasktemplatebymethods;
	
	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="businessOwner")
	private List<ApplicationInstance> businessOwnerApplicationInstances;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="technicalOwner")
	private List<ApplicationInstance> technicalOwnerApplicationInstances;
		
	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="businessOwner")
	private List<Application> businessOwnerApplications;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="technicalOwner")
	private List<Application> technicalOwnerApplications;
	
	//bi-directional many-to-one association to BusinessServiceRole
	@OneToMany(mappedBy="user")
	private List<BusinessServiceRole> businessserviceroles;

	//bi-directional many-to-one association to MigrationSlot
	@OneToMany(mappedBy="user")
	private List<MigrationSlot> migrationslots;

	//bi-directional many-to-one association to MoveGroup
	@OneToMany(mappedBy="user")
	private List<MoveGroup> movegroups;

	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="user")
	private List<Server> servers;

	//bi-directional many-to-one association to TaskTemplateUser
	@OneToMany(mappedBy="user")
	private List<TaskTemplateUser> tasktemplateusers;

	//bi-directional many-to-one association to TaskStatusUser
	@OneToMany(mappedBy="user")
	private List<TaskStatusUser> taskstatususers;

	//bi-directional many-to-one association to TemplateUpload
	@OneToMany(mappedBy="user")
	private List<TemplateUpload> templateuploads;

	//bi-directional many-to-one association to UserApplicationEditRule
	@OneToMany(mappedBy="user")
	private List<UserApplicationEditRule> userapplicationeditrules;

	//bi-directional many-to-one association to UserGroup
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER)
	private List<UserGroup> usergroups;
	
	//bi-directional many-to-one association to MigrationScope
	@OneToMany(mappedBy="createdByUser")
	private List<MigrationScope> createdMigrationScopes;
	
	//bi-directional many-to-one association to MigrationScope
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<MigrationScope> updatedMigrationScopes;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Application> createdApplications;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Application> updatedApplications;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ApplicationComponent> createdApplicationComponents;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApplicationComponent> updatedApplicationComponents;

	@OneToMany(mappedBy="createdByUser")
	private List<ApplicationInstance> createdApplicationInstances;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApplicationInstance> updatedApplicationInstances;

	@OneToMany(mappedBy="createdByUser")
	private List<ApplicationComponentInstance> createdApplicationComponentInstances;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApplicationComponentInstance> updatedApplicationComponentInstances;

	@OneToMany(mappedBy="createdByUser")
	private List<ApplicationDataRestriction> createdApplicationDataRestrictions;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApplicationDataRestriction> updatedApplicationDataRestrictions;

	@OneToMany(mappedBy="createdByUser")
	private List<ApplicationUserLocation> createdApplicationUserLocations;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApplicationUserLocation> updatedApplicationUserLocations;

	@OneToMany(mappedBy="createdByUser")
	private List<OperationalService> createdOperationalServices;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<OperationalService> updatedOperationalServices;

	@OneToMany(mappedBy="createdByUser")
	private List<ApplicationOperationalService> createdApplicationOperationalServices;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApplicationOperationalService> updatedApplicationOperationalServices;

	@OneToMany(mappedBy="createdByUser")
	private List<ApptoappDependency> createdApptoAppDependencies;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApptoappDependency> updatedApptoAppDependencies;

	@OneToMany(mappedBy="createdByUser")
	private List<SoftwareManufacturer> createdSoftwareManufacturers;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<SoftwareManufacturer> updatedSoftwareManufacturers;

	@OneToMany(mappedBy="createdByUser")
	private List<Software> createdSoftware;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Software> updatedSoftware;
	
	@OneToMany(mappedBy="createdByUser")
	private List<SoftwareVersion> createdSoftwareVersions;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<SoftwareVersion> updatedSoftwareVersions;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ApplicationComponentSoftwareRequirement> createdAppComponentSoftwareRequirements;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ApplicationComponentSoftwareRequirement> updatedAppComponentSoftwareRequirements;
	
	@OneToMany(mappedBy="createdByUser")
	private List<LogicalDataLink> createdLogicalDataLinks;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<LogicalDataLink> updatedLogicalDataLinks;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Protocol> createdProtocols;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Protocol> updatedProtocols;
	
	@OneToMany(mappedBy="createdByUser")
	private List<SaaSApplication> createdSaaSApplication;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<SaaSApplication> updatedSaaSApplication;
	
	@OneToMany(mappedBy="createdByUser")
	private List<PaaS> createdPaaS;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<PaaS> updatedPaaS;
		
	@OneToMany(mappedBy="createdByUser")
	private List<Environment> createdEnvironments;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Environment> updatedEnvironments;
	
	@OneToMany(mappedBy="createdByUser")
	private List<BusinessService> createdBusinessServices;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<BusinessService> updatedBusinessServices;
	
	@OneToMany(mappedBy="createdByUser")
	private List<GeographicLocation> createdGeographicLocations;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<GeographicLocation> updatedGeographicLocations;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServiceProvider> createdServiceProviders;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServiceProvider> updatedServiceProviders;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Building> createdBuildings;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Building> updatedBuildings;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Floor> createdFloors;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Floor> updatedFloors;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Room> createdRooms;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Room> updatedRooms;
	
	@OneToMany(mappedBy="createdByUser")
	private List<FloorLocation> createdFloorLocations;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<FloorLocation> updatedFloorLocations;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Rack> createdRacks;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Rack> updatedRacks;
	
	@OneToMany(mappedBy="createdByUser")
	private List<BladeChassis> createdBladeChassis;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<BladeChassis> updatedBladeChassis;
	
	@OneToMany(mappedBy="createdByUser")
	private List<HardwareManufacturer> createdHardwareManufacturers;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<HardwareManufacturer> updatedHardwareManufacturers;
	
	@OneToMany(mappedBy="createdByUser")
	private List<AssetModel> createdAssetModels;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<AssetModel> updatedAssetModels;
	
	@OneToMany(mappedBy="createdByUser")
	private List<PhysicalServer> createdPhysicalServers;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<PhysicalServer> updatedPhysicalServers;
	
	@OneToMany(mappedBy="createdByUser")
	private List<VmFarm> createdVMFarms;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<VmFarm> updatedVMFarms;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServerCluster> createdServerClusters;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServerCluster> updatedServerClusters;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServersInServerCluster> createdServersInServerClusters;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServersInServerCluster> updatedServersInServerClusters;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServerInstalledSoftware> createdServerInstalledSoftware;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServerInstalledSoftware> updatedServerInstalledSoftware;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServerDAS> createdServerDAS;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServerDAS> updatedServerDAS;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServerShare> createdServerShares;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServerShare> updatedServerShares;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServerShareMount> createdServerShareMounts;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServerShareMount> updatedServerShareMounts;
	
	@OneToMany(mappedBy="createdByUser")
	private List<StorageService> createdStorageServices;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<StorageService> updatedStorageServices;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Nasshare> createdNASShares;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Nasshare> updatedNASShares;
	
	@OneToMany(mappedBy="createdByUser")
	private List<Sanlun> createdSANLUNs;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<Sanlun> updatedSANLUNs;
	
	@OneToMany(mappedBy="createdByUser")
	private List<ServerSANConnection> createdServerSANConnections;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<ServerSANConnection> updatedServerSANConnections;
	
	@OneToMany(mappedBy="createdByUser")
	private List<NetworkDevice> createdNetworkDevices;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<NetworkDevice> updatedNetworkDevices;
	
	@OneToMany(mappedBy="createdByUser")
	private List<AssetRole> createdAssetRoles;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<AssetRole> updatedAssetRoles;
	
	@OneToMany(mappedBy="createdByUser")
	private List<AssetType> createdAssetTypes;
	
	@OneToMany(mappedBy="lastUpdatedByUser")
	private List<AssetType> updatedAssetTypes;
	
	public User() {
	}

	public int getUserID() {
		return this.userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEMail() {
		return this.eMail;
	}

	public void setEMail(String EMail) {
		this.eMail = EMail;
	}

	public Boolean getGlobalAdmin() {
		return this.globalAdmin;
	}

	public void setGlobalAdmin(Boolean globalAdmin) {
		this.globalAdmin = globalAdmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Boolean getIsCustomer() {
		return isCustomer;
	}

	public void setIsCustomer(Boolean isCustomer) {
		this.isCustomer = isCustomer;
	}

	public List<ApplicationInstance> getBusinessOwnerApplicationInstances() {
		return businessOwnerApplicationInstances;
	}

	public void setBusinessOwnerApplicationInstances(
			List<ApplicationInstance> businessOwnerApplicationInstances) {
		this.businessOwnerApplicationInstances = businessOwnerApplicationInstances;
	}

	public List<ApplicationInstance> getTechnicalOwnerApplicationInstances() {
		return technicalOwnerApplicationInstances;
	}

	public void setTechnicalOwnerApplicationInstances(
			List<ApplicationInstance> technicalOwnerApplicationInstances) {
		this.technicalOwnerApplicationInstances = technicalOwnerApplicationInstances;
	}

	public List<Application> getBusinessOwnerApplications() {
		return businessOwnerApplications;
	}

	public void setBusinessOwnerApplications(
			List<Application> businessOwnerApplications) {
		this.businessOwnerApplications = businessOwnerApplications;
	}

	public List<Application> getTechnicalOwnerApplications() {
		return technicalOwnerApplications;
	}

	public void setTechnicalOwnerApplications(
			List<Application> technicalOwnerApplications) {
		this.technicalOwnerApplications = technicalOwnerApplications;
	}

	public List<BusinessServiceRole> getBusinessserviceroles() {
		return this.businessserviceroles;
	}

	public void setBusinessserviceroles(List<BusinessServiceRole> businessserviceroles) {
		this.businessserviceroles = businessserviceroles;
	}

	public BusinessServiceRole addBusinessservicerole(BusinessServiceRole businessservicerole) {
		getBusinessserviceroles().add(businessservicerole);
		businessservicerole.setUser(this);

		return businessservicerole;
	}

	public BusinessServiceRole removeBusinessservicerole(BusinessServiceRole businessservicerole) {
		getBusinessserviceroles().remove(businessservicerole);
		businessservicerole.setUser(null);

		return businessservicerole;
	}

	public List<MigrationSlot> getMigrationslots() {
		return this.migrationslots;
	}

	public void setMigrationslots(List<MigrationSlot> migrationslots) {
		this.migrationslots = migrationslots;
	}

	public MigrationSlot addMigrationslot(MigrationSlot migrationslot) {
		getMigrationslots().add(migrationslot);
		migrationslot.setUser(this);

		return migrationslot;
	}

	public MigrationSlot removeMigrationslot(MigrationSlot migrationslot) {
		getMigrationslots().remove(migrationslot);
		migrationslot.setUser(null);

		return migrationslot;
	}

	public List<MoveGroup> getMovegroups() {
		return this.movegroups;
	}

	public void setMovegroups(List<MoveGroup> movegroups) {
		this.movegroups = movegroups;
	}

	public MoveGroup addMovegroup(MoveGroup movegroup) {
		getMovegroups().add(movegroup);
		movegroup.setUser(this);

		return movegroup;
	}

	public MoveGroup removeMovegroup(MoveGroup movegroup) {
		getMovegroups().remove(movegroup);
		movegroup.setUser(null);

		return movegroup;
	}

	public List<Server> getServers() {
		return this.servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	public Server addServer(Server server) {
		getServers().add(server);
		server.setUser(this);

		return server;
	}

	public Server removeServer(Server server) {
		getServers().remove(server);
		server.setUser(null);

		return server;
	}

	public List<TaskTemplateUser> getTasktemplateusers() {
		return this.tasktemplateusers;
	}

	public void setTasktemplateusers(List<TaskTemplateUser> tasktemplateusers) {
		this.tasktemplateusers = tasktemplateusers;
	}

	public TaskTemplateUser addTasktemplateuser(TaskTemplateUser tasktemplateuser) {
		getTasktemplateusers().add(tasktemplateuser);
		tasktemplateuser.setUser(this);

		return tasktemplateuser;
	}

	public TaskTemplateUser removeTasktemplateuser(TaskTemplateUser tasktemplateuser) {
		getTasktemplateusers().remove(tasktemplateuser);
		tasktemplateuser.setUser(null);

		return tasktemplateuser;
	}

	public List<TaskStatusUser> getTaskstatususers() {
		return this.taskstatususers;
	}

	public void setTaskstatususers(List<TaskStatusUser> taskstatususers) {
		this.taskstatususers = taskstatususers;
	}

	public TaskStatusUser addTaskstatususer(TaskStatusUser taskstatususer) {
		getTaskstatususers().add(taskstatususer);
		taskstatususer.setUser(this);

		return taskstatususer;
	}

	public TaskStatusUser removeTaskstatususer(TaskStatusUser taskstatususer) {
		getTaskstatususers().remove(taskstatususer);
		taskstatususer.setUser(null);

		return taskstatususer;
	}

	public List<TemplateUpload> getTemplateuploads() {
		return this.templateuploads;
	}

	public void setTemplateuploads(List<TemplateUpload> templateuploads) {
		this.templateuploads = templateuploads;
	}

	public TemplateUpload addTemplateupload(TemplateUpload templateupload) {
		getTemplateuploads().add(templateupload);
		templateupload.setUser(this);

		return templateupload;
	}

	public TemplateUpload removeTemplateupload(TemplateUpload templateupload) {
		getTemplateuploads().remove(templateupload);
		templateupload.setUser(null);

		return templateupload;
	}

	public List<UserApplicationEditRule> getUserapplicationeditrules() {
		return this.userapplicationeditrules;
	}

	public void setUserapplicationeditrules(List<UserApplicationEditRule> userapplicationeditrules) {
		this.userapplicationeditrules = userapplicationeditrules;
	}

	public UserApplicationEditRule addUserapplicationeditrule(UserApplicationEditRule userapplicationeditrule) {
		getUserapplicationeditrules().add(userapplicationeditrule);
		userapplicationeditrule.setUser(this);

		return userapplicationeditrule;
	}

	public UserApplicationEditRule removeUserapplicationeditrule(UserApplicationEditRule userapplicationeditrule) {
		getUserapplicationeditrules().remove(userapplicationeditrule);
		userapplicationeditrule.setUser(null);

		return userapplicationeditrule;
	}

	public List<UserGroup> getUsergroups() {
		return this.usergroups;
	}

	public void setUsergroups(List<UserGroup> usergroups) {
		this.usergroups = usergroups;
	}

	public UserGroup addUsergroup(UserGroup usergroup) {
		getUsergroups().add(usergroup);
		usergroup.setUser(this);

		return usergroup;
	}

	public UserGroup removeUsergroup(UserGroup usergroup) {
		getUsergroups().remove(usergroup);
		usergroup.setUser(null);

		return usergroup;
	}

	public List<Application> getCreatedApplications() {
		return createdApplications;
	}

	public void setCreatedApplications(List<Application> createdApplications) {
		this.createdApplications = createdApplications;
	}
	
	public Application addCreatedApplication(Application application) {
		getCreatedApplications().add(application);
		application.setCreatedByUser(this);

		return application;
	}

	public Application removeCreatedApplication(Application application) {
		getCreatedApplications().remove(application);
		application.setCreatedByUser(null);

		return application;
	}


	public List<Application> getUpdatedApplications() {
		return updatedApplications;
	}

	public void setUpdatedApplications(List<Application> updatedApplications) {
		this.updatedApplications = updatedApplications;
	}
	
	public Application addUpdatedApplication(Application application) {
		getCreatedApplications().add(application);
		application.setLastUpdatedByUser(this);

		return application;
	}

	public Application removeUpdatedApplication(Application application) {
		getCreatedApplications().remove(application);
		application.setLastUpdatedByUser(null);

		return application;
	}

	public List<ApplicationComponent> getCreatedApplicationComponents() {
		return createdApplicationComponents;
	}

	public void setCreatedApplicationComponents(
			List<ApplicationComponent> createdApplicationComponents) {
		this.createdApplicationComponents = createdApplicationComponents;
	}
	
	public ApplicationComponent addCreatedApplicationComponent(ApplicationComponent applicationComponent) {
		getCreatedApplicationComponents().add(applicationComponent);
		applicationComponent.setCreatedByUser(this);

		return applicationComponent;
	}

	public ApplicationComponent removeCreatedApplicationComponent(ApplicationComponent applicationComponent) {
		getCreatedApplicationComponents().remove(applicationComponent);
		applicationComponent.setCreatedByUser(null);

		return applicationComponent;
	}

	public List<ApplicationComponent> getUpdatedApplicationComponents() {
		return updatedApplicationComponents;
	}

	public void setUpdatedApplicationComponents(
			List<ApplicationComponent> updatedApplicationComponents) {
		this.updatedApplicationComponents = updatedApplicationComponents;
	}
	
	public  ApplicationComponent addUpdatedApplicationComponent(ApplicationComponent applicationComponent) {
		getUpdatedApplicationComponents().add(applicationComponent);
		applicationComponent.setLastUpdatedByUser(this);

		return applicationComponent;
	}

	public ApplicationComponent removeUpdatedApplicationComponent(ApplicationComponent applicationComponent) {
		getUpdatedApplicationComponents().remove(applicationComponent);
		applicationComponent.setLastUpdatedByUser(null);

		return applicationComponent;
	}

	public List<ApplicationInstance> getCreatedApplicationInstances() {
		return createdApplicationInstances;
	}

	public void setCreatedApplicationInstances(
			List<ApplicationInstance> createdApplicationInstances) {
		this.createdApplicationInstances = createdApplicationInstances;
	}
	
	public ApplicationInstance addCreatedApplicationInstance(ApplicationInstance applicationInstance) {
		getCreatedApplicationInstances().add(applicationInstance);
		applicationInstance.setCreatedByUser(this);

		return applicationInstance;
	}

	public ApplicationInstance removeCreatedApplicationInstance(ApplicationInstance applicationInstance) {
		getCreatedApplicationInstances().remove(applicationInstance);
		applicationInstance.setCreatedByUser(null);

		return applicationInstance;
	}

	public List<ApplicationInstance> getUpdatedApplicationInstances() {
		return updatedApplicationInstances;
	}

	public void setUpdatedApplicationInstances(
			List<ApplicationInstance> updatedApplicationInstances) {
		this.updatedApplicationInstances = updatedApplicationInstances;
	}
	
	public ApplicationInstance addUpdatedApplication(ApplicationInstance applicationInstance) {
		getUpdatedApplicationInstances().add(applicationInstance);
		applicationInstance.setLastUpdatedByUser(this);

		return applicationInstance;
	}

	public ApplicationInstance removeUpdatedApplication(ApplicationInstance applicationInstance) {
		getUpdatedApplicationInstances().remove(applicationInstance);
		applicationInstance.setLastUpdatedByUser(null);

		return applicationInstance;
	}

	public List<ApplicationComponentInstance> getCreatedApplicationComponentInstances() {
		return createdApplicationComponentInstances;
	}

	public void setCreatedApplicationComponentInstances(
			List<ApplicationComponentInstance> createdApplicationComponentInstances) {
		this.createdApplicationComponentInstances = createdApplicationComponentInstances;
	}
	
	public ApplicationComponentInstance addCreatedApplicationComponentInstance(ApplicationComponentInstance applicationComponentInstance) {
		getCreatedApplicationComponentInstances().add(applicationComponentInstance);
		applicationComponentInstance.setCreatedByUser(this);

		return applicationComponentInstance;
	}

	public ApplicationComponentInstance removeCreatedApplicationComponentInstance(ApplicationComponentInstance applicationComponentInstance) {
		getCreatedApplicationComponentInstances().remove(applicationComponentInstance);
		applicationComponentInstance.setCreatedByUser(null);

		return applicationComponentInstance;
	}

	public List<ApplicationComponentInstance> getUpdatedApplicationComponentInstances() {
		return updatedApplicationComponentInstances;
	}

	public void setUpdatedApplicationComponentInstances(
			List<ApplicationComponentInstance> updatedApplicationComponentInstances) {
		this.updatedApplicationComponentInstances = updatedApplicationComponentInstances;
	}
	
	public ApplicationComponentInstance addUpdatedApplicationComponentInstance(ApplicationComponentInstance applicationComponentInstance) {
		getUpdatedApplicationComponentInstances().add(applicationComponentInstance);
		applicationComponentInstance.setLastUpdatedByUser(this);

		return applicationComponentInstance;
	}

	public ApplicationComponentInstance removeUpdatedApplicationComponentInstance(ApplicationComponentInstance applicationComponentInstance) {
		getUpdatedApplicationComponentInstances().remove(applicationComponentInstance);
		applicationComponentInstance.setLastUpdatedByUser(null);

		return applicationComponentInstance;
	}

	public List<ApplicationDataRestriction> getCreatedApplicationDataRestrictions() {
		return createdApplicationDataRestrictions;
	}

	public void setCreatedApplicationDataRestrictions(
			List<ApplicationDataRestriction> createdApplicationDataRestrictions) {
		this.createdApplicationDataRestrictions = createdApplicationDataRestrictions;
	}
	
	public ApplicationDataRestriction addCreatedApplicationDataRestriction(ApplicationDataRestriction applicationDataRestriction) {
		getCreatedApplicationDataRestrictions().add(applicationDataRestriction);
		applicationDataRestriction.setCreatedByUser(this);

		return applicationDataRestriction;
	}

	public ApplicationDataRestriction removeCreatedApplicationDataRestriction(ApplicationDataRestriction applicationDataRestriction) {
		getCreatedApplicationDataRestrictions().remove(applicationDataRestriction);
		applicationDataRestriction.setCreatedByUser(null);

		return applicationDataRestriction;
	}

	public List<ApplicationDataRestriction> getUpdatedApplicationDataRestrictions() {
		return updatedApplicationDataRestrictions;
	}

	public void setUpdatedApplicationDataRestrictions(
			List<ApplicationDataRestriction> updatedApplicationDataRestrictions) {
		this.updatedApplicationDataRestrictions = updatedApplicationDataRestrictions;
	}
	
	public ApplicationDataRestriction addUpdatedApplicationDataRestriction(ApplicationDataRestriction applicationDataRestriction) {
		getUpdatedApplicationDataRestrictions().add(applicationDataRestriction);
		applicationDataRestriction.setLastUpdatedByUser(this);

		return applicationDataRestriction;
	}

	public ApplicationDataRestriction removeUpdatedApplicationDataRestriction(ApplicationDataRestriction applicationDataRestriction) {
		getUpdatedApplicationDataRestrictions().remove(applicationDataRestriction);
		applicationDataRestriction.setLastUpdatedByUser(null);

		return applicationDataRestriction;
	}

	public List<ApplicationUserLocation> getCreatedApplicationUserLocations() {
		return createdApplicationUserLocations;
	}

	public void setCreatedApplicationUserLocations(
			List<ApplicationUserLocation> createdApplicationUserLocations) {
		this.createdApplicationUserLocations = createdApplicationUserLocations;
	}
	
	public ApplicationUserLocation addCreatedApplicationUserLocation(ApplicationUserLocation applicationUserLocation) {
		getCreatedApplicationUserLocations().add(applicationUserLocation);
		applicationUserLocation.setCreatedByUser(this);

		return applicationUserLocation;
	}

	public ApplicationUserLocation removeCreatedApplicationUserLocation(ApplicationUserLocation applicationUserLocation) {
		getCreatedApplicationUserLocations().remove(applicationUserLocation);
		applicationUserLocation.setCreatedByUser(null);

		return applicationUserLocation;
	}
	

	public List<ApplicationUserLocation> getUpdatedApplicationUserLocations() {
		return updatedApplicationUserLocations;
	}

	public void setUpdatedApplicationUserLocations(
			List<ApplicationUserLocation> updatedApplicationUserLocations) {
		this.updatedApplicationUserLocations = updatedApplicationUserLocations;
	}
	
	public ApplicationUserLocation addUpdatedApplicationUserLocation(ApplicationUserLocation applicationUserLocation) {
		getUpdatedApplicationUserLocations().add(applicationUserLocation);
		applicationUserLocation.setLastUpdatedByUser(this);

		return applicationUserLocation;
	}

	public ApplicationUserLocation removeUpdatedApplicationUserLocation(ApplicationUserLocation applicationUserLocation) {
		getUpdatedApplicationUserLocations().remove(applicationUserLocation);
		applicationUserLocation.setLastUpdatedByUser(null);

		return applicationUserLocation;
	}

	public List<OperationalService> getCreatedOperationalServices() {
		return createdOperationalServices;
	}

	public void setCreatedOperationalServices(
			List<OperationalService> createdOperationalServices) {
		this.createdOperationalServices = createdOperationalServices;
	}
	
	public OperationalService addCreatedOperationalService(OperationalService operationalService) {
		getCreatedOperationalServices().add(operationalService);
		operationalService.setCreatedByUser(this);

		return operationalService;
	}

	public OperationalService removeCreatedOperationalService(OperationalService operationalService) {
		getCreatedOperationalServices().remove(operationalService);
		operationalService.setCreatedByUser(null);

		return operationalService;
	}

	public List<OperationalService> getUpdatedOperationalServices() {
		return updatedOperationalServices;
	}

	public void setUpdatedOperationalServices(
			List<OperationalService> updatedOperationalServices) {
		this.updatedOperationalServices = updatedOperationalServices;
	}
	
	public OperationalService addUpdatedOperationalService(OperationalService operationalService) {
		getUpdatedOperationalServices().add(operationalService);
		operationalService.setLastUpdatedByUser(this);

		return operationalService;
	}

	public OperationalService removeUpdatedOperationalService(OperationalService operationalService) {
		getUpdatedOperationalServices().remove(operationalService);
		operationalService.setLastUpdatedByUser(null);

		return operationalService;
	}

	public List<ApplicationOperationalService> getCreatedApplicationOperationalServices() {
		return createdApplicationOperationalServices;
	}

	public void setCreatedApplicationOperationalServices(
			List<ApplicationOperationalService> createdApplicationOperationalServices) {
		this.createdApplicationOperationalServices = createdApplicationOperationalServices;
	}
	
	public ApplicationOperationalService addCreatedApplicationOperationalService(ApplicationOperationalService applicationOperationalService) {
		getCreatedApplicationOperationalServices().add(applicationOperationalService);
		applicationOperationalService.setCreatedByUser(this);

		return applicationOperationalService;
	}

	public ApplicationOperationalService removeCreatedApplicationOperationalService(ApplicationOperationalService applicationOperationalService) {
		getCreatedApplicationOperationalServices().remove(applicationOperationalService);
		applicationOperationalService.setCreatedByUser(null);

		return applicationOperationalService;
	}
	

	public List<ApplicationOperationalService> getUpdatedApplicationOperationalServices() {
		return updatedApplicationOperationalServices;
	}

	public void setUpdatedApplicationOperationalServices(
			List<ApplicationOperationalService> updatedApplicationOperationalServices) {
		this.updatedApplicationOperationalServices = updatedApplicationOperationalServices;
	}
	
	public ApplicationOperationalService addUpdatedApplicationOperationalService(ApplicationOperationalService applicationOperationalService) {
		getUpdatedApplicationOperationalServices().add(applicationOperationalService);
		applicationOperationalService.setLastUpdatedByUser(this);

		return applicationOperationalService;
	}

	public ApplicationOperationalService removeUpdatedApplicationOperationalService(ApplicationOperationalService applicationOperationalService) {
		getUpdatedApplicationOperationalServices().remove(applicationOperationalService);
		applicationOperationalService.setLastUpdatedByUser(null);

		return applicationOperationalService;
	}

	public List<ApptoappDependency> getCreatedApptoAppDependencies() {
		return createdApptoAppDependencies;
	}

	public void setCreatedApptoAppDependencies(
			List<ApptoappDependency> createdApptoAppDependencies) {
		this.createdApptoAppDependencies = createdApptoAppDependencies;
	}
	
	public ApptoappDependency addCreatedApptoappDependency(ApptoappDependency apptoappDependency) {
		getCreatedApptoAppDependencies().add(apptoappDependency);
		apptoappDependency.setCreatedByUser(this);

		return apptoappDependency;
	}

	public ApptoappDependency removeCreatedApptoappDependency(ApptoappDependency apptoappDependency) {
		getCreatedApptoAppDependencies().remove(apptoappDependency);
		apptoappDependency.setCreatedByUser(null);

		return apptoappDependency;
	}
	

	public List<ApptoappDependency> getUpdatedApptoAppDependencies() {
		return updatedApptoAppDependencies;
	}

	public void setUpdatedApptoAppDependencies(
			List<ApptoappDependency> updatedApptoAppDependencies) {
		this.updatedApptoAppDependencies = updatedApptoAppDependencies;
	}
	
	public ApptoappDependency addUpdatedApptoappDependency(ApptoappDependency apptoappDependency) {
		getUpdatedApptoAppDependencies().add(apptoappDependency);
		apptoappDependency.setLastUpdatedByUser(this);

		return apptoappDependency;
	}

	public ApptoappDependency removeUpdatedApptoappDependency(ApptoappDependency apptoappDependency) {
		getUpdatedApptoAppDependencies().remove(apptoappDependency);
		apptoappDependency.setLastUpdatedByUser(null);

		return apptoappDependency;
	}

	public List<SoftwareManufacturer> getCreatedSoftwareManufacturers() {
		return createdSoftwareManufacturers;
	}

	public void setCreatedSoftwareManufacturers(
			List<SoftwareManufacturer> createdSoftwareManufacturers) {
		this.createdSoftwareManufacturers = createdSoftwareManufacturers;
	}
	
	public SoftwareManufacturer addCreatedSoftwareManufacturer(SoftwareManufacturer softwareManufacturer) {
		getCreatedSoftwareManufacturers().add(softwareManufacturer);
		softwareManufacturer.setCreatedByUser(this);

		return softwareManufacturer;
	}

	public SoftwareManufacturer removeCreatedSoftwareManufacturer(SoftwareManufacturer softwareManufacturer) {
		getCreatedSoftwareManufacturers().remove(softwareManufacturer);
		softwareManufacturer.setCreatedByUser(null);

		return softwareManufacturer;
	}

	public List<SoftwareManufacturer> getUpdatedSoftwareManufacturers() {
		return updatedSoftwareManufacturers;
	}

	public void setUpdatedSoftwareManufacturers(
			List<SoftwareManufacturer> updatedSoftwareManufacturers) {
		this.updatedSoftwareManufacturers = updatedSoftwareManufacturers;
	}
	
	public SoftwareManufacturer addUpdatedSoftwareManufacturer(SoftwareManufacturer softwareManufacturer) {
		getUpdatedSoftwareManufacturers().add(softwareManufacturer);
		softwareManufacturer.setLastUpdatedByUser(this);

		return softwareManufacturer;
	}

	public SoftwareManufacturer removeUpdatedSoftwareManufacturer(SoftwareManufacturer softwareManufacturer) {
		getUpdatedSoftwareManufacturers().remove(softwareManufacturer);
		softwareManufacturer.setLastUpdatedByUser(null);

		return softwareManufacturer;
	}

	public List<Software> getCreatedSoftware() {
		return createdSoftware;
	}

	public void setCreatedSoftware(List<Software> createdSoftware) {
		this.createdSoftware = createdSoftware;
	}
	
	public Software addCreatedSoftware(Software software) {
		getCreatedSoftware().add(software);
		software.setCreatedByUser(this);

		return software;
	}

	public Software removeCreatedSoftware(Software software) {
		getCreatedSoftware().remove(software);
		software.setCreatedByUser(null);

		return software;
	}
	

	public List<Software> getUpdatedSoftware() {
		return updatedSoftware;
	}

	public void setUpdatedSoftware(List<Software> updatedSoftware) {
		this.updatedSoftware = updatedSoftware;
	}
	
	public Software addUpdatedSoftware(Software software) {
		getUpdatedSoftware().add(software);
		software.setLastUpdatedByUser(this);

		return software;
	}

	public Software removeUpdatedSoftware(Software software) {
		getUpdatedSoftware().remove(software);
		software.setLastUpdatedByUser(null);

		return software;
	}

	public List<SoftwareVersion> getCreatedSoftwareVersions() {
		return createdSoftwareVersions;
	}

	public void setCreatedSoftwareVersions(
			List<SoftwareVersion> createdSoftwareVersions) {
		this.createdSoftwareVersions = createdSoftwareVersions;
	}
	
	public SoftwareVersion addCreatedSoftwareVersion(SoftwareVersion softwareVersion) {
		getCreatedSoftwareVersions().add(softwareVersion);
		softwareVersion.setCreatedByUser(this);

		return softwareVersion;
	}

	public SoftwareVersion removeCreatedSoftwareVersion(SoftwareVersion softwareVersion) {
		getCreatedSoftwareVersions().remove(softwareVersion);
		softwareVersion.setCreatedByUser(null);

		return softwareVersion;
	}

	public List<SoftwareVersion> getUpdatedSoftwareVersions() {
		return updatedSoftwareVersions;
	}

	public void setUpdatedSoftwareVersions(
			List<SoftwareVersion> updatedSoftwareVersions) {
		this.updatedSoftwareVersions = updatedSoftwareVersions;
	}
	
	public SoftwareVersion addUpdatedSoftwareVersion(SoftwareVersion softwareVersion) {
		getUpdatedSoftwareVersions().add(softwareVersion);
		softwareVersion.setLastUpdatedByUser(this);

		return softwareVersion;
	}

	public SoftwareVersion removeUpdatedSoftwareVersion(SoftwareVersion softwareVersion) {
		getUpdatedSoftwareVersions().remove(softwareVersion);
		softwareVersion.setLastUpdatedByUser(null);

		return softwareVersion;
	}

	public List<ApplicationComponentSoftwareRequirement> getCreatedAppComponentSoftwareRequirements() {
		return createdAppComponentSoftwareRequirements;
	}

	public void setCreatedAppComponentSoftwareRequirements(
			List<ApplicationComponentSoftwareRequirement> createdAppComponentSoftwareRequirements) {
		this.createdAppComponentSoftwareRequirements = createdAppComponentSoftwareRequirements;
	}
	
	public ApplicationComponentSoftwareRequirement addCreatedApplicationComponentSoftwareRequirement(ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement) {
		getCreatedAppComponentSoftwareRequirements().add(applicationComponentSoftwareRequirement);
		applicationComponentSoftwareRequirement.setCreatedByUser(this);

		return applicationComponentSoftwareRequirement;
	}

	public ApplicationComponentSoftwareRequirement removeCreatedApplicationComponentSoftwareRequirement(ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement) {
		getCreatedAppComponentSoftwareRequirements().remove(applicationComponentSoftwareRequirement);
		applicationComponentSoftwareRequirement.setCreatedByUser(null);

		return applicationComponentSoftwareRequirement;
	}
	

	public List<ApplicationComponentSoftwareRequirement> getUpdatedAppComponentSoftwareRequirements() {
		return updatedAppComponentSoftwareRequirements;
	}

	public void setUpdatedAppComponentSoftwareRequirements(
			List<ApplicationComponentSoftwareRequirement> updatedAppComponentSoftwareRequirements) {
		this.updatedAppComponentSoftwareRequirements = updatedAppComponentSoftwareRequirements;
	}
	
	public ApplicationComponentSoftwareRequirement addUpdatedApplicationComponentSoftwareRequirement(ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement) {
		getUpdatedAppComponentSoftwareRequirements().add(applicationComponentSoftwareRequirement);
		applicationComponentSoftwareRequirement.setLastUpdatedByUser(this);

		return applicationComponentSoftwareRequirement;
	}

	public ApplicationComponentSoftwareRequirement removeUpdatedApplicationComponentSoftwareRequirement(ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement) {
		getUpdatedAppComponentSoftwareRequirements().remove(applicationComponentSoftwareRequirement);
		applicationComponentSoftwareRequirement.setLastUpdatedByUser(null);

		return applicationComponentSoftwareRequirement;
	}

	public List<LogicalDataLink> getCreatedLogicalDataLinks() {
		return createdLogicalDataLinks;
	}

	public void setCreatedLogicalDataLinks(
			List<LogicalDataLink> createdLogicalDataLinks) {
		this.createdLogicalDataLinks = createdLogicalDataLinks;
	}
	
	public LogicalDataLink addCreatedLogicalDataLink(LogicalDataLink logicalDataLink) {
		getCreatedLogicalDataLinks().add(logicalDataLink);
		logicalDataLink.setCreatedByUser(this);

		return logicalDataLink;
	}

	public LogicalDataLink removeCreatedLogicalDataLink(LogicalDataLink logicalDataLink) {
		getCreatedLogicalDataLinks().remove(logicalDataLink);
		logicalDataLink.setCreatedByUser(null);

		return logicalDataLink;
	}
	
	public List<LogicalDataLink> getUpdatedLogicalDataLinks() {
		return updatedLogicalDataLinks;
	}

	public void setUpdatedLogicalDataLinks(
			List<LogicalDataLink> updatedLogicalDataLinks) {
		this.updatedLogicalDataLinks = updatedLogicalDataLinks;
	}
	
	public LogicalDataLink addUpdatedLogicalDataLink(LogicalDataLink logicalDataLink) {
		getUpdatedLogicalDataLinks().add(logicalDataLink);
		logicalDataLink.setLastUpdatedByUser(this);

		return logicalDataLink;
	}

	public LogicalDataLink removeUpdatedLogicalDataLink(LogicalDataLink logicalDataLink) {
		getUpdatedLogicalDataLinks().remove(logicalDataLink);
		logicalDataLink.setLastUpdatedByUser(null);

		return logicalDataLink;
	}

	public List<Protocol> getCreatedProtocols() {
		return createdProtocols;
	}

	public void setCreatedProtocols(List<Protocol> createdProtocols) {
		this.createdProtocols = createdProtocols;
	}
	
	public Protocol addCreatedProtocol(Protocol protocol) {
		getCreatedProtocols().add(protocol);
		protocol.setCreatedByUser(this);

		return protocol;
	}

	public Protocol removeCreatedProtocol(Protocol protocol) {
		getCreatedProtocols().remove(protocol);
		protocol.setCreatedByUser(null);

		return protocol;
	}

	public List<Protocol> getUpdatedProtocols() {
		return updatedProtocols;
	}

	public void setUpdatedProtocols(List<Protocol> updatedProtocols) {
		this.updatedProtocols = updatedProtocols;
	}
	
	public Protocol addUpdatedProtocol(Protocol protocol) {
		getUpdatedProtocols().add(protocol);
		protocol.setLastUpdatedByUser(this);

		return protocol;
	}

	public Protocol removeUpdatedProtocol(Protocol protocol) {
		getUpdatedProtocols().remove(protocol);
		protocol.setLastUpdatedByUser(null);

		return protocol;
	}

	public List<SaaSApplication> getCreatedSaaSApplication() {
		return createdSaaSApplication;
	}

	public void setCreatedSaaSApplication(
			List<SaaSApplication> createdSaaSApplication) {
		this.createdSaaSApplication = createdSaaSApplication;
	}
	
	public SaaSApplication addCreatedSaaSApplication(SaaSApplication saaSApplication) {
		getCreatedSaaSApplication().add(saaSApplication);
		saaSApplication.setCreatedByUser(this);

		return saaSApplication;
	}

	public SaaSApplication removeCreatedSaaSApplication(SaaSApplication saaSApplication) {
		getCreatedSaaSApplication().remove(saaSApplication);
		saaSApplication.setCreatedByUser(null);

		return saaSApplication;
	}
	

	public List<SaaSApplication> getUpdatedSaaSApplication() {
		return updatedSaaSApplication;
	}

	public void setUpdatedSaaSApplication(
			List<SaaSApplication> updatedSaaSApplication) {
		this.updatedSaaSApplication = updatedSaaSApplication;
	}
	
	public SaaSApplication addUpdatedSaaSApplication(SaaSApplication saaSApplication) {
		getUpdatedSaaSApplication().add(saaSApplication);
		saaSApplication.setLastUpdatedByUser(this);

		return saaSApplication;
	}

	public SaaSApplication removeUpdatedSaaSApplication(SaaSApplication saaSApplication) {
		getUpdatedSaaSApplication().remove(saaSApplication);
		saaSApplication.setLastUpdatedByUser(null);

		return saaSApplication;
	}

	public List<PaaS> getCreatedPaaS() {
		return createdPaaS;
	}

	public void setCreatedPaaS(List<PaaS> createdPaaS) {
		this.createdPaaS = createdPaaS;
	}
	
	public PaaS addCreatedPaaS(PaaS paaS) {
		getCreatedPaaS().add(paaS);
		paaS.setCreatedByUser(this);

		return paaS;
	}

	public PaaS removeCreatedPaaS(PaaS paaS) {
		getCreatedPaaS().remove(paaS);
		paaS.setCreatedByUser(null);

		return paaS;
	}

	public List<PaaS> getUpdatedPaaS() {
		return updatedPaaS;
	}

	public void setUpdatedPaaS(List<PaaS> updatedPaaS) {
		this.updatedPaaS = updatedPaaS;
	}
	
	public PaaS addUpdatedPaaS(PaaS paaS) {
		getUpdatedPaaS().add(paaS);
		paaS.setLastUpdatedByUser(this);

		return paaS;
	}

	public PaaS removeUpdatedPaaS(PaaS paaS) {
		getUpdatedPaaS().remove(paaS);
		paaS.setLastUpdatedByUser(null);

		return paaS;
	}
	
	public List<Environment> getCreatedEnvironments() {
		return createdEnvironments;
	}

	public void setCreatedEnvironments(List<Environment> createdEnvironments) {
		this.createdEnvironments = createdEnvironments;
	}
	
	public Environment addCreatedEnvironment(Environment environment) {
		getCreatedEnvironments().add(environment);
		environment.setCreatedByUser(this);

		return environment;
	}

	public Environment removeCreatedEnvironment(Environment environment) {
		getCreatedEnvironments().remove(environment);
		environment.setCreatedByUser(null);

		return environment;
	}
	
	public List<Environment> getUpdatedEnvironments() {
		return updatedEnvironments;
	}

	public void setUpdatedEnvironments(List<Environment> updatedEnvironments) {
		this.updatedEnvironments = updatedEnvironments;
	}
	
	public Environment addUpdatedEnvironment(Environment environment) {
		getUpdatedEnvironments().add(environment);
		environment.setLastUpdatedByUser(this);

		return environment;
	}

	public Environment removeUpdatedEnvironment(Environment environment) {
		getUpdatedEnvironments().remove(environment);
		environment.setLastUpdatedByUser(null);

		return environment;
	}

	public List<BusinessService> getCreatedBusinessServices() {
		return createdBusinessServices;
	}

	public void setCreatedBusinessServices(
			List<BusinessService> createdBusinessServices) {
		this.createdBusinessServices = createdBusinessServices;
	}
	
	public BusinessService addCreatedBusinessService(BusinessService businessService) {
		getCreatedBusinessServices().add(businessService);
		businessService.setCreatedByUser(this);

		return businessService;
	}

	public BusinessService removeCreatedBusinessService(BusinessService businessService) {
		getCreatedBusinessServices().remove(businessService);
		businessService.setCreatedByUser(null);

		return businessService;
	}
	

	public List<BusinessService> getUpdatedBusinessServices() {
		return updatedBusinessServices;
	}

	public void setUpdatedBusinessServices(
			List<BusinessService> updatedBusinessServices) {
		this.updatedBusinessServices = updatedBusinessServices;
	}
	
	public BusinessService addUpdatedBusinessService(BusinessService businessService) {
		getUpdatedBusinessServices().add(businessService);
		businessService.setLastUpdatedByUser(this);

		return businessService;
	}

	public BusinessService removeUpdatedBusinessService(BusinessService businessService) {
		getUpdatedBusinessServices().remove(businessService);
		businessService.setLastUpdatedByUser(null);

		return businessService;
	}

	public List<GeographicLocation> getCreatedGeographicLocations() {
		return createdGeographicLocations;
	}

	public void setCreatedGeographicLocations(
			List<GeographicLocation> createdGeographicLocations) {
		this.createdGeographicLocations = createdGeographicLocations;
	}
	
	public GeographicLocation addCreatedGeographicLocation(GeographicLocation geographicLocation) {
		getCreatedGeographicLocations().add(geographicLocation);
		geographicLocation.setCreatedByUser(this);

		return geographicLocation;
	}

	public GeographicLocation removeCreatedGeographicLocation(GeographicLocation geographicLocation) {
		getCreatedGeographicLocations().remove(geographicLocation);
		geographicLocation.setCreatedByUser(null);

		return geographicLocation;
	}

	public List<GeographicLocation> getUpdatedGeographicLocations() {
		return updatedGeographicLocations;
	}

	public void setUpdatedGeographicLocations(
			List<GeographicLocation> updatedGeographicLocations) {
		this.updatedGeographicLocations = updatedGeographicLocations;
	}
	
	public GeographicLocation addUpdatedGeographicLocation(GeographicLocation geographicLocation) {
		getUpdatedGeographicLocations().add(geographicLocation);
		geographicLocation.setLastUpdatedByUser(this);

		return geographicLocation;
	}

	public GeographicLocation removeUpdatedGeographicLocation(GeographicLocation geographicLocation) {
		getUpdatedGeographicLocations().remove(geographicLocation);
		geographicLocation.setLastUpdatedByUser(null);

		return geographicLocation;
	}

	public List<ServiceProvider> getCreatedServiceProviders() {
		return createdServiceProviders;
	}

	public void setCreatedServiceProviders(
			List<ServiceProvider> createdServiceProviders) {
		this.createdServiceProviders = createdServiceProviders;
	}
	
	public ServiceProvider addCreatedServiceProvider(ServiceProvider serviceProvider) {
		getCreatedServiceProviders().add(serviceProvider);
		serviceProvider.setCreatedByUser(this);

		return serviceProvider;
	}

	public ServiceProvider removeCreatedServiceProvider(ServiceProvider serviceProvider) {
		getCreatedServiceProviders().remove(serviceProvider);
		serviceProvider.setCreatedByUser(null);

		return serviceProvider;
	}

	public List<ServiceProvider> getUpdatedServiceProviders() {
		return updatedServiceProviders;
	}

	public void setUpdatedServiceProviders(
			List<ServiceProvider> updatedServiceProviders) {
		this.updatedServiceProviders = updatedServiceProviders;
	}
	
	public ServiceProvider addUpdatedServiceProvider(ServiceProvider serviceProvider) {
		getUpdatedServiceProviders().add(serviceProvider);
		serviceProvider.setLastUpdatedByUser(this);

		return serviceProvider;
	}

	public ServiceProvider removeUpdatedServiceProvider(ServiceProvider serviceProvider) {
		getUpdatedServiceProviders().remove(serviceProvider);
		serviceProvider.setLastUpdatedByUser(null);

		return serviceProvider;
	}

	public List<Building> getCreatedBuildings() {
		return createdBuildings;
	}

	public void setCreatedBuildings(List<Building> createdBuildings) {
		this.createdBuildings = createdBuildings;
	}
	
	public Building addCreatedBuilding(Building building) {
		getCreatedBuildings().add(building);
		building.setCreatedByUser(this);

		return building;
	}

	public Building removeCreatedBuilding(Building building) {
		getCreatedBuildings().remove(building);
		building.setCreatedByUser(null);

		return building;
	}
	
	public List<Building> getUpdatedBuildings() {
		return updatedBuildings;
	}

	public void setUpdatedBuildings(List<Building> updatedBuildings) {
		this.updatedBuildings = updatedBuildings;
	}
	
	
	public Building addUpdatedBuilding(Building building) {
		getUpdatedBuildings().add(building);
		building.setLastUpdatedByUser(this);

		return building;
	}

	public Building removeUpdatedBuilding(Building building) {
		getUpdatedBuildings().remove(building);
		building.setLastUpdatedByUser(null);

		return building;
	}

	public List<Floor> getCreatedFloors() {
		return createdFloors;
	}

	public void setCreatedFloors(List<Floor> createdFloors) {
		this.createdFloors = createdFloors;
	}
	
	public Floor addCreatedFloor(Floor floor) {
		getCreatedFloors().add(floor);
		floor.setCreatedByUser(this);

		return floor;
	}

	public Floor removeCreatedFloor(Floor floor) {
		getCreatedFloors().remove(floor);
		floor.setCreatedByUser(null);

		return floor;
	}

	public List<Floor> getUpdatedFloors() {
		return updatedFloors;
	}

	public void setUpdatedFloors(List<Floor> updatedFloors) {
		this.updatedFloors = updatedFloors;
	}
	
	public Floor addUpdatedFloor(Floor floor) {
		getUpdatedFloors().add(floor);
		floor.setLastUpdatedByUser(this);

		return floor;
	}

	public Floor removeUpdatedFloor(Floor floor) {
		getUpdatedFloors().remove(floor);
		floor.setLastUpdatedByUser(null);

		return floor;
	}

	public List<Room> getCreatedRooms() {
		return createdRooms;
	}

	public void setCreatedRooms(List<Room> createdRooms) {
		this.createdRooms = createdRooms;
	}
	
	public Room addCreatedRoom(Room room) {
		getCreatedRooms().add(room);
		room.setCreatedByUser(this);

		return room;
	}

	public Room removeCreatedRoom(Room room) {
		getCreatedRooms().remove(room);
		room.setCreatedByUser(null);

		return room;
	}

	public List<Room> getUpdatedRooms() {
		return updatedRooms;
	}

	public void setUpdatedRooms(List<Room> updatedRooms) {
		this.updatedRooms = updatedRooms;
	}
	
	public Room addUpdatedRoom(Room room) {
		getUpdatedRooms().add(room);
		room.setLastUpdatedByUser(this);

		return room;
	}

	public Room removeUpdatedRoom(Room room) {
		getUpdatedRooms().remove(room);
		room.setLastUpdatedByUser(null);

		return room;
	}

	public List<FloorLocation> getCreatedFloorLocations() {
		return createdFloorLocations;
	}

	public void setCreatedFloorLocations(List<FloorLocation> createdFloorLocations) {
		this.createdFloorLocations = createdFloorLocations;
	}
	
	public FloorLocation addCreatedFloorLocation(FloorLocation floorLocation) {
		getCreatedFloorLocations().add(floorLocation);
		floorLocation.setCreatedByUser(this);

		return floorLocation;
	}

	public FloorLocation removeCreatedFloorLocation(FloorLocation floorLocation) {
		getCreatedFloorLocations().remove(floorLocation);
		floorLocation.setCreatedByUser(null);

		return floorLocation;
	}

	public List<FloorLocation> getUpdatedFloorLocations() {
		return updatedFloorLocations;
	}

	public void setUpdatedFloorLocations(List<FloorLocation> updatedFloorLocations) {
		this.updatedFloorLocations = updatedFloorLocations;
	}
	
	public FloorLocation addUpdatedFloorLocation(FloorLocation floorLocation) {
		getUpdatedFloorLocations().add(floorLocation);
		floorLocation.setLastUpdatedByUser(this);

		return floorLocation;
	}

	public FloorLocation removeUpdatedFloorLocation(FloorLocation floorLocation) {
		getUpdatedFloorLocations().remove(floorLocation);
		floorLocation.setLastUpdatedByUser(null);

		return floorLocation;
	}

	public List<Rack> getCreatedRacks() {
		return createdRacks;
	}

	public void setCreatedRacks(List<Rack> createdRacks) {
		this.createdRacks = createdRacks;
	}
	
	public Rack addCreatedRack(Rack rack) {
		getCreatedRacks().add(rack);
		rack.setCreatedByUser(this);

		return rack;
	}

	public Rack removeCreatedRack(Rack rack) {
		getCreatedRacks().remove(rack);
		rack.setCreatedByUser(null);

		return rack;
	}

	public List<Rack> getUpdatedRacks() {
		return updatedRacks;
	}

	public void setUpdatedRacks(List<Rack> updatedRacks) {
		this.updatedRacks = updatedRacks;
	}
	
	public Rack addUpdatedRack(Rack rack) {
		getUpdatedRacks().add(rack);
		rack.setLastUpdatedByUser(this);

		return rack;
	}

	public Rack removeUpdatedRack(Rack rack) {
		getUpdatedRacks().remove(rack);
		rack.setLastUpdatedByUser(null);

		return rack;
	}

	public List<BladeChassis> getCreatedBladeChassis() {
		return createdBladeChassis;
	}

	public void setCreatedBladeChassis(List<BladeChassis> createdBladeChassis) {
		this.createdBladeChassis = createdBladeChassis;
	}
	
	public BladeChassis addCreatedBladeChassis(BladeChassis bladeChassis) {
		getCreatedBladeChassis().add(bladeChassis);
		bladeChassis.setCreatedByUser(this);

		return bladeChassis;
	}

	public BladeChassis removeCreatedBladeChassis(BladeChassis bladeChassis) {
		getCreatedBladeChassis().remove(bladeChassis);
		bladeChassis.setCreatedByUser(null);

		return bladeChassis;
	}

	public List<BladeChassis> getUpdatedBladeChassis() {
		return updatedBladeChassis;
	}

	public void setUpdatedBladeChassis(List<BladeChassis> updatedBladeChassis) {
		this.updatedBladeChassis = updatedBladeChassis;
	}
	
	public BladeChassis addUpdatedBladeChassis(BladeChassis bladeChassis) {
		getUpdatedBladeChassis().add(bladeChassis);
		bladeChassis.setLastUpdatedByUser(this);

		return bladeChassis;
	}

	public BladeChassis removeUpdatedBladeChassis(BladeChassis bladeChassis) {
		getUpdatedBladeChassis().remove(bladeChassis);
		bladeChassis.setLastUpdatedByUser(null);

		return bladeChassis;
	}

	public List<HardwareManufacturer> getCreatedHardwareManufacturers() {
		return createdHardwareManufacturers;
	}

	public void setCreatedHardwareManufacturers(
			List<HardwareManufacturer> createdHardwareManufacturers) {
		this.createdHardwareManufacturers = createdHardwareManufacturers;
	}
	
	public HardwareManufacturer addCreatedHardwareManufacturer(HardwareManufacturer hardwareManufacturer) {
		getCreatedHardwareManufacturers().add(hardwareManufacturer);
		hardwareManufacturer.setCreatedByUser(this);

		return hardwareManufacturer;
	}

	public HardwareManufacturer removeCreatedHardwareManufacturer(HardwareManufacturer hardwareManufacturer) {
		getCreatedHardwareManufacturers().remove(hardwareManufacturer);
		hardwareManufacturer.setCreatedByUser(null);

		return hardwareManufacturer;
	}

	public List<HardwareManufacturer> getUpdatedHardwareManufacturers() {
		return updatedHardwareManufacturers;
	}

	public void setUpdatedHardwareManufacturers(
			List<HardwareManufacturer> updatedHardwareManufacturers) {
		this.updatedHardwareManufacturers = updatedHardwareManufacturers;
	}
	
	public HardwareManufacturer addUpdatedHardwareManufacturer(HardwareManufacturer hardwareManufacturer) {
		getUpdatedHardwareManufacturers().add(hardwareManufacturer);
		hardwareManufacturer.setLastUpdatedByUser(this);

		return hardwareManufacturer;
	}

	public HardwareManufacturer removeUpdatedHardwareManufacturer(HardwareManufacturer hardwareManufacturer) {
		getUpdatedHardwareManufacturers().remove(hardwareManufacturer);
		hardwareManufacturer.setLastUpdatedByUser(null);

		return hardwareManufacturer;
	}

	public List<AssetModel> getCreatedAssetModels() {
		return createdAssetModels;
	}

	public void setCreatedAssetModels(List<AssetModel> createdAssetModels) {
		this.createdAssetModels = createdAssetModels;
	}
	
	public AssetModel addCreatedAssetModel(AssetModel assetModel) {
		getCreatedAssetModels().add(assetModel);
		assetModel.setCreatedByUser(this);

		return assetModel;
	}

	public AssetModel removeCreatedAssetModel(AssetModel assetModel) {
		getCreatedAssetModels().remove(assetModel);
		assetModel.setCreatedByUser(null);

		return assetModel;
	}

	public List<AssetModel> getUpdatedAssetModels() {
		return updatedAssetModels;
	}

	public void setUpdatedAssetModels(List<AssetModel> updatedAssetModels) {
		this.updatedAssetModels = updatedAssetModels;
	}
	
	public AssetModel addUpdatedAssetModel(AssetModel assetModel) {
		getUpdatedAssetModels().add(assetModel);
		assetModel.setLastUpdatedByUser(this);

		return assetModel;
	}

	public AssetModel removeUpdatedAssetModel(AssetModel assetModel) {
		getUpdatedAssetModels().remove(assetModel);
		assetModel.setLastUpdatedByUser(null);

		return assetModel;
	}

	public List<PhysicalServer> getCreatedPhysicalServers() {
		return createdPhysicalServers;
	}

	public void setCreatedPhysicalServers(
			List<PhysicalServer> createdPhysicalServers) {
		this.createdPhysicalServers = createdPhysicalServers;
	}
	
	public PhysicalServer addCreatedPhysicalServer(PhysicalServer physicalServer) {
		getCreatedPhysicalServers().add(physicalServer);
		physicalServer.setCreatedByUser(this);

		return physicalServer;
	}

	public PhysicalServer removeCreatedPhysicalServer(PhysicalServer physicalServer) {
		getCreatedPhysicalServers().remove(physicalServer);
		physicalServer.setCreatedByUser(null);

		return physicalServer;
	}

	public List<PhysicalServer> getUpdatedPhysicalServers() {
		return updatedPhysicalServers;
	}

	public void setUpdatedPhysicalServers(
			List<PhysicalServer> updatedPhysicalServers) {
		this.updatedPhysicalServers = updatedPhysicalServers;
	}
	
	public PhysicalServer addUpdatedPhysicalServer(PhysicalServer physicalServer) {
		getUpdatedPhysicalServers().add(physicalServer);
		physicalServer.setLastUpdatedByUser(this);

		return physicalServer;
	}

	public PhysicalServer removeUpdatedPhysicalServer(PhysicalServer physicalServer) {
		getUpdatedPhysicalServers().remove(physicalServer);
		physicalServer.setLastUpdatedByUser(null);

		return physicalServer;
	}

	public List<VmFarm> getCreatedVMFarms() {
		return createdVMFarms;
	}

	public void setCreatedVMFarms(List<VmFarm> createdVMFarms) {
		this.createdVMFarms = createdVMFarms;
	}
	
	public VmFarm addCreatedVmFarm(VmFarm vmFarm) {
		getCreatedVMFarms().add(vmFarm);
		vmFarm.setCreatedByUser(this);

		return vmFarm;
	}

	public VmFarm removeCreatedVmFarm(VmFarm vmFarm) {
		getCreatedVMFarms().remove(vmFarm);
		vmFarm.setCreatedByUser(null);

		return vmFarm;
	}

	public List<VmFarm> getUpdatedVMFarms() {
		return updatedVMFarms;
	}

	public void setUpdatedVMFarms(List<VmFarm> updatedVMFarms) {
		this.updatedVMFarms = updatedVMFarms;
	}
	
	public VmFarm addUpdatedVmFarm(VmFarm vmFarm) {
		getUpdatedVMFarms().add(vmFarm);
		vmFarm.setLastUpdatedByUser(this);

		return vmFarm;
	}

	public VmFarm removeUpdatedVmFarm(VmFarm vmFarm) {
		getUpdatedVMFarms().remove(vmFarm);
		vmFarm.setLastUpdatedByUser(null);

		return vmFarm;
	}

	public List<ServerCluster> getCreatedServerClusters() {
		return createdServerClusters;
	}

	public void setCreatedServerClusters(List<ServerCluster> createdServerClusters) {
		this.createdServerClusters = createdServerClusters;
	}
	
	public ServerCluster addCreatedServerCluster(ServerCluster serverCluster) {
		getCreatedServerClusters().add(serverCluster);
		serverCluster.setCreatedByUser(this);

		return serverCluster;
	}

	public ServerCluster removeCreatedServerCluster(ServerCluster serverCluster) {
		getCreatedServerClusters().remove(serverCluster);
		serverCluster.setCreatedByUser(null);

		return serverCluster;
	}

	public List<ServerCluster> getUpdatedServerClusters() {
		return updatedServerClusters;
	}

	public void setUpdatedServerClusters(List<ServerCluster> updatedServerClusters) {
		this.updatedServerClusters = updatedServerClusters;
	}
	
	public ServerCluster addUpdatedServerCluster(ServerCluster serverCluster) {
		getUpdatedServerClusters().add(serverCluster);
		serverCluster.setLastUpdatedByUser(this);

		return serverCluster;
	}

	public ServerCluster removeUpdatedServerCluster(ServerCluster serverCluster) {
		getUpdatedServerClusters().remove(serverCluster);
		serverCluster.setLastUpdatedByUser(null);

		return serverCluster;
	}

	public List<ServersInServerCluster> getCreatedServersInServerClusters() {
		return createdServersInServerClusters;
	}

	public void setCreatedServersInServerClusters(
			List<ServersInServerCluster> createdServersInServerClusters) {
		this.createdServersInServerClusters = createdServersInServerClusters;
	}
	
	public ServersInServerCluster addCreatedServersInServerCluster(ServersInServerCluster serversInServerCluster) {
		getCreatedServersInServerClusters().add(serversInServerCluster);
		serversInServerCluster.setCreatedByUser(this);

		return serversInServerCluster;
	}

	public ServersInServerCluster removeCreatedServersInServerCluster(ServersInServerCluster serversInServerCluster) {
		getCreatedServersInServerClusters().remove(serversInServerCluster);
		serversInServerCluster.setCreatedByUser(null);

		return serversInServerCluster;
	}

	public List<ServersInServerCluster> getUpdatedServersInServerClusters() {
		return updatedServersInServerClusters;
	}

	public void setUpdatedServersInServerClusters(
			List<ServersInServerCluster> updatedServersInServerClusters) {
		this.updatedServersInServerClusters = updatedServersInServerClusters;
	}
	
	public ServersInServerCluster addUpdatedServersInServerCluster(ServersInServerCluster serversInServerCluster) {
		getUpdatedServersInServerClusters().add(serversInServerCluster);
		serversInServerCluster.setLastUpdatedByUser(this);

		return serversInServerCluster;
	}

	public ServersInServerCluster removeUpdatedServersInServerCluster(ServersInServerCluster serversInServerCluster) {
		getUpdatedServersInServerClusters().remove(serversInServerCluster);
		serversInServerCluster.setLastUpdatedByUser(null);

		return serversInServerCluster;
	}

	public List<ServerInstalledSoftware> getCreatedServerInstalledSoftware() {
		return createdServerInstalledSoftware;
	}

	public void setCreatedServerInstalledSoftware(
			List<ServerInstalledSoftware> createdServerInstalledSoftware) {
		this.createdServerInstalledSoftware = createdServerInstalledSoftware;
	}
	
	public ServerInstalledSoftware addCreatedServerInstalledSoftware(ServerInstalledSoftware serverInstalledSoftware) {
		getCreatedServerInstalledSoftware().add(serverInstalledSoftware);
		serverInstalledSoftware.setCreatedByUser(this);

		return serverInstalledSoftware;
	}

	public ServerInstalledSoftware removeCreatedServerInstalledSoftware(ServerInstalledSoftware serverInstalledSoftware) {
		getCreatedServerInstalledSoftware().remove(serverInstalledSoftware);
		serverInstalledSoftware.setCreatedByUser(null);

		return serverInstalledSoftware;
	}

	public List<ServerInstalledSoftware> getUpdatedServerInstalledSoftware() {
		return updatedServerInstalledSoftware;
	}

	public void setUpdatedServerInstalledSoftware(
			List<ServerInstalledSoftware> updatedServerInstalledSoftware) {
		this.updatedServerInstalledSoftware = updatedServerInstalledSoftware;
	}
	
	public ServerInstalledSoftware addUpdatedServerInstalledSoftware(ServerInstalledSoftware serverInstalledSoftware) {
		getUpdatedServerInstalledSoftware().add(serverInstalledSoftware);
		serverInstalledSoftware.setLastUpdatedByUser(this);

		return serverInstalledSoftware;
	}

	public ServerInstalledSoftware removeUpdatedServerInstalledSoftware(ServerInstalledSoftware serverInstalledSoftware) {
		getUpdatedServerInstalledSoftware().remove(serverInstalledSoftware);
		serverInstalledSoftware.setLastUpdatedByUser(null);

		return serverInstalledSoftware;
	}

	public List<ServerDAS> getCreatedServerDAS() {
		return createdServerDAS;
	}

	public void setCreatedServerDAS(List<ServerDAS> createdServerDAS) {
		this.createdServerDAS = createdServerDAS;
	}
	
	public ServerDAS addCreatedServerDAS(ServerDAS serverDAS) {
		getCreatedServerDAS().add(serverDAS);
		serverDAS.setCreatedByUser(this);

		return serverDAS;
	}

	public ServerDAS removeCreatedServerDAS(ServerDAS serverDAS) {
		getCreatedServerDAS().remove(serverDAS);
		serverDAS.setCreatedByUser(null);

		return serverDAS;
	}

	public List<ServerDAS> getUpdatedServerDAS() {
		return updatedServerDAS;
	}

	public void setUpdatedServerDAS(List<ServerDAS> updatedServerDAS) {
		this.updatedServerDAS = updatedServerDAS;
	}
	
	public ServerDAS addUpdatedServerDAS(ServerDAS serverDAS) {
		getUpdatedServerDAS().add(serverDAS);
		serverDAS.setLastUpdatedByUser(this);

		return serverDAS;
	}

	public ServerDAS removeUpdatedServerDAS(ServerDAS serverDAS) {
		getUpdatedServerDAS().remove(serverDAS);
		serverDAS.setLastUpdatedByUser(null);

		return serverDAS;
	}

	public List<ServerShare> getCreatedServerShares() {
		return createdServerShares;
	}

	public void setCreatedServerShares(List<ServerShare> createdServerShares) {
		this.createdServerShares = createdServerShares;
	}
	
	public ServerShare addCreatedServerShare(ServerShare serverShare) {
		getCreatedServerShares().add(serverShare);
		serverShare.setCreatedByUser(this);

		return serverShare;
	}

	public ServerShare removeCreatedServerShare(ServerShare serverShare) {
		getCreatedServerShares().remove(serverShare);
		serverShare.setCreatedByUser(null);

		return serverShare;
	}

	public List<ServerShare> getUpdatedServerShares() {
		return updatedServerShares;
	}

	public void setUpdatedServerShares(List<ServerShare> updatedServerShares) {
		this.updatedServerShares = updatedServerShares;
	}
	
	public ServerShare addUpdatedServerShare(ServerShare serverShare) {
		getUpdatedServerShares().add(serverShare);
		serverShare.setLastUpdatedByUser(this);

		return serverShare;
	}

	public ServerShare removeUpdatedServerShare(ServerShare serverShare) {
		getUpdatedServerShares().remove(serverShare);
		serverShare.setLastUpdatedByUser(null);

		return serverShare;
	}

	public List<ServerShareMount> getCreatedServerShareMounts() {
		return createdServerShareMounts;
	}

	public void setCreatedServerShareMounts(
			List<ServerShareMount> createdServerShareMounts) {
		this.createdServerShareMounts = createdServerShareMounts;
	}
	
	public ServerShareMount addCreatedServerShareMount(ServerShareMount serverShareMount) {
		getCreatedServerShareMounts().add(serverShareMount);
		serverShareMount.setCreatedByUser(this);

		return serverShareMount;
	}

	public ServerShareMount removeCreatedServerShareMount(ServerShareMount serverShareMount) {
		getCreatedServerShareMounts().remove(serverShareMount);
		serverShareMount.setCreatedByUser(null);

		return serverShareMount;
	}

	public List<ServerShareMount> getUpdatedServerShareMounts() {
		return updatedServerShareMounts;
	}

	public void setUpdatedServerShareMounts(
			List<ServerShareMount> updatedServerShareMounts) {
		this.updatedServerShareMounts = updatedServerShareMounts;
	}
	
	public ServerShareMount addUpdatedServerShareMount(ServerShareMount serverShareMount) {
		getUpdatedServerShareMounts().add(serverShareMount);
		serverShareMount.setLastUpdatedByUser(this);

		return serverShareMount;
	}

	public ServerShareMount removeUpdatedServerShareMount(ServerShareMount serverShareMount) {
		getUpdatedServerShareMounts().remove(serverShareMount);
		serverShareMount.setLastUpdatedByUser(null);

		return serverShareMount;
	}

	public List<StorageService> getCreatedStorageServices() {
		return createdStorageServices;
	}

	public void setCreatedStorageServices(
			List<StorageService> createdStorageServices) {
		this.createdStorageServices = createdStorageServices;
	}
	
	public StorageService addCreatedStorageService(StorageService storageService) {
		getCreatedStorageServices().add(storageService);
		storageService.setCreatedByUser(this);

		return storageService;
	}

	public StorageService removeCreatedStorageService(StorageService storageService) {
		getCreatedStorageServices().remove(storageService);
		storageService.setCreatedByUser(null);

		return storageService;
	}

	public List<StorageService> getUpdatedStorageServices() {
		return updatedStorageServices;
	}

	public void setUpdatedStorageServices(
			List<StorageService> updatedStorageServices) {
		this.updatedStorageServices = updatedStorageServices;
	}
	
	public StorageService addUpdatedStorageService(StorageService storageService) {
		getUpdatedStorageServices().add(storageService);
		storageService.setLastUpdatedByUser(this);

		return storageService;
	}

	public StorageService removeUpdatedStorageService(StorageService storageService) {
		getUpdatedStorageServices().remove(storageService);
		storageService.setLastUpdatedByUser(null);

		return storageService;
	}

	public List<Nasshare> getCreatedNASShares() {
		return createdNASShares;
	}

	public void setCreatedNASShares(List<Nasshare> createdNASShares) {
		this.createdNASShares = createdNASShares;
	}
	
	public Nasshare addCreatedNasshare(Nasshare nasshare) {
		getCreatedNASShares().add(nasshare);
		nasshare.setCreatedByUser(this);

		return nasshare;
	}

	public Nasshare removeCreatedNasshare(Nasshare nasshare) {
		getCreatedNASShares().remove(nasshare);
		nasshare.setCreatedByUser(null);

		return nasshare;
	}

	public List<Nasshare> getUpdatedNASShares() {
		return updatedNASShares;
	}

	public void setUpdatedNASShares(List<Nasshare> updatedNASShares) {
		this.updatedNASShares = updatedNASShares;
	}
	
	public Nasshare addUpdatedNasshare(Nasshare nasshare) {
		getUpdatedNASShares().add(nasshare);
		nasshare.setLastUpdatedByUser(this);

		return nasshare;
	}

	public Nasshare removeUpdatedNasshare(Nasshare nasshare) {
		getUpdatedNASShares().remove(nasshare);
		nasshare.setLastUpdatedByUser(null);

		return nasshare;
	}


	public List<Sanlun> getCreatedSANLUNs() {
		return createdSANLUNs;
	}

	public void setCreatedSANLUNs(List<Sanlun> createdSANLUNs) {
		this.createdSANLUNs = createdSANLUNs;
	}
	
	public Sanlun addCreatedSanlun(Sanlun sanlun) {
		getCreatedSANLUNs().add(sanlun);
		sanlun.setCreatedByUser(this);

		return sanlun;
	}

	public Sanlun removeCreatedSanlun(Sanlun sanlun) {
		getCreatedSANLUNs().remove(sanlun);
		sanlun.setCreatedByUser(null);

		return sanlun;
	}

	public List<Sanlun> getUpdatedSANLUNs() {
		return updatedSANLUNs;
	}

	public void setUpdatedSANLUNs(List<Sanlun> updatedSANLUNs) {
		this.updatedSANLUNs = updatedSANLUNs;
	}
	
	public Sanlun addUpdatedSanlun(Sanlun sanlun) {
		getUpdatedSANLUNs().add(sanlun);
		sanlun.setLastUpdatedByUser(this);

		return sanlun;
	}

	public Sanlun removeUpdatedSanlun(Sanlun sanlun) {
		getUpdatedSANLUNs().remove(sanlun);
		sanlun.setLastUpdatedByUser(null);

		return sanlun;
	}

	public List<ServerSANConnection> getCreatedServerSANConnections() {
		return createdServerSANConnections;
	}

	public void setCreatedServerSANConnections(
			List<ServerSANConnection> createdServerSANConnections) {
		this.createdServerSANConnections = createdServerSANConnections;
	}
	
	public ServerSANConnection addCreatedServerSANConnection(ServerSANConnection serverSANConnection) {
		getCreatedServerSANConnections().add(serverSANConnection);
		serverSANConnection.setCreatedByUser(this);

		return serverSANConnection;
	}

	public ServerSANConnection removeCreatedServerSANConnection(ServerSANConnection serverSANConnection) {
		getCreatedServerSANConnections().remove(serverSANConnection);
		serverSANConnection.setCreatedByUser(null);

		return serverSANConnection;
	}

	public List<ServerSANConnection> getUpdatedServerSANConnections() {
		return updatedServerSANConnections;
	}

	public void setUpdatedServerSANConnections(
			List<ServerSANConnection> updatedServerSANConnections) {
		this.updatedServerSANConnections = updatedServerSANConnections;
	}
	
	public ServerSANConnection addUpdatedServerSANConnection(ServerSANConnection serverSANConnection) {
		getUpdatedServerSANConnections().add(serverSANConnection);
		serverSANConnection.setLastUpdatedByUser(this);

		return serverSANConnection;
	}

	public ServerSANConnection removeUpdatedServerSANConnection(ServerSANConnection serverSANConnection) {
		getUpdatedServerSANConnections().remove(serverSANConnection);
		serverSANConnection.setLastUpdatedByUser(null);

		return serverSANConnection;
	}


	public List<NetworkDevice> getCreatedNetworkDevices() {
		return createdNetworkDevices;
	}

	public void setCreatedNetworkDevices(List<NetworkDevice> createdNetworkDevices) {
		this.createdNetworkDevices = createdNetworkDevices;
	}
	
	public NetworkDevice addCreatedNetworkDevice(NetworkDevice networkDevice) {
		getCreatedNetworkDevices().add(networkDevice);
		networkDevice.setCreatedByUser(this);

		return networkDevice;
	}

	public NetworkDevice removeCreatedNetworkDevice(NetworkDevice networkDevice) {
		getCreatedNetworkDevices().remove(networkDevice);
		networkDevice.setCreatedByUser(null);

		return networkDevice;
	}

	public List<NetworkDevice> getUpdatedNetworkDevices() {
		return updatedNetworkDevices;
	}

	public void setUpdatedNetworkDevices(List<NetworkDevice> updatedNetworkDevices) {
		this.updatedNetworkDevices = updatedNetworkDevices;
	}
	
	public NetworkDevice addUpdatedNetworkDevice(NetworkDevice networkDevice) {
		getUpdatedNetworkDevices().add(networkDevice);
		networkDevice.setLastUpdatedByUser(this);

		return networkDevice;
	}

	public NetworkDevice removeUpdatedNetworkDevice(NetworkDevice networkDevice) {
		getUpdatedNetworkDevices().remove(networkDevice);
		networkDevice.setLastUpdatedByUser(null);

		return networkDevice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public List<TaskTemplateByMethod> getTasktemplatebymethods() {
		return this.tasktemplatebymethods;
	}

	public void setTasktemplatebymethods(List<TaskTemplateByMethod> tasktemplatebymethods) {
		this.tasktemplatebymethods = tasktemplatebymethods;
	}

	public TaskTemplateByMethod addTasktemplatebymethod(TaskTemplateByMethod tasktemplatebymethod) {
		getTasktemplatebymethods().add(tasktemplatebymethod);
		tasktemplatebymethod.setUser(this);

		return tasktemplatebymethod;
	}

	public TaskTemplateByMethod removeTasktemplatebymethod(TaskTemplateByMethod tasktemplatebymethod) {
		getTasktemplatebymethods().remove(tasktemplatebymethod);
		tasktemplatebymethod.setUser(null);

		return tasktemplatebymethod;
	}
	

	public List<MigrationScope> getCreatedMigrationScopes() {
		return createdMigrationScopes;
	}

	public void setCreatedMigrationScopes(
			List<MigrationScope> createdMigrationScopes) {
		this.createdMigrationScopes = createdMigrationScopes;
	}

	public List<AssetRole> getCreatedAssetRoles() {
		return createdAssetRoles;
	}

	public void setCreatedAssetRoles(List<AssetRole> createdAssetRoles) {
		this.createdAssetRoles = createdAssetRoles;
	}

	public List<AssetRole> getUpdatedAssetRoles() {
		return updatedAssetRoles;
	}

	public void setUpdatedAssetRoles(List<AssetRole> updatedAssetRoles) {
		this.updatedAssetRoles = updatedAssetRoles;
	}

	public List<MigrationScope> getUpdatedMigrationScopes() {
		return updatedMigrationScopes;
	}

	public void setUpdatedMigrationScopes(
			List<MigrationScope> updatedMigrationScopes) {
		this.updatedMigrationScopes = updatedMigrationScopes;
	}

	public MigrationScope addCreatedMigrationscope(MigrationScope migrationscope) {
		getCreatedMigrationScopes().add(migrationscope);
		migrationscope.setCreatedByUser(this);

		return migrationscope;
	}

	public MigrationScope removeCreatedMigrationscope(MigrationScope migrationscope) {
		getCreatedMigrationScopes().remove(migrationscope);
		migrationscope.setCreatedByUser(null);

		return migrationscope;
	}
	public MigrationScope addUpdatedMigrationscope(MigrationScope migrationscope) {
		getUpdatedMigrationScopes().add(migrationscope);
		migrationscope.setLastUpdatedByUser(this);

		return migrationscope;
	}

	public MigrationScope removeUpdatedMigrationscope(MigrationScope migrationscope) {
		getUpdatedMigrationScopes().remove(migrationscope);
		migrationscope.setLastUpdatedByUser(null);

		return migrationscope;
	}
}