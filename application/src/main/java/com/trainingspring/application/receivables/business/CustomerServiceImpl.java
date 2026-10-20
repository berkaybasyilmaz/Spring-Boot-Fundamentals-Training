package com.trainingspring.application.receivables.business;

import com.trainingspring.application.receivables.client.AddressClient;
import com.trainingspring.application.receivables.client.AddressDto;
import com.trainingspring.application.receivables.data.Customer;
import com.trainingspring.application.receivables.data.CustomerRepository;
import org.springframework.stereotype.Service;


import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final AddressClient addressClient;

    public CustomerServiceImpl(CustomerRepository customerRepository, AddressClient addressClient) {
        this.customerRepository = customerRepository;
        this.addressClient = addressClient;
    }


    @Override
    public String createCustomer(CustomerDto customerDto) {
        Customer customer = toEntity(customerDto);
        customer.setCustomerId(UUID.randomUUID());

        // Entity deki DB değerlerimizi, DTO daki "gözükme" değerlerimizle set - get match lemesi yapıyoruz.
        // Bu sayede DB yi hiç görmeden repository miz ulaşıyor.
//        customer.setCustomerId(UUID.randomUUID());
//        customer.setCustomerName(customerDto.getCustomerName());
//        customer.setTotalDebit(customerDto.getTotalDebit()); Bu kısımlar artık toEntity ADI VERİLEN Maping kısmında yapılıyor.

        customerRepository.save(customer);
        return customerDto.getCustomerId();
    }

    @Override
    public String getCustomer(CustomerDto customerDto) {


        Optional<Customer> optional = customerRepository.findById(UUID.fromString(customerDto.getCustomerId()));

        if(optional.isPresent()) { // to DTO işlemi aslında, Mapping, aşağıdaki toEntity yapısı gibi ayrı yapılabilir.

            AddressDto addressDto = addressClient.getAddress(customerDto.getCustomerId());
            customerDto.setAddressDto(addressDto);


            Customer customer = optional.get();
            customerDto.setCustomerId(customerDto.getCustomerId());
            customerDto.setCustomerName(optional.get().getCustomerName());
            customerDto.setTotalDebit(customer.getTotalDebit());
            return customerDto.getCustomerId();
        }
        else{
            throw new IllegalArgumentException ("alıcı bulunamadı" + customerDto.getCustomerId());
        }



    }

    // Mapping
    private Customer toEntity(CustomerDto customerDto){
        Customer customer = new Customer();
        // Entity deki DB değerlerimizi, DTO daki "gözükme" değerlerimizle set - get match lemesi yapıyoruz.
        // Bu sayede DB yi hiç görmeden repository miz ulaşıyor.
        customer.setCustomerName(customerDto.getCustomerName());
        customer.setTotalDebit(customerDto.getTotalDebit());
        return customer;

    }
}
