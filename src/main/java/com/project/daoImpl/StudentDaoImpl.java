package com.project.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.StudentDao;
import com.project.entity.Student;
import com.project.utility.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public boolean addStudent(Student student) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();

		try {
			System.out.println(student);
			int pk = (int) session.save(student);
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
	public boolean deletStudent(int studentId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			Student student = session.get(Student.class, studentId);
			session.delete(student);
			transaction.commit();
			Student removed = session.get(Student.class, studentId);

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
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	// not correct;

	@Override
	public List<Student> showAllStudent() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		session = sessionFactory.openSession();
		String hql = "from Student";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Student> students = query.getResultList();

		return students;
	}

	@Override
	public boolean searchStudent(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			String hql = "FROM Student WHERE user_id = :user_id";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", userId);

			try {
				Student student = (Student) query.getSingleResult();

				return student != null;
			} catch (Exception e) {
				return false;
			}

		} catch (

		Exception e) {
			transaction.rollback();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public Student getStudent(int studentId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Student student = null;
		session = sessionFactory.openSession();
		try {

			String hql = "FROM Student WHERE student_id = :studentid";
			Query query = session.createQuery(hql);
			query.setParameter("studentid", studentId);

			try {
				student = (Student) query.getSingleResult();

				if (student != null) {
					return student;
				}
			} catch (Exception e) {
				System.out.println("student not found :");
				return null;
			}

		} catch (

		Exception e) {
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public Student getStudentUsingUserId(int userId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Student student = null;
		session = sessionFactory.openSession();
		try {

			String hql = "FROM Student WHERE user_id = :userid";
			Query query = session.createQuery(hql);
			query.setParameter("userid", userId);

			try {
				student = (Student) query.getSingleResult();

				if (student != null) {
					return student;
				}
			} catch (Exception e) {
				System.out.println("student not found :");
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
