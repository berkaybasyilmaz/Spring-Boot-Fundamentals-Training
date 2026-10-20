package com.trainingspring.client.receivables;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/client/receivables")
// Client controller class ımız, Application prpojemizdeki controller ( adresini verip )
// restTemplate ile oluşturma isteği atıyoruz. Daha sonrasında application projemiz
// attığımız bu isteği alıp işlemler yapacak.
public class ClientCustomerController {

    @GetMapping("/customer/create")
    public String createCustomer(){

        String url="http://localhost:8080/receivable/customer";
        RestTemplate restTemplate = new RestTemplate();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCustomerName("Orhan Gencebay");
        customerDto.setTotalDebit(1000.0);
        String customerId = restTemplate.postForObject(url,customerDto,String.class);
        return "Müşreti yaratıldı." + customerId;

    }

    @GetMapping("/find/create/{id}")
    public String getCustomer(@PathVariable("id") String customerId){

        String url="http://localhost:8080/receivable/customer/customerId";
        RestTemplate restTemplate = new RestTemplate();
        CustomerDto customerDto = restTemplate.getForObject(url,CustomerDto.class);
        return "Müşreti bulundu." + customerDto.getCustomerId() + " " + customerDto.getCustomerName() + customerDto.getAddress() +
                customerDto.getAddress().getProvinceName() + customerDto.getAddress().setDistrictName();

    }

}
