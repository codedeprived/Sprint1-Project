package com.project.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.TutorDao;
import com.project.entity.Tutor;
import com.project.utility.HibernateUtil;

public class TutorDaoImpl implements TutorDao {

	@Override
	public boolean addTutor(Tutor tutor) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {
			System.out.println(tutor);
			int pk = (int) session.save(tutor);
			transaction.commit();
			if (pk != 0) {
				return true;
			}

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteTutor(int tutorId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			Tutor tutor = session.get(Tutor.class, tutorId);
			session.delete(tutor);
			transaction.commit();
			Tutor removed = session.get(Tutor.class, tutorId);

			if (removed == null) {
				return true;
			}

		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateTutorDetials(Tutor tutor) {

		return false;
	}

	@Override
	public List<Tutor> showallTutors() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		session = sessionFactory.openSession();
		String hql = "from Tutor";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Tutor> tutors = query.getResultList();

		return tutors;
	}

	@Override
	public boolean searchUser(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			String hql = "FROM Tutor WHERE user_id = :user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", userId);

			try {
				Tutor tutor = (Tutor) query.getSingleResult();

				return tutor != null;
			} catch (Exception e) {
				return false;
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
	public Tutor getTutor(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Tutor tutor = null;
		session = sessionFactory.openSession();
		try {

			String hql = "FROM Tutor WHERE user_id = :user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", userId);

			try {
				tutor = (Tutor) query.getSingleResult();
				System.out.println(tutor);
				return tutor;

			} catch (Exception e) {
				System.out.println("Tutor not found :");
				return null;
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Tutor getTutorUsingTutorId(int tutorId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Tutor tutor = null;
		session = sessionFactory.openSession();
		try {

			String hql = "FROM Tutor WHERE tutor_id = :tutor_id";
			Query query = session.createQuery(hql);
			query.setParameter("tutor_id", tutorId);

			try {
				tutor = (Tutor) query.getSingleResult();
				return tutor;

			} catch (Exception e) {
				System.out.println("Tutor not found :");
				return null;
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
