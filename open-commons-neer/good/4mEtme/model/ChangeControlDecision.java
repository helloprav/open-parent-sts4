package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Cacheable(true)
@Table(name = "ChangeControlDecisions")
@NamedQuery(name = "ChangeControlDecision.findAll", query = "SELECT c FROM ChangeControlDecision c")
public class ChangeControlDecision implements Serializable{

	private static final long serialVersionUID = -3306307722661311925L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int changeControlDecisionID;
	
	private String changeControlDecisionName;
	
	// bi-directional many-to-one association to VmFarm
	@OneToMany(mappedBy = "changeControlDecision")
	private List<Application> applications;
	
	// bi-directional many-to-one association to VmFarm
	@OneToMany(mappedBy = "changeControlDecision")
	private List<ApplicationComponentInstance> applicationComponentInstances;
	
	// bi-directional many-to-one association to VmFarm
	@OneToMany(mappedBy = "changeControlDecision")
	private List<Server> servers;

	public int getChangeControlDecisionID() {
		return changeControlDecisionID;
	}

	public void setChangeControlDecisionID(int changeControlDecisionID) {
		this.changeControlDecisionID = changeControlDecisionID;
	}

	public String getChangeControlDecisionName() {
		return changeControlDecisionName;
	}

	public void setChangeControlDecisionName(String changeControlDecisionName) {
		this.changeControlDecisionName = changeControlDecisionName;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
}
