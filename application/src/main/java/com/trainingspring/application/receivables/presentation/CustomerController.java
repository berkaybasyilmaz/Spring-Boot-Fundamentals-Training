package com.trainingspring.application.receivables.presentation;

import com.trainingspring.application.receivables.business.CustomerDto;
import com.trainingspring.application.receivables.business.CustomerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receivable")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customer")
    public String createCustomer(@RequestBody CustomerDto customerDto) {

        return customerService.createCustomer(customerDto);

    }

    @GetMapping("/customer/{id}")
    public String getCustomer(@PathVariable("id") CustomerDto customerDto) {
        return customerService.getCustomer(customerDto);

    }
}
