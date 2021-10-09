package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import org.springframework.cache.annotation.Cacheable;

/**
 * The persistent class for the dispositions database table.
 * 
 */
@Entity
@Cacheable("Dispositions")
@Table(name = "Dispositions")
@NamedQuery(name = "Disposition.findAll", query = "SELECT d FROM Disposition d")
public class Disposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dispositionID;

	private String dispositionName;
	
	private String description;

	// bi-directional many-to-one association to ApplicationInstance
	@OneToMany(mappedBy = "disposition1", cascade = { CascadeType.ALL })
	private List<ApplicationInstance> applicationinstances1;

	/*// bi-directional many-to-one association to ApplicationInstance
	@OneToMany(mappedBy = "disposition2", cascade = { CascadeType.ALL })
	private List<ApplicationInstance> applicationinstances2;*/

	// bi-directional many-to-one association to Application
	@OneToMany(mappedBy = "disposition1")
	private List<Application> applications1;

	/*// bi-directional many-to-one association to Application
	@OneToMany(mappedBy = "disposition2")
	private List<Application> applications2;*/

	// bi-directional many-to-one association to NetworkDevice
	@OneToMany(mappedBy = "disposition1", cascade = { CascadeType.ALL })
	private List<NetworkDevice> networkdevices1;

	/*// bi-directional many-to-one association to NetworkDevice
	@OneToMany(mappedBy = "disposition2", cascade = { CascadeType.ALL })
	private List<NetworkDevice> networkdevices2;*/

	// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "disposition1",cascade = { CascadeType.ALL })
	private List<PhysicalServer> physicalservers1;

	/*// bi-directional many-to-one association to PhysicalServer
	@OneToMany(mappedBy = "disposition2",cascade = { CascadeType.ALL })
	private List<PhysicalServer> physicalservers2;*/

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "disposition1")
	private List<Server> servers1;

	/*// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "disposition2")
	private List<Server> servers2;*/

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "disposition1")
	private List<ApplicationComponent> applicationComponent1;

	/*// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "disposition2")
	private List<ApplicationComponent> applicationComponent2;*/

	// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "disposition1")
	private List<ApplicationComponentInstance> applicationComponentInstance1;

	/*// bi-directional many-to-one association to Server
	@OneToMany(mappedBy = "disposition2")
	private List<ApplicationComponentInstance> applicationComponentInstance2;*/
	
	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public Disposition() {
	}

	public int getDispositionID() {
		return this.dispositionID;
	}

	public void setDispositionID(int dispositionID) {
		this.dispositionID = dispositionID;
	}

	public String getDispositionName() {
		return this.dispositionName;
	}

	public void setDispositionName(String dispositionName) {
		this.dispositionName = dispositionName;
	}

	public List<ApplicationInstance> getApplicationinstances1() {
		return this.applicationinstances1;
	}

	public void setApplicationinstances1(List<ApplicationInstance> applicationinstances1) {
		this.applicationinstances1 = applicationinstances1;
	}

	public ApplicationInstance addApplicationinstances1(ApplicationInstance applicationinstances1) {
		getApplicationinstances1().add(applicationinstances1);
		applicationinstances1.setDisposition1(this);

		return applicationinstances1;
	}

	public ApplicationInstance removeApplicationinstances1(ApplicationInstance applicationinstances1) {
		getApplicationinstances1().remove(applicationinstances1);
		applicationinstances1.setDisposition1(null);

		return applicationinstances1;
	}

	public List<Application> getApplications1() {
		return this.applications1;
	}

	public void setApplications1(List<Application> applications1) {
		this.applications1 = applications1;
	}

	public Application addApplications1(Application applications1) {
		getApplications1().add(applications1);
		applications1.setDisposition1(this);

		return applications1;
	}

	public Application removeApplications1(Application applications1) {
		getApplications1().remove(applications1);
		applications1.setDisposition1(null);

		return applications1;
	}

	public List<NetworkDevice> getNetworkdevices1() {
		return this.networkdevices1;
	}

	public void setNetworkdevices1(List<NetworkDevice> networkdevices1) {
		this.networkdevices1 = networkdevices1;
	}

	public NetworkDevice addNetworkdevices1(NetworkDevice networkdevices1) {
		getNetworkdevices1().add(networkdevices1);
		networkdevices1.setDisposition1(this);

		return networkdevices1;
	}

	public NetworkDevice removeNetworkdevices1(NetworkDevice networkdevices1) {
		getNetworkdevices1().remove(networkdevices1);
		networkdevices1.setDisposition1(null);

		return networkdevices1;
	}

	public List<PhysicalServer> getPhysicalservers1() {
		return this.physicalservers1;
	}

	public void setPhysicalservers1(List<PhysicalServer> physicalservers1) {
		this.physicalservers1 = physicalservers1;
	}

	public PhysicalServer addPhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().add(physicalservers1);
		physicalservers1.setDisposition1(this);

		return physicalservers1;
	}

	public PhysicalServer removePhysicalservers1(PhysicalServer physicalservers1) {
		getPhysicalservers1().remove(physicalservers1);
		physicalservers1.setDisposition1(null);

		return physicalservers1;
	}

	public List<Server> getServers1() {
		return this.servers1;
	}

	public void setServers1(List<Server> servers1) {
		this.servers1 = servers1;
	}

	public Server addServers1(Server servers1) {
		getServers1().add(servers1);
		servers1.setDisposition1(this);

		return servers1;
	}

	public Server removeServers1(Server servers1) {
		getServers1().remove(servers1);
		servers1.setDisposition1(null);

		return servers1;
	}

	public List<ApplicationComponent> getApplicationComponent1() {
		return this.applicationComponent1;
	}

	public void setApplicationComponent1(List<ApplicationComponent> applicationComponent1) {
		this.applicationComponent1 = applicationComponent1;
	}

	public ApplicationComponent addApplicationComponent1(ApplicationComponent applicationComponent1) {
		getApplicationComponent1().add(applicationComponent1);
		applicationComponent1.setDisposition1(this);

		return applicationComponent1;
	}

	public ApplicationComponent removeServers1ApplicationComponent1(ApplicationComponent applicationComponent1) {
		getServers1().remove(applicationComponent1);
		applicationComponent1.setDisposition1(null);

		return applicationComponent1;
	}

	public List<ApplicationComponentInstance> getApplicationComponentInstance1() {
		return applicationComponentInstance1;
	}

	public void setApplicationComponentInstance1(List<ApplicationComponentInstance> applicationComponentInstance1) {
		this.applicationComponentInstance1 = applicationComponentInstance1;
	}

	public ApplicationComponentInstance addApplicationComponentInstance1(
			ApplicationComponentInstance applicationComponentInstance1) {
		getApplicationComponentInstance1().add(applicationComponentInstance1);
		applicationComponentInstance1.setDisposition1(this);

		return applicationComponentInstance1;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
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