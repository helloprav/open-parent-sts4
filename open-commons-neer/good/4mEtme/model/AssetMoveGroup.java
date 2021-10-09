package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the assetmovegroup database table.
 * 
 */
@Entity
@NamedQuery(name="AssetMoveGroup.findAll", query="SELECT a FROM AssetMoveGroup a")
public class AssetMoveGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetMoveGroupId;

	private int assetID;

	private String assetType;

	@OneToOne(cascade = { CascadeType.REFRESH })
	@JoinColumn(name = "moveGroupId")
	private MoveGroup moveGroup;
	
	public AssetMoveGroup() {
	}

	public int getAssetMoveGroupId() {
		return this.assetMoveGroupId;
	}

	public void setAssetMoveGroupId(int assetMoveGroupId) {
		this.assetMoveGroupId = assetMoveGroupId;
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

	public MoveGroup getMoveGroup() {
		return moveGroup;
	}

	public void setMoveGroup(MoveGroup moveGroup) {
		this.moveGroup = moveGroup;
	}
	
}