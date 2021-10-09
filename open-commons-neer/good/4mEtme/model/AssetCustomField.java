package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
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
 * The persistent class for the AssetCustomFields database table.
 */
@Entity
@Cacheable(true)
@Table(name="AssetCustomFields")
@NamedQuery(name="AssetCustomField.findAll", query="SELECT a FROM AssetCustomField a")
public class AssetCustomField implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetCustomFieldID;
	private String assetTableName;
	private String enableCustomField;
	private String customFieldName1;
	private String customFieldName2;
	private String customFieldName3;
	
	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	//bi-directional many-to-one association to AssetCustomFieldHistory
	@OneToMany(mappedBy="assetCustomField")
	private List<AssetCustomFieldHistory> assetCustomFieldHistories;

	public AssetCustomField() {
		super();
	}

	public int getAssetCustomFieldID() {
		return assetCustomFieldID;
	}

	public void setAssetCustomFieldID(int assetCustomFieldID) {
		this.assetCustomFieldID = assetCustomFieldID;
	}

	public String getAssetTableName() {
		return assetTableName;
	}

	public void setAssetTableName(String assetTableName) {
		this.assetTableName = assetTableName;
	}

	public String getEnableCustomField() {
		return enableCustomField;
	}

	public void setEnableCustomField(String enableCustomField) {
		this.enableCustomField = enableCustomField;
	}

	public String getCustomFieldName1() {
		return customFieldName1;
	}

	public void setCustomFieldName1(String customFieldName1) {
		this.customFieldName1 = customFieldName1;
	}

	public String getCustomFieldName2() {
		return customFieldName2;
	}

	public void setCustomFieldName2(String customFieldName2) {
		this.customFieldName2 = customFieldName2;
	}

	public String getCustomFieldName3() {
		return customFieldName3;
	}

	public void setCustomFieldName3(String customFieldName3) {
		this.customFieldName3 = customFieldName3;
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