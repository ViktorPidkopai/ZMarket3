package ua.org.oa.podkopayv.zmarket3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ua.org.oa.podkopayv.zmarket3.model.Product;
import ua.org.oa.podkopayv.zmarket3.repository.ProductRepository;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    //    @Qualifier("productRepository")
//    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(produces = "application/json", method = RequestMethod.GET)
    public
    @ResponseBody
    List<Product> getAll() {
        List<Product> result = productRepository.getAll();
        System.out.println("getAll() method is work.");
        if (result.isEmpty()) {
            System.out.println("Empty result.");
        } else {
            for (Product p : result) {
                System.out.println(p);
            }
        }
        return result;
    }


}
