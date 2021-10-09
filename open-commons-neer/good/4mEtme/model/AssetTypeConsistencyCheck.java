package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the assettypeconsistencychecks database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name = "AssetTypeConsistencyChecks")
@NamedQuery(name = "AssetTypeConsistencyCheck.findAll", query = "SELECT a FROM AssetTypeConsistencyCheck a")
public class AssetTypeConsistencyCheck implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int assetTypeConsistencyCheckID;

    private String consistencyCheckSP;

    private String consistencyCheckName;

    private String consistencyCheckgMsg;

    // bi-directional many-to-one association to AssetType
    @ManyToOne
    @JoinColumn(name = "AsssetTypeID")
    private AssetType assettype;

    public AssetTypeConsistencyCheck() {
    }

    public int getAssetTypeConsistencyCheckID() {
	return this.assetTypeConsistencyCheckID;
    }

    public void setAssetTypeConsistencyCheckID(int assetTypeConsistencyCheckID) {
	this.assetTypeConsistencyCheckID = assetTypeConsistencyCheckID;
    }

    public String getConsistencyCheckSP() {
	return this.consistencyCheckSP;
    }

    public void setConsistencyCheckSP(String consistencyCheckSP) {
	this.consistencyCheckSP = consistencyCheckSP;
    }

    public AssetType getAssettype() {
	return this.assettype;
    }

    public void setAssettype(AssetType assettype) {
	this.assettype = assettype;
    }

    public String getConsistencyCheckName() {
	return consistencyCheckName;
    }

    public void setConsistencyCheckName(String consistencyCheckName) {
	this.consistencyCheckName = consistencyCheckName;
    }

    public String getConsistencyCheckgMsg() {
	return consistencyCheckgMsg;
    }

    public void setConsistencyCheckgMsg(String consistencyCheckgMsg) {
	this.consistencyCheckgMsg = consistencyCheckgMsg;
    }

}