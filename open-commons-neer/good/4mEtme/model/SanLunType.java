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
 * The Persistent class for the SanLunTypes Database Table
 * 
 * @author esoidey
 */
@Entity
@Cacheable(true)
@Table(name = "SanLunTypes")
@NamedQuery(name = "SanLunType.findAll", query = "SELECT sl FROM SanLunType sl")
public class SanLunType implements Serializable{

	private static final long serialVersionUID = -3928559730669863449L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int sanlunTypeID;
	private String sanLunTypeName;
	
	// bi-directional many-to-one association to Sanlun
	@OneToMany(mappedBy = "sanLunType", cascade = { CascadeType.ALL })
	private List<Sanlun> sanluns;
	
	public SanLunType(){
		
	}

	public int getSanlunTypeID() {
		return sanlunTypeID;
	}

	public void setSanlunTypeID(int sanlunTypeID) {
		this.sanlunTypeID = sanlunTypeID;
	}

	public String getSanLunTypeName() {
		return sanLunTypeName;
	}

	public void setSanLunTypeName(String sanLunTypeName) {
		this.sanLunTypeName = sanLunTypeName;
	}

	public List<Sanlun> getSanluns() {
		return sanluns;
	}

	public void setSanluns(List<Sanlun> sanluns) {
		this.sanluns = sanluns;
	}
	
}
