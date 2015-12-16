package ua.org.oa.podkopayv.zmarket3.repository;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ua.org.oa.podkopayv.zmarket3.model.Category;
import ua.org.oa.podkopayv.zmarket3.model.Product;

import java.util.List;

@Repository("productRepository")
public class ProductRepositoryImpl implements ProductRepository {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.save(product);
    }

    @Override
    public void update(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);
    }

    @Override
    public Product getById(long id) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Product P WHERE P.id = :productId";
        Query query = session.createQuery(hql);
        query.setParameter("productId", id);
        Product product = (Product) query.list().get(0);
        return product;
    }

    @Override
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        List<Product> result = session.createCriteria(Product.class).list();
        return result;
    }

    @Override
    public List<Product> getByPriceRange(int minPrice, int maxPrice) {
        Session session = sessionFactory.getCurrentSession();
        final String hql = "FROM Product P WHERE P.price >= :minPrice AND P.price <= :maxPrice";
        Query query = session.createQuery(hql).setInteger("minPrice", minPrice).setInteger("maxPrice", maxPrice);
        List<Product> result = query.list();
        return result;
    }

    @Override
    public List<Product> getByCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        final String hql = "FROM Product P WHERE P.category = (FROM Category C WHERE C.title = :title)";
        Query query = session.createQuery(hql).setString("title", category.getTitle());
        List<Product> result = query.list();
        return result;
    }

    @Override
    public List<Product> getByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        List<Product> result = session.createCriteria(Product.class).add(Restrictions.like("name", "%" + name + "%")).list();
        return result;
    }

    @Override
    public List<String> getCategories() {
        Session session = sessionFactory.getCurrentSession();
        final String hql = "SELECT C.title FROM Category C GROUP BY C.id";
        Query query = session.createQuery(hql);
        List<String> result = query.list();
        return result;
    }

}
