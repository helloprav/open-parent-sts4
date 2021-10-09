package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;


/**
 * The persistent class for the assetmigrationscope database table.
 * 
 */
@Entity
@NamedQuery(name="AssetMigrationScope.findAll", query="SELECT a FROM AssetMigrationScope a")
public class AssetMigrationScope implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetMigrationScopeId;

	private int assetID;

	private String assetType;

	private byte migrationScopeSignOffFlag;
	
	@OneToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "migrationScopeId")
	private MigrationScope migrationScope;

	public AssetMigrationScope() {
	}

	public int getAssetMigrationScopeId() {
		return this.assetMigrationScopeId;
	}

	public void setAssetMigrationScopeId(int assetMigrationScopeId) {
		this.assetMigrationScopeId = assetMigrationScopeId;
	}

	public int getAssetID() {
		return this.assetID;
	}

	public void setAssetID(int assetID) {
		this.assetID = assetID;
	}

	public String getAssetType() {
		return this.assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}	

	public MigrationScope getMigrationScope() {
		return migrationScope;
	}

	public void setMigrationScope(MigrationScope migrationScope) {
		this.migrationScope = migrationScope;
	}

	public byte getMigrationScopeSignOffFlag() {
		return this.migrationScopeSignOffFlag;
	}

	public void setMigrationScopeSignOffFlag(byte migrationScopeSignOffFlag) {
		this.migrationScopeSignOffFlag = migrationScopeSignOffFlag;
	}

}