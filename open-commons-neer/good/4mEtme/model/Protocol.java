package com.ericsson.etme.commons.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the protocols database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="Protocols")
@NamedQuery(name="Protocol.findAll", query="SELECT p FROM Protocol p")
public class Protocol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int protocolID;

	private String description;

	private int portNumber;

	private String protocolName;

	private String sctp;

	private String tcp;

	private String udp;

	//bi-directional many-to-one association to LogicalDataLink
	@OneToMany(mappedBy="protocol")
	private List<LogicalDataLink> logicaldatalinks;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "TemplateUploadID")
	private TemplateUpload templateUpload;
    
	private Date creationDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "CreatedByUserID")
	private User createdByUser;

	private Date lastUpdatedDate;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "LastUpdatedByUserID")
	private User lastUpdatedByUser;
	
	public Protocol() {
	}

	public TemplateUpload getTemplateUpload() {
		return templateUpload;
	}

	public void setTemplateUpload(TemplateUpload templateUpload) {
		this.templateUpload = templateUpload;
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

	public int getProtocolID() {
		return this.protocolID;
	}

	public void setProtocolID(int protocolID) {
		this.protocolID = protocolID;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPortNumber() {
		return this.portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}

	public String getProtocolName() {
		return this.protocolName;
	}

	public void setProtocolName(String protocolName) {
		this.protocolName = protocolName;
	}

	public String getSctp() {
		return this.sctp;
	}

	public void setSctp(String sctp) {
		this.sctp = sctp;
	}

	public String getTcp() {
		return this.tcp;
	}

	public void setTcp(String tcp) {
		this.tcp = tcp;
	}

	public String getUdp() {
		return this.udp;
	}

	public void setUdp(String udp) {
		this.udp = udp;
	}

	public List<LogicalDataLink> getLogicaldatalinks() {
		return this.logicaldatalinks;
	}

	public void setLogicaldatalinks(List<LogicalDataLink> logicaldatalinks) {
		this.logicaldatalinks = logicaldatalinks;
	}

	public LogicalDataLink addLogicaldatalinks(LogicalDataLink logicaldatalinks) {
		getLogicaldatalinks().add(logicaldatalinks);
		logicaldatalinks.setProtocol(this);

		return logicaldatalinks;
	}

	public LogicalDataLink removeLogicaldatalinks(LogicalDataLink logicaldatalinks) {
		getLogicaldatalinks().remove(logicaldatalinks);
		logicaldatalinks.setProtocol(null);

		return logicaldatalinks;
	}

}