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
@Table(name="BusinessCriticality")
@NamedQuery(name="BusinessCriticality.findAll", query="SELECT m FROM BusinessCriticality m")
public class BusinessCriticality implements Serializable {

	private static final long serialVersionUID = -8157814396794684633L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int businessCriticalityID;
	
	private String businessCriticalityName;
	
	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="businessCriticality")
	private List<Application> applications;

	public int getBusinessCriticalityID() {
		return businessCriticalityID;
	}

	public void setBusinessCriticalityID(int businessCriticalityID) {
		this.businessCriticalityID = businessCriticalityID;
	}

	public String getBusinessCriticalityName() {
		return businessCriticalityName;
	}

	public void setBusinessCriticalityName(String businessCriticalityName) {
		this.businessCriticalityName = businessCriticalityName;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
	
}
