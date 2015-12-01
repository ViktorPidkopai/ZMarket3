package ua.org.oa.podkopayv.zmarket3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    private long id;


    private Map orderItem = new HashMap<>();

    public Order() {
    }
}
