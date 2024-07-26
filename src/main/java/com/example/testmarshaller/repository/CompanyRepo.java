package com.example.testmarshaller.repository;

import com.example.testmarshaller.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<CompanyEntity, Integer> {

}
