package com.project.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory SF = null;

	public static SessionFactory getSessionFactory() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SF = cfg.buildSessionFactory();
		return SF;

	}

	public static void main(String[] args) {

		SessionFactory SF = getSessionFactory();

		if (SF != null) {
			System.out.println("Session Created ..");
		} else {
			System.out.println("something went wrong ...");
		}
	}
}
