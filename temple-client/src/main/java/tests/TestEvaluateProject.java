package tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote;

public class TestEvaluateProject {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		ProjectServicesRemote projectServicesRemote = (ProjectServicesRemote) context
				.lookup("temple-ear/temple-ejb/ProjectServices!tn.bettaieb.p_temple.services.interfaces.ProjectServicesRemote");

		System.out.println(projectServicesRemote.evaluate("ESP_456",
				"134JFT1340", 3));
	}
}
