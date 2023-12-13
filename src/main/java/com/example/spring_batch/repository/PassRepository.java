package com.example.spring_batch.repository;

import com.example.spring_batch.entity.PassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassRepository extends JpaRepository<PassEntity, Integer> {
}
