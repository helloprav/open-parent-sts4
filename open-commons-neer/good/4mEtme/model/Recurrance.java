package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the recurrances database table.
 * 
 */
@Entity
@Table(name="Recurrances")
@NamedQuery(name="Recurrance.findAll", query="SELECT r FROM Recurrance r")
public class Recurrance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int recurranceID;

	private String recurranceName;

	//bi-directional many-to-one association to ApplicationComponentInstanceMaintenanceOperation
	@OneToMany(mappedBy="recurrance")
	private List<ApplicationComponentInstanceMaintenanceOperation> applicationcomponentinstancemaintenanceoperations;

	//bi-directional many-to-one association to LogicalDataLinkMaintenanceWindow
	@OneToMany(mappedBy="recurrance")
	private List<LogicalDataLinkMaintenanceWindow> logicaldatalinkmaintenancewindows;

	//bi-directional many-to-one association to ServerMaintenanceOperation
	@OneToMany(mappedBy="recurrance")
	private List<ServerMaintenanceOperation> servermaintenanceoperations;

	public Recurrance() {
	}

	public int getRecurranceID() {
		return this.recurranceID;
	}

	public void setRecurranceID(int recurranceID) {
		this.recurranceID = recurranceID;
	}

	public String getRecurranceName() {
		return this.recurranceName;
	}

	public void setRecurranceName(String recurranceName) {
		this.recurranceName = recurranceName;
	}

	public List<ApplicationComponentInstanceMaintenanceOperation> getApplicationcomponentinstancemaintenanceoperations() {
		return this.applicationcomponentinstancemaintenanceoperations;
	}

	public void setApplicationcomponentinstancemaintenanceoperations(List<ApplicationComponentInstanceMaintenanceOperation> applicationcomponentinstancemaintenanceoperations) {
		this.applicationcomponentinstancemaintenanceoperations = applicationcomponentinstancemaintenanceoperations;
	}

	public ApplicationComponentInstanceMaintenanceOperation addApplicationcomponentinstancemaintenanceoperation(ApplicationComponentInstanceMaintenanceOperation applicationcomponentinstancemaintenanceoperation) {
		getApplicationcomponentinstancemaintenanceoperations().add(applicationcomponentinstancemaintenanceoperation);
		applicationcomponentinstancemaintenanceoperation.setRecurrance(this);

		return applicationcomponentinstancemaintenanceoperation;
	}

	public ApplicationComponentInstanceMaintenanceOperation removeApplicationcomponentinstancemaintenanceoperation(ApplicationComponentInstanceMaintenanceOperation applicationcomponentinstancemaintenanceoperation) {
		getApplicationcomponentinstancemaintenanceoperations().remove(applicationcomponentinstancemaintenanceoperation);
		applicationcomponentinstancemaintenanceoperation.setRecurrance(null);

		return applicationcomponentinstancemaintenanceoperation;
	}

	public List<LogicalDataLinkMaintenanceWindow> getLogicaldatalinkmaintenancewindows() {
		return this.logicaldatalinkmaintenancewindows;
	}

	public void setLogicaldatalinkmaintenancewindows(List<LogicalDataLinkMaintenanceWindow> logicaldatalinkmaintenancewindows) {
		this.logicaldatalinkmaintenancewindows = logicaldatalinkmaintenancewindows;
	}

	public LogicalDataLinkMaintenanceWindow addLogicaldatalinkmaintenancewindow(LogicalDataLinkMaintenanceWindow logicaldatalinkmaintenancewindow) {
		getLogicaldatalinkmaintenancewindows().add(logicaldatalinkmaintenancewindow);
		logicaldatalinkmaintenancewindow.setRecurrance(this);

		return logicaldatalinkmaintenancewindow;
	}

	public LogicalDataLinkMaintenanceWindow removeLogicaldatalinkmaintenancewindow(LogicalDataLinkMaintenanceWindow logicaldatalinkmaintenancewindow) {
		getLogicaldatalinkmaintenancewindows().remove(logicaldatalinkmaintenancewindow);
		logicaldatalinkmaintenancewindow.setRecurrance(null);

		return logicaldatalinkmaintenancewindow;
	}

	public List<ServerMaintenanceOperation> getServermaintenanceoperations() {
		return this.servermaintenanceoperations;
	}

	public void setServermaintenanceoperations(List<ServerMaintenanceOperation> servermaintenanceoperations) {
		this.servermaintenanceoperations = servermaintenanceoperations;
	}

	public ServerMaintenanceOperation addServermaintenanceoperation(ServerMaintenanceOperation servermaintenanceoperation) {
		getServermaintenanceoperations().add(servermaintenanceoperation);
		servermaintenanceoperation.setRecurrance(this);

		return servermaintenanceoperation;
	}

	public ServerMaintenanceOperation removeServermaintenanceoperation(ServerMaintenanceOperation servermaintenanceoperation) {
		getServermaintenanceoperations().remove(servermaintenanceoperation);
		servermaintenanceoperation.setRecurrance(null);

		return servermaintenanceoperation;
	}

}