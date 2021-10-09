package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
 * The persistent class for the DiscoveryState database table.
 */
@Entity
@Table(name="OperatingSystems")
@NamedQuery(name="OperatingSystem.findAll", query="SELECT o FROM OperatingSystem o")
public class OperatingSystem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int operatingSystemID;
	private String operatingSystemName;
	
	//bi-directional many-to-one association to Server
	@OneToMany(mappedBy="operatingSystem")
	private List<OperatingSystemVersion> operatingSystemVersions;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public OperatingSystem() {
	}

	public int getOperatingSystemID() {
		return operatingSystemID;
	}

	public void setOperatingSystemID(int operatingSystemID) {
		this.operatingSystemID = operatingSystemID;
	}

	public String getOperatingSystemName() {
		return operatingSystemName;
	}

	public void setOperatingSystemName(String operatingSystemName) {
		this.operatingSystemName = operatingSystemName;
	}

	public List<OperatingSystemVersion> getOperatingSystemVersions() {
		return operatingSystemVersions;
	}

	public void setOperatingSystemVersions(List<OperatingSystemVersion> operatingSystemVersions) {
		this.operatingSystemVersions = operatingSystemVersions;
	}

	public TemplateUpload getTemplateUpload() {
		return templateUpload;
	}

	public void setTemplateUpload(TemplateUpload templateUpload) {
		this.templateUpload = templateUpload;
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

	public OperatingSystemVersion addOperatingSystemVersion(OperatingSystemVersion operatingSystemVersion) {
		getOperatingSystemVersions().add(operatingSystemVersion);
		operatingSystemVersion.setOperatingSystem(this);

		return operatingSystemVersion;
	}

	public OperatingSystemVersion removeOperatingSystemVersion(OperatingSystemVersion operatingSystemVersion) {
		getOperatingSystemVersions().remove(operatingSystemVersion);
		operatingSystemVersion.setOperatingSystem(null);

		return operatingSystemVersion;
	}
}