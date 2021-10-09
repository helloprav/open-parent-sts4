package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userapplicationeditrules database table.
 * 
 */
@Entity
@Table(name="UserApplicationEditRules")
@NamedQuery(name="UserApplicationEditRule.findAll", query="SELECT u FROM UserApplicationEditRule u")
public class UserApplicationEditRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userApplicationEditRuleID;

	private String rule;

	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserID")
	private User user;

	public UserApplicationEditRule() {
	}

	public int getUserApplicationEditRuleID() {
		return this.userApplicationEditRuleID;
	}

	public void setUserApplicationEditRuleID(int userApplicationEditRuleID) {
		this.userApplicationEditRuleID = userApplicationEditRuleID;
	}

	public String getRule() {
		return this.rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}