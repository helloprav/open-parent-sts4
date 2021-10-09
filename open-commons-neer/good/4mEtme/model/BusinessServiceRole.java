package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the businessserviceroles database table.
 * 
 */
@Entity
@Table(name="BusinessServiceRoles")
@NamedQuery(name="BusinessServiceRole.findAll", query="SELECT b FROM BusinessServiceRole b")
public class BusinessServiceRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int businessServiceRoleID;

	private String otherName;

	//bi-directional many-to-one association to BusinessService
	@ManyToOne
	@JoinColumn(name="BusinessServiceID")
	private BusinessService businessservice;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="RoleID")
	private Role role;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public BusinessServiceRole() {
	}

	public int getBusinessServiceRoleID() {
		return this.businessServiceRoleID;
	}

	public void setBusinessServiceRoleID(int businessServiceRoleID) {
		this.businessServiceRoleID = businessServiceRoleID;
	}

	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public BusinessService getBusinessservice() {
		return this.businessservice;
	}

	public void setBusinessservice(BusinessService businessservice) {
		this.businessservice = businessservice;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}