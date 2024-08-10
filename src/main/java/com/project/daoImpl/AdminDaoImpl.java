package com.project.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.AdminDao;
import com.project.entity.Admin;
import com.project.utility.HibernateUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean addAdmin(Admin admin) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			int pk = (int) session.save(admin);
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
	public boolean deleteAdmin(int adminId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			Admin admin = session.get(Admin.class, adminId);
			session.delete(admin);
			transaction.commit();
			Admin removed = session.get(Admin.class, adminId);

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
	public List<Admin> showAllAdmin() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;

		session = sessionFactory.openSession();

		String hql = "from Admin";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Admin> admins = query.getResultList();

		return admins;

	}

	@Override
	public Admin searchAdmin(int adminId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			Admin admin = session.get(Admin.class, adminId);
			return admin;

		} catch (

		Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return null;
	}

}
