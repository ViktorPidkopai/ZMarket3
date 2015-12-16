package ua.org.oa.podkopayv.zmarket3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.podkopayv.zmarket3.model.Category;
import ua.org.oa.podkopayv.zmarket3.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> getAll() {
        List<Category> result = categoryRepository.getAll();
        result.stream().forEach(r -> r.setProducts(null));
        return result;
    }
}
