package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ua.org.oa.podkopayv.zmarket3.model.Pet;

import java.util.List;

@Repository("petRepositoryImpl")
public class PetRepositoryImpl implements PetRepository {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    public PetRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PetRepositoryImpl() {
    }

    @Override
    public void create(Pet item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
    }

    @Override
    public void update(Pet item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
    }

    @Override
    public void delete(Pet item) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
    }

    @Override
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

    @Override
    public List<Pet> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Pet";
        Query query = session.createQuery(hql);
        List<Pet> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public List<Pet> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Pet> result = session.createCriteria(Pet.class).add(Restrictions.like("name", "%" + name + "%")).list();
        session.getTransaction().commit();
        return result;
    }

    @Override
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