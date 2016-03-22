package testProject;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote;

public class TestAssignProjectToUser {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectServicesRemote projectServicesRemote = (ProjectServicesRemote) context
				.lookup("p-temple-ear/p-temple-ejb/ProjectServices!tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote");

		System.out.println(projectServicesRemote.assignProjectToUser("ESP_123",
				"151JMT1343"));

	}

}
