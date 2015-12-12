package ua.org.oa.podkopayv.zmarket3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.org.oa.podkopayv.zmarket3.dto.ProductDTO;
import ua.org.oa.podkopayv.zmarket3.model.Cart;
import ua.org.oa.podkopayv.zmarket3.model.Order;
import ua.org.oa.podkopayv.zmarket3.model.Product;
import ua.org.oa.podkopayv.zmarket3.repository.OrderRepository;
import ua.org.oa.podkopayv.zmarket3.service.ProductService;

import java.util.*;

@Controller
@RequestMapping(value = "/cart")
@Scope("session")
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private Cart cart;

    @RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    void putInCart(@RequestBody long id) {
        ProductDTO product = productService.getById(id);
        cart.putInCart(product);
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProductDTO> getAll() {
        System.out.println("getAll() items in cart");
        Map<Product, Integer> items = cart.getItems();
        List<ProductDTO> result = new ArrayList<>();
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            result.add(new ProductDTO(entry.getKey()));
        }
        return result;
    }

    @RequestMapping(value = "/{id}",produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    int getTotalAmount(@PathVariable("id") long id) {
        System.out.println("total amount = " + cart.totalAmount());
        return cart.totalAmount();
    }

    @RequestMapping(value = "/{id}",produces = "application/json", method = RequestMethod.DELETE)
    public
    @ResponseBody
    boolean deleteById(@PathVariable("id") long id) {
        System.out.println("delete from cart item id = " + id);
        return cart.deleteFromCart(id);
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public
    @ResponseBody
    void order() {
        System.out.println("order...");
        Order order = new Order();
        Set<Product> itemsSet = new HashSet<>();
        Map<Product, Integer> itemsMap = cart.getItems();
        for (Map.Entry<Product, Integer> entry : itemsMap.entrySet()) {
            itemsSet.add(entry.getKey());
        }
        order.setProducts(itemsSet);
        orderRepository.create(order);
    }

}
