package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The Persistent class for the OtherHardwareTypes Database Table
 *
 */
@Entity
@Cacheable(true)
@Table(name = "OtherHardwareTypes")
@NamedQuery(name = "OtherHardwareType.findAll", query = "SELECT ot FROM OtherHardwareType ot")
public class OtherHardwareType implements Serializable {

	private static final long serialVersionUID = 7137000623051756406L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int otherHardwareTypeID;
	private String otherHardwareTypeName;
	
	// bi-directional many-to-one association to OtherHardware
	@OneToMany(mappedBy = "otherHardwareType", cascade = { CascadeType.ALL })
	private List<OtherHardware> otherHardwares;
	
	public OtherHardwareType(){
		
	}

	public int getOtherHardwareTypeID() {
		return otherHardwareTypeID;
	}

	public void setOtherHardwareTypeID(int otherHardwareTypeID) {
		this.otherHardwareTypeID = otherHardwareTypeID;
	}

	public String getOtherHardwareTypeName() {
		return otherHardwareTypeName;
	}

	public void setOtherHardwareTypeName(String otherHardwareTypeName) {
		this.otherHardwareTypeName = otherHardwareTypeName;
	}

	public List<OtherHardware> getOtherHardwares() {
		return otherHardwares;
	}

	public void setOtherHardwares(List<OtherHardware> otherHardwares) {
		this.otherHardwares = otherHardwares;
	}
	
}
