package com.example.testmarshaller.repository;

import com.example.testmarshaller.entity.IndividuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndividuelRepo extends JpaRepository<IndividuelEntity, Integer> {
}
