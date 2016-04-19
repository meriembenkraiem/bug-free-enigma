package tn.esprit.temple.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.bettaieb.p_temple.persistence.Student;
import tn.bettaieb.p_temple.persistence.User;
import tn.bettaieb.p_temple.services.interfaces.UserServicesLocal;

@ManagedBean
@SessionScoped
public class UserBean {
	@EJB
	private UserServicesLocal userServicesLocal;
	private User user = new User();

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
