package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

public class StorageRepositories {

    private PetRepository petRepository;

    private StorageRepositories() {
        SessionFactory sessionFactory;

        try {
            String hibernateCfgFilePath = "C:\\Users\\Victor\\IdeaProjects\\ZMarket3\\src\\main\\java\\hibernate.cfg.xml";
            File hibernateCfgFile = new File(hibernateCfgFilePath);
            sessionFactory = new Configuration().configure(hibernateCfgFile).buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        this.petRepository = new PetRepository(sessionFactory);
    }

    public static StorageRepositories getInstance() {
        return Holder.INSTANCE;
    }

    public PetRepository getPetRepository() {
        return petRepository;
    }

    private static class Holder {
        private static final StorageRepositories INSTANCE = new StorageRepositories();
    }
}