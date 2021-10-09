package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the groupapplicationeditrules database table.
 * 
 */
@Entity
@Table(name="GroupApplicationEditRules")
@NamedQuery(name="GroupApplicationEditRule.findAll", query="SELECT g FROM GroupApplicationEditRule g")
public class GroupApplicationEditRule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int groupApplicationEditRuleID;

	private String rule;

	//bi-directional many-to-one association to Application
	@ManyToOne
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to Group
	@ManyToOne
	@JoinColumn(name="GroupID")
	private Group group;

	public GroupApplicationEditRule() {
	}

	public int getGroupApplicationEditRuleID() {
		return this.groupApplicationEditRuleID;
	}

	public void setGroupApplicationEditRuleID(int groupApplicationEditRuleID) {
		this.groupApplicationEditRuleID = groupApplicationEditRuleID;
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

	public Group getGroup() {
		return this.group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}