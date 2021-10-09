package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the changefreezes database table.
 * 
 */
@Entity
@Table(name="ChangeFreezes")
@NamedQuery(name="ChangeFreeze.findAll", query="SELECT c FROM ChangeFreeze c")
public class ChangeFreeze implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int changeFreezeID;

	private String applyToAllServers;

	private String changeFreezeName;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDateTime;

	private String notes;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDateTime;

	//bi-directional many-to-one association to ApplicationChangeFreeze
	@OneToMany(mappedBy="changefreeze")
	private List<ApplicationChangeFreeze> applicationchangefreezes;

	private Date creationDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public ChangeFreeze() {
	}

	public int getChangeFreezeID() {
		return this.changeFreezeID;
	}

	public void setChangeFreezeID(int changeFreezeID) {
		this.changeFreezeID = changeFreezeID;
	}

	public String getApplyToAllServers() {
		return this.applyToAllServers;
	}

	public void setApplyToAllServers(String applyToAllServers) {
		this.applyToAllServers = applyToAllServers;
	}

	public String getChangeFreezeName() {
		return this.changeFreezeName;
	}

	public void setChangeFreezeName(String changeFreezeName) {
		this.changeFreezeName = changeFreezeName;
	}

	public Date getEndDateTime() {
		return this.endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getStartDateTime() {
		return this.startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public List<ApplicationChangeFreeze> getApplicationchangefreezes() {
		return this.applicationchangefreezes;
	}

	public void setApplicationchangefreezes(List<ApplicationChangeFreeze> applicationchangefreezes) {
		this.applicationchangefreezes = applicationchangefreezes;
	}

	public ApplicationChangeFreeze addApplicationchangefreeze(ApplicationChangeFreeze applicationchangefreeze) {
		getApplicationchangefreezes().add(applicationchangefreeze);
		applicationchangefreeze.setChangefreeze(this);

		return applicationchangefreeze;
	}

	public ApplicationChangeFreeze removeApplicationchangefreeze(ApplicationChangeFreeze applicationchangefreeze) {
		getApplicationchangefreezes().remove(applicationchangefreeze);
		applicationchangefreeze.setChangefreeze(null);

		return applicationchangefreeze;
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

}