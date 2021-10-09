package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the migrationcomplexities database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="MigrationComplexities")
@NamedQuery(name="MigrationComplexity.findAll", query="SELECT m FROM MigrationComplexity m")
public class MigrationComplexity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int migrationComplexityID;

	private String description;

	private String migrationComplexityName;

	//bi-directional many-to-one association to Application
	@OneToMany(mappedBy="migrationcomplexity")
	private List<Application> applications;

	public MigrationComplexity() {
	}

	public int getMigrationComplexityID() {
		return this.migrationComplexityID;
	}

	public void setMigrationComplexityID(int migrationComplexityID) {
		this.migrationComplexityID = migrationComplexityID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMigrationComplexityName() {
		return this.migrationComplexityName;
	}

	public void setMigrationComplexityName(String migrationComplexityName) {
		this.migrationComplexityName = migrationComplexityName;
	}

	public List<Application> getApplications() {
		return this.applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public Application addApplication(Application application) {
		getApplications().add(application);
		application.setMigrationcomplexity(this);

		return application;
	}

	public Application removeApplication(Application application) {
		getApplications().remove(application);
		application.setMigrationcomplexity(null);

		return application;
	}

}