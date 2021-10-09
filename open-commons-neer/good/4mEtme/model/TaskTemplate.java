package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tasktemplates database table.
 * 
 */
@Entity
@Table(name="TaskTemplates")
@NamedQuery(name="TaskTemplate.findAll", query="SELECT t FROM TaskTemplate t")
public class TaskTemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taskTemplateID;

	private String taskName;

	private String description;

	private int migrationOffset;

	private byte businessServiceLevel;

	private byte applicationLevel;

	private byte applicationInstanceLevel;

	private byte applicationComponentLevel;
	
	private byte applicationComponentInstanceLevel;

	private byte serverLevel;

	private byte assetLevel;

	private byte operationalServiceLevel;

	private byte currentPaasLevel;
	
	private byte targetPaasLevel;
	
	private byte currentServerLevel;
	
	private byte targetServerLevel;
	
	private byte currentVmFarmLevel;
	
	private byte targetVmFarmLevel;
	
	private byte currentPhysicalServerLevel;
	
	private byte targetPhysicalServerLevel;
	
	private byte moveGroupLevel;

	private byte networkDeviceLevel;

	private byte storageServiceLevel;

	private byte otherHardwareLevel;
	
	private byte physicalServerLevel;
	
	//bi-directional many-to-one association to MigrationMethodTaskTemplate
//	@OneToMany(mappedBy="tasktemplate")
//	private List<MigrationMethodTaskTemplate> migrationmethodtasktemplates;

	//bi-directional many-to-one association to MigrationMethodTaskTemplate
	@OneToMany(mappedBy="tasktemplate")
	private List<TaskTemplateByMethod> taskTemplateByMethods;

	//bi-directional many-to-one association to TaskTemplateDependency
	@OneToMany(mappedBy="tasktemplate1")
	private List<TaskTemplateDependency> tasktemplatedependencies1;

	//bi-directional many-to-one association to TaskTemplateDependency
	@OneToMany(mappedBy="tasktemplate2")
	private List<TaskTemplateDependency> tasktemplatedependencies2;

	//bi-directional many-to-one association to TaskTemplateRole
	@OneToMany(mappedBy="tasktemplate")
	private List<TaskTemplateRole> tasktemplateroles;

	//bi-directional many-to-one association to TaskTemplateUser
	@OneToMany(mappedBy="tasktemplate")
	private List<TaskTemplateUser> tasktemplateusers;

	//bi-directional many-to-one association to TaskTracking
	@OneToMany(mappedBy="tasktemplate")
	private List<Task> tasktrackings;

	//bi-directional many-to-one association to TransformationMethodTaskTemplate
