package com.lien.fraud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRespository extends JpaRepository<FraudCheckHistory,Integer> {
    
}
