package com.example.testmarshaller.repository;


import com.example.testmarshaller.entity.ContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
//import java.util.Optional;

public interface ContractRepo extends JpaRepository<ContractEntity, Integer> {
    // select * from product where name = param;

    List<ContractEntity> findAllByContractCode(long code);

   /*  @Query(value = "SELECT s FROM Contract s WHERE s.contractCode=:code")
    public ContractEntity fetchUsingCode(@Param("code") Long code); */
}
