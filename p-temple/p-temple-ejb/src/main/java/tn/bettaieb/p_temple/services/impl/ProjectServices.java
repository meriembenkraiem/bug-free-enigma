package tn.bettaieb.p_temple.services.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.bettaieb.p_temple.persistence.Project;
import tn.bettaieb.p_temple.persistence.Student;
import tn.bettaieb.p_temple.services.interfaces.ProjectServicesLocal;
import tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote;
import tn.bettaieb.p_temple.services.interfaces.UserServicesLocal;

/**
 * Session Bean implementation class ProjectServices
 */
@Stateless
public class ProjectServices implements ProjectServicesRemote,
		ProjectServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	@EJB
	private UserServicesLocal userServicesLocal;

	/**
	 * Default constructor.
	 */
	public ProjectServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addProject(Project project) {
		Boolean b = false;
		try {
			entityManager.persist(project);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Boolean assignProjectToUser(String idProject, String idStudent) {
		Boolean b = false;
		try {
			Project project = findProjectById(idProject);
			Student student = (Student) userServicesLocal
					.findUserById(idStudent);

			student.getProjects().add(project);
			entityManager.merge(student);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public Project findProjectById(String idProject) {
		return entityManager.find(Project.class, idProject);
	}

}
