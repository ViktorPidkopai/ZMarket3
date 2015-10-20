package ua.org.oa.podkopayv.zmarket3.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.oa.podkopayv.zmarket3.model.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;
import ua.org.oa.podkopayv.zmarket3.repository.StorageRepositories;

import java.util.List;

@Controller
@RequestMapping("/pet")
public class PetService {

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Pet> getAll() {
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
        return pets;
    }

//       @GET
//    @Path("{id}")
//    @Produces("application/json")
//    public Response getById(@PathParam("id") long id) {
//        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
//        Pet result = petRepository.getById(id);
//        System.out.println("@GET getById(" + id + "); pet = " + result);
//        return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
//    }
//
//    @GET
//    @Path("/itemsList/{list}")
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response getByIdList(@QueryParam("list") List<String> list) {
//        for (int i = 0; i < list.size(); ++i) {
//            System.out.println(list.get(i));
//        }
//        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
//        return Response.ok(petRepository.getAll(), MediaType.APPLICATION_JSON_TYPE).build();
//    }
//
//    @DELETE
//    @Path("{id}")
//    @Produces("application/json")
//    public Response delete(@PathParam("id") long id) {
//        System.out.println("delete() method is work; id = " + id);
//        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
//        Pet pet = new Pet();
//        pet.setId(id);
//        petRepository.delete(pet);
//        return Response.ok(petRepository.getAll(),
//                MediaType.APPLICATION_JSON_TYPE).build();
//    }
//
//    @POST
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response add(Pet pet) {
//        System.out.println("add() method work; pet = " + pet);
//        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
//        petRepository.create(pet);
//        return Response.ok(petRepository.getAll(), MediaType.APPLICATION_JSON_TYPE).build();
//    }
//
//    @PUT
//    @Consumes("application/json")
//    @Produces("application/json")
//    public Response update(Pet pet) {
//        System.out.println("update() method work; pet = " + pet);
//        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
//        petRepository.update(pet);
//        return Response.ok(petRepository.getAll(), MediaType.APPLICATION_JSON_TYPE).build();
//    }

}