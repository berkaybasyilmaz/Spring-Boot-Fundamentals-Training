package com.trainingspring.springormtraining.derived;

import com.trainingspring.springormtraining.Query.Supplier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/derived")
public class DerivedController {

    DerivedRepository derivedRepository;
    public DerivedController(DerivedRepository derivedRepository) {
        this.derivedRepository = derivedRepository;
    }


    @GetMapping("/name")
    public List<Supplier> getByName(String name){

        // return derivedRepository.findBySupplierName("Satıcı 43");

        // return derivedRepository.findBySupplierNameStartingWith("Satıcı%5");

        // return derivedRepository.findBySupplierNameEndingWith("6");

        return derivedRepository.findByTotalDebitGreaterThan(50);

    }

    @GetMapping("/debit")
    public List<Supplier> getByTotalDebit(double totalDebit){

        return derivedRepository.findByTotalDebitBetween(1000, 20000);

    }


}
