package testProject;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.bettaieb.p_temple.persistence.User;
import tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote;

public class TestFindUserByProjectId {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectServicesRemote projectServicesRemote = (ProjectServicesRemote) context.lookup(
				"p-temple-ear/p-temple-ejb/ProjectServices!tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote");

		System.out.println(projectServicesRemote.assignProjectToUser("ESP_123", "151JMT1343"));

		List<User> users = projectServicesRemote.findUsersByProjectId("ESP_123");

		for (User u : users) {
			System.out.println(u.getFirstName());
		}

	}

}
