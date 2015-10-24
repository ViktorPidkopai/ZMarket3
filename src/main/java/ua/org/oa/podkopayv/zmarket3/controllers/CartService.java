package ua.org.oa.podkopayv.zmarket3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.oa.podkopayv.zmarket3.model.Cart;

import java.util.Map;

@Controller
@RequestMapping("/cart")
//@Scope("session")
public class CartService {

    private Cart cart = new Cart();

//    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)
//    public
//    @ResponseBody
//    int putInCart(@RequestBody long[] id) {
//        System.out.println("/cart id = " + id);
////        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
////        Pet item = petRepository.getById(id);
////        cart.putInCart(item);
//        return id.length;
//    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    long putInCart(@RequestBody long id) {
        cart.putInCart(id);
        return id;
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<Long, Integer> getAll() {
        System.out.println("getAll() items in cart");
        return cart.getItems();
    }

}
