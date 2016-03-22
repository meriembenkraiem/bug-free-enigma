package tn.bettaieb.p_temple.services.interfaces;

import javax.ejb.Remote;

import tn.bettaieb.p_temple.persistence.Project;

@Remote
public interface ProjectServicesRemote {
	Boolean addProject(Project project);

	Boolean assignProjectToUser(String idProject, String idStudent);

	Project findProjectById(String idProject);

}
