package ua.org.oa.podkopayv.zmarket3.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ua.org.oa.podkopayv.zmarket3.dto.ProductDTO;
import ua.org.oa.podkopayv.zmarket3.model.Product;
import ua.org.oa.podkopayv.zmarket3.repository.CategoryRepository;
import ua.org.oa.podkopayv.zmarket3.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ProductService {

    private static final Logger log = Logger.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> getAll() {
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getAll();
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        log.info("Get all products");
        return result;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getByCategoryTitle(String title) {
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getByCategory(categoryRepository.getByTitle(title));
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        return result;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getByName(String name) {
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getByName(name);
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        return result;
    }

    @Transactional(readOnly = true)
    public List<ProductDTO> getByPriceRange(int minPrice, int maxPrice) {
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getByPriceRange(minPrice, maxPrice);
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        return result;
    }

    @Transactional(readOnly = true)
    public ProductDTO getById(long id) {
        return new ProductDTO(productRepository.getById(id));
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void delete(long id) {
        Product p = new Product();
        p.setId(id);
        productRepository.delete(p);
        log.info("Delete product - " + p);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void create(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(categoryRepository.getByTitle(dto.getCategory()));
        productRepository.create(product);
        log.info("Create new product - " + product);
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void update(ProductDTO dto) {
        Product product = new Product();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setCategory(categoryRepository.getByTitle(dto.getCategory()));
        productRepository.update(product);
        log.info("Update product - " + product);
    }
}
