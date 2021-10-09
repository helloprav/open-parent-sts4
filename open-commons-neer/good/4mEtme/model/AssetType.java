package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Cacheable(true)
@Table(name="AssetTypes")
@NamedQuery(name="AssetType.findAll", query="SELECT a FROM AssetType a")
public class AssetType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetTypeID;
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

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public AssetType() {
	}

	public String getAssetType() {
		return assetType;
	}

	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}

	public int getAssetTypeID() {
		return this.assetTypeID;
	}

	public void setAssetTypeID(int assetTypeID) {
		this.assetTypeID = assetTypeID;
	}

	public String getAssetTypeName() {
		return this.assetTypeName;
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
		return this.assetroles;
	}

	public void setAssetroles(List<AssetRole> assetroles) {
		this.assetroles = assetroles;
	}

	public AssetRole addAssetrole(AssetRole assetrole) {
		getAssetroles().add(assetrole);
		assetrole.setAssettype(this);

		return assetrole;
	}

	public AssetRole removeAssetrole(AssetRole assetrole) {
		getAssetroles().remove(assetrole);
		assetrole.setAssettype(null);

		return assetrole;
	}

	public List<AssetTypeConsistencyCheck> getAssettypeconsistencychecks() {
		return this.assettypeconsistencychecks;
	}

	public void setAssettypeconsistencychecks(List<AssetTypeConsistencyCheck> assettypeconsistencychecks) {
		this.assettypeconsistencychecks = assettypeconsistencychecks;
	}

	public AssetTypeConsistencyCheck addAssettypeconsistencycheck(AssetTypeConsistencyCheck assettypeconsistencycheck) {
		getAssettypeconsistencychecks().add(assettypeconsistencycheck);
		assettypeconsistencycheck.setAssettype(this);

		return assettypeconsistencycheck;
	}

	public AssetTypeConsistencyCheck removeAssettypeconsistencycheck(AssetTypeConsistencyCheck assettypeconsistencycheck) {
		getAssettypeconsistencychecks().remove(assettypeconsistencycheck);
		assettypeconsistencycheck.setAssettype(null);

		return assettypeconsistencycheck;
	}

	public List<TemplateUpload> getTemplateuploads() {
		return this.templateuploads;
	}

	public void setTemplateuploads(List<TemplateUpload> templateuploads) {
		this.templateuploads = templateuploads;
	}

	public TemplateUpload addTemplateupload(TemplateUpload templateupload) {
		getTemplateuploads().add(templateupload);
		templateupload.setAssettype(this);

		return templateupload;
	}

	public TemplateUpload removeTemplateupload(TemplateUpload templateupload) {
		getTemplateuploads().remove(templateupload);
		templateupload.setAssettype(null);

		return templateupload;
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