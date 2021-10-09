package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the applications database table.
 * 
 */
@Entity
@Table(name = "Applications")
@NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
public class Application implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int applicationID;

	private String applicationName;
	private String businessUseDescription;
	private String designDocumentationLink;
	private String notes;
	private String changeControlNumber;
	private String targetDisposition;
	private String customField1;
	private String customField2;
	private String customField3;
	
	// bi-directional many-to-one association to BusinessService
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BusinessServiceID")
	private BusinessService businessservice;

	// bi-directional many-to-one association to DiscoveryState
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "DiscoveryStateId")
	private DiscoveryState discoverystate;

	// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CurrentDispositionID")
	private Disposition disposition1;

	/*// bi-directional many-to-one association to Disposition
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TargetDispositionID")
	private Disposition disposition2;*/

	// bi-directional many-to-one association to MigrationComplexity
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MigrationComplexityID")
	private MigrationComplexity migrationcomplexity;
	
	// bi-directional many-to-one association to BusinessCriticality
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "BusinessCriticalityID")
	private BusinessCriticality businessCriticality;

	// bi-directional many-to-one association to MigrationScope
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MigrationScopeID")
	private MigrationScope migrationscope;

	// bi-directional many-to-one association to MoveGroup
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MoveGroupID")
	private MoveGroup movegroup;

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
	@JoinColumn(name = "BusinessOwnerID")
	private User businessOwner;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TechnicalOwnerID")
	private User technicalOwner;
	
	// bi-directional many-to-one association to ChangeControlDecision
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ChangeControlDecisionID")
	private ChangeControlDecision changeControlDecision;
	
	// bi-directional many-to-one association to ApplicationChangeFreeze
	@OneToMany(mappedBy = "application")
	private List<ApplicationChangeFreeze> applicationchangefreezes;

	// bi-directional many-to-one association to ApplicationComponent
	@OneToMany(mappedBy = "application")
	private List<ApplicationComponent> applicationcomponents;

	// bi-directional many-to-one association to ApplicationDataRestriction
	@OneToMany(mappedBy = "application")
	private List<ApplicationDataRestriction> applicationdatarestrictions;

	// bi-directional many-to-one association to ApplicationInstance
	@OneToMany(mappedBy = "application")
	private List<ApplicationInstance> applicationinstances;

	// bi-directional many-to-one association to ApplicationOperationalService
	@OneToMany(mappedBy = "application")
	private List<ApplicationOperationalService> applicationoperationalservices;

	// bi-directional many-to-one association to ApplicationRole
