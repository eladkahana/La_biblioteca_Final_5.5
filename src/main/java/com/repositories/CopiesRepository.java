package com.repositories;

import com.entities.Copies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CopiesRepository extends JpaRepository<Copies, Integer>, JpaSpecificationExecutor<Copies> {

}