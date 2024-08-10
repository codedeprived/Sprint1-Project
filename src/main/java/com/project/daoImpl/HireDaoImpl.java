package com.project.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.HireDao;
import com.project.dto.Hire;
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
			int pk = (int) session.save(hire);
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
	public boolean hireCancelation(int hireId) {
		// TODO Auto-generated method stub
		return false;
	}

}
