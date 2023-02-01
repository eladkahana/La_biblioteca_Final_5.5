package com.repositories;

import com.entities.ResponesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResponesRepository extends JpaRepository<ResponesEntity, Integer> {
}