package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the supportstatus database table.
 * 
 */
@Entity
@Cacheable(true)
@NamedQuery(name="SupportStatus.findAll", query="SELECT s FROM SupportStatus s")
public class SupportStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int supportStatusID;

	private String supportStatusName;

	//bi-directional many-to-one association to SoftwareVersion
	@OneToMany(mappedBy="supportstatus")
	private List<SoftwareVersion> softwareversions;

	//bi-directional many-to-one association to SoftwareVersion
	@OneToMany(mappedBy="supportstatus")
	private List<OperatingSystemVersion> operatingsystemversions;
		
	public SupportStatus() {
	}

	public int getSupportStatusID() {
		return this.supportStatusID;
	}

	public void setSupportStatusID(int supportStatusID) {
		this.supportStatusID = supportStatusID;
	}

	public String getSupportStatusName() {
		return this.supportStatusName;
	}

	public void setSupportStatusName(String supportStatusName) {
		this.supportStatusName = supportStatusName;
	}

	public List<SoftwareVersion> getSoftwareversions() {
		return this.softwareversions;
	}

	public void setSoftwareversions(List<SoftwareVersion> softwareversions) {
		this.softwareversions = softwareversions;
	}

	public SoftwareVersion addSoftwareversion(SoftwareVersion softwareversion) {
		getSoftwareversions().add(softwareversion);
		softwareversion.setSupportstatus(this);

		return softwareversion;
	}

	public SoftwareVersion removeSoftwareversion(SoftwareVersion softwareversion) {
		getSoftwareversions().remove(softwareversion);
		softwareversion.setSupportstatus(null);

		return softwareversion;
	}
	
	public List<OperatingSystemVersion> getOperatingsystemversions() {
		return operatingsystemversions;
	}

	public void setOperatingsystemversions(
			List<OperatingSystemVersion> operatingsystemversions) {
		this.operatingsystemversions = operatingsystemversions;
	}

	public OperatingSystemVersion addSoftwareversion(OperatingSystemVersion operatingsystemversion) {
		getOperatingsystemversions().add(operatingsystemversion);
		operatingsystemversion.setSupportstatus(this);

		return operatingsystemversion;
	}

	public OperatingSystemVersion removeSoftwareversion(OperatingSystemVersion operatingsystemversion) {
		getOperatingsystemversions().remove(operatingsystemversion);
		operatingsystemversion.setSupportstatus(null);

		return operatingsystemversion;
	}
}