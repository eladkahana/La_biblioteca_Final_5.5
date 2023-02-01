package com.repositories;

import com.entities.CopiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CopiesRepository extends JpaRepository<CopiesEntity, Integer>  {

}