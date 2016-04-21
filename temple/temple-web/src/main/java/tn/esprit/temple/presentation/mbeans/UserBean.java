package tn.esprit.temple.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import tn.bettaieb.p_temple.persistence.Student;
import tn.bettaieb.p_temple.persistence.User;
import tn.bettaieb.p_temple.services.interfaces.UserServicesLocal;

@ManagedBean
public class UserBean {
	// injection du service
	@EJB
	private UserServicesLocal userServicesLocal;
	// Modele
	private User user = new User();

	// Methode

	public String doAddUser() {
		userServicesLocal.addUser(user);
		return "";
	}

	public String doLogin() {
		String navigateTo = "";
		User userLoggedIn = userServicesLocal.login(user.getEmail(),
				user.getPassword());
		if (userLoggedIn != null) {
			if (userLoggedIn instanceof Student) {
				user = userLoggedIn;
				navigateTo = "";
				System.out.println("stu");
			}

		} else {
			System.out.println("nooo");
		}
		return navigateTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
