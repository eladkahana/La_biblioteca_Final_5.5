package com.repositories;

import com.entities.LastNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LastNameRepository extends JpaRepository<LastNameEntity, Integer>  {

}