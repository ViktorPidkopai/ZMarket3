package ua.org.oa.podkopayv.zmarket3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.oa.podkopayv.zmarket3.model.Cart;

@Controller
@RequestMapping("/cart")
public class CartService {

    private Cart cart = new Cart();

    @RequestMapping(consumes = "application/json", method = RequestMethod.POST)

    public
    @ResponseBody
    int putInCart(@RequestBody long[] id) {
        System.out.println("/cart id = " + id);
//        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
//        Pet item = petRepository.getById(id);
//        cart.putInCart(item);
        return id.length;
    }

}
