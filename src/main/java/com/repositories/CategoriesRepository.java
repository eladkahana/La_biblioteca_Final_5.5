package com.repositories;

import com.entities.Categories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoriesRepository extends JpaRepository<Categories, Integer>, JpaSpecificationExecutor<Categories> {

}