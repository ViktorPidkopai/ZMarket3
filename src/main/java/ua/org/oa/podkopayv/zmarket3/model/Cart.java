package ua.org.oa.podkopayv.zmarket3.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Pet, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void putInCart(Pet pet) {
        if (items.containsKey(pet)) {
            items.put(pet, items.get(pet) + 1);
            System.out.println(items.size() + "  _2");
        } else {
            items.put(pet, 1);
            System.out.println(items.size() + "  _3");
        }
    }

    public boolean deleteFromCart(long itemId) {
        boolean result = false;
//        PetRepository pr = new PetRepositoryImpl();
//        Pet pet = pr.getById(itemId);
//        if(items.containsKey(pet)){
//            items.remove(pet);
//            result = true;
//        }
        return result;
    }

    public Map<Pet, Integer> getItems() {
        return items;
    }

    public int totalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Pet, Integer> entry : items.entrySet()) {
            totalAmount += entry.getKey().getPrice() * entry.getValue();
        }
        return totalAmount;
    }
}
