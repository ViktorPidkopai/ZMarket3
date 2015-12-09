package ua.org.oa.podkopayv.zmarket3.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.org.oa.podkopayv.zmarket3.model.Cart;
import ua.org.oa.podkopayv.zmarket3.model.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;
import ua.org.oa.podkopayv.zmarket3.repository.StorageRepositories;

import java.util.Map;

@Controller
@RequestMapping(value = "/cart")
@Scope("session")
public class CartController {

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

    @RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    Pet putInCart(@RequestBody long id) {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        Pet pet = petRepository.getById(id);
        cart.putInCart(pet);
        return pet;
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<Pet, Integer> getAll() {
        System.out.println("getAll() items in cart");
        return cart.getItems();
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

}
