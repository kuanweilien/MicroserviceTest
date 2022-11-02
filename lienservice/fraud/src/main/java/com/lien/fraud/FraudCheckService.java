package com.lien.fraud;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRespository fraudCheckHistoryRespository;
    
    public Boolean isFraudulentCustomer(Integer customerId){
        fraudCheckHistoryRespository.save(
            FraudCheckHistory.builder()
            .customerId(customerId)
            .isFraudster(false)
            .createdAt(LocalDateTime.now())
            .build()
        ); 
        return false;

    }
}
