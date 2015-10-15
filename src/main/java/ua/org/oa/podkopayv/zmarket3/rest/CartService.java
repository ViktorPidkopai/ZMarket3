package ua.org.oa.podkopayv.zmarket3.rest;

import ua.org.oa.podkopayv.zmarket3.model.Cart;
import ua.org.oa.podkopayv.zmarket3.model.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;
import ua.org.oa.podkopayv.zmarket3.repository.StorageRepositories;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/cart")
public class CartService {

    private Cart cart = new Cart();

    @Path("{id}")
    @Produces("application/json")
    public Response putInCart(@PathParam("id") long id) {
        System.out.println("/cart id = " + id);
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        Pet item = petRepository.getById(id);
        cart.putInCart(item);
        return Response.ok().build();
    }

}
