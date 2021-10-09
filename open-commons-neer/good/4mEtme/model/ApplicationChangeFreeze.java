package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * The persistent class for the applicationchangefreezes database table.
 * 
 */
@Entity
@Table(name="ApplicationChangeFreezes")
@NamedQuery(name="ApplicationChangeFreeze.findAll", query="SELECT a FROM ApplicationChangeFreeze a")
public class ApplicationChangeFreeze implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int applicationChangeFreezeID;

	//bi-directional many-to-one association to Application
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ApplicationID")
	private Application application;

	//bi-directional many-to-one association to ChangeFreeze
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ChangeFreezeID")
	private ChangeFreeze changefreeze;

	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;

	public ApplicationChangeFreeze() {
	}

	public int getApplicationChangeFreezeID() {
		return this.applicationChangeFreezeID;
	}

	public void setApplicationChangeFreezeID(int applicationChangeFreezeID) {
		this.applicationChangeFreezeID = applicationChangeFreezeID;
	}

	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	public ChangeFreeze getChangefreeze() {
		return this.changefreeze;
	}

	public void setChangefreeze(ChangeFreeze changefreeze) {
		this.changefreeze = changefreeze;
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