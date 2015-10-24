package ua.org.oa.podkopayv.zmarket3.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Long, Integer> items = new HashMap<Long, Integer>();
    private int totalAmount;

    public Cart() {
    }

    public void putInCart(long id) {
        if (items.containsKey(id)) {
            items.put(id, items.get(id) + 1);
            System.out.println(items.size() + "  _2");
        } else {
            items.put(id, 1);
            System.out.println(items.size() + "  _3");
        }
    }

    public void deleteFromCart(long itemId) {
        //TODO
    }

    public Map<Long, Integer> getItems() {
        return items;
    }

}
