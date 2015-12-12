package ua.org.oa.podkopayv.zmarket3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.org.oa.podkopayv.zmarket3.dto.ProductDTO;
import ua.org.oa.podkopayv.zmarket3.service.ProductService;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public
    @ResponseBody
    void create(@RequestBody ProductDTO dto) {
        System.out.println("product controller add() product = " + dto);
        productService.create(dto);
    }

    @RequestMapping(value = "/{id}", produces = "application/json", method = RequestMethod.DELETE)
    public
    @ResponseBody
    void delete(@PathVariable("id") long id) {
        System.out.println("productController delete(" + id + ")");
        productService.delete(id);
    }

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProductDTO> getAll() {
        System.out.println("productController getAll()");
        return productService.getAll();
    }

    @RequestMapping(value = "category/{category}", produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProductDTO> getByCategory(@PathVariable("category") String categoryTitle) {
        System.out.println("productController getByCategory(" + categoryTitle + ")");
        return productService.getByCategoryTitle(categoryTitle);
    }

    @RequestMapping(value = "/search/{name}", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProductDTO> getByName(@PathVariable("name") String name) {
        System.out.println("productController getByName(" + name + ")");
        return productService.getByName(name);
    }

    @RequestMapping(value = "/{id}", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    ProductDTO getById(@PathVariable("id") long id) {
        ProductDTO result = productService.getById(id);
        System.out.println("productController getId(" + id + ") = " + result);
        return result;
    }

    @RequestMapping(value = "/{min}/{max}", produces = "application/json", consumes = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<ProductDTO> getPriceRange(@PathVariable("min") int minPrice, @PathVariable("max") int maxPrice) {
        System.out.println("productController getByPriceRange(" + minPrice + ", " + maxPrice + ")");
        return productService.getByPriceRange(minPrice, maxPrice);
    }

    @RequestMapping(consumes = "application/json", method = RequestMethod.PUT)
    public
    @ResponseBody
    void update(@RequestBody ProductDTO dto) {
        System.out.println("productController update() product = " + dto);
        productService.update(dto);
    }

}
