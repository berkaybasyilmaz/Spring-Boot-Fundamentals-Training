package com.trainingspring.springresttraining.Controller;

import com.trainingspring.springresttraining.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class WritingController {

    @PostMapping("product ") // post yaratmak için, hiç olmayan bir parametreyi de yaratır koyar.
    public long postProduct(@RequestBody Product product) {
        System.out.println("post product" + product.getId() + " " + product.getName()  +
                " " + product.getPrice());
        product.setId(302);
        return product.getId();
    }


    @PutMapping("product ") // put güncelleme için.
    public void putProduct(@RequestBody Product product) {
        System.out.println("put product" + product.getId() + " " + product.getName()  +
                " " + product.getPrice());
    }

    @DeleteMapping("product{id}")
    public void deleteProduct(@PathVariable(name = "id") long productId) {
        System.out.println("Delete product" + productId);
    }





}