//	@OneToMany(mappedBy = "application")
//	private List<ApplicationRole> applicationroles;

	// bi-directional many-to-one association to ApplicationUserLocation
	@OneToMany(mappedBy = "application")
	private List<ApplicationUserLocation> applicationuserlocations;

	// bi-directional many-to-one association to ApptoappDependency
	@OneToMany(mappedBy = "application1")
	private List<ApptoappDependency> apptoappdependencies1;

	// bi-directional many-to-one association to ApptoappDependency
	@OneToMany(mappedBy = "application2")
	private List<ApptoappDependency> apptoappdependencies2;

	// bi-directional many-to-one association to GroupApplicationEditRule
	@OneToMany(mappedBy = "application")
	private List<GroupApplicationEditRule> groupapplicationeditrules;

	// bi-directional many-to-one association to SaaSApplication
	@OneToMany(mappedBy = "application")
	private List<SaaSApplication> saasapplications;

	// bi-directional many-to-one association to TaskTracking
	//@OneToMany(mappedBy = "application")
	//private List<TaskTracking> tasktrackings;
    
	// bi-directional many-to-one association to UserApplicationEditRule
	@OneToMany(mappedBy = "application")
	private List<UserApplicationEditRule> userapplicationeditrules;
    
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
	
	public Application() {
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

	public int getApplicationID() {
		return this.applicationID;
	}

	public void setApplicationID(int applicationID) {
		this.applicationID = applicationID;
	}

	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getBusinessUseDescription() {
		return this.businessUseDescription;
	}

	public void setBusinessUseDescription(String businessUseDescription) {
		this.businessUseDescription = businessUseDescription;
	}

	public String getDesignDocumentationLink() {
		return this.designDocumentationLink;
	}

	public void setDesignDocumentationLink(String designDocumentationLink) {
		this.designDocumentationLink = designDocumentationLink;
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

	public List<ApplicationChangeFreeze> getApplicationchangefreezes() {
		return this.applicationchangefreezes;
	}

	public void setApplicationchangefreezes(
			List<ApplicationChangeFreeze> applicationchangefreezes) {
		this.applicationchangefreezes = applicationchangefreezes;
	}

	public ApplicationChangeFreeze addApplicationchangefreeze(
			ApplicationChangeFreeze applicationchangefreeze) {
		getApplicationchangefreezes().add(applicationchangefreeze);
		applicationchangefreeze.setApplication(this);

		return applicationchangefreeze;
	}

	public ApplicationChangeFreeze removeApplicationchangefreeze(
			ApplicationChangeFreeze applicationchangefreeze) {
		getApplicationchangefreezes().remove(applicationchangefreeze);
		applicationchangefreeze.setApplication(null);

		return applicationchangefreeze;
	}

	public List<ApplicationComponent> getApplicationcomponents() {
		return this.applicationcomponents;
	}

	public void setApplicationcomponents(
			List<ApplicationComponent> applicationcomponents) {
		this.applicationcomponents = applicationcomponents;
	}

	public ApplicationComponent addApplicationcomponent(
			ApplicationComponent applicationcomponent) {
		getApplicationcomponents().add(applicationcomponent);
		applicationcomponent.setApplication(this);

		return applicationcomponent;
	}

	public ApplicationComponent removeApplicationcomponent(
			ApplicationComponent applicationcomponent) {
		getApplicationcomponents().remove(applicationcomponent);
		applicationcomponent.setApplication(null);

		return applicationcomponent;
	}

	public List<ApplicationDataRestriction> getApplicationdatarestrictions() {
		return this.applicationdatarestrictions;
	}

	public void setApplicationdatarestrictions(
			List<ApplicationDataRestriction> applicationdatarestrictions) {
		this.applicationdatarestrictions = applicationdatarestrictions;
	}

	public ApplicationDataRestriction addApplicationdatarestriction(
			ApplicationDataRestriction applicationdatarestriction) {
		getApplicationdatarestrictions().add(applicationdatarestriction);
		applicationdatarestriction.setApplication(this);

		return applicationdatarestriction;
	}

	public ApplicationDataRestriction removeApplicationdatarestriction(
			ApplicationDataRestriction applicationdatarestriction) {
		getApplicationdatarestrictions().remove(applicationdatarestriction);
		applicationdatarestriction.setApplication(null);

		return applicationdatarestriction;
	}

	public List<ApplicationInstance> getApplicationinstances() {
		return this.applicationinstances;
	}

	public void setApplicationinstances(
			List<ApplicationInstance> applicationinstances) {
		this.applicationinstances = applicationinstances;
	}

	public ApplicationInstance addApplicationinstance(
			ApplicationInstance applicationinstance) {
		getApplicationinstances().add(applicationinstance);
		applicationinstance.setApplication(this);

		return applicationinstance;
	}

	public ApplicationInstance removeApplicationinstance(
			ApplicationInstance applicationinstance) {
		getApplicationinstances().remove(applicationinstance);
		applicationinstance.setApplication(null);

		return applicationinstance;
	}

	public List<ApplicationOperationalService> getApplicationoperationalservices() {
		return this.applicationoperationalservices;
	}

	public void setApplicationoperationalservices(
			List<ApplicationOperationalService> applicationoperationalservices) {
		this.applicationoperationalservices = applicationoperationalservices;
	}

	public ApplicationOperationalService addApplicationoperationalservice(
			ApplicationOperationalService applicationoperationalservice) {
		getApplicationoperationalservices().add(applicationoperationalservice);
		applicationoperationalservice.setApplication(this);

		return applicationoperationalservice;
	}

	public ApplicationOperationalService removeApplicationoperationalservice(
			ApplicationOperationalService applicationoperationalservice) {
		getApplicationoperationalservices().remove(
				applicationoperationalservice);
		applicationoperationalservice.setApplication(null);

		return applicationoperationalservice;
	}

	public BusinessService getBusinessservice() {
		return this.businessservice;
	}

	public void setBusinessservice(BusinessService businessservice) {
		this.businessservice = businessservice;
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

	public MigrationComplexity getMigrationcomplexity() {
		return this.migrationcomplexity;
	}

	public void setMigrationcomplexity(MigrationComplexity migrationcomplexity) {
		this.migrationcomplexity = migrationcomplexity;
	}

	public BusinessCriticality getBusinessCriticality() {
		return businessCriticality;
	}

	public void setBusinessCriticality(BusinessCriticality businessCriticality) {
		this.businessCriticality = businessCriticality;
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

	public User getBusinessOwner() {
		return businessOwner;
	}

	public void setBusinessOwner(User businessOwner) {
		this.businessOwner = businessOwner;
	}

	public User getTechnicalOwner() {
		return technicalOwner;
	}

	public void setTechnicalOwner(User technicalOwner) {
		this.technicalOwner = technicalOwner;
	}

	public ChangeControlDecision getChangeControlDecision() {
		return changeControlDecision;
	}

	public void setChangeControlDecision(ChangeControlDecision changeControlDecision) {
		this.changeControlDecision = changeControlDecision;
	}

	public String getTargetDisposition() {
		return targetDisposition;
	}

	public void setTargetDisposition(String targetDisposition) {
		this.targetDisposition = targetDisposition;
	}

	public List<ApplicationUserLocation> getApplicationuserlocations() {
		return this.applicationuserlocations;
	}

	public void setApplicationuserlocations(
			List<ApplicationUserLocation> applicationuserlocations) {
		this.applicationuserlocations = applicationuserlocations;
	}

	public ApplicationUserLocation addApplicationuserlocation(
			ApplicationUserLocation applicationuserlocation) {
		getApplicationuserlocations().add(applicationuserlocation);
		applicationuserlocation.setApplication(this);

		return applicationuserlocation;
	}

	public ApplicationUserLocation removeApplicationuserlocation(
			ApplicationUserLocation applicationuserlocation) {
		getApplicationuserlocations().remove(applicationuserlocation);
		applicationuserlocation.setApplication(null);

		return applicationuserlocation;
	}

	public List<ApptoappDependency> getApptoappdependencies1() {
		return this.apptoappdependencies1;
	}

	public void setApptoappdependencies1(
			List<ApptoappDependency> apptoappdependencies1) {
		this.apptoappdependencies1 = apptoappdependencies1;
	}

	public ApptoappDependency addApptoappdependencies1(
			ApptoappDependency apptoappdependencies1) {
		getApptoappdependencies1().add(apptoappdependencies1);
		apptoappdependencies1.setApplication1(this);

		return apptoappdependencies1;
	}

	public ApptoappDependency removeApptoappdependencies1(
			ApptoappDependency apptoappdependencies1) {
		getApptoappdependencies1().remove(apptoappdependencies1);
		apptoappdependencies1.setApplication1(null);

		return apptoappdependencies1;
	}

	public List<ApptoappDependency> getApptoappdependencies2() {
		return this.apptoappdependencies2;
	}

	public void setApptoappdependencies2(
			List<ApptoappDependency> apptoappdependencies2) {
		this.apptoappdependencies2 = apptoappdependencies2;
	}

	public ApptoappDependency addApptoappdependencies2(
			ApptoappDependency apptoappdependencies2) {
		getApptoappdependencies2().add(apptoappdependencies2);
		apptoappdependencies2.setApplication2(this);

		return apptoappdependencies2;
	}

	public ApptoappDependency removeApptoappdependencies2(
			ApptoappDependency apptoappdependencies2) {
		getApptoappdependencies2().remove(apptoappdependencies2);
		apptoappdependencies2.setApplication2(null);

		return apptoappdependencies2;
	}

	public List<GroupApplicationEditRule> getGroupapplicationeditrules() {
		return this.groupapplicationeditrules;
	}

	public void setGroupapplicationeditrules(
			List<GroupApplicationEditRule> groupapplicationeditrules) {
		this.groupapplicationeditrules = groupapplicationeditrules;
	}

	public GroupApplicationEditRule addGroupapplicationeditrule(
			GroupApplicationEditRule groupapplicationeditrule) {
		getGroupapplicationeditrules().add(groupapplicationeditrule);
		groupapplicationeditrule.setApplication(this);

		return groupapplicationeditrule;
	}

	public GroupApplicationEditRule removeGroupapplicationeditrule(
			GroupApplicationEditRule groupapplicationeditrule) {
		getGroupapplicationeditrules().remove(groupapplicationeditrule);
		groupapplicationeditrule.setApplication(null);

		return groupapplicationeditrule;
	}

	public List<SaaSApplication> getSaasapplications() {
		return this.saasapplications;
	}

	public void setSaasapplications(List<SaaSApplication> saasapplications) {
		this.saasapplications = saasapplications;
	}

	public SaaSApplication addSaasapplication(SaaSApplication saasapplication) {
		getSaasapplications().add(saasapplication);
		saasapplication.setApplication(this);

		return saasapplication;
	}

	public SaaSApplication removeSaasapplication(SaaSApplication saasapplication) {
		getSaasapplications().remove(saasapplication);
		saasapplication.setApplication(null);

		return saasapplication;
	}

	/*public List<TaskTracking> getTasktrackings() {
		return this.tasktrackings;
	}

	public void setTasktrackings(List<TaskTracking> tasktrackings) {
		this.tasktrackings = tasktrackings;
	}

	public TaskTracking addTasktracking(TaskTracking tasktracking) {
		getTasktrackings().add(tasktracking);
		tasktracking.setApplication(this);

		return tasktracking;
	}

	public TaskTracking removeTasktracking(TaskTracking tasktracking) {
		getTasktrackings().remove(tasktracking);
		tasktracking.setApplication(null);

		return tasktracking;
	}*/

	public List<UserApplicationEditRule> getUserapplicationeditrules() {
		return this.userapplicationeditrules;
	}

	public void setUserapplicationeditrules(
			List<UserApplicationEditRule> userapplicationeditrules) {
		this.userapplicationeditrules = userapplicationeditrules;
	}

	public UserApplicationEditRule addUserapplicationeditrule(
			UserApplicationEditRule userapplicationeditrule) {
		getUserapplicationeditrules().add(userapplicationeditrule);
		userapplicationeditrule.setApplication(this);

		return userapplicationeditrule;
	}

	public UserApplicationEditRule removeUserapplicationeditrule(
			UserApplicationEditRule userapplicationeditrule) {
		getUserapplicationeditrules().remove(userapplicationeditrule);
		userapplicationeditrule.setApplication(null);

		return userapplicationeditrule;
	}

}