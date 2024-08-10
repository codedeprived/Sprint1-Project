package com.project.daoImpl;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.LoginDao;
import com.project.entity.Admin;
import com.project.entity.User;
import com.project.utility.HibernateUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean adminCheck(Admin admin) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			System.out.println("admin email " + admin.getEmail());
			System.out.println("admin email " + admin.getPassword());
			String hql = "FROM Admin WHERE email = :email AND password = :password";
			Query query = session.createQuery(hql);

			query.setParameter("email", admin.getEmail());
			query.setParameter("password", admin.getPassword());

			Admin result = (Admin) query.getSingleResult();
			if (result != null) {
				return true;
			}

		} catch (

		Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean userCheck(User user) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			System.out.println("user email " + user.getEmail());
			System.out.println("user password " + user.getPassword());
			String hql = "FROM User WHERE email = :email AND password = :password";
			Query query = session.createQuery(hql);

			query.setParameter("email", user.getEmail());
			query.setParameter("password", user.getPassword());

			User result = (User) query.getSingleResult();
			if (result != null) {
				return true;
			}

		} catch (

		Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return false;
	}

}
