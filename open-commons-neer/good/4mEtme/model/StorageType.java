package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The Persistent class for the StorageTypes Database Table
 * 
 * @author esoidey
 *
 */
@Entity
@Cacheable(true)
@Table(name = "StorageTypes")
@NamedQuery(name = "StorageType.findAll", query = "SELECT ot FROM StorageType ot")
public class StorageType implements Serializable {

	private static final long serialVersionUID = 8751940610864295008L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storageTypeID;
	private String storageTypeName;
	
	// bi-directional many-to-one association to StorageService
	@OneToMany(mappedBy = "storageType")
	private List<StorageService> storageServices;

	public int getStorageTypeID() {
		return storageTypeID;
	}

	public void setStorageTypeID(int storageTypeID) {
		this.storageTypeID = storageTypeID;
	}

	public String getStorageTypeName() {
		return storageTypeName;
	}

	public void setStorageTypeName(String storageTypeName) {
		this.storageTypeName = storageTypeName;
	}

	public List<StorageService> getStorageServices() {
		return storageServices;
	}

	public void setStorageServices(List<StorageService> storageServices) {
		this.storageServices = storageServices;
	}
	
}
