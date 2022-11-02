package com.lien.customer;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate ;

    public void registerCustomer(CustomerRegistrationRquest rquest){
        Customer customer = Customer.builder()
            .firstName(rquest.firstName())
            .lastName(rquest.lastName())
            .email(rquest.email())
            .build();
        
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud/{customerId}", 
                FraudCheckResponse.class, 
                customer.getId());
        if(fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }
    }
}
