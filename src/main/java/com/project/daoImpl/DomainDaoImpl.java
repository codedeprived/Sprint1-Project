package com.project.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.dao.DomainDao;
import com.project.entity.Domain;
import com.project.utility.HibernateUtil;

public class DomainDaoImpl implements DomainDao {

	@Override
	public boolean addDomain(Domain domain) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			int pk = (int) session.save(domain);
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
	public boolean deleteDomain(int domainId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Transaction transaction = null;
		Session session = null;
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		try {

			Domain domain = session.get(Domain.class, domainId);
			session.delete(domain);
			transaction.commit();
			Domain removed = session.get(Domain.class, domainId);

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
	public List<Domain> showAllDomain() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;

		session = sessionFactory.openSession();

		String hql = "from Domain";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Domain> Domain = query.getResultList();

		return Domain;
	}

	@Override
	public Domain searchDomain(int domainId) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = null;
		Domain domain = null;
		try {

			session = sessionFactory.openSession();
			domain = (Domain) session.get(Domain.class, domainId);

			if (domain != null) {
				return domain;
			} else {
				System.out.println("Domain id Invalid ! Domain not Found!");
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return null;
	}

}
