package com.ericsson.etme.commons.model;

import java.io.Serializable;
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
 * The persistent class for the movegroups database table.
 * 
 */
@Entity
@Table(name = "MoveGroups")
@NamedQuery(name = "MoveGroup.findAll", query = "SELECT m FROM MoveGroup m")
public class MoveGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int moveGroupID;

	private String moveGroupName;

	// bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy = "movegroup")
	private List<ApplicationComponentInstance> applicationcomponentinstances;

	// bi-directional many-to-one association to ApplicationComponent
	@OneToMany(mappedBy = "movegroup")
	private List<ApplicationComponent> applicationcomponents;

	// bi-directional many-to-one association to ApplicationInstance
	@OneToMany(mappedBy = "movegroup")
	private List<ApplicationInstance> applicationinstances;

	// bi-directional many-to-one association to Application
	@OneToMany(mappedBy = "movegroup")
	private List<Application> applications;

	// bi-directional many-to-one association to MigrationSlot
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MigrationSlotID")
	private MigrationSlot migrationslot;

	// bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "MoveGroupOwnerID")
	private User user;

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "movegroup")
	private List<PhysicalServer> physicalservers;

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "movegroup")
	private List<Server> servers;

	// bi-directional many-to-one association to Task
	@OneToMany(mappedBy = "movegroup")
	private List<Task> tasktrackings;

	public MoveGroup() {
	}

	public int getMoveGroupID() {
		return this.moveGroupID;
	}

	public void setMoveGroupID(int moveGroupID) {
		this.moveGroupID = moveGroupID;
	}

	public String getMoveGroupName() {
		return this.moveGroupName;
	}

	public void setMoveGroupName(String moveGroupName) {
		this.moveGroupName = moveGroupName;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances() {
		return this.applicationcomponentinstances;
	}

	public void setApplicationcomponentinstances(
			List<ApplicationComponentInstance> applicationcomponentinstances) {
		this.applicationcomponentinstances = applicationcomponentinstances;
	}

	public ApplicationComponentInstance addApplicationcomponentinstance(
			ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().add(applicationcomponentinstance);
		applicationcomponentinstance.setMovegroup(this);

		return applicationcomponentinstance;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstance(
			ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().remove(applicationcomponentinstance);
		applicationcomponentinstance.setMovegroup(null);

		return applicationcomponentinstance;
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
		applicationcomponent.setMovegroup(this);

		return applicationcomponent;
	}

	public ApplicationComponent removeApplicationcomponent(
			ApplicationComponent applicationcomponent) {
		getApplicationcomponents().remove(applicationcomponent);
		applicationcomponent.setMovegroup(null);

		return applicationcomponent;
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
		applicationinstance.setMovegroup(this);

		return applicationinstance;
	}

	public ApplicationInstance removeApplicationinstance(
			ApplicationInstance applicationinstance) {
		getApplicationinstances().remove(applicationinstance);
		applicationinstance.setMovegroup(null);

		return applicationinstance;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setMovegroup(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setMovegroup(null);

		return application;
	}

	public MigrationSlot getMigrationslot() {
		return this.migrationslot;
	}

	public void setMigrationslot(MigrationSlot migrationslot) {
		this.migrationslot = migrationslot;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PhysicalServer> getPhysicalservers() {
		return this.physicalservers;
	}

	public void setPhysicalservers(List<PhysicalServer> physicalservers) {
		this.physicalservers = physicalservers;
	}

	public PhysicalServer addPhysicalserver(PhysicalServer physicalserver) {
		getPhysicalservers().add(physicalserver);
		physicalserver.setMovegroup(this);

		return physicalserver;
	}

	public PhysicalServer removePhysicalserver(PhysicalServer physicalserver) {
		getPhysicalservers().remove(physicalserver);
		physicalserver.setMovegroup(null);

		return physicalserver;
	}

	public List<Server> getServers() {
		return this.servers;
	}

	public void setServers(List<Server> servers) {
		this.servers = servers;
	}

	public Server addServer(Server server) {
		getServers().add(server);
		server.setMovegroup(this);

		return server;
	}

	public Server removeServer(Server server) {
		getServers().remove(server);
		server.setMovegroup(null);

		return server;
	}

	public List<Task> getTasktrackings() {
		return tasktrackings;
	}

	public void setTasktrackings(List<Task> tasktrackings) {
		this.tasktrackings = tasktrackings;
	}

	public Task addTask(Task tasktrackings) {
		getTasktrackings().add(tasktrackings);
		tasktrackings.setMovegroup(this);

		return tasktrackings;
	}

	public Task removeTask(Task tasktrackings) {
		getTasktrackings().remove(tasktrackings);
		tasktrackings.setMovegroup(null);

		return tasktrackings;
	}
}