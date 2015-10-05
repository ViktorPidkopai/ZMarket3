package ua.org.oa.podkopayv.zmarket3.main;

import ua.org.oa.podkopayv.zmarket3.entity.Pet;
import ua.org.oa.podkopayv.zmarket3.repository.PetRepository;
import ua.org.oa.podkopayv.zmarket3.repository.StorageRepositories;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PetRepository petRepository = StorageRepositories.getInstance().getPetRepository();

        System.out.println("----------------");

        List<Pet> pets = petRepository.getAll();

        if (pets.isEmpty()) {
            System.out.println("Empty result.");
        } else {
            for (Pet pet : pets) {
                System.out.println(pet);
            }
        }


    }

//        System.out.println(petRepository.getById(2L));
}

