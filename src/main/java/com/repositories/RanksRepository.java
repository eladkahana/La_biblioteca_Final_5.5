package com.repositories;

import com.entities.RanksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RanksRepository extends JpaRepository<RanksEntity, Integer>  {

}