package tn.bettaieb.p_temple.services.interfaces;

import javax.ejb.Remote;

import tn.bettaieb.p_temple.persistence.User;

@Remote
public interface UserServicesRemote {
	Boolean addUser(User user);

	User findUserById(String id);

	User login(String email, String password);

	Boolean updateUser(User user);
}
