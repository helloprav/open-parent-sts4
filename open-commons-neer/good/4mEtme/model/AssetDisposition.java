package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the assetdispositions database table.
 * 
 */
@Entity
@Table(name = "AssetDispositions")
@NamedQuery(name = "AssetDisposition.findAll", query = "SELECT a FROM AssetDisposition a")
public class AssetDisposition implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assetDispositionsId;

	private int assetId;

	private String assetType;

	private byte decidedDispositionFlag;

	private int dispositionId;

	private String dispositionName;

	private String riskScore;

	private String complexity;

	// bi-directional many-to-one association to Dispositionmethod
	@OneToMany(cascade = {CascadeType.ALL} , mappedBy = "assetdisposition", fetch = FetchType.EAGER, orphanRemoval = true)
	private List<DispositionMethod> dispositionMethods;

	public AssetDisposition() {
	}

	public int getAssetDispositionsId() {
		return this.assetDispositionsId;
	}

	public void setAssetDispositionsId(int assetDispositionsId) {
		this.assetDispositionsId = assetDispositionsId;
	}

	public int getAssetId() {
		return this.assetId;
	}

	public void setAssetId(int assetId) {
		this.assetId = assetId;
	}

	public String getAssetType() {
		return this.assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public byte getDecidedDispositionFlag() {
		return this.decidedDispositionFlag;
	}

	public void setDecidedDispositionFlag(byte decidedDispositionFlag) {
		this.decidedDispositionFlag = decidedDispositionFlag;
	}

	public int getDispositionId() {
		return this.dispositionId;
	}

	public void setDispositionId(int dispositionId) {
		this.dispositionId = dispositionId;
	}

	public String getDispositionName() {
		return this.dispositionName;
	}

	public void setDispositionName(String dispositionName) {
		this.dispositionName = dispositionName;
	}

	public String getRiskScore() {
		return riskScore;
	}

	public void setRiskScore(String riskScore) {
		this.riskScore = riskScore;
	}

	public String getComplexity() {
		return complexity;
	}

	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}

	public List<DispositionMethod> getDispositionMethods() {
		return this.dispositionMethods;
	}

	public void setDispositionMethods(List<DispositionMethod> dispositionMethods) {
		this.dispositionMethods = dispositionMethods;
	}

	public DispositionMethod addDispositionmethod(
			DispositionMethod dispositionMethod) {
		if (dispositionMethod != null) {
			if (dispositionMethods == null) {
				dispositionMethods = new ArrayList<DispositionMethod>();
			}
			dispositionMethods.add(dispositionMethod);
			dispositionMethod.setAssetDisposition(this);
		}
		return dispositionMethod;
	}

	public DispositionMethod removeDispositionmethod(
			DispositionMethod dispositionMethod) {
		if (dispositionMethods != null) {
			dispositionMethod.setAssetDisposition(this);
			dispositionMethods.remove(dispositionMethod);
		

		}

		return dispositionMethod;
	}
	
	public boolean removeAllDispositionmethod() {
	
			dispositionMethods.removeAll(getDispositionMethods());
		return true;
	}

}