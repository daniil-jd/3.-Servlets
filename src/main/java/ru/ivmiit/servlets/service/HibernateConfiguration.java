package ru.ivmiit.servlets.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Configure Hibernate from xml file
 */
public class HibernateConfiguration {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public HibernateConfiguration(){}

    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex){
            System.out.println("Initial SessionFactory creation failed...");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getFactory().close();
    }
}
