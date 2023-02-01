package com.repositories;

import com.entities.ShelfmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShelfmarkRepository extends JpaRepository<ShelfmarkEntity, Integer>  {

}