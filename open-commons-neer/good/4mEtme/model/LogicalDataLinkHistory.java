package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the LogicalDataLinkHistory database table.
 */
@Entity
@Table(name="LogicalDataLinkHistory")
@NamedQuery(name="LogicalDataLinkHistory.findAll", query="SELECT l FROM LogicalDataLinkHistory l")
public class LogicalDataLinkHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int logicalDataLinkHistoryID;
	
	private int versionNumber;
	
	private String firewallChanges;

	private String firewallChangesRequired;

	private String sourceAndTargetMoveTogether;

	private String sourceConfigurationRequired;

	private String soureConfigDetails;

	private String targetConfigurationRequired;

	private String targetConfigDetails;
	
	//bi-directional many-to-one association to LogicalDataLink
	@ManyToOne
	@JoinColumn(name="LogicalDataLinkID")
	private LogicalDataLink logicalDataLinks;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne
	@JoinColumn(name="SourceApplicationComponentID")
	private ApplicationComponent applicationcomponent1;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne
	@JoinColumn(name="TargetApplicationComponentID")
	private ApplicationComponent applicationcomponent2;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne
	@JoinColumn(name="ProtocolID")
	private Protocol protocol;
	
	@ManyToOne
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public LogicalDataLinkHistory() {
		super();
	}

	public int getLogicalDataLinkHistoryID() {
		return logicalDataLinkHistoryID;
	}

	public void setLogicalDataLinkHistoryID(int logicalDataLinkHistoryID) {
		this.logicalDataLinkHistoryID = logicalDataLinkHistoryID;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getFirewallChanges() {
		return firewallChanges;
	}

	public void setFirewallChanges(String firewallChanges) {
		this.firewallChanges = firewallChanges;
	}

	public String getFirewallChangesRequired() {
		return firewallChangesRequired;
	}

	public void setFirewallChangesRequired(String firewallChangesRequired) {
		this.firewallChangesRequired = firewallChangesRequired;
	}

	public String getSourceAndTargetMoveTogether() {
		return sourceAndTargetMoveTogether;
	}

	public void setSourceAndTargetMoveTogether(String sourceAndTargetMoveTogether) {
		this.sourceAndTargetMoveTogether = sourceAndTargetMoveTogether;
	}

	public String getSourceConfigurationRequired() {
		return sourceConfigurationRequired;
	}

	public void setSourceConfigurationRequired(String sourceConfigurationRequired) {
		this.sourceConfigurationRequired = sourceConfigurationRequired;
	}

	public String getSoureConfigDetails() {
		return soureConfigDetails;
	}

	public void setSoureConfigDetails(String soureConfigDetails) {
		this.soureConfigDetails = soureConfigDetails;
	}

	public String getTargetConfigDetails() {
		return targetConfigDetails;
	}

	public void setTargetConfigDetails(String targetConfigDetails) {
		this.targetConfigDetails = targetConfigDetails;
	}

	public String getTargetConfigurationRequired() {
		return targetConfigurationRequired;
	}

	public void setTargetConfigurationRequired(String targetConfigurationRequired) {
		this.targetConfigurationRequired = targetConfigurationRequired;
	}

	public LogicalDataLink getLogicalDataLinks() {
		return logicalDataLinks;
	}

	public void setLogicalDataLinks(LogicalDataLink logicalDataLinks) {
		this.logicalDataLinks = logicalDataLinks;
	}

	public ApplicationComponent getApplicationcomponent1() {
		return applicationcomponent1;
	}

	public void setApplicationcomponent1(ApplicationComponent applicationcomponent1) {
		this.applicationcomponent1 = applicationcomponent1;
	}

	public ApplicationComponent getApplicationcomponent2() {
		return applicationcomponent2;
	}

	public void setApplicationcomponent2(ApplicationComponent applicationcomponent2) {
		this.applicationcomponent2 = applicationcomponent2;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
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
		
}