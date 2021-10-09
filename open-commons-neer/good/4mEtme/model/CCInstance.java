package com.ericsson.etme.commons.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the ccinstances database table.
 * 
 */
@Entity
@Table(name="CCInstances")
@NamedQuery(name="CCInstance.findAll", query="SELECT c FROM CCInstance c")
public class CCInstance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int CCInstanceID;

	private String referenceField;

	private String url;

	private String view;

	//bi-directional many-to-one association to Question
//	@OneToMany(mappedBy="ccinstance")
//	private List<Question> questions;

	public CCInstance() {
	}

	public int getCCInstanceID() {
		return this.CCInstanceID;
	}

	public void setCCInstanceID(int CCInstanceID) {
		this.CCInstanceID = CCInstanceID;
	}

	public String getReferenceField() {
		return this.referenceField;
	}

	public void setReferenceField(String referenceField) {
		this.referenceField = referenceField;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getView() {
		return this.view;
	}

	public void setView(String view) {
		this.view = view;
	}

}