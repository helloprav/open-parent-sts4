package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.cache.annotation.Cacheable;


/**
 * The persistent class for the migrationscopes database table.
 * 
 */
@Entity
@Cacheable("migrationScope")
@Table(name="MigrationScopes")
@NamedQuery(name="MigrationScope.findAll", query="SELECT m FROM MigrationScope m")
public class MigrationScope implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int migrationScopeID;

	private String description;

	private Timestamp lastUpdatedDate;

	private String migrationScopeName;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;
	
	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public MigrationScope() {
	}

	public int getMigrationScopeID() {
		return this.migrationScopeID;
	}

	public void setMigrationScopeID(int migrationScopeID) {
		this.migrationScopeID = migrationScopeID;
	}

	

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastUpdatedDate() {
		return this.lastUpdatedDate;
	}

	public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getMigrationScopeName() {
		return this.migrationScopeName;
	}

	public void setMigrationScopeName(String migrationScopeName) {
		this.migrationScopeName = migrationScopeName;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public User getLastUpdatedByUser() {
		return lastUpdatedByUser;
	}

	public void setLastUpdatedByUser(User lastUpdatedByUser) {
		this.lastUpdatedByUser = lastUpdatedByUser;
	}

	



}