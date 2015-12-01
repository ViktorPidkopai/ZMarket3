package ua.org.oa.podkopayv.zmarket3.repository;

import ua.org.oa.podkopayv.zmarket3.model.Pet;

import java.util.List;

/**
 * Created by Victor on 01.12.2015.
 */
public interface PetRepository {
    void create(Pet item);

    void update(Pet item);

    void delete(Pet item);

    Pet getById(long id);

    List<Pet> getAll();

    List<Pet> getByName(String name);

    List<Pet> getByPriceRange(int minPrice, int maxPrice);
}
