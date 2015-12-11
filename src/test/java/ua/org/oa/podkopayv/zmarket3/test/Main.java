package ua.org.oa.podkopayv.zmarket3.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.org.oa.podkopayv.zmarket3.model.Category;
import ua.org.oa.podkopayv.zmarket3.model.Order;
import ua.org.oa.podkopayv.zmarket3.model.Product;
import ua.org.oa.podkopayv.zmarket3.repository.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//        PetRepository petRepository = context.getBean("petRepository", PetRepository.class);
//        PetController petController = context.getBean("petController", PetController.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepositoryImpl.class);
        CategoryRepository categoryRepository = context.getBean("categoryRepository", CategoryRepositoryImpl.class);
        OrderRepository orderRepository = context.getBean("orderRepository", OrderRepositoryImpl.class);

//        System.out.println(petRepository);
//        System.out.println(petController);
//        System.out.println(productRepository);
        System.out.println(categoryRepository);

        List<Category> categories = categoryRepository.getAll();
        for (Category c : categories) {
            System.out.println(c);
        }

        String categoryTitle = "Pets";
        System.out.println("getByCategoryTitle(" + categoryTitle + ")");
        Category c = categoryRepository.getByTitle(categoryTitle);
        System.out.println(c);

        int categoryId = 1;
        System.out.println("getById(" + categoryId + ")");
        System.out.println(categoryRepository.getById(categoryId));

        Product newProduct = new Product();
        newProduct.setName("Zver");
        newProduct.setPrice(99999);
        newProduct.setCategory(categoryRepository.getById(1));

        productRepository.create(newProduct);


        List<Product> products = productRepository.getAll();
        for (Product p : products) {
            System.out.println(p);
        }

        Set<Product> productOrder = new HashSet<>();
        productOrder.add(productRepository.getById(1));
        productOrder.add(productRepository.getById(2));
        productOrder.add(productRepository.getById(3));

        Order order = new Order();
        order.setProducts(productOrder);

        orderRepository.create(order);
        System.out.println(orderRepository.getAll());

//        List<Pet> pets = petRepository.getAll();
//        for (Pet p : pets) {
//            System.out.println(p);
//        }

//        System.out.println("-----getAll-----------");
//
//        List<Pet> pets = petRepository.getAll();
//
//        if (pets.isEmpty()) {
//            System.out.println("Empty result.");
//        } else {
//            for (Pet pet : pets) {
//                System.out.println(pet);
//            }
//        }
//
//        System.out.println("-------getById---------");
//        System.out.println(petRepository.getById(1));
//        System.out.println(petRepository.getById(145));
//
//        System.out.println("-------getByName---------");
//        System.out.println(petRepository.getByName("Cat"));
//
//        System.out.println("-------getByPriceRange---------");
//        System.out.println(petRepository.getByPriceRange(15_000, 40_000));


    }

}