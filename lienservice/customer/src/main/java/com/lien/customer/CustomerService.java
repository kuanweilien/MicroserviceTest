package com.lien.customer;

import org.springframework.stereotype.Service;


@Service
public record CustomerService(CustomerRepository customerRepository) {

    public void registerCustomer(CustomerRegistrationRquest rquest){
        Customer customer = Customer.builder()
            .firstName(rquest.firstName())
            .lastName(rquest.lastName())
            .email(rquest.email())
            .build();


        customerRepository.save(customer);
    }
}
