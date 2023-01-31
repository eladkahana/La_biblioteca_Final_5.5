package com.repositories;

import com.entities.FirstName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FirstNameRepository extends JpaRepository<FirstName, Integer>, JpaSpecificationExecutor<FirstName> {

}