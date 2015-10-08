package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.org.oa.podkopayv.zmarket3.model.Pet;

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
        String hql = "FROM Pet P WHERE P.id = :petId";
        Query query = session.createQuery(hql);
        query.setParameter("petId", id);
        Pet pet = (Pet) query.list().get(0);
        session.getTransaction().commit();
        return pet;
    }

    public List<Pet> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Pet";
        Query query = session.createQuery(hql);
        List<Pet> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    public List<Pet> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Pet P WHERE P.name LIKE :name";
        Query query = session.createQuery(hql).setString("name", name);
        List<Pet> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    public List<Pet> getByPriceRange(int minPrice, int maxPrice) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Pet P WHERE P.price >= :minPrice AND P.price <= :maxPrice";
        Query query = session.createQuery(hql).setInteger("minPrice", minPrice).setInteger("maxPrice", maxPrice);
        List<Pet> result = query.list();
        session.getTransaction().commit();
        return result;
    }


}