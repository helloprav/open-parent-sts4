package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the assettypes database table.
 */
@Entity
@Table(name="AssetTypeHistory")
@NamedQuery(name="AssetTypeHistory.findAll", query="SELECT ah FROM AssetTypeHistory ah")
public class AssetTypeHistory implements Serializable {
	
	private static final long serialVersionUID = -5580843127958373129L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetTypeHistoryID;
	private int versionNumber;
	
	@ManyToOne
	@JoinColumn(name="assetTypeID")
	private AssetType asset ;
	
	private String assetType;
	private String assetTypeName;
	private String assetTemplateFileName;
	private String questionnaireFileName;
	
	//bi-directional many-to-one association to AssetRole
	@OneToMany(mappedBy="assettype")
	private List<AssetRole> assetroles;
	
	//bi-directional many-to-one association to AssetTypeConsistencyCheck
	@OneToMany(mappedBy="assettype")
	private List<AssetTypeConsistencyCheck> assettypeconsistencychecks;

	//bi-directional many-to-one association to TemplateUpload
	@OneToMany(mappedBy="assettype")
	private List<TemplateUpload> templateuploads;

	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public AssetTypeHistory() {
	}

	public int getAssetTypeHistoryID() {
		return assetTypeHistoryID;
	}

	public void setAssetTypeHistoryID(int assetTypeHistoryID) {
		this.assetTypeHistoryID = assetTypeHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public AssetType getAsset() {
		return asset;
	}

	public void setAsset(AssetType asset) {
		this.asset = asset;
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public String getAssetTypeName() {
		return assetTypeName;
	}

	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
	}

	public String getAssetTemplateFileName() {
		return assetTemplateFileName;
	}

	public void setAssetTemplateFileName(String assetTemplateFileName) {
		this.assetTemplateFileName = assetTemplateFileName;
	}

	public String getQuestionnaireFileName() {
		return questionnaireFileName;
	}

	public void setQuestionnaireFileName(String questionnaireFileName) {
		this.questionnaireFileName = questionnaireFileName;
	}

	public List<AssetRole> getAssetroles() {
		return assetroles;
	}

	public void setAssetroles(List<AssetRole> assetroles) {
		this.assetroles = assetroles;
	}

	public List<AssetTypeConsistencyCheck> getAssettypeconsistencychecks() {
		return assettypeconsistencychecks;
	}

	public void setAssettypeconsistencychecks(
			List<AssetTypeConsistencyCheck> assettypeconsistencychecks) {
		this.assettypeconsistencychecks = assettypeconsistencychecks;
	}

	public List<TemplateUpload> getTemplateuploads() {
		return templateuploads;
	}

	public void setTemplateuploads(List<TemplateUpload> templateuploads) {
		this.templateuploads = templateuploads;
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
