package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StorageRepositories {

    private PetRepository petRepository;

    private StorageRepositories() {

        SessionFactory sessionFactory;

        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        this.petRepository = new PetRepositoryImpl(sessionFactory);
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