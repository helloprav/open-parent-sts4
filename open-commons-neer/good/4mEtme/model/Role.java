package com.ericsson.etme.commons.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="Roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int roleID;

	private String roleName;
	
	private String description;

	//bi-directional many-to-one association to ApplicationRole
	@OneToMany(mappedBy="role")
	private List<AssetRole> assetroles;

	//bi-directional many-to-one association to TaskTemplateRole
	@OneToMany(mappedBy="role")
	private List<TaskTemplateRole> tasktemplateroles;

	public Role() {
	}

	public int getRoleID() {
		return this.roleID;
	}

	public void setRoleID(int roleID) {
		this.roleID = roleID;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<TaskTemplateRole> getTasktemplateroles() {
		return this.tasktemplateroles;
	}

	public void setTasktemplateroles(List<TaskTemplateRole> tasktemplateroles) {
		this.tasktemplateroles = tasktemplateroles;
	}

	public TaskTemplateRole addTasktemplaterole(TaskTemplateRole tasktemplaterole) {
		getTasktemplateroles().add(tasktemplaterole);
		tasktemplaterole.setRole(this);

		return tasktemplaterole;
	}

	public TaskTemplateRole removeTasktemplaterole(TaskTemplateRole tasktemplaterole) {
		getTasktemplateroles().remove(tasktemplaterole);
		tasktemplaterole.setRole(null);

		return tasktemplaterole;
	}

	public List<AssetRole> getAssetroles() {
		return this.assetroles;
	}

	public void setAssetroles(List<AssetRole> assetroles) {
		this.assetroles = assetroles;
	}

	public AssetRole addAssetrole(AssetRole assetrole) {
		getAssetroles().add(assetrole);
		assetrole.setRole(this);

		return assetrole;
	}

	public AssetRole removeAssetrole(AssetRole assetrole) {
		getAssetroles().remove(assetrole);
		assetrole.setRole(null);

		return assetrole;
	}

}