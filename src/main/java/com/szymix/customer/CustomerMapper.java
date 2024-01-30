package com.szymix.customer;

public class CustomerMapper {
    public static void mapRegistrationRequestToCustomer(CustomerRegistrationRequest customerRegistrationRequest, Customer customer) {
        customer.setName(customerRegistrationRequest.name());
        customer.setAge(customerRegistrationRequest.age());
        customer.setEmail(customerRegistrationRequest.email());
    }

    public static void mapUpdateRequestToCustomer(CustomerUpdateRequest customerRegistrationRequest, Customer customer) {
        customer.setName(customerRegistrationRequest.name());
        customer.setAge(customerRegistrationRequest.age());
        customer.setEmail(customerRegistrationRequest.email());
    }
}
