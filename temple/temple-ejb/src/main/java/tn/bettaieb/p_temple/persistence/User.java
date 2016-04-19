package tn.bettaieb.p_temple.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
public class User implements Serializable {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private static final long serialVersionUID = 1L;

	@ManyToMany(cascade = CascadeType.PERSIST)
	private List<Project> projects;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "USR_PROJ", joinColumns = @JoinColumn(name = "USR_ID", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "PROJ_ID", referencedColumnName = "id"))
	private List<Project> projectsUsedByUsers;

	public User() {
		super();
	}

	public User(String id, String firstName, String lastName, String email,
			String password) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Project> getProjectsUsedByUsers() {
		return projectsUsedByUsers;
	}

	public void setProjectsUsedByUsers(List<Project> projectsUsedByUsers) {
		this.projectsUsedByUsers = projectsUsedByUsers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((projects == null) ? 0 : projects.hashCode());
		result = prime
				* result
				+ ((projectsUsedByUsers == null) ? 0 : projectsUsedByUsers
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (projects == null) {
			if (other.projects != null)
				return false;
		} else if (!projects.equals(other.projects))
			return false;
		if (projectsUsedByUsers == null) {
			if (other.projectsUsedByUsers != null)
				return false;
		} else if (!projectsUsedByUsers.equals(other.projectsUsedByUsers))
			return false;
		return true;
	}

}
