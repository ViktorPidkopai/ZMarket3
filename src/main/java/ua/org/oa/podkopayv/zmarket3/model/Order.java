package ua.org.oa.podkopayv.zmarket3.model;

import java.util.HashMap;
import java.util.Map;

//@Entity
//@Table(name = "orders")
public class Order {

//    @Id
//    @Column(name = "id")
    private long id;


    private Map orderItem = new HashMap<>();

    public Order() {
    }
}
