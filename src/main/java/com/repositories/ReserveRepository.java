package com.repositories;

import com.entities.ReserveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ReserveRepository extends JpaRepository<ReserveEntity, Integer>  {

}