package com.trainingspring.springormtraining.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OptionalController  {

    ProductRepository productRepository;

    public OptionalController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("find/{id}") // çok daha modern kullanım
    public String FindProduct(@PathVariable("id") String productId) {

        UUID uuid = UUID.fromString(productId);

       return  productRepository.findById(uuid)
               .map(product -> "Ürün " + product.getProductid())
               .orElse("Ürün bulunamadı : " + productId);


    }
}
