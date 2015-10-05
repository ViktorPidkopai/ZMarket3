package ua.org.oa.podkopayv.zmarket3.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    static {
        try {
            String hibernatePropsFilePath = "C:\\Users\\Victor\\IdeaProjects\\ZMarket3\\src\\main\\java\\hibernate.cfg.xml";
            File hibernatePropsFile = new File(hibernatePropsFilePath);
            sessionFactory = new Configuration().configure(hibernatePropsFile).buildSessionFactory();
        } catch (Throwable e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    private HibernateUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
