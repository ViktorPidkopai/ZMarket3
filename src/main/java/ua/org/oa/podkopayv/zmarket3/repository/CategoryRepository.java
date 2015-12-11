package ua.org.oa.podkopayv.zmarket3.repository;

import ua.org.oa.podkopayv.zmarket3.model.Category;

import java.util.List;

public interface CategoryRepository {

    void create(Category category);

    void update(Category category);

    void delete(Category category);

    List<Category> getAll();

    Category getById(int id);

    Category getByTitle(String title);

}
