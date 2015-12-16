package ua.org.oa.podkopayv.zmarket3.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.podkopayv.zmarket3.model.Order;

import java.util.List;

@Repository("orderRepository")
public class OrderRepositoryImpl implements OrderRepository {

    @Qualifier("sessionFactory")
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void create(Order order) {
        sessionFactory.getCurrentSession().save(order);
        System.out.println("ORDER - OK");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAll() {
        Session session = sessionFactory.getCurrentSession();
        final String hql = "FROM Order O ORDER BY O.id";
        Query query = session.createQuery(hql);
        List<Order> result = query.list();
        return result;
    }
}
