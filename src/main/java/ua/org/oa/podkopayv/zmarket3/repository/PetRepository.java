package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.org.oa.podkopayv.zmarket3.entity.Pet;

import java.util.List;

public class PetRepository {

    private final SessionFactory sessionFactory;

    public PetRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void create(Pet item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }

    public void update(Pet item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
    }

    public void delete(Pet item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
    }

    public Pet getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM pets P WHERE P.id = " + id;
        Query query = session.createQuery(hql);
        Pet pet = session.load(Pet.class, id);
        session.getTransaction().commit();
        return pet;
    }

    public List<Pet> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//        String hql = "FROM pets";
//        Query query = session.createQuery(hql);
//        List<Pet> petsList = query.list();
        List<Pet> petsList = session.createCriteria(Pet.class).list();
        session.getTransaction().commit();
        System.out.println("getAll() method work.");
        return petsList;
    }

}
