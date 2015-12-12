package ua.org.oa.podkopayv.zmarket3.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.org.oa.podkopayv.zmarket3.dto.ProductDTO;
import ua.org.oa.podkopayv.zmarket3.repository.CategoryRepository;

import java.util.HashMap;
import java.util.Map;

@Component
public class Cart {

    @Qualifier("categoryRepository")
    @Autowired
    private CategoryRepository categoryRepository;

    private Map<Product, Integer> items = new HashMap<>();

    public Cart() {
    }

    public void putInCart(ProductDTO dto) {
        System.out.println("cart dto = " + dto);
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(categoryRepository.getByTitle(dto.getCategory()));

        if (items.containsKey(product)) {
            items.put(product, items.get(product) + 1);
        } else {
            items.put(product, 1);
        }
    }

    public boolean deleteFromCart(long itemId) {
        boolean result = false;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            if (entry.getKey().getId() == itemId) {
                items.remove(entry.getKey());
                result = true;
            }
        }
        return result;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public int totalAmount() {
        int totalAmount = 0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            totalAmount += entry.getKey().getPrice() * entry.getValue();
        }
        return totalAmount;
    }
}
