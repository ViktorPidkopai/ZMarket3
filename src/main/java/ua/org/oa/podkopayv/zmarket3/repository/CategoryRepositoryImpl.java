package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ua.org.oa.podkopayv.zmarket3.model.Category;

import java.util.List;

@Repository("categoryRepository")
public class CategoryRepositoryImpl implements CategoryRepository {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Category category) {

    }

    @Override
    public void update(Category category) {

    }

    @Override
    public void delete(Category category) {

    }

    @Override
    public List<Category> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Category C GROUP BY C.id";
        Query query = session.createQuery(hql);
        List<Category> result = query.list();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public Category getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Category category = (Category) session.get(Category.class, id);
        session.getTransaction().commit();
        return category;
    }

    @Override
    public Category getByTitle(String title) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Category C WHERE C.title = :title";
        Query query = session.createQuery(hql).setString("title", title);
        Category result = (Category) query.list().get(0);
        session.getTransaction().commit();
        return result;
    }

}
