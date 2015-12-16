package ua.org.oa.podkopayv.zmarket3.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.podkopayv.zmarket3.model.Category;
import ua.org.oa.podkopayv.zmarket3.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private static final Logger log = Logger.getLogger(ProductService.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<Category> getAll() {
        List<Category> result = categoryRepository.getAll();
        result.stream().forEach(r -> r.setProducts(null));
        log.info("getAll() category");
        return result;
    }
}
