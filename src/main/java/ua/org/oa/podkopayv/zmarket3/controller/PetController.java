package ua.org.oa.podkopayv.zmarket3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.org.oa.podkopayv.zmarket3.model.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;
import ua.org.oa.podkopayv.zmarket3.repository.StorageRepositories;

import java.util.List;

@Controller
@RequestMapping(value = "/pet")
public class PetController {

//    @Autowired
//    private PetRepository petRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Pet> getAll() {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        List<Pet> result = petRepository.getAll();
        System.out.println("getAll() PetController");
        if (result.isEmpty()) {
            System.out.println("Empty result.");
        } else {
            for (Pet pet : result) {
                System.out.println(pet);
            }
        }
        return result;
    }

    @RequestMapping(value = "/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    Pet getById(@PathVariable("id") long id) {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        Pet result = petRepository.getById(id);
        System.out.println("@GET getById(" + id + "); pet = " + result);
        return result;
    }

    @RequestMapping(value = "/{min}/{max}", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Pet> getPriceRange(@PathVariable("min") int minPrice, @PathVariable("max") int maxPrice) {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        List<Pet> result = petRepository.getByPriceRange(minPrice, maxPrice);
        System.out.println("@GET getPriceRange(" + minPrice + ", " + maxPrice + ")");
        return result;
    }

    @RequestMapping(value = "/search/{name}", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Pet> getByName(@PathVariable("name") String name) {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        List<Pet> result = petRepository.getByName(name);
        System.out.println("@GET getByName() - OK; name = " + name);
        return result;
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public
    @ResponseBody
    Pet delete(@PathVariable("id") long id) {
        System.out.println("delete() method is work; id = " + id);
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        Pet pet = new Pet();
        pet.setId(id);
        petRepository.delete(pet);
        return pet;
    }

    @RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    Pet add(@RequestBody Pet pet) {
        System.out.println("add() method work; pet = " + pet);
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        petRepository.create(pet);
        return pet;
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    public
    @ResponseBody
    long update(@RequestBody Pet pet) {
        System.out.println("update() method work; pet = " + pet);
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        petRepository.update(pet);
        return pet.getId();
    }

}