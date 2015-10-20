package ua.org.oa.podkopayv.zmarket3.main;

import ua.org.oa.podkopayv.zmarket3.model.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;
import ua.org.oa.podkopayv.zmarket3.repository.StorageRepositories;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();

        System.out.println("-----getAll-----------");

        List<Pet> pets = petRepository.getAll();

        if (pets.isEmpty()) {
            System.out.println("Empty result.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }

        System.out.println("-------getById---------");
        System.out.println(petRepository.getById(1));
        System.out.println(petRepository.getById(2));

        System.out.println("-------getByName---------");
        System.out.println(petRepository.getByName("Cat"));

        System.out.println("-------getByPriceRange---------");
        System.out.println(petRepository.getByPriceRange(15_000, 40_000));

//        ApplicationContext context = new ClassPathXMLApplicationContext("spring-config.xml");
//        Pet obj = (Pet)context.get

    }

}