package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the templateuploads database table.
 * 
 */
@Entity
@Table(name = "TemplateUploads")
@NamedQuery(name = "TemplateUpload.findAll", query = "SELECT t FROM TemplateUpload t")
public class TemplateUpload implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int templateUploadID;

	private String localFileName;
	private String uploadStatus;
	private Date uploadTime;
	private String dataConsistencyCheckOverriden;
	private String dataSourceConflictOverriden;
	
	// bi-directional many-to-one association to AssetType
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "AssetTypeID")
	private AssetType assettype;

	// bi-directional many-to-one association to DataSource
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DataSourceID")
	private DataSource datasource;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "UploadUserID")
	private User user;
	
	@Column(name="OriginalFileName")
	private String originalFileName;
	
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] assetData;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Application> applications;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ApplicationComponent> applicationComponents;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ApplicationComponentInstance> applicationComponentInstances;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ApplicationInstance> applicationInstances;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ApplicationDataRestriction> applicationDataRestrictions;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ApplicationUserLocation> applicationUserLocations;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<OperationalService> operationalServices;

	@OneToMany(mappedBy = "templateUpload")
	private List<ApplicationOperationalService> applicationOperationalServices;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ApptoappDependency> apptoappDependencys;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<SoftwareManufacturer> softwareManufactures;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Software> softwares;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<SoftwareVersion> softwareVersions;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ApplicationComponentSoftwareRequirement> ApplicationComponentSoftwareRequirements;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<LogicalDataLink> logicalDataLinks;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Protocol> protocols;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<SaaSApplication> saaApplications;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<PaaS> paaasList;
		
	@OneToMany(mappedBy = "templateUpload")
	private List<BusinessService> businessServices;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<GeographicLocation> geographicLocation;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServiceProvider> serviceProviders;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Server> servers;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Building> buildings;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Floor> floors;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Room> rooms;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<FloorLocation> FloorLocations;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<BladeChassis> bladeChasis;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<HardwareManufacturer> hardwareManufacturers;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<AssetModel> assetModel;
	
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Rack> racks;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<PhysicalServer> physicalServers;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServerCluster> serverClusters;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServersInServerCluster> serversInServerClusters;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServerInstalledSoftware> serverInstalledSoftwares;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServerDAS> serverDASes;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServerShare> serverShares;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServerShareMount> serverShareMounts;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<StorageService> storageServices;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Nasshare> nassShares;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<Sanlun> sanluns;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<ServerSANConnection> serverSANConnections;
	
	@OneToMany(mappedBy = "templateUpload")
	private List<NetworkDevice> networkDevices;
	
	public TemplateUpload() {
	}
	
	public int getTemplateUploadID() {
		return this.templateUploadID;
	}

	public void setTemplateUploadID(int templateUploadID) {
		this.templateUploadID = templateUploadID;
	}

	public String getLocalFileName() {
		return this.localFileName;
	}

	public void setLocalFileName(String localFileName) {
		this.localFileName = localFileName;
	}

	public AssetType getAssettype() {
		return this.assettype;
	}

	public void setAssettype(AssetType assettype) {
		this.assettype = assettype;
	}

	public DataSource getDatasource() {
		return this.datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getUploadStatus() {
		return uploadStatus;
	}

	public void setUploadStatus(String uploadStatus) {
		this.uploadStatus = uploadStatus;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getDataConsistencyCheckOverriden() {
		return dataConsistencyCheckOverriden;
	}

	public void setDataConsistencyCheckOverriden(String dataConsistencyCheckOverriden) {
		this.dataConsistencyCheckOverriden = dataConsistencyCheckOverriden;
	}

	public String getDataSourceConflictOverriden() {
		return dataSourceConflictOverriden;
	}

	public void setDataSourceConflictOverriden(String dataSourceConflictOverriden) {
		this.dataSourceConflictOverriden = dataSourceConflictOverriden;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setTemplateUpload(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setTemplateUpload(null);

		return application;
	}

	public List<ApplicationComponent> getApplicationComponents() {
		return applicationComponents;
	}

	public void setApplicationComponents(
			List<ApplicationComponent> applicationComponents) {
		this.applicationComponents = applicationComponents;
	}
	
	public ApplicationComponent addApplicationComponent(ApplicationComponent applicationComponent) {
		getApplicationComponents().add(applicationComponent);
		applicationComponent.setTemplateUpload(this);

		return applicationComponent;
	}

	public ApplicationComponent removeApplicationComponent(ApplicationComponent applicationComponent) {
		getApplicationComponents().remove(applicationComponent);
		applicationComponent.setTemplateUpload(null);

		return applicationComponent;
	}

	public List<ApplicationComponentInstance> getApplicationComponentInstances() {
		return applicationComponentInstances;
	}

	public void setApplicationComponentInstances(
			List<ApplicationComponentInstance> applicationComponentInstances) {
		this.applicationComponentInstances = applicationComponentInstances;
	}
	
	public ApplicationComponentInstance addApplicationComponentInstance(ApplicationComponentInstance applicationComponentInstance) {
		getApplicationComponentInstances().add(applicationComponentInstance);
		applicationComponentInstance.setTemplateUpload(this);

		return applicationComponentInstance;
	}

	public ApplicationComponentInstance removeApplicationComponentInstance(ApplicationComponentInstance applicationComponentInstance) {
		getApplicationComponentInstances().remove(applicationComponentInstance);
		applicationComponentInstance.setTemplateUpload(null);

		return applicationComponentInstance;
	}

	public List<ApplicationInstance> getApplicationInstances() {
		return applicationInstances;
	}

	public void setApplicationInstances(
			List<ApplicationInstance> applicationInstances) {
		this.applicationInstances = applicationInstances;
	}
	
	public ApplicationInstance addApplicationInstance(ApplicationInstance applicationInstance) {
		getApplicationInstances().add(applicationInstance);
		applicationInstance.setTemplateUpload(this);

		return applicationInstance;
	}

	public ApplicationInstance removeApplicationInstance(ApplicationInstance applicationInstance) {
		getApplicationInstances().remove(applicationInstance);
		applicationInstance.setTemplateUpload(null);

		return applicationInstance;
	}

	public List<ApplicationDataRestriction> getApplicationDataRestrictions() {
		return applicationDataRestrictions;
	}

	public void setApplicationDataRestrictions(
			List<ApplicationDataRestriction> applicationDataRestrictions) {
		this.applicationDataRestrictions = applicationDataRestrictions;
	}
	
	public ApplicationDataRestriction addApplicationDataRestriction(ApplicationDataRestriction applicationDataRestriction) {
		getApplicationDataRestrictions().add(applicationDataRestriction);
		applicationDataRestriction.setTemplateUpload(this);

		return applicationDataRestriction;
	}

	public ApplicationDataRestriction removeApplicationDataRestriction(ApplicationDataRestriction applicationDataRestriction) {
		getApplicationDataRestrictions().remove(applicationDataRestriction);
		applicationDataRestriction.setTemplateUpload(null);

		return applicationDataRestriction;
	}

	public List<ApplicationUserLocation> getApplicationUserLocations() {
		return applicationUserLocations;
	}

	public void setApplicationUserLocations(
			List<ApplicationUserLocation> applicationUserLocations) {
		this.applicationUserLocations = applicationUserLocations;
	}
	
	public ApplicationUserLocation addApplicationUserLocation(ApplicationUserLocation applicationUserLocation) {
		getApplicationUserLocations().add(applicationUserLocation);
		applicationUserLocation.setTemplateUpload(this);

		return applicationUserLocation;
	}

	public ApplicationUserLocation removeApplicationUserLocation(ApplicationUserLocation applicationUserLocation) {
		getApplicationUserLocations().remove(applicationUserLocation);
		applicationUserLocation.setTemplateUpload(null);

		return applicationUserLocation;
	}

	public List<OperationalService> getOperationalServices() {
		return operationalServices;
	}

	public void setOperationalServices(List<OperationalService> operationalServices) {
		this.operationalServices = operationalServices;
	}
	
	public OperationalService addOperationalService(OperationalService operationalService) {
		getOperationalServices().add(operationalService);
		operationalService.setTemplateUpload(this);

		return operationalService;
	}

	public OperationalService removeOperationalService(OperationalService operationalService) {
		getOperationalServices().remove(operationalService);
		operationalService.setTemplateUpload(null);

		return operationalService;
	}

	public List<ApplicationOperationalService> getApplicationOperationalServices() {
		return applicationOperationalServices;
	}

	public void setApplicationOperationalServices(
			List<ApplicationOperationalService> applicationOperationalServices) {
		this.applicationOperationalServices = applicationOperationalServices;
	}
	
	public ApplicationOperationalService addApplicationOperationalService(ApplicationOperationalService applicationOperationalService) {
		getApplicationOperationalServices().add(applicationOperationalService);
		applicationOperationalService.setTemplateUpload(this);

		return applicationOperationalService;
	}
	
	public ApplicationOperationalService removeApplicationOperationalService(ApplicationOperationalService applicationOperationalService) {
		getApplicationOperationalServices().remove(applicationOperationalService);
		applicationOperationalService.setTemplateUpload(null);

		return applicationOperationalService;
	}

	public List<ApptoappDependency> getApptoappDependencys() {
		return apptoappDependencys;
	}

	public void setApptoappDependencys(List<ApptoappDependency> apptoappDependencys) {
		this.apptoappDependencys = apptoappDependencys;
	}
	
	public ApptoappDependency addApptoappDependency(ApptoappDependency apptoappDependency) {
		getApptoappDependencys().add(apptoappDependency);
		apptoappDependency.setTemplateUpload(this);

		return apptoappDependency;
	}
	
	public ApptoappDependency removeApptoappDependency(ApptoappDependency apptoappDependency) {
		getApptoappDependencys().remove(apptoappDependency);
		apptoappDependency.setTemplateUpload(null);

		return apptoappDependency;
	}

	public List<SoftwareManufacturer> getSoftwareManufactures() {
		return softwareManufactures;
	}

	public void setSoftwareManufactures(
			List<SoftwareManufacturer> softwareManufactures) {
		this.softwareManufactures = softwareManufactures;
	}
	
	public SoftwareManufacturer addSoftwareManufacturer(SoftwareManufacturer softwareManufacturer) {
		getSoftwareManufactures().add(softwareManufacturer);
		softwareManufacturer.setTemplateUpload(this);

		return softwareManufacturer;
	}
	
	public SoftwareManufacturer removeSoftwareManufacturer(SoftwareManufacturer softwareManufacturer) {
		getSoftwareManufactures().remove(softwareManufacturer);
		softwareManufacturer.setTemplateUpload(null);

		return softwareManufacturer;
	}

	public List<Software> getSoftwares() {
		return softwares;
	}

	public void setSoftwares(List<Software> softwares) {
		this.softwares = softwares;
	}
	
	public Software addSoftware(Software software) {
		getSoftwares().add(software);
		software.setTemplateUpload(this);

		return software;
	}
	
	public Software removeSoftware(Software software) {
		getSoftwares().remove(software);
		software.setTemplateUpload(null);

		return software;
	}

	public List<SoftwareVersion> getSoftwareVersions() {
		return softwareVersions;
	}

	public void setSoftwareVersions(List<SoftwareVersion> softwareVersions) {
		this.softwareVersions = softwareVersions;
	}
	
	public SoftwareVersion addSoftwareVersion(SoftwareVersion softwareVersion) {
		getSoftwareVersions().add(softwareVersion);
		softwareVersion.setTemplateUpload(this);

		return softwareVersion;
	}
	
	public SoftwareVersion removeSoftwareVersion(SoftwareVersion softwareVersion) {
		getSoftwareVersions().remove(softwareVersion);
		softwareVersion.setTemplateUpload(null);

		return softwareVersion;
	}

	public List<ApplicationComponentSoftwareRequirement> getApplicationComponentSoftwareRequirements() {
		return ApplicationComponentSoftwareRequirements;
	}

	public void setApplicationComponentSoftwareRequirements(
			List<ApplicationComponentSoftwareRequirement> applicationComponentSoftwareRequirements) {
		ApplicationComponentSoftwareRequirements = applicationComponentSoftwareRequirements;
	}
	
	public ApplicationComponentSoftwareRequirement addApplicationComponentSoftwareRequirement(ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement) {
		getApplicationComponentSoftwareRequirements().add(applicationComponentSoftwareRequirement);
		applicationComponentSoftwareRequirement.setTemplateUpload(this);

		return applicationComponentSoftwareRequirement;
	}
	
	public ApplicationComponentSoftwareRequirement removeApplicationComponentSoftwareRequirement(ApplicationComponentSoftwareRequirement applicationComponentSoftwareRequirement) {
		getApplicationComponentSoftwareRequirements().remove(applicationComponentSoftwareRequirement);
		applicationComponentSoftwareRequirement.setTemplateUpload(null);

		return applicationComponentSoftwareRequirement;
	}
	
	public List<LogicalDataLink> getLogicalDataLinks() {
		return logicalDataLinks;
	}

	public void setLogicalDataLinks(List<LogicalDataLink> logicalDataLinks) {
		this.logicalDataLinks = logicalDataLinks;
	}
	
	public LogicalDataLink addLogicalDataLink(LogicalDataLink logicalDataLink) {
		getLogicalDataLinks().add(logicalDataLink);
		logicalDataLink.setTemplateUpload(this);

		return logicalDataLink;
	}
	
	public LogicalDataLink removeLogicalDataLink(LogicalDataLink logicalDataLink) {
		getLogicalDataLinks().remove(logicalDataLink);
		logicalDataLink.setTemplateUpload(null);

		return logicalDataLink;
	}

	public List<Protocol> getProtocols() {
		return protocols;
	}

	public void setProtocols(List<Protocol> protocols) {
		this.protocols = protocols;
	}
	
	public Protocol addProtocol(Protocol protocol) {
		getProtocols().add(protocol);
		protocol.setTemplateUpload(this);

		return protocol;
	}

	public Protocol removeProtocol(Protocol protocol) {
		getProtocols().remove(protocol);
		protocol.setTemplateUpload(null);

		return protocol;
	}
	
	public List<SaaSApplication> getSaaApplications() {
		return saaApplications;
	}

	public void setSaaApplications(List<SaaSApplication> saaApplications) {
		this.saaApplications = saaApplications;
	}
	
	public SaaSApplication addSaaSApplication(SaaSApplication saaSApplication) {
		getSaaApplications().add(saaSApplication);
		saaSApplication.setTemplateUpload(this);

		return saaSApplication;
	}

	public SaaSApplication removeSaaSApplication(SaaSApplication saaSApplication) {
		getSaaApplications().remove(saaSApplication);
		saaSApplication.setTemplateUpload(null);

		return saaSApplication;
	}

	public List<PaaS> getPaaasList() {
		return paaasList;
	}

	public void setPaaasList(List<PaaS> paaasList) {
		this.paaasList = paaasList;
	}
	
	public PaaS addPaaS(PaaS paaS) {
		getPaaasList().add(paaS);
		paaS.setTemplateUpload(this);

		return paaS;
	}
	
	public PaaS removePaaS(PaaS paaS) {
		getPaaasList().remove(paaS);
		paaS.setTemplateUpload(null);

		return paaS;
	}

	public List<BusinessService> getBusinessServices() {
		return businessServices;
	}

	public void setBusinessServices(List<BusinessService> businessServices) {
		this.businessServices = businessServices;
	}
	
	public BusinessService addBusinessService(BusinessService businessService) {
		getBusinessServices().add(businessService);
		businessService.setTemplateUpload(this);

		return businessService;
	}

	public BusinessService removeBusinessService(BusinessService businessService) {
		getBusinessServices().remove(businessService);
		businessService.setTemplateUpload(null);

		return businessService;
	}

	public List<GeographicLocation> getGeographicLocation() {
		return geographicLocation;
	}

	public void setGeographicLocation(List<GeographicLocation> geographicLocation) {
		this.geographicLocation = geographicLocation;
	}
	
	public GeographicLocation addGeographicLocation(GeographicLocation geographicLocation) {
		getGeographicLocation().add(geographicLocation);
		geographicLocation.setTemplateUpload(this);

		return geographicLocation;
	}
	
	public GeographicLocation removeGeographicLocation(GeographicLocation geographicLocation) {
		getGeographicLocation().remove(geographicLocation);
		geographicLocation.setTemplateUpload(null);

		return geographicLocation;
	}

	public List<ServiceProvider> getServiceProviders() {
		return serviceProviders;
	}

	public void setServiceProviders(List<ServiceProvider> serviceProviders) {
		this.serviceProviders = serviceProviders;
	}
	
	public ServiceProvider addServiceProvider(ServiceProvider serviceProvider) {
		getServiceProviders().add(serviceProvider);
		serviceProvider.setTemplateUpload(this);

		return serviceProvider;
	}

	public ServiceProvider removeServiceProvider(ServiceProvider serviceProvider) {
		getServiceProviders().remove(serviceProvider);
		serviceProvider.setTemplateUpload(null);

		return serviceProvider;
	}

	public List<Server> getServers() {
		return servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}
	
	public Server addServer(Server server) {
		getServers().add(server);
		server.setTemplateUpload(this);

		return server;
	}

	public Server removeServer(Server server) {
		getServers().remove(server);
		server.setTemplateUpload(null);

		return server;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}
	
	public Building addBuilding(Building building) {
		getBuildings().add(building);
		building.setTemplateUpload(this);

		return building;
	}
	
	public Building removeBuilding(Building building) {
		getBuildings().remove(building);
		building.setTemplateUpload(null);

		return building;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}
	
	public Floor addFloor(Floor floor) {
		getFloors().add(floor);
		floor.setTemplateUpload(this);

		return floor;
	}
	
	public Floor removeFloor(Floor floor) {
		getFloors().remove(floor);
		floor.setTemplateUpload(null);

		return floor;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	public Room addRoom(Room room) {
		getRooms().add(room);
		room.setTemplateUpload(this);

		return room;
	}
	
	public Room removeoom(Room room) {
		getRooms().remove(room);
		room.setTemplateUpload(null);

		return room;
	}

	public List<FloorLocation> getFloorLocations() {
		return FloorLocations;
	}

	public void setFloorLocations(List<FloorLocation> floorLocations) {
		FloorLocations = floorLocations;
	}
	
	public FloorLocation addFloorLocation(FloorLocation floorLocation) {
		getFloorLocations().add(floorLocation);
		floorLocation.setTemplateUpload(this);

		return floorLocation;
	}

	public FloorLocation removeFloorLocation(FloorLocation floorLocation) {
		getFloorLocations().remove(floorLocation);
		floorLocation.setTemplateUpload(null);

		return floorLocation;
	}

	public List<BladeChassis> getBladeChasis() {
		return bladeChasis;
	}

	public void setBladeChasis(List<BladeChassis> bladeChasis) {
		this.bladeChasis = bladeChasis;
	}
	
	public BladeChassis addBladeChassis(BladeChassis bladeChassis) {
		getBladeChasis().add(bladeChassis);
		bladeChassis.setTemplateUpload(this);

		return bladeChassis;
	}
	
	public BladeChassis removeBladeChassis(BladeChassis bladeChassis) {
		getBladeChasis().remove(bladeChassis);
		bladeChassis.setTemplateUpload(null);

		return bladeChassis;
	}

	public List<HardwareManufacturer> getHardwareManufacturers() {
		return hardwareManufacturers;
	}

	public void setHardwareManufacturers(
			List<HardwareManufacturer> hardwareManufacturers) {
		this.hardwareManufacturers = hardwareManufacturers;
	}
	
	public HardwareManufacturer addHardwareManufacturer(HardwareManufacturer hardwareManufacturer) {
		getHardwareManufacturers().add(hardwareManufacturer);
		hardwareManufacturer.setTemplateUpload(this);

		return hardwareManufacturer;
	}

	public HardwareManufacturer removeHardwareManufacturer(HardwareManufacturer hardwareManufacturer) {
		getHardwareManufacturers().remove(hardwareManufacturer);
		hardwareManufacturer.setTemplateUpload(null);

		return hardwareManufacturer;
	}

	public List<AssetModel> getAssetModel() {
		return assetModel;
	}

	public void setAssetModel(List<AssetModel> assetModel) {
		this.assetModel = assetModel;
	}
	
	public AssetModel addAssetModel(AssetModel assetModel) {
		getAssetModel().add(assetModel);
		assetModel.setTemplateUpload(this);

		return assetModel;
	}
	
	public AssetModel removeAssetModel(AssetModel assetModel) {
		getAssetModel().remove(assetModel);
		assetModel.setTemplateUpload(null);

		return assetModel;
	}

	public List<Rack> getRacks() {
		return racks;
	}

	public void setRacks(List<Rack> racks) {
		this.racks = racks;
	}
	
	public Rack addRack(Rack rack) {
		getRacks().add(rack);
		rack.setTemplateUpload(this);

		return rack;
	}

	public Rack removeRack(Rack rack) {
		getRacks().remove(rack);
		rack.setTemplateUpload(null);

		return rack;
	}

	public List<PhysicalServer> getPhysicalServers() {
		return physicalServers;
	}

	public void setPhysicalServers(List<PhysicalServer> physicalServers) {
		this.physicalServers = physicalServers;
	}
	
	public PhysicalServer addPhysicalServer(PhysicalServer physicalServer) {
		getPhysicalServers().add(physicalServer);
		physicalServer.setTemplateUpload(this);

		return physicalServer;
	}

	public PhysicalServer removePhysicalServer(PhysicalServer physicalServer) {
		getPhysicalServers().remove(physicalServer);
		physicalServer.setTemplateUpload(null);

		return physicalServer;
	}
	public List<ServerCluster> getServerClusters() {
		return serverClusters;
	}

	public void setServerClusters(List<ServerCluster> serverClusters) {
		this.serverClusters = serverClusters;
	}
	
	public ServerCluster addgetServerClusters(ServerCluster serverCluster) {
		getServerClusters().add(serverCluster);
		serverCluster.setTemplateUpload(this);

		return serverCluster;
	}
	
	public ServerCluster removegetServerClusters(ServerCluster serverCluster) {
		getServerClusters().remove(serverCluster);
		serverCluster.setTemplateUpload(null);

		return serverCluster;
	}

	public List<ServersInServerCluster> getServersInServerClusters() {
		return serversInServerClusters;
	}

	public void setServersInServerClusters(
			List<ServersInServerCluster> serversInServerClusters) {
		this.serversInServerClusters = serversInServerClusters;
	}

	public ServersInServerCluster addServersInServerCluster(ServersInServerCluster serversInServerCluster) {
		getServersInServerClusters().add(serversInServerCluster);
		serversInServerCluster.setTemplateUpload(this);

		return serversInServerCluster;
	}
	
	public ServersInServerCluster removeServersInServerCluster(ServersInServerCluster serversInServerCluster) {
		getServersInServerClusters().remove(serversInServerCluster);
		serversInServerCluster.setTemplateUpload(null);

		return serversInServerCluster;
	}

	public List<ServerInstalledSoftware> getServerInstalledSoftwares() {
		return serverInstalledSoftwares;
	}

	public void setServerInstalledSoftwares(
			List<ServerInstalledSoftware> serverInstalledSoftwares) {
		this.serverInstalledSoftwares = serverInstalledSoftwares;
	}
	
	public ServerInstalledSoftware addServerInstalledSoftware(ServerInstalledSoftware serverInstalledSoftware) {
		getServerInstalledSoftwares().add(serverInstalledSoftware);
		serverInstalledSoftware.setTemplateUpload(this);

		return serverInstalledSoftware;
	}
	
	public ServerInstalledSoftware removeServerInstalledSoftware(ServerInstalledSoftware serverInstalledSoftware) {
		getServerInstalledSoftwares().remove(serverInstalledSoftware);
		serverInstalledSoftware.setTemplateUpload(null);

		return serverInstalledSoftware;
	}

	public List<ServerDAS> getServerDASes() {
		return serverDASes;
	}

	public void setServerDASes(List<ServerDAS> serverDASes) {
		this.serverDASes = serverDASes;
	}
	
	public ServerDAS addServerDAS(ServerDAS serverDAS) {
		getServerDASes().add(serverDAS);
		serverDAS.setTemplateUpload(this);

		return serverDAS;
	}

	public ServerDAS removeServerDAS(ServerDAS serverDAS) {
		getServerDASes().remove(serverDAS);
		serverDAS.setTemplateUpload(null);

		return serverDAS;
	}

	public List<ServerShare> getServerShares() {
		return serverShares;
	}

	public void setServerShares(List<ServerShare> serverShares) {
		this.serverShares = serverShares;
	}
	
	public ServerShare addServerShare(ServerShare serverShare) {
		getServerShares().add(serverShare);
		serverShare.setTemplateUpload(this);

		return serverShare;
	}

	public ServerShare removeServerShare(ServerShare serverShare) {
		getServerShares().remove(serverShare);
		serverShare.setTemplateUpload(null);

		return serverShare;
	}

	public List<ServerShareMount> getServerShareMounts() {
		return serverShareMounts;
	}

	public void setServerShareMounts(List<ServerShareMount> serverShareMounts) {
		this.serverShareMounts = serverShareMounts;
	}
	
	public ServerShareMount addServerShareMount(ServerShareMount serverShareMount) {
		getServerShareMounts().add(serverShareMount);
		serverShareMount.setTemplateUpload(this);

		return serverShareMount;
	}
	
	public ServerShareMount removeServerShareMount(ServerShareMount serverShareMount) {
		getServerShareMounts().remove(serverShareMount);
		serverShareMount.setTemplateUpload(null);

		return serverShareMount;
	}

	public List<StorageService> getStorageServices() {
		return storageServices;
	}

	public void setStorageServices(List<StorageService> storageServices) {
		this.storageServices = storageServices;
	}

	public StorageService addStorageService(StorageService storageService) {
		getStorageServices().add(storageService);
		storageService.setTemplateUpload(this);

		return storageService;
	}
	
	public StorageService removeStorageService(StorageService storageService) {
		getStorageServices().remove(storageService);
		storageService.setTemplateUpload(null);

		return storageService;
	}

	public List<Nasshare> getNassShares() {
		return nassShares;
	}

	public void setNassShares(List<Nasshare> nassShares) {
		this.nassShares = nassShares;
	}
	
	public Nasshare addNasshare(Nasshare nasshare) {
		getNassShares().add(nasshare);
		nasshare.setTemplateUpload(this);

		return nasshare;
	}
	
	public Nasshare removeNasshare(Nasshare nasshare) {
		getNassShares().remove(nasshare);
		nasshare.setTemplateUpload(null);

		return nasshare;
	}

	public List<Sanlun> getSanluns() {
		return sanluns;
	}

	public void setSanluns(List<Sanlun> sanluns) {
		this.sanluns = sanluns;
	}
	
	public Sanlun addSanlun(Sanlun sanlun) {
		getSanluns().add(sanlun);
		sanlun.setTemplateUpload(this);

		return sanlun;
	}

	public Sanlun removeSanlun(Sanlun sanlun) {
		getSanluns().remove(sanlun);
		sanlun.setTemplateUpload(null);

		return sanlun;
	}
	
	public List<ServerSANConnection> getServerSANConnections() {
		return serverSANConnections;
	}

	public void setServerSANConnections(
			List<ServerSANConnection> serverSANConnections) {
		this.serverSANConnections = serverSANConnections;
	}
	
	public ServerSANConnection addServerSANConnection(ServerSANConnection serverSANConnection) {
		getServerSANConnections().add(serverSANConnection);
		serverSANConnection.setTemplateUpload(this);

		return serverSANConnection;
	}
	
	public ServerSANConnection removeServerSANConnection(ServerSANConnection serverSANConnection) {
		getServerSANConnections().remove(serverSANConnection);
		serverSANConnection.setTemplateUpload(null);

		return serverSANConnection;
	}

	public List<NetworkDevice> getNetworkDevices() {
		return networkDevices;
	}

	public void setNetworkDevices(List<NetworkDevice> networkDevices) {
		this.networkDevices = networkDevices;
	}
	
	public NetworkDevice addNetworkDevice(NetworkDevice networkDevice) {
		getNetworkDevices().add(networkDevice);
		networkDevice.setTemplateUpload(this);

		return networkDevice;
	}

	public NetworkDevice removeNetworkDevice(NetworkDevice networkDevice) {
		getNetworkDevices().remove(networkDevice);
		networkDevice.setTemplateUpload(null);

		return networkDevice;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public byte[] getAssetData() {
		return assetData;
	}

	public void setAssetData(byte[] assetData) {
		this.assetData = assetData;
	}

	
}