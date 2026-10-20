package com.trainingspring.springormtraining.product;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @PostMapping("/find/{name}/{price}")
    public String CreateProduct(@PathVariable("name") String productName,@PathVariable(name = "price") Double salesPrice) {
        UUID productId = UUID.randomUUID();
        Product product = new Product(productId, productName, salesPrice);

        productRepository.save(product);

        return productId.toString();

    }

    @PutMapping("/update/{id}/{name}/{price}")
    public String UpdateProduct(@PathVariable("id") String productId, @PathVariable("name") String productName
    , @PathVariable(name = "price") double salesPrice) {

        UUID uuid = UUID.fromString(productId);
        Optional<Product> optional = productRepository.findById(uuid);

        if (optional.isPresent()) {
            Product product = optional.get();
            productRepository.save(product);
        }
        else  {
            return "Product not found" + productId;

        }
        return productId;
    }


    @DeleteMapping("/delete/{name}/{price}")
    public String DeleteProduct(@PathVariable("id") String productId) {
        UUID uuid = UUID.fromString(productId);

        productRepository.deleteById(uuid);
        return "Product deleted" + productId;


    }


    @GetMapping("find/{id}")
    public String FindProduct(@PathVariable("id") String productId) {

        UUID id = UUID.fromString(productId);
        Optional<Product> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get().toString();
        }
        else  {
            return "Product not found" + productId;
        }
    }

    @GetMapping("/list")
    public String listProducts() {

        StringBuilder builder = new StringBuilder();
        for(Product product : productRepository.findAll()) {
            builder.append(product.getProductid()).append("\n");
        }
        return "list of products " + builder.toString();
    }

}








