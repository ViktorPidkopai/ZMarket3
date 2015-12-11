package ua.org.oa.podkopayv.zmarket3.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private Set<Product> products = new HashSet<>(0);


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products.toString() +
                '}';
    }

}
