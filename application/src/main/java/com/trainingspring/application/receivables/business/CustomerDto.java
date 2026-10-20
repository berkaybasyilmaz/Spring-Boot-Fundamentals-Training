package com.trainingspring.application.receivables.business;

import com.trainingspring.application.receivables.client.AddressDto;

// iş mantığı, Veri tabanıyla alakasız
public class CustomerDto {

    private String customerId;
    private String customerName;
    private double totalDebit;
    private AddressDto addressDto;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }

    public AddressDto getAddressDto() {
            return addressDto;
    }
}
