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

import org.springframework.cache.annotation.Cacheable;


/**
 * The persistent class for the slas database table.
 * 
 */
@Entity
@Cacheable("SLAs")
@Table(name="SLAs")
@NamedQuery(name="SLA.findAll", query="SELECT s FROM SLA s")
public class SLA implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int slaid;

	private float availabilityPercent;

	private int RPOMinutes;

	private int RTOMinutes;

	private String sLAName;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy="sla1")
	private List<ApplicationComponentInstance> applicationcomponentinstances1;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy="sla2")
	private List<ApplicationComponentInstance> applicationcomponentinstances2;

	//bi-directional many-to-one association to ApplicationInstance
	@OneToMany(mappedBy="sla1")
	private List<ApplicationInstance> applicationinstances1;

	//bi-directional many-to-one association to ApplicationInstance
	@OneToMany(mappedBy="sla2")
	private List<ApplicationInstance> applicationinstances2;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="sla1")
	private List<Application> applications1;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="sla2")
	private List<Application> applications2;

	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="sla1")
	private List<Server> servers1;

	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="sla2")
	private List<Server> servers2;
	
	//bi-directional many-to-one association to NetworkDevice
	@OneToMany(mappedBy="sla1")
	private List<NetworkDevice> networkDevices1;
	
	//bi-directional many-to-one association to NetworkDevice
	@OneToMany(mappedBy="sla2")
	private List<NetworkDevice> networkDevices2;

	//bi-directional many-to-one association to SLAHistory
	@OneToMany(mappedBy="sla")
	private List<SLAHistory> slaHistories;
		
	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public SLA() {
	}

	public int getSlaid() {
		return slaid;
	}

	public void setSlaid(int slaid) {
		this.slaid = slaid;
	}

	public String getsLAName() {
		return sLAName;
	}

	public void setsLAName(String sLAName) {
		this.sLAName = sLAName;
	}

	public float getAvailabilityPercent() {
		return this.availabilityPercent;
	}

	public void setAvailabilityPercent(float availabilityPercent) {
		this.availabilityPercent = availabilityPercent;
	}

	public int getRPOMinutes() {
		return this.RPOMinutes;
	}

	public void setRPOMinutes(int RPOMinutes) {
		this.RPOMinutes = RPOMinutes;
	}

	public int getRTOMinutes() {
		return this.RTOMinutes;
	}

	public void setRTOMinutes(int RTOMinutes) {
		this.RTOMinutes = RTOMinutes;
	}

	public String getSLAName() {
		return this.sLAName;
	}

	public void setSLAName(String sLAName) {
		this.sLAName = sLAName;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances1() {
		return this.applicationcomponentinstances1;
	}

	public void setApplicationcomponentinstances1(List<ApplicationComponentInstance> applicationcomponentinstances1) {
		this.applicationcomponentinstances1 = applicationcomponentinstances1;
	}

	public ApplicationComponentInstance addApplicationcomponentinstances1(ApplicationComponentInstance applicationcomponentinstances1) {
		getApplicationcomponentinstances1().add(applicationcomponentinstances1);
		applicationcomponentinstances1.setSla1(this);

		return applicationcomponentinstances1;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstances1(ApplicationComponentInstance applicationcomponentinstances1) {
		getApplicationcomponentinstances1().remove(applicationcomponentinstances1);
		applicationcomponentinstances1.setSla1(null);

		return applicationcomponentinstances1;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances2() {
		return this.applicationcomponentinstances2;
	}

	public void setApplicationcomponentinstances2(List<ApplicationComponentInstance> applicationcomponentinstances2) {
		this.applicationcomponentinstances2 = applicationcomponentinstances2;
	}

	public ApplicationComponentInstance addApplicationcomponentinstances2(ApplicationComponentInstance applicationcomponentinstances2) {
		getApplicationcomponentinstances2().add(applicationcomponentinstances2);
		applicationcomponentinstances2.setSla2(this);

		return applicationcomponentinstances2;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstances2(ApplicationComponentInstance applicationcomponentinstances2) {
		getApplicationcomponentinstances2().remove(applicationcomponentinstances2);
		applicationcomponentinstances2.setSla2(null);

		return applicationcomponentinstances2;
	}

	public List<ApplicationInstance> getApplicationinstances1() {
		return this.applicationinstances1;
	}

	public void setApplicationinstances1(List<ApplicationInstance> applicationinstances1) {
		this.applicationinstances1 = applicationinstances1;
	}

	public ApplicationInstance addApplicationinstances1(ApplicationInstance applicationinstances1) {
		getApplicationinstances1().add(applicationinstances1);
		applicationinstances1.setSla1(this);

		return applicationinstances1;
	}

	public ApplicationInstance removeApplicationinstances1(ApplicationInstance applicationinstances1) {
		getApplicationinstances1().remove(applicationinstances1);
		applicationinstances1.setSla1(null);

		return applicationinstances1;
	}

	public List<ApplicationInstance> getApplicationinstances2() {
		return this.applicationinstances2;
	}

	public void setApplicationinstances2(List<ApplicationInstance> applicationinstances2) {
		this.applicationinstances2 = applicationinstances2;
	}

	public ApplicationInstance addApplicationinstances2(ApplicationInstance applicationinstances2) {
		getApplicationinstances2().add(applicationinstances2);
		applicationinstances2.setSla2(this);

		return applicationinstances2;
	}

	public ApplicationInstance removeApplicationinstances2(ApplicationInstance applicationinstances2) {
		getApplicationinstances2().remove(applicationinstances2);
		applicationinstances2.setSla2(null);

		return applicationinstances2;
	}

	public List<Application> getApplications1() {
		return this.applications1;
	}

	public void setApplications1(List<Application> applications1) {
		this.applications1 = applications1;
	}

	public Application addApplications1(Application applications1) {
		getApplications1().add(applications1);
		applications1.setSla1(this);

		return applications1;
	}

	public Application removeApplications1(Application applications1) {
		getApplications1().remove(applications1);
		applications1.setSla1(null);

		return applications1;
	}

	public List<Application> getApplications2() {
		return this.applications2;
	}

	public void setApplications2(List<Application> applications2) {
		this.applications2 = applications2;
	}

	public Application addApplications2(Application applications2) {
		getApplications2().add(applications2);
		applications2.setSla2(this);

		return applications2;
	}

	public Application removeApplications2(Application applications2) {
		getApplications2().remove(applications2);
		applications2.setSla2(null);

		return applications2;
	}

	public List<Server> getServers1() {
		return this.servers1;
	}

	public void setServers1(List<Server> servers1) {
		this.servers1 = servers1;
	}

	public Server addServers1(Server servers1) {
		getServers1().add(servers1);
		servers1.setSla1(this);

		return servers1;
	}

	public Server removeServers1(Server servers1) {
		getServers1().remove(servers1);
		servers1.setSla1(null);

		return servers1;
	}

	public List<Server> getServers2() {
		return this.servers2;
	}

	public void setServers2(List<Server> servers2) {
		this.servers2 = servers2;
	}

	public Server addServers2(Server servers2) {
		getServers2().add(servers2);
		servers2.setSla2(this);

		return servers2;
	}

	public Server removeServers2(Server servers2) {
		getServers2().remove(servers2);
		servers2.setSla2(null);

		return servers2;
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