package com.revature.lostchapterbackend.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.lostchapterbackend.dto.SignUpDto;
import com.revature.lostchapterbackend.model.Cart;
import com.revature.lostchapterbackend.model.User;

@Repository
public class UserDao {

	@PersistenceContext
	private EntityManager em;

	private Logger logger = LoggerFactory.getLogger(UserDao.class);

	// Sign up method
	@Transactional
	public User addUser(SignUpDto dto, Cart c) {
		User createdUser = new User(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(),
			 dto.getEmail(), dto.getBirthday(), dto.getRole());

		em.persist(createdUser);

		c = new Cart();
		c.setUser(createdUser);
		em.persist(c);
		return createdUser;
	}

	// Login method
	@Transactional
	public User getUser(String username, String password) {
		logger.info("UserDao.getUser() invoked");

		User user = em.createQuery("FROM Users u WHERE u.username = :username AND u.password = :password", User.class)
				.setParameter("username", username).setParameter("password", password).getSingleResult();

		return user;
	}

	@Transactional
	public User getUser(String username) {
		logger.info("UserDao.getUser() invoked");

		try {

			User user = em.createQuery("FROM Users u WHERE u.username = :username", User.class)
					.setParameter("username", username).getSingleResult();

			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	// Delete User method
	@Transactional
	public void deleteUserById(int id) {
		User user = em.find(User.class, id);
		Cart cart = em.find(Cart.class, id);
		
		em.remove(user);
		em.remove(cart);
	}

	// Getting a user by email
	@Transactional
	public User getUserByEmail(String email) {
		logger.info("UserDao.getUserByEmail() invoked");

		try {
			User user = em.createQuery("FROM Users u WHERE u.email = :email", User.class).setParameter("email", email)
					.getSingleResult();

			return user;
		} catch (DataAccessException e) {

			e.printStackTrace();
			throw new NoResultException("Email cannot be blank");
		} catch (NoResultException e) {
			return null;
		}

	}

	// Updating a user's information
	@Transactional
	public User updateUser(int id, User updatedUserInfo) {
		Session session = em.unwrap(Session.class);

		User currentlyLoggedInUser = session.find(User.class, id);
		currentlyLoggedInUser = updatedUserInfo;

		session.merge(currentlyLoggedInUser);

		return currentlyLoggedInUser;
	}

}
