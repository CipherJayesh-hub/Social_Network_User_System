package com.util;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

        private static final SessionFactory sessionFactory;

        static{
            try{
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                sessionFactory = configuration.buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to create SessionFactory");
            }
        }
        // Method to get SessionFactory
        public static SessionFactory getSessionFactory() {
            return sessionFactory;
    }
}
