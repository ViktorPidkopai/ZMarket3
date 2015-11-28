package ua.org.oa.podkopayv.zmarket3.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.org.oa.podkopayv.zmarket3.model.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();
        PetRepository petRepository = context.getBean("petRepository", PetRepository.class);

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
        System.out.println(petRepository.getById(145));

        System.out.println("-------getByName---------");
        System.out.println(petRepository.getByName("Cat"));

        System.out.println("-------getByPriceRange---------");
        System.out.println(petRepository.getByPriceRange(15_000, 40_000));

//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        Pet obj = (Pet)context.getBean()

    }

}