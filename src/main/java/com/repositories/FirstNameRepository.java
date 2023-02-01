package com.repositories;

import com.entities.FirstNameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FirstNameRepository extends JpaRepository<FirstNameEntity, Integer>  {

}