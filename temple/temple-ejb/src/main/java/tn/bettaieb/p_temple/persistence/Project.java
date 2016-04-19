package tn.bettaieb.p_temple.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: Project
 *
 */
@Entity
public class Project implements Serializable {

	@Id
	private String id;
	private String name;
	private int evalValue;
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "projects")
	private List<User> users;

	@ManyToMany(mappedBy = "projectsUsedByUsers")
	
	private List<User> usersThatUserTheProject;

	public Project() {
		super();
	}

	public Project(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getUsersThatUserTheProject() {
		return usersThatUserTheProject;
	}

	public void setUsersThatUserTheProject(List<User> usersThatUserTheProject) {
		this.usersThatUserTheProject = usersThatUserTheProject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getEvalValue() {
		return evalValue;
	}

	public void setEvalValue(int evalValue) {
		this.evalValue = evalValue;
	}

}
