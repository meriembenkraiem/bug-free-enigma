package tn.bettaieb.p_temple.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public User login(String email, String password) {
		User userFound = null;
		String jpql = "select u from User u where u.email=:param1 and u.password=:param2";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("param1", email);
		query.setParameter("param2", password);
		try {
			userFound = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("user not found");
		}

		return userFound;
	}
}
