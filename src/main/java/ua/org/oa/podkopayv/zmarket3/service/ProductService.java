package ua.org.oa.podkopayv.zmarket3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.org.oa.podkopayv.zmarket3.dto.ProductDTO;
import ua.org.oa.podkopayv.zmarket3.model.Product;
import ua.org.oa.podkopayv.zmarket3.repository.CategoryRepository;
import ua.org.oa.podkopayv.zmarket3.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductDTO> getAll() {
        System.out.println("productService getAll()");

        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getAll();
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        return result;
    }

    public List<ProductDTO> getByCategoryTitle(String title) {
        System.out.println("productService getByCategory(" + title + ")");
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getByCategory(categoryRepository.getByTitle(title));
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        return result;
    }

    public List<ProductDTO> getByName(String name) {
        System.out.println("productService getByName(" + name + ")");
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getByName(name);
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        return result;
    }

    public List<ProductDTO> getByPriceRange(int minPrice, int maxPrice) {
        List<ProductDTO> result = new ArrayList<>();
        List<Product> products = productRepository.getByPriceRange(minPrice, maxPrice);
        products.stream().forEach(p -> result.add(new ProductDTO(p)));
        return result;
    }

    public void delete(long id) {
        Product p = new Product();
        p.setId(id);
        productRepository.delete(p);
    }

    public void create(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setCategory(categoryRepository.getByTitle(dto.getCategory()));
        productRepository.create(product);
    }
}
