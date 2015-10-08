package ua.org.oa.podkopayv.zmarket3.service;

import ua.org.oa.podkopayv.zmarket3.model.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;
import ua.org.oa.podkopayv.zmarket3.repository.StorageRepositories;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pet")
public class PetService {


    @GET
    @Produces("application/json")
    public Response getAll() {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        List<Pet> pets = petRepository.getAll();
        System.out.println("getAll() method is work.");

        if (pets.isEmpty()) {
            System.out.println("Empty result.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }

        return Response.ok(pets, MediaType.APPLICATION_JSON_TYPE).build();
    }


    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        System.out.println("delete() method is work; id = " + id);
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        Pet pet = new Pet();
        pet.setId(id);
        petRepository.delete(pet);
        return Response.ok(petRepository.getAll(),
                MediaType.APPLICATION_JSON_TYPE).build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response add(Pet pet) {
        System.out.println("add() method work; pet = " + pet);
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        petRepository.create(pet);
        return Response.ok(petRepository.getAll(), MediaType.APPLICATION_JSON_TYPE).build();
    }

}