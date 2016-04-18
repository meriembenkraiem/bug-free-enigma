package tn.bettaieb.p_temple.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.bettaieb.p_temple.persistence.User;
import tn.bettaieb.p_temple.services.interfaces.UserServicesLocal;
import tn.bettaieb.p_temple.services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean addUser(User user) {
		Boolean b = false;
		try {
			entityManager.persist(user);
			b = true;
		} catch (Exception e) {
		}
		return b;
	}

	@Override
	public User findUserById(String id) {
		return entityManager.find(User.class, id);
	}

}
