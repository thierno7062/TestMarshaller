package com.example.testmarshaller.repository;


import com.example.testmarshaller.entity.CollateralEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CollateralRepo extends JpaRepository<CollateralEntity, Integer> {

    List<CollateralEntity> findByContractCode = null;
//    List<Collateral> findAllByContractCode(long code);
}
