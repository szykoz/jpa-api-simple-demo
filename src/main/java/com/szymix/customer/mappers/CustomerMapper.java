package com.szymix.customer.mappers;

import com.szymix.customer.dtos.CustomerRegistrationRequest;
import com.szymix.customer.models.Customer;

public class CustomerMapper {
    public static void mapRegistrationRequestToCustomer(CustomerRegistrationRequest customerRegistrationRequest,
            Customer customer) {
        customer.setName(customerRegistrationRequest.name());
        customer.setAge(customerRegistrationRequest.age());
        customer.setEmail(customerRegistrationRequest.email());
    }
}
