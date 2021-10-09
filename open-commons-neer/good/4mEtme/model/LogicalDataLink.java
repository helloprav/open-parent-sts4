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
 * The persistent class for the LogicalDataLinks database table.
 */
@Entity
@Table(name="LogicalDataLinks")
@NamedQuery(name="LogicalDataLink.findAll", query="SELECT l FROM LogicalDataLink l")
public class LogicalDataLink implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int logicalDataLinkID;

	private String firewallChanges;
	private String firewallChangesRequired;
	private String sourceAndTargetMoveTogether;
	private String sourceConfigurationRequired;
	private String soureConfigDetails;
	private String targetConfigDetails;
	private String targetConfigurationRequired;

	//bi-directional many-to-one association to LogicalDataLinkMaintenanceWindow
	@OneToMany(mappedBy="logicaldatalink")
	private List<LogicalDataLinkMaintenanceWindow> logicaldatalinkmaintenancewindows;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="SourceApplicationComponentID")
	private ApplicationComponent applicationcomponent1;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TargetApplicationComponentID")
	private ApplicationComponent applicationcomponent2;

	//bi-directional many-to-one association to ApplicationComponent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ProtocolID")
	private Protocol protocol;
	
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

	public LogicalDataLink() {
		super();
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
	
	public int getLogicalDataLinkID() {
		return this.logicalDataLinkID;
	}

	public void setLogicalDataLinkID(int logicalDataLinkID) {
		this.logicalDataLinkID = logicalDataLinkID;
	}

	public String getFirewallChanges() {
		return this.firewallChanges;
	}

	public void setFirewallChanges(String firewallChanges) {
		this.firewallChanges = firewallChanges;
	}

	public String getFirewallChangesRequired() {
		return this.firewallChangesRequired;
	}

	public void setFirewallChangesRequired(String firewallChangesRequired) {
		this.firewallChangesRequired = firewallChangesRequired;
	}

	public String getSourceAndTargetMoveTogether() {
		return this.sourceAndTargetMoveTogether;
	}

	public void setSourceAndTargetMoveTogether(String sourceAndTargetMoveTogether) {
		this.sourceAndTargetMoveTogether = sourceAndTargetMoveTogether;
	}

	public String getSourceConfigurationRequired() {
		return this.sourceConfigurationRequired;
	}

	public void setSourceConfigurationRequired(String sourceConfigurationRequired) {
		this.sourceConfigurationRequired = sourceConfigurationRequired;
	}

	public String getSoureConfigDetails() {
		return this.soureConfigDetails;
	}

	public void setSoureConfigDetails(String soureConfigDetails) {
		this.soureConfigDetails = soureConfigDetails;
	}

	public String getTargetConfigDetails() {
		return this.targetConfigDetails;
	}

	public void setTargetConfigDetails(String targetConfigDetails) {
		this.targetConfigDetails = targetConfigDetails;
	}

	public String getTargetConfigurationRequired() {
		return this.targetConfigurationRequired;
	}

	public void setTargetConfigurationRequired(String targetConfigurationRequired) {
		this.targetConfigurationRequired = targetConfigurationRequired;
	}

	public List<LogicalDataLinkMaintenanceWindow> getLogicaldatalinkmaintenancewindows() {
		return this.logicaldatalinkmaintenancewindows;
	}

	public void setLogicaldatalinkmaintenancewindows(List<LogicalDataLinkMaintenanceWindow> logicaldatalinkmaintenancewindows) {
		this.logicaldatalinkmaintenancewindows = logicaldatalinkmaintenancewindows;
	}

	public LogicalDataLinkMaintenanceWindow addLogicaldatalinkmaintenancewindow(LogicalDataLinkMaintenanceWindow logicaldatalinkmaintenancewindow) {
		getLogicaldatalinkmaintenancewindows().add(logicaldatalinkmaintenancewindow);
		logicaldatalinkmaintenancewindow.setLogicaldatalink(this);

		return logicaldatalinkmaintenancewindow;
	}

	public LogicalDataLinkMaintenanceWindow removeLogicaldatalinkmaintenancewindow(LogicalDataLinkMaintenanceWindow logicaldatalinkmaintenancewindow) {
		getLogicaldatalinkmaintenancewindows().remove(logicaldatalinkmaintenancewindow);
		logicaldatalinkmaintenancewindow.setLogicaldatalink(null);

		return logicaldatalinkmaintenancewindow;
	}

	public ApplicationComponent getApplicationcomponent1() {
		return this.applicationcomponent1;
	}

	public void setApplicationcomponent1(ApplicationComponent applicationcomponent1) {
		this.applicationcomponent1 = applicationcomponent1;
	}

	public ApplicationComponent getApplicationcomponent2() {
		return this.applicationcomponent2;
	}

	public void setApplicationcomponent2(ApplicationComponent applicationcomponent2) {
		this.applicationcomponent2 = applicationcomponent2;
	}
	
	public Protocol getProtocol() {
		return this.protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}
	
}