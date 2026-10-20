package com.trainingspring.application.receivables.business;

import com.trainingspring.application.receivables.data.Customer;

public interface CustomerService {

    // Servisin bağlantısı Entity ile değil, DTO ile olmalı. Çünkü servis iş mantığıdır, veri tabanı ile alakası yoktur.
        String createCustomer(CustomerDto customerDto);

        String getCustomer(CustomerDto customerDto);

}