//	@OneToMany(mappedBy="tasktemplate")
//	private List<TransformationMethodTaskTemplate> transformationmethodtasktemplates;

	public TaskTemplate() {
	}

	public int getTaskTemplateID() {
		return this.taskTemplateID;
	}

	public void setTaskTemplateID(int taskTemplateID) {
		this.taskTemplateID = taskTemplateID;
	}

	public byte getApplicationComponentInstanceLevel() {
		return this.applicationComponentInstanceLevel;
	}

	public void setApplicationComponentInstanceLevel(byte applicationComponentInstanceLevel) {
		this.applicationComponentInstanceLevel = applicationComponentInstanceLevel;
	}

	public byte getApplicationComponentLevel() {
		return this.applicationComponentLevel;
	}

	public void setApplicationComponentLevel(byte applicationComponentLevel) {
		this.applicationComponentLevel = applicationComponentLevel;
	}

	public byte getApplicationInstanceLevel() {
		return this.applicationInstanceLevel;
	}

	public void setApplicationInstanceLevel(byte applicationInstanceLevel) {
		this.applicationInstanceLevel = applicationInstanceLevel;
	}

	public byte getApplicationLevel() {
		return this.applicationLevel;
	}

	public void setApplicationLevel(byte applicationLevel) {
		this.applicationLevel = applicationLevel;
	}

	public byte getAssetLevel() {
		return this.assetLevel;
	}

	public void setAssetLevel(byte assetLevel) {
		this.assetLevel = assetLevel;
	}

	public byte getBusinessServiceLevel() {
		return this.businessServiceLevel;
	}

	public void setBusinessServiceLevel(byte businessServiceLevel) {
		this.businessServiceLevel = businessServiceLevel;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMigrationOffset() {
		return this.migrationOffset;
	}

	public void setMigrationOffset(int migrationOffset) {
		this.migrationOffset = migrationOffset;
	}

	public byte getOperationalServiceLevel() {
		return this.operationalServiceLevel;
	}

	public void setOperationalServiceLevel(byte operationalServiceLevel) {
		this.operationalServiceLevel = operationalServiceLevel;
	}

	public byte getServerLevel() {
		return this.serverLevel;
	}

	public void setServerLevel(byte serverLevel) {
		this.serverLevel = serverLevel;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public byte getCurrentPaasLevel() {
		return currentPaasLevel;
	}

	public void setCurrentPaasLevel(byte currentPaasLevel) {
		this.currentPaasLevel = currentPaasLevel;
	}

	public byte getTargetPaasLevel() {
		return targetPaasLevel;
	}

	public void setTargetPaasLevel(byte targetPaasLevel) {
		this.targetPaasLevel = targetPaasLevel;
	}

	public byte getCurrentServerLevel() {
		return currentServerLevel;
	}

	public void setCurrentServerLevel(byte currentServerLevel) {
		this.currentServerLevel = currentServerLevel;
	}

	public byte getTargetServerLevel() {
		return targetServerLevel;
	}

	public void setTargetServerLevel(byte targetServerLevel) {
		this.targetServerLevel = targetServerLevel;
	}

	public byte getCurrentVmFarmLevel() {
		return currentVmFarmLevel;
	}

	public void setCurrentVmFarmLevel(byte currentVmFarmLevel) {
		this.currentVmFarmLevel = currentVmFarmLevel;
	}

	public byte getTargetVmFarmLevel() {
		return targetVmFarmLevel;
	}

	public void setTargetVmFarmLevel(byte targetVmFarmLevel) {
		this.targetVmFarmLevel = targetVmFarmLevel;
	}

	public byte getCurrentPhysicalServerLevel() {
		return currentPhysicalServerLevel;
	}

	public void setCurrentPhysicalServerLevel(byte currentPhysicalServerLevel) {
		this.currentPhysicalServerLevel = currentPhysicalServerLevel;
	}

	public byte getTargetPhysicalServerLevel() {
		return targetPhysicalServerLevel;
	}

	public void setTargetPhysicalServerLevel(byte targetPhysicalServerLevel) {
		this.targetPhysicalServerLevel = targetPhysicalServerLevel;
	}

	public byte getMoveGroupLevel() {
		return moveGroupLevel;
	}

	public void setMoveGroupLevel(byte moveGroupLevel) {
		this.moveGroupLevel = moveGroupLevel;
	}

	public byte getNetworkDeviceLevel() {
		return networkDeviceLevel;
	}

	public void setNetworkDeviceLevel(byte networkServiceLevel) {
		this.networkDeviceLevel = networkServiceLevel;
	}

	public byte getStorageServiceLevel() {
		return storageServiceLevel;
	}

	public void setStorageServiceLevel(byte storageServiceLevel) {
		this.storageServiceLevel = storageServiceLevel;
	}

	public byte getOtherHardwareLevel() {
		return otherHardwareLevel;
	}

	public void setOtherHardwareLevel(byte otherHardwareLevel) {
		this.otherHardwareLevel = otherHardwareLevel;
	}

	public byte getPhysicalServerLevel() {
		return physicalServerLevel;
	}

	public void setPhysicalServerLevel(byte physicalServerLevel) {
		this.physicalServerLevel = physicalServerLevel;
	}

	public List<TaskTemplateByMethod> getTaskTemplateByMethods() {
		return taskTemplateByMethods;
	}

	public void setTaskTemplateByMethods(List<TaskTemplateByMethod> taskTemplateByMethods) {
		this.taskTemplateByMethods = taskTemplateByMethods;
	}

	public List<TaskTemplateDependency> getTasktemplatedependencies1() {
		return this.tasktemplatedependencies1;
	}

	public void setTasktemplatedependencies1(List<TaskTemplateDependency> tasktemplatedependencies1) {
		this.tasktemplatedependencies1 = tasktemplatedependencies1;
	}

	public TaskTemplateDependency addTasktemplatedependencies1(TaskTemplateDependency tasktemplatedependencies1) {
		getTasktemplatedependencies1().add(tasktemplatedependencies1);
		tasktemplatedependencies1.setTasktemplate1(this);

		return tasktemplatedependencies1;
	}

	public TaskTemplateDependency removeTasktemplatedependencies1(TaskTemplateDependency tasktemplatedependencies1) {
		getTasktemplatedependencies1().remove(tasktemplatedependencies1);
		tasktemplatedependencies1.setTasktemplate1(null);

		return tasktemplatedependencies1;
	}

	public List<TaskTemplateDependency> getTasktemplatedependencies2() {
		return this.tasktemplatedependencies2;
	}

	public void setTasktemplatedependencies2(List<TaskTemplateDependency> tasktemplatedependencies2) {
		this.tasktemplatedependencies2 = tasktemplatedependencies2;
	}

	public TaskTemplateDependency addTasktemplatedependencies2(TaskTemplateDependency tasktemplatedependencies2) {
		getTasktemplatedependencies2().add(tasktemplatedependencies2);
		tasktemplatedependencies2.setTasktemplate2(this);

		return tasktemplatedependencies2;
	}

	public TaskTemplateDependency removeTasktemplatedependencies2(TaskTemplateDependency tasktemplatedependencies2) {
		getTasktemplatedependencies2().remove(tasktemplatedependencies2);
		tasktemplatedependencies2.setTasktemplate2(null);

		return tasktemplatedependencies2;
	}

	public List<TaskTemplateRole> getTasktemplateroles() {
		return this.tasktemplateroles;
	}

	public void setTasktemplateroles(List<TaskTemplateRole> tasktemplateroles) {
		this.tasktemplateroles = tasktemplateroles;
	}

	public TaskTemplateRole addTasktemplaterole(TaskTemplateRole tasktemplaterole) {
		getTasktemplateroles().add(tasktemplaterole);
		tasktemplaterole.setTasktemplate(this);

		return tasktemplaterole;
	}

	public TaskTemplateRole removeTasktemplaterole(TaskTemplateRole tasktemplaterole) {
		getTasktemplateroles().remove(tasktemplaterole);
		tasktemplaterole.setTasktemplate(null);

		return tasktemplaterole;
	}

	public List<TaskTemplateUser> getTasktemplateusers() {
		return this.tasktemplateusers;
	}

	public void setTasktemplateusers(List<TaskTemplateUser> tasktemplateusers) {
		this.tasktemplateusers = tasktemplateusers;
	}

	public TaskTemplateUser addTasktemplateusers(TaskTemplateUser tasktemplateusers) {
		getTasktemplateusers().add(tasktemplateusers);
		tasktemplateusers.setTasktemplate(this);

		return tasktemplateusers;
	}

	public TaskTemplateUser removeTasktemplateusers(TaskTemplateUser tasktemplateusers) {
		getTasktemplateusers().remove(tasktemplateusers);
		tasktemplateusers.setTasktemplate(null);

		return tasktemplateusers;
	}

	public List<Task> getTasktrackings() {
		return this.tasktrackings;
	}

	public void setTasktrackings(List<Task> tasktrackings) {
		this.tasktrackings = tasktrackings;
	}

	public Task addTasktracking(Task tasktracking) {
		getTasktrackings().add(tasktracking);
		tasktracking.setTasktemplate(this);

		return tasktracking;
	}

	public Task removeTasktracking(Task tasktracking) {
		getTasktrackings().remove(tasktracking);
		tasktracking.setTasktemplate(null);

		return tasktracking;
	}

	public List<TaskTemplateByMethod> getTasktemplatebymethod() {
		return this.taskTemplateByMethods;
	}

	public void setTasktemplatebymethod(List<TaskTemplateByMethod> taskTemplateByMethods) {
		this.taskTemplateByMethods = taskTemplateByMethods;
	}

	public TaskTemplateByMethod addTasktemplatebymethod(TaskTemplateByMethod taskTemplateByMethods) {
		getTasktemplatebymethod().add(taskTemplateByMethods);
		taskTemplateByMethods.setTasktemplate(this);
	

		return taskTemplateByMethods;
	}

	public TaskTemplateByMethod removeTasktemplatebymethod(TaskTemplateByMethod taskTemplateByMethods) {
		getTasktemplatebymethod().remove(taskTemplateByMethods);
		taskTemplateByMethods.setTasktemplate(null);
		
		return taskTemplateByMethods;
	}

}