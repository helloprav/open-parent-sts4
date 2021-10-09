package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the environments database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="Environments")
@NamedQuery(name="Environment.findAll", query="SELECT e FROM Environment e")
public class Environment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int environmentID;

	private String environmentName;
	
	private String description;

	//bi-directional many-to-one association to ApplicationComponentInstance
	@OneToMany(mappedBy="environment")
	private List<ApplicationComponentInstance> applicationcomponentinstances;
    
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public Environment() {
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

	public int getEnvironmentID() {
		return this.environmentID;
	}

	public void setEnvironmentID(int environmentID) {
		this.environmentID = environmentID;
	}

	public String getEnvironmentName() {
		return this.environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	public List<ApplicationComponentInstance> getApplicationcomponentinstances() {
		return this.applicationcomponentinstances;
	}

	public void setApplicationcomponentinstances(List<ApplicationComponentInstance> applicationcomponentinstances) {
		this.applicationcomponentinstances = applicationcomponentinstances;
	}

	public ApplicationComponentInstance addApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().add(applicationcomponentinstance);
		applicationcomponentinstance.setEnvironment(this);

		return applicationcomponentinstance;
	}

	public ApplicationComponentInstance removeApplicationcomponentinstance(ApplicationComponentInstance applicationcomponentinstance) {
		getApplicationcomponentinstances().remove(applicationcomponentinstance);
		applicationcomponentinstance.setEnvironment(null);

		return applicationcomponentinstance;
	}

	public String getDescription() {
	    return description;
	}

	public void setDescription(String description) {
	    this.description = description;
	}

}