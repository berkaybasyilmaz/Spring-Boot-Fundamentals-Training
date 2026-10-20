package com.trainingspring.springresttraining.Controller;

import com.trainingspring.springresttraining.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/product")
     public Product getProduct() {
        // Spring boot nesneyi otomatik olarak JSON olarak gönderir. ( eğer string int vb. çevirmezseniz )
         return new Product(301, "Mobile Phone", 145344);

     }

    @GetMapping("/products")
    public List<Product> getProducts() {

         List<Product> products = new ArrayList<>();

         products.add(new Product(301, "Mobile Phone", 45344));
         products.add(new Product(302, "Desktop Computer", 185344));
         products.add(new Product(303, "Laptop", 125344));
         return products;

    }

}
