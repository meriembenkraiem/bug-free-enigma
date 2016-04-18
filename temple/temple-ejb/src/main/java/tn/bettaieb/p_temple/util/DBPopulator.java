package tn.bettaieb.p_temple.util;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.bettaieb.p_temple.persistence.Project;
import tn.bettaieb.p_temple.persistence.Student;
import tn.bettaieb.p_temple.services.interfaces.ProjectServicesLocal;
import tn.bettaieb.p_temple.services.interfaces.UserServicesLocal;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	private UserServicesLocal userServicesLocal;
	@EJB
	private ProjectServicesLocal projectServicesLocal;

	public DBPopulator() {
	}

	@PostConstruct
	public void init() {
		Student student = new Student("133JFT1340", "meriam", "ben kraiem");
		Student student2 = new Student("134JFT1341", "zeineb", "salhi");
		Student student3 = new Student("150JMT1342", "mondher", "boubakker");
		Student student4 = new Student("151JMT1343", "weal", "nidhal");

		Project project = new Project("ESP_123", "windows server");
		Project project2 = new Project("ESP_456", "E_GOV");

		
		userServicesLocal.addUser(student);
		userServicesLocal.addUser(student2);
		userServicesLocal.addUser(student3);
		userServicesLocal.addUser(student4);
		
		projectServicesLocal.addProject(project);
		projectServicesLocal.addProject(project2);

	}
}
