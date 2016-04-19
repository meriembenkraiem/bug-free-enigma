package tn.bettaieb.p_temple.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.bettaieb.p_temple.persistence.Project;
import tn.bettaieb.p_temple.persistence.User;

@Remote
public interface ProjectServicesRemote {
	Boolean addProject(Project project);

	Boolean assignProjectToUser(String idProject, String idStudent);

	Project findProjectById(String idProject);

	List<Project> findProjectsByUserId(String idUser);

	List<User> findUsersByProjectId(String idProject);

	Boolean updateUsersThatUsedTheProject(String idUser, String idProject);

	Boolean evaluate(String idProject, String idUser, int evalValue);
}
