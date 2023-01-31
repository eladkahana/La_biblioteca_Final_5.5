package com.repositories;

import com.entities.LastName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LastNameRepository extends JpaRepository<LastName, Integer>, JpaSpecificationExecutor<LastName> {

}