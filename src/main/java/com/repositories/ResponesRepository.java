package com.repositories;

import com.entities.Respones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ResponesRepository extends JpaRepository<Respones, Integer>, JpaSpecificationExecutor<Respones> {

}