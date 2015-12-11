package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ua.org.oa.podkopayv.zmarket3.model.Order;

import java.util.List;

@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Order order) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
    }

    @Override
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        final String hql = "FROM Order O ORDER BY O.id";
        Query query = session.createQuery(hql);
        List<Order> result = query.list();
        session.getTransaction().commit();
        return result;
    }
}
