package com.repositories;

import com.entities.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GenderRepository extends JpaRepository<Gender, Integer>, JpaSpecificationExecutor<Gender> {

}