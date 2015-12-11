package ua.org.oa.podkopayv.zmarket3.repository;

import ua.org.oa.podkopayv.zmarket3.model.Order;

import java.util.List;

public interface OrderRepository {
    void create(Order order);

    List<Order> getAll();
}
