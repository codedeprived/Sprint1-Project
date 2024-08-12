package com.project.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.HireDao;
import com.project.entity.Hire;
import com.project.utility.HibernateUtil;

public class HireDaoImpl implements HireDao {

	@Override
	public boolean hireRequest(Hire hire) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		try {
			System.out.println(hire);
			session.saveOrUpdate(hire);
			Hire hired = session.get(Hire.class, hire.getHireId());
			transaction.commit();
			if (hired != null) {
				return true;
			}

		} catch (Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return false;

	}

	@Override
	public boolean hireCancelation(int studentId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		boolean isDeleted = false;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			String hql = "DELETE FROM Hire WHERE studentId = :studentId";
			Query query = session.createQuery(hql);
			query.setParameter("studentId", studentId);

			int result = query.executeUpdate();
			transaction.commit();

			if (result > 0) {
				isDeleted = true;
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isDeleted;
	}

	@Override
	public Hire getHireRequest(int tutorId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Hire hire = null;
		session = sessionFactory.openSession();
		try {
			String hql = "FROM Hire WHERE tutor_id = :tutorid";
			Query query = session.createQuery(hql);
			query.setParameter("tutorid", tutorId);

			List<Hire> results = query.getResultList();
			if (results.isEmpty()) {
				System.out.println("No records found for tutor_id = " + tutorId);
				return null;
			} else {
				hire = results.get(0);
				System.out.println(hire);
				return hire;
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public Hire getHireStatus(int studentId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Hire hire = null;
		session = sessionFactory.openSession();
		try {
			String hql = "FROM Hire WHERE student_id = :studentid";
			Query query = session.createQuery(hql);
			query.setParameter("studentid", studentId);

			List<Hire> results = query.getResultList();
			if (results.isEmpty()) {
				System.out.println("No records found for tutor_id = " + studentId);
				return null;
			} else {
				hire = results.get(0);
				return hire;
			}
		} catch (Exception e) {
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
