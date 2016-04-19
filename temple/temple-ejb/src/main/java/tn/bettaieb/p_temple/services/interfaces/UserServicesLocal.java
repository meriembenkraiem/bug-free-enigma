package tn.bettaieb.p_temple.services.interfaces;

import javax.ejb.Local;

import tn.bettaieb.p_temple.persistence.User;

@Local
public interface UserServicesLocal {
	Boolean addUser(User user);

	User findUserById(String id);

	User login(String email, String password);
}
