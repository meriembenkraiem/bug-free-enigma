package tn.bettaieb.p_temple.services.interfaces;

import javax.ejb.Local;

import tn.bettaieb.p_temple.persistence.Project;

@Local
public interface ProjectServicesLocal {
	Boolean addProject(Project project);

	Boolean assignProjectToUser(String idProject, String idStudent);

	Project findProjectById(String idProject);
}
