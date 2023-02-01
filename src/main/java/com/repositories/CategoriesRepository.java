package com.repositories;

import com.entities.CategoriesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoriesRepository extends JpaRepository<CategoriesEntity, Integer> {

}