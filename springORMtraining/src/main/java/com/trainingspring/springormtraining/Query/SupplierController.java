package com.trainingspring.springormtraining.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    SupplierRepository supplierRepository;
    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/generate")
    public String generate(){
        int count = 100;
        for(int i = 0; i < count; i++){
            UUID uuid = UUID.randomUUID();
            Supplier supplier = new Supplier(
                    uuid, "Satıcı" + (i+1), 5000 + 250*i);

            supplierRepository.save(supplier);
        }

        return "Oluşturuldu" + count;
    }

    @GetMapping("/list")
    public String list(){

            StringBuilder builder = new StringBuilder();
            for(Supplier supplier : supplierRepository.findAll()){
                builder.append(supplier.getSupplierName())
                        .append("");
            }
            return builder.toString();
        }

    @GetMapping("/like")
    public String like(){

        StringBuilder builder = new StringBuilder();
        for(Supplier supplier : supplierRepository.findAllSuppliersLike()){
            builder.append(supplier.getSupplierName())
                    .append("br/");
        }
        return builder.toString();
    }

    @GetMapping("/min")
    public String min(){

        StringBuilder builder = new StringBuilder();
        for(Supplier supplier : supplierRepository.findSuppliersMin(12500)){
            builder.append(supplier.getSupplierName())
                    .append(supplier.getTotalDebit())
                    .append("br/");
        }
        return builder.toString();
    }

    @GetMapping("/min-average")
    public double avg(){

        double average = supplierRepository.findSuppliersAvg(50000);
        return average;
    }
}


