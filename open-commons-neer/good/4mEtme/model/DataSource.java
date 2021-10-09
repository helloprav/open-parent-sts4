package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the datasources database table.
 * 
 */
@Entity
@Cacheable(true)
@Table(name="DataSources")
@NamedQuery(name="DataSource.findAll", query="SELECT d FROM DataSource d")
public class DataSource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long dataSourceID;

	private String dataSourceName;

	private int priorityOrderNum;

	//bi-directional many-to-one association to TemplateUpload
	@OneToMany(mappedBy="datasource")
	private List<TemplateUpload> templateuploads;

	public DataSource() {
	}

	public Long getDataSourceID() {
		return this.dataSourceID;
	}

	public void setDataSourceID(Long dataSourceID) {
		this.dataSourceID = dataSourceID;
	}

	public String getDataSourceName() {
		return this.dataSourceName;
	}

	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public int getPriorityOrderNum() {
		return this.priorityOrderNum;
	}

	public void setPriorityOrderNum(int priorityOrderNum) {
		this.priorityOrderNum = priorityOrderNum;
	}

	public List<TemplateUpload> getTemplateuploads() {
		return this.templateuploads;
	}

	public void setTemplateuploads(List<TemplateUpload> templateuploads) {
		this.templateuploads = templateuploads;
	}

	public TemplateUpload addTemplateupload(TemplateUpload templateupload) {
		getTemplateuploads().add(templateupload);
		templateupload.setDatasource(this);

		return templateupload;
	}

	public TemplateUpload removeTemplateupload(TemplateUpload templateupload) {
		getTemplateuploads().remove(templateupload);
		templateupload.setDatasource(null);

		return templateupload;
	}

}