package tn.bettaieb.p_temple.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.bettaieb.p_temple.persistence.Project;
import tn.bettaieb.p_temple.persistence.Student;
import tn.bettaieb.p_temple.persistence.User;
import tn.bettaieb.p_temple.services.interfaces.ProjectServicesLocal;
import tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote;
import tn.bettaieb.p_temple.services.interfaces.UserServicesLocal;

/**
 * Session Bean implementation class ProjectServices
 */
@Stateless
public class ProjectServices implements ProjectServicesRemote, ProjectServicesLocal {
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
			Student student = (Student) userServicesLocal.findUserById(idStudent);

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

	@Override
	public List<Project> findProjectsByUserId(String idUser) {
		List<Project> projects = new ArrayList<Project>();
		Student student = (Student) userServicesLocal.findUserById(idUser);
		String jpql = "select p from Project p where :param member of p.users";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", student);
		projects = query.getResultList();
		return projects;
	}

	@Override
	public List<User> findUsersByProjectId(String idProject) {
		List<User> users = new ArrayList<User>();
		Project project = findProjectById(idProject);
		String jpql = "select u from User u where :param member of u.projects";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param", project);
		users = query.getResultList();
		return users;
	}

}
