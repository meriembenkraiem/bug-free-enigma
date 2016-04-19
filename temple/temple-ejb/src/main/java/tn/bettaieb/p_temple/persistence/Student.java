package tn.bettaieb.p_temple.persistence;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Student
 *
 */
@Entity
public class Student extends User implements Serializable {

	private static final long serialVersionUID = 1L;

	public Student() {
		super();
	}

	public Student(String id, String firstName, String lastName, String email,
			String password) {
		super(id, firstName, lastName, email, password);
	}

	

}
