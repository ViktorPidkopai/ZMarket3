package ua.org.oa.podkopayv.zmarket3.repository;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.podkopayv.zmarket3.model.Category;
import ua.org.oa.podkopayv.zmarket3.model.Product;

import java.util.ArrayList;
import java.util.List;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void create(Product product) {
        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
        session.save(product);
//        session.getTransaction().commit();
    }

    @Transactional
    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
//        session.beginTransaction();
        session.update(product);
//        session.getTransaction().commit();
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
    }

    @Override
//    @Transactional(readOnly = true)
    public Product getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Product P WHERE P.id = :productId";
        Query query = session.createQuery(hql);
        query.setParameter("productId", id);
        Product product = (Product) query.list().get(0);
        session.getTransaction().commit();
        return product;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
//        final String hql = "FROM Product";
//        Query query = session.createQuery(hql);
//        List<Product> result = query.list();
        List<Product> result = session.createCriteria(Product.class).list();
        session.getTransaction().commit();
        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByPriceRange(int minPrice, int maxPrice) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Product P WHERE P.price >= :minPrice AND P.price <= :maxPrice";
        Query query = session.createQuery(hql).setInteger("minPrice", minPrice).setInteger("maxPrice", maxPrice);
        List<Product> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Product P WHERE P.category = (FROM Category C WHERE C.title = :title)";
        Query query = session.createQuery(hql).setString("title", category.getTitle());
        List<Product> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<Product> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Product P WHERE P.name LIKE :name";
        Query query = session.createQuery(hql).setString("name", name);
        List<Product> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    @Override
//    @Transactional(readOnly = true)
    public List<String> getCategories() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "SELECT C.title FROM Category C GROUP BY C.id";
        Query query = session.createQuery(hql);
        List<String> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    private List<Product> unproxy(List<Product> products, Session session) {
        List<Product> result = new ArrayList<Product>();
        for (Product p : products) {
            Object unproxied = ((SessionImplementor) session).getPersistenceContext().unproxy(p);
            result.add((Product) unproxied);
        }
        return result;
    }
}
