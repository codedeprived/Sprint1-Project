package com.project.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.UserDao;
import com.project.entity.User;
import com.project.utility.HibernateUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean addUser(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			int pk = (int) session.save(user);
			transaction.commit();
			if (pk != 0) {
				return true;
			}

		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return false;

	}

	@Override
	public boolean deleteUser(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			User user = session.get(User.class, userId);
			session.delete(user);
			transaction.commit();
			User removed = session.get(User.class, userId);

			if (removed == null) {
				return true;
			}

		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateUser(int userID, User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			User prevUser = session.get(User.class, userID);

			prevUser.setEmail(user.getEmail());
			prevUser.setPassword(user.getPassword());
			prevUser.setUsername(user.getUsername());

			session.update(prevUser);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			System.out.println("Error retrieving user with userId " + userID);
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public List<User> showAllUser() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		session = sessionFactory.openSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> users = query.getResultList();

		return users;
	}

	@Override
	public boolean searchUser(String email) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			String hql = "FROM User WHERE email = :Email";
			Query query = session.createQuery(hql);
			query.setParameter("Email", email);

			try {
				User user = (User) query.getSingleResult();

				return user != null;
			} catch (Exception e) {
				return false;
			}

		} catch (Exception e) {
			transaction.rollback();
			return false;
		} finally {
			session.close();
		}
	}

	@Override
	public User getUser(String email) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		User user = null;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			String hql = "FROM User WHERE email = :Email";
			Query query = session.createQuery(hql);
			query.setParameter("Email", email);

			try {
				user = (User) query.getSingleResult();
				System.out.println(user);
				return user;
			} catch (Exception e) {
				System.out.println("No user found with email: " + email);
			}

			transaction.commit();

		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user;
	}

	public User getUser(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

		try (Session session = sessionFactory.openSession()) {
			User user = session.get(User.class, userId);
			if (user != null) {
				return user;
			} else {
				System.out.println("No user found with userId " + userId);
			}
		} catch (Exception e) {
			System.out.println("Error retrieving user with userId " + userId);
			return null;
		}
		return null;
	}
}
